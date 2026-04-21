package dtos;

/**
 * Objeto de transferencia de datos que contiene la información necesaria de una
 * tarjeta bancaria para procesar un pago.
 *
 * Este DTO se utiliza para transportar los datos entre capas del sistema sin
 * exponer lógica de negocio.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class TarjetaDTO {

    /**
     * Número de la tarjeta bancaria.
     */
    private String numero;

    /**
     * Mes de expiración de la tarjeta.
     */
    private int mesExpiracion;

    /**
     * Año de expiración de la tarjeta.
     */
    private int anioExpiracion;

    /**
     * Código de seguridad de la tarjeta.
     */
    private String cvc;

    /**
     * Constructor por defecto.
     */
    public TarjetaDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param numero número de la tarjeta
     * @param mesExpiracion mes de expiración
     * @param anioExpiracion año de expiración
     * @param cvc código de seguridad
     */
    public TarjetaDTO(String numero, int mesExpiracion, int anioExpiracion, String cvc) {
        this.numero = numero;
        this.mesExpiracion = mesExpiracion;
        this.anioExpiracion = anioExpiracion;
        this.cvc = cvc;
    }

    /**
     * Obtiene el número de tarjeta.
     *
     * @return número de tarjeta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de tarjeta.
     *
     * @param numero número de tarjeta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el mes de expiración.
     *
     * @return mes de expiración
     */
    public int getMesExpiracion() {
        return mesExpiracion;
    }

    /**
     * Establece el mes de expiración.
     *
     * @param mesExpiracion mes de expiración
     */
    public void setMesExpiracion(int mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    /**
     * Obtiene el año de expiración.
     *
     * @return año de expiración
     */
    public int getAnioExpiracion() {
        return anioExpiracion;
    }

    /**
     * Establece el año de expiración.
     *
     * @param anioExpiracion año de expiración
     */
    public void setAnioExpiracion(int anioExpiracion) {
        this.anioExpiracion = anioExpiracion;
    }

    /**
     * Obtiene el código de seguridad.
     *
     * @return código de seguridad
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Establece el código de seguridad.
     *
     * @param cvc código de seguridad
     */
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
