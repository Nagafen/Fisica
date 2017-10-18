/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author crist
 */
public class DatosDao {
    
    public String Ingreso(Datos d) throws SQLException{
        Connection conexion = Util.conexion.getConnection();
        PreparedStatement statement = null;
        double voltaje = d.getVoltaje();
        int puntos = d.getPuntos();
        int clave = d.getClave();
        String sqlQuery = "insert into datos (voltaje,puntos,clave) values (?,?,?)";
        statement = conexion.prepareStatement(sqlQuery);
        statement.setDouble(1, voltaje);
        statement.setInt(2, puntos);
        statement.setInt(3, clave);
        statement.execute();
        String bandera = "Succes import excel to mysql table";
        conexion.close();
        statement.close();
        return bandera;
    }
    public String IngresoCoordenadas(Coordenadas cor) throws SQLException{
        Connection conexion = Util.conexion.getConnection();
        PreparedStatement statement = null;
        String vol = cor.getVoltaje();
        String x = cor.getCoorX();
        String y = cor.getCoorY();
        String clave = cor.getClave();
        String sqlQuery = "insert into datosCor (voltaje,coorx,coory,clave) values (?,?,?,?)";
        statement = conexion.prepareStatement(sqlQuery);
        statement.setDouble(1, Double.valueOf(vol));
        statement.setInt(2, Integer.valueOf(x));
        statement.setInt(3, Integer.valueOf(y));
        statement.setInt(4, Integer.valueOf(clave));
        statement.execute();
        String bandera = "Succes import excel to mysql table";
        conexion.close();
        statement.close();
        return bandera;
    }
    
    public double ValorVoltaje(int clave) throws SQLException{
        Connection conexion = Util.conexion.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sqlQuery = "select voltaje from datos where clave = ?";
        statement = conexion.prepareStatement(sqlQuery);
        statement.setInt(1, clave);
        rs = statement.executeQuery();
        double voltaje = 0;
        if(rs.next()){
           voltaje = rs.getDouble("voltaje");
        }
        conexion.close();
        statement.close();
        return voltaje;
    }

    public int NumeroPuntos(int clave) throws SQLException{
        Connection conexion = Util.conexion.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String sqlQuery = "select puntos from datos where clave = ?";
        statement = conexion.prepareStatement(sqlQuery);
        statement.setInt(1, clave);
        rs = statement.executeQuery();
        int puntos = 0;
        if(rs.next()){
           puntos = rs.getInt("puntos");
        }
        conexion.close();
        statement.close();
        return puntos;
    }
}
