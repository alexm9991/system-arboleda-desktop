package vista;

import Vista.VstProductos;
import java.awt.Color;
import java.awt.Component;
import vista.VstGestionUsuarios;
public class VstMenu extends VstBase {

    public VstMenu() {
        super();
        initComponents();
         setLocationRelativeTo(null);
         bordePantalla();
    }

    // hover mouse
    public void hoverEntered(java.awt.event.MouseEvent evt) {
        Component c = evt.getComponent();
        c.setBackground(new Color(69, 196, 192));
    }

    public void hoverExited(java.awt.event.MouseEvent evt) {
        Component c = evt.getComponent();
        c.setBackground(new Color(194, 229, 242));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_menuPrincipal = new javax.swing.JPanel();
        lbl_gestionUsuarios = new javax.swing.JLabel();
        btn_gestionProductos = new javax.swing.JButton();
        btn_gestionServicios = new javax.swing.JButton();
        lbl_gestionServicios = new javax.swing.JLabel();
        btn_gestionReportes = new javax.swing.JButton();
        lbl_gestionProductos = new javax.swing.JLabel();
        lbl_gestionReportes = new javax.swing.JLabel();
        btn_gestionUsuarios = new javax.swing.JButton();
        pnl_barraMenu = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setLocation(new java.awt.Point(0, 0));
        setName("frm_menuPrincipal"); // NOI18N
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

        pnl_menuPrincipal.setBackground(new java.awt.Color(236, 242, 243));
        pnl_menuPrincipal.setMaximumSize(new java.awt.Dimension(610, 455));
        pnl_menuPrincipal.setPreferredSize(new java.awt.Dimension(600, 450));

        lbl_gestionUsuarios.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_gestionUsuarios.setText("Gestión de Usuarios");
        lbl_gestionUsuarios.setToolTipText("");

        btn_gestionProductos.setBackground(new java.awt.Color(194, 229, 242));
        btn_gestionProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/productos.png"))); // NOI18N
        btn_gestionProductos.setBorder(null);
        btn_gestionProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gestionProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gestionProductosMouseExited(evt);
            }
        });
        btn_gestionProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionProductosActionPerformed(evt);
            }
        });

        btn_gestionServicios.setBackground(new java.awt.Color(194, 229, 242));
        btn_gestionServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/servicios.png"))); // NOI18N
        btn_gestionServicios.setBorder(null);
        btn_gestionServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gestionServiciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gestionServiciosMouseExited(evt);
            }
        });
        btn_gestionServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionServiciosActionPerformed(evt);
            }
        });

        lbl_gestionServicios.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_gestionServicios.setText("Gestión de Servicios");

        btn_gestionReportes.setBackground(new java.awt.Color(194, 229, 242));
        btn_gestionReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/reporte.png"))); // NOI18N
        btn_gestionReportes.setBorder(null);
        btn_gestionReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gestionReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gestionReportesMouseExited(evt);
            }
        });
        btn_gestionReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionReportesActionPerformed(evt);
            }
        });

        lbl_gestionProductos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_gestionProductos.setText("Gestión de Productos");

        lbl_gestionReportes.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lbl_gestionReportes.setText("Gestión de Reportes");

        btn_gestionUsuarios.setBackground(new java.awt.Color(194, 229, 242));
        btn_gestionUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usuarios.png"))); // NOI18N
        btn_gestionUsuarios.setBorder(null);
        btn_gestionUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gestionUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gestionUsuariosMouseExited(evt);
            }
        });
        btn_gestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionUsuariosActionPerformed(evt);
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

        javax.swing.GroupLayout pnl_menuPrincipalLayout = new javax.swing.GroupLayout(pnl_menuPrincipal);
        pnl_menuPrincipal.setLayout(pnl_menuPrincipalLayout);
        pnl_menuPrincipalLayout.setHorizontalGroup(
            pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_gestionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_gestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lbl_gestionUsuarios))
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lbl_gestionProductos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuPrincipalLayout.createSequentialGroup()
                        .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_gestionServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_gestionReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(lbl_gestionReportes)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(lbl_gestionServicios)
                        .addGap(96, 96, 96))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menuPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnl_barraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_menuPrincipalLayout.setVerticalGroup(
            pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                .addComponent(pnl_barraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(btn_gestionServicios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gestionServicios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_gestionReportes))
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(btn_gestionUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_gestionUsuarios)
                        .addGap(30, 30, 30)
                        .addComponent(btn_gestionProductos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_menuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(lbl_gestionProductos)
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(pnl_menuPrincipalLayout.createSequentialGroup()
                        .addComponent(lbl_gestionReportes)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        super.presionVentana(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        super.moverVentana(evt);
    }//GEN-LAST:event_formMouseDragged

    private void btn_gestionUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionUsuariosMouseExited
        hoverExited(evt);
    }//GEN-LAST:event_btn_gestionUsuariosMouseExited

    private void btn_gestionUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionUsuariosMouseEntered
        hoverEntered(evt);
    }//GEN-LAST:event_btn_gestionUsuariosMouseEntered

    private void btn_gestionReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionReportesMouseExited
        hoverExited(evt);
    }//GEN-LAST:event_btn_gestionReportesMouseExited

    private void btn_gestionReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionReportesMouseEntered
        hoverEntered(evt);
    }//GEN-LAST:event_btn_gestionReportesMouseEntered

    private void btn_gestionServiciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionServiciosMouseExited
        hoverExited(evt);
    }//GEN-LAST:event_btn_gestionServiciosMouseExited

    private void btn_gestionServiciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionServiciosMouseEntered
        hoverEntered(evt);
    }//GEN-LAST:event_btn_gestionServiciosMouseEntered

    private void btn_gestionProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionProductosMouseExited
        hoverExited(evt);
    }//GEN-LAST:event_btn_gestionProductosMouseExited

    private void btn_gestionProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gestionProductosMouseEntered
        hoverEntered(evt);
    }//GEN-LAST:event_btn_gestionProductosMouseEntered

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        super.cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        super.minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void btn_gestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionUsuariosActionPerformed
        VstGestionUsuarios abrir = new VstGestionUsuarios();
        abrir.setVisible(true);
    }//GEN-LAST:event_btn_gestionUsuariosActionPerformed

    private void btn_gestionServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionServiciosActionPerformed
        VstGestionServicios abrir = new VstGestionServicios();
        abrir.setVisible(true);
    }//GEN-LAST:event_btn_gestionServiciosActionPerformed

    private void btn_gestionProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionProductosActionPerformed
        VstProductos abrir = new VstProductos();
        abrir.setVisible(true);
    }//GEN-LAST:event_btn_gestionProductosActionPerformed

    private void btn_gestionReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionReportesActionPerformed
        VstReports abrir = new VstReports();
        abrir.setVisible(true);
    }//GEN-LAST:event_btn_gestionReportesActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//  
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VstMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gestionProductos;
    private javax.swing.JButton btn_gestionReportes;
    private javax.swing.JButton btn_gestionServicios;
    private javax.swing.JButton btn_gestionUsuarios;
    private javax.swing.JLabel lbl_gestionProductos;
    private javax.swing.JLabel lbl_gestionReportes;
    private javax.swing.JLabel lbl_gestionServicios;
    private javax.swing.JLabel lbl_gestionUsuarios;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JPanel pnl_barraMenu;
    private javax.swing.JPanel pnl_menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
