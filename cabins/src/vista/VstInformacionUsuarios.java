package vista;

import com.sun.awt.AWTUtilities;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.sql.*;
import conexion.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static vista.VstCrearUsuarios.formatter;

public class VstInformacionUsuarios extends javax.swing.JFrame {

    //Formato para el TIMESTAMP
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String user_update = "";
    int ID;

    public VstInformacionUsuarios() {
        this.setUndecorated(true);

        initComponents();

        this.setSize(new Dimension(950, 540)); //Metodo para cambiar el tamaño del JFrame

        //Codigo para redondear los bordes del JFRAME, IMPORTANTE TENER "TRUE" EL this.setUndecorated
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);

        user_update = VstGestionUsuarios.user_update;

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));

        try {

            Connection cn = conexionMensaje.nuevaConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from users where name = '" + user_update + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ID = rs.getInt("id");
                txt_nombre.setText(rs.getString("name"));
                txt_apellido.setText(rs.getString("last_name"));
                txt_contacto.setText(rs.getString("phone_number"));
                txt_edad.setText(rs.getString("age"));
                txt_correo.setText(rs.getString("email"));
                txt_identificacion.setText(rs.getString("identification_number"));
                cmb_tipoIdentificacion.setSelectedItem(rs.getString("identification_type"));
                txt_contrasenia.setText(rs.getString("password"));

            }

            cn.close();//Importante cerrar la Conexion

        } catch (SQLException e) {
            System.out.println("ERROR en cargar Usuario " + e);
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR !! Porfavor Contacte al Administrador.");
        }

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
        lbl_minimizar = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txt_nombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lbl_modificar = new javax.swing.JLabel();
        lbl_eliminar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jLabel1.setText("INFORMACION DEL USUARIO");
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
        txt_apellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_apellidoMouseClicked(evt);
            }
        });
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
        txt_identificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_identificacionMouseClicked(evt);
            }
        });
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
        txt_edad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_edadMouseClicked(evt);
            }
        });
        txt_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_edadActionPerformed(evt);
            }
        });
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 170, 20));

        txt_contrasenia.setBackground(new java.awt.Color(255, 255, 255));
        txt_contrasenia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_contrasenia.setForeground(new java.awt.Color(51, 51, 51));
        txt_contrasenia.setBorder(null);
        getContentPane().add(txt_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 253, 160, 20));

        lbl_directorio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_directorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/directorio.png"))); // NOI18N
        getContentPane().add(lbl_directorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 80, 80));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/contacto.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 40, 50));

        lbl_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png"))); // NOI18N
        lbl_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_minimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_minimizarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, 30));

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

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setFont(new java.awt.Font("Dubai Medium", 1, 48)); // NOI18N
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 190, 10));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(51, 51, 51));
        txt_nombre.setBorder(null);
        txt_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nombreMouseClicked(evt);
            }
        });
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 170, 20));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        lbl_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar64.png"))); // NOI18N
        lbl_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_modificarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, 80, 80));

        lbl_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/eliminar64.png"))); // NOI18N
        lbl_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_eliminarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 90, 80));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Editar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 50, 20));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setText("Eliminar");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 400, -1, 20));

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
        //System.exit(0);
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

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_modificarMouseClicked
        ModificarDatos();
    }//GEN-LAST:event_lbl_modificarMouseClicked

    private void lbl_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eliminarMouseClicked

        ImageIcon icono = new ImageIcon("/assets/eliminar128.png");

        int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro que deseas Eliminar al usuario?", " ELIMINAR USUARIO: ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icono);

        if (opcion == 0) {
            EliminarDatos();
        }
    }//GEN-LAST:event_lbl_eliminarMouseClicked

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
       setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_modificarMouseEntered
      lbl_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar70.png")));
    }//GEN-LAST:event_lbl_modificarMouseEntered

    private void lbl_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_modificarMouseExited
        lbl_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar64.png")));
    }//GEN-LAST:event_lbl_modificarMouseExited

    private void lbl_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eliminarMouseEntered
       lbl_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/eliminar70.png")));
    }//GEN-LAST:event_lbl_eliminarMouseEntered

    private void lbl_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_eliminarMouseExited
       lbl_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/eliminar64.png")));
    }//GEN-LAST:event_lbl_eliminarMouseExited

    private void txt_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseClicked
      
    }//GEN-LAST:event_txt_nombreMouseClicked

    private void txt_apellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_apellidoMouseClicked
        
    }//GEN-LAST:event_txt_apellidoMouseClicked

    private void txt_edadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_edadMouseClicked
     
    }//GEN-LAST:event_txt_edadMouseClicked

    private void txt_identificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_identificacionMouseClicked
      
    }//GEN-LAST:event_txt_identificacionMouseClicked

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
            java.util.logging.Logger.getLogger(VstInformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstInformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstInformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstInformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstInformacionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_tipoIdentificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel lbl_eliminar;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_modificar;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JPasswordField txt_contrasenia;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_identificacion;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

    public void ModificarDatos() {

        String nombre, apellido, num_telefono, tipo_identificacion_string = "", num_identificacion, correo, contrasenia, edad;
        int tipo_identificacion, validacion = 0;

        //Metodo para generar el TIMESTAMP
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

        try {

            Connection cn1 = conexionMensaje.nuevaConexion();
            PreparedStatement pst1 = cn1.prepareStatement( //Esta consulta lo que basicamente esta haciendo es comparar trayendo el nombre de usuario que no tenga ese ID, en lo que si se encuentra ese dato no se va a poder registrar con ese nombre de usuario porque ya existe
                    "select email from users where email = '" + correo + "' and not id = '" + ID + "'"); //Dice que si encuentra un nombre de usuario igual y que no sea el de este mismo ID es porque ya existe y no se puede usar

            ResultSet rs = pst1.executeQuery();

            if (rs.next()) {
                txt_correo.setForeground(Color.red);
                JOptionPane.showMessageDialog(null, "ATENCION! Correo NO DISPONIBLE.");
                txt_correo.setText("");
                txt_correo.setForeground(Color.black);
                cn1.close();
            } else {
                cn1.close();

                if (validacion == 0) { //Si no hay ningun campo vacio, entonces se realiza la insercion

                    try {

                        Connection cn2 = conexionMensaje.nuevaConexion();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "update users set name = ?, last_name = ?, phone_number = ?, identification_type = ?, identification_number = ?, email = ?,  "
                                + "password = ?, age = ?, state_record = ?, update_time = ? where id = '" + ID + "'");

                        pst2.setString(1, nombre);
                        pst2.setString(2, apellido);
                        pst2.setString(3, num_telefono);
                        pst2.setString(4, tipo_identificacion_string);
                        pst2.setString(5, num_identificacion);
                        pst2.setString(6, correo);
                        pst2.setString(7, contrasenia);
                        pst2.setString(8, edad);
                        pst2.setString(9, "ACTIVO");
                        pst2.setString(10, formattedDateTime);

                        pst2.executeUpdate(); //Cuando queremos actualizar datos usamos este metodo ExecuteUpdate pero cuando queremos ejecutar una consulta usamos el metodo ExecuteQuery
                        cn2.close(); //IMPORTANTE CERRAR LA CONEXION

                        JOptionPane.showMessageDialog(null, "Modificacion Exitosa !!"); //Mensaje de confirmacion
                        this.dispose(); //Metodo para que cierre la ventana despues de realizar el proceso

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "ERROR Al actualizar !!");
                        System.err.println("ERROR al Actualizar!" + e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ATENCION!! Debes llenar todos los campos");
                    
                }
            }

        } catch (SQLException e) {
            System.err.println("ERROR en validar usuario -MODIFICAR- " + e);
            JOptionPane.showMessageDialog(null, "ERROR al comparar usuario! Contacte al Administrador, -Problemas de Conexion-");
        }
    }

    public void EliminarDatos() {

        String nombre, apellido, num_telefono, tipo_identificacion_string = "", num_identificacion, correo, contrasenia, edad;
        int tipo_identificacion, validacion = 0;

        //Metodo para generar el TIMESTAMP
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

        try {

            Connection cn = conexionMensaje.nuevaConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "update users set name = ?, last_name = ?, phone_number = ?, identification_type = ?, identification_number = ?, email = ?,  "
                    + "password = ?, age = ?, state_record = ?, update_time = ? where id = '" + ID + "'");

            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, num_telefono);
            pst.setString(4, tipo_identificacion_string);
            pst.setString(5, num_identificacion);
            pst.setString(6, correo);
            pst.setString(7, contrasenia);
            pst.setString(8, edad);
            pst.setString(9, "INACTIVO");
            pst.setString(10, formattedDateTime);

            pst.executeUpdate(); //Cuando queremos actualizar datos usamos este metodo ExecuteUpdate pero cuando queremos ejecutar una consulta usamos el metodo ExecuteQuery
            cn.close(); //IMPORTANTE CERRAR LA CONEXION

            JOptionPane.showMessageDialog(null, "Eliminación Exitosa !!"); //Mensaje de confirmacion
            this.dispose(); //Metodo para que cierre la ventana despues de realizar el proceso

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR Al Eliminar !!");
            System.err.println("ERROR al Eliminar!" + e);
        }

    }

}
