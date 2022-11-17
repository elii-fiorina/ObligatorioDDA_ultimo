/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.cliente;

import dominio.Sector.Llamada;


public class ClienteGestor extends Cliente{

    public ClienteGestor(String cedula, String nombre, double saldo) {
        super(cedula, nombre, saldo);
    }

    @Override
    public double calcularCostosLlamada(Llamada llamada) {
        double costoFijo = llamada.getCostoFijo() /2;
        double costo = 0;
        double duracion = llamada.calcularDuracion();
        if(duracion > 180){
            costo = llamada.getCostoFijo() * duracion;
        }else{
            costo = (costoFijo * duracion)- (llamada.getCostoFijo() * duracion);
        }
        if(costo < 0){
            costo = 0;
        }
        llamada.setCosto(costo);
        double saldoTotal = this.saldo - costo;
        this.setSaldo(saldoTotal);
        return 0;
    }
    
}
