package Controlador;

import vista.VstEditar_Producto;
import conexion.conexionMensaje;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MdlProductos;
import org.apache.commons.net.ftp.FTPClient;
import vista.VstModificarDetalleServicio;

public class CtrlProductos {

    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public ArrayList<MdlProductos> consultaProductos() {
        conexionMensaje conecta = new conexionMensaje();
        ArrayList<MdlProductos> listaProductos = new ArrayList();
        ResultSet rs;
        String sql = "select * from products where state_record='ACTIVAR'";
        try {
            rs = conecta.consultar(sql);
            while (rs.next()) {
                MdlProductos producto = new MdlProductos();
                producto.setId(rs.getInt("id"));
                producto.setNameProduct(rs.getString("name_product"));
                producto.setPrice(rs.getInt("price"));
                producto.setDescripcion(rs.getString("decripcion"));
                producto.setCreateTime(rs.getTimestamp("create_time"));
                producto.setUpdateTime(rs.getTimestamp("update_time"));
                listaProductos.add(producto);
            }

        } catch (Exception error) {
            System.out.println("Error en consulta de productos  : " + error);
            JOptionPane.showMessageDialog(null, error);
        }

        return listaProductos;

    }

    public ArrayList<MdlProductos> consultaProductosEliminados() {
        conexionMensaje conecta = new conexionMensaje();
        ArrayList<MdlProductos> listaProductosEliminado = new ArrayList();
        ResultSet rs;
        String sql = "select * from products where state_record='DESACTIVAR'";
        try {
            rs = conecta.consultar(sql);
            while (rs.next()) {
                MdlProductos producto = new MdlProductos();
                producto.setNameProduct(rs.getString("name_product"));
                producto.setPrice(rs.getFloat("price"));
                producto.setId(rs.getInt("id"));
                listaProductosEliminado.add(producto);
            }
        } catch (Exception error) {
            System.out.println("Error en la consulta de productos eliminados  : " + error);
            JOptionPane.showMessageDialog(null, error);
        }
        return listaProductosEliminado;
    }

    public MdlProductos consultarProducto(MdlProductos producto, int idRetornado) {
        conexionMensaje conexion = new conexionMensaje();
        ResultSet rs;
        String sql = "select * from products where id=" + idRetornado;
       
        try {
            rs = conexion.consultar(sql);
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNameProduct(rs.getString("name_product"));
                producto.setPrice(rs.getFloat("price"));
                producto.setDescripcion(rs.getString("decripcion"));
                producto.setRutaImg(rs.getString("picture"));

            }
        } catch (Exception error) {
            System.out.println("Error en la consulta del producto : " + error);
            JOptionPane.showMessageDialog(null, "Error en la consulta del producto : " + error);
        }
        return producto;

    }

    public void eliminar(MdlProductos producto, int idRetornado) {
        conexionMensaje conexion = new conexionMensaje();
        String sql = "update products set state_record = 'DESACTIVAR' where id=" + idRetornado;
       
        try {
            if (conexion.ejecutar(sql)) {
                JOptionPane.showMessageDialog(null, "Se elimino exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se elimino el producto");
            }
        } catch (Exception error) {
            System.out.println("Error al momento de eliminar : " + error);
            JOptionPane.showMessageDialog(null, "Error al momento de eliminar : " + error);
        }
    }

    public void restaurar(MdlProductos producto, int idRetornado) {
        conexionMensaje conexion = new conexionMensaje();
        String sql = "update products set state_record = 'ACTIVAR' where id=" + idRetornado;
       
        try {
            if (conexion.ejecutar(sql)) {
                JOptionPane.showMessageDialog(null, "Se restauro el producto exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No restauro el producto");
            }
        } catch (Exception error) {
            System.out.println("Error al momento de restaurar : " + error);
            JOptionPane.showMessageDialog(null, "Error al momento de restaurar : " + error);
        }
    }

