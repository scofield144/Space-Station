/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author fvict
 */
public enum Estado {
    PENDENTE,
    A_TRANSPORTAR,
    CANCELADO,
    FINALIZADO;

    @Override
    public String toString() {
        switch (this) {
            case PENDENTE:
                return "Pendente";
            case A_TRANSPORTAR:
                return "A Transportar";
            case CANCELADO:
                return "Cancelado";
            case FINALIZADO:
                return "Finalizado";
        }
        return "";
    }
    
    
}
