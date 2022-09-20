/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import conexion.conexionMensaje;
import Controlador.CtrlProductos;
import Modelo.MdlProductos;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author SENA
 */
public class VstAgregar_Producto extends javax.swing.JFrame {
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] byteImg;
    CtrlProductos gestion = new CtrlProductos();

    ArrayList<MdlProductos> Producto = new ArrayList();
    
    conexionMensaje con = new conexionMensaje();
    conexionMensaje conexion = new conexionMensaje();
   Long datetime = System.currentTimeMillis(); //Se crea una variable de tipo Long y se le asigna el valor de System.currentTimeMillis()
        Timestamp timestamp = new Timestamp(datetime);
    Calendar fecha = new GregorianCalendar();
    
public void Fecha() {
        lblfecha.setText(String.valueOf(timestamp));  
    }

    public VstAgregar_Producto() {
        initComponents();

        aviso.setVisible(false);
        aviso2.setVisible(false);
        aviso3.setVisible(false);
        Fecha();
        getContentPane().setBackground(new Color(255, 255, 255));
    }
public void salirEntered(java.awt.event.MouseEvent evt){
           lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
        }
public void salirExited(java.awt.event.MouseEvent evt){
           lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
        }
public void cerrarVentana(java.awt.event.MouseEvent evt){
       this.setVisible(false);
}

public void minimizarEntered(java.awt.event.MouseEvent evt){
           lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
        }
public void minimizarExited(java.awt.event.MouseEvent evt){
           lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
        }
