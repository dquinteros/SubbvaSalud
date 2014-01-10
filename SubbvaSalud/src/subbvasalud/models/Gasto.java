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

    /**
     *
     */
    public Gasto() {
        this.idGasto = -1;
    }

    /**
     *
     * @param idGasto
     * @param nombreGasto
     */
    public Gasto(int idGasto, String nombreGasto) {
        this.idGasto = idGasto;
        this.nombreGasto = nombreGasto;
    }

    /**
     *
     * @return
     */
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

                    Gasto newGasto = this.createGastoFromResultSet(result);
                    boolean ans;
                    ans = listGastos.add(newGasto);
                    if (ans == true) {

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

    /**
     *
     * @param r
     * @return
     */
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

    /**
     *
     * @return
     */
    public int getIdGasto() {
        return idGasto;
    }

    /**
     *
     * @param idGasto
     */
    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    /**
     *
     * @return
     */
    public String getNombreGasto() {
        return nombreGasto;
    }

    /**
     *
     * @param nombreGasto
     */
    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

}
