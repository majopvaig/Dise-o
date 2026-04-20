package Entitys;

import Entitys.ENUMS.EstadoAsiento;
import java.util.Objects;

/**
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class Asiento {

    private Long idAsiento;
    private String fila;
    private Integer numero;
    private Seccion seccion;

    public Asiento() {
    }

    public Asiento(Long idAsiento, String fila, Integer numero, Seccion seccion) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
    }

    public Asiento(String fila, Integer numero, Seccion seccion) {
        this.fila = fila;
        this.numero = numero;
        this.seccion = seccion;
    }

    public Long getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Long idAsiento) {
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

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idAsiento);
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
        final Asiento other = (Asiento) obj;
        return Objects.equals(this.idAsiento, other.idAsiento);
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", fila=" + fila + ", numero=" + numero + ", seccion=" + seccion + '}';
    }

}
