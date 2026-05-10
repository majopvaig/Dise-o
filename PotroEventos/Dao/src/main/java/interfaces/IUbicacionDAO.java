/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entitys.Seccion;
import Entitys.Ubicacion;
import excepciones.PersistenciaException;

/**
 *
 * @author maria
 */
public interface IUbicacionDAO {
    
    Ubicacion consultarPorID(String idUbicacion) throws PersistenciaException;
    
    Seccion buscarSeccionPorId(String idUbicacion, String idSeccion) throws PersistenciaException;
}
