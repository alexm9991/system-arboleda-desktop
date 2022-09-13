
package controlador;

import java.sql.*;
import javax.swing.*;
import vista.VstMenu;
import conexion.*;
import modelo.*;

public class CtrLogin {
    
    public void validarusuario(MdlUsuarios usuario) {
        
    CtrLogin controladorLogin = new CtrLogin();    
    conexionMensaje cc = new conexionMensaje();
    Connection con = conexionMensaje.getConnection();
    
    int resultado = 0;
    
////    String SQL = "select email,password from users where email='" + usuario + "' and password='"
////                + password + "' and state_record = 'ACTIVAR'";
    
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(SQL);
//            if (rs.next()) {
//                resultado = 1;
//                if (resultado == 1) {
//                    VstMenu menuPrincipal = new VstMenu();
//                    menuPrincipal.setVisible(true);
//                    this.dispose();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Error de Acceso: Usuario no registrado");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
//        }
//    }
    
}
