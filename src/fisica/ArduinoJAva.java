/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisica;

import com.panamahitek.PanamaHitek_Arduino;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

public class ArduinoJAva {

    public static PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    public static boolean bandera = false;
    public static LinkedList<String> valoress = new LinkedList<>();
    public static int puntos;
    public static String cc;
    public static final SerialPortEventListener LISTENER = new SerialPortEventListener() {
        public String valorVoltajeA;
        public String clave = JOptionPane.showInputDialog(null, "Ingrese el dato");
        public String valor;
        
        {
            try {
                cc = clave;
                this.valor = valorDB(Integer.valueOf(cc));
                puntos = PuntosDB(Integer.valueOf(cc));
            } catch (SQLException ex) {
                Logger.getLogger(ArduinoJAva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        public void serialEvent(SerialPortEvent spe) {        
            try {
                while (arduino.isMessageAvailable()) {
                    valorVoltajeA = arduino.printMessage();
                    if (valorVoltajeA.equalsIgnoreCase(valor) && valoress.size() < puntos) {
                        if (bandera == false) {
                            valoress.add(valorVoltajeA);
                            System.out.println(valoress);
                            IngresoConCoordenadas in = new IngresoConCoordenadas();
                            in.jTextField1.setText(valorVoltajeA);
                            in.setVisible(true);
                            bandera = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "La ventana ya esta abierta");
                        }
                        
                    }
                }
            } catch (Exception e) {
            }

        }
    };

    public static String promedio(LinkedList<String> listaValores) {
        double Promedio = 0.0;
        LinkedList<String> valores = listaValores;
        for (int i = 0; i < valores.size(); i++) {
            Promedio = Promedio + Double.valueOf(valores.get(i));
        }
        Promedio = Promedio / valores.size();
        String pro = String.valueOf(Promedio);
        return pro;
    }

    public static String valorDB(int clave) throws SQLException {
        DatosDao dao = new DatosDao();
        double valor = dao.ValorVoltaje(clave);
        String valoraRetornar = String.valueOf(valor);
        return valoraRetornar;
    }
    
    public static int PuntosDB(int clave) throws SQLException {
        DatosDao dao = new DatosDao();
        int valor = dao.NumeroPuntos(clave);        
        return valor;
    }

}
