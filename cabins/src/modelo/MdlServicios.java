package modelo;

import java.util.Date;

public class MdlServicios {

    private int id;
    private int idFUno;
    private int total;
    private String reglas;
    private String url;
    private String nombre_img;
    private String nombre_servicio;
    private String nombre_detalle_servicio;
    private String descripcion;
    private String estado;
    private Date fecha_registro;
    private Date fecha_modificacion;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNombre_img() {
        return nombre_img;
    }

    public void setNombre_img(String nombre_img) {
        this.nombre_img = nombre_img;
    }

    public String getNombre_detalle_servicio() {
        return nombre_detalle_servicio;
    }

    public void setNombre_detalle_servicio(String nombre_detalle_servicio) {
        this.nombre_detalle_servicio = nombre_detalle_servicio;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre_servicio) {
        this.nombre_servicio = nombre_servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getIdFUno() {
        return idFUno;
    }

    public void setIdFUno(int idFUno) {
        this.idFUno = idFUno;
    }
}
