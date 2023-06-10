/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author jeffe
 */
public class MdlProductos {
    private int id;
    private String nameProduct;
    private String descripcion;
    private float price;
    private String RutaImg;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String stateRecord;

    public MdlProductos(String string, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getRutaImg() {
        return RutaImg;
    }

    public void setRutaImg(String RutaImg) {
        this.RutaImg = RutaImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getStateRecord() {
        return stateRecord;
    }

    public void setStateRecord(String stateRecord) {
        this.stateRecord = stateRecord;
    }
    
public MdlProductos(){
    
}
       
    public MdlProductos(int id,String nameProduct, String descripcion, float price,String RutaImg, Timestamp createTime, Timestamp updateTime, String stateRecord) {
       this.id=id;
        this.nameProduct = nameProduct;
        this.descripcion = descripcion;
        this.price = price;
        this.RutaImg = RutaImg;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.stateRecord = stateRecord;
    }
    
    
}
