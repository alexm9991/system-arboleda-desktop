package vista;

import controlador.CtrServicios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import modelo.MdlServicios;

public class VstModificarServicios extends VstBase {

    public void traerDato() {
        MdlServicios mdlServicio = new MdlServicios();
        llenarDatos(mdlServicio);
    }

    //OBTIENE LOS DATOS DE LA TABLA Y LOS MUESTRA EN LOS CAMPOS DE LA INTERFAZ
    public void llenarDatos(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
        ctrServicios.consultarModificar(servicio);

        txt_id.setText(String.valueOf(servicio.getId()));
        txt_nombre.setText(servicio.getNombre_servicio());
        txa_descripcion.setText(servicio.getDescripcion());
        spn_cantidad.setValue(servicio.getTotal());
        txa_reglas.setText(servicio.getReglas());

        if (servicio.getEstado().equals("ACTIVAR")) {
            cmb_estado.setSelectedIndex(1);
        } else {
            if (servicio.getEstado().equals("DESACTIVAR")) {
                cmb_estado.setSelectedIndex(2);
            }
        }
        llenarTablaDetalles(servicio);
    }

    ArrayList<MdlServicios> listaDetalles;
    DefaultTableModel modelo;

    //LLENA LA TABLA CON LA INFOMACION IMPORTANTE DEL SERVICIO
    DefaultTableModel tab = new DefaultTableModel();
    public void llenarTablaDetalles(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
        DefaultTableModel tabla = new DefaultTableModel();
        tab = tabla;
        String[] fila = new String[2];
        tabla.addColumn("ID");
        tabla.addColumn("Nombre del detalle");

        listaDetalles = ctrServicios.consultarDetalles(servicio);
        for (int consecutivo = 0; consecutivo < listaDetalles.size(); consecutivo++) {
            fila[0] = Integer.toString(listaDetalles.get(consecutivo).getId());
            fila[1] = listaDetalles.get(consecutivo).getNombre_detalle_servicio();
            tabla.addRow(fila);
        }
        tbl_detalles.setModel(tabla);
    }

    public void modificar() {
        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        mdlServicio.setId(Integer.parseInt(txt_id.getText()));
        mdlServicio.setNombre_servicio(txt_nombre.getText());
        mdlServicio.setTotal(Integer.parseInt(spn_cantidad.getValue().toString()));
        mdlServicio.setEstado(cmb_estado.getSelectedItem().toString());
        mdlServicio.setDescripcion(txa_descripcion.getText());
        mdlServicio.setReglas(txa_reglas.getText());

        ctrServicios.modificarServicio(mdlServicio);
        super.dispose();
        
    }

    public void limpiar() {
        txt_nombre.setText("");
        spn_cantidad.setValue(((SpinnerNumberModel) spn_cantidad.getModel()).getMinimum());
        cmb_estado.setSelectedIndex(0);
        txa_descripcion.setText("");
        txa_reglas.setText("");
    }

//    //MENSAJES EMERGENTES DE CONFIMARCION
    private void confirmarModificar() {
        if (txt_nombre.getText().equals("") || cmb_estado.getSelectedItem().toString().equals("Seleccione...")
                || txa_descripcion.getText().equals("") || txa_reglas.getText().equals("") || spn_cantidad.getValue().toString().equals("0")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        } else {
            String botones[] = {"Modificar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea modificar el servicio?", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, this);          
            if (eleccion == JOptionPane.YES_OPTION) {
                modificar();
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
        modelo = new DefaultTableModel();
        traerDato();
    }

    public VstModificarServicios() {
        initComponents();
        inicio();
    }
    public static String user_update = "";
    public static String id_servicio = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_ruta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        spn_cantidad = new javax.swing.JSpinner();
        lbl_maximo = new javax.swing.JLabel();
        lbl_imagenes = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        lbl_detalle_servicios = new javax.swing.JLabel();
        lbl_detalle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        cmb_estado = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        lbl_estado = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        lbl_editar = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txa_reglas = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_detalles = new javax.swing.JTable();
        txt_id = new javax.swing.JLabel();
        lbl_crear = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_actualizar = new javax.swing.JLabel();

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
            .addGap(0, 0, Short.MAX_VALUE)
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

        lbl_imagenes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_imagenes.setText("Reglas");

        btn_limpiar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        lbl_detalle_servicios.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_detalle_servicios.setText("Detalles de servicios");

        lbl_detalle.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lbl_detalle.setText("MODIFICAR SERVICIO");

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        txa_descripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txa_descripcion);

        cmb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "ACTIVAR", "DESACTIVAR" }));

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

        btn_modificar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        lbl_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar.png"))); // NOI18N

        txa_reglas.setColumns(20);
        txa_reglas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_reglas.setLineWrap(true);
        txa_reglas.setRows(5);
        txa_reglas.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txa_reglas);

        tbl_detalles.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_detalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "DETALLES DEL SERVICIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_detalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_detallesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_detalles);

        lbl_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/registrar_detalle.png"))); // NOI18N
        lbl_crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_crearMouseClicked(evt);
            }
        });

        lbl_codigo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_codigo.setText("Codigo");

        lbl_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refres_detalle.png"))); // NOI18N
        lbl_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_actualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_detalle)
                        .addGap(434, 434, 434)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_nombre)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_codigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94))
                                .addComponent(lbl_maximo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_estado, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmb_estado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(83, 83, 83))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_detalle_servicios)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl_crear)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbl_actualizar))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(btn_modificar)
                                .addGap(90, 90, 90))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_descripcion)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_imagenes)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(446, 446, 446))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lbl_detalle))
                            .addComponent(lbl_editar)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lbl_descripcion))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_nombre)
                                        .addGap(12, 12, 12)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_maximo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_actualizar)
                                                    .addComponent(lbl_crear)))
                                            .addComponent(lbl_detalle_servicios))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_estado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_imagenes)))))
                        .addGap(30, 30, 30))))
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

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        confirmarModificar();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if (txt_nombre.getText().length() > 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void spn_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spn_cantidadKeyTyped

    }//GEN-LAST:event_spn_cantidadKeyTyped

    private void tbl_detallesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_detallesMouseClicked
        int fila_point = tbl_detalles.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            user_update = (String) tab.getValueAt(fila_point, columna_point);
            id_servicio = txt_id.getText();
        }

        VstModificarDetalleServicio vstMDS = new VstModificarDetalleServicio();
        vstMDS.setVisible(true);
    }//GEN-LAST:event_tbl_detallesMouseClicked

    private void lbl_crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_crearMouseClicked
        id_servicio = txt_id.getText();
        VstCrearDetalleServicio vstDS = new VstCrearDetalleServicio();        
        vstDS.setVisible(true);
    }//GEN-LAST:event_lbl_crearMouseClicked

    private void lbl_actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_actualizarMouseClicked
       traerDato();
    }//GEN-LAST:event_lbl_actualizarMouseClicked

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_actualizar;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_crear;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_detalle_servicios;
    private javax.swing.JLabel lbl_editar;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_imagenes;
    private javax.swing.JLabel lbl_maximo;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_ruta;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JSpinner spn_cantidad;
    private javax.swing.JTable tbl_detalles;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextArea txa_reglas;
    private javax.swing.JLabel txt_id;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
