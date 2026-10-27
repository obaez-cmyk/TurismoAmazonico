package controlador;

import modelo.Turista;
import modelo.PaqueteTuristico;
import modelo.Reserva;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador que gestiona las listas de turistas, paquetes y reservas.
 * Actúa como intermediario entre el menú (Main) y las clases del modelo.
 *
 * @author Oscar
 */
public class ReservaControlador {

    private List<Turista> turistas = new ArrayList<>();
    private List<PaqueteTuristico> paquetes = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private int contadorReservas = 1;

    public void registrarTurista(Turista turista) {
        turistas.add(turista);
    }

    public void registrarPaquete(PaqueteTuristico paquete) {
        paquetes.add(paquete);
    }

    public List<Turista> getTuristas() {
        return turistas;
    }

    public List<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Turista buscarTuristaPorDocumento(String documento) {
        for (Turista t : turistas) {
            if (t.getDocumento().equals(documento)) {
                return t;
            }
        }
        return null;
    }

    public PaqueteTuristico buscarPaquetePorId(int id) {
        for (PaqueteTuristico p : paquetes) {
            if (p.getIdPaquete() == id) {
                return p;
            }
        }
        return null;
    }

    public void mostrarPaquetesDisponibles() {
        System.out.println("\n===== PAQUETES DISPONIBLES =====");
        for (PaqueteTuristico p : paquetes) {
            if (p.isDisponible()) {
                System.out.println(p);
            }
        }
    }

    public Reserva crearReserva(Turista turista, String fecha) {
        Reserva reserva = new Reserva(contadorReservas++, turista, fecha);
        reservas.add(reserva);
        return reserva;
    }
}
