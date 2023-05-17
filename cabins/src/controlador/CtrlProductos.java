package Controlador;

import Modelo.MdlProductos;
import conexion.conexionMensaje;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlProductos {
    
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
     public ArrayList<MdlProductos> consultaProductos() {
        conexionMensaje conecta = new conexionMensaje();
        ArrayList<MdlProductos> listaProductos = new ArrayList();
        ResultSet rs;
        String sql = "select * from products where state_record='ACTIVAR'";
        System.out.println("Consulta de Productos : " + sql);
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
        System.out.println("Consulta de Productos : " + sql);
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
        String sql = "select * from products where id="+idRetornado;
        System.out.println("Consulta de Productos : " + sql);
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
      
      public void eliminar(MdlProductos producto, int idRetornado){
        conexionMensaje conexion = new conexionMensaje();
        String sql = "update products set state_record = 'DESACTIVAR' where id="+idRetornado;
        System.out.println("Consulta de Productos : " + sql);
        try {
            if(conexion.ejecutar(sql)){
               JOptionPane.showMessageDialog(null,"Se elimino exitosamente"); 
            }else{
                JOptionPane.showMessageDialog(null,"No se elimino el producto");
            }
        } catch (Exception error) {
            System.out.println("Error al momento de eliminar : " + error);
            JOptionPane.showMessageDialog(null, "Error al momento de eliminar : " + error);
        }
      }
       
      public void restaurar(MdlProductos producto, int idRetornado){
        conexionMensaje conexion = new conexionMensaje();
        String sql = "update products set state_record = 'ACTIVAR' where id="+idRetornado;
        System.out.println("Consulta de Productos : " + sql);
        try {
            if(conexion.ejecutar(sql)){
               JOptionPane.showMessageDialog(null,"Se restauro el producto exitosamente"); 
            }else{
                JOptionPane.showMessageDialog(null,"No restauro el producto");
            }
        } catch (Exception error) {
            System.out.println("Error al momento de restaurar : " + error);
            JOptionPane.showMessageDialog(null, "Error al momento de restaurar : " + error);
        }
      }
      
      public void borrar(MdlProductos producto, int idRetornado){
        conexionMensaje conexion = new conexionMensaje();
        String sql = "update products set state_record = 'borrar' where id="+idRetornado;
        System.out.println("Consulta de Productos : " + sql);
        try {
            if(conexion.ejecutar(sql)){
               JOptionPane.showMessageDialog(null,"Se ha borrado el producto exitosamente"); 
            }else{
                JOptionPane.showMessageDialog(null,"No se ha borrado el producto");
            }
        } catch (Exception error) {
            System.out.println("Error al momento de borrar : " + error);
            JOptionPane.showMessageDialog(null, "Error al momento de borrar : " + error);
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
//        int i = JOptionPane.showConfirmDialog(null, "Seguro Quieres Guardar El Producto?", "ADVERTENCIA", i = 0);
//        if (i == JOptionPane.YES_OPTION) {
            try {
                String sqlgu = "select * from products where name_product = '" + mdlProductos.getNameProduct() + "'";
                rsgu = conexion.consultar(sqlgu);
                if (rsgu.next()) {
                    JOptionPane.showMessageDialog(null, "El Nombre del Producto Existe");
                } else {
                    JOptionPane.showMessageDialog(null, "Producto Agregado");
                    String nuevo = mdlProductos.getRutaImg().replaceAll("\\\\", "\\\\\\\\");
                    String sqlguardar = "insert into products(name_product,decripcion,price,picture,create_time,state_record)"
                            + "values('" + mdlProductos.getNameProduct() + "','" + mdlProductos.getDescripcion() + "','"
                            + mdlProductos.getPrice() + "','" + nuevo +"','"+mdlProductos.getCreateTime()+"','"
                            + mdlProductos.getStateRecord() + "')";
                   
                    conexion.ejecutar(sqlguardar);
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, " Error En Guardar Productos ");
                System.out.print(error);
            }
//        } else if (i == 1 || i == 2) {
//            JOptionPane.showMessageDialog(null, "Producto No Agregado");
//        }
    }

     public void EditarProducto(MdlProductos mdlproducto) {
        conexionMensaje conexion = new conexionMensaje();
        String nuevo = mdlproducto.getRutaImg().replaceAll("\\\\", "\\\\\\\\");
        String sqlp = "update products set name_product = '" + mdlproducto.getNameProduct() + "',"
                + " decripcion = '" + mdlproducto.getDescripcion() + "', price = '" + mdlproducto.getPrice()
                + "', update_time = '" + mdlproducto.getUpdateTime()+ "', picture = '"+ nuevo
                + "' where id = " +mdlproducto.getId();
    
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

