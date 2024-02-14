/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
/**
 *
 * @author fvict
 */
public class FTL extends NaveEspacial {
    private double velocidadeMaximaTrek;    
    private int limiteDeTransporte;
    private PortoEspacial porto;

    public FTL(double velocidadeMaximaTrek, int limiteDeTransporte, String nome, PortoEspacial porto) {
        super(nome);
        this.velocidadeMaximaTrek = velocidadeMaximaTrek;
        this.limiteDeTransporte = limiteDeTransporte;
        this.porto = porto;
    }
    
    
    public double getVelocidadeMaximaTrek() {
        return velocidadeMaximaTrek;
    }
    public void setVelocidadeMaximaTrek(double velocidadeMaximaTrek) {
        this.velocidadeMaximaTrek = velocidadeMaximaTrek;
    }
    public int getLimiteDeTransporte() {
        return limiteDeTransporte;
    }
    public void setLimiteDeTransporte(int limiteDeTransporte) {
        this.limiteDeTransporte = limiteDeTransporte;
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
        return  
               "Nome: " + getNome() +"\n"+ 
               "Porto: " + getPorto().getNome() +"\n"+ 
               "Tipo de Nave: FTL " +"\n"+ 
               "Velocidade Maxima: "+getVelocidadeMaximaTrek()+"\n"+          
               "Limite  de Transporte: "+ getLimiteDeTransporte();
    }
    
}
