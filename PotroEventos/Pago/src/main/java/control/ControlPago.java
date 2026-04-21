package control;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import dtos.CobroDTO;
import dtos.TarjetaDTO;
import excepciones.PagoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de control encargada de gestionar el procesamiento de pagos mediante
 * Stripe.
 *
 * Implementa el patrón Singleton para mantener una sola instancia durante toda
 * la ejecución del sistema.
 *
 * Los datos de tarjeta capturados se convierten internamente a tokens de prueba
 * compatibles con Stripe.
 *
 * @author Aaron Burciaga - 262788
 * @author Brian Sandoval - 262741
 * @author Dayanara Peralta - 262695
 * @author María Valdez - 262775
 */
public class ControlPago {

    /**
     * Logger del subsistema.
     */
    private static final Logger LOG = Logger.getLogger(ControlPago.class.getName());

    /**
     * Instancia única del controlador.
     */
    private static ControlPago instancia;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private ControlPago() {
    }

    /**
     * Obtiene la instancia única de ControlPago.
     *
     * @return instancia única
     */
    public static ControlPago getInstance() {
        if (instancia == null) {
            instancia = new ControlPago();
        }
        return instancia;
    }

    /**
     * Procesa un pago usando datos de tarjeta y cobro.
     *
     * @param tarjetaDTO datos de la tarjeta
     * @param cobroDTO datos del cobro
     * @return true si el pago fue exitoso
     * @throws PagoException si ocurre un error
     */
    public boolean realizarPago(TarjetaDTO tarjetaDTO, CobroDTO cobroDTO) throws PagoException {
        try {
            validarDatos(tarjetaDTO, cobroDTO);

            String token = convertirTarjetaAToken(tarjetaDTO);
            Charge cargo = crearCargo(token, cobroDTO);

            if (transaccionExitosa(cargo)) {
                LOG.log(Level.INFO,
                        "Pago exitoso. ID: {0}, Monto: {1}, Estado: {2}",
                        new Object[]{cargo.getId(), cargo.getAmount(), cargo.getStatus()});
                return true;
            }

            LOG.log(Level.WARNING,
                    "Pago no aprobado. ID: {0}, Estado: {1}",
                    new Object[]{cargo.getId(), cargo.getStatus()});

            throw new PagoException("La transacción no fue aprobada.");

        } catch (StripeException ex) {
            LOG.log(Level.SEVERE, "Error con Stripe: {0}", ex.getMessage());
            throw new PagoException("Error al procesar pago: " + ex.getMessage());

        } catch (IllegalArgumentException ex) {
            LOG.log(Level.WARNING, "Datos inválidos: {0}", ex.getMessage());
            throw new PagoException(ex.getMessage());
        }
    }

    /**
     * Valida datos básicos antes de procesar el pago.
     *
     * @param tarjetaDTO datos de la tarjeta
     * @param cobroDTO datos del cobro
     */
    private void validarDatos(TarjetaDTO tarjetaDTO, CobroDTO cobroDTO) {

        if (tarjetaDTO == null) {
            throw new IllegalArgumentException("La tarjeta es obligatoria.");
        }

        if (cobroDTO == null) {
            throw new IllegalArgumentException("El cobro es obligatorio.");
        }

        if (cobroDTO.getMonto() == null || cobroDTO.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }

        if (tarjetaDTO.getNumero() == null || tarjetaDTO.getNumero().isBlank()) {
            throw new IllegalArgumentException("El número de tarjeta es obligatorio.");
        }
    }

    /**
     * Convierte el número de tarjeta capturado a un token de prueba Stripe.
     *
     * @param tarjetaDTO datos de la tarjeta
     * @return token de prueba
     */
    private String convertirTarjetaAToken(TarjetaDTO tarjetaDTO) {

        String numero = tarjetaDTO.getNumero().replace(" ", "");

        switch (numero) {

            case "4242424242424242" -> {
                return "tok_visa";
            }

            case "4000000000009995" -> {
                return "tok_chargeDeclinedInsufficientFunds";
            }

            case "4000000000000002" -> {
                return "tok_chargeDeclined";
            }

            default ->
                throw new IllegalArgumentException("Tarjeta no válida.");
        }
    }

    /**
     * Crea el cargo en Stripe.
     *
     * @param token token de prueba
     * @param cobroDTO datos del cobro
     * @return cargo generado
     * @throws StripeException si ocurre error con Stripe
     */
    private Charge crearCargo(String token, CobroDTO cobroDTO) throws StripeException {

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("amount", cobroDTO.getMonto());
        parametros.put("currency", cobroDTO.getMoneda());
        parametros.put("description", cobroDTO.getDescripcion());
        parametros.put("source", token);

        LOG.info("Enviando solicitud de cobro...");
        return Charge.create(parametros);
    }

    /**
     * Verifica si la transacción fue aprobada.
     *
     * @param cargo respuesta de Stripe
     * @return true si fue exitosa
     */
    private boolean transaccionExitosa(Charge cargo) {
        return cargo != null && Boolean.TRUE.equals(cargo.getPaid()) && "succeeded".equalsIgnoreCase(cargo.getStatus());
    }
}
