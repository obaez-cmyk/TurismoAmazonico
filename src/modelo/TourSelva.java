package modelo;

/**
 * Caminata guiada por la selva amazónica.
 * Tiene un recargo si incluye un guía especializado (nocturno, avistamiento
 * de fauna, etc.).
 *
 * @author Oscar
 */
public class TourSelva extends PaqueteTuristico {

    private boolean guiaEspecializado;
    private static final double RECARGO_GUIA = 0.20;

    public TourSelva() {
    }

    public TourSelva(int idPaquete, String nombre, int cuposDisponibles, double precioBase,
            String descripcion, Categoria categoria, boolean guiaEspecializado) {
        super(idPaquete, nombre, cuposDisponibles, precioBase, descripcion, categoria);
        this.guiaEspecializado = guiaEspecializado;
    }

    public boolean isGuiaEspecializado() {
        return guiaEspecializado;
    }

    public void setGuiaEspecializado(boolean guiaEspecializado) {
        this.guiaEspecializado = guiaEspecializado;
    }

    // Sobreescritura: agrega el recargo si tiene guía especializado
    @Override
    public double calcularPrecioFinal() {
        return guiaEspecializado
                ? getPrecioBase() + (getPrecioBase() * RECARGO_GUIA)
                : getPrecioBase();
    }
}