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

    public Prestacion() {
    }

    public Prestacion(int idPrestacion, int idGasto, String nombrePrestacion) {
        this.idPrestacion = idPrestacion;
        this.idGasto = idGasto;
        this.nombrePrestacion = nombrePrestacion;
    }

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
                    System.out.println("Pasa");
                    Prestacion newPrestacion = this.createPrestacionFromResultSet(result);
                    boolean ans;
                    ans = listPrestacion.add(newPrestacion);
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
        return listPrestacion;
    }

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
                    System.out.println("Pasa");
                    Prestacion newPrestacion = this.createPrestacionFromResultSet(result);
                    boolean ans;
                    ans = listPrestacion.add(newPrestacion);
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
        return listPrestacion;
    }

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

    public int getIdPrestacion() {
        return idPrestacion;
    }

    public void setIdPrestacion(int idPrestacion) {
        this.idPrestacion = idPrestacion;
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getNombrePrestacion() {
        return nombrePrestacion;
    }

    public void setNombrePrestacion(String nombrePrestacion) {
        this.nombrePrestacion = nombrePrestacion;
    }

}
