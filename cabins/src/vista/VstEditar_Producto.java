package Vista;

import Conexion.conexionMensaje;
import Controlador.CtrlProductos;
import Vista.VstProductos;
import Modelo.MdlProductos;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import javax.swing.*;


public class VstEditar_Producto extends javax.swing.JFrame {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] byteImg;
    CtrlProductos gestion = new CtrlProductos();
    Conexion.conexionMensaje con = new conexionMensaje();
    Conexion.conexionMensaje connect = new conexionMensaje();
    ArrayList<MdlProductos> listaProductosActualizar = new ArrayList();
    Long datetime = System.currentTimeMillis(); 
        Timestamp timestamp = new Timestamp(datetime);
    public VstEditar_Producto() {
        initComponents();
        Ocultar();
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
    public void traerDatos(int idx) {
        CtrlProductos j = new CtrlProductos();
        MdlProductos producto = new MdlProductos();
        j.consultarProducto(producto, idx);
        llenarDatos(producto);
    }

    public void llenarDatos(MdlProductos producto) {
         
        lblfecha.setText(String.valueOf(timestamp));
        lblId.setText("" + producto.getId());
        TxtNombreProductoEditar.setText(producto.getNameProduct());
        TxtPrecioProductoEditar.setText(String.valueOf(producto.getPrice()));
        txtDescripcion.setText(producto.getDescripcion());
        lblruta.setText(producto.getRutaImg());
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, producto.getRutaImg());

        inactivar();
    }

    // Funcion para que no se vea el id del producto
    public void Ocultar() {
        lblId.setVisible(false);
    }

    // Funcion para que no se pueda editar la ruta de una imagen
    public void inactivar() {
        lblruta.setEnabled(false);
    }

    public void editarProducto() {
        Long datetime = System.currentTimeMillis(); //Se crea una variable de tipo Long y se le asigna el valor de System.currentTimeMillis()
        Timestamp timestamp = new Timestamp(datetime);
        MdlProductos mdlproducto = new MdlProductos();
        CtrlProductos ctrlproducto = new CtrlProductos();
        mdlproducto.setId(Integer.parseInt(lblId.getText()));
        mdlproducto.setDescripcion(txtDescripcion.getText());
        mdlproducto.setNameProduct(TxtNombreProductoEditar.getText());
        mdlproducto.setUpdateTime(timestamp);
        mdlproducto.setPrice(Float.parseFloat(TxtPrecioProductoEditar.getText()));
        mdlproducto.setRutaImg(lblruta.getText());
        ctrlproducto.EditarProducto(mdlproducto);
        this.setVisible(false);
        VstProductos productos = new VstProductos();
    }

    public void CambiarImagen() {
        if (seleccionado.showDialog(null, "Abrir Imagen") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionado.getSelectedFile();
            lblruta.setText(String.valueOf(archivo));
            if (archivo.canRead()) {
                String ruta = archivo.getName().toLowerCase();
                if (ruta.endsWith("jpg") || ruta.endsWith("png") || ruta.endsWith("gif") || ruta.endsWith("jpeg")) {
                    rsscalelabel.RSScaleLabel.setScaleLabel(lblImagen, lblruta.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Por Favor Seleccione Un Archivo De Imagen");
                }
            }
        }
    }

    
    public void Confirmacion() {

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios?");

        if (confirmacion == 0) {
            editarProducto();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtNombreProductoEditar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtPrecioProductoEditar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtnAceptarEditar = new javax.swing.JButton();
        BtnCancelarEditar = new javax.swing.JButton();
        btnCambiarImg = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        lblruta = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(714, 520));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 30));

        TxtNombreProductoEditar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxtNombreProductoEditar.setBorder(null);
        TxtNombreProductoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreProductoEditarActionPerformed(evt);
            }
        });
        TxtNombreProductoEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreProductoEditarKeyTyped(evt);
            }
        });
        jPanel1.add(TxtNombreProductoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 230, 30));

        TxtPrecioProductoEditar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        TxtPrecioProductoEditar.setBorder(null);
        TxtPrecioProductoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPrecioProductoEditarActionPerformed(evt);
            }
        });
        TxtPrecioProductoEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPrecioProductoEditarKeyTyped(evt);
            }
        });
        jPanel1.add(TxtPrecioProductoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 240, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 230, 30));

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 370, 330));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Imagen:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 80, 30));

        BtnAceptarEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnAceptarEditar.setText("Actualizar");
        BtnAceptarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 100, 40));

        BtnCancelarEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnCancelarEditar.setText("Cancelar");
        BtnCancelarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCancelarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 100, 40));

        btnCambiarImg.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCambiarImg.setText("Cambiar imagen");
        btnCambiarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarImgActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 30));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, 20));

        lblfecha.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblfechaComponentAdded(evt);
            }
        });
        jPanel1.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 180, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setBorder(null);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de modificación:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        lblruta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblruta.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblrutaComponentAdded(evt);
            }
        });
        jPanel1.add(lblruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 240, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 240, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 250, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 700, 470));

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
        getContentPane().add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreProductoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreProductoEditarActionPerformed

    }//GEN-LAST:event_TxtNombreProductoEditarActionPerformed

    private void TxtPrecioProductoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPrecioProductoEditarActionPerformed

    }//GEN-LAST:event_TxtPrecioProductoEditarActionPerformed

    private void BtnAceptarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarEditarActionPerformed
        Confirmacion();
    }//GEN-LAST:event_BtnAceptarEditarActionPerformed

    private void BtnCancelarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarEditarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnCancelarEditarActionPerformed

    private void btnCambiarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarImgActionPerformed
        CambiarImagen();
    }//GEN-LAST:event_btnCambiarImgActionPerformed

    private void TxtNombreProductoEditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreProductoEditarKeyTyped
//         Validar ingreso de caracteres
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtNombreProductoEditarKeyTyped

    private void TxtPrecioProductoEditarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPrecioProductoEditarKeyTyped
//        Validar ingreso de numeros
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (TxtPrecioProductoEditar.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_TxtPrecioProductoEditarKeyTyped

    private void lblfechaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lblfechaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblfechaComponentAdded

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lblrutaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_lblrutaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblrutaComponentAdded

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstEditar_Producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnAceptarEditar;
    public javax.swing.JButton BtnCancelarEditar;
    public javax.swing.JTextField TxtNombreProductoEditar;
    public javax.swing.JTextField TxtPrecioProductoEditar;
    private javax.swing.JButton btnCambiarImg;
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
    private javax.swing.JLabel lblId;
    public javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblruta;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
