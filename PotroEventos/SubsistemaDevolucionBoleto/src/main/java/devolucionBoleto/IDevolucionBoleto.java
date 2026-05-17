/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package devolucionBoleto;

import dtos.DevolucionDTO;
import dtos.ENUMS.TipoDevolucionN;
import dtos.ReservacionDTO;
import excepciones.DevolucionBoletoException;

/**
 *
 * @author maria
 */
public interface IDevolucionBoleto {
    
    
    boolean realizarDevolucionGratuita(ReservacionDTO reservacion, DevolucionDTO devolucion) throws DevolucionBoletoException;
    
    boolean realizarDevolucionPago(ReservacionDTO resercacion, TipoDevolucionN tipo, DevolucionDTO devolucion) throws DevolucionBoletoException;
}
