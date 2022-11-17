/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.cliente;

import dominio.Sector.Llamada;

/**
 *
 * @author ana
 */
public class ClienteConCosto extends Cliente{

    public ClienteConCosto(String cedula, String nombre, double saldo) {
        super(cedula, nombre, saldo);
    }

    @Override
    public double calcularCostosLlamada(Llamada llamada) {
        double costo = llamada.getCostoFijo() * llamada.calcularDuracion();
        if(llamada.getTiempoEnEspera() < 60){
            costo = costo /2;
        }
        llamada.setCosto(costo);
        double saldoTotal = this.saldo - costo;
        this.setSaldo(saldoTotal);
        return costo;
    }
    
}
