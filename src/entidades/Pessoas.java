/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoDeTransporte;
/**
 *
 * @author fvict
 */
public class Pessoas extends Transporte{
    private int quantidadePessoa;
    private final TipoDeTransporte tipoDeTransporte = TipoDeTransporte.PESSOAS;

    public Pessoas(int quantidade, int identificador, PortoEspacial origem,
            PortoEspacial destino) {
        super(identificador, origem, destino);
        this.quantidadePessoa = quantidade;
    }    


//    this.calcularDistancia()  metodo declarado na class Transporte que calcula a distancia
    @Override
    public double calcularCusto() {
           return custoTransporte()*custoDistancia();
    }
    @Override
    public double calcularDistancia() {
        double distancia = Math.sqrt(Math.pow(getDestino().getCoordenadas().getX() - getOrigem().getCoordenadas().getX(), 2)
                + Math.pow(getDestino().getCoordenadas().getY() - getOrigem().getCoordenadas().getY(), 2) + 
                Math.pow(getDestino().getCoordenadas().getZ()- getOrigem().getCoordenadas().getZ(), 2));
        
        return distancia;
    }        
    @Override
    public double fatorDistancia(double distancia) {
          
        return distancia < 0.5 ? 1.000000 * distancia : distancia * 100;
    }        

    /**
     *
     * @return
     */
    @Override
    public double custoDistancia() {
       return calcularDistancia()*fatorDistancia(calcularDistancia());
    }        
    private double  custoTransporte()
    {
        return getQuantidade()*100;
    }
    
    public int getQuantidade() {
        return quantidadePessoa;
    }
    public void setQuantidade(int quantidade) {
        this.quantidadePessoa = quantidade;
    }
    public TipoDeTransporte getTipoDeTransporte() {
        return tipoDeTransporte;
    }    
    @Override
    public String toString() {        
        return 
                        
                "Idenficador: " + this.getIdentificador()+"\n"+      
                "Tipo: " + getTipoDeTransporte().toString() +"\n"+      
                "Quantidade: " + getQuantidade()+"\n"+
                "Porto de origem: "+this.getOrigem().getNome() + "\n" +
                "Porto de destino: "+this.getDestino().getNome() + "\n" +                
                "Estado: " + this.getEstado()+ "\n" +
//                "Nave: " + this.getNaveEspacial().getNome() +"\n"+
                "Distancia: " + this.calcularDistancia();
                
//                ;
//        
    }
    
}
