package dtos;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class AsientoDTO {

    private String idAsiento;
    private String fila;
    private Integer numero;
    private UbicacionDTO ubicacion;
    private SeccionDTO seccion;
    /*
    igual, no le muevo pero es mejor que tenga su objeto completo
     */
    //private String idseccion;

    public AsientoDTO() {
    }

    public AsientoDTO(String fila, Integer numero, UbicacionDTO ubicacion, SeccionDTO seccion) {
        this.fila = fila;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.seccion = seccion;
    }

    public AsientoDTO(String idAsiento, String fila, Integer numero, UbicacionDTO ubicacion, SeccionDTO seccion) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.seccion = seccion;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public UbicacionDTO getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    public SeccionDTO getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionDTO seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "AsientoDTO{" + "idAsiento=" + idAsiento + ", fila=" + fila + ", numero=" + numero + ", ubicacion=" + ubicacion + ", seccion=" + seccion + '}';
    }
    
}
