/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
//import com.sun.jndi.url.rmi.rmiURLContext;
import Database.Connector;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Andrey Orozco
 */
public class VentaHandler {
    Connector conexion=new Connector("gasolinera");;

    public VentaHandler() {
        conexion.conectar();
    }

    
    public ArrayList<Venta> getAllVentas(){
        Venta venta = null;
        ArrayList<Venta> Ventas = new ArrayList<>();
        
        try(Connection connection=conexion.conectar()){
            String query = "SELECT * FROM `ventas`";        
            Statement stmt = connection.createStatement();                        
            ResultSet result = stmt.executeQuery(query);
            
            while(result.next()){
                venta = new Venta(result.getInt("id"),result.getString("tipo_combustible"), result.getFloat("galones"), result.getFloat("precio"),result.getString("fecha"));
                Ventas.add(venta);   
            }
            stmt.close();
            result.close();
            return Ventas;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }                        
    }
    
        public ArrayList<Venta> getVentas(String combustible){
        Venta venta ;
        ArrayList<Venta> Ventas = new ArrayList<>();
        try(Connection connection=conexion.conectar()){
            String query = "SELECT * FROM `ventas` WHERE tipo_combustible="+combustible;        
            Statement stmt = connection.createStatement();                        
            ResultSet result = stmt.executeQuery(query);
            
            while(result.next()){
                venta = new Venta(result.getInt("id"),result.getString("tipo_combustible"), result.getFloat("galones"), result.getFloat("precio"),result.getString("fecha"));
                Ventas.add(venta);   
            }
            stmt.close();
            result.close();
            return Ventas;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }                        
    }
    
    public void Insert(Venta venta){
        try(Connection connection=conexion.conectar()){
            String query = "INSERT INTO `ventas` (tipo_combustible,galones,precio,fecha) VALUES('"+venta.getNombre()+
                    "',"+venta.getCantidad()+","+venta.getPrecioTotal()+",'"+venta.getFecha()+"')";        
            PreparedStatement stmt = connection.prepareStatement(query);     
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}