// Función para que la imagen se ajuste al tamaño del label 
    public byte[] AbrirImagen(File archivo) {
        byte[] byteImg = new byte[1280 * 1080];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(byteImg);

        } catch (Exception e) {
        }
        return byteImg;
    }

    public ArrayList<MdlProductos> consulta() {
        conexionMensaje conexion = new conexionMensaje();
        ArrayList<MdlProductos> listaProductos = new ArrayList();
        ResultSet rs;
        String sql = "select * from products where state_record='ACTIVAR'";
        System.out.println("Consulta de Productos : " + sql);
        try {
            rs = conexion.consultar(sql);
            while (rs.next()) {
                MdlProductos mdlProductos = new MdlProductos();
                mdlProductos.setId(rs.getInt("id"));
                mdlProductos.setNameProduct(rs.getString("name_product"));
                mdlProductos.setPrice(rs.getInt("price"));
                mdlProductos.setDescripcion(rs.getString("decripcion"));
                mdlProductos.setCreateTime(rs.getTimestamp("create_time"));
                listaProductos.add(mdlProductos);
            }
        } catch (Exception error) {
            System.out.println("Error en consulta : " + error);
            JOptionPane.showMessageDialog(null, " Error en La Consulta de Productos");
        }
        return listaProductos;
    }

    public void guardarProductos(MdlProductos mdlProductos) {
        conexionMensaje conexion = new conexionMensaje();
        ResultSet rsgu;
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream = null;

        String carpetaDestino = "public_html/public/storage/imgProducts/";
        long timestamp = System.currentTimeMillis();
        String urlImagenOrigen = mdlProductos.getRutaImg();

        File archivo = new File(urlImagenOrigen);
        String img = archivo.getName();
        String nombreImagen = timestamp + "_";
        for (int i = 0; i < img.length(); i++) {
            if (img.charAt(i) == ' ') {
                nombreImagen += "";
            } else {
                nombreImagen += img.charAt(i);
            }
        }

////        int i = JOptionPane.showConfirmDialog(null, "Seguro Quieres Guardar El Producto?", "ADVERTENCIA", i = 0);
////        if (i == JOptionPane.YES_OPTION) {
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
        try {
            String sqlgu = "select * from products where name_product = '" + mdlProductos.getNameProduct() + "'";
            rsgu = conexion.consultar(sqlgu);
            if (rsgu.next()) {
                JOptionPane.showMessageDialog(null, "El Nombre del Producto Existe");
            } else {

                String sqlguardar = "insert into products(name_product,decripcion,price,picture,create_time,state_record)"
                        + "values('" + mdlProductos.getNameProduct() + "','" + mdlProductos.getDescripcion() + "','"
                        + mdlProductos.getPrice() + "','" + nombreImagen + "','" + mdlProductos.getCreateTime() + "','"
                        + mdlProductos.getStateRecord() + "')";
                System.out.println(sqlguardar);

                conexion.ejecutar(sqlguardar);
                JOptionPane.showMessageDialog(null, "Producto Agregado");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, " Error En Guardar Productos ");
            System.out.print(error);
        }
//        } else if (i == 1 || i == 2) {
//            JOptionPane.showMessageDialog(null, "Producto No Agregado");
//        }
    }

    public static String nombre_imagen;

    public void EditarProducto(MdlProductos mdlproducto) throws IOException {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fileInputStream = null;
        conexionMensaje conexion = new conexionMensaje();
        String carpetaDestino = "public_html/public/storage/imgProducts/";
        long timestamp = System.currentTimeMillis();
        String urlImagenOrigen = mdlproducto.getRutaImg();


       
        nombre_imagen = VstEditar_Producto.nombre_imagen;
         File archivoold = new File(nombre_imagen);
        String imgold = archivoold.getName();
        

        if (!urlImagenOrigen.startsWith("https://www.fincaturisticalaarboleda.com")) {
            File archivo = new File(urlImagenOrigen);
            String img = archivo.getName();
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
            ftpClient.disconnect();

            ftpClient.connect("ftp.fincaturisticalaarboleda.com", 21); // Establece la conexión FTP con el host y el puerto correspondientes
            ftpClient.login("admin@fincaturisticalaarboleda.com", "Cabins.123"); // Inicia sesión en el servidor FTP con las credenciales adecuadas
            ftpClient.changeWorkingDirectory("public_html/public/storage/imgProducts/");
            ftpClient.deleteFile(imgold);

            ftpClient.logout();
            ftpClient.disconnect();

            String sqlp = "update products set name_product = '" + mdlproducto.getNameProduct() + "',"
                    + " decripcion = '" + mdlproducto.getDescripcion() + "', price = '" + mdlproducto.getPrice()
                    + "', update_time = '" + mdlproducto.getUpdateTime() + "', picture = '" + nombreImagen
                    + "' where id = " + mdlproducto.getId();

            try {
                if (conexion.ejecutar(sqlp)) {
                    JOptionPane.showMessageDialog(null, "Se modificaron los datos satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(null, "los datos NO fueron modificados");
                }
            } catch (Exception error) {
                error.printStackTrace();
                JOptionPane.showMessageDialog(null, "error en la modificación del producto: " + error);
            }

        } else {
            String sqlp = "update products set name_product = '" + mdlproducto.getNameProduct() + "',"
                    + " decripcion = '" + mdlproducto.getDescripcion() + "', price = '" + mdlproducto.getPrice()
                    + "', update_time = '" + mdlproducto.getUpdateTime() + "' where id = " + mdlproducto.getId();

            try {
                if (conexion.ejecutar(sqlp)) {
                    JOptionPane.showMessageDialog(null, "Se modificaron los datos satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(null, "los datos NO fueron modificados");
                }
            } catch (Exception error) {
                error.printStackTrace();
                JOptionPane.showMessageDialog(null, "error en la modificación del producto: " + error);
            }
        }

    }

}
