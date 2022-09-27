
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexionMensaje implements Conexion{
    
     //conexion local
    public static Connection nuevaConexion() {
        try {
            Connection cn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion local" + e);
        }
        return (null);
    }
    
private static Connection con = null;

    static {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            if (con != null) {
                System.out.println("Conexion exitosa");
                ;
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Error en conexión : " + error);
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public static Connection getConnection() {
        return con;
    }
    
    public void cerrar() {
        try {
            con.close();
        } catch (SQLException error) {
            System.out.println("Error en cerrar");
        }

    }

    public boolean ejecutar(String sql) throws SQLException {
        boolean var;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (sentencia.executeUpdate(sql) == 0) {
                var = false;
            } else {
                var = true;
            }
        } catch (SQLException error) {
            System.out.println("Error en ejecución");
            var = false;
            throw error;
        }
        return var;
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException error) {
            System.out.println("Error en la consulta");
            resultado = null;
        }
        return resultado;
    }
}
