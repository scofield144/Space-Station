/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author fvict
 */
public enum Combustivel {
    NUCLEAR,
    ION;  
    
    @Override    
    public String toString() {
        switch(this){
            case NUCLEAR:
                return "Nucler";
            case ION: 
                return "Ion";          
        }
        return "";
        
        
    }
}
