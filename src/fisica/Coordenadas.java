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
public class Coordenadas {
    
    private String voltaje;
    private String CoorX;
    private String CoorY;
    private String clave;

    public Coordenadas(String voltaje, String CoorX, String CoorY, String clave) {
        this.voltaje = voltaje;
        this.CoorX = CoorX;
        this.CoorY = CoorY;
        this.clave = clave;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }

    public String getCoorX() {
        return CoorX;
    }

    public void setCoorX(String CoorX) {
        this.CoorX = CoorX;
    }

    public String getCoorY() {
        return CoorY;
    }

    public void setCoorY(String CoorY) {
        this.CoorY = CoorY;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    
    
    
    
}
