/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inicio;
import dominio.Sector.SectorException;
import dominio.trabajador.TrabajadorException;
import uiswing.Principal;

public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SectorException, TrabajadorException {
        DatosPrueba.cargar();
        Principal principal = new Principal();
        principal.setVisible(true);
    }

}
