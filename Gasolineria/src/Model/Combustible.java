/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Andrey Orozco
 */
public class Combustible {
    private String nombre;
    private float precioG;

    public Combustible(String nombre, float precioG) {
        this.nombre = nombre;
        this.precioG = precioG;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioG() {
        return precioG;
    }
    
}
