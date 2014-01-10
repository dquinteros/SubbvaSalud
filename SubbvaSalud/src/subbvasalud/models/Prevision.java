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
public class Prevision extends Conexion {

    private int idPrevision;
    private String nombrePrevision;

    /**
     *
     */
    public Prevision() {
        this.idPrevision = -1;
    }

    /**
     *
     * @return
     */
    public LinkedList<Prevision> getAllPrevision() {
        String sql = "select * from prevision";
        ResultSet result = null;
        connect();
        LinkedList<Prevision> listPrevision;
        listPrevision = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Prevision newPrevision = this.createPrevisionFromResultSet(result);
                    boolean ans;
                    ans = listPrevision.add(newPrevision);
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
        return listPrevision;
    }

    /**
     *
     * @param r
     * @return
     */
    public Prevision createPrevisionFromResultSet(ResultSet r) {
        try {
            Prevision p;
            p = new Prevision(
                    (int) r.getObject(1),
                    (String) r.getObject(2)
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
     * @param idPrevision
     * @param nombrePrevision
     */
    public Prevision(int idPrevision, String nombrePrevision) {
        this.idPrevision = idPrevision;
        this.nombrePrevision = nombrePrevision;
    }

    /**
     *
     * @return
     */
    public int getIdPrevision() {
        return idPrevision;
    }

    /**
     *
     * @param idPrevision
     */
    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
    }

    /**
     *
     * @return
     */
    public String getNombrePrevision() {
        return nombrePrevision;
    }

    /**
     *
     * @param nombrePrevision
     */
    public void setNombrePrevision(String nombrePrevision) {
        this.nombrePrevision = nombrePrevision;
    }

}
