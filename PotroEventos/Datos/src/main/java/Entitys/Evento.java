package Entitys;

import Entitys.ENUMS.CategoriaEvento;
import Entitys.ENUMS.EstadoEvento;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class Evento {

    private Long idEvento;
    private CategoriaEvento categoriaEvento;
    private String nombreEvento;
    private String informacionEvento;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private EstadoEvento estadoEvento;

    public Evento() {
    }

    public Evento(Long idEvento, CategoriaEvento categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion) {
        this.idEvento = idEvento;
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
    }

    public Evento(CategoriaEvento categoriaEvento, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion) {
        this.categoriaEvento = categoriaEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public CategoriaEvento getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getInformacionEvento() {
        return informacionEvento;
    }

    public void setInformacionEvento(String informacionEvento) {
        this.informacionEvento = informacionEvento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idEvento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        return Objects.equals(this.idEvento, other.idEvento);
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", categoriaEvento=" + categoriaEvento + ", nombreEvento=" + nombreEvento + ", informacionEvento=" + informacionEvento + ", fechaHora=" + fechaHora + ", ubicacion=" + ubicacion + '}';
    }

}
