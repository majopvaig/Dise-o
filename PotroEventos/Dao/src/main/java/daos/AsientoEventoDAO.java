package daos;

import Entitys.Asiento;
import Entitys.AsientoEvento;
import Entitys.ENUMS.EstadoAsiento;
import Entitys.Seccion;
import interfaces.IAsientoEventoDAO;
import java.util.ArrayList;
import java.util.List;

public class AsientoEventoDAO implements IAsientoEventoDAO {

    private static AsientoEventoDAO instancia;

    private AsientoEventoDAO() {
    }

    public static AsientoEventoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AsientoEventoDAO();
        }
        return instancia;
    }

    @Override
    public List<AsientoEvento> buscarPorEvento(Long idEvento) {
        List<AsientoEvento> ocupacion = new ArrayList<>();

        // SECCIONES PREDEFINIDAS
        Seccion sVip = new Seccion(1L, "VIP", 50, 1500.0);
        Seccion sPlatea = new Seccion(2L, "PLATEA", 50, 800.0);
        Seccion sGral = new Seccion(3L, "GENERAL", 50, 400.0);

        // --- ASIENTOS VIP ---
        ocupacion.add(crearAE(101L, "A", 1, sVip, EstadoAsiento.DISPONIBLE));
        ocupacion.add(crearAE(102L, "A", 2, sVip, EstadoAsiento.VENDIDO));
        ocupacion.add(crearAE(103L, "B", 1, sVip, EstadoAsiento.DISPONIBLE));

        // --- ASIENTOS PLATEA ---
        ocupacion.add(crearAE(201L, "A", 1, sPlatea, EstadoAsiento.DISPONIBLE));
        ocupacion.add(crearAE(202L, "A", 2, sPlatea, EstadoAsiento.DISPONIBLE));

        // --- ASIENTOS GENERAL ---
        ocupacion.add(crearAE(301L, "A", 1, sGral, EstadoAsiento.VENDIDO));

        return ocupacion;
    }

    // Método auxiliar para no repetir código de creación
    private AsientoEvento crearAE(Long id, String fila, int num, Seccion s, EstadoAsiento estado) {
        Asiento a = new Asiento(id, fila, num, s);
        AsientoEvento ae = new AsientoEvento();
        ae.setAsiento(a);
        ae.setEstadoAsiento(estado);
        ae.setIdReservacion(id + 10000); // ID único de reserva
        return ae;
    }
}
