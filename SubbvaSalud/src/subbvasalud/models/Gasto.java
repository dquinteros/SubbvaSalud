/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author damage
 */
public class Gasto extends Conexion {

    private int idGasto;
    private String nombreGasto;

    public Gasto() {
    }

    public Gasto(int idGasto, String nombreGasto) {
        this.idGasto = idGasto;
        this.nombreGasto = nombreGasto;
    }

    public LinkedList<Gasto> getAllGastos() {
        String sql = "select * from gasto";
        ResultSet result = null;
        connect();
        LinkedList<Gasto> listGastos;
        listGastos = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    System.out.println("Pasa");
                    Gasto newGasto = this.createGastoFromResultSet(result);
                    boolean ans;
                    ans = listGastos.add(newGasto);
                    if (ans == true) {
                        System.out.println("Agregado");
                    }
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return listGastos;
    }

    public Gasto createGastoFromResultSet(ResultSet r) {
        try {
            Gasto g;
            g = new Gasto(
                    (int) r.getObject(1),
                    (String) r.getObject(2)
            );
            return g;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

}
