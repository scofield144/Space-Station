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

// * Classe que representa o transporte de materiais entre portos espaciais.
 
public class Material extends Transporte{
    private String descricao;
    private double quantidadeCarga;
    private final TipoDeTransporte tipoDeTransporte = TipoDeTransporte.CARGA;

    public Material(String descricao, double quantidadeCarga, 
            int identificador, PortoEspacial origem, PortoEspacial destino) {
        super(identificador, origem, destino);
        this.descricao = descricao;
        this.quantidadeCarga = quantidadeCarga;
    }
//    /**
// * Calcula o custo total do transporte, multiplicando o custo da distância pelo custo adicional do transporte.
// *
// * @return O custo total do transporte.
// */
    @Override
    public double calcularCusto() {

           return custoDistancia()*custoTransporte();
    }
///**
// * Calcula a distância euclidiana tridimensional entre o porto de origem e o porto de destino.
// * Utiliza as coordenadas X, Y e Z dos portos para calcular a distância.
// *
// * @return A distância entre os portos de origem e destino.
// */
@Override
public double calcularDistancia() {
    double distancia = Math.sqrt(Math.pow(getDestino().getCoordenadas().getX() - getOrigem().getCoordenadas().getX(), 2)
            + Math.pow(getDestino().getCoordenadas().getY() - getOrigem().getCoordenadas().getY(), 2) + 
            Math.pow(getDestino().getCoordenadas().getZ() - getOrigem().getCoordenadas().getZ(), 2));
    
    return distancia;
}    
//
///**
// * Aplica um fator à distância, considerando a condição: se a distância for menor que 0.5,
// * o fator é 1.000000; caso contrário, o fator é a própria distância multiplicada por 100.
// *
// * @param distancia A distância a ser fatorada.
// * @return A distância fatorada.
// */
@Override
public double fatorDistancia(double distancia) {
    return distancia < 0.5 ? 1.000000 * distancia : distancia * 100;
}    
//
///**
// * Calcula o custo da distância considerando o fator de distância.
// *
// * @return O custo da distância, levando em conta o fator aplicado.
// */
@Override
public double custoDistancia() {
    return calcularDistancia() * fatorDistancia(calcularDistancia());
}
//
///**
// * Calcula o custo adicional do transporte com base na quantidade de carga.
// * Considera um valor fixo de 500 unidades por unidade de carga.
// *
// * @return O custo adicional do transporte devido à quantidade de carga.
// */
private double custoTransporte() {
    return getQuantidadeCarga() * 500;
}
    
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidadeCarga() {
        return quantidadeCarga;
    }

    public void setQuantidadeCarga(double quantidadeCarga) {
        this.quantidadeCarga = quantidadeCarga;
    }

    public String getTipoDeTransporte() {
        return tipoDeTransporte.toString();
    }    

    @Override
    public String toString() {
        return 
               "Descricao: "+getDescricao() +"\n"+ 
               "Quantidade: "+getQuantidadeCarga() +"\n"+
               "Calculo do custo: "+this.calcularCusto() +"\n"+ 
               "Porto de origem: "+this.getOrigem().getNome()+"\n"+ 
               "Porto de destino: "+this.getDestino().getNome()+"\n"+ 
               "Estado: " + this.getEstado()+ "\n" +
//                "Nave: " + this.getNaveEspacial().getNome() +"\n"+
               "Tipo de transporte: "+this.tipoDeTransporte.toString();                
    }


  }
