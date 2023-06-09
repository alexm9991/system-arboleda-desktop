package vista;

import conexion.conexionMensaje;
import controlador.CtrServicios;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.MdlServicios;
import java.util.List;

public class VstServicios extends VstBase {

    ArrayList<MdlServicios> lista;
    ArrayList<MdlServicios> lista_imagen = new ArrayList();

    int cantidad = 0;

    //CONSULTA LA BASE DE DATOS
    public void consultar() {
        llenarTabla();
    }

    //LLENA LA TABLA CON LA INFOMACION IMPORTANTE DEL SERVICIO
    public void llenarTabla() {
        CtrServicios ctrServicios = new CtrServicios();
        DefaultTableModel tabla = new DefaultTableModel();

        String[] fila = new String[5];
        tabla.addColumn("Nombre");
        tabla.addColumn("Descripción");
        tabla.addColumn("Estado");
        tabla.addColumn("Fecha de cración");
        tabla.addColumn("Fecha de modificación");
        System.out.println("holis");
        lista = ctrServicios.consultar();
        for (int consecutivo = 0; consecutivo < lista.size(); consecutivo++) {
            fila[0] = lista.get(consecutivo).getNombre_servicio();
            fila[1] = lista.get(consecutivo).getDescripcion();
            fila[2] = lista.get(consecutivo).getEstado();
            fila[3] = lista.get(consecutivo).getFecha_registro().toString();
            fila[4] = lista.get(consecutivo).getFecha_modificacion().toString();

            tabla.addRow(fila);
        }
        tbl_tabla.setModel(tabla);
    }

    //ESTE BOTON GUARDA LA IMAGEN SELECCIONADA EN LA TABLA URL
    int ban = 0;
    Object[] datos = new Object[10];

