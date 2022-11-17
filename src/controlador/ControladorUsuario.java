
import dominio.EventoSistema;
import dominio.Sistema;
import observer.Observable;
import observer.Observador;
import vista.VistaMonitoreo;

public class ControladorUsuario {
    private VistaMonitoreo vista;

    //public List<Sector> mostrarTodosLosSectores() {
    //    vista.mostrarTodosLosSectores(Sistema.getInstancia().getSectores());
    //}

    //private void mostrarLista() {
    //   vista.mostrarUsuariosConectados(Sistema.getInstancia().getLogueados());
    //}

    public void actualizar(Observable origen, Object evento) {
        switch((EventoSistema) evento) {
            case LOGIN:
                //mostrarLista();
                break;
        }
    }
}
