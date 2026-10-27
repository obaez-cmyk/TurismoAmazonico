
package modelo;

/**
 * Clase abstracta que representa a cualquier persona relacionada
 * con la agencia (Usuario o Turista). Aplica encapsulamiento y
 * sirve de base para la herencia.
 *
 * @author Oscar
 */
public abstract class Persona {

    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String nacionalidad;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String documento,
            String telefono, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Cada subclase decide cómo mostrar su información (polimorfismo).
     */
    public abstract void mostrarInfo();
}