/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import enums.Estado;
import java.util.List;

/**
 *  
 * @author fvict
 */

public class Gerenciar implements IGerenciar {
    //Registra um novo porto na lista se ele ainda não existir
    @Override
    public boolean registarPortos(List<PortoEspacial> listPorto,
            PortoEspacial novoPorto) {

        boolean existe = jaExiste(listPorto,novoPorto);

        if (!existe) {
            listPorto.add(novoPorto);
            return true;
        }
        return false;
    }

//Verifica se um porto já existe na lista com base em suas coordenadas.
    private boolean jaExiste(List<PortoEspacial> listPorto,PortoEspacial novoPorto) {
        for (PortoEspacial portoEspacial : listPorto) {

            if ( portoEspacial.getCoordenadas().getX() == novoPorto.getCoordenadas().getX() &&
                    portoEspacial.getCoordenadas().getY() == novoPorto.getCoordenadas().getY() &&
                    portoEspacial.getCoordenadas().getZ() == novoPorto.getCoordenadas().getZ() ||
                    portoEspacial.getNome().equals(
                            novoPorto.getNome())
                     ) {

                return true;
            }
        }
        return false;
    }
///**
// * Registra uma nova nave espacial na lista de naves espaciais, verificando o tipo de nave e realizando as devidas ações.
// *
// * @param listNave A lista de naves espaciais onde a nova nave será registrada.
// * @param naveEspacial A nova nave espacial a ser registrada.
// * @return True se o registro for bem-sucedido, False caso contrário.
// */
    @Override
    public <T> boolean registarNaves(List<NaveEspacial> listNave,T naveEspacial) {

            int tipo = eIgual(naveEspacial);
            if (tipo == 1) {
                Subluz sublEspacial = (Subluz) naveEspacial;             


                if (listNave.isEmpty()) {
                    listNave.add(sublEspacial);
                    return true;
                }else{

                    for (NaveEspacial naveEspacial1 : listNave) {
                            
                            if (!naveEspacial1.getNome().equals(sublEspacial.getNome())) {
                            
                                listNave.add(sublEspacial);
                                return true;
                            }
                        }
                }                
            } else if (tipo == 2) {
                FTL ftlEspacial = (FTL) naveEspacial;
                if (listNave.isEmpty()) {
                    listNave.add(ftlEspacial);
                    return true;
                }else{                    
                    for (NaveEspacial naveEspacial1 : listNave) {
                        
                        if (!naveEspacial1.getNome().equals(ftlEspacial.getNome())) {
                        
                                listNave.add(ftlEspacial);
                                return true;
                            }
                        }
                }
                
            }
//        }        
        return false;
    }
    private <T> boolean checarNave(List<NaveEspacial> listNave,T naveEspacial)
    {        
        
//        PortoEspacial porto = (PortoEspacial)naveEspacial;
//        for (NaveEspacial naveEspacial1 : listNave) {
//            
//            if (naveEspacial1.getNome().equals(porto.getNome())) {
//                return false;
//            }            
//        }
        return true;
        
    }
///**
// * Registra um novo transporte na lista de transportes, verificando o tipo de transporte e realizando as devidas ações.
// *
// * @param transportesLista A lista de transportes onde o novo transporte será registrado.
// * @param novoTransporte O novo transporte a ser registrado.
// * @return True se o registro for bem-sucedido, False caso contrário.
// */
@Override    
public <T> boolean registarTransporte(List<T> transportesLista, T novoTransporte) {
    int tipo = eIgual(novoTransporte);
    String print;
    if (tipo == 3) {
        Pessoas pessoas = (Pessoas) novoTransporte;
        if (!existeIdentidificador(transportesLista, novoTransporte)) {
            transportesLista.add((T) pessoas);                
            print = pessoas.toString();
            System.out.println(print);
            return true;
        }
    } else if (tipo == 4) {
        Material material = (Material) novoTransporte;
        transportesLista.add((T) material);   
        print = material.toString();            
        System.out.println(print);
        return true;
    }
    return false;
}
///**
// * Verifica se já existe um transporte com o mesmo identificador na lista de transportes.
// *
// * @param listTransporte A lista de transportes a ser verificada.
// * @param transporte O novo transporte a ser verificado.
// * @return True se já existir um transporte com o mesmo identificador, False caso contrário.
// */
    private <T> boolean existeIdentidificador(List<T> listTransporte,T transporte) {

        for (T transporte1: listTransporte) {
            if (transporte instanceof Pessoas && transporte1 instanceof Pessoas) {
                
                if (((Transporte) transporte).getIdentificador()
                        == ((Transporte) transporte1).getIdentificador()) {
                    
                    return true;
                }
            } else if (transporte instanceof Material) {

                if (((Transporte) transporte).getIdentificador()
                        != ((Transporte) transporte1).getIdentificador()) {
                } else {
                    
                    return true;
                }
            }
        }
        return false;
    }


//    Simula a viagem das naves espaciais, atualizando o estado dos transportes quando chegam ao destino.
    public static void viajar(List<Transporte> listTransporte,List<NaveEspacial> listNave) {

        if(listTransporte.isEmpty() || listNave.isEmpty()){
            return;
        }               
        
        for (Transporte transporte : listTransporte) {
            if (transporte.getEstado() == Estado.A_TRANSPORTAR ) {
                
                  transporte.setEstado(Estado.FINALIZADO);                  
                
                for (NaveEspacial naveEspacial : listNave) {
                    if(naveEspacial.getTransporte().equals(transporte)){

                         chegar(listNave,listNave.indexOf(naveEspacial));
                         
                         return;
                    }
                        
                }
                
            }
          }       
        }
//Altera o estado de um transporte com base no código de estado fornecido.

