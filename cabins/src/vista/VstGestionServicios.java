package vista;

import controlador.CtrServicios;
import java.util.ArrayList;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.MdlServicios;

public class VstGestionServicios extends VstBase {

    ArrayList<MdlServicios> lista;
    DefaultTableModel modelo;

    int cantidad = 0;

    //CONSULTA LA BASE DE DATOS
    public void consultar() {
        llenarTabla();
    }

    DefaultTableModel tab = new DefaultTableModel();

    //LLENA LA TABLA CON LA INFOMACION IMPORTANTE DEL SERVICIO
    public void llenarTabla() {
        CtrServicios ctrServicios = new CtrServicios();
        DefaultTableModel tabla = new DefaultTableModel();
        tab = tabla;
        String[] fila = new String[5];
        tabla.addColumn("ID");
        tabla.addColumn("Nombre de servicio");
        tabla.addColumn("Estado");
        tabla.addColumn("Fecha de cración");
        tabla.addColumn("Fecha de modificación");

        lista = ctrServicios.consultar();
        for (int consecutivo = 0; consecutivo < lista.size(); consecutivo++) {
            fila[0] = Integer.toString(lista.get(consecutivo).getId());
            fila[1] = lista.get(consecutivo).getNombre_servicio();
            fila[2] = lista.get(consecutivo).getEstado();
            fila[3] = lista.get(consecutivo).getFecha_registro().toString();
            fila[4] = lista.get(consecutivo).getFecha_modificacion().toString();

            tabla.addRow(fila);
        }
        tbl_tabla.setModel(tabla);
    }

    //EVENTO DEL MOUSE QUE AL DARLE CLIC A UNA FILA TE LLAMA EL METODO LLENAR DATOS 
    public void traerDato() {
        MdlServicios mdlServicio = new MdlServicios();
        for (int posicion = 0; posicion < lista.size(); posicion++) {
            if (tbl_tabla.getSelectedRow() == posicion) {
                mdlServicio = lista.get(posicion);
            }
        }
    }

    //EVENTOS DE BOTONES MINIMIZAR Y CERRAR
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

    public void inicio() {
        setLocationRelativeTo(null);
        consultar();
        bordePantalla();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        modelo = new DefaultTableModel();
    }

    public VstGestionServicios() {
        initComponents();
        inicio();
    }

    public static String user_update = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lbl_registrar = new javax.swing.JLabel();
        lbl_detalle = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_salir = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        lbl_actualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de servicios");
        setBackground(new java.awt.Color(51, 51, 51));
        setSize(new java.awt.Dimension(100, 100));
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

        lbl_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/registrar.png"))); // NOI18N
        lbl_registrar.setText("jLabel1");
        lbl_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_registrarMouseClicked(evt);
            }
        });

        lbl_detalle.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lbl_detalle.setText("GESTIÓN DE SERVICIOS");

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

        tbl_tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_tabla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre del servicio", "Estado", "Fecha de creación", "Fecha de modificación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tabla);

        lbl_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refres.png"))); // NOI18N
        lbl_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_actualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_detalle)
                .addGap(153, 153, 153)
                .addComponent(lbl_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_minimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_detalle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_registrar)
                    .addComponent(lbl_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked

        int fila_point = tbl_tabla.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            user_update = (String) tab.getValueAt(fila_point, columna_point);
        }
        VstModificarServicios vstMS = new VstModificarServicios();
        vstMS.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_tbl_tablaMouseClicked

    private void lbl_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseEntered
        salirEntered(evt);
    }//GEN-LAST:event_lbl_salirMouseEntered

    private void lbl_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseExited
        salirExited(evt);
    }//GEN-LAST:event_lbl_salirMouseExited

    private void lbl_salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_salirMouseClicked
        cerrarVentana(evt);
    }//GEN-LAST:event_lbl_salirMouseClicked

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
        minimizarVentana(evt);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        minimizarEntered(evt);
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        minimizarExited(evt);
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        super.moverVentana(evt);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        super.presionVentana(evt);
    }//GEN-LAST:event_formMousePressed

    private void lbl_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_actualizarMouseClicked
        consultar();
    }//GEN-LAST:event_lbl_actualizarMouseClicked

    private void lbl_registrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_registrarMouseClicked
        VstCrearServicios vstCS = new VstCrearServicios();
        vstCS.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_lbl_registrarMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_actualizar;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_registrar;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JTable tbl_tabla;
    // End of variables declaration//GEN-END:variables
}
