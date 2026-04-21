package dtos;

import dtos.ENUMS.CategoriaEventoDTO;
import dtos.ENUMS.EstadoEventoDTO;
import java.time.LocalDateTime;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class EventoDTO {

    private Long idEvento;
    private String nombreEvento;
    private EstadoEventoDTO estadoEvento;
    private String informacionEvento;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private CategoriaDTO categoriaDTO;
    private String urlImagen;

    public EventoDTO() {
    }

    public EventoDTO(Long idEvento, CategoriaDTO categoriaDTO, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEventoDTO estadoEvento, String urlImagen) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.categoriaDTO = categoriaDTO;
        this.urlImagen = urlImagen;
        this.estadoEvento = estadoEvento;
    }

    public EventoDTO(CategoriaDTO categoriaDTO, String nombreEvento, String informacionEvento, LocalDateTime fechaHora, String ubicacion, EstadoEventoDTO estadoEvento, String urlImagen) {
        this.nombreEvento = nombreEvento;
        this.informacionEvento = informacionEvento;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.categoriaDTO = categoriaDTO;
        this.urlImagen = urlImagen;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
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

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public EstadoEventoDTO getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEventoDTO estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    @Override
    public String toString() {
        return "EventoDTO{" + "idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", informacionEvento=" + informacionEvento + ", fechaHora=" + fechaHora + ", ubicacion=" + ubicacion + ", categoriaDTO=" + categoriaDTO.getNombreCategoria() + ", urlImagen=" + urlImagen + '}';
    }

}
