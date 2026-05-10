package Entitys;

import Entitys.ENUMS.EstadoBoleto;
import java.time.LocalDate;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class Boleto {

    private String codigoQR;
    private Double precio;
    private EstadoBoleto estadoBoleto;
    private Evento evento;
    private AsientoEvento asiento;

    public Boleto() {
    }

    public Boleto(String codigoQR, Double precio, EstadoBoleto estadoBoleto, Evento evento, AsientoEvento asiento) {
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.estadoBoleto = estadoBoleto;
        this.evento = evento;
        this.asiento = asiento;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public EstadoBoleto getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public AsientoEvento getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoEvento asiento) {
        this.asiento = asiento;
    }

}
