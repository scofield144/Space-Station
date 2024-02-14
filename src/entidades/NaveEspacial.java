/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.Estado;
import enums.TipoDeTransporte;
import java.util.ArrayList;

/**
 * @author fvict
 */
// * Representa uma nave espacial que pode realizar transportes.
// * Mantém um histórico de transportes realizados.

public class NaveEspacial{

    private String nome;    
    private ArrayList<Historico> arrHistorico = new ArrayList<>();
    private Transporte transporte  = null;

    public NaveEspacial() {
    }
    
    public NaveEspacial(String nome,Date date,TipoDeTransporte tipoDeTransporte, 
            PortoEspacial portoEspacial) 
    {
        this.nome = nome;

        arrHistorico = null;
    }

    public NaveEspacial(String nome) {
        this.nome = nome;
    }
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

  
    private Historico fazerHistoria(Date date)
    {

                
            Historico historico = new Historico(date, this.transporte);
            return historico;        
        
    }
    
    
    public void addTransporte(Transporte transporte, Date date) {
    // Muda o estado do transporte para TRANSPORTAR
    transporte.mudarEstado(Estado.A_TRANSPORTAR);
    
    // Associa o transporte à nave espacial
    this.transporte = transporte;
    transporte.setNaveEspacial(this);
    
    // Adiciona um novo histórico do transporte realizado
    this.arrHistorico.add(fazerHistoria(date));
}
    public boolean checarEstado()
    {
        return this.transporte == null;
    }
   
    public void mostrarHistorico( )
    {
        if(arrHistorico.isEmpty()){
            System.out.println("Nao tem historico de transporte");
            return;
        }
        
        for(Historico historico: arrHistorico){

              System.out.println(historico.getData().toString());
              System.out.println(historico.getTransporte().toString());
              
        }
    }   
    @Override
    public String toString() {
        return 

                this.getNome() +"\n"+

                arrHistorico.size();

    }
    
    
    
    public boolean equals(Object obj) {
    
        if(this == obj){
            return true;
        }
               return !(obj == null || getClass() != this.getClass());
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }
    
    
    
    
    
}
