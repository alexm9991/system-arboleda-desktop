package vista;

import com.sun.awt.AWTUtilities;
import java.awt.*;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.*;
import conexion.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import controlador.CtrEncrypt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VstCrearUsuarios extends javax.swing.JFrame {

    int ID;
    int x, y;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public VstCrearUsuarios() {
        this.setUndecorated(true);

        initComponents();

        this.setSize(new Dimension(950, 540)); //Metodo para cambiar el tamaño del JFrame

        //Codigo para redondear los bordes del JFRAME, IMPORTANTE TENER "TRUE" EL this.setUndecorated
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparatorContrasenia = new javax.swing.JSeparator();
        jSeparatorCorreo = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparatorApellido = new javax.swing.JSeparator();
        jSeparatorContacto = new javax.swing.JSeparator();
        jSeparatorEdad = new javax.swing.JSeparator();
        jSeparatorIdentificacion = new javax.swing.JSeparator();
        txt_apellido = new javax.swing.JTextField();
        txt_contacto = new javax.swing.JTextField();
        txt_identificacion = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        cmb_tipoIdentificacion = new javax.swing.JComboBox<>();
        txt_edad = new javax.swing.JTextField();
        txt_contrasenia = new javax.swing.JPasswordField();
        lbl_directorio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_registrarDatos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparatorNombre = new javax.swing.JSeparator();
        txt_nombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_clave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 900, 550));
        setIconImage(getIconImage());
        setSize(900,550);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparatorContrasenia.setBackground(new java.awt.Color(51, 255, 255));
        jSeparatorContrasenia.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorContrasenia.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 273, 190, 10));

        jSeparatorCorreo.setBackground(new java.awt.Color(51, 255, 255));
        jSeparatorCorreo.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorCorreo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 190, 10));

        jPanel1.setBackground(new java.awt.Color(255, 165, 89));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 540));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("CREAR USUARIO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Apellido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 80, 20));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Identificación:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Tipo Identificación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("Contacto:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("CONTRASEÑA:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText("Edad:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, 20));

        jSeparatorApellido.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorApellido.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorApellido.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 190, 10));

        jSeparatorContacto.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorContacto.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorContacto.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 190, 10));

        jSeparatorEdad.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorEdad.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorEdad.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 190, 10));

        jSeparatorIdentificacion.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorIdentificacion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparatorIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 190, 10));

        txt_apellido.setBackground(new java.awt.Color(255, 255, 255));
        txt_apellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(51, 51, 51));
        txt_apellido.setBorder(null);
        txt_apellido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 170, 20));

        txt_contacto.setBackground(new java.awt.Color(255, 255, 255));
        txt_contacto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_contacto.setForeground(new java.awt.Color(51, 51, 51));
        txt_contacto.setBorder(null);
        txt_contacto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 170, 20));

        txt_identificacion.setBackground(new java.awt.Color(255, 255, 255));
        txt_identificacion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_identificacion.setForeground(new java.awt.Color(51, 51, 51));
        txt_identificacion.setBorder(null);
        txt_identificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 170, 20));

        txt_correo.setBackground(new java.awt.Color(255, 255, 255));
        txt_correo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_correo.setForeground(new java.awt.Color(51, 51, 51));
        txt_correo.setBorder(null);
        txt_correo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 160, 20));

        cmb_tipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "tarjeta de identidad", "cedula de ciudadania", "cedula de extranjeria" }));
        cmb_tipoIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoIdentificacionActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_tipoIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 160, 30));

        txt_edad.setBackground(new java.awt.Color(255, 255, 255));
        txt_edad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_edad.setForeground(new java.awt.Color(51, 51, 51));
        txt_edad.setBorder(null);
        txt_edad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edadActionPerformed(evt);
            }
        });
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 170, 20));

        txt_contrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txt_contrasenia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_contrasenia.setForeground(new java.awt.Color(51, 51, 51));
        txt_contrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contrasenia.setBorder(null);
        getContentPane().add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 253, 160, 20));

        lbl_directorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_directorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/directorio.png"))); // NOI18N
        getContentPane().add(lbl_directorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 80, 80));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/contacto.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 40, 50));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, -1, 30));

        lbl_registrarDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_registrarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/agregar-usuario.png"))); // NOI18N
        lbl_registrarDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_registrarDatosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_registrarDatosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_registrarDatosMouseExited(evt);
            }
        });
        getContentPane().add(lbl_registrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 310, 90, 80));

        jLabel13.setText("Registrar");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, -1, -1));

        jSeparatorNombre.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorNombre.setForeground(new java.awt.Color(0, 0, 0));
        jSeparatorNombre.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        getContentPane().add(jSeparatorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, 10));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(51, 51, 51));
        txt_nombre.setBorder(null);
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 170, 20));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        lbl_correo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_correo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/correo.png"))); // NOI18N
        getContentPane().add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 30, 20));

        lbl_clave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_clave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/clave.png"))); // NOI18N
        getContentPane().add(lbl_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 30, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_edadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_edadActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         setVisible(false);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void cmb_tipoIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoIdentificacionActionPerformed

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
    }//GEN-LAST:event_jLabel11MouseExited

    private void lbl_registrarDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_registrarDatosMouseExited
        lbl_registrarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/agregar-usuario.png")));
    }//GEN-LAST:event_lbl_registrarDatosMouseExited

    private void lbl_registrarDatosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_registrarDatosMouseEntered
        lbl_registrarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/agregar-usuarioON.png")));
    }//GEN-LAST:event_lbl_registrarDatosMouseEntered

    private void lbl_registrarDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_registrarDatosMouseClicked
        crearUsuario();
    }//GEN-LAST:event_lbl_registrarDatosMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        this.setLocation(X - x, Y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VstCrearUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstCrearUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstCrearUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstCrearUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstCrearUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_tipoIdentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparatorApellido;
    private javax.swing.JSeparator jSeparatorContacto;
    private javax.swing.JSeparator jSeparatorContrasenia;
    private javax.swing.JSeparator jSeparatorCorreo;
    private javax.swing.JSeparator jSeparatorEdad;
    private javax.swing.JSeparator jSeparatorIdentificacion;
    private javax.swing.JSeparator jSeparatorNombre;
    private javax.swing.JLabel lbl_clave;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_directorio;
    private javax.swing.JLabel lbl_registrarDatos;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JPasswordField txt_contrasenia;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_identificacion;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public void crearUsuario() {
            CtrEncrypt encrypt = new CtrEncrypt();
        String nombre, apellido, num_telefono, tipo_identificacion_string = "", num_identificacion, correo, contrasenia, edad;
        int tipo_identificacion, validacion = 0;

        LocalDateTime todayDateTime = LocalDateTime.now();
        String formattedDateTime = todayDateTime.format(formatter);

        nombre = txt_nombre.getText().trim();
        apellido = txt_apellido.getText().trim();
        num_telefono = txt_contacto.getText().trim();
        tipo_identificacion = cmb_tipoIdentificacion.getSelectedIndex();
        num_identificacion = txt_identificacion.getText().trim();
        correo = txt_correo.getText().trim();
        contrasenia = txt_contrasenia.getText().trim();
        edad = txt_edad.getText().trim();
       // edad = Integer.parseInt(txt_edad.getText().trim());
       
       
       //VALIDACIONES GENERALES
       //campos vacios
       if (nombre.isEmpty() || apellido.isEmpty() || num_telefono.isEmpty() || tipo_identificacion == 0 || num_identificacion.isEmpty() || correo.isEmpty() || contrasenia.isEmpty() || edad.isEmpty()) {
           JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos son obligatorios");
           validacion++;
           return;
        }
       
       //formato correo correcto
       else if (!correo.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            jSeparatorCorreo.setOpaque(true);
            jSeparatorCorreo.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Por favor, introduzca una dirección de correo electrónico válida");   
            jSeparatorCorreo.setOpaque(false);
            validacion++;
            return;
        }
       
        if (!edad.matches("[0-9]+")) {
            jSeparatorEdad.setOpaque(true);
            jSeparatorEdad.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Solo se permite numeros");
            return;
        }
        
        //Validacion edad
        int edadV = Integer.parseInt(edad);
        if (edadV < 18 || edadV > 65) {
            jSeparatorEdad.setOpaque(true);
            jSeparatorEdad.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "La edad debe estar entre 18 y 65 años");
            return;
        }
        
        //Validacion longitud
        if (num_telefono.length() != 10) {
            jSeparatorContacto.setOpaque(true);
            jSeparatorContacto.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "El número de contacto debe tener 10 dígitos");
            validacion++;
            return;
        }
        if (contrasenia.length() < 10) {
            jSeparatorContrasenia.setOpaque(true);
            jSeparatorContrasenia.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "La contraseña debe contener al menos 10 caracteres o mas");
            validacion++;
            return;
        }
        
        if (num_identificacion.length() != 10) {
            jSeparatorIdentificacion.setOpaque(true);
            jSeparatorIdentificacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "El número de identificacion debe tener 10 dígitos");
            validacion++;
            return;
        }
        
        //Validar Texto solo caracteres
        if(validarTexto(nombre) == false){
            jSeparatorNombre.setOpaque(true);
            jSeparatorNombre.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Solo se permite Texto");
            validacion++;
            return;
        }
        
        if(validarTexto(apellido) == false){
            jSeparatorApellido.setOpaque(true);
            jSeparatorApellido.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Solo se permite Texto");
            validacion++;
            return;
        }
        
        //Validar solo numeros
        
        if(!num_identificacion.matches("[0-9]+")){
            jSeparatorIdentificacion.setOpaque(true);
            jSeparatorIdentificacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Solo se permite numeros");
        }
        if(!num_telefono.matches("[0-9]+")){
            jSeparatorContacto.setOpaque(true);
            jSeparatorContacto.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Solo se permite numeros");
        }

  //comboBOX
        if (tipo_identificacion == 0) {
            cmb_tipoIdentificacion.setBackground(Color.red);
            validacion = validacion + 1;

        } else if (tipo_identificacion == 1) {
            tipo_identificacion_string = "tarjeta de identidad";

        } else if (tipo_identificacion == 2) {
            tipo_identificacion_string = "cedula de ciudadania";

        } else if (tipo_identificacion == 3) {
            tipo_identificacion_string = "cedula de extranjeria";
        }


        try {

            Connection cn1 = conexionMensaje.nuevaConexion();
            PreparedStatement pst1 = cn1.prepareStatement(""
                    + "select identification_number, email from users where email = '" + correo + "' or identification_number = '" + num_identificacion + "'");

            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El Usuario ya existe, intenta otro correo");
                cn1.close();
            } else {
                cn1.close();

                if (validacion == 0) { //Si no hay ningun campo vacio, entonces se realiza la insercion

                    //INGRESO DE DATOS #1
                try {
                    Connection cn2 = conexionMensaje.nuevaConexion();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "insert into users values(?,?,?,?,?,?,?,?,?,?,?,?)");

                    pst2.setInt(1, 0);
                    pst2.setString(2, nombre);
                    pst2.setString(3, apellido);
                    pst2.setString(4, num_telefono);
                    pst2.setString(5, tipo_identificacion_string);
                    pst2.setString(6, num_identificacion);
                    pst2.setString(7, correo);
                    pst2.setString(8, encrypt.encryptPassword(contrasenia));
                    pst2.setString(9, edad);
                    pst2.setString(10, "ACTIVAR");
                    pst2.setString(11, formattedDateTime);
                    pst2.setString(12, formattedDateTime);

                    pst2.executeUpdate();
                    cn2.close();
                    

                    JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!!");
                    this.dispose(); //metodo que hace que se cierre la ventana luego de realizar este proceso

                } catch (SQLException e) {
                    System.err.println("No ha sido ingresado los datos correctamente" + e);
                    JOptionPane.showMessageDialog(null, "Ingreso de datos incorrecto, contacte a los desarrolladores");
                }
                
                 //Con el sig codigo obtenemos el id que acabo de registrarse
                    try {
                        Connection cn3 = conexionMensaje.nuevaConexion();
                        PreparedStatement pst3 = cn3.prepareStatement(
                               "select id from users where email = '"+ correo +"'");
                        
                        ResultSet rs3 = pst3.executeQuery();
                        if(rs3.next()){                          
                            ID = rs3.getInt("id");
                        }
                        cn3.close();
                        
                        try {
                            Connection cn4 = conexionMensaje.nuevaConexion();
                            PreparedStatement pst4 = cn4.prepareStatement(
                                 "insert into model_has_roles values(?,?,?)");
                            
                            pst4.setString(1, "2");
                            pst4.setString(2, "App\\Models\\User");
                            pst4.setInt(3, ID);
                            
                            pst4.executeUpdate();
                            cn4.close();
                            
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "No se registro el rol" +e);
                        }
                        
                        
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "No se encontro el ID" +e);
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "ATENCION!! Debes llenar todos los campos");
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR en validar usuario " + e);
            JOptionPane.showMessageDialog(null, "ERROR al comparar usuario! Contacte al Administrador, -Problemas de Conexion-");

        }
    }
    
      public static boolean validarTexto(String texto) {
        // Creamos una expresión regular que sólo permita letras (mayúsculas o minúsculas)
        Pattern patron = Pattern.compile("^[a-zA-Z]+$");
        // Creamos un objeto Matcher para buscar el patrón en el texto
        Matcher matcher = patron.matcher(texto);
        // Retornamos true si el patrón se encuentra en el texto
        return matcher.matches();
    }
}
