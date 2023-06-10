/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Andrey Orozco
 */
import Model.VentaHandler;
import Model.Venta;
import java.util.ArrayList;

public class ControllerTable {

     public void generarReporte(String tipo){
    SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss");
    Calendar cal=Calendar.getInstance();
    ArrayList<Venta> lista = new ArrayList<>();
    VentaHandler bd=new VentaHandler();
    if(tipo=="General"){
    lista=bd.getAllVentas();
    }else{
    lista=bd.getVentas(tipo);
    }
        try {
            BufferedWriter outStream= new BufferedWriter(new FileWriter("Reporte-"+tipo +"-"+ sdf.format(cal.getTime()) +" .csv",true));
            for(Venta v:lista){
                outStream.write("Id Venta"+v.getId()+", Tipo de combustible:"+v.getNombre()+",Cantidad: "+v.getCantidad()+",Precio:$"+v.getPrecioTotal()+",Fecha:"+v.getFecha()+"\n");
            }
            outStream.close();
        }catch (IOException ex){
            System.out.println("ERROR");
        }
}
     public ArrayList<Venta> llenar(){
        ArrayList<Venta> lista = new ArrayList<>();
        VentaHandler bd=new VentaHandler();
        lista=bd.getAllVentas();
        return lista;
    }
}
