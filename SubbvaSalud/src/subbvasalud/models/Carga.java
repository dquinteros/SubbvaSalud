/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class Carga extends Conexion {

    private int idCarga;
    private int idSocio;
    private String rut;
    private String nombre;
    private int idEstado;

    /**
     *
     */
    public Carga() {
    }

    /**
     *
     * @param idCarga
     * @param idSocio
     * @param rut
     * @param nombre
     * @param idEstado
     */
    public Carga(int idCarga, int idSocio, String rut, String nombre, int idEstado) {
        this.idCarga = idCarga;
        this.idSocio = idSocio;
        this.rut = rut;
        this.nombre = nombre;
        this.idEstado = idEstado;
    }

    /**
     *
     * @param c
     * @return
     */
    public String cargaToSqlInsert(Carga c) {
        if (c != null) {
            String sql = "INSERT INTO \"carga\""
                    + "(\"id_carga\","
                    + "\"id_socio\","
                    + "\"rut_carga\","
                    + "\"nombre_carga\","
                    + "\"id_estado\")"
                    + " VALUES("
                    + " NULL,"
                    + c.getIdSocio() + ","
                    + " '" + c.getRut() + "',"
                    + " '" + c.getNombre() + "',"
                    + c.getIdEstado()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public String cargaToSqlUpdate(Carga c) {
        if (c != null) {
            String sql = "UPDATE \"carga\""
                    + " SET"
                    + " rut_carga = \"" + c.getRut() + "\","
                    + " nombre_carga = \"" + c.getNombre() + "\","
                    + " id_estado = " + c.getIdEstado()
                    + " WHERE id_carga= " + c.getIdCarga()
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
    public String cargaToSqlFindById(int id) {
        if (id >= 0) {
            String sql = "SELECT * FROM carga WHERE id_carga =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param rut
     * @return
     */
    public String cargaToSqlFindByRut(String rut) {
        if (ViewUtils.validaRut(rut)) {
            String sql = "SELECT * FROM carga WHERE rut_carga =" + rut + ";";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param c
     * @return
     */
    public int insertCarga(Carga c) {
        String sql = this.cargaToSqlInsert(c);

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
     * @param c
     * @return
     */
    public int updateCarga(Carga c) {
        String sql = this.cargaToSqlUpdate(c);

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
    public LinkedList<Carga> getAllCargas() {
        String sql = "select * from carga where id_estado = 1";
        ResultSet result = null;
        connect();
        LinkedList<Carga> listCargas;
        listCargas = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Carga newCarga = this.createCargaFromResultSet(result);
                    boolean ans;
                    ans = listCargas.add(newCarga);
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
        return listCargas;
    }

    /**
     *
     * @param id
     * @return
     */
    public LinkedList<Carga> getAllCargasByIdSocio(int id) {
        String sql = "select * from carga where id_socio =" + id + " and id_estado = 1";
        ResultSet result = null;
        connect();
        LinkedList<Carga> listCargas;
        listCargas = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Carga newCarga = this.createCargaFromResultSet(result);
                    boolean ans;
                    ans = listCargas.add(newCarga);
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
        return listCargas;
    }

    /**
     *
     * @param id
     * @return
     */
    public Carga getCargasById(int id) {
        String sql = cargaToSqlFindById(id);
        ResultSet result = null;
        connect();
        Carga newCarga = new Carga();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newCarga = this.createCargaFromResultSet(result);
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
     * @param rut
     * @return
     */
    public Carga getCargasByRut(String rut) {
        String sql = cargaToSqlFindByRut(rut);
        ResultSet result = null;
        connect();
        Carga newCarga = new Carga();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newCarga = this.createCargaFromResultSet(result);
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
     * @param r
     * @return
     */
    public Carga createCargaFromResultSet(ResultSet r) {
        try {
            Carga c;
            c = new Carga(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (String) r.getObject(3),
                    (String) r.getObject(4),
                    (int) r.getObject(5)
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
    public int getIdCarga() {
        return idCarga;
    }

    /**
     *
     * @param idCarga
     */
    public void setIdCarga(int idCarga) {
        this.idCarga = idCarga;
    }

    /**
     *
     * @return
     */
    public int getIdSocio() {
        return idSocio;
    }

    /**
     *
     * @param idSocio
     */
    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    /**
     *
     * @return
     */
    public String getRut() {
        return rut;
    }

    /**
     *
     * @param rut
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     *
     * @param idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

}
