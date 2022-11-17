package dominio;
import dominio.Sector.SectorException;
import dominio.Sector.SistemaSector;
import dominio.cliente.Cliente;
import dominio.cliente.ClienteConCosto;
import dominio.cliente.ClienteExonerado;
import dominio.cliente.ClienteGestor;
import dominio.trabajador.SistemaTrabajador;
import dominio.trabajador.TrabajadorException;
import dominio.Sector.Llamada;
import dominio.Sector.PuestoDeTrabajo;
import dominio.Sector.Sector;
import dominio.cliente.ClienteException;
import dominio.cliente.SistemaCliente;
import dominio.trabajador.Sesion;
import dominio.trabajador.Trabajador;
import java.time.LocalDateTime;
import java.util.List;
import observer.Observable;

public class Sistema extends Observable {

    private static Sistema instancia = new Sistema();
    private SistemaTrabajador st = new SistemaTrabajador();
    private SistemaSector ss = new SistemaSector();
    private SistemaCliente sc = new SistemaCliente();

    public static Sistema getInstancia() {
        return instancia;
    }

    public Sesion loginTrabajador(String usuario, String password) throws TrabajadorException {
        return st.login(usuario, password);
    }
    public Trabajador crearTrabajador(String cedula, String password, String nombreCompleto, Sector sector) throws TrabajadorException {
        return st.crearTrabajador(cedula, password, nombreCompleto, sector);
    }
     public ClienteExonerado CrearClienteExonerado(String cedula, String nombre) {
        return sc.CrearClienteExonerado(cedula, nombre);
    }
      public ClienteConCosto CrearClienteConCosto(String cedula, String nombre, double saldo) {
        return sc.CrearClienteConCosto(cedula, nombre, saldo);
    }
      public ClienteGestor CrearClienteGestor(String cedula, String nombre, double saldo) {
        return sc.CrearClienteGestor(cedula, nombre, saldo);
    }
    
    public PuestoDeTrabajo crearPuestoDeTrabajo(double tiempoPromedio, int llamadasAtendidas){
        return ss.crearPuestoDeTrabajo(tiempoPromedio, llamadasAtendidas);
    }
    
    public Sector crearSector(String nombre, int numero, int cantidadPuestos){
        return ss.crearSector(nombre, numero, cantidadPuestos);
    }
    
    public List<Sector> getSectores() {
        return ss.getSectores();
    }

    public void agregarPuestoEnSector(PuestoDeTrabajo p, Sector s) {
        ss.agregarPuestoEnSector(p,s);
    }

    public Llamada crearLlamada(LocalDateTime fechaInicio, Sector s, Cliente c) {
        return ss.crearLlamada(fechaInicio, s, c);

    }
    public void registrarUsuario(
            String cedula,
            String password,
            String nombreCompleto, 
            Sector sector) throws TrabajadorException {
        st.crearTrabajador(cedula, password, nombreCompleto, sector);
    }
   
    public List<Sesion> getLogueados() {
        return st.getLogueados();

    }

    public int numeroDePuestoDeTrabajo(PuestoDeTrabajo pdt) {
        return ss.numeroDePuestoDeTrabajo(pdt);
    }

    public String cantidadLlamadasAtendidas(PuestoDeTrabajo pdt) {
        return ss.cantidadLlamadasAtendidas(pdt);
    }

    public String tiempoPromedioLlamada(PuestoDeTrabajo pdt) {
        return ss.tiempoPromedioLlamada(pdt);

    }

    public void finalizarLlamada(Trabajador trabajador, Llamada llamada, String descripcion, PuestoDeTrabajo pdt) {
        ss.finalizarLlamada(trabajador, llamada, descripcion, pdt);
    }

    public String costoLlamada(Llamada llamada) {
        return ss.costoLlamada(llamada);
    }

    public void agregarSectorATrabajador(Trabajador t, Sector sector) throws SectorException {
        ss.agregarSectorATrabajador(t,sector);

    }

    public PuestoDeTrabajo asignarPuestoDeTrabajo(Trabajador trabajador) throws TrabajadorException {
         return ss.puestosDisponibles(trabajador);
    }

    public String mostrarSector(Sector sector) {
        return ss.mostrarSector(sector);
    }
    
    public List<String> mostrarLlamadasSector(String sectorElegido) throws TrabajadorException {
        return ss.mostrarLlamadasSector(sectorElegido);
    }

    public Cliente seleccionarCliente(String cedula) throws ClienteException {
        return sc.seleccionarCliente(cedula);
    }

    public void atenderLlamada(Llamada l, Sector s) throws SectorException {
        ss.atenderLlamada(l, s);
    }

    
   
}
