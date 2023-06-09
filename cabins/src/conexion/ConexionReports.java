package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionReports implements Conexion {

    private static final String DB = "fincatur_cabins";
    private static final String USER = "fincatur_superadmin";
    private static final String PASSWORD = "04gU)6SN+-bJ";
    private static final String REPORTS_CONNECTION_URL = "jdbc:mysql://162.241.203.121/" + DB;

//    private static final String DB = "cabins";
//    private static final String USER = "root";
//    private static final String PASSWORD = "";
//    private static final String REPORTS_CONNECTION_URL = "jdbc:mysql://localhost:3306/" + DB;
    
    public static Connection getMySqlConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conectionURL = REPORTS_CONNECTION_URL;
            Connection conn = DriverManager.getConnection(conectionURL, USER, PASSWORD);
            return conn;
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
