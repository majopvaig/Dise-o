/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import dtos.ENUMS.TipoUbicacionN;
import java.util.List;

/**
 *
 * @author maria
 */
public class UbicacionDTO {

    private String idUbicacion;
    private String nombre;
    private Integer capacidad;
    private TipoUbicacionN tipo;
    private List<SeccionDTO> secciones;

    public UbicacionDTO() {
    }

    public UbicacionDTO(String nombre, Integer capacidad, TipoUbicacionN tipo) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public UbicacionDTO(String nombre, Integer capacidad, TipoUbicacionN tipo, List<SeccionDTO> secciones) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.secciones = secciones;
    }

    public UbicacionDTO(String idUbicacion, String nombre, Integer capacidad, TipoUbicacionN tipo, List<SeccionDTO> secciones) {
        this.idUbicacion = idUbicacion;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.secciones = secciones;
    }

    public String getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(String idUbicacion) {
        this.idUbicacion = idUbicacion;
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

    public TipoUbicacionN getTipo() {
        return tipo;
    }

    public void setTipo(TipoUbicacionN tipo) {
        this.tipo = tipo;
    }

    public List<SeccionDTO> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionDTO> secciones) {
        this.secciones = secciones;
    }

}
