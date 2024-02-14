/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.Estado;
//
///**
// * Classe abstrata que representa um transporte espacial.
// * Classes filhas devem implementar métodos abstratos específicos.
// * 
// * @author fvict
// */
public abstract class Transporte {
    private int identificador;
    private PortoEspacial origem;
    private PortoEspacial destino;
    private NaveEspacial naveEspacial;
    private Estado estado ;
//  /**
//     * Construtor da classe Transporte.
//     * 
//     * @param identificador Identificador único do transporte.
//     * @param origem Porto de origem do transporte.
//     * @param destino Porto de destino do transporte.
//     */
    public Transporte(int identificador, PortoEspacial origem,
            PortoEspacial destino) {
        this.identificador = identificador;
        this.origem = origem;
        this.destino = destino;
        estado = Estado.PENDENTE;
    }
//    
//    /**
//     * Método abstrato para calcular a distância do transporte.
//     * Deve ser implementado nas classes filhas.
//     * 
//     * @return Distância do transporte.
//     */
    public abstract double calcularDistancia();    
//
//    /**
//     * Método abstrato para calcular o fator de distância.
//     * Deve ser implementado nas classes filhas.
//     * 
//     * @param distancia Distância do transporte.
//     * @return Fator de distância calculado.
//     */
    public abstract double fatorDistancia(double distancia);
//
//    /**
//     * Método abstrato para calcular o custo baseado na distância.
//     * Deve ser implementado nas classes filhas.
//     * 
//     * @return Custo calculado.
//     */
    public abstract double custoDistancia();
//
//    /**
//     * Método para simular a chegada do transporte.
//     * Reduz a distância até zero e muda o estado para FINALIZADO.
//     * 
//     * @return Distância percorrida.
//     */
    
    
   public boolean mudarEstado(Estado estado)
    {
        if(checarEstado()){            
            this.setEstado(estado);
            return true;
        }
        return false;        
    }
//
//    /**
//     * Método privado para verificar se o estado atual é válido para mudança.
//     * 
//     * @return Verdadeiro se o estado atual é válido, falso caso contrário.
//     */
    private boolean checarEstado()
    {
        return (this.getEstado() != Estado.CANCELADO
                || this.getEstado() != Estado.FINALIZADO);
    }
//       /**
//     * Método abstrato para calcular o custo total do transporte.
//     * Deve ser implementado nas classes filhas.
//     * 
//     * @return Custo total do transporte.
//     */
    public abstract double calcularCusto();    
    
    public double chegar() {
        // Obtém a distância inicial usando o método calcularDistancia
        double distancia = calcularDistancia();
        
        // Loop enquanto a distância for maior que zero
        while (distancia > 0) {
            // Reduz a distância em uma unidade a cada iteração
            distancia--;
        }
        
        // Após o loop, a distância chegou a zero, então muda o estado para FINALIZADO
        this.mudarEstado(Estado.FINALIZADO);
        
        // Retorna a distância inicial antes da chegada (pode ser zero se inicialmente já era zero)
        return distancia;
    }
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public PortoEspacial getOrigem() {
        return origem;
    }
    public void setOrigem(PortoEspacial origem) {
        this.origem = origem;
    }
    public PortoEspacial getDestino() {
        return destino;
    }
    public void setDestino(PortoEspacial destino) {
        this.destino = destino;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public NaveEspacial getNaveEspacial() {
        return naveEspacial;
    }

    public void setNaveEspacial(NaveEspacial naveEspacial) {
        this.naveEspacial = naveEspacial;
    }
    
    @Override
    public String toString() {
        return 
                "Identificador: "+getIdentificador() + "\n" +
                "Estado: "+getEstado().toString()+ "\n" +
                "Distancia: "+calcularDistancia()
                ;                
    }
    
}
