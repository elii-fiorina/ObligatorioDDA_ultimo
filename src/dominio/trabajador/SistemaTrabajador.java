package dominio.trabajador;

import dominio.EventoSistema;
import dominio.Sistema;
import dominio.Sector.Sector;
import java.util.ArrayList;
import java.util.List;

public class SistemaTrabajador {

    private List<Trabajador> trabajadores = new ArrayList<>();
    private List<Sesion> logueados = new ArrayList<>();
    private Sector sector;

    public Sesion login(String cedula, String password) throws TrabajadorException {
        Sesion sesion = loginTrabajador(cedula, password);
            if (sesion != null && !usuarioYaLogeado(sesion.getTrbajador())) {
            logueados.add(sesion);
            sesion.getTrbajador().getSector().setCantidadConectados();
            Sistema.getInstancia().avisar(EventoSistema.LOGIN);
            return sesion;
            } else {
             throw new TrabajadorException("Acceso denegado");          
            }
    }
  
    private Sesion loginTrabajador(String cedula, String password) throws TrabajadorException {
        Trabajador unT = new Trabajador(cedula, password);
        for (Trabajador t : trabajadores) {
            if(t.getCedula().equals(unT.getCedula()) && t.getPassword().equals(unT.getPassword())){
                unT = t;
                Sesion sesion = new Sesion(unT);
                return sesion;
                
            }
        }
        return null;
    }
    
    public List<Sesion> getLogueados() {
        return logueados;
    }


    public Trabajador crearTrabajador(String cedula, String password, String nombreCompleto, Sector sector) throws TrabajadorException {

        Trabajador usuario = new Trabajador(cedula, nombreCompleto, password);
        if (!trabajadores.contains(usuario)) {
            trabajadores.add(usuario);
            
        } else {
            throw new TrabajadorException("El trabajador ya existe");
        }
        
        return usuario;
    }    

    private boolean usuarioYaLogeado(Trabajador t) {
        for(Sesion s: logueados){
            Trabajador unT = s.getTrbajador();
            if(unT.getCedula().equals(t.getCedula())){
                return true;
            }
        }return false;
    }

    
    

}
