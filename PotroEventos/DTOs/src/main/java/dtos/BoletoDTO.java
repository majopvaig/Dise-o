package dtos;

import dtos.ENUMS.EstadoBoletoDTO;
import java.time.LocalDate;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class BoletoDTO {

    private Long idBoleto;
    private String codigoQR;
    private Double precio;
    private LocalDate fechaCompra;
    private EstadoBoletoDTO estadoBoleto;
    private Long idUsuario;

    public BoletoDTO() {
    }

    public BoletoDTO(Long idBoleto, String codigoQR, Double precio, LocalDate fechaCompra, EstadoBoletoDTO estadoBoleto, Long idUsuario) {
        this.idBoleto = idBoleto;
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.estadoBoleto = estadoBoleto;
        this.idUsuario = idUsuario;
    }

    public BoletoDTO(String codigoQR, Double precio, LocalDate fechaCompra, EstadoBoletoDTO estadoBoleto, Long idUsuario) {
        this.codigoQR = codigoQR;
        this.precio = precio;
        this.fechaCompra = fechaCompra;
        this.estadoBoleto = estadoBoleto;
        this.idUsuario = idUsuario;
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

    public EstadoBoletoDTO getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoBoletoDTO estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "BoletoDTO{" + "idBoleto=" + idBoleto + ", codigoQR=" + codigoQR + ", precio=" + precio + ", fechaCompra=" + fechaCompra + ", estadoBoleto=" + estadoBoleto + ", idUsuario=" + idUsuario + '}';
    }

}
