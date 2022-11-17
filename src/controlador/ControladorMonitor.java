/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Sistema;
import dominio.Sector.Sector;
import dominio.trabajador.TrabajadorException;
import java.util.ArrayList;
import java.util.List;
import vista.VistaMonitoreo;

/**
 *
 * @author sofia
 */
public class ControladorMonitor {
    
    private VistaMonitoreo vista;
    private List<Sector> sectores = new ArrayList<>();
    private Sistema logica = Sistema.getInstancia();
    
    public ControladorMonitor(VistaMonitoreo v){
        this.vista = v;
        this.sectores = logica.getSectores();
        iniciarMonitoreo();
    }
    
    private void iniciarMonitoreo() {
        vista.mostrarTodosLosSectores(sectores);
    }

    public List<String> elegirSector(String sectorElegido) throws TrabajadorException {
        return logica.mostrarLlamadasSector(sectorElegido);
    }
    
}
