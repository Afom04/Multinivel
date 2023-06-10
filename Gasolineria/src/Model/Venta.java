/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Andrey Orozco
 */
public class Venta {
    private int id;
    private String nombre;
    private float cantidad;
    private float precioTotal;
    private String fecha;
    //Combustible combustible;

    public Venta(int id,String nombre, float cantidad, float precioTotal,String fecha) {
        this.id=id;
        this.nombre=nombre;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.fecha=fecha;
    }

    public Venta(String nombre, float cantidad, float precioTotal, String fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }
    
    public float getPrecioTotal() {
        return precioTotal;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

  /*  public Combustible getCombustible() {
        return combustible;
    }*/
    
}
