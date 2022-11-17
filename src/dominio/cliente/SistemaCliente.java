/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.cliente;

import dominio.trabajador.Trabajador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ana
 */
public class SistemaCliente {

    private List<ClienteExonerado> clientesExonerados = new ArrayList<ClienteExonerado>();
    private List<ClienteConCosto> clientesConCosto = new ArrayList<ClienteConCosto>();
    private List<ClienteGestor> clientesGestor = new ArrayList<ClienteGestor>();
    private List<Cliente> clientes = new ArrayList<Cliente>();

    
    public ClienteExonerado CrearClienteExonerado(String cedula, String nombre) {
        double saldo = 0;
        ClienteExonerado usuario = new ClienteExonerado(cedula, nombre, saldo);
        if (!clientesExonerados.contains(usuario)) {
            clientesExonerados.add(usuario);
            clientes.add(usuario);
        }
        return usuario;
    }

    public ClienteConCosto CrearClienteConCosto(String cedula, String nombre, double saldo) {
        ClienteConCosto usuario = new ClienteConCosto(cedula, nombre, saldo);
        if (!clientesConCosto.contains(usuario)) {
            clientesConCosto.add(usuario);
            clientes.add(usuario);
        }
        return usuario;
    }

    public ClienteGestor CrearClienteGestor(String cedula, String nombre, double saldo) {
        ClienteGestor usuario = new ClienteGestor(cedula, nombre, saldo);
        if (!clientesGestor.contains(usuario)) {
            clientesGestor.add(usuario);
            clientes.add(usuario);
        }
        return usuario;
    }

    public Cliente seleccionarCliente(String cedula) throws ClienteException  {
        for(Cliente c : clientes){
            if(c.getCedula().equals(cedula)){
                return c;
                
            }else{
                
             throw new ClienteException("Cliente no registrado");   
             
            }
        }return null;
    }
        
        
    
    
    
}
