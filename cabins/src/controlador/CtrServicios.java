package controlador;

import conexion.conexionMensaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MdlServicios;
import vista.VstServicios;

public class CtrServicios {

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
                servicios.setFecha_registro(rs.getDate("create_time"));
                servicios.setFecha_actualizacion(rs.getDate("update_time"));
                servicios.setEstado(rs.getString("state_record"));

                //     servicios = consultarServicio(servicios);
                lista.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de servicios" + error);
        }
        return lista;
    }
    //Consultar imagen

    public ArrayList<MdlServicios> consultar_imagen() {
        conexionMensaje conectar = new conexionMensaje();
        ArrayList<MdlServicios> lista_imagen = new ArrayList();
        ResultSet rs;
        String sql = "select * from resources join detail_services on detail_services_id.resources = id.detail_services join services on services_id.detail_services = id.services";
        try {
            rs = conectar.consultar(sql);
            while (rs.next()) {
                MdlServicios servicios = new MdlServicios();
                servicios.setId(rs.getInt("id"));
                servicios.setUrl(rs.getString("url"));

                lista_imagen.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de imagenes" + error);
        }
        return lista_imagen;
    }

    //CONSULTAR PRECIOS DE ACUERDO AL ID SELECCIONADO
    public void consultarPrecios(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        VstServicios vst = new VstServicios();
        ResultSet rs;
        String sql = "select  from detail_services where tittle = '" + servicio.getNombre_servicio() + "'";
        rs = conectar.consultar(sql);
        try {

            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }

            //guardarImagenCtr(servicio);
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id ds" + error);
        }

    }

    //INSERT DE LA TABLA RESOURCES
    public void insertarRe(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        VstServicios vstclientes = new VstServicios();
        ResultSet rs;
        String sql = "select id from detail_services where tittle = '" + servicio.getNombre_servicio() + "'";
        rs = conectar.consultar(sql);
        try {

            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }

            vstclientes.guardarImagenDB(servicio);

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id ds" + error);
        }

    }

    //INSERT DE LA TABLA DETAIL_SERVICES
    public void insertarDS(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs;
        String sql = "select id from services where tittle = '" + servicio.getNombre_servicio() + "'";
        rs = conectar.consultar(sql);
        try {

            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }

            String sqlguDos = "insert into detail_services(tittle,description,state_record,services_id)"
                    + "values('" + servicio.getNombre_servicio() + "','" + servicio.getDescripcion() + "','" + servicio.getEstado() + "'," + servicio.getId() + ")";

            if (conectar.ejecutar(sqlguDos)) {

            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id s" + error);
        }

    }

    //INSERT DE LA TABLA INDIVIDUALS_FOR_SERVICES
    public void insertarIFS(MdlServicios servicio) {

        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, rss, rsss;
        String sql = "select id from services where tittle = '" + servicio.getNombre_servicio() + "'";
        String sqlDos = "select id from types_individuals where id = 1";
        String sqlTres = "select id from types_individuals where id = 2";
        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);
        rsss = conectar.consultar(sqlTres);
        try {

            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }
            while (rss.next()) {
                servicio.setIdFUno(rs.getInt("id"));
            }
            while (rsss.next()) {
                servicio.setIdFDos(rs.getInt("id"));
            }

            String sqlgu = "insert into individual_for_services(total_individuals,services_id,types_individuals_id,)"
                    + "values(" + servicio.getTotal() + "','" + servicio.getId() + "','" + servicio.getIdFUno() + ")";

            String sqlguDos = "insert into individual_for_services(total_individuals,services_id,types_individuals_id,)"
                    + "values(" + servicio.getTotal() + "','" + servicio.getId() + "','" + servicio.getIdFDos() + ")";

            if (conectar.ejecutar(sqlgu) && conectar.ejecutar(sqlguDos)) {
                System.out.println("Precios registrados");

            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id s" + error);
        }
    }

    public void insertarRu(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, rss;
        String sql = "select id from individual_for_services where type_individuals_id = 1 and services_id = " + servicio.getId();
        String sqlDos = "select id from individual_for_services where type_individuals_id = 2 and services_id = " + servicio.getId();

        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);

        try {

            while (rs.next()) {
                servicio.setIdFUno(rs.getInt("type_individuals_id"));
            }
            while (rss.next()) {
                servicio.setIdFDos(rs.getInt("type_individuals_id"));
            }

            String sqlgu = "insert into rules(tittle,description,age_min,age_max,people_for_services_id)"
                    + "values('ADULTO','PERSONA ADULTA JEJE','8','100'," + servicio.getIdFUno() + ")";

            String sqlguDos = "insert into rules(tittle,description,age_min,age_max,people_for_services_id)"
                    + "values('NIÑO','PERSONA NIÑO JEJE','3','7'," + servicio.getIdFDos() + ")";

            if (conectar.ejecutar(sqlgu) && conectar.ejecutar(sqlguDos)) {
                System.out.println("Reglas registradas");

            } else {
                JOptionPane.showMessageDialog(null, "Reglas no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id s" + error);
        }
    }

    //METODO PARA GUARDAR UN SERVICIO
    public void guardarServicio(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();

        String sqlgu = "insert into services(tittle,description,state_record)"
                + "values('" + servicio.getNombre_servicio() + "','" + servicio.getDescripcion() + "','" + servicio.getEstado() + "')";

        try {
            if (conectar.ejecutar(sqlgu)) {

                insertarDS(servicio);
                insertarRe(servicio);
                insertarIFS(servicio);
                insertarRu(servicio);

                JOptionPane.showMessageDialog(null, "El servicio fue creado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio" + error);
        }
        //Gurdar detail_services        
    }

    public void modificar(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        LocalDateTime todaysDate = LocalDateTime.now();
        String sqlp = "update services set tittle = '" + servicio.getNombre_servicio()
                + "', description = '" + servicio.getDescripcion()
                + "', state_record = '" + servicio.getEstado() + "', update_time = '" + todaysDate + "' where id = " + servicio.getId();
        System.out.println("actualizar servicio: " + sqlp);

        try {
            if (conectar.ejecutar(sqlp)) {
                JOptionPane.showMessageDialog(null, "Se modificaron los datos satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificaron");
            }
        } catch (Exception error) {
            System.out.println("Error en modificacion del servicio" + error);
        }
    }

    /**
     * public Mdl_Servicios consultarServicio(Mdl_Servicios servicio) { Conexion
     * conectar = new Conexion(); ResultSet rs; String sql = "select * from
     * services where id = " + servicio.getId(); try { rs =
     * conectar.consultar(sql); if (rs.next()) {
     * servicio.setNombres(rs.getString("nombres"));
     * servicio.setApellidos(rs.getString("apellidos"));
     * servicio.setIdentificaicon(rs.getString("identificacion"));
     * cliente.setTipo_identificacion(rs.getString("tipo_identificacion"));
     * cliente.setNatalicio(rs.getDate("natalicio"));
     * cliente.setDireccion(rs.getString("direccion"));
     * cliente.setCelular(rs.getString("telefono"));
     * cliente.setCorreo(rs.getString("email"));
     * cliente.setLugar_residencia(rs.getString("lugar_residencia"));
     * cliente.setGenero(rs.getString("genero")); } } catch (SQLException error)
     * { JOptionPane.showMessageDialog(null, "Error en la consulta de
     * personas"); } return cliente; }
     */
}
