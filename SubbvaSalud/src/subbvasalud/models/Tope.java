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

    public Tope() {
    }

    public Tope(int idTope, Double tope, int monedaTope, int tipoTope) {
        this.idTope = idTope;
        this.tope = tope;
        this.monedaTope = monedaTope;
        this.tipoTope = tipoTope;
    }

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
                    boolean ans;
                    ans = listTopes.add(newTope);
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
        return listTopes;
    }

    public String topeToSqlFindById(int id) {
        if (id >= 0) {
            String sql = "SELECT * FROM tope WHERE id_tope =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

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
                    if (newTope != null) {
                         
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
        return newTope;
    }

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

    public int getIdTope() {
        return idTope;
    }

    public void setIdTope(int idTope) {
        this.idTope = idTope;
    }

    public Double getTope() {
        return tope;
    }

    public void setTope(Double tope) {
        this.tope = tope;
    }

    public int getMonedaTope() {
        return monedaTope;
    }

    public void setMonedaTope(int monedaTope) {
        this.monedaTope = monedaTope;
    }

    public int getTipoTope() {
        return tipoTope;
    }

    public void setTipoTope(int tipoTope) {
        this.tipoTope = tipoTope;
    }

}
