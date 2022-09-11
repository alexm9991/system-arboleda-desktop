package conexion;

public interface Conexion {

    String DRIVER = "com.mysql.jdbc.Driver";
    String DATA_BASE = "cabins";   
    String CONNECTION_URL = "jdbc:mysql://localhost:3306/"+DATA_BASE;
    String USERNAME = "root";
    String PASSWORD = "";   
}
