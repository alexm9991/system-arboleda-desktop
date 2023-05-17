package vista;

import java.awt.Color;
import javax.swing.*;
import jasperReportsController.ReportGenerator;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

public class VstReports extends vista.VstBase {

    public VstReports() {
        this.setLocationRelativeTo(null);
        initComponents();
        setSize(500, 350);
        getContentPane().setBackground(new Color(255, 255, 255));
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void salirEntered(java.awt.event.MouseEvent evt) {
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
    }

    public void salirExited(java.awt.event.MouseEvent evt) {
        lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
    }

    public void cerrarVentana(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    public void minimizarEntered(java.awt.event.MouseEvent evt) {
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
    }

    public void minimizarExited(java.awt.event.MouseEvent evt) {
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
    }

    public void minimizarVentana(java.awt.event.MouseEvent evt) {
        setExtendedState(ICONIFIED);
    }

    public static void main(String[] args) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jComboBoxUser = new javax.swing.JComboBox<>();
        jComboBoxProducts = new javax.swing.JComboBox<>();
        jComboBoxServices = new javax.swing.JComboBox<>();
        jComboBoxBookings = new javax.swing.JComboBox<>();
        jComboBoxPqrs = new javax.swing.JComboBox<>();
        jPanel_tittle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 250));
        setSize(new java.awt.Dimension(500, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png"))); // NOI18N
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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 30));

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
        getContentPane().add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 30, 30));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(17, 116, 110), 2, true));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jComboBoxUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Usuarios Activos", "Usuarios Eliminados" }));
        jComboBoxUser.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jComboBoxUserComponentAdded(evt);
            }
        });
        jComboBoxUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUserActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Usuarios", jComboBoxUser);

        jComboBoxProducts.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Productos Activos", "Productos Eliminados" }));
        jComboBoxProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProductsActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Productos", jComboBoxProducts);

        jComboBoxServices.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxServices.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Servicios Activos", "Servicios Inactivos" }));
        jComboBoxServices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxServicesActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Servicios", jComboBoxServices);

        jComboBoxBookings.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxBookings.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Reservaciones Activas", "Reservaciones Inactivas" }));
        jComboBoxBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBookingsActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("Reservas", jComboBoxBookings);

        jComboBoxPqrs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxPqrs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "PQRS Gestionadas", "PQRS No Gestionadas", "PQRS En Proceso" }));
        jComboBoxPqrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPqrsActionPerformed(evt);
            }
        });
        jTabbedPane1.addTab("PQRS", jComboBoxPqrs);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 480, 60));

        jPanel_tittle.setBackground(new java.awt.Color(255, 165, 89));
        jPanel_tittle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(16, 116, 110), 4, true));
        jPanel_tittle.setForeground(new java.awt.Color(16, 116, 110));
        jPanel_tittle.setToolTipText("");
        jPanel_tittle.setMaximumSize(new java.awt.Dimension(450, 80));
        jPanel_tittle.setMinimumSize(new java.awt.Dimension(450, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/reporteSmall.png"))); // NOI18N
        jPanel_tittle.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 116, 110));
        jLabel1.setText("GESTION DE REPORTES");
        jPanel_tittle.add(jLabel1);

        getContentPane().add(jPanel_tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 480, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked
    int xx, xy;
    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void jComboBoxPqrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPqrsActionPerformed
        // Obtenemos el elemento seleccionado en el ComboBox
        String selectedItem = jComboBoxPqrs.getSelectedItem().toString();
        if (selectedItem.equals("PQRS Gestionadas")) {
            JasperPrint reporteLleno = ReportGenerator.rpPqrsGestionado();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("PQRS No Gestionadas")) {
            JasperPrint reporteLleno = ReportGenerator.rpPqrsNoGestionado();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("PQRS En Proceso")) {
            JasperPrint reporteLleno = ReportGenerator.rpPqrsProceso();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxPqrsActionPerformed

    private void jComboBoxBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBookingsActionPerformed
        // Obtenemos el elemento seleccionado en el ComboBox
        String selectedItem = jComboBoxBookings.getSelectedItem().toString();
        if (selectedItem.equals("Reservaciones Activas")) {
            JasperPrint reporteLleno = ReportGenerator.rpActiveBookings();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("Reservaciones Inactivas")) {
            JasperPrint reporteLleno = ReportGenerator.rpInactiveBookings();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxBookingsActionPerformed

    private void jComboBoxServicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxServicesActionPerformed
        // Obtenemos el elemento seleccionado en el ComboBox
        String selectedItem = jComboBoxServices.getSelectedItem().toString();
        if (selectedItem.equals("Servicios Activos")) {
            JasperPrint reporteLleno = ReportGenerator.rpActiveServices();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("Servicios Inactivos")) {
            JasperPrint reporteLleno = ReportGenerator.rpInactiveServices();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxServicesActionPerformed

    private void jComboBoxProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProductsActionPerformed
        // Obtenemos el elemento seleccionado en el ComboBox
        String selectedItem = jComboBoxProducts.getSelectedItem().toString();
        // Si se ha seleccionado "Usuarios activos", generamos el reporte
        if (selectedItem.equals("Productos Activos")) {
            JasperPrint reporteLleno = ReportGenerator.rpActiveProducts();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("Productos Eliminados")) {
            JasperPrint reporteLleno = ReportGenerator.rpInactiveProducts();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxProductsActionPerformed

    private void jComboBoxUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUserActionPerformed
        // Obtenemos el elemento seleccionado en el ComboBox
        String selectedItem = jComboBoxUser.getSelectedItem().toString();
        // Si se ha seleccionado "Usuarios activos", generamos el reporte
        if (selectedItem.equals("Usuarios Activos")) {
            JasperPrint reporteLleno = ReportGenerator.rpActiveUsers();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        } else if (selectedItem.equals("Usuarios Eliminados")) {
            JasperPrint reporteLleno = ReportGenerator.rpInactiveUsers();
            JasperViewer viewer = new JasperViewer(reporteLleno, false);
            viewer.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxUserActionPerformed

    private void jComboBoxUserComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jComboBoxUserComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUserComponentAdded

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxBookings;
    private javax.swing.JComboBox<String> jComboBoxPqrs;
    private javax.swing.JComboBox<String> jComboBoxProducts;
    private javax.swing.JComboBox<String> jComboBoxServices;
    private javax.swing.JComboBox<String> jComboBoxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel_tittle;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables
}
