/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import dominio.Sector.Sector;
import dominio.trabajador.Trabajador;
import java.util.List;

public interface VistaSimularLlamada {

    public void mostrarTodosLosSectores(List<Sector> sectoresTotal);
    public void iniciarLlamada(Sector sec, Trabajador t);
}
