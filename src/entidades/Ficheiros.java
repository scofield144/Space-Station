package entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package entidades;
/**
 *
 * @author fvict
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ficheiros implements IFicherio {
    private static final String PORTO_FILE_PATH = "portoFile.txt";
    private static final String TRANSPORTE_FILE_PATH = "transporteFile.txt";
    private static final String NAVE_FILE_PATH = "naveFile.txt";

    @Override
    public boolean carregar(List<PortoEspacial> portoLista, List<Transporte> transportesLista,
                            List<NaveEspacial> naveEspacialsLista) {
        try {            
            if(checarFicheiro(PORTO_FILE_PATH)){                
                criarFicheiro(PORTO_FILE_PATH);
                criarFicheiro(TRANSPORTE_FILE_PATH);
                criarFicheiro(NAVE_FILE_PATH);                
            }else{                
                portoLista.addAll(carregarLista(PORTO_FILE_PATH, new PortoEspacialCreator()));
                transportesLista.addAll(carregarLista(TRANSPORTE_FILE_PATH, new TransporteCreator()));
                naveEspacialsLista.addAll(carregarLista(NAVE_FILE_PATH, new NaveEspacialCreator()));
            }
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
            return false;
        }
    }
    
    private boolean checarFicheiro(String caminho) throws IOException
    {
        File file = new File(caminho);                    
        if(!file.exists()){
            return true;
        }
        return false;
    }
    private void criarFicheiro(String caminho) throws IOException
    {
        File file = new File(caminho);
        file.createNewFile();        
    }
    @Override
    public boolean salvar(List<PortoEspacial> portoLista, List<Transporte> transportesLista,
                          List<NaveEspacial> naveEspacialsLista){
        try {
            salvarLista(portoLista, PORTO_FILE_PATH);
            salvarLista(transportesLista, TRANSPORTE_FILE_PATH);
            salvarLista(naveEspacialsLista, NAVE_FILE_PATH);
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
            return false;
        }
    }
    private <T> List<T> carregarLista(String filePath, ListObjectCreator<T> objectCreator)
            throws IOException {
        File file = new File(filePath);
        List<T> lista = new ArrayList<>();
        if (file.exists()) {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                if (line != null && !line.isEmpty()) {
                    T object = objectCreator.create(line);
                    if (object != null) {
                        lista.add(object);
                    }
                }
            }
        }
        return lista;
    }
    private <T> void salvarLista(List<T> lista, String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        for (T object : lista) {
            lines.add(object.toString());
        }
        Files.write(Paths.get(filePath), lines);
    }

    private interface ListObjectCreator<T> {
        T create(String line);
    }

    private class PortoEspacialCreator implements ListObjectCreator<PortoEspacial> {
        @Override
        public PortoEspacial create(String line) {
            
            return null;
        }
    }

    private class TransporteCreator implements ListObjectCreator<Transporte> {
        @Override
        public Transporte create(String line) {
            
            return null;
        }
    }

    private class NaveEspacialCreator implements ListObjectCreator<NaveEspacial> {
        @Override
        public NaveEspacial create(String line) {
            
            return null;
        }
    }
}
