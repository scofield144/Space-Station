/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
/**
 *
 * @author fvict
// */
//public class Historico {
//    private Date data;
//    private List<Transporte> transportList = new ArrayList<>();
//    
//    public Historico(Date data, Transporte transportList) {
//        this.data = data;
//        this.transportList.add(transportList);
//    }
//
//    public Date getData() {
//        return data;
//    }
//
//    public void setData(Date data) {
//        this.data = data;
//    }
//
//    public List<Transporte> getTransportList() {
//        return transportList;
//    }
//
//    public void setTransportList(List<Transporte> transportList) {
//        this.transportList = transportList;
//    }
//}

public class Historico {
    private Date data;
    private Transporte transporte;

    public Historico(Date data, Transporte transporte) {
        this.data = data;
        this.transporte = transporte;
    }
//
//    Designar transportes (a partir da fila de transportes pendentes; 
//    verificar se é possível designar alguma nave espacial disponível
//            e apta para cada transporte, e actualize o seu estado. 
//            Se não for possível designar alguma nave espacial,
//                    retornar para a fila de transportes pendentes.
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Transporte getTransporte() {
        return transporte;
    }
    
    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }        

    @Override
    public String toString() {
      return getData().toString()+"n/"+
             getTransporte().toString();
    }
    
    
   
}