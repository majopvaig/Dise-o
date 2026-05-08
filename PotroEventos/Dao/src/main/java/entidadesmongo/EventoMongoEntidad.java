/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesmongo;

import java.time.LocalDateTime;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 *
 * @author maria
 */
public class EventoMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private CategoriaMongoEntidad categoria;
    private String nombre;
    private String informacion;
    private LocalDateTime fechaHora;
    private UbicacionMongoEntidad ubicacion;
    private String estado;
    private String urlImagen;
    private boolean gratuito;
    private String tipo;
    private int disponibilidad;

    public EventoMongoEntidad() {
    }

    public EventoMongoEntidad(CategoriaMongoEntidad categoria, String nombre, String informacion, LocalDateTime fechaHora, UbicacionMongoEntidad ubicacion, String estado, String urlImagen, boolean gratuito, String tipo, int disponibilidad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.informacion = informacion;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.urlImagen = urlImagen;
        this.gratuito = gratuito;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public EventoMongoEntidad(ObjectId id, CategoriaMongoEntidad categoria, String nombre, String informacion, LocalDateTime fechaHora, UbicacionMongoEntidad ubicacion, String estado, String urlImagen, boolean gratuito, String tipo, int disponibilidad) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.informacion = informacion;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.urlImagen = urlImagen;
        this.gratuito = gratuito;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public String getIdComoTexto(){
        if(id == null){
            return null;
        }
        return id.toHexString();
    }

    public CategoriaMongoEntidad getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMongoEntidad categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public UbicacionMongoEntidad getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionMongoEntidad ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "EventoMongoEntidad{" 
                + "id=" + getIdComoTexto() 
                + ", categoria=" + categoria 
                + ", nombre=" + nombre 
                + ", informacion=" + informacion 
                + ", fechaHora=" + fechaHora 
                + ", ubicacion=" + ubicacion 
                + ", estado=" + estado 
                + ", urlImagen=" + urlImagen 
                + ", gratuito=" + gratuito 
                + ", tipo=" + tipo 
                + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
