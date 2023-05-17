
package controlador;
import conexion.conexionMensaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.*;

public class CtrLogin {
    conexionMensaje cc = new conexionMensaje();
    CtrEncrypt val = new CtrEncrypt();
    Connection con = conexionMensaje.getConnection();
    
//   public int ValidarPssword (String usuario, String password)  {
//       int indicativo = 0;
////         PreparedStatement ps =null;
////         ps=con.prepareStatement(SQL2);
////        ResultSet rs2 = ps.executeQuery("select password from users where email = '"+usuario+"'");
////        String pss = rs2.getString(1);
////        System.out.println(pss);
//        
//       
//       if(conf == true){
//            indicativo = indicativo+1;
//       }else{
//           System.out.print("Error en la obtencion del password");
//       }
//       return indicativo;
//   }
     
     public int Validarusuario(String usuario, String password)  {
              
         int resultado = 0;       
        String SQL = "select email,password,id from users where email='" + usuario + "' and state_record = 'ACTIVAR'";
        
             
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
//            Ejecución de la consulta
            if (rs.next()) {    
//                Se guarda el password encriptado en una variable
                   String resultado1 = rs.getNString(2);  
                   int id = rs.getInt(3);
//                   Obtengo el id del usuario para consultar el rol del mismo y hacer la validacion del rol                                   
                   String SQL2 = "select role_id from model_has_roles where model_id='"+id+"'";
//                   Ejecuta la consulta del rol
                   ResultSet rs2 = st.executeQuery(SQL2);
                   rs2.next();
                   int role = rs2.getInt(1);
//                   Validacion del password ingresado con el password encriptado
                 boolean conf = val.verifyPassword(password,resultado1);   
                
                 if (conf ==true) {
                     if(role==1){
                    VstMenu menuPrincipal = new VstMenu();
                    menuPrincipal.setVisible(true);
                    resultado = 1;
                     }else{
                         JOptionPane.showMessageDialog(null, "El Usuario no es Administrador");
                     }
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos ");
                }
            } else {
               JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
       }
        return resultado;
    }
   
}
