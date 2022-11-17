/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Sector.Llamada;
import dominio.Sector.Sector;
import dominio.Sector.SectorException;
import dominio.Sistema;
import dominio.cliente.Cliente;
import dominio.cliente.ClienteException;
import java.time.LocalDateTime;
import java.util.List;
import observer.Observable;
import observer.Observador;
import vista.VistaSimularLlamada;

public class ControladorSimularLlamada implements Observador  {

   private VistaSimularLlamada vista;
   Sistema sistema = Sistema.getInstancia();
   Cliente cli;

    public ControladorSimularLlamada(VistaSimularLlamada vista) {
        cli = null;
    }

   public void seleccionarCliente(String cedula) throws ClienteException{
       Cliente cliente = sistema.seleccionarCliente(cedula);
       cli = cliente;
       mostrarSectores();
   }

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarSectores() {
        List<Sector> sectoresTotal = sistema.getSectores();
        vista.mostrarTodosLosSectores(sectoresTotal);
    }

    public Sector traerSector(String sectorElegido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void iniciarLlamada(Sector s) throws SectorException {
        Llamada l = sistema.crearLlamada(LocalDateTime.now(), s, cli);
        sistema.atenderLlamada(l, s);
    }
    
}
