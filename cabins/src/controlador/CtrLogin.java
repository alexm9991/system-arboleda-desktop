package controlador;

import conexion.conexionMensaje;
import java.sql.*;
import javax.swing.JOptionPane;
import vista.VstMenu;

public class CtrLogin {
    conexionMensaje cc = new conexionMensaje();
    Connection con = conexionMensaje.getConnection();

     public int Validarusuario(String usuario, String password) {
        int resultado = 0;
        String SQL = "select email,password from users where email='" + usuario + "' and password='"
                + password + "' and state_record = 'ACTIVAR'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1) {
                    VstMenu menuPrincipal = new VstMenu();
                    menuPrincipal.setVisible(true);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
        return resultado;
    }
   
}
