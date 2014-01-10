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
public class Condicion extends Conexion {

    /**
     *
     */
    public int idCondicion;

    /**
     *
     */
    public int idTipo;

    /**
     *
     */
    public int idTope;

    /**
     *
     */
    public Condicion() {
    }

    /**
     *
     * @param idCondicion
     * @param idTipo
     * @param idTope
     */
    public Condicion(int idCondicion, int idTipo, int idTope) {
        this.idCondicion = idCondicion;
        this.idTipo = idTipo;
        this.idTope = idTope;
    }

    /**
     *
     * @return
     */
    public LinkedList<Condicion> getAllCondiciones() {
        String sql = "select * from condicion";
        ResultSet result = null;
        connect();
        LinkedList<Condicion> listCondiciones;
        listCondiciones = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Condicion newCondicion = this.createCondicionFromResultSet(result);
                    boolean ans;
                    ans = listCondiciones.add(newCondicion);
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
        return listCondiciones;
    }

    /**
     *
     * @param r
     * @return
     */
    public Condicion createCondicionFromResultSet(ResultSet r) {
        try {
            Condicion c;
            c = new Condicion(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (int) r.getObject(3)
            );
            return c;
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
    public int getIdCondicion() {
        return idCondicion;
    }

    /**
     *
     * @param idCondicion
     */
    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    /**
     *
     * @return
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     *
     * @param idTipo
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     *
     * @return
     */
    public int getIdTope() {
        return idTope;
    }

    /**
     *
     * @param idTope
     */
    public void setIdTope(int idTope) {
        this.idTope = idTope;
    }

}
