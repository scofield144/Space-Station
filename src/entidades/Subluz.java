/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.Combustivel;
//import enums.TipoDeTransporte;

/**
 *
 * @author fvict
 */
public class Subluz extends NaveEspacial{
    private double velocidadeMaximaDeImpulso;
    private Combustivel combustivel;
    private PortoEspacial porto;

    public Subluz() {
        super();
    }
    

    public Subluz(double velocidadeMaximaDeImpulso, Combustivel combustivel,
            String nome,PortoEspacial portoEspacial) {
        super(nome);
        this.velocidadeMaximaDeImpulso = velocidadeMaximaDeImpulso;
        this.combustivel = combustivel;
        this.porto = portoEspacial;
    }
    

    public double getVelocidadeMaximaDeImpulso() {
        return velocidadeMaximaDeImpulso;
    }

    public void setVelocidadeMaximaDeImpulso(double velocidadeMaximaDeImpulso) {
        this.velocidadeMaximaDeImpulso = velocidadeMaximaDeImpulso;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    public PortoEspacial getPorto() {
        return porto;
    }

    public void setPorto(PortoEspacial porto) {
        this.porto = porto;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() +"\n"+ 
               "Porto: " + getPorto().getNome() +"\n"+ 
               "Tipo de Nave: SUBLUZ " +"\n"+ 
                "Velocidade Maxima: "+getVelocidadeMaximaDeImpulso()+"\n"+ 
               "Tipo de combustivel: "+getCombustivel().toString();
        } 
    
}
