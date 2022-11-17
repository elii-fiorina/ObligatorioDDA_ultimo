/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.Sector;
import dominio.trabajador.Trabajador;


public class PuestoDeTrabajo {
    private double tiempoPromedio;
    private int llamadasAtendidas;
    private Trabajador trabajador;
    private Llamada llamadaEnCurso;
    private int numero;

    public PuestoDeTrabajo(){}
    
    public PuestoDeTrabajo(double tiempoPromedio, int llamadasAtendidas) {
   
        this.tiempoPromedio = tiempoPromedio;
        this.llamadasAtendidas = llamadasAtendidas;
        this.trabajador = null;
        this.llamadaEnCurso = null;
        numero = 0;
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(double tiempoPromedio) {
        this.tiempoPromedio = calcularTiempoPromedio();
    }

    public int getLlamadasAtendidas() {
        return llamadasAtendidas;
    }

    public void setLlamadasAtendidas(int llamadasAtendidas) {
        this.llamadasAtendidas = llamadasAtendidas;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Llamada getLlamadaEnCurso() {
        return llamadaEnCurso;
    }

    public void setLlamadaEnCurso(Llamada llamadaEnCurso) {
        this.llamadaEnCurso = llamadaEnCurso;
    }

    
    private double calcularTiempoPromedio() {
        if(llamadaEnCurso != null){
            double tiempoLlamadaActual =  llamadaEnCurso.calcularDuracion();
            double promedio = (tiempoPromedio + tiempoLlamadaActual)/llamadasAtendidas;
            return promedio;
        } else {
            return tiempoPromedio;
        }
    }
    
}
