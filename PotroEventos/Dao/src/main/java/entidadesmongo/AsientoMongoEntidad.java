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
public class AsientoMongoEntidad {
    
    @BsonId
    private ObjectId id;
    
    private String fila;
    private int numero;
    private SeccionMongoEntidad seccion;

    public AsientoMongoEntidad() {
    }

    public AsientoMongoEntidad(String fila, int numero, SeccionMongoEntidad seccion) {
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
    }

    public AsientoMongoEntidad(ObjectId id, String fila, int numero, SeccionMongoEntidad seccion) {
        this.id = id;
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
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

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public SeccionMongoEntidad getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionMongoEntidad seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "AsientoMongoEntidad{" 
                + "id=" + id 
                + ", fila=" + fila 
                + ", numero=" + numero 
                + ", seccion=" + seccion + '}';
    }
    
}
    