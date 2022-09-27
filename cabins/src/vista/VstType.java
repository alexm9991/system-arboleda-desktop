/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;

/**
 *
 * @author jorge
 */
public class VstType extends javax.swing.JFrame {

    /**
     * Creates new form VstType
     */
    public VstType() {
        initComponents();
    }
 public void abrirReportUser() {
        VstReportUser VRU = new VstReportUser();
        VRU.setSize(900, 400);
        VRU.setLocation(0, 0);

        pnl_reports.removeAll();
        pnl_reports.add(VRU, BorderLayout.CENTER);
        pnl_reports.revalidate();
        pnl_reports.repaint();
    }
    
    public void abrirReportService() {
        VstReportService VRS = new VstReportService();
        VRS.setSize(900, 400);
        VRS.setLocation(0, 0);

        pnl_reports.removeAll();
        pnl_reports.add(VRS, BorderLayout.CENTER);
        pnl_reports.revalidate();
        pnl_reports.repaint();
    }
    
    public void abrirReportProduct() {
        VstReportProduct VRP = new VstReportProduct();
        VRP.setSize(900, 400);
        VRP.setLocation(0, 0);

        pnl_reports.removeAll();
        pnl_reports.add(VRP, BorderLayout.CENTER);
        pnl_reports.revalidate();
        pnl_reports.repaint();
    }
    
    public void abrirReportReservation() {
        VstReportReservation VRR = new VstReportReservation();
        VRR.setSize(900, 400);
        VRR.setLocation(0, 0);

        pnl_reports.removeAll();
        pnl_reports.add(VRR, BorderLayout.CENTER);
        pnl_reports.revalidate();
        pnl_reports.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_reports = new javax.swing.JPanel();
        lbl_tipoReportes = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnRerservaciones = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnl_reportsLayout = new javax.swing.GroupLayout(pnl_reports);
        pnl_reports.setLayout(pnl_reportsLayout);
        pnl_reportsLayout.setHorizontalGroup(
            pnl_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        pnl_reportsLayout.setVerticalGroup(
            pnl_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        lbl_tipoReportes.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lbl_tipoReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipoReportes.setText("Tipo de reporte");
        lbl_tipoReportes.setToolTipText("");
        lbl_tipoReportes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnProductos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnRerservaciones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnRerservaciones.setText("Rerservaciones");
        btnRerservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRerservacionesActionPerformed(evt);
            }
        });

        btn_usuarios.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_usuarios.setText("Usuarios");
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });

        btnServicios.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnServicios.setText("Servicios");
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(pnl_reports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRerservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(lbl_tipoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbl_tipoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRerservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnl_reports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        abrirReportProduct();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnRerservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRerservacionesActionPerformed
        // TODO add your handling code here:
        abrirReportReservation();
    }//GEN-LAST:event_btnRerservacionesActionPerformed

    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
        // TODO add your handling code here:
        abrirReportUser();
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        // TODO add your handling code here:
        abrirReportService();
    }//GEN-LAST:event_btnServiciosActionPerformed

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
            java.util.logging.Logger.getLogger(VstType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRerservaciones;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JLabel lbl_tipoReportes;
    private javax.swing.JPanel pnl_reports;
    // End of variables declaration//GEN-END:variables
}
