
package modelo;

/**
 * Representa a un turista que reserva paquetes en la agencia.
 * Hereda de Persona (herencia + reutilización de código).
 *
 * @author Oscar
 */
public class Turista extends Persona {

    private int idTurista;
    private String numeroPasaporte;
    private double totalPagado;

    public Turista() {
    }

    public Turista(int idTurista, String nombre, String apellido, String documento,
            String telefono, String nacionalidad, String numeroPasaporte) {
        super(nombre, apellido, documento, telefono, nacionalidad);
        this.idTurista = idTurista;
        this.numeroPasaporte = numeroPasaporte;
        this.totalPagado = 0;
    }

    public int getIdTurista() {
        return idTurista;
    }

    public void setIdTurista(int idTurista) {
        this.idTurista = idTurista;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    // Sobrecarga de método: dos formas de registrar un pago
    public void registrarPago(double monto) {
        totalPagado += monto;
        System.out.println(getNombre() + " pagó $" + monto);
    }

    public void registrarPago(double monto, String metodoPago) {
        totalPagado += monto;
        System.out.println(getNombre() + " pagó $" + monto + " mediante " + metodoPago);
    }

    // Sobreescritura del método abstracto de Persona
    @Override
    public void mostrarInfo() {
        System.out.println("\n===== TURISTA =====");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("Nacionalidad: " + getNacionalidad());
        System.out.println("Pasaporte: " + numeroPasaporte);
        System.out.println("Total pagado: $" + totalPagado);
    }
}
