
package interfaces;

/**
 * Define el comportamiento de aplicar descuentos.
 * Cualquier clase que la implemente debe indicar cómo calcula el
 * precio con descuento (polimorfismo).
 *
 * @author Oscar
 */
public interface Descontable {
    double aplicarDescuento(double porcentaje);
}