public void minimizarVentana(java.awt.event.MouseEvent evt){
    setExtendedState(ICONIFIED);
}

    public void llenarDato(MdlProductos mdlProductos) {
        TxtNombreProductoAgregar.setText(String.valueOf(mdlProductos.getNameProduct()));
        TxtPrecioProductoAgregar.setText(String.valueOf(mdlProductos.getPrice()));
        TxtDescripcionProductoAgregar.setText(String.valueOf(mdlProductos.getDescripcion()));
        lblruta.setText(String.valueOf(mdlProductos.getRutaImg()));

    }
    public void limpiar() {
        TxtNombreProductoAgregar.setText(" ");
        TxtDescripcionProductoAgregar.setText(" ");
        TxtPrecioProductoAgregar.setText(" ");
        lblruta.setText(" ");
        lblImagen.setIcon(null);
        lblfecha.setText(String.valueOf(gestion.fecha()));
        lblestado.setText(" ");
    }
    public void Guardar() {
        MdlProductos mdlproductos = new MdlProductos();
        CtrlProductos ctrlproductos = new CtrlProductos();
        mdlproductos.setNameProduct(TxtNombreProductoAgregar.getText());
        mdlproductos.setPrice(Float.parseFloat(TxtPrecioProductoAgregar.getText()));
        mdlproductos.setRutaImg(lblruta.getText());
        mdlproductos.setCreateTime(timestamp);
        mdlproductos.setDescripcion(TxtDescripcionProductoAgregar.getText());
        mdlproductos.setStateRecord("activar");
        ctrlproductos.guardarProductos(mdlproductos);;
        limpiar();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblestado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TxtNombreProductoAgregar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnAceptarAgregar = new javax.swing.JButton();
        BtnCancelarAgregar = new javax.swing.JButton();
        btnAggImg = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblruta = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        aviso = new javax.swing.JLabel();
        aviso2 = new javax.swing.JLabel();
        aviso3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        TxtPrecioProductoAgregar = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDescripcionProductoAgregar = new javax.swing.JTextArea();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        lblestado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(lblestado);
        lblestado.setBounds(10, 520, 10, 24);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del producto:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(18, 11, 230, 24);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(20, 150, 240, 10);

        TxtNombreProductoAgregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxtNombreProductoAgregar.setBorder(null);
        TxtNombreProductoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreProductoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(TxtNombreProductoAgregar);
        TxtNombreProductoAgregar.setBounds(20, 40, 240, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 100, 230, 24);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 170, 230, 24);

        BtnAceptarAgregar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnAceptarAgregar.setText("Guardar");
        BtnAceptarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAceptarAgregar);
        BtnAceptarAgregar.setBounds(200, 440, 110, 40);

        BtnCancelarAgregar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnCancelarAgregar.setText("Cancelar");
        BtnCancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCancelarAgregar);
        BtnCancelarAgregar.setBounds(40, 440, 100, 40);

        btnAggImg.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAggImg.setText("Agregar Imagen");
        btnAggImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggImgActionPerformed(evt);
            }
        });
        jPanel1.add(btnAggImg);
        btnAggImg.setBounds(30, 270, 170, 30);

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblImagen);
        lblImagen.setBounds(330, 70, 480, 350);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de creación:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(480, 440, 150, 40);

        lblruta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblruta.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblrutaComponentAdded(evt);
            }
        });
        jPanel1.add(lblruta);
        lblruta.setBounds(20, 320, 240, 30);

        lblfecha.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblfechaComponentAdded(evt);
            }
        });
        jPanel1.add(lblfecha);
        lblfecha.setBounds(620, 450, 230, 20);

        aviso.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aviso.setForeground(new java.awt.Color(255, 102, 102));
        aviso.setText("X");
        jPanel1.add(aviso);
        aviso.setBounds(250, 20, 41, 16);

        aviso2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aviso2.setForeground(new java.awt.Color(255, 51, 51));
        aviso2.setText("X");
        jPanel1.add(aviso2);
        aviso2.setBounds(250, 110, 41, 16);

        aviso3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        aviso3.setForeground(new java.awt.Color(255, 51, 51));
        aviso3.setText("X");
        jPanel1.add(aviso3);
        aviso3.setBounds(250, 180, 41, 16);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Imagen:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 30, 58, 18);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 70, 240, 10);

        TxtPrecioProductoAgregar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxtPrecioProductoAgregar.setBorder(null);
        TxtPrecioProductoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioProductoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(TxtPrecioProductoAgregar);
        TxtPrecioProductoAgregar.setBounds(20, 120, 240, 30);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(20, 240, 240, 30);

        TxtDescripcionProductoAgregar.setColumns(20);
        TxtDescripcionProductoAgregar.setRows(5);
        TxtDescripcionProductoAgregar.setBorder(null);
        jScrollPane1.setViewportView(TxtDescripcionProductoAgregar);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 200, 240, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 850, 490));

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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 30, 30));

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
        getContentPane().add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lblrutaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lblrutaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblrutaComponentAdded

    private void btnAggImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggImgActionPerformed
        if (seleccionado.showDialog(null, "Abrir Imagen") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            lblruta.setText(String.valueOf(archivo));
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png")
                    || archivo.getName().endsWith("gif") || archivo.getName().endsWith("jpeg")
                    || archivo.getName().endsWith("JPG") || archivo.getName().endsWith("PNG")
                    || archivo.getName().endsWith("JPEG")) {
                    byteImg = gestion.AbrirImagen(archivo);

                    rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, String.valueOf(archivo) );
                } else {
                    JOptionPane.showMessageDialog(null, "Por Favor Seleccione Un Archivo De Imagen");
                }
            }
        }
    }//GEN-LAST:event_btnAggImgActionPerformed

    private void BtnCancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarAgregarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarAgregarActionPerformed

    private void BtnAceptarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarAgregarActionPerformed

        if (TxtNombreProductoAgregar.getText().trim().isEmpty() || TxtPrecioProductoAgregar.getText().trim().isEmpty() || TxtDescripcionProductoAgregar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "por favor diligenciar campos obligatorios", "error", JOptionPane.WARNING_MESSAGE);
            aviso.setVisible(true);
            aviso2.setVisible(true);
            aviso3.setVisible(true);
        } else {
            Guardar();

        }
    }//GEN-LAST:event_BtnAceptarAgregarActionPerformed

    private void TxtPrecioProductoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioProductoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPrecioProductoAgregarActionPerformed

    private void TxtNombreProductoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreProductoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreProductoAgregarActionPerformed

    private void lblfechaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lblfechaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblfechaComponentAdded

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
            java.util.logging.Logger.getLogger(VstAgregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstAgregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstAgregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstAgregar_Producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstAgregar_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptarAgregar;
    private javax.swing.JButton BtnCancelarAgregar;
    private javax.swing.JTextArea TxtDescripcionProductoAgregar;
    private javax.swing.JTextField TxtNombreProductoAgregar;
    private javax.swing.JTextField TxtPrecioProductoAgregar;
    private javax.swing.JLabel aviso;
    private javax.swing.JLabel aviso2;
    private javax.swing.JLabel aviso3;
    private javax.swing.JButton btnAggImg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JLabel lblestado;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblruta;
    // End of variables declaration//GEN-END:variables
}