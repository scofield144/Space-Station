/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/*
 * @author fvict
*/

public class PortoEspacial {
    private int numero;
    private String nome;
    private Coordenadas coordenadas;

    public PortoEspacial() {
    }
   
    public PortoEspacial(int numero, String nome, Coordenadas coordenadas) {
        this.numero = numero;
        this.nome = nome;
        this.coordenadas = coordenadas;        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return this.getNumero() +"\n"+                 
                this.getNome() +"\n"+ 
                this.coordenadas.toString();
    }
    
    
    
    
    
    
}