    @Override
    public  Transporte alterarEstado(Transporte transporte, int estado) {

        switch (estado) {
            case 1:
                    if(transporte.mudarEstado(Estado.CANCELADO)){
                        return transporte;
                    }
            case 2:
                if(transporte.mudarEstado(Estado.FINALIZADO)){
                        return transporte;
                    }
            case 3:
                if(transporte.mudarEstado(Estado.PENDENTE)){
                        return transporte;
                    }
            case 4:
                if(transporte.mudarEstado(Estado.A_TRANSPORTAR)){
                        return transporte;
                    }
        }
        return null;
    }

    @Override
    public boolean carregarDados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//    Designa um transporte disponível para uma nave espacial, marcando-o como 'PENDENTE'."
    @Override
    public boolean designarTransporte(List<NaveEspacial> listNave,
            List<Transporte> listTransport,int id, Date date) {                       
                Transporte transporte = listTransport.get(id);
                boolean estado = transporte.getEstado().equals(Estado.PENDENTE);                
                if (estado) {                    
                    for (NaveEspacial naveEspacial : listNave) {
                
                        estado = naveEspacial.checarEstado();
                        if (estado) {                            
                            int checarLimite = checarLimite(naveEspacial, transporte);                                    
                                if (checarLimite == 1) {
                                    naveEspacial.addTransporte(transporte, date);
                                    alterarEstado(listTransport.get(id), 4); 
                                    return true;
                                }              
                            }
                   }               
        }
        return false;
    }
//    Verifica se uma nave espacial tem capacidade para transportar o tipo específico de carga."
   private int checarLimite(NaveEspacial nave, Transporte transporte) {
    if (nave instanceof FTL) {
        FTL ftl = (FTL)nave;        
        if (transporte instanceof Pessoas) {
            
            if(ftl.getLimiteDeTransporte() >= ((Pessoas) transporte).getQuantidade()){                      
                return 1;
            }
        } else if (transporte instanceof Material) {
            
            if(((Material) transporte).getQuantidadeCarga() < ftl.getLimiteDeTransporte()){   
                
                return 1;                           
            }
        } 
//        caso ela seja do tipo FTL mas a quantidade nao satisfazer, retorna -1 representando erro
        return -1;    
    }
//    caso ela nao seja FTL entao sera SUBLUZ e ela nao precisa de saber o limite

    return 1;
}
//   Verifica se uma nave espacial está disponível para transporte.
   private int checarNaveDisponivel(List<NaveEspacial> listNave, int index) {
    for (; index <= listNave.size(); index++) {
        NaveEspacial nav = listNave.get(index);
        if (nav.checarEstado()) {
            
            return index;
        }
    }
    return -1;
}

//Exibe informações sobre todos os transportes, incluindo a nave espacial associada.
    public static void mostrarTodosTransportes(List<Transporte> listTransportes, List<NaveEspacial> naveEspacials)
    {
        for (Transporte listTransporte : listTransportes) {
            if(listTransporte.getNaveEspacial()!= null){
                System.out.println(listTransporte.toString());
                System.out.println("Nave: "+listTransporte.getNaveEspacial().getNome());
                System.out.println("****************************************************");
            }else{
                System.out.println(listTransporte.toString());
                System.out.println("****************************************************");
            }
        }
        viajar(listTransportes,naveEspacials);
    }
    
    
//Simula a chegada de uma nave espacial ao destino, atualizando seu estado
    private static void chegar(List<NaveEspacial> listNave,int index)
    {
        System.out.println("Chegar: "+ listNave.get(index).getNome());
        listNave.get(index).getTransporte().chegar();
        listNave.get(index).setTransporte(null);

        
    }
//    Retorna um código numérico representando o tipo de objeto
    private <T> int eIgual(T newObject) {

        if (newObject instanceof Subluz) {
            
            return 1;
        } else if (newObject instanceof FTL) {
            
            return 2;
        } else {
            // comparando agora objectos do transportes e retornando numero acima de 2              
            if (newObject instanceof Pessoas) {
                return 3;
            } else if (newObject instanceof Material) {
                return 4;
            }
        }
        return 0;
    }
    @Override
    public <T> void apagarByPosition(List<T> list, int id) {
        list.remove(id);

    }
    
    @Override
    public boolean cancelar(List<NaveEspacial> listNave, List<Transporte> listTransport,int index)
    {
        Transporte alterar = alterarEstado(listTransport.get(index), 1); 
        return alterar != null;
    }
    
    
    

}
