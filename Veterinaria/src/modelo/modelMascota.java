package modelo;

import controlador.Mascota;

import java.sql.*;
import java.util.LinkedList;

public class modelMascota extends DbData{

    public Mascota validarId(String id){
        Mascota mas = null;

        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

            String query = "SELECT * FROM `mascotas` WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                int masId = result.getInt(1);
                String masNombreMascota = result.getString(2);
                int masEdad = result.getInt(3);
                String masDescripcion = result.getString(4);
                String masAnalisis = result.getString(5);
                String masNombreOwner = result.getString(6);
                String masCelular = result.getString(7);
                String masEmail = result.getString(8);

                mas = new Mascota(masId, masNombreMascota, masEdad, masDescripcion, masAnalisis, masNombreOwner, masCelular, masEmail);

                return mas;
            }
            stmt.close();
            result.close();
        }catch(Exception e){
            System.out.println("Eror de SQL 1: " + e.getMessage());
            return null;
        }
        return mas;
    }

    public void mostrarDatos(int masId, String masNombreMascota, int masEdad, String masDescripcion, String masAnalisis, String masNombreOwner, String masCelular, String masEmail){
        System.out.println("Id: " + masId +
                "\nNombre: " + masNombreMascota +
                "\nEdad: " + masEdad +
                "\nDescripcion: " + masDescripcion +
                "\nAnalisis: " + masAnalisis +
                "\nNombreOwner:" + masNombreOwner +
                "\nCelular: " + masCelular +
                "\nEmail: " + masEmail);
        System.out.println("");
    }

    public Mascota consultaMascotaId(String id){
        Mascota mas = null;

        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

            String query = "SELECT * FROM `mascotas` WHERE id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                int masId = result.getInt(1);
                String masNombreMascota = result.getString(2);
                int masEdad = result.getInt(3);
                String masDescripcion = result.getString(4);
                String masAnalisis = result.getString(5);
                String masNombreOwner = result.getString(6);
                String masCelular = result.getString(7);
                String masEmail = result.getString(8);

                mostrarDatos(masId, masNombreMascota, masEdad, masDescripcion, masAnalisis, masNombreOwner, masCelular, masEmail);

                mas = new Mascota(masId, masNombreMascota, masEdad, masDescripcion, masAnalisis, masNombreOwner, masCelular, masEmail);
                return mas;
            }
            stmt.close();
            result.close();
        }catch(Exception e){
            System.out.println("Eror de SQL: " + e.getMessage());
            return null;
        }
        return mas;
    }

    public boolean crearMascota(int masId, String masNombreMascota, int masEdad, String masDescripcion, String masAnalisis, String masNombreOwner, String masCelular, String masEmail){

        try (Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

            String query = "INSERT INTO `mascotas` (id, nombre_mascota, edad_mascota, descripcion_mascota, analisis_consulta, nombre_owner, celular, email) "
                         + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, masId);
            stmt.setString(2, masNombreMascota);
            stmt.setInt(3, masEdad);
            stmt.setString(4, masDescripcion);
            stmt.setString(5, masAnalisis);
            stmt.setString(6, masNombreOwner);
            stmt.setString(7, masCelular);
            stmt.setString(8, masEmail);

            stmt.executeUpdate();
            stmt.close();

            return true;
        }catch (Exception e){
            System.out.printf("Error de SQL 2: " + e.getMessage());
            return false;
        }
    }

    public boolean editarMascota(int masId, String masNombreMascota, int masEdad, String masDescripcion, String masAnalisis, String masNombreOwner, String masCelular, String masEmail){

        try (Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

            String query = "UPDATE `mascotas` \n"
                         + "SET `nombre_mascota`=?, `edad_mascota`=?, `descripcion_mascota`=?, `analisis_consulta`=?, `nombre_owner`=?, `celular`=?, `email`=? WHERE id = ?";
            /*String query = "UPDATE `mascotas` "
                         + "SET nombre_mascota=" + masNombreMascota + ", edad_mascota=" + masEdad + ", descripcion_mascota=" + masDescripcion + ", analisis_consulta=" + masAnalisis + ", nombre_owner=" + masNombreOwner + ", celular=" + masCelular + ", email=" + masEmail +" WHERE id =" +masId;
            * */

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, masNombreMascota);
            stmt.setInt(2, masEdad);
            stmt.setString(3, masDescripcion);
            stmt.setString(4, masAnalisis);
            stmt.setString(5, masNombreOwner);
            stmt.setString(6, masCelular);
            stmt.setString(7, masEmail);
            stmt.setInt(8, masId);

            stmt.executeUpdate();
            stmt.close();

            return true;
        }catch (Exception e){
            System.out.println("Error de SQL 3: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarMascota(String id){

        Mascota mascota = consultaMascotaId(id);

        if(mascota != null){
            try (Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

                String query = "DELETE FROM `mascotas` WHERE id =?";

                PreparedStatement stmt = connection.prepareStatement(query);

                stmt.setString(1, id);

                stmt.executeUpdate();
                stmt.close();

                return true;
            }catch (Exception e){
                System.out.println("Error de SQL 4: " + e.getMessage());
                return false;
            }
        }else {
            return false;
        }
    }

    public LinkedList<Mascota> listaMascota(){

        LinkedList<Mascota> mascotaLista = new LinkedList<>();
        Mascota mascota = null;

        try(Connection connection = DriverManager.getConnection(getUrl(),getUser(),getPassword())){

            String query = "SELECT id, nombre_mascota, edad_mascota, descripcion_mascota, analisis_consulta, nombre_owner, celular, email FROM `mascotas`";

            //NO ES UNA CONSULTA PREPARADA
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int masId = result.getInt(1);
                String masNombreMascota = result.getString(2);
                int masEdad = result.getInt(3);
                String masDescripcion = result.getString(4);
                String masAnalisis = result.getString(5);
                String masNombreOwner = result.getString(6);
                String masCelular = result.getString(7);
                String masEmail = result.getString(8);

                mascota = new Mascota(masId, masNombreMascota, masEdad, masDescripcion, masAnalisis, masNombreOwner, masCelular, masEmail);
                mascotaLista.add(mascota);
            }
            stmt.close();
            result.close();
            return mascotaLista;
        }catch (Exception e){
            System.out.println("Error de SQL 5: " + e.getMessage());
            return null;
        }
    }

}
