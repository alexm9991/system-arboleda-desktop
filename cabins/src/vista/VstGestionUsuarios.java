package ventanas;

import com.sun.awt.AWTUtilities;
import conexion.Conectar;
import diseño.ScrollBarCustom;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VstGestionUsuarios extends javax.swing.JFrame {

    int x, y;

    public static String user_update = "";

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Gestion_Usuarios
     */
    public VstGestionUsuarios() {

        this.setUndecorated(true);

        initComponents();

        //Codigo para redondear los bordes del JFRAME, IMPORTANTE TENER "TRUE" EL this.setUndecorated
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);

        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Gestion de Usuarios - Sesion de ");

        getContentPane().setBackground(new Color(255, 255, 255));//Color Fondo del Jframe

        try {
            Connection cn = Conectar.nuevaConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "select name, identification_number, BOOKING_id from users ");

            ResultSet rs = pst.executeQuery();

            tbl_tablaUsuarios = new JTable(model);
            jScrollPane1.setViewportView(tbl_tablaUsuarios);

            jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());

            tbl_tablaUsuarios.getTableHeader().setDefaultRenderer(new HeaderColor());

            tbl_tablaUsuarios.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
            tbl_tablaUsuarios.getTableHeader().setOpaque(false);
            tbl_tablaUsuarios.getTableHeader().setBackground(new Color(32, 136, 203));
            tbl_tablaUsuarios.getTableHeader().setForeground(new Color(255, 255, 255));
            tbl_tablaUsuarios.setRowHeight(25);

            //Con las sigt lineas de codigo podemos añadir columnas y asi mismo asignarles un nombre
            model.addColumn("Nombre");
            model.addColumn("Numero Identificacion");
            model.addColumn("Codigo Reserva");

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

        tbl_tablaUsuarios.addMouseListener(new MouseAdapter() {

            @Override //Vamos a sobreescribir un metodo de una clase existente, asi que escribimos el Override
            public void mouseClicked(MouseEvent e) { //Metodo Sobreescrito, con una variable u objeto del tipo MouseEvent en el cual va a guardar de manera temporal el evento asignado

                int fila_point = tbl_tablaUsuarios.rowAtPoint(e.getPoint());//Creamos una variable entera donde va a guardar la posicion a la hora en la que lo seleccionemos con nuestro click
                int columna_point = 0; //Creamos la variable para la guardar la posicion de la columna, en este caso siempre va ser la posicion 2

                //Posterior generamos una estructura condicional para que el programa sepa que tiene que hacer cuando se haya obtenido la posicion tanto de la fila como de la columna
                if (fila_point > -1) {   //Aqui estamos diciendo que si la variable fila es mayor a -1, (recordemos que las posiciones empiezan desde 0 entonces no puede haber una posicion -1) se ejecute la accion.

                    user_update = (String) model.getValueAt(fila_point, columna_point); //Pasamos estos valores a la variable statica que creamos antes
                    
                    new Informacion_Usuarios().setVisible(true); //con esta linea abrimos la interfaz de la informacion del usuario seleccionado

                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tablaUsuarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_crear = new javax.swing.JLabel();
        lbl_cerrar = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        lbl_logo.setBackground(new java.awt.Color(255, 255, 255));
        lbl_logo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa16px.png"))); // NOI18N
        lbl_logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 20, 20));

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setBorder(null);
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, 220, -1));

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
                {null, null, null}
            },
            new String [] {
                "Nombre", "Numero Identificacion", "Codigo Reserva"
            }
        ));
        tbl_tablaUsuarios.setFocusable(false);
        tbl_tablaUsuarios.setRowHeight(15);
        tbl_tablaUsuarios.setSelectionBackground(new java.awt.Color(162, 222, 244));
        tbl_tablaUsuarios.setShowVerticalLines(false);
        tbl_tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_tablaUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 530, 310));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 142, 240, -1));

        lbl_crear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadirOFF.png"))); // NOI18N
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
        getContentPane().add(lbl_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 70, 70));

        lbl_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/errorBlanco.png"))); // NOI18N
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
        getContentPane().add(lbl_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 20, 20));

        lbl_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloBlanco.png"))); // NOI18N
        lbl_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_minimizarMouseExited(evt);
            }
        });
        getContentPane().add(lbl_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 20, 20));

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
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadirON.png")));
    }//GEN-LAST:event_lbl_crearMouseEntered

    private void lbl_crearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseExited
        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadirOFF.png")));
    }//GEN-LAST:event_lbl_crearMouseExited

    private void lbl_crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseClicked
        añadirPersonas añadir = new añadirPersonas();
        añadir.setVisible(true);
    }//GEN-LAST:event_lbl_crearMouseClicked

    private void lbl_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_cerrarMouseClicked

    private void lbl_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseEntered
        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/errorNegro.png")));
    }//GEN-LAST:event_lbl_cerrarMouseEntered

    private void lbl_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_cerrarMouseExited

        lbl_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/errorBlanco.png")));
    }//GEN-LAST:event_lbl_cerrarMouseExited

    private void lbl_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseEntered

        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloNegro.png")));

    }//GEN-LAST:event_lbl_minimizarMouseEntered

    private void lbl_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizarMouseExited
        lbl_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloBlanco.png")));    }//GEN-LAST:event_lbl_minimizarMouseExited

    private void lbl_logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoMouseClicked


    }//GEN-LAST:event_lbl_logoMouseClicked

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
            java.util.logging.Logger.getLogger(VstGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VstGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VstGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VstGestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VstGestionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cerrar;
    private javax.swing.JLabel lbl_crear;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_minimizar;
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

            setBackground(new java.awt.Color(32, 136, 203));
            setFont(new Font("Verdana", Font.CENTER_BASELINE, 12));
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(100, 100);
            setPreferredSize(new Dimension(80, 30));
            //you can change the color that u want 
            return this;
        }
    }

}
