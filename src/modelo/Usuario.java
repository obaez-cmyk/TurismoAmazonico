
package modelo;

/**
 * Representa un usuario del sistema (guía o administrador que gestiona
 * las reservas). Hereda los atributos comunes de Persona.
 *
 * @author Oscar
 */
public class Usuario extends Persona {

    private int idUsuario;
    private String usuario;
    private String password;
    private String rol;

    public Usuario() {
    }

    // Constructor completo
    public Usuario(int idUsuario, String nombre, String apellido, String documento,
            String telefono, String usuario, String password, String rol) {
        super(nombre, apellido, documento, telefono, "Colombia");
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    // Sobrecarga: constructor simplificado, asigna rol "guia" por defecto
    public Usuario(int idUsuario, String nombre, String apellido, String usuario, String password) {
        this(idUsuario, nombre, apellido, "", "", usuario, password, "guia");
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean validarCredenciales(String usuarioIngresado, String passwordIngresado) {
        return usuario.equals(usuarioIngresado) && password.equals(passwordIngresado);
    }

    // Sobreescritura del método abstracto de Persona
    @Override
    public void mostrarInfo() {
        System.out.println("\n===== USUARIO =====");
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("Usuario: " + usuario);
        System.out.println("Rol: " + rol);
    }
}
