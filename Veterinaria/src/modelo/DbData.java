package modelo;

public class DbData {

    private String dbName = "veterinaria";
    private String dbUserName = "root";
    private String dbPassword = "";


    private final String driver  = "com.mysql.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
//    private final String url = "jdbc:mysql://localhost3306/veterinaria";
    private String url = "jdbc:mysql://localhost:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";

    //GETTER (PORQUE NO MODIFICARE VALORES)
    public String getDriver() {
        return driver;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }

}
