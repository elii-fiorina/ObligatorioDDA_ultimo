/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.Sector;

import java.util.List;
import dominio.trabajador.Trabajador;
import java.util.ArrayList;
/**
 *
 * @author alumnoFI
 */
public class Sector {
    private List<Trabajador> trabajadores= new ArrayList<>();
    private List<PuestoDeTrabajo> puestosDeTrabajo = new ArrayList<>();
    private String nombre;
    private int numero;
    private int cantidadPuestos;
    private int cantidadConectados;

    public Sector(String nombre, int numero, int cantidadPuestos) {
        this.nombre = nombre;
        this.numero = numero;
        this.cantidadPuestos = cantidadPuestos;
    }

    public Sector() {
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public List<PuestoDeTrabajo> getPuestosDeTrabajo() {
        return puestosDeTrabajo;
    }

    public void setPuestosDeTrabajo(List<PuestoDeTrabajo> puestosDeTrabajo) {
        this.puestosDeTrabajo = puestosDeTrabajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public int getCantidadConectados() {
        return cantidadConectados;
    }

    public void setCantidadConectados() {
        cantidadConectados = cantidadConectados+1;
    }
    public void agregarTrabajador(Trabajador trabajador) {
        if(trabajadores.size() > 0){
            if (!trabajadores.contains(trabajador)) {
                trabajadores.add(trabajador);
           }
        } else {
            trabajadores.add(trabajador);
        }
    }

    public void agregarPuesto(PuestoDeTrabajo p) {
            if(puestosDeTrabajo.size() > 0 && puestosDeTrabajo.size() <= cantidadPuestos){
                if (!puestosDeTrabajo.contains(p)) {
                    puestosDeTrabajo.add(p);
                }
            } else {
                puestosDeTrabajo.add(p);
            
        }
    }
    
    public boolean puestoDisponible(){
     return this.cantidadConectados < this.cantidadPuestos;
     
    }
    
    public PuestoDeTrabajo asignarPuesto(Trabajador unT){
        PuestoDeTrabajo ret = null;
        int i = 0;
        while(i < puestosDeTrabajo.size() && ret == null){
            PuestoDeTrabajo unP = puestosDeTrabajo.get(i);
            if(unP.getTrabajador() == null){
                unP.setTrabajador(unT);
                ret = unP;
            }
            i++;
        }
        return ret;
    }

    public int numeroDePuestoDeTrabajo(Trabajador trabajador) {
        int i = 0;
        boolean encontre = false;
        while(i < puestosDeTrabajo.size() && !encontre){
            if(puestosDeTrabajo.get(i).getTrabajador().equals(trabajador)){
                encontre = true;
                return i;
            }
            i++;
        }return 0;
    }

    public String cantidadLlamadasAtendidas(Trabajador trabajador) {
        PuestoDeTrabajo unPuesto = obtenerPuestoDeTrabajo(trabajador);
        return "Llamadas atendidas: " + unPuesto.getLlamadasAtendidas();
    }

    public String tiempoPromedioLlamada(Trabajador trabajador) {
        PuestoDeTrabajo unPuesto = obtenerPuestoDeTrabajo(trabajador);
        return "Tiempo promedio: " + unPuesto.getTiempoPromedio();
    }

    private PuestoDeTrabajo obtenerPuestoDeTrabajo(Trabajador trabajador) {
         int i = 0;
        boolean encontre = false;
        PuestoDeTrabajo unPuesto = new PuestoDeTrabajo();
        while(i < puestosDeTrabajo.size() && !encontre){
            if(puestosDeTrabajo.get(i).getTrabajador().equals(trabajador)){
                encontre = true;
                unPuesto = puestosDeTrabajo.get(i);
                
            }
            i++;
        }
        return unPuesto;
    }

    public String traerPuesto(Llamada l) {
        String ret = "";
        for(PuestoDeTrabajo pdt : puestosDeTrabajo){
            if(pdt.getLlamadaEnCurso()!=null && pdt.getLlamadaEnCurso().equals(l)){
                ret = String.valueOf(pdt.getNumero());
            }
        }
        return ret;
    }

    public PuestoDeTrabajo buscarPuesto() {
        PuestoDeTrabajo pdt = null;
        for(PuestoDeTrabajo p : puestosDeTrabajo){
            if(p.getTrabajador()!= null && p.getLlamadaEnCurso() != null){
                pdt = p;
            }
        }
        return pdt;
    }
    
}
