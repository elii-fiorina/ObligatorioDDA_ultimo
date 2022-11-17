package inicio;

import dominio.Sector.SectorException;
import dominio.Sistema;
import dominio.cliente.ClienteConCosto;
import dominio.cliente.ClienteExonerado;
import dominio.cliente.ClienteGestor;
import dominio.Sector.Llamada;
import dominio.Sector.PuestoDeTrabajo;
import dominio.Sector.Sector;
import dominio.trabajador.Trabajador;
import dominio.trabajador.TrabajadorException;
import java.time.LocalDateTime;

public class DatosPrueba {

    public static void cargar() throws SectorException, TrabajadorException {
        Sistema logica = Sistema.getInstancia();
        
        Sector sector1 = logica.crearSector("sector1", 01, 5);
        Sector sector2 = logica.crearSector("sector2", 02, 6);
        Sector sector3 = logica.crearSector("sector3", 03, 4);
        Sector sector4 = logica.crearSector("sector4", 04, 5);
        
        Trabajador t1 = logica.crearTrabajador("1", "1", "Trabajador Uno", sector1);
        Trabajador t2 = logica.crearTrabajador("987654321", "trabajador2", "Trabajador Dos", sector1);
        Trabajador t3 = logica.crearTrabajador("741852963", "trabajador3", "Trabajador Tres", sector2);
        Trabajador t4 = logica.crearTrabajador("369258147", "trabajador4", "Trabajador Cuatro", sector2);
        Trabajador t5 = logica.crearTrabajador("147258369", "trabajador5", "Trabajador Cinco", sector3);
        Trabajador t6 = logica.crearTrabajador("6547893321", "trabajador6", "Trabajador Seis", sector3);
        Trabajador t7 = logica.crearTrabajador("564231897", "trabajador7", "Trabajador Siete", sector4);
        Trabajador t8 = logica.crearTrabajador("246351789", "trabajador8", "Trabajador Ocho", sector4);
        
        PuestoDeTrabajo pdt1 = logica.crearPuestoDeTrabajo(12, 225);
        PuestoDeTrabajo pdt2 = logica.crearPuestoDeTrabajo(8, 300);
        PuestoDeTrabajo pdt3 = logica.crearPuestoDeTrabajo(11.3, 105);
        PuestoDeTrabajo pdt4 = logica.crearPuestoDeTrabajo(9.25, 150);
        PuestoDeTrabajo pdt5 = logica.crearPuestoDeTrabajo(15, 114);
        PuestoDeTrabajo pdt6 = logica.crearPuestoDeTrabajo(7.8, 98);
        PuestoDeTrabajo pdt7 = logica.crearPuestoDeTrabajo(14.5, 295);
        PuestoDeTrabajo pdt8 = logica.crearPuestoDeTrabajo(13.16, 256);
        PuestoDeTrabajo pdt9 = logica.crearPuestoDeTrabajo(8.78, 198);
        PuestoDeTrabajo pdt10 = logica.crearPuestoDeTrabajo(10, 241);
        PuestoDeTrabajo pdt11 = logica.crearPuestoDeTrabajo(10.1, 302);
        
        logica.agregarPuestoEnSector(pdt1, sector4);
        logica.agregarPuestoEnSector(pdt2, sector4);
        logica.agregarPuestoEnSector(pdt3, sector3);
        logica.agregarPuestoEnSector(pdt4, sector3);
        logica.agregarPuestoEnSector(pdt5, sector2);
        logica.agregarPuestoEnSector(pdt6, sector2);
        logica.agregarPuestoEnSector(pdt7, sector1);
        logica.agregarPuestoEnSector(pdt8, sector1);
        
        logica.agregarSectorATrabajador(t1, sector4);
        logica.agregarSectorATrabajador(t2, sector4);
        logica.agregarSectorATrabajador(t3, sector3);
        logica.agregarSectorATrabajador(t4, sector3);
        logica.agregarSectorATrabajador(t5, sector2);
        logica.agregarSectorATrabajador(t6, sector2);
        logica.agregarSectorATrabajador(t7, sector1);
        logica.agregarSectorATrabajador(t8, sector1);
        
        //pdt1.setTrabajador(t1);
        pdt2.setTrabajador(t2);
        pdt3.setTrabajador(t3);
        pdt4.setTrabajador(t4);
        pdt5.setTrabajador(t5);
        pdt6.setTrabajador(t6);
        pdt7.setTrabajador(t7);
        pdt8.setTrabajador(t8);
        

        
        LocalDateTime hoy = (LocalDateTime) LocalDateTime.now();
        
        ClienteExonerado c1 = logica.CrearClienteExonerado("48981670", "Laura");
        ClienteConCosto c2 = logica.CrearClienteConCosto("12345657", "Pepe", 1200);
        ClienteGestor c3 =logica.CrearClienteGestor("58974521", "Enrique", 500);
        
        Llamada ll1 = logica.crearLlamada(hoy, sector4, c1);
        Llamada ll2 = logica.crearLlamada(hoy, sector2, c2);
        Llamada ll3 = logica.crearLlamada(hoy, sector1, c3);
        
        logica.finalizarLlamada(t2, ll1, "todo ok", pdt2);
        logica.finalizarLlamada(t5, ll2, "todo ok", pdt5);
        logica.finalizarLlamada(t3, ll3, "todo ok", pdt3);
        
    }
}
