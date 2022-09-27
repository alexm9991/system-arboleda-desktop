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
                servicios.setFecha_modificacion(rs.getDate("update_time"));
                servicios.setEstado(rs.getString("state_record"));

                //     servicios = consultarServicio(servicios);
                lista.add(servicios);
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de servicios" + error);
        }
        return lista;
    }

    //CONSULTAR IMAGANES DE LA TABLA RESOURCES
    public ArrayList<MdlServicios> consultar_imagen(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ArrayList<MdlServicios> lista_imagen = new ArrayList();
        MdlServicios servicios = new MdlServicios();
        ResultSet rs, rsID;
        String sqlID = "select id from services where tittle = '" + servicio.getNombre_servicio() + "'";
        System.out.println(servicio.getNombre_servicio());
        try {
            rsID = conectar.consultar(sqlID);

            while (rsID.next()) {
                servicio.setId(rsID.getInt("id"));
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de imagenes ID" + error);
        }
        System.out.println(servicio.getId());
        String sql = "select url from resources r join detail_services d on r.detail_services_id = d.id join services s on d.services_id = s.id where s.id =" + servicio.getId();

        try {
            rs = conectar.consultar(sql);

            while (rs.next()) {

               // servicio.setUrls(rs.getURL("url"));
                System.out.println(servicio.getUrls());
                lista_imagen.add(servicios);
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de imagenes" + error);
        }
        return lista_imagen;
    }

    //CONSULTAR PRECIOS Y TOTAL DE PERSONAS, DE ACUERDO AL ID SELECCIONADO
    public void consultarPrecios(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, rss, rsss;
        String sql = "select price from type_for_services where services_id = " + servicio.getId() + " and types_individuals_id = 1";
        String sqlDos = "select price from type_for_services where services_id = " + servicio.getId() + " and types_individuals_id = 2";
        String sqlTres = "select max_individuals from type_for_services where services_id = " + servicio.getId() + " and types_individuals_id = 1";
        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);
        rsss = conectar.consultar(sqlTres);

        try {

            while (rs.next()) {
                servicio.setP_adulto(rs.getInt("price"));
            }
            while (rss.next()) {
                servicio.setP_nino(rss.getInt("price"));
            }
            while (rsss.next()) {
                servicio.setTotal(rsss.getInt("max_individuals"));
            }

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio id ds" + error);
        }

    }

    //INSERT DE LA TABLA RESOURCES
    public void insertarRe(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        VstServicios vstServicios = new VstServicios();
        ResultSet rs;
        String sql = "select id from detail_services where tittle = '" + servicio.getNombre_servicio() + "'";
        rs = conectar.consultar(sql);
        try {

            while (rs.next()) {
                servicio.setIdFUno(rs.getInt("id"));
            }
            System.out.println("aqui");
            try {
                System.out.println("1");
                
                servicio.getUrls().stream().forEach(url ->{
                    String c = "insert into resources(url,detail_services_id)"
                            + "values('" + url + "'," + servicio.getId() + ")";
                    try {
                        conectar.ejecutar(c);
                    } catch (SQLException e){
                        e.printStackTrace();
                    }
                });
               
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "no se ve");
                System.out.println("no se ve jeje");
            }

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
                servicio.setIdFUno(rs.getInt("id"));
            }
            String sqlguDos = "insert into detail_services(tittle,description,state_record,services_id)"
                    + "values('" + servicio.getNombre_servicio() + "','" + servicio.getDescripcion() + "','" + servicio.getEstado() + "'," + servicio.getIdFUno() + ")";

            if (conectar.ejecutar(sqlguDos)) {
                System.out.println("detalle creado");
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
        String sqlDos = "select id from types_individuals where tittle = 'adulto'";
        String sqlTres = "select id from types_individuals where tittle = 'niño'";
        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);
        rsss = conectar.consultar(sqlTres);
        try {
            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }
            while (rss.next()) {
                servicio.setIdFUno(rss.getInt("id"));
            }
            while (rsss.next()) {
                servicio.setIdFDos(rsss.getInt("id"));
            }

            String sqlgu = "insert into type_for_services(max_individuals,price,services_id,types_individuals_id)"
                    + "values(" + servicio.getTotal() + "," + servicio.getP_adulto() + "," + servicio.getId() + "," + servicio.getIdFUno() + ")";

            String sqlguDos = "insert into type_for_services(max_individuals,price,services_id,types_individuals_id)"
                    + "values(" + servicio.getTotal() + "," + servicio.getP_nino() + "," + servicio.getId() + "," + servicio.getIdFDos() + ")";

            if (conectar.ejecutar(sqlgu) && conectar.ejecutar(sqlguDos)) {
                System.out.println("Precios registrados");

            } else {
                JOptionPane.showMessageDialog(null, "El precio no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio, precios" + error);
        }
    }

    //INSERT DE LA TABLA RULES
    public void insertarRu(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, rss;
        String sql = "select id from type_for_services where types_individuals_id = 1 and services_id = " + servicio.getId();
        String sqlDos = "select id from type_for_services where types_individuals_id = 2 and services_id = " + servicio.getId();
        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);

        try {
            while (rs.next()) {
                servicio.setIdFUno(rs.getInt("id"));
            }
            while (rss.next()) {
                servicio.setIdFDos(rss.getInt("id"));
            }

            String sqlgu = "insert into rules(tittle,description,age_min,age_max,people_for_services_id)"
                    + "values('ADULTO','Precio de persona adulta es desde los 8 hasta los 100 años de edad',8,100," + servicio.getIdFUno() + ")";

            String sqlguDos = "insert into rules(tittle,description,age_min,age_max,people_for_services_id)"
                    + "values('NIÑO','Precio de niños es desde los 3 hasta los 7 años de edad',3,7," + servicio.getIdFDos() + ")";
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
//                insertarRe(servicio);
                insertarIFS(servicio);
                insertarRu(servicio);

                JOptionPane.showMessageDialog(null, "El servicio fue creado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El servicio no fue creado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en crear servicio" + error);
        }
    }

    //MODIFICAR TODOS LOS CAMPOS DEL SERVICIO
    public void modificar(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        LocalDateTime todaysDate = LocalDateTime.now();
        String sqlp = "update services set tittle = '" + servicio.getNombre_servicio()
                + "', description = '" + servicio.getDescripcion()
                + "', state_record = '" + servicio.getEstado() + "', update_time = '" + todaysDate + "' where id = " + servicio.getId();
        try {
            if (conectar.ejecutar(sqlp)) {
                modificarIFS(servicio);

                JOptionPane.showMessageDialog(null, "Se modificaron los datos satisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificaron");
            }
        } catch (Exception error) {
            System.out.println("Error en modificacion del servicio" + error);
        }
    }

    //UPDATE DE LA TABLA INDIVIDUALS_FOR_SERVICES
    public void modificarIFS(MdlServicios servicio) {
        conexionMensaje conectar = new conexionMensaje();
        ResultSet rs, rss, rsss;
        String sql = "select id from services where tittle = '" + servicio.getNombre_servicio() + "'";
        String sqlDos = "select id from types_individuals where tittle = 'adulto'";
        String sqlTres = "select id from types_individuals where tittle = 'niño'";
        rs = conectar.consultar(sql);
        rss = conectar.consultar(sqlDos);
        rsss = conectar.consultar(sqlTres);
        try {
            while (rs.next()) {
                servicio.setId(rs.getInt("id"));
            }
            while (rss.next()) {
                servicio.setIdFUno(rss.getInt("id"));
            }
            while (rsss.next()) {
                servicio.setIdFDos(rsss.getInt("id"));
            }
            String sqlgu = "update type_for_services set max_individuals = " + servicio.getTotal() + ", price = " + servicio.getP_adulto()
                    + " where services_id = " + servicio.getId() + " and types_individuals_id = " + servicio.getIdFUno();

            String sqlguDos = "update type_for_services set max_individuals = " + servicio.getTotal() + ", price = " + servicio.getP_nino() + " "
                    + " where services_id = " + servicio.getId() + " and types_individuals_id = " + servicio.getIdFDos();
            if (conectar.ejecutar(sqlgu) && conectar.ejecutar(sqlguDos)) {
                System.out.println("Precios modificados");
            } else {
                JOptionPane.showMessageDialog(null, "El precio no fue modificado");
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Error en modificar servicio, precios" + error);
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