    public void guardarImagen() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Url");
        tbl_imagen.setModel(modelo);
        String ruta = lbl_ruta.getText();
        System.out.println(ban);
        datos[ban] = ruta;
        modelo.addRow(datos);
        tbl_imagen.setModel(modelo);
        System.out.println(ban);
        System.out.println(datos[ban]);
        ban++;
        System.out.println(ban);
        ruta = "";
        btn_guardar.setEnabled(false);
        btn_eliminar.setEnabled(false);
        lbl_imagen.setIcon(null);

    }
    public void guardarImagenDB(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();

    }

    //LIMPIA LA TABLA JEJE
    public void limpiarTabla() {
        for (int consecutivo = 0; consecutivo < lista.size(); consecutivo++) {
            tbl_tabla.setValueAt("", consecutivo, 0);
            tbl_tabla.setValueAt("", consecutivo, 1);
            tbl_tabla.setValueAt("", consecutivo, 2);
            tbl_tabla.setValueAt("", consecutivo, 3);
            tbl_tabla.setValueAt("", consecutivo, 4);
        }
    }

    //EVENTO DEL MOUSE QUE AL DARLE CLIC A UNA FILA TE LLAMA EL METODO LLENAR DATOS 
    public void traerDato() {
        MdlServicios mdlServicio = new MdlServicios();
        for (int posicion = 0; posicion < lista.size(); posicion++) {
            if (tbl_tabla.getSelectedRow() == posicion) {
                mdlServicio = lista.get(posicion);
            }
        }
        desocultarM();
        ocultarC();
        llenarDatos(mdlServicio);
    }

    //OBTIENE LOS DATOS DE LA TABLA Y LOS MUESTRA EN LOS CAMPOS DE LA INTERFAZ
    public void llenarDatos(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
//        ctrServicios.consultarPrecios(servicio);
        consultar_imagen(servicio);
        txt_id.setText(String.valueOf(servicio.getId()));
        txt_nombre.setText(servicio.getNombre_servicio());
        txa_descripcion.setText(servicio.getDescripcion());

        if (servicio.getEstado().equals("Activo")) {
            cmb_estado.setSelectedIndex(1);
        } else {
            if (servicio.getEstado().equals("Inactivo")) {
                cmb_estado.setSelectedIndex(2);
            }
        }

      //  txt_precioA.setText(String.valueOf(servicio.getP_adulto()));
       // txt_precioN.setText(String.valueOf(servicio.getP_nino()));
        spn_cantidad.setValue(servicio.getTotal());

    }

    //CONSULTAR IMAGENES EN LA DB
    public void consultar_imagen(MdlServicios servicio) {
        llenarTablaImagen(servicio);
    }

    //LLENAR LA TABLA URL CON LAS IMAGANES QUE HAY EN LA DB
    public void llenarTablaImagen(MdlServicios servicio) {
        CtrServicios ctrServicios = new CtrServicios();
        DefaultTableModel tablaI = new DefaultTableModel();

        String[] fila = new String[1];
        tablaI.addColumn("Url");
       // lista_imagen = ctrServicios.consultar_imagen(servicio);
        for (int consecutivo = 0; consecutivo < lista_imagen.size(); consecutivo++) {
            //fila[0] = lista_imagen.get(consecutivo).getUrls().get(consecutivo); 
            System.out.println(lista_imagen);
            tablaI.addRow(fila);
        }
        tbl_imagen.setModel(tablaI);
    }

    //LIMPIA TODO LO QUE HAY EN LA TABLA URL
    public void limpiarTablaImagenTemporal() {
        DefaultTableModel tablaI = new DefaultTableModel();
        for (int i = 0; i < tbl_imagen.getRowCount(); i++) {
            tbl_imagen.remove(this);
            i -= 1;
        }
    }

    //BOTON PARA ABRIR EXPLORADOR DE ARCHIVOS Y SELECCIONAR LA IMAGEN
    public void agregarImagen() {
        lbl_ruta.setVisible(false);
        String ruta = "";
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif", "mov", "mp4");
        jFileChooser.setFileFilter(filtrado);

        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ruta = jFileChooser.getSelectedFile().getPath();

            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH));
            lbl_imagen.setIcon(mIcono);
            lbl_ruta.setText(ruta);
            btn_guardar.setEnabled(true);
            btn_eliminar.setEnabled(true);
            lbl = "t";
        }
    }

    //SELECCIONAR IMAGEN DE LA TABLA URL Y MOSTRARLA EN LABEL
    String lbl = "false";

    public void traerImagen() {
        if (tbl_imagen.getSelectedRow() >= 0) {
            DefaultTableModel tm = (DefaultTableModel) tbl_imagen.getModel();

            String ruta = String.valueOf(tm.getValueAt(tbl_imagen.getSelectedRow(), 0));
            Image mImagen = new ImageIcon(ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH));
            lbl_imagen.setIcon(mIcono);
            lbl = "true";
            btn_eliminar.setEnabled(true);

        }
    }

    //METODOS CREAR, MODIFICAR Y LIMPIAR
    public void crear() {
        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        mdlServicio.setNombre_servicio(txt_nombre.getText());
        mdlServicio.setDescripcion(txa_descripcion.getText());
        mdlServicio.setEstado(cmb_estado.getSelectedItem().toString());
        mdlServicio.setTotal(Integer.parseInt(spn_cantidad.getValue().toString()));
//        mdlServicio.setP_adulto(Integer.parseInt(txt_precioA.getText()));
     //   mdlServicio.setP_nino(Integer.parseInt(txt_precioN.getText()));
        
        List<String> lUrls = new ArrayList<>();
        for (int i = 0; i <= tbl_imagen.getRowCount(); i++){
//            lUrls.add(tbl_imagen.getValueAt(0, i).toString()); 
        }
       // mdlServicio.setUrls(lUrls); 
        // m_servicio.setUrl(tbl_imagen.ruta);
        //ctrServicios.guardarServicio(mdlServicio);
        limpiar();
        limpiarTabla();
        limpiarTablaImagenTemporal();
        consultar();
    }

    public void modificar() {

        MdlServicios mdlServicio = new MdlServicios();
        CtrServicios ctrServicios = new CtrServicios();

        mdlServicio.setId(Integer.parseInt(txt_id.getText()));
        mdlServicio.setNombre_servicio(txt_nombre.getText());
        mdlServicio.setDescripcion(txa_descripcion.getText());
        mdlServicio.setEstado(cmb_estado.getSelectedItem().toString());
        mdlServicio.setTotal(Integer.parseInt(spn_cantidad.getValue().toString()));
//        mdlServicio.setP_adulto(Integer.parseInt(txt_precioA.getText()));
       // mdlServicio.setP_nino(Integer.parseInt(txt_precioN.getText()));

      //  ctrServicios.modificar(mdlServicio);
        limpiar();
        limpiarTabla();
        consultar();

    }

    public void limpiar() {

        txt_id.setText("");
        txt_nombre.setText("");
        txa_descripcion.setText("");
        cmb_estado.setSelectedIndex(0);
        txt_precioA.setText("");
        txt_precioN.setText("");
        lbl_imagen.setIcon(null);
        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(false);
        spn_cantidad.setValue(((SpinnerNumberModel) spn_cantidad.getModel()).getMinimum());
        limpiarTablaImagenTemporal();
        desocultarC();
    }

    //MENSAJES EMERGENTES DE CONFIMARCION
    public void confirmarElimiarImagen() {
        DefaultTableModel modelo = new DefaultTableModel();
        if (lbl == "true") {
            String botones[] = {"Eliminar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea eliminar la imagen?", "Titulo",
                    0, 0, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                int fila = tbl_imagen.getSelectedRow();
                modelo.removeRow(fila);
                lbl_imagen.setIcon(null);
                lbl = "false";
                btn_eliminar.setEnabled(false);
            } else if (eleccion == JOptionPane.NO_OPTION) {
            }
        }
        if (lbl == "t") {
            lbl_imagen.setIcon(null);
            lbl = "false";
            btn_eliminar.setEnabled(false);
            btn_guardar.setEnabled(false);
        }

    }

    private void confirmarCrear() {
        if (txt_nombre.getText().equals("") || cmb_estado.getSelectedItem().toString().equals("Seleccione...")
                || txa_descripcion.getText().equals("") || txt_precioA.getText().equals("")
                || txt_precioN.getText().equals("") || spn_cantidad.getValue().toString().equals("0")) {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        } else {
            String botones[] = {"Crear", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "¿Desea crear el servicio?", "Titulo",
                    0, 0, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                crear();
            }
        }
    }

    private void confirmarModificar() {
        String botones[] = {"Modificar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea modificar el servicio?", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            modificar();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }

    private void confirmarLimpiar() {
        String botones[] = {"Limpiar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea limpiar los campos del servicio?", "Titulo",
                0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            limpiar();
        } else if (eleccion == JOptionPane.NO_OPTION) {
        }
    }

    //MOSTRAR Y OCULTAR BOTONES
    public void desocultarC() {
        btn_crear.setEnabled(true);
    }

    public void desocultarM() {
        btn_modificar.setEnabled(true);
    }

    public void ocultarC() {
        btn_crear.setEnabled(false);
    }

    public void ocultarE() {
        btn_eliminar.setEnabled(false);
    }

    public void ocultarMGE() {
        btn_modificar.setEnabled(false);
        btn_guardar.setEnabled(false);
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
        System.exit(0);
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
        ocultarMGE();
        setLocationRelativeTo(null);
        consultar();
        spinner();
        bordePantalla();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public VstServicios() {
        initComponents();
        inicio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        cmb_estado = new javax.swing.JComboBox<>();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_detalle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_descripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lbl_precio1 = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        lbl_detalle1 = new javax.swing.JLabel();
        txt_precioA = new javax.swing.JTextField();
        txt_precioN = new javax.swing.JTextField();
        lbl_maximo = new javax.swing.JLabel();
        spn_cantidad = new javax.swing.JSpinner();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_imagen = new javax.swing.JTable();
        lbl_imagenes = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JButton();
        lbl_imagen = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_salir = new javax.swing.JLabel();
        lbl_minimizar = new javax.swing.JLabel();
        lbl_ruta = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btn_crear = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_nombre.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre:");

        lbl_descripcion.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_descripcion.setText("Descripción:");

        lbl_estado.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_estado.setText("Estado:");

        txt_nombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        cmb_estado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmb_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Activo", "Inactivo" }));

        lbl_id.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_id.setText("Codigo:");

        txt_id.setEditable(false);
        txt_id.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lbl_detalle.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lbl_detalle.setText("Detalles");

        txa_descripcion.setColumns(20);
        txa_descripcion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txa_descripcion.setLineWrap(true);
        txa_descripcion.setRows(5);
        txa_descripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txa_descripcion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_descripcion)
                        .addGap(208, 208, 208))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_id)
                                .addGap(48, 48, 48)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(lbl_detalle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_detalle)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_estado)
                    .addComponent(cmb_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_descripcion)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        tbl_tabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_tabla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Estado", "Fecha de creación", "Fecha de modificación"
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_precio1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_precio1.setText("Niño:");

        lbl_precio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbl_precio.setText("Adulto:");

        lbl_detalle1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lbl_detalle1.setText("Precios");

        txt_precioA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        txt_precioN.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        lbl_maximo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbl_maximo.setText("Max personas:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl_detalle1)
                .addGap(59, 59, 59))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_maximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_precio)
                            .addComponent(lbl_precio1))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_precioN, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(txt_precioA))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_detalle1)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_precio)
                    .addComponent(txt_precioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_precio1)
                    .addComponent(txt_precioN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_maximo)
                    .addComponent(spn_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbl_imagen.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_imagen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_imagenMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_imagen);

        lbl_imagenes.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        lbl_imagenes.setText("Imagenes");

        btn_agregar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_agregar.setText("Buscar imagen");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        lbl_imagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_imagenMouseClicked(evt);
            }
        });

        btn_guardar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_guardar.setText("G");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_eliminar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_eliminar.setText("E");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbl_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_agregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_eliminar)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(lbl_imagenes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lbl_imagenes)
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_crear.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_crear.setText("Crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_limpiar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tablaMouseClicked
        traerDato();
    }//GEN-LAST:event_tbl_tablaMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        confirmarElimiarImagen();
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
        agregarImagen();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        guardarImagen();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void tbl_imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_imagenMouseClicked
        traerImagen();
    }//GEN-LAST:event_tbl_imagenMouseClicked

    private void lbl_imagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_imagenMouseClicked

    }//GEN-LAST:event_lbl_imagenMouseClicked

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        confirmarCrear();
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        confirmarModificar();
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_estado;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_detalle;
    private javax.swing.JLabel lbl_detalle1;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_imagen;
    private javax.swing.JLabel lbl_imagenes;
    private javax.swing.JLabel lbl_maximo;
    private javax.swing.JLabel lbl_minimizar;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_precio1;
    private javax.swing.JLabel lbl_ruta;
    private javax.swing.JLabel lbl_salir;
    private javax.swing.JSpinner spn_cantidad;
    private javax.swing.JTable tbl_imagen;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextArea txa_descripcion;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precioA;
    private javax.swing.JTextField txt_precioN;
    // End of variables declaration//GEN-END:variables
}
