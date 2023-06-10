/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Andrey Orozco
 */
import Model.Combustible;
import Model.VentaHandler;
import Model.Venta;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
public class ControllerSell {
    Combustible combustible[];
    VentaHandler ventas;
    Factura factura;
    public ControllerSell(){
        combustible= new Combustible[3];
        combustible[0]=new Combustible("Gasolina", 9856);
        combustible[1]=new Combustible("Diesel", 8203);
        combustible[2]=new Combustible("GNV", 6723);
        ventas=new VentaHandler();
    }
    public Combustible getCombustible(int i){
        return combustible[i];
    }
    public void Insertar(String nombre, float cantidad, float precioTotal){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String fecha = sdf.format(new Date());
        Venta venta=new Venta(nombre,cantidad,precioTotal,fecha);
        ventas.Insert(venta);
        System.out.println("Insertado Correctamente");
        factura=new Factura();
        factura.generar(venta);

    }
}
