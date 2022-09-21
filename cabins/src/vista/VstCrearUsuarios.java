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

public class VstCrearUsuarios extends javax.swing.JFrame {

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
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
        jSeparator9 = new javax.swing.JSeparator();
        txt_nombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_clave = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 900, 550));
        setIconImage(getIconImage());
        setSize(900,550);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

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

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 190, 10));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 190, 10));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 190, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 190, 10));

        jSeparator6.setBackground(new java.awt.Color(51, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 190, 10));

        jSeparator7.setBackground(new java.awt.Color(51, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 273, 190, 10));

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

        cmb_tipoIdentificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "T.I", "C.C", "C.E" }));
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

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, 10));

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
//     System.exit(0);
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
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

        //VALIDACION DE CAMPOS VACIOS =
        if (nombre.equals("")) {
            txt_nombre.setForeground(Color.red);
            validacion++; //Aqui usamos la variable de tipo bandera en donde indicaremos que si esto pasa, esta misma va aumentar de uno en uno, esto nos ayudara mas adelante para saber cauntos campos estan vacios
        }
        if (apellido.equals("")) {
            txt_apellido.setForeground(Color.red);
            validacion++;
        }
        if (num_telefono.equals("")) {
            txt_contacto.setForeground(Color.red);
            validacion++;
        }
        if (num_identificacion.equals("")) {
            txt_identificacion.setForeground(Color.red);
            validacion++;
        }
        if (correo.equals("")) {
            txt_correo.setForeground(Color.red);
            validacion++;
        }
        if (contrasenia.equals("")) {
            txt_contrasenia.setForeground(Color.red);
            validacion++;
        }
        if (edad.equals("")) {
            txt_edad.setForeground(Color.red);
            validacion++;
        }
        
        //comboBOX
        if (tipo_identificacion == 0) {
            cmb_tipoIdentificacion.setBackground(Color.red);
            validacion = validacion + 1;

        } else if (tipo_identificacion == 1) {
            tipo_identificacion_string = "T.I";

        } else if (tipo_identificacion == 2) {
            tipo_identificacion_string = "C.C";

        } else if (tipo_identificacion == 3) {
            tipo_identificacion_string = "C.E";
        }

//        conexionMensaje conectar = new conexionMensaje();
//        String sqlCrearU = "INSERT INTO `users` (`id`, `name`, `last_name`, `phone_number`, `identification_type`,"
//                + " `identification_number`, `email`, `password`, `age`, `state_record`, `create_time`, `update_time`) "
//                + "VALUES (" + NULL +", '" + nombre + "', '" +apellido+ "', '" + num_telefono + "', '" + tipo_identificacion_string + "', '" + num_identificacion + "', '" + correo + "', "
//                + "' " + contrasenia+ "', '" + edad+ "', 'ACTIVAR', "
//                + formattedDateTime + "," + formattedDateTime + ");";
//        
//        try {
//            if (conectar.ejecutar(sqlCrearU)) {
//                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");
//            } else {
//                JOptionPane.showMessageDialog(null, "El usuario no fue guardado");
//            }
//        } catch (SQLException e) {
//            System.err.println("Error en guardar usuario " +e);
//        }
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
                    pst2.setString(8, contrasenia);
                    pst2.setString(9, edad);
                    pst2.setString(10, "ACTIVO");
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
                    
                }else{
                    JOptionPane.showMessageDialog(null, "ATENCION!! Debes llenar todos los campos");
                    this.dispose(); //metodo que hace que se cierre la ventana luego de realizar este proceso
                }
            }
        } catch (SQLException e) {
            System.err.println("ERROR en validar usuario " + e);
            JOptionPane.showMessageDialog(null, "ERROR al comparar usuario! Contacte al Administrador, -Problemas de Conexion-");

        }
    }
}
