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
public class Tope extends Conexion {

    private int idTope;
    private Double tope;
    private int monedaTope;
    private int tipoTope;

    /**
     *
     */
    public Tope() {
    }

    /**
     *
     * @param idTope
     * @param tope
     * @param monedaTope
     * @param tipoTope
     */
    public Tope(int idTope, Double tope, int monedaTope, int tipoTope) {
        this.idTope = idTope;
        this.tope = tope;
        this.monedaTope = monedaTope;
        this.tipoTope = tipoTope;
    }

    /**
     *
     * @return
     */
    public LinkedList<Tope> getAllTopes() {
        String sql = "select * from Tope";
        ResultSet result = null;
        connect();
        LinkedList<Tope> listTopes;
        listTopes = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    Tope newTope = this.createTopeFromResultSet(result);
                    listTopes.add(newTope);
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return listTopes;
    }

    /**
     *
     * @param id
     * @return
     */
    public String topeToSqlFindById(int id) {
        if (id >= 0) {
            String sql = "SELECT * FROM tope WHERE id_tope =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Tope getTopeById(int id) {
        String sql = topeToSqlFindById(id);
        ResultSet result = null;
        connect();
        Tope newTope = new Tope();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newTope = this.createTopeFromResultSet(result);
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
        return newTope;
    }

    /**
     *
     * @param r
     * @return
     */
    public Tope createTopeFromResultSet(ResultSet r) {
        try {
            Tope p;
            p = new Tope(
                    (int) r.getObject(1),
                    (Double) r.getObject(2),
                    (int) r.getObject(3),
                    (int) r.getObject(4)
            );
            return p;
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

    /**
     *
     * @return
     */
    public Double getTope() {
        return tope;
    }

    /**
     *
     * @param tope
     */
    public void setTope(Double tope) {
        this.tope = tope;
    }

    /**
     *
     * @return
     */
    public int getMonedaTope() {
        return monedaTope;
    }

    /**
     *
     * @param monedaTope
     */
    public void setMonedaTope(int monedaTope) {
        this.monedaTope = monedaTope;
    }

    /**
     *
     * @return
     */
    public int getTipoTope() {
        return tipoTope;
    }

    /**
     *
     * @param tipoTope
     */
    public void setTipoTope(int tipoTope) {
        this.tipoTope = tipoTope;
    }

}
