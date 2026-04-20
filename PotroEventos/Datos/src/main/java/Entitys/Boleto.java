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

    private Long idBoleto;
    private String codigoQR;
    private Double precio;
    private LocalDate fechaCompra;
    private EstadoBoleto estadoBoleto;
    private Usuario usuario;

    public Boleto() {
    }

    public Boleto(Long idBoleto, String codigoQR, Double precio, LocalDate fechaCompra, EstadoBoleto estadoBoleto, Usuario usuario) {
        this.idBoleto = idBoleto;
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.estadoBoleto = estadoBoleto;
        this.usuario = usuario;
    }

    public Boleto(String codigoQR, Double precio, LocalDate fechaCompra, EstadoBoleto estadoBoleto, Usuario usuario) {
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.estadoBoleto = estadoBoleto;
        this.usuario = usuario;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
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

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public EstadoBoleto getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Boleto{" + "idBoleto=" + idBoleto + ", codigoQR=" + codigoQR + ", precio=" + precio + ", fechaCompra=" + fechaCompra + ", estadoBoleto=" + estadoBoleto + ", usuario=" + usuario + '}';
    }

}
