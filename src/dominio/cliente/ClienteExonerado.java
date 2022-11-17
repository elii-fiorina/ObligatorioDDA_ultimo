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
public class ClienteExonerado extends Cliente{

    public ClienteExonerado(String cedula, String nombre, double saldo) {
        super(cedula, nombre, saldo);
    }

    @Override
    public double calcularCostosLlamada(Llamada llamada) {
        llamada.setCosto(0);
        return 0;
    }
    
}
