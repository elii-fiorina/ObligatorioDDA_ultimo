package vista;
import dominio.trabajador.Trabajador;

public interface VistaLogin {
    public void mostrarProximaInterfaz(Trabajador t);
    public void cerrar();
    public void mostrarError(String mensaje);
    public void limpiarDatos();
}
