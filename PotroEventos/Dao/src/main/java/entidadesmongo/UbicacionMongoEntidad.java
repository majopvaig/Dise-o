/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class UbicacionMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private String nombre;
    private Integer capacidad;
    private String tipoUbicacion;

    public UbicacionMongoEntidad() {
    }

    public UbicacionMongoEntidad(String nombre, Integer capacidad, String tipoUbicacion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipoUbicacion = tipoUbicacion;
    }

    public UbicacionMongoEntidad(ObjectId id, String nombre, Integer capacidad, String tipoUbicacion) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipoUbicacion = tipoUbicacion;
    }

    public ObjectId getId() {
        return id;
    }
    
    public String getIdComoTexto(){
        if(id == null){
            return null;
        }
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoUbicacion() {
        return tipoUbicacion;
    }

    public void setTipoUbicacion(String tipoUbicacion) {
        this.tipoUbicacion = tipoUbicacion;
    }

    @Override
    public String toString() {
        return "UbicacionMongoEntidad{" 
                + "id=" + getIdComoTexto() 
                + ", nombre=" + nombre 
                + ", capacidad=" + capacidad 
                + ", tipoUbicacion=" + tipoUbicacion + '}';
    }
    
}
