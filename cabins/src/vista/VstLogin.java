package vista;

import controlador.CtrEncrip;
import controlador.CtrLogin;
import conexion.conexionMensaje;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import controlador.CtrEncrip;

/**
 * @author jorge
 */
public class VstLogin extends VstBase {

    conexionMensaje cc = new conexionMensaje();

    Connection con = conexionMensaje.getConnection();

    public VstLogin() {
        super();
        initComponents();
        SetImageLabel(lbl_logo, "src/assets/logo.jpg");
    }

    // hover salir
    public void salirEntered(java.awt.event.MouseEvent evt) {
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
    }

    public void salirExited(java.awt.event.MouseEvent evt) {
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
    }

    // hover minimizar
    public void minimizarEntered(java.awt.event.MouseEvent evt) {
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
    }

    public void minimizarExited(java.awt.event.MouseEvent evt) {
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();

    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_loginPrincipal = new javax.swing.JPanel();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_iniciar = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        pnl_barraMenu = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));

        pnl_loginPrincipal.setBackground(new java.awt.Color(236, 242, 243));
        pnl_loginPrincipal.setToolTipText("");
        pnl_loginPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_loginPrincipal.setDoubleBuffered(false);
        pnl_loginPrincipal.setEnabled(false);
        pnl_loginPrincipal.setFocusable(false);
        pnl_loginPrincipal.setMaximumSize(new java.awt.Dimension(600, 450));
        pnl_loginPrincipal.setPreferredSize(new java.awt.Dimension(600, 450));
        pnl_loginPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnl_loginPrincipalMouseDragged(evt);
            }
        });
        pnl_loginPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_loginPrincipalMousePressed(evt);
            }
        });

        lbl_email.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_email.setText("Email:");

        txt_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lbl_password.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_password.setText("Password:");

        txt_password.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });

        btn_iniciar.setText("Login");
        btn_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarActionPerformed(evt);
            }
        });

        pnl_barraMenu.setBackground(new java.awt.Color(236, 242, 243));

        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png"))); // NOI18N
        lbl_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_salirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_salirMouseExited(evt);
            }
        });

        lbl_minimizar.setBackground(new java.awt.Color(236, 242, 243));
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png"))); // NOI18N
        lbl_minimizar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
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

        javax.swing.GroupLayout pnl_barraMenuLayout = new javax.swing.GroupLayout(pnl_barraMenu);
        pnl_barraMenu.setLayout(pnl_barraMenuLayout);
        pnl_barraMenuLayout.setHorizontalGroup(
            pnl_barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_barraMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnl_barraMenuLayout.setVerticalGroup(
            pnl_barraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_barraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_loginPrincipalLayout = new javax.swing.GroupLayout(pnl_loginPrincipal);
        pnl_loginPrincipal.setLayout(pnl_loginPrincipalLayout);
        pnl_loginPrincipalLayout.setHorizontalGroup(
            pnl_loginPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_loginPrincipalLayout.createSequentialGroup()
                .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_loginPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_loginPrincipalLayout.createSequentialGroup()
                        .addGroup(pnl_loginPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_email)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_password)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_iniciar))
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_loginPrincipalLayout.createSequentialGroup()
                        .addComponent(pnl_barraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnl_loginPrincipalLayout.setVerticalGroup(
            pnl_loginPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginPrincipalLayout.createSequentialGroup()
                .addComponent(pnl_barraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(lbl_email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lbl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_iniciar)
                .addGap(170, 170, 170))
            .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_loginPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_loginPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarActionPerformed
       CtrEncrip val = new CtrEncrip();
        if(txt_email.getText().isEmpty() & txt_password.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Por favor Llene los campos");
        }else{          
        String usuario = txt_email.getText();
           String password = txt_password.getText();
            CtrLogin validar = new CtrLogin();
        if (validar.Validarusuario(usuario, password)==1){
            this.dispose();
        }
        
        
        }
        
    }//GEN-LAST:event_btn_iniciarActionPerformed

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        super.cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        super.minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void pnl_loginPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_loginPrincipalMousePressed
        super.presionVentana(evt);
    }//GEN-LAST:event_pnl_loginPrincipalMousePressed

    private void pnl_loginPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_loginPrincipalMouseDragged
        super.moverVentana(evt);
    }//GEN-LAST:event_pnl_loginPrincipalMouseDragged

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_iniciar;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JPanel pnl_barraMenu;
    private javax.swing.JPanel pnl_loginPrincipal;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
