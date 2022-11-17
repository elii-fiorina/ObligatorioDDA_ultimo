/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.Sector;

import dominio.cliente.Cliente;
import dominio.trabajador.Trabajador;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author alumnoFI
 */
public class Llamada {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double costo;
    private Sector sector;
    String descripcion;
    private Trabajador trabajador;
    private Cliente cliente;
    private int numero;
    private boolean finalizada;
    private double costoFijo;
    private double tiempoEnEspera;

    public Llamada() {
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public int getNumero() {
        return numero;
    }

    public Llamada(LocalDateTime fechaInicio, Sector sector, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.sector = sector;
        this.descripcion = "";
        this.fechaFin = null;
        this.costo = 0;
        this.trabajador = null;
        this.cliente = cliente;
        this.numero = 0;
        this.finalizada = false;
        this.costoFijo = 5;
        this.tiempoEnEspera = tiempoEnEspera;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Sector getSector() {
        return sector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCostoFijo() {
        return costoFijo;
    }

    public void setCostoFijo(double costoFijo) {
        this.costoFijo = costoFijo;
    }

    public double getTiempoEnEspera() {
        return tiempoEnEspera;
    }

    public void setTiempoEnEspera(double tiempoEnEspera) {
        this.tiempoEnEspera = tiempoEnEspera;
    }

    
    public void finalizarLlamada(Trabajador t, String d) {
        trabajador = t;
        fechaFin = LocalDateTime.now();
        descripcion = d;
        costo = this.calcularCostoLlamada();
        finalizada = true;
    }

    public double calcularCostoLlamada() {
        return cliente.calcularCostosLlamada(this);
    }
    
    public String estadoDeLlamada (){
        if(!finalizada){
            return "En curso";
        } else {
            return "Finalizada";
        }
    }

    public void setNumero(int size) {
        this.numero = size;
    }

    public String nombreTrabajador() {
        return trabajador.getNombre();
    }

    public double calcularDuracion() {
        Duration d = Duration.between(fechaFin, fechaInicio);
        double dur;
        dur = (double) d.getSeconds();
        return dur;
        
    }

    public String nombreCliente() {
        return cliente.getNombre();
    }
    
}
