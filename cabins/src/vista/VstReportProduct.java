/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author ADSI
 */
public class VstReportProduct extends javax.swing.JPanel {

    /**
     * Creates new form VstReportUser
     */
    public VstReportProduct() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUsuarios = new javax.swing.JLabel();
        btnBuscarTercero = new javax.swing.JButton();
        btnUsuariosActivos = new javax.swing.JButton();
        btnUsuariosEliminados = new javax.swing.JButton();
        btnEmpleadosRegistrados = new javax.swing.JButton();

        setToolTipText("");
        setName(""); // NOI18N

        lblUsuarios.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lblUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuarios.setText("Productos");
        lblUsuarios.setToolTipText("");
        lblUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblUsuarios.setPreferredSize(new java.awt.Dimension(200, 50));

        btnBuscarTercero.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnBuscarTercero.setText("Activos");
        btnBuscarTercero.setPreferredSize(new java.awt.Dimension(200, 50));
        btnBuscarTercero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTerceroActionPerformed(evt);
            }
        });

        btnUsuariosActivos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnUsuariosActivos.setText("Eliminados");
        btnUsuariosActivos.setPreferredSize(new java.awt.Dimension(200, 50));
        btnUsuariosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActivosActionPerformed(evt);
            }
        });

        btnUsuariosEliminados.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnUsuariosEliminados.setText("Mas Vendidos");
        btnUsuariosEliminados.setPreferredSize(new java.awt.Dimension(200, 50));
        btnUsuariosEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosEliminadosActionPerformed(evt);
            }
        });

        btnEmpleadosRegistrados.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnEmpleadosRegistrados.setText("Menos Vendidos");
        btnEmpleadosRegistrados.setPreferredSize(new java.awt.Dimension(200, 50));
        btnEmpleadosRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosRegistradosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscarTercero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUsuariosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUsuariosEliminados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmpleadosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarTercero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariosEliminados, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleadosRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarTerceroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTerceroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarTerceroActionPerformed

    private void btnUsuariosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosActivosActionPerformed

    private void btnUsuariosEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosEliminadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosEliminadosActionPerformed

    private void btnEmpleadosRegistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosRegistradosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpleadosRegistradosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarTercero;
    private javax.swing.JButton btnEmpleadosRegistrados;
    private javax.swing.JButton btnUsuariosActivos;
    private javax.swing.JButton btnUsuariosEliminados;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuarios;
    // End of variables declaration//GEN-END:variables
}
