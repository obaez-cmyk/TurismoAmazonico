package principal;

import controlador.ReservaControlador;
import modelo.Categoria;
import modelo.PaqueteTuristico;
import modelo.Reserva;
import modelo.TourFluvial;
import modelo.TourSelva;
import modelo.Turista;
import java.util.Scanner;

/**
 * Menú principal del sistema de la Agencia de Turismo Amazónico.
 *
 * @author Oscar
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ReservaControlador controlador = new ReservaControlador();
    
    
    public static void main(String[] args) {
        cargarDatosDePrueba();

        int opcion;
        do {
            System.out.println("\n===== AGENCIA DE TURISMO AMAZONICO =====");
            System.out.println("1. Registrar turista");
            System.out.println("2. Ver paquetes disponibles");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Ver historial de reservas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> registrarTurista();
                case 2 -> controlador.mostrarPaquetesDisponibles();
                case 3 -> realizarReserva();
                case 4 -> verHistorialReservas();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    static void registrarTurista() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Documento: ");
        String documento = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Número de pasaporte: ");
        String pasaporte = scanner.nextLine();

        Turista turista = new Turista(controlador.getTuristas().size() + 1,
                nombre, apellido, documento, telefono, nacionalidad, pasaporte);
        controlador.registrarTurista(turista);
        System.out.println("Turista registrado con éxito.");
    }

    static void realizarReserva() {
        System.out.print("Documento del turista: ");
        String documento = scanner.nextLine();
        Turista turista = controlador.buscarTuristaPorDocumento(documento);

        if (turista == null) {
            System.out.println("Turista no encontrado. Regístralo primero.");
            return;
        }

        Reserva reserva = controlador.crearReserva(turista, "2026-07-15");
        boolean seguir = true;

        while (seguir) {
            controlador.mostrarPaquetesDisponibles();
            System.out.print("ID del paquete a agregar (0 para terminar): ");
            int idPaquete = leerEntero();
            if (idPaquete == 0) {
                seguir = false;
                continue;
            }
            PaqueteTuristico paquete = controlador.buscarPaquetePorId(idPaquete);
            if (paquete == null) {
                System.out.println("Paquete no encontrado.");
                continue;
            }
            System.out.print("Cantidad de cupos: ");
            int cantidad = leerEntero();
            reserva.agregarPaquete(paquete, cantidad);
        }

        reserva.mostrarComprobante();
    }

    static void verHistorialReservas() {
        System.out.println("\n===== HISTORIAL DE RESERVAS =====");
        for (Reserva r : controlador.getReservas()) {
            System.out.printf("Reserva #%d - Turista: %s - Total: $%.2f%n",
                    r.getIdReserva(), r.getTurista().getNombre(), r.calcularTotal());
        }
    }

    static int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Datos de prueba para no empezar con el sistema vacío
    static void cargarDatosDePrueba() {
        Categoria aventura = new Categoria(1, "Aventura", "Tours fluviales y de exploración");
        Categoria ecologico = new Categoria(2, "Ecológico", "Caminatas y avistamiento de fauna");

        controlador.registrarPaquete(new TourFluvial(1, "Navegación río Amazonas", 15, 150000,
                "Recorrido en lancha por el río, avistamiento de delfines rosados",
                aventura, 25));
        controlador.registrarPaquete(new TourFluvial(2, "Travesía a Isla de los Micos", 10, 200000,
                "Recorrido fluvial hasta la isla y regreso", aventura, 40));
        controlador.registrarPaquete(new TourSelva(3, "Caminata ecológica diurna", 20, 90000,
                "Recorrido guiado por senderos de la selva", ecologico, false));
        controlador.registrarPaquete(new TourSelva(4, "Caminata nocturna con guía especializado", 8, 130000,
                "Avistamiento de fauna nocturna con guía experto", ecologico, true));
    }
}
