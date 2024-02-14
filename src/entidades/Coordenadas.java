/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author fvict
 */
public class Coordenadas {
    private double x;
    private double y;
    private double z;

    public Coordenadas(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    } 
    
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return getX() +
                ","
                +
               getY() +
                ","+
               getZ();
    }
    
    
    
    
}
