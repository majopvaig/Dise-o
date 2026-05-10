/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entitys;

import Entitys.ENUMS.TipoUbicacionP;
import java.util.List;

/**
 *
 * @author maria
 */
public class Ubicacion {

    private String idUbicacion;
    private String nombre;
    private Integer capacidad;
    private TipoUbicacionP tipo;
    private List<Seccion> secciones;

    public Ubicacion() {
    }

    public Ubicacion(String nombre, Integer capacidad, TipoUbicacionP tipo, List<Seccion> secciones) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.secciones = secciones;
    }

    public Ubicacion(String idUbicacion, String nombre, Integer capacidad, TipoUbicacionP tipo, List<Seccion> secciones) {
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

    public TipoUbicacionP getTipo() {
        return tipo;
    }

    public void setTipo(TipoUbicacionP tipo) {
        this.tipo = tipo;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

}
