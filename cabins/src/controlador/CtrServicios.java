package controlador;

import conexion.conexionMensaje;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MdlServicios;
import vista.VstCrearServicios;
import vista.VstCrearDetalleServicio;
import vista.VstGestionServicios;
import vista.VstModificarDetalleServicio;
import vista.VstModificarServicios;
import org.apache.commons.net.ftp.FTPClient;

public class CtrServicios {

    //CONSULTAR - GESTION SERVICIOS
    public ArrayList<MdlServicios> consultar() {
        conexionMensaje conectar = new conexionMensaje();
        ArrayList<MdlServicios> lista = new ArrayList();
        ResultSet rs;
        String sql = "select * from services";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                MdlServicios servicios = new MdlServicios();
                servicios.setId(rs.getInt("id"));
                servicios.setNombre_servicio(rs.getString("tittle"));
                servicios.setDescripcion(rs.getString("description"));
                servicios.setReglas(rs.getString("rules"));
                servicios.setFecha_registro(rs.getDate("create_time"));
                servicios.setFecha_modificacion(rs.getDate("update_time"));
                servicios.setEstado(rs.getString("state_record"));
                lista.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de servicios " + error);
        }
        return lista;
    }

    //CONSULTA Y TRAE EL CAMPO SELECCIONADO DE LA TABLA GESTION, HACIA LA INTERFAZ MODIFICAR
    String user_update = "";

    public ArrayList<MdlServicios> consultarModificar(MdlServicios servicio) {

        user_update = VstGestionServicios.user_update;
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs;

        String sql = "select * from services where id = " + "'" + user_update + "'";
        rs = conectar.consultar(sql);

        try {
            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
                servicio.setNombre_servicio(rs.getString("tittle"));
                servicio.setDescripcion(rs.getString("description"));
                servicio.setTotal(rs.getInt("max_individuals"));
                servicio.setReglas(rs.getString("rules"));
                servicio.setFecha_registro(rs.getDate("create_time"));
                servicio.setFecha_modificacion(rs.getDate("update_time"));
                servicio.setEstado(rs.getString("state_record"));

                consultarDetalles(servicio);
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de servicios " + error);
        }
        return null;
    }

    //CONSULTA LOS DETALLES DEL SERVICIO Y LOS LLENA EN LA TABLA DETALLES SERVICIOS DE LA INTERFAZ MODIFICAR
    public ArrayList<MdlServicios> consultarDetalles(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ArrayList<MdlServicios> listaDetalles = new ArrayList();

        ResultSet rs;
        String sql = "select * from detail_services where services_id = " + servicio.getId();
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {

                MdlServicios servicios = new MdlServicios();
                servicios.setId(rs.getInt("id"));
                servicios.setNombre_detalle_servicio(rs.getString("tittle"));
                listaDetalles.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de detalles de servicios " + error);
        }
        return listaDetalles;
    }

    //CONSULTA LA INFO DE DEATALLES Y LA MUESTRA EN LA INTERFAZ MODIFICAR DETALLES
    String id_servicio = "";

    public ArrayList<MdlServicios> consultarModificarDetalles(MdlServicios servicio) {

        user_update = VstModificarServicios.user_update;
        id_servicio = VstModificarServicios.id_servicio;
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, id_s;

        String sql = "select * from detail_services where id = " + "'" + user_update + "'";
        String sqlId = "select tittle from services where id = " + "" + id_servicio + "";
        rs = conectar.consultar(sql);
        id_s = conectar.consultar(sqlId);

        try {

            while (rs.next() && id_s.next()) {
                servicio.setId(rs.getInt("id"));
                servicio.setNombre_detalle_servicio(rs.getString("tittle"));
                servicio.setDescripcion(rs.getString("description"));
                servicio.setEstado(rs.getString("state_record"));
                servicio.setNombre_servicio(id_s.getString("tittle"));
//                consultar_imagen(servicio);
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de detalles de servicios " + error);
        }
        return null;
    }
    String nombre_servicio = "";
    String descripcion_servicio = "";
    String reglas_servicio = "";

    //CONSULTA EL ID Y EL NOMBRE DEL SERVICIO CREADO Y ABRE LA INTERFAZ CREAR DETALLES
    public ArrayList<MdlServicios> consultarCrearDetalles(MdlServicios servicio) {

        nombre_servicio = VstCrearServicios.nombre_servicio;
        descripcion_servicio = VstCrearServicios.descripcion_servicio;
        reglas_servicio = VstCrearServicios.reglas_servicio;

        if (nombre_servicio.isEmpty() && descripcion_servicio.isEmpty() && reglas_servicio.isEmpty()) {

            id_servicio = VstModificarServicios.id_servicio;
            conexionMensaje conectar = new conexionMensaje();
            ResultSet id_s;
            String sqlId = "select * from services where id = " + "" + id_servicio + "";
            id_s = conectar.consultar(sqlId);

            try {
                while (id_s.next()) {
                    servicio.setId(id_s.getInt("id"));
                    servicio.setNombre_servicio(id_s.getString("tittle"));
                }

            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, "Error en la consulta de servicios " + error);
            }
        } else {
            conexionMensaje conectar = new conexionMensaje();
            ResultSet datos_s;
            String sqlDatos = "select id, tittle from services where tittle = '" + nombre_servicio
                    + "' and description = '" + descripcion_servicio
                    + "' and rules = '" + reglas_servicio + "'";
            datos_s = conectar.consultar(sqlDatos);
            try {

                while (datos_s.next()) {
                    servicio.setId(datos_s.getInt("id"));
                    servicio.setNombre_servicio(datos_s.getString("tittle"));
                }
            } catch (SQLException error) {
                JOptionPane.showMessageDialog(null, "Error en la consulta de servicios " + error);
            }
        }
        return null;
    }

    //ELIMINAR O DESACTIVAR IMAGENES EN LA DB
    String nombre_imagen = "";

    public void eliminarImagenDB(MdlServicios servicio) throws IOException {
        String siHay = "";
        nombre_imagen = VstModificarDetalleServicio.nombre_imagen;

        conexionMensaje conectar = new conexionMensaje();
        LocalDateTime todaysDate = LocalDateTime.now();
        FTPClient ftpClient = new FTPClient();

        String sqlConsultarImg = "select url from resources where url ='" + nombre_imagen + "'";
        ResultSet rs;
        rs = conectar.consultar(sqlConsultarImg);

        try {
            while (rs.next()) {
                servicio.setUrl(rs.getString("url"));
                siHay = servicio.getUrl();
                servicio.setUrl("");
            }
            if (!siHay.isEmpty()) {
                String sqlI = "update resources set state_record = 'DESACTIVAR"
                        + "', update_time = '" + todaysDate
                        + "' where url = '" + nombre_imagen + "'";

                try {
                    if (conectar.ejecutar(sqlI)) {
                        ftpClient.connect("ftp.fincaturisticalaarboleda.com", 21); // Establece la conexión FTP con el host y el puerto correspondientes
                        ftpClient.login("admin@fincaturisticalaarboleda.com", "Cabins.123"); // Inicia sesión en el servidor FTP con las credenciales adecuadas
                        ftpClient.changeWorkingDirectory("public_html/public/storage/imgServices/");
                        ftpClient.deleteFile(nombre_imagen);

                        ftpClient.logout();
                        ftpClient.disconnect();
                        JOptionPane.showMessageDialog(null, "Se elimino la imagen correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "La imagen no fue eliminada");
                    }
                } catch (SQLException error) {
                    JOptionPane.showMessageDialog(null, "Error en modificar detalle del servicio" + error);
                }
            }

        } catch (SQLException error) {
        }
    }

    //CONSULTAR IMAGANES DE LA TABLA RESOURCES
    public ArrayList<MdlServicios> consultar_imagen(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ArrayList<MdlServicios> lista_imagen = new ArrayList();
        ResultSet rsImg;
        String sqlImg = "select url from resources where detail_services_id = '" + servicio.getId() + "' and state_record = 'ACTIVAR'";
        String carpetaOrigen = "https://www.fincaturisticalaarboleda.com/storage/imgServices/";
        try {
            rsImg = conectar.consultar(sqlImg);

            while (rsImg.next()) {
                MdlServicios servicios = new MdlServicios();

                servicios.setNombre_img(rsImg.getString("url"));
                servicios.setUrl(carpetaOrigen + servicios.getNombre_img());
                lista_imagen.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de imagenes ID" + error);
        }
        return lista_imagen;
    }

    //INSERT DE LA TABLA RESOURCES
    public void insertar_R(Object[][] datos, MdlServicios servicio) throws IOException {
        conexionMensaje conectar = new conexionMensaje();
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream = null;

        ResultSet re;
        String sqlR = "SELECT id FROM detail_services WHERE tittle = '" + servicio.getNombre_detalle_servicio()
                + "' AND description = '" + servicio.getDescripcion()
                + "' AND services_id = '" + servicio.getId() + "'";
        re = conectar.consultar(sqlR);

        try {
            while (re.next()) {
                servicio.setIdFUno(re.getInt("id"));
            }
            String carpetaDestino = "public_html/public/storage/imgServices/"; // Ruta de la carpeta de destino en el servidor FTP

            for (Object[] fila : datos) {
                // Método para crear un código aleatorio para la imagen
                long timestamp = System.currentTimeMillis();
                String urlImagenOrigen = fila[0].toString();
                String img = fila[1].toString();
                String nombreImagen = timestamp + "_";
                for (int i = 0; i < img.length(); i++) {
                    if (img.charAt(i) == ' ') {
                        nombreImagen += "";
                        
                    } else {
                        nombreImagen += img.charAt(i);
                    }
                }
                try {
                    ftpClient.connect("ftp.fincaturisticalaarboleda.com", 21); // Establece la conexión FTP con el host y el puerto correspondientes
                    ftpClient.login("admin@fincaturisticalaarboleda.com", "Cabins.123"); // Inicia sesión en el servidor FTP con las credenciales adecuadas
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); // Establece el tipo de archivo a binario

                    fileInputStream = new FileInputStream(urlImagenOrigen);
                    ftpClient.storeFile(carpetaDestino + nombreImagen, fileInputStream); // Sube el archivo al servidor FTP en la ubicación de destino 
                    ftpClient.logout();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        ftpClient.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                String sqlI = "INSERT INTO resources (url, detail_services_id) VALUES ('" + nombreImagen + "'," + servicio.getIdFUno() + ")";
                if (conectar.ejecutar(sqlI)) {
//                     Realizar acciones adicionales si la inserción fue exitosa
                }
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error al crear servicio ID DS: " + error.getMessage());
        }
    }

    //CREAR UN SERVICIO
    public void crearServicio(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();

        String sqlgu = "insert into services(tittle,description,max_individuals, rules, state_record)"
                + "values('" + servicio.getNombre_servicio() + "','" + servicio.getDescripcion()
                + "', '" + servicio.getTotal() + "','" + servicio.getReglas() + "','" + servicio.getEstado() + "')";

        try {
            if (conectar.ejecutar(sqlgu)) {
                JOptionPane.showMessageDialog(null, "El servicio fue creado correctamente");

                VstCrearDetalleServicio vstDS = new VstCrearDetalleServicio();
                vstDS.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue creado");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio " + error);
        }
    }

    //CREAR UN DETALLE DE SERVICIO
    public void crearDetalle(Object[][] datos, MdlServicios servicio) throws IOException {
        conexionMensaje conectar = new conexionMensaje();
        String sqlIDS = "insert into detail_services(tittle,description,state_record,services_id)"
                + "values('" + servicio.getNombre_detalle_servicio()
                + "','" + servicio.getDescripcion()
                + "','" + servicio.getEstado()
                + "'," + servicio.getId() + ")";

        try {
            if (conectar.ejecutar(sqlIDS)) {
                insertar_R(datos, servicio);
                JOptionPane.showMessageDialog(null, "El detalle de servicio fue creado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El detalle de servicio no fue creado");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en crear detalle de servicio" + error);
        }

    }

    //MODIFICAR SERVICIO
    public void modificarServicio(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        LocalDateTime todaysDate = LocalDateTime.now();
        String sqlp = "update services set tittle = '" + servicio.getNombre_servicio()
                + "', description = '" + servicio.getDescripcion()
                + "', max_individuals = '" + servicio.getTotal()
                + "', rules = '" + servicio.getReglas()
                + "', state_record = '" + servicio.getEstado()
                + "', update_time = '" + todaysDate
                + "' where id = " + servicio.getId();

        try {
            if (conectar.ejecutar(sqlp)) {
                JOptionPane.showMessageDialog(null, "Se modifico el servicio correctamente");

                VstGestionServicios vstGS = new VstGestionServicios();
                vstGS.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue modificado");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en modificar el servicio" + error);
        }
    }

    public void modificarDetalle(Object[][] datos, MdlServicios servicio) throws IOException {
        conexionMensaje conectar = new conexionMensaje();
        LocalDateTime todaysDate = LocalDateTime.now();
        String sqlDS = "update detail_services set tittle = '" + servicio.getNombre_detalle_servicio()
                + "', description = '" + servicio.getDescripcion()
                + "', state_record = '" + servicio.getEstado()
                + "', update_time = '" + todaysDate
                + "' where id = " + servicio.getId();

        try {

            if (conectar.ejecutar(sqlDS)) {
                modificar_R(datos, servicio);
                JOptionPane.showMessageDialog(null, "Se modificaron los detalles del servicio correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificados");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en modificar detalle del servicio" + error);
        }
    }

    //MODIFICAR DE LA TABLA RESOURCES
    public void modificar_R(Object[][] datos, MdlServicios servicio) throws IOException {
        conexionMensaje conectar = new conexionMensaje();
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream = null;

        try {
            String carpetaDestino = "public_html/public/storage/imgServices/";

            for (Object[] fila : datos) {

                String sqlVerificar = "SELECT COUNT(*) FROM resources WHERE url = '" + fila[1].toString()
                        + "' AND state_record = 'ACTIVAR'"
                        + " AND detail_services_id = " + servicio.getId();
                ResultSet resultado = conectar.consultar(sqlVerificar);
                int count = 0;
                if (resultado.next()) {
                    count = resultado.getInt(1);
                }

                // Copiar y pegar la imagen en la carpeta de destino
                if (count == 0) {
                    // Metodo para crear un codigo aleatorio para la imagen
                    long timestamp = System.currentTimeMillis();
                    String urlImagenOrigen = fila[0].toString();
                    String img = fila[1].toString();
                     String nombreImagen = timestamp + "_";
                    for (int i = 0; i < img.length(); i++) {
                    if (img.charAt(i) == ' ') {
                        nombreImagen += "";                    
                    } else {
                        nombreImagen += img.charAt(i);
                    }
                    }
                    ftpClient.connect("ftp.fincaturisticalaarboleda.com", 21); // Establece la conexión FTP con el host y el puerto correspondientes
                    ftpClient.login("admin@fincaturisticalaarboleda.com", "Cabins.123"); // Inicia sesión en el servidor FTP con las credenciales adecuadas
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); // Establece el tipo de archivo a binario

                    fileInputStream = new FileInputStream(urlImagenOrigen);
                    ftpClient.storeFile(carpetaDestino + nombreImagen, fileInputStream); // Sube el archivo al servidor FTP en la ubicación de destino 
                    ftpClient.logout();

                    String sqlI = "INSERT INTO resources (url, detail_services_id) VALUES ('" + nombreImagen + "'," + servicio.getId() + ")";

                    if (conectar.ejecutar(sqlI)) {
                    }
                }
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id ds" + error);
        }
    }

}
