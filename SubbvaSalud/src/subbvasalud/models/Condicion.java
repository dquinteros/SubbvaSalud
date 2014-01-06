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

    public int idCondicion;
    public int idTipo;
    public int idTope;

    public Condicion() {
    }

    public Condicion(int idCondicion, int idTipo, int idTope) {
        this.idCondicion = idCondicion;
        this.idTipo = idTipo;
        this.idTope = idTope;
    }

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
                    System.out.println("Pasa");
                    Condicion newCondicion = this.createCondicionFromResultSet(result);
                    boolean ans;
                    ans = listCondiciones.add(newCondicion);
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
        return listCondiciones;
    }

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

    public int getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdTope() {
        return idTope;
    }

    public void setIdTope(int idTope) {
        this.idTope = idTope;
    }

}
