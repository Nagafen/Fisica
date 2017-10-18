/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisica;

/**
 *
 * @author crist
 */
public class Datos {
    public double voltaje;
    public int puntos;
    public int clave;

    public Datos(double voltaje, int puntos, int clave) {
        this.voltaje = voltaje;
        this.puntos = puntos;
        this.clave = clave;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    
    
}
