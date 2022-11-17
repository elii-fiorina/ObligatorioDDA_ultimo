package dominio.trabajador;

import java.util.Date;

public class Sesion {
    
    private Date fechaUltimoIngreso = new Date();
    private Trabajador trabajador;

    public Sesion(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    

    /*Sesion(Trabajador trabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public Trabajador getTrbajador() {
        return trabajador;
    }

    public Date getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }
}
