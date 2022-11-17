
package vista;

public interface VistaAtender {
    public void mostrarNombreTrabajador(String nombre);
    public void mostrarSector(String sector);
    public void cantidadLlamadasAtendidas(String atendidas);
    public void tiempoPromedioLlamada(String atendidas);
    public void finalizarLlamada(String descripcion);
}
