
package modelo;

/**
 * Tour en lancha por el río Amazonas.
 * Tiene un recargo de combustible según la distancia recorrida.
 *
 * @author Oscar
 */
public class TourFluvial extends PaqueteTuristico {

    private double distanciaKm;
    private static final double RECARGO_POR_KM = 3000;

    public TourFluvial() {
    }

    public TourFluvial(int idPaquete, String nombre, int cuposDisponibles, double precioBase,
            String descripcion, Categoria categoria, double distanciaKm) {
        super(idPaquete, nombre, cuposDisponibles, precioBase, descripcion, categoria);
        this.distanciaKm = distanciaKm;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    // Sobreescritura: agrega el recargo de combustible según la distancia
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() + (distanciaKm * RECARGO_POR_KM);
    }
}