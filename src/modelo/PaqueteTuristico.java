
package modelo;

import interfaces.Descontable;

/**
 * Clase abstracta que representa un paquete turístico genérico.
 * Cada tipo de tour (fluvial, selva) calcula su propio precio final,
 * aplicando polimorfismo y sobreescritura.
 *
 * @author Oscar
 */
public abstract class PaqueteTuristico implements Descontable {

    private int idPaquete;
    private String nombre;
    private int cuposDisponibles;
    private double precioBase;
    private String descripcion;
    private Categoria categoria;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int idPaquete, String nombre, int cuposDisponibles,
            double precioBase, String descripcion, Categoria categoria) {
        this.idPaquete = idPaquete;
        this.nombre = nombre;
        this.cuposDisponibles = cuposDisponibles;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return cuposDisponibles > 0;
    }

    /**
     * Cada subclase define su propio recargo (polimorfismo real,
     * no solo un mensaje distinto).
     */
    public abstract double calcularPrecioFinal();

    // Implementación por defecto de Descontable; las subclases pueden
    // sobreescribirla si necesitan una regla distinta.
    @Override
    public double aplicarDescuento(double porcentaje) {
        return calcularPrecioFinal() - (calcularPrecioFinal() * porcentaje / 100);
    }

    public void reducirCupos(int cantidad) {
        this.cuposDisponibles -= cantidad;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - $%.2f (cupos: %d)",
                idPaquete, nombre, calcularPrecioFinal(), cuposDisponibles);
    }
}