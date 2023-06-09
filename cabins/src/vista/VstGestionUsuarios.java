package vista;

import com.sun.awt.AWTUtilities;
import conexion.*;
import utilidades.ScrollBarCustom;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import vista.VstCrearUsuarios;

public class VstGestionUsuarios extends javax.swing.JFrame {

    int x, y;

    public static String user_update = "";
    public static boolean ventanaOpen;
    
      

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Gestion_Usuarios
     */
    public VstGestionUsuarios() {
  
        Connection cn = conexionMensaje.getConnection();
        this.setUndecorated(true);

        initComponents();

        //Codigo para redondear los bordes del JFRAME, IMPORTANTE TENER "TRUE" EL this.setUndecorated
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);

        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(255, 255, 255));//Color Fondo del Jframe

       
        try {
            
            PreparedStatement pst = cn.prepareStatement(
                    "select name, identification_number, phone_number from users where state_record = 'ACTIVAR' ");

            ResultSet rs = pst.executeQuery();

            tbl_tablaUsuarios = new JTable(model);
            jScrollPane1.setViewportView(tbl_tablaUsuarios);

            jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());

            tbl_tablaUsuarios.getTableHeader().setDefaultRenderer(new HeaderColor());

            tbl_tablaUsuarios.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
            tbl_tablaUsuarios.getTableHeader().setOpaque(false);
            tbl_tablaUsuarios.getTableHeader().setBackground(new Color(255,230,199));
            tbl_tablaUsuarios.getTableHeader().setForeground(new Color(255, 255, 255));
            tbl_tablaUsuarios.setRowHeight(25);

            //Con las sigt lineas de codigo podemos añadir columnas y asi mismo asignarles un nombre
            model.addColumn("Nombre");
            model.addColumn("Numero Identificacion");
            model.addColumn("Contacto");

            //Ahora necesitamos de un ciclo repetitivo para que recorra todos los datos que se obtenga de la base de datos
            while (rs.next()) { //con esta condicion estamos diciendo que mientras encuentre informacion en la BD se siga ciclando hasta que no haya nada
                Object[] fila = new Object[3]; //Con este vector le indicamos el tamaño de columnas que hay 

                for (int i = 0; i < 3; i++) { //Con esto le indicamos que i empieza desde cero hasta que llegue a 5 porque son 5 columnas y asi se va recorriendo los datos en la posicion indicada
                    fila[i] = rs.getObject(i + 1); //Aqui la fila empieza recorrer en su posicion correspondiente

                }
                model.addRow(fila); //De esta forma estariamos agregando la fila que hayamos encontrado dentro del objeto model
            }
            
        } catch (SQLException e) {
            System.err.println("ERROR al llenar tabla." + e);
            JOptionPane.showMessageDialog(null, "ERROR al mostrar informacion, Contacte al Administrador!");
        }

        ventanaOpen = true;
                
                VstInformacionUsuarios detallesUsuarios = new VstInformacionUsuarios();
                if (detallesUsuarios.isVisible()) {
                    ventanaOpen = false;
                }
        tbl_tablaUsuarios.addMouseListener(new MouseAdapter() {
            
            @Override //Vamos a sobreescribir un metodo de una clase existente, asi que escribimos el Override
            public void mouseClicked(MouseEvent e) { //Metodo Sobreescrito, con una variable u objeto del tipo MouseEvent en el cual va a guardar de manera temporal el evento asignado

                
                
                int fila_point = tbl_tablaUsuarios.rowAtPoint(e.getPoint());//Creamos una variable entera donde va a guardar la posicion a la hora en la que lo seleccionemos con nuestro click
                int columna_point = 0; //Creamos la variable para la guardar la posicion de la columna, en este caso siempre va ser la posicion 2

                //Posterior generamos una estructura condicional para que el programa sepa que tiene que hacer cuando se haya obtenido la posicion tanto de la fila como de la columna
                if (fila_point > -1) {   //Aqui estamos diciendo que si la variable fila es mayor a -1, (recordemos que las posiciones empiezan desde 0 entonces no puede haber una posicion -1) se ejecute la accion.

                    user_update = (String) model.getValueAt(fila_point, columna_point); //Pasamos estos valores a la variable statica que creamos antes

                    if (ventanaOpen != false) {                                                
                      new VstInformacionUsuarios().setVisible(true); //con esta linea abrimos la interfaz de la informacion del usuario seleccionado      
                     }                
                }
            }
        });      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_lupa = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tablaUsuarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_crear = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_refrescar = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(719, 778));
        setSize(new java.awt.Dimension(1000, 800));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("GESTION DE USUARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        lbl_lupa.setBackground(new java.awt.Color(255, 255, 255));
        lbl_lupa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_lupa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search16.png"))); // NOI18N
        lbl_lupa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_lupa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_lupaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_lupaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_lupaMouseExited(evt);
            }
        });
        getContentPane().add(lbl_lupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 30, 20));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setBorder(null);
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 125, 200, -1));

        tbl_tablaUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 36))); // NOI18N
        tbl_tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Numero Identificacion", "Codigo Reserva"
            }
        ));
        tbl_tablaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_tablaUsuarios.setFocusable(false);
        tbl_tablaUsuarios.setRowHeight(15);
        tbl_tablaUsuarios.setSelectionBackground(new java.awt.Color(255, 230, 199));
        tbl_tablaUsuarios.setSelectionForeground(new java.awt.Color(255, 230, 199));
        tbl_tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_tablaUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 720, 590));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 142, 240, -1));

        lbl_crear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/añadirOFF.png"))); // NOI18N
        lbl_crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_crearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_crearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_crearMouseExited(evt);
            }
        });
        getContentPane().add(lbl_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 70, 70));

        lbl_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png"))); // NOI18N
        lbl_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_cerrarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 20, 20));

        lbl_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png"))); // NOI18N
        lbl_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 20, 20));

        lbl_refrescar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        lbl_refrescar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_refrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_refrescarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_refrescarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_refrescarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_refrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 50, 50));

        lbl_fondo.setBackground(new java.awt.Color(204, 255, 255));
        lbl_fondo.setForeground(new java.awt.Color(51, 102, 255));
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int X = evt.getXOnScreen();
        int Y = evt.getYOnScreen();
        this.setLocation(X - x, Y - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        txtBuscar.setLayout(new BorderLayout());
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void lbl_crearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseEntered
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/añadirON.png")));
    }//GEN-LAST:event_lbl_crearMouseEntered

    private void lbl_crearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseExited
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/añadirOFF.png")));
    }//GEN-LAST:event_lbl_crearMouseExited

    private void lbl_crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseClicked
        VstCrearUsuarios crear = new VstCrearUsuarios();
        crear.setVisible(true);
    }//GEN-LAST:event_lbl_crearMouseClicked

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        setVisible(false);
       // System.exit(0);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void lbl_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseEntered
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorNegro.png")));
    }//GEN-LAST:event_lbl_cerrarMouseEntered

    private void lbl_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseExited
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/errorBlanco.png")));
    }//GEN-LAST:event_lbl_cerrarMouseExited

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloNegro.png")));
    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_lupaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_lupaMouseClicked
         refrescarTabla();
         String buscar = txtBuscar.getText().trim();
         filtrarBusquedad(buscar);
    }//GEN-LAST:event_lbl_lupaMouseClicked

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
       
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/circuloBlanco.png")));
    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_refrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refrescarMouseClicked
        refrescarTabla();
        llenarTabla();
    }//GEN-LAST:event_lbl_refrescarMouseClicked

    private void lbl_refrescarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refrescarMouseEntered
       lbl_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh40px.png")));
    }//GEN-LAST:event_lbl_refrescarMouseEntered

    private void lbl_refrescarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_refrescarMouseExited
        lbl_refrescar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png")));
    }//GEN-LAST:event_lbl_refrescarMouseExited

    private void lbl_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseClicked
         setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lbl_minimizarMouseClicked

    private void lbl_lupaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_lupaMouseEntered
        lbl_lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search20.png")));
    }//GEN-LAST:event_lbl_lupaMouseEntered

    private void lbl_lupaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_lupaMouseExited
        lbl_lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search16.png")));
    }//GEN-LAST:event_lbl_lupaMouseExited

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        lbl_lupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search20.png")));
    }//GEN-LAST:event_txtBuscarMouseClicked

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_crear;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_lupa;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_refrescar;
    private javax.swing.JTable tbl_tablaUsuarios;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            setBackground(new java.awt.Color(255, 165, 89));
            setFont(new Font("Verdana", Font.CENTER_BASELINE, 12));
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(100, 100);
            setPreferredSize(new Dimension(80, 30));
            //you can change the color that u want 
            return this;
        }
    }

    public void llenarTabla() {

        try {
            Connection cn = conexionMensaje.nuevaConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select name, identification_number, phone_number from users where state_record = 'ACTIVAR' ");

            ResultSet rs = pst.executeQuery();

            //Ahora necesitamos de un ciclo repetitivo para que recorra todos los datos que se obtenga de la base de datos
            while (rs.next()) { //con esta condicion estamos diciendo que mientras encuentre informacion en la BD se siga ciclando hasta que no haya nada
                Object[] fila = new Object[3]; //Con este vector le indicamos el tamaño de columnas que hay 

                for (int i = 0; i < 3; i++) { //Con esto le indicamos que i empieza desde cero hasta que llegue a 5 porque son 5 columnas y asi se va recorriendo los datos en la posicion indicada
                    fila[i] = rs.getObject(i + 1); //Aqui la fila empieza recorrer en su posicion correspondiente

                }
                model.addRow(fila); //De esta forma estariamos agregando la fila que hayamos encontrado dentro del objeto model
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR al llenar tabla." + e);
            JOptionPane.showMessageDialog(null, "ERROR al mostrar informacion, Contacte al Administrador!");
        }
    }
    
    public void filtrarBusquedad(String filtro){
        try {
            Connection cn = conexionMensaje.nuevaConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select name, identification_number, phone_number from users where name = '"+filtro+"'");

            ResultSet rs = pst.executeQuery();

            //Ahora necesitamos de un ciclo repetitivo para que recorra todos los datos que se obtenga de la base de datos
            while (rs.next()) { //con esta condicion estamos diciendo que mientras encuentre informacion en la BD se siga ciclando hasta que no haya nada
                Object[] fila = new Object[3]; //Con este vector le indicamos el tamaño de columnas que hay 

                for (int i = 0; i < 3; i++) { //Con esto le indicamos que i empieza desde cero hasta que llegue a 5 porque son 5 columnas y asi se va recorriendo los datos en la posicion indicada
                    fila[i] = rs.getObject(i + 1); //Aqui la fila empieza recorrer en su posicion correspondiente

                }
                model.addRow(fila); //De esta forma estariamos agregando la fila que hayamos encontrado dentro del objeto model
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("ERROR al llenar tabla." + e);
            JOptionPane.showMessageDialog(null, "No hay información, Contacte al Administrador!");
        }
    }

    public void refrescarTabla() {
        model.setRowCount(0);
    }

}
