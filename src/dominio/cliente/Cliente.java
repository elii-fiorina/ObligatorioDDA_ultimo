/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.cliente;

import dominio.Sector.Llamada;

/**
 *
 * @author alumnoFI
 */
public abstract class Cliente {
    private String cedula;
    private String nombre;
    double saldo;

    public Cliente(String cedula, String nombre, double saldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     *
     */
    public abstract double calcularCostosLlamada(Llamada llamada);
    
}
