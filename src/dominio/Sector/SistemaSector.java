/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.Sector;

import dominio.cliente.Cliente;
import dominio.trabajador.Trabajador;
import dominio.trabajador.TrabajadorException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofia
 */
public class SistemaSector {
    private List<PuestoDeTrabajo> puestos = new ArrayList<>();
    private List<Sector> sectores = new ArrayList<>();
    private List<Llamada> llamadas = new ArrayList<>();
    private List<Llamada> llamadasEntrantes = new ArrayList<>();

    public List<PuestoDeTrabajo> getPuestos() {
        return puestos;
    }

    public List<Sector> getSectores() {
        return sectores;
    }
    
    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    public PuestoDeTrabajo crearPuestoDeTrabajo(double tiempoPromedio, int llamadasAtendidas) {
        PuestoDeTrabajo pdt = new PuestoDeTrabajo(tiempoPromedio, llamadasAtendidas);
        if (!puestos.contains(pdt)) {
            int aux = puestos.size();
            pdt.setNumero(aux);
            puestos.add(pdt);
        }
        
        return pdt;
    }

    public Llamada crearLlamada(LocalDateTime fechaInicio, Sector sector, Cliente cliente){
        Llamada llamada = new Llamada(fechaInicio, sector, cliente);
        if (!llamadasEntrantes.contains(llamada)) {
            llamadasEntrantes.add(llamada);
        }
        return llamada;
    }
    
    public Sector crearSector(String nombre, int numero, int cantidadPuestos){
        Sector sector = new Sector(nombre, numero, cantidadPuestos);
        if (!sectores.contains(sector)) {
            sectores.add(sector);
        }
        return sector;
    }
   
    public void agregarPuestoEnSector(PuestoDeTrabajo p, Sector s) {
        s.agregarPuesto(p);
    }

    public int numeroDePuestoDeTrabajo(PuestoDeTrabajo pdt) {
        return pdt.getNumero();
    }

    public String cantidadLlamadasAtendidas(PuestoDeTrabajo pdt) {
        String llamadass = Integer.toString(pdt.getLlamadasAtendidas());
        return llamadass;
    }

    public String tiempoPromedioLlamada(PuestoDeTrabajo pdt) {
        String promedio = Double.toString(pdt.getTiempoPromedio());
        return promedio;    
    }

    public void agregarSectorATrabajador(Trabajador t, Sector sector) throws SectorException {
        t.setSector(sector);
    }
    
    public PuestoDeTrabajo puestosDisponibles(Trabajador unT) throws TrabajadorException{
        if(!unT.getSector().puestoDisponible()){
            throw new TrabajadorException("No hay puestos disponibles");
        } else {
            return asignarPuesto(unT);
        }
    }
    
    public PuestoDeTrabajo asignarPuesto(Trabajador unT){
        PuestoDeTrabajo p = unT.getSector().asignarPuesto(unT);
        return p;
    }

    public String mostrarSector(Sector sector) {
        return sector.getNombre();
    }
    
    public void finalizarLlamada(Trabajador trabajador, Llamada llamada, String descripcion, PuestoDeTrabajo pdt) {
        llamada.setFechaFin(LocalDateTime.now());
        llamada.setDescripcion(descripcion);
        llamada.setCosto(llamada.calcularCostoLlamada());
        llamada.setFinalizada(true);
        pdt.setLlamadaEnCurso(null);
               
    }

    public String costoLlamada(Llamada llamada) {
        if(llamada.calcularCostoLlamada() > 0){
            return "El costo es de : " + llamada.calcularCostoLlamada();
        }
        else{
         return "El costo es de : 0" ;   
        }
    }
    
    public List<String> mostrarLlamadasSector(String sectorElegido) throws TrabajadorException {
        Sector sec = null;
        for (int i = 0; i < sectores.size() && sec == null; i++){
            if(sectores.get(i).getNombre() == sectorElegido){
                sec = sectores.get(i);
            }
        }
        if(sec != null){
            return listaDeLlamadas(sec);
        } else {
            throw new TrabajadorException("No hay llamadas para el sector");
        }
    }

    private List<String> listaDeLlamadas(Sector sec) {
        List<String> ret = new ArrayList<>();
        ret.add("#llamada | Estado | Inicio | Fin | #puesto | Trabajador | Duracion | Costo | Cliente | Saldo ");
        llamadas.stream().filter((l) -> (l.getSector() == sec)).map((l) -> String.valueOf(l.getNumero()) 
                + l.estadoDeLlamada()
                + String.valueOf(l.getFechaInicio())
                + String.valueOf(l.getFechaFin())
                + sec.traerPuesto(l)
                + l.nombreTrabajador()
                + String.valueOf(l.calcularDuracion())
                + String.valueOf(l.getCosto())
                + l.nombreCliente()).forEachOrdered((aux2) -> {
                    ret.add(aux2);
        });
        return ret;
    }

    public void atenderLlamada(Llamada l, Sector s) throws SectorException {
        PuestoDeTrabajo pdt = s.buscarPuesto();
        if(pdt != null){
            llamadasEntrantes.remove(l);
            l.setFechaInicio(LocalDateTime.now());
            l.setTrabajador(pdt.getTrabajador());
            l.setNumero(llamadas.size());
            llamadas.add(l);
        } else {
            int enEspera = 0;
            enEspera = llamadasEntrantes.stream().filter((llam) -> (llam.getSector() == s)).map((_item) -> 1).reduce(enEspera, Integer::sum);
            throw new SectorException("Aguarde en línea, Ud. se encuentra a" + enEspera + "llamadas de ser atendido, la espera estimada es N de minutos");
        }
        
    }
}
