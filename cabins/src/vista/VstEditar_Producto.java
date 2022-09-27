package Vista;

import conexion.conexionMensaje;
import Controlador.CtrlProductos;
import Vista.VstProductos;
import Modelo.MdlProductos;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import javax.swing.*;


public final class VstEditar_Producto extends javax.swing.JFrame  {

    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    byte[] byteImg;
    CtrlProductos gestion = new CtrlProductos();
    conexion.conexionMensaje con = new conexionMensaje();
    conexion.conexionMensaje connect = new conexionMensaje();
    ArrayList<MdlProductos> listaProductosActualizar = new ArrayList();
    Long datetime = System.currentTimeMillis(); 
        Timestamp timestamp = new Timestamp(datetime);
    public VstEditar_Producto() {
        
        this.setLocationRelativeTo(null);
       
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
 int i = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios?", "CONFIRMACIÓN", i = 0);
        if (i == JOptionPane.YES_OPTION) {
            editarProducto();
        }else if (i == 1 || i == 2) {
            JOptionPane.showMessageDialog(null, "Producto No Editado");
       }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(714, 520));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1105, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 30, 30));

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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 30, 30));

        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, 0, 1400, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 230, 30));

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
        jPanel1.add(TxtNombreProductoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 220, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 230, 30));

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
        jPanel1.add(TxtPrecioProductoEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 220, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Descripción:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 230, 30));

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 450, 290));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Imagen:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 80, 30));

        BtnAceptarEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnAceptarEditar.setText("Actualizar");
        BtnAceptarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAceptarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 120, 40));

        BtnCancelarEditar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BtnCancelarEditar.setText("Cancelar");
        BtnCancelarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCancelarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 100, 40));

        btnCambiarImg.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnCambiarImg.setText("Cambiar imagen");
        btnCambiarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarImgActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 180, 30));
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 20, 20));

        lblfecha.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblfechaComponentAdded(evt);
            }
        });
        jPanel1.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 180, 20));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setBorder(null);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 220, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de modificación:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        lblruta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblruta.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                lblrutaComponentAdded(evt);
            }
        });
        jPanel1.add(lblruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 250, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 250, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 250, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 250, 20));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setText("EDITAR PRODUCTO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/firma.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/signoDolares.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/descripcion.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 810, 520));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 600));

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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
      
    }//GEN-LAST:event_jPanel1MouseDragged
int x,y;
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
       int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        this.setLocation(X - x, Y - y);
    }//GEN-LAST:event_jPanel3MouseDragged
    
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
