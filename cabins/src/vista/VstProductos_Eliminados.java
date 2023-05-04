package Vista;

import conexion.conexionMensaje;
import Controlador.CtrlProductos;
import Modelo.MdlProductos;
import VstRecursos.RenderTable;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SENA
 */
public class VstProductos_Eliminados extends vista.VstBase {
DefaultTableModel diseñoTablaEliminados=new DefaultTableModel(){public boolean isCellEditable(int row, int column){
            return false;}
    };
    ArrayList<MdlProductos> listaProductosEliminado = new ArrayList();
    conexion.conexionMensaje con = new conexionMensaje();
    conexion.conexionMensaje connect = new conexionMensaje();
    int idRetornar = 0;
    
    public VstProductos_Eliminados() {
        initComponents();
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
     System.exit(0);
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
public void atrasExited(java.awt.event.MouseEvent evt){
           btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/atrasBlanco.png")));
}
public void atrasEntered(java.awt.event.MouseEvent evt){
           btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/atrasNegro.png")));
        }
 public void CargarTabla(){
        CtrlProductos controlx=new CtrlProductos();
        listaProductosEliminado=controlx.consultaProductosEliminados();
        llenar_Tabla(listaProductosEliminado);  
    }
    
    public void llenar_Tabla(ArrayList<MdlProductos> listaProductosEliminado) {
       tdlDatosEliminados.setDefaultRenderer(Object.class, new RenderTable());
               
            JButton botonRestaurar=new JButton("Restaurar");
            botonRestaurar.setName("btnRestaurar");
            
    JButton botonBorrar=new JButton("Borrar");
    botonBorrar.setName("btnBorrar");
    
    String[] titulo=new String[]{"Nombre","Precio","  ", " "};
      diseñoTablaEliminados.setColumnIdentifiers(titulo);
      
      tdlDatosEliminados.setModel(diseñoTablaEliminados);
      tdlDatosEliminados.setRowHeight(30);
        for (int consecutivo = 0; consecutivo < listaProductosEliminado.size(); consecutivo++) {
            diseñoTablaEliminados.addRow(new Object[consecutivo]);
            tdlDatosEliminados.setValueAt(listaProductosEliminado.get(consecutivo).getNameProduct(), consecutivo, 0);
            tdlDatosEliminados.setValueAt(listaProductosEliminado.get(consecutivo).getPrice(), consecutivo,1);
            tdlDatosEliminados.setValueAt(listaProductosEliminado.get(consecutivo).getId(), consecutivo,2);
            tdlDatosEliminados.setValueAt(botonRestaurar, consecutivo,2);
            tdlDatosEliminados.setValueAt(botonBorrar, consecutivo,3);       
        }
    }
    
    public void traerDato(int idx){
        CtrlProductos control = new CtrlProductos();
        MdlProductos  producto = new MdlProductos();
    }
        public void preguntaRestaurar(int idRetornar){
        int btnPregunta=JOptionPane.showConfirmDialog( this, "Estas seguro de querer restaurar este producto?","ADVERTENCIA",btnPregunta=0);
            if(btnPregunta==JOptionPane.YES_OPTION){
            CtrlProductos control = new CtrlProductos();
            MdlProductos producto = new MdlProductos();
            
            control.restaurar(producto,Traerid());
            limpiar_Tabla();
            CargarTabla();
        }
           
           //aqui debe de ir el metodo de restaurar el producto
        else{
            remove(btnPregunta);
        }
    }
     public void preguntaBorrar(int idRetornar){
        int btnPregunta=JOptionPane.showConfirmDialog( this, "Estas seguro de querer borrar este producto de forma definitiva?, no podra recuperar esta información","ADVERTENCIA",btnPregunta=0);
        if(btnPregunta==JOptionPane.YES_OPTION){
            CtrlProductos control = new CtrlProductos();
            MdlProductos producto = new MdlProductos();
            
            control.borrar(producto,Traerid());
            
        }else{
            remove(btnPregunta);
        }
    }
   
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
            java.util.logging.Logger.getLogger(VstProductos_Eliminados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstProductos_Eliminados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstProductos_Eliminados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstProductos_Eliminados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstProductos_Eliminados().setVisible(true);
            }
        });
    }
    
    public int Traerid(){
    
   for ( int posicion = 0;posicion < listaProductosEliminado.size(); posicion++){
                          if (tdlDatosEliminados.getSelectedRow() == posicion){
                              idRetornar = listaProductosEliminado.get(posicion).getId();
                          }
                          
                      } 
   return idRetornar;
   
}
 public void limpiar_Tabla() {
diseñoTablaEliminados.setRowCount(0);

    }
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tdlDatosEliminados = new javax.swing.JTable();
        btn_atras = new javax.swing.JButton();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdlDatosEliminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nombre del producto", "Precio", ""
            }
        ));
        tdlDatosEliminados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdlDatosEliminadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tdlDatosEliminados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 550, 360));

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/atrasBlanco.png"))); // NOI18N
        btn_atras.setContentAreaFilled(false);
        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_atrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_atrasMouseExited(evt);
            }
        });
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tdlDatosEliminadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdlDatosEliminadosMouseClicked
     int column;
        column = tdlDatosEliminados.getColumnModel().getColumnIndexAtX(evt.getX());
        int row= evt.getY()/tdlDatosEliminados.getRowHeight();
        
        if(row<tdlDatosEliminados.getRowCount() && row>=0 && column<tdlDatosEliminados.getColumnCount() &&column>=0){
            Object objeto_renderizable=tdlDatosEliminados.getValueAt(row, column);
            if(objeto_renderizable instanceof JButton){
                ((JButton) objeto_renderizable).doClick();
                JButton boton = (JButton)objeto_renderizable;
                if(boton.getName().equals("btnRestaurar")){
                    Traerid();
        preguntaRestaurar(idRetornar);
                }
                if(boton.getName().equals("btnBorrar")){
                Traerid();
                preguntaBorrar(idRetornar);
                }
            }
        }
    }//GEN-LAST:event_tdlDatosEliminadosMouseClicked

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        this.setVisible(false);
        new VstProductos().setVisible(true);
    }//GEN-LAST:event_btn_atrasActionPerformed

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

    private void btn_atrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_atrasMouseEntered
        atrasEntered(evt);
    }//GEN-LAST:event_btn_atrasMouseEntered

    private void btn_atrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_atrasMouseExited
        atrasExited(evt);
    }//GEN-LAST:event_btn_atrasMouseExited

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JTable tdlDatosEliminados;
    // End of variables declaration//GEN-END:variables
}
