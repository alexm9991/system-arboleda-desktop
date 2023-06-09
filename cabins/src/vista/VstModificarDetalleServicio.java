package vista;

import controlador.CtrServicios;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.MdlServicios;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VstModificarDetalleServicio extends VstBase {

    public void traerDato() {
        MdlServicios mdlServicio = new MdlServicios();
        llenarDatos(mdlServicio);
    }

    //OBTIENE LOS DATOS DE LA TABLA Y LOS MUESTRA EN LOS CAMPOS DE LA INTERFAZ
    public void llenarDatos(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
        ctrServicios.consultarModificarDetalles(servicio);

        lbl_nombre_servicio.setText(servicio.getNombre_servicio());
        lbl_id_servicio.setText(String.valueOf(servicio.getId()));
        txt_nombre.setText(servicio.getNombre_detalle_servicio());
        txa_descripcion.setText(servicio.getDescripcion());

        if (servicio.getEstado().equals("ACTIVAR")) {
            cmb_estado.setSelectedIndex(1);
        } else {
            if (servicio.getEstado().equals("DESACTIVAR")) {
                cmb_estado.setSelectedIndex(2);
            }
        }
        llenarTablaImagen(servicio);
    }

    public void llenarTablaImagen(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
        modelo = (DefaultTableModel) tbl_imagen.getModel();
        String[] fila = new String[2];

        lista_imagen = ctrServicios.consultar_imagen(servicio);
        for (int consecutivo = 0; consecutivo < lista_imagen.size(); consecutivo++) {
            fila[0] = lista_imagen.get(consecutivo).getUrl();
            fila[1] = lista_imagen.get(consecutivo).getNombre_img();
            modelo.addRow(fila);
        }
        if (lista_imagen.size() >= 5) {
            limiteImagen();
        }
        tbl_imagen.setModel(modelo);
    }

    ArrayList<MdlServicios> lista_imagen;
    DefaultTableModel modelo;

    public void agregarImagen() {
        String ruta = lbl_ruta.getText();
        String nom_imagen = lbl_nom_imagen.getText();

        modelo = (DefaultTableModel) tbl_imagen.getModel();
        Object[] fila = new Object[2];
        fila[0] = ruta;
        fila[1] = nom_imagen;
        modelo.addRow(fila);

        lbl_ruta.setText("");
        lbl_nom_imagen.setText("");
        btn_agregar_imagen.setEnabled(false);
        btn_eliminar.setEnabled(false);
        lbl_imagen.setIcon(null);
        limiteImagen();
    }

    public void limiteImagen() {
        int rowCount = tbl_imagen.getRowCount();
        if (rowCount == 5) {
            btn_agregar.setEnabled(false);
        }
    }

    //BOTON PARA ABRIR EXPLORADOR DE ARCHIVOS Y SELECCIONAR LA IMAGEN
    public void buscarImagen() {
        String ruta;
        String nom_imagen;
        lbl_ruta.setVisible(false);
        lbl_nom_imagen.setVisible(false);

        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & JPEG", "jpg", "png", "jpeg");
        jFileChooser.setFileFilter(filtrado);

        int respuesta = jFileChooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = jFileChooser.getSelectedFile().getPath();
            nom_imagen = jFileChooser.getSelectedFile().getName();

            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH));
            lbl_imagen.setIcon(mIcono);

            lbl_ruta.setText(ruta);
            lbl_nom_imagen.setText(nom_imagen);

            btn_agregar_imagen.setEnabled(true);
            btn_eliminar.setEnabled(true);
            lbl = "false";
        }
    }

    //SELECCIONAR IMAGEN DE LA TABLA URL Y MOSTRARLA EN LABEL
    String lbl = "false";
    public void traerImagen() throws MalformedURLException {
        if (tbl_imagen.getSelectedRow() >= 0) {
            DefaultTableModel tm = (DefaultTableModel) tbl_imagen.getModel();
            String ruta = String.valueOf(tm.getValueAt(tbl_imagen.getSelectedRow(), 0));

            if (ruta.startsWith("https://www.fincaturisticalaarboleda.com")) {
                ImageIcon icon = new ImageIcon(new URL(ruta));
                Image image = icon.getImage().getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(image);
                lbl_imagen.setIcon(scaledIcon);
                lbl = "true";
                btn_eliminar.setEnabled(true);
                
            }else{
                Image mImagen = new ImageIcon(ruta).getImage();
                ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH));
                lbl_imagen.setIcon(mIcono);
                lbl = "true";
                btn_eliminar.setEnabled(true);
            }
        }
    }

    //METODOS CREAR DETALLE Y LIMPIAR    
    public void modificar() throws IOException {

        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        mdlServicio.setId(Integer.parseInt(lbl_id_servicio.getText()));
        mdlServicio.setNombre_detalle_servicio(txt_nombre.getText());
        mdlServicio.setDescripcion(txa_descripcion.getText());
        mdlServicio.setEstado(cmb_estado.getSelectedItem().toString());

        modelo = (DefaultTableModel) tbl_imagen.getModel();
        Object[][] datos = obtenerDatosDelModelo(modelo);

        ctrServicios.modificarDetalle(datos, mdlServicio);
        super.dispose();

    }

    public Object[][] obtenerDatosDelModelo(DefaultTableModel modelo) {
        int rowCount = tbl_imagen.getRowCount();
        Object[][] datos = new Object[rowCount][2];

        for (int i = 0; i < tbl_imagen.getRowCount(); i++) {
            datos[i][0] = modelo.getValueAt(i, 0); // Ruta
            datos[i][1] = modelo.getValueAt(i, 1); // Nombre de la imagen
        }
        return datos;
    }

    public void limpiar() {
        txt_nombre.setText("");
        txa_descripcion.setText("");
        cmb_estado.setSelectedIndex(0);
        lbl_imagen.setIcon(null);

        limpiarTablaImagenTemporal();
        btn_eliminar.setEnabled(false);
    }

    //LIMPIA TODO LO QUE HAY EN LA TABLA IMAGENES
    public void limpiarTablaImagenTemporal() {
        modelo = (DefaultTableModel) tbl_imagen.getModel();
        for (int i = 0; i < tbl_imagen.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void ElimiarImagenDB(String nombreImagen) throws IOException {
        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        nombre_imagen = nombreImagen;
        ctrServicios.eliminarImagenDB(mdlServicio);
        nombre_imagen = "";
    }

    //MENSAJES EMERGENTES DE CONFIMARCION 
    public void confirmarElimiarImagen() throws IOException {
        if (lbl.equals("true")) {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea eliminar la imagen?", "",
                    0, 0, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                modelo = (DefaultTableModel) tbl_imagen.getModel();
                int fila = tbl_imagen.getSelectedRow();
                if (fila >= 0) {
                    String nombreImagen = modelo.getValueAt(fila, 1).toString();
                    modelo.removeRow(fila);
                    btn_agregar.setEnabled(true);
                    ElimiarImagenDB(nombreImagen);
                }
                lbl_imagen.setIcon(null);
                lbl = "false";
                btn_eliminar.setEnabled(false);
                btn_agregar_imagen.setEnabled(false);
            }
        } else if (lbl.equals("false")) {
            lbl_imagen.setIcon(null);
            lbl = "false";
            btn_eliminar.setEnabled(false);
            btn_agregar_imagen.setEnabled(false);
        }
    }

    private void confirmarModificar() throws IOException {
        if (txt_nombre.getText().equals("") || cmb_estado.getSelectedItem().toString().equals("Seleccione...")
                || txa_descripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        } else {
            String botones[] = {"Modificar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea modificar el servicio?", "Modificar",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                modificar();
                this.dispose();
            }
        }
    }

    private void confirmarLimpiar() {
        String botones[] = {"Limpiar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea limpiar los campos del detalle del servicio?", "Titulo",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            limpiar();
        }
    }

    //MOSTRAR Y OCULTAR BOTONES
    public void ocultarAE() {
        btn_agregar_imagen.setEnabled(false);
        btn_eliminar.setEnabled(false);
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
        ocultarAE();
        setLocationRelativeTo(null);
        bordePantalla();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        traerDato();
    }

    public VstModificarDetalleServicio() {
        initComponents();
        inicio();
    }
    public static String nombre_imagen = "";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_imagen = new javax.swing.JTable();
        btn_agregar_imagen = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        lbl_imagen = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        lbl_crear_detalle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        lbl_nombre = new javax.swing.JLabel();
        cmb_estado = new javax.swing.JComboBox<>();
        txt_nombre = new javax.swing.JTextField();
        lbl_estado = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_detalle = new javax.swing.JLabel();
        lbl_editar = new javax.swing.JLabel();
        lbl_nombre_servicio = new javax.swing.JLabel();
        lbl_id_servicio = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_ruta = new javax.swing.JLabel();
        lbl_nom_imagen = new javax.swing.JLabel();

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
            .addGap(0, 613, Short.MAX_VALUE)
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

        tbl_imagen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_imagen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Url", "Nombre Imagen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_imagenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_imagen);

        btn_agregar_imagen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_agregar_imagen.setText("Agregar");
        btn_agregar_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregar_imagenMouseClicked(evt);
            }
        });
        btn_agregar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_imagenActionPerformed(evt);
            }
        });

        btn_agregar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_agregar.setText("Buscar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        lbl_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imagenMouseClicked(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        lbl_crear_detalle.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        lbl_crear_detalle.setText("MODIFICAR DETALLE DE SERVICIO");

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        txa_descripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txa_descripcion);

        lbl_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre del servicio");

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

        lbl_detalle.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_detalle.setText("Detalle del servicio");

        lbl_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editar.png"))); // NOI18N

        lbl_codigo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_codigo.setText("Codigo");

        lbl_ruta.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lbl_nom_imagen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lbl_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_crear_detalle)
                        .addGap(294, 294, 294)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_codigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_id_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbl_nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_nombre_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(lbl_estado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_descripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_detalle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb_estado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_ruta))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_agregar)
                                        .addGap(59, 59, 59)
                                        .addComponent(btn_agregar_imagen)
                                        .addGap(73, 73, 73)
                                        .addComponent(btn_eliminar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(340, 340, 340)
                    .addComponent(lbl_nom_imagen)
                    .addContainerGap(752, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(lbl_crear_detalle))
                                .addComponent(lbl_editar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_id_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_agregar)
                                .addComponent(btn_agregar_imagen)
                                .addComponent(btn_eliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_nombre_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_detalle)
                                .addGap(10, 10, 10)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_descripcion)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ruta)))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(584, Short.MAX_VALUE)
                    .addComponent(lbl_nom_imagen)
                    .addGap(61, 61, 61)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        try {
            confirmarElimiarImagen();
        } catch (IOException ex) {
            Logger.getLogger(VstModificarDetalleServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        buscarImagen();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_agregar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_imagenActionPerformed
        agregarImagen();
    }//GEN-LAST:event_btn_agregar_imagenActionPerformed

    private void tbl_imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_imagenMouseClicked
        try {
            traerImagen();
        } catch (MalformedURLException ex) {
            Logger.getLogger(VstModificarDetalleServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbl_imagenMouseClicked

    private void lbl_imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imagenMouseClicked

    }//GEN-LAST:event_lbl_imagenMouseClicked

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        try {
            confirmarModificar();
        } catch (IOException ex) {
            Logger.getLogger(VstCrearDetalleServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        confirmarLimpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        super.moverVentana(evt);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        super.presionVentana(evt);
    }//GEN-LAST:event_formMousePressed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        if (txt_nombre.getText().length() > 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void btn_agregar_imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregar_imagenMouseClicked

    }//GEN-LAST:event_btn_agregar_imagenMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregar_imagen;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_crear_detalle;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_editar;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_id_servicio;
    private javax.swing.JLabel lbl_imagen;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_nom_imagen;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombre_servicio;
    private javax.swing.JLabel lbl_ruta;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JTable tbl_imagen;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
