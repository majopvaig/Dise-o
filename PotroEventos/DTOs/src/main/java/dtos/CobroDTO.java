package dtos;

/**
 * Objeto de transferencia de datos que contiene la información necesaria para
 * realizar un cobro dentro del subsistema de pagos.
 *
 * El monto se maneja en centavos para mantener precisión monetaria.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class CobroDTO {

    /**
     * Monto del cobro expresado en centavos.
     */
    private Long monto;

    /**
     * Código de moneda del cobro.
     */
    private String moneda;

    /**
     * Descripción del cobro.
     */
    private String descripcion;

    /**
     * Constructor por defecto.
     */
    public CobroDTO() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param monto monto en centavos
     * @param moneda código de moneda
     * @param descripcion descripción del cobro
     */
    public CobroDTO(Long monto, String moneda, String descripcion) {
        this.monto = monto;
        this.moneda = moneda;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el monto del cobro.
     *
     * @return monto en centavos
     */
    public Long getMonto() {
        return monto;
    }

    /**
     * Establece el monto del cobro.
     *
     * @param monto monto en centavos
     */
    public void setMonto(Long monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la moneda.
     *
     * @return código de moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Establece la moneda.
     *
     * @param moneda código de moneda
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Obtiene la descripción del cobro.
     *
     * @return descripción del cobro
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del cobro.
     *
     * @param descripcion descripción del cobro
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
