package modelo;

import java.util.Date;
import java.util.List;

public class MdlServicios {

    private int id;
    private String nombre_servicio;
    private String descripcion;
    private String estado;
    private Date fecha_registro;
    private Date fecha_modificacion;
    private int p_adulto;
    private int p_nino;
    private List<String> urls;
    private int idFUno;
    private int idFDos;
    private int total;
    
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

    public int getP_adulto() {
        return p_adulto;
    }

    public void setP_adulto(int p_adulto) {
        this.p_adulto = p_adulto;
    }

    public int getP_nino() {
        return p_nino;
    }

    public void setP_nino(int p_nino) {
        this.p_nino = p_nino;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

   
    public int getIdFUno() {
        return idFUno;
    }

    public void setIdFUno(int idFUno) {
        this.idFUno = idFUno;
    }

    public int getIdFDos() {
        return idFDos;
    }

    public void setIdFDos(int idFDos) {
        this.idFDos = idFDos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
