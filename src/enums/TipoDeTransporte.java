/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;
/**
 *
 * @author fvict
 */
public enum TipoDeTransporte {
    PESSOAS,
    CARGA;    
    @Override
    public String toString() {
        switch (this) {
            case PESSOAS:
                return "Pessoas";                
            case CARGA:
                return "Carga";
        }
    return "";
    }
}
