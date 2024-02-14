/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author fvict
 */
public class Date {
    private int dia;
    private int mes;
    private int ano;
    private final String arrMonth[] = {" ","janeiro","fevereiro","março",    "maio",    "abril",    "junho",    "julho","agosto","setembro","outubro",
    "novembro","dezembro"};

    public Date(int dia, int mes, int ano) {
        
        if (validadeDate(dia, mes, ano)) {            
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;        
        }        
    }
   
    /**
     *
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static boolean validadeDate(int dia, int mes, int ano )
    {
        if ((ano%4 == 0) && (ano % 100 !=0)) {
            if (mes > 0 && mes < 13 ) {
                if (dia > 0 && dia < 32 ) {
                return true;    
                }                   
            }
        }
        return false;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return getDia() + " de " + arrMonth[getMes()] + " de " + getAno(); 
    }
    
    
}
