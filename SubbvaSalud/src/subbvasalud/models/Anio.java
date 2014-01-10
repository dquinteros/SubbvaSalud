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
public class Anio extends Conexion {

    private int id_anio;
    private int numero_anio;

    /**
     *
     */
    public Anio() {
    }

    /**
     *
     * @param id_anio
     * @param numero_anio
     */
    public Anio(int id_anio, int numero_anio) {
        this.id_anio = id_anio;
        this.numero_anio = numero_anio;
    }

    /**
     *
     * @param a
     * @return
     */
    public String anioToSqlInsert(Anio a) {
        if (a != null) {
            String sql = "INSERT INTO \"anio\""
                    + "(\"id_anio\","
                    + "\"numero_anio\")"
                    + " VALUES("
                    + " null,"
                    + a.getNumero_anio()
                    + ");";
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
    public String anioToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM anio WHERE id_anio =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param anio
     * @return
     */
    public String anioToSqlFindByYear(int anio) {
        if (anio > 0) {
            String sql = "SELECT * FROM anio WHERE numero_anio =" + anio + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param a
     * @return
     */
    public int insertAnio(Anio a) {
        String sql = this.anioToSqlInsert(a);

        if (sql != null) {
            connect();
            try {
                query.executeUpdate(sql);
            } catch (SQLException e) {
                modelUtils.showSQLException(e);
            } finally {
                modelUtils.postUpdateFinally(query, connection);
            }
            return 0;
        }
        return 1;
    }

    /**
     *
     * @return
     */
    public LinkedList<Anio> getAllAnios() {
        String sql = "select * from anio";
        ResultSet result = null;
        connect();
        LinkedList<Anio> listAnios;
        listAnios = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Anio newAnio = this.createAnioFromResultSet(result);
                    boolean ans;
                    ans = listAnios.add(newAnio);
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
        return listAnios;
    }

    /**
     *
     * @param id
     * @return
     */
    public Anio getCargasById(int id) {
        String sql = anioToSqlFindById(id);
        ResultSet result = null;
        connect();
        Anio newAnio = new Anio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newAnio = this.createAnioFromResultSet(result);
                    if (newAnio != null) {

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
        return newAnio;
    }

    /**
     *
     * @param anio
     * @return
     */
    public Anio getAnioByYear(int anio) {
        String sql = anioToSqlFindByYear(anio);
        ResultSet result = null;
        connect();
        Anio newAnio = new Anio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newAnio = this.createAnioFromResultSet(result);
                    if (newAnio != null) {

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
        return newAnio;
    }

    /**
     *
     * @param r
     * @return
     */
    public Anio createAnioFromResultSet(ResultSet r) {
        try {
            Anio a;
            a = new Anio(
                    (int) r.getObject(1),
                    (int) r.getObject(2)
            );
            return a;
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
    public int getId_anio() {
        return id_anio;
    }

    /**
     *
     * @param id_anio
     */
    public void setId_anio(int id_anio) {
        this.id_anio = id_anio;
    }

    /**
     *
     * @return
     */
    public int getNumero_anio() {
        return numero_anio;
    }

    /**
     *
     * @param numero_anio
     */
    public void setNumero_anio(int numero_anio) {
        this.numero_anio = numero_anio;
    }

}
