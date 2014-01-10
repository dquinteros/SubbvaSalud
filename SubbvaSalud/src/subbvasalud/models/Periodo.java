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
public class Periodo extends Conexion {

    private int id_periodo;
    private int id_anio;
    private int estado_id_estado;
    private String nombre_periodo;
    private int valor_uf;

    /**
     *
     */
    public Periodo() {
    }

    /**
     *
     * @param id_periodo
     * @param id_anio
     * @param estado_id_estado
     * @param nombre_periodo
     * @param valor_uf
     */
    public Periodo(int id_periodo, int id_anio, int estado_id_estado, String nombre_periodo, int valor_uf) {
        this.id_periodo = id_periodo;
        this.id_anio = id_anio;
        this.estado_id_estado = estado_id_estado;
        this.nombre_periodo = nombre_periodo;
        this.valor_uf = valor_uf;
    }

    /**
     *
     * @param p
     * @return
     */
    public String periodoToSqlInsert(Periodo p) {
        if (p != null) {
            String sql = "INSERT INTO \"periodo\""
                    + "(\"id_periodo\","
                    + "\"id_anio\","
                    + "\"estado_id_estado\","
                    + "\"nombre_periodo\","
                    + "\"valor_uf_periodo\")"
                    + " VALUES("
                    + " NULL,"
                    + p.getId_anio() + ","
                    + p.getEstado_id_estado() + ","
                    + " '" + p.getNombre_periodo() + "',"
                    + p.getValor_uf()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param p
     * @return
     */
    public String periodoToSqlUpdate(Periodo p) {
        if (p != null) {
            String sql = "UPDATE \"periodo\""
                    + " SET"
                    + " id_anio = " + p.getId_anio() + ","
                    + " nombre_periodo = \"" + p.getNombre_periodo() + "\","
                    + " id_estado = " + p.getEstado_id_estado() + ","
                    + " valor_uf_periodo = " + p.getValor_uf()
                    + " WHERE id_periodo = " + p.getId_periodo()
                    + ";";
            System.out.println(sql);
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
    public String periodoToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM periodo WHERE id_periodo =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public String periodoToSqlFindByNombre(String name) {
        if (name != null) {
            String sql = "SELECT * FROM periodo WHERE nombre_periodo = \"" + name + "\" ;";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param p
     * @return
     */
    public int insertPeriodo(Periodo p) {
        String sql = this.periodoToSqlInsert(p);

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
     * @param p
     * @return
     */
    public int updatePeriodo(Periodo p) {
        String sql = this.periodoToSqlUpdate(p);

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
    public LinkedList<Periodo> getAllPeriodos() {
        String sql = "select * from periodo where id_estado_estado = 1";
        ResultSet result = null;
        connect();
        LinkedList<Periodo> listPeriodos;
        listPeriodos = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Periodo newPeriodo = this.createPeriodoFromResultSet(result);
                    boolean ans;
                    ans = listPeriodos.add(newPeriodo);
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
        return listPeriodos;
    }

    /**
     *
     * @param id
     * @return
     */
    public LinkedList<Periodo> getAllPeriodosByYear(int id) {
        String sql = "select * from periodo where id_anio = " + id;
        ResultSet result = null;
        connect();
        LinkedList<Periodo> listPeriodos;
        listPeriodos = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Periodo newPeriodo = this.createPeriodoFromResultSet(result);
                    boolean ans;
                    ans = listPeriodos.add(newPeriodo);
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
        return listPeriodos;
    }

    /**
     *
     * @param r
     * @return
     */
    public Periodo createPeriodoFromResultSet(ResultSet r) {
        try {
            Periodo p;
            p = new Periodo(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (int) r.getObject(3),
                    (String) r.getObject(4),
                    (int) r.getObject(5)
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
     * @param id
     * @return
     */
    public Periodo getPeriodoById(int id) {
        String sql = periodoToSqlFindById(id);
        ResultSet result = null;
        connect();
        Periodo newPeriodo = new Periodo();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newPeriodo = this.createPeriodoFromResultSet(result);
                    if (newPeriodo != null) {

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
        return newPeriodo;
    }

    /**
     *
     * @param name
     * @return
     */
    public Periodo getPeriodoByName(String name) {
        String sql = periodoToSqlFindByNombre(name);
        ResultSet result = null;
        connect();
        Periodo newCarga = new Periodo();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newCarga = this.createPeriodoFromResultSet(result);
                    if (newCarga != null) {

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
        return newCarga;
    }

    /**
     *
     * @return
     */
    public int getId_periodo() {
        return id_periodo;
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
    public int getEstado_id_estado() {
        return estado_id_estado;
    }

    /**
     *
     * @param estado_id_estado
     */
    public void setEstado_id_estado(int estado_id_estado) {
        this.estado_id_estado = estado_id_estado;
    }

    /**
     *
     * @return
     */
    public String getNombre_periodo() {
        return nombre_periodo;
    }

    /**
     *
     * @param nombre_periodo
     */
    public void setNombre_periodo(String nombre_periodo) {
        this.nombre_periodo = nombre_periodo;
    }

    /**
     *
     * @return
     */
    public int getValor_uf() {
        return valor_uf;
    }

    /**
     *
     * @param valor_uf
     */
    public void setValor_uf(int valor_uf) {
        this.valor_uf = valor_uf;
    }

}
