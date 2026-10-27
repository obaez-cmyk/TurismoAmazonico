
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una reserva: un turista que reserva varios paquetes.
 * Aplica composición (Reserva "tiene" Turista y Paquetes) y
 * polimorfismo (no le importa si el paquete es Fluvial o de Selva,
 * solo llama a calcularPrecioFinal()).
 *
 * @author Oscar
 */
public class Reserva {

    private int idReserva;
    private Turista turista;
    private List<PaqueteTuristico> paquetes;
    private String fecha;

    public Reserva(int idReserva, Turista turista, String fecha) {
        this.idReserva = idReserva;
        this.turista = turista;
        this.fecha = fecha;
        this.paquetes = new ArrayList<>();
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Turista getTurista() {
        return turista;
    }

    public List<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public String getFecha() {
        return fecha;
    }

    // Sobrecarga: agregar 1 cupo o una cantidad específica de cupos
    public void agregarPaquete(PaqueteTuristico paquete) {
        agregarPaquete(paquete, 1);
    }

    public void agregarPaquete(PaqueteTuristico paquete, int cantidadCupos) {
        if (!paquete.isDisponible() || paquete.getCuposDisponibles() < cantidadCupos) {
            System.out.println("No hay cupos suficientes en " + paquete.getNombre());
            return;
        }
        for (int i = 0; i < cantidadCupos; i++) {
            paquetes.add(paquete);
        }
        paquete.reducirCupos(cantidadCupos);
    }

    // Polimorfismo: cada paquete calcula su precio a su manera,
    // Reserva no necesita saber de qué tipo es cada uno.
    public double calcularTotal() {
        double total = 0;
        for (PaqueteTuristico p : paquetes) {
            total += p.calcularPrecioFinal();
        }
        return total;
    }

    public void mostrarComprobante() {
        System.out.println("\n===== COMPROBANTE DE RESERVA #" + idReserva + " =====");
        System.out.println("Fecha: " + fecha);
        System.out.println("Turista: " + turista.getNombre() + " " + turista.getApellido());
        System.out.println("--------------------------------");
        for (PaqueteTuristico p : paquetes) {
            System.out.println(p);
        }
        System.out.println("--------------------------------");
        double total = calcularTotal();
        System.out.printf("TOTAL: $%.2f%n", total);
        turista.registrarPago(total);
    }
}