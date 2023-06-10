package controlador;

public class Mascota {

    //ATRIBUTES
    private int id;
    private String nombreMascota;
    private int edad;
    private String descripcion;
    private String analisisConsulta;
    private String nombreOwner;
    private String celular;
    private String email;

    //CONSTRUCTORS
    public Mascota(int id, String nombreMascota, int edad, String descripcion, String analisisConsulta, String nombreOwner, String celular, String email) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.edad = edad;
        this.descripcion = descripcion;
        this.analisisConsulta = analisisConsulta;
        this.nombreOwner = nombreOwner;
        this.celular = celular;
        this.email = email;
    }

    public Mascota() {
    }

    //GETTERS AND SETTERS


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombreMascota() {
        return nombreMascota;
    }
    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAnalisisConsulta() {
        return analisisConsulta;
    }
    public void setAnalisisConsulta(String analisisConsulta) {
        this.analisisConsulta = analisisConsulta;
    }
    public String getNombreOwner() {
        return nombreOwner;
    }
    public void setNombreOwner(String nombreOwner) {
        this.nombreOwner = nombreOwner;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "Mascota{" +
                "id: " + id +
                ", nombre: " + nombreMascota + '\'' +
                ", edad: " + edad + '\'' +
                ", descripcion: " + descripcion + '\'' +
                ", analisis: " + analisisConsulta + '\'' +
                ", nombreOwner:" + nombreOwner + '\'' +
                ", celular: " + celular + '\'' +
                ", email: " + email +
                "}";
    }
}
