package vista;

import controlador.CtrServicios;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import modelo.MdlServicios;

public class VstCrearServicios extends VstBase {

    //METODOS CREAR Y LIMPIAR
    public void crear() {
        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        mdlServicio.setNombre_servicio(txt_nombre.getText());
        mdlServicio.setTotal(Integer.parseInt(spn_cantidad.getValue().toString()));
        mdlServicio.setEstado(cmb_estado.getSelectedItem().toString());
        mdlServicio.setDescripcion(txa_descripcion.getText());
        mdlServicio.setReglas(txa_reglas.getText());

        nombre_servicio = txt_nombre.getText();
        descripcion_servicio = txa_descripcion.getText();
        reglas_servicio = txa_reglas.getText();

        ctrServicios.crearServicio(mdlServicio);

        super.dispose();
        nombre_servicio = "";
        descripcion_servicio = "";
        reglas_servicio = "";
    }

    public void limpiar() {
        txt_nombre.setText("");
        spn_cantidad.setValue(((SpinnerNumberModel) spn_cantidad.getModel()).getMinimum());
        cmb_estado.setSelectedIndex(0);
        txa_descripcion.setText("");
        txa_reglas.setText("");
    }

//    //MENSAJES EMERGENTES DE CONFIMARCION
    private void confirmarCrear() {
        if (txt_nombre.getText().equals("") || cmb_estado.getSelectedItem().toString().equals("Seleccione...")
                || txa_descripcion.getText().equals("") || txa_reglas.getText().equals("") || spn_cantidad.getValue().toString().equals("0")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        } else {
            String botones[] = {"Crear", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea crear el servicio?", "Crear",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                crear();
            }
        }
    }

    private void confirmarLimpiar() {
        String botones[] = {"Limpiar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea limpiar los campos del servicio?", "Limpiar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            limpiar();
        } else if (eleccion == JOptionPane.NO_OPTION) {
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

    public void spinner() {
        SpinnerNumberModel m = new SpinnerNumberModel();
        m.setMaximum(30);
        m.setMinimum(0);
        spn_cantidad.setModel(m);
    }

    public void inicio() {
        setLocationRelativeTo(null);
        spinner();
        bordePantalla();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public VstCrearServicios() {
        initComponents();
        inicio();
    }
    public static String nombre_servicio = "";
    public static String descripcion_servicio = "";
    public static String reglas_servicio = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        spn_cantidad = new javax.swing.JSpinner();
        lbl_maximo = new javax.swing.JLabel();
        lbl_reglas = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        lbl_crear_servicio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        cmb_estado = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        lbl_estado = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        btn_crear = new javax.swing.JButton();
        lbl_editar = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txa_reglas = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
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

        jPanel1.setBackground(new java.awt.Color(255, 165, 89));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_salir, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(lbl_minimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        spn_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spn_cantidadKeyTyped(evt);
            }
        });

        lbl_maximo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_maximo.setText("Maximo de personas");

        lbl_reglas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_reglas.setText("Reglas");

        btn_limpiar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_crear_servicio.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lbl_crear_servicio.setText("CREAR SERVICIO");

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        txa_descripcion.setWrapStyleWord(true);
        txa_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txa_descripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txa_descripcion);

        cmb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ACTIVAR", "DESACTIVAR" }));
        cmb_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estadoActionPerformed(evt);
            }
        });

        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        lbl_estado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_estado.setText("Estado");

        lbl_descripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_descripcion.setText("Descripción");

        lbl_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre del servicio");

        btn_crear.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        lbl_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/crear.png"))); // NOI18N

        txa_reglas.setColumns(20);
        txa_reglas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_reglas.setLineWrap(true);
        txa_reglas.setRows(5);
        txa_reglas.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txa_reglas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_crear_servicio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_nombre)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_maximo)
                                        .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_estado)
                                        .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(83, 83, 83))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_descripcion)
                                    .addComponent(lbl_reglas)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)
                                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(651, 651, 651)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_nombre, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lbl_crear_servicio))
                                    .addComponent(lbl_editar))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_nombre)
                                    .addComponent(lbl_descripcion)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_reglas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_maximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        confirmarLimpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        super.moverVentana(evt);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        super.presionVentana(evt);
    }//GEN-LAST:event_formMousePressed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        confirmarCrear();
    }//GEN-LAST:event_btn_crearActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if (txt_nombre.getText().length() > 19) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void spn_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spn_cantidadKeyTyped

    }//GEN-LAST:event_spn_cantidadKeyTyped

    private void cmb_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estadoActionPerformed

    private void txa_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txa_descripcionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txa_descripcionKeyTyped

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_crear_servicio;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_editar;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_maximo;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_reglas;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JSpinner spn_cantidad;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextArea txa_reglas;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
