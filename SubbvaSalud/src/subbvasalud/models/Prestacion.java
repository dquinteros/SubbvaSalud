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
public class Prestacion extends Conexion {

    private int idPrestacion;
    private int idGasto;
    private String nombrePrestacion;

    /**
     *
     */
    public Prestacion() {
        this.idPrestacion = -1;
    }

    /**
     *
     * @param idPrestacion
     * @param idGasto
     * @param nombrePrestacion
     */
    public Prestacion(int idPrestacion, int idGasto, String nombrePrestacion) {
        this.idPrestacion = idPrestacion;
        this.idGasto = idGasto;
        this.nombrePrestacion = nombrePrestacion;
    }

    /**
     *
     * @return
     */
    public LinkedList<Prestacion> getAllPrestacion() {
        String sql = "select * from prestacion";
        ResultSet result = null;
        connect();
        LinkedList<Prestacion> listPrestacion;
        listPrestacion = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Prestacion newPrestacion = this.createPrestacionFromResultSet(result);
                    boolean ans;
                    ans = listPrestacion.add(newPrestacion);
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
        return listPrestacion;
    }

    /**
     *
     * @param idGasto
     * @return
     */
    public LinkedList<Prestacion> getAllPrestacionByGasto(int idGasto) {
        String sql = "select * from prestacion where id_gasto = " + idGasto + ";";
        ResultSet result = null;
        connect();
        LinkedList<Prestacion> listPrestacion;
        listPrestacion = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Prestacion newPrestacion = this.createPrestacionFromResultSet(result);
                    boolean ans;
                    ans = listPrestacion.add(newPrestacion);
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
        return listPrestacion;
    }

    /**
     *
     * @param id
     * @return
     */
    public Prestacion getPrestacionById(int id) {
        String sql = "select * from prestacion where id_prestacion = " + idGasto + ";";
        ResultSet result = null;
        connect();
         Prestacion newPrestacion = new Prestacion();
        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    newPrestacion = this.createPrestacionFromResultSet(result);                    
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
        return newPrestacion;
    }

    /**
     *
     * @param r
     * @return
     */
    public Prestacion createPrestacionFromResultSet(ResultSet r) {
        try {
            Prestacion p;
            p = new Prestacion(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (String) r.getObject(3)
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
    public int getIdPrestacion() {
        return idPrestacion;
    }

    /**
     *
     * @param idPrestacion
     */
    public void setIdPrestacion(int idPrestacion) {
        this.idPrestacion = idPrestacion;
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
    public String getNombrePrestacion() {
        return nombrePrestacion;
    }

    /**
     *
     * @param nombrePrestacion
     */
    public void setNombrePrestacion(String nombrePrestacion) {
        this.nombrePrestacion = nombrePrestacion;
    }

}
