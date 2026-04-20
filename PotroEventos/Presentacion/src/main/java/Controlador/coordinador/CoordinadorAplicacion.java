package Controlador.coordinador;

import Controlador.interfaz.ICoordinadorAplicacion;
import Pantallas.FrmInicioSesion;
import Pantallas.FrmPago;
import Pantallas.FrmPlantillaSistema;
import Pantallas.FrmRegistrarse;
import Pantallas.FrmDetallesCompra;
import Pantallas.FrmRegistroItson;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class CoordinadorAplicacion implements ICoordinadorAplicacion {

    private FrmInicioSesion frmInicioSesion;
    private FrmRegistrarse frmRegistrarse;
    private FrmPago frmPago;
    private FrmPlantillaSistema frmPlantilla;
    private FrmDetallesCompra frmDetalles;
    private FrmRegistroItson frmRegistro;

    private void ocultarTodo() {
        if (frmInicioSesion != null) {
            frmInicioSesion.setVisible(false);
        }
        if (frmRegistrarse != null) {
            frmRegistrarse.setVisible(false);
        }

    }

    @Override
    public void iniciaSistema() {
        if (frmInicioSesion == null) {
            frmInicioSesion = new FrmInicioSesion(this);
        }
        frmInicioSesion.setVisible(true);
        frmInicioSesion.setLocationRelativeTo(null);
    }

    @Override
    public void mostrarInicioSesion() {
        ocultarTodo();
        if (frmInicioSesion == null) {
            frmInicioSesion = new FrmInicioSesion(this);
        }
        frmInicioSesion.setVisible(true);
        frmInicioSesion.setLocationRelativeTo(null);
    }

    @Override
    public void mostrarRegistro() {
        ocultarTodo();
        if (frmRegistrarse == null) {
            frmRegistrarse = new FrmRegistrarse(this);
        }
        frmRegistrarse.setVisible(true);
        frmRegistrarse.setLocationRelativeTo(null);
    }

    @Override
    public void mostrarInicio() {
        if (frmPlantilla == null) {
            frmPlantilla = new FrmPlantillaSistema(this);
        }
        this.frmPlantilla.setVisible(true);
        frmInicioSesion.dispose();
    }

    @Override
    public void mostrarConsultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarInfoEvento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void finalizarCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarEventos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void volverAEventos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarConsultarEvento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void volverAConsultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
