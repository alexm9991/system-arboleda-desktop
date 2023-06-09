package vista;

import Controlador.CtrlProductos;
import Modelo.MdlProductos;
import conexion.conexionMensaje;
import VstRecursos.RenderTable;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VstProductos extends vista.VstBase{

    DefaultTableModel diseñoTabla = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ArrayList<MdlProductos> listaProductos = new ArrayList();
    conexion.conexionMensaje con = new conexionMensaje();
    conexion.conexionMensaje connect = new conexionMensaje();
    int filaseleccionada;

    int idRetornar = 0;

    public VstProductos() {
        this.setLocationRelativeTo(null);
        initComponents();
        bordePantalla();
        CargarTabla();
        getContentPane().setBackground(new Color(255, 255, 255));
    }
    
public void salirEntered(java.awt.event.MouseEvent evt){
           lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
        }
public void salirExited(java.awt.event.MouseEvent evt){
           lbl_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
        }
public void cerrarVentana(java.awt.event.MouseEvent evt){
        this.dispose();
}
public void crearEntered(java.awt.event.MouseEvent evt){
           btn_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/crearProductoColor.png")));
        }
public void crearExited(java.awt.event.MouseEvent evt){
           btn_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/crearProductoBlanco.png")));
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

    public void CargarTabla() {
        CtrlProductos control = new CtrlProductos();
        listaProductos = control.consultaProductos();
        llenar_Tabla(listaProductos);
    }

    public void llenar_Tabla(ArrayList<MdlProductos> listaProductos) {
        tdlDatos.setDefaultRenderer(Object.class, new RenderTable());

        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.setName("btnActualizar");

        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setName("btnEliminar");

        String[] titulo = new String[]{"Nombre", "Precio", "  ", " "};
        diseñoTabla.setColumnIdentifiers(titulo);
        tdlDatos.setModel(diseñoTabla);
        tdlDatos.setRowHeight(30);
        for (int consecutivo = 0; consecutivo < listaProductos.size(); consecutivo++) {
            diseñoTabla.addRow(new Object[consecutivo]);
            tdlDatos.setValueAt(listaProductos.get(consecutivo).getNameProduct(), consecutivo, 0);
            tdlDatos.setValueAt(listaProductos.get(consecutivo).getPrice(), consecutivo, 1);
            tdlDatos.setValueAt(listaProductos.get(consecutivo).getId(), consecutivo, 2);
            tdlDatos.setValueAt(botonActualizar, consecutivo, 2);
            tdlDatos.setValueAt(botonEliminar, consecutivo, 3);   
        }
    }
   public void limpiar_Tabla() {
diseñoTabla.setRowCount(0);

    }
    public void preguntaEliminar(int idx) {
        int btnPregunta = JOptionPane.showConfirmDialog(this, "Estas seguro de querer eliminar este producto", "ADVERTENCIA", btnPregunta = 0);
        if (btnPregunta == JOptionPane.YES_OPTION) {
            CtrlProductos control = new CtrlProductos();
            MdlProductos producto = new MdlProductos();
            control.eliminar(producto, idx);
            limpiar_Tabla();
            CargarTabla();
        } else {
            remove(btnPregunta);
        }
    }

    public void Traerid() {
        for (int posicion = 0; posicion < listaProductos.size(); posicion++) {
            if (tdlDatos.getSelectedRow() == posicion) {
                idRetornar = listaProductos.get(posicion).getId();
            }
        }
    }

    public void Pregunta_Restaurar() {
        JOptionPane.showMessageDialog(null, "De click en la pestaña de opciones y elija la papelera, \n"
                + "verifique el nombre del producto a restaurar y de click sobre el boton 'Restaurar'");
    }

    public void Pregunta_Borrar() {
        JOptionPane.showMessageDialog(null, "Elija el producto a eliminar y \n"
                + "de click sobre el boton 'Eliminar'");
    }

    public void Pregunta_Agregar() {
        JOptionPane.showMessageDialog(null, "De click en el boton 'Crear'  \n"
                + "que se encuentra en la parte superior \n"
                + "y llene toda la información del producto");
    }

    public void Pregunta_Modificar() {
        JOptionPane.showMessageDialog(null, "Elija el producto que desea modificar y \n"
                + "de click sobre el boton 'Actualizar'");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_minimizar = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_crear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdlDatos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 30, 30));

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
        getContentPane().add(lbl_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 20));

        btn_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/crearProductoBlanco.png"))); // NOI18N
        btn_crear.setToolTipText("Crear");
        btn_crear.setBorder(null);
        btn_crear.setContentAreaFilled(false);
        btn_crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_crearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_crearMouseExited(evt);
            }
        });
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 70));

        tdlDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del producto", "Precio", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tdlDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdlDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdlDatos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 550, 310));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        jButton2.setToolTipText("Refrescar");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 70));

        jMenu1.setText("Options");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setText("Papelera");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setText("Restaurar un Producto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Agregar un Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Eliminar un Producto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Modificar un Producto");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        new VstAgregar_Producto().setVisible(true);
    }//GEN-LAST:event_btn_crearActionPerformed

    private void tdlDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdlDatosMouseClicked
        int column;

        column = tdlDatos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tdlDatos.getRowHeight();

        if (row < tdlDatos.getRowCount() && row >= 0 && column < tdlDatos.getColumnCount() && column >= 0) {
            Object objeto_renderizable = tdlDatos.getValueAt(row, column);
            if (objeto_renderizable instanceof JButton) {
                ((JButton) objeto_renderizable).doClick();
                JButton boton = (JButton) objeto_renderizable;
                Traerid();
                if (boton.getName().equals("btnActualizar")) {
                    VstEditar_Producto ig = new VstEditar_Producto();

                    ig.traerDatos(idRetornar);
                    ig.setVisible(true);

                }
                if (boton.getName().equals("btnEliminar")) {
                    preguntaEliminar(idRetornar);

                }
            }
        }
    }//GEN-LAST:event_tdlDatosMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        new VstProductos_Eliminados().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Pregunta_Borrar();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Pregunta_Restaurar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Pregunta_Agregar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Pregunta_Modificar();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            limpiar_Tabla();
            CargarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_crearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearMouseEntered
        crearEntered(evt);
    }//GEN-LAST:event_btn_crearMouseEntered

    private void btn_crearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_crearMouseExited
        crearExited(evt);
    }//GEN-LAST:event_btn_crearMouseExited
int xx,xy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
       xx=evt.getX();
        xy=evt.getY();
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
         int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();

        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JTable tdlDatos;
    // End of variables declaration//GEN-END:variables
}
