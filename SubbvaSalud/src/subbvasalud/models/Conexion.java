/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author damage
 */
public class Conexion {

    Connection connection;
    Statement query;
    public String ruta;

    /**
     * Constructor for objects of class Conexion
     */
    @SuppressWarnings("empty-statement")
    public Conexion() {
        ruta = System.getProperty("user.dir").substring(2).replace('\\', '/') + "/data/subbvaSaludDB.db";
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "/data/subbvaSaludDB.db");
            query = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ResultSet consultar(String sql){
        connect();
        ResultSet resultado = null;
        try {
            resultado = query.executeQuery(sql);
        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return resultado;
    }
}
