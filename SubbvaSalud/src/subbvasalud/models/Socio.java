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
public class Socio extends Conexion {

    private int idSocio;
    private String rutSocio;
    private String nombreSocio;
    private String cuentaBancariaSocio;
    private int tipoCuentaSocio;
    private int presupuestoSocio;
    private int idEstado;
    private int bancoSocio;

    private static final int COLUMNAS = 8;

    /**
     *
     */
    public Socio() {

    }

    /**
     *
     * @param idSocio
     * @param rutSocio
     * @param nombreSocio
     * @param cuentaBancariaSocio
     * @param tipoCuentaSocio
     * @param presupuestoSocio
     * @param idEstado
     * @param bancoSocio
     */
    public Socio(int idSocio, String rutSocio, String nombreSocio, String cuentaBancariaSocio, int tipoCuentaSocio, int presupuestoSocio, int idEstado, int bancoSocio) {
        this.idSocio = idSocio;
        this.rutSocio = rutSocio;
        this.nombreSocio = nombreSocio;
        this.cuentaBancariaSocio = cuentaBancariaSocio;
        this.tipoCuentaSocio = tipoCuentaSocio;
        this.presupuestoSocio = presupuestoSocio;
        this.idEstado = idEstado;
        this.bancoSocio = bancoSocio;
    }

    /**
     *
     * @param s
     * @return
     */
    public String socioToSqlInsert(Socio s) {
        if (s != null) {
            String sql = "INSERT INTO \"socio\""
                    + "(\"id_socio\","
                    + "\"rut_socio\","
                    + "\"nombre_socio\","
                    + "\"cuenta_bancaria_socio\","
                    + "\"tipo_cuenta_socio\","
                    + "\"presupuesto_socio\","
                    + "\"id_estado\","
                    + "\"id_banco\")"
                    + " VALUES("
                    + " NULL,"
                    + " '" + s.getRutSocio() + "',"
                    + " '" + s.getNombreSocio() + "',"
                    + " '" + s.getCuentaBancariaSocio() + "',"
                    + s.getTipoCuentaSocio() + ","
                    + s.getPresupuestoSocio() + ","
                    + s.getIdEstado() + ","
                    + s.getBancoSocio()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public String socioToSqlUpdate(Socio s) {
        if (s != null) {
            String sql = "UPDATE \"socio\""
                    + " SET"
                    + " rut_socio = \"" + s.getRutSocio() + "\","
                    + " nombre_socio = \"" + s.getNombreSocio() + "\","
                    + " cuenta_bancaria_socio = \"" + s.getCuentaBancariaSocio() + "\","
                    + " tipo_cuenta_socio = " + s.getTipoCuentaSocio() + ","
                    + " presupuesto_socio = " + s.getPresupuestoSocio() + ","
                    + " id_estado = " + s.getIdEstado() + ","
                    + " id_banco = " + s.getBancoSocio()
                    + " WHERE id_socio= " + s.getIdSocio()
                    + ";";
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
    public String socioToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM socio WHERE id_socio =" + id + ";";
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
    public String socioToSqlFindByRut(String rut) {
        if (ViewUtils.validaRut(rut)) {
            String sql = "SELECT * FROM socio WHERE rut_socio = '" + rut + "';";
            return sql;
        } else {
            return null;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public int insertSocio(Socio s) {
        String sql = this.socioToSqlInsert(s);

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
     * @param lista
     * @return
     */
    public int insertAllSocio(LinkedList<String> lista) {
        connect();
        consultarBatch(lista);
        return 0;
    }

    /**
     *
     * @param s
     * @return
     */
    public int updateSocio(Socio s) {
        String sql = this.socioToSqlUpdate(s);

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
    public LinkedList<Socio> getAllSocios() {
        String sql = "select * from socio where id_estado = 1";
        ResultSet result = null;
        connect();
        LinkedList<Socio> listSocios;
        listSocios = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Socio newSocio = this.createSocioFromResultSet(result);
                    boolean ans;
                    ans = listSocios.add(newSocio);
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
        return listSocios;
    }

    public LinkedList<Socio> getAllFullSocios() {
        String sql = "select * from socio;";
        ResultSet result = null;
        connect();
        LinkedList<Socio> listSocios;
        listSocios = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    Socio newSocio = this.createSocioFromResultSet(result);
                    boolean ans;
                    ans = listSocios.add(newSocio);
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
        return listSocios;
    }

    /**
     *
     * @param id
     * @return
     */
    public Socio getSociosById(int id) {
        String sql = socioToSqlFindById(id);
        ResultSet result = null;
        connect();
        Socio newSocio = new Socio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newSocio = this.createSocioFromResultSet(result);
                    if (newSocio != null) {

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
        return newSocio;
    }

    /**
     *
     * @param rut
     * @return
     */
    public Socio getSociosByRut(String rut) {
        String sql = socioToSqlFindByRut(rut);
        ResultSet result = null;
        connect();
        Socio newSocio = new Socio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newSocio = this.createSocioFromResultSet(result);
                    if (newSocio != null) {

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
        return newSocio;
    }

    /**
     *
     * @param r
     * @return
     */
    public Socio createSocioFromResultSet(ResultSet r) {
        try {
            Socio s;
            s = new Socio(
                    (int) r.getObject(1),
                    (String) r.getObject(2),
                    (String) r.getObject(3),
                    (String) r.getObject(4),
                    (int) r.getObject(5),
                    (int) r.getObject(6),
                    (int) r.getObject(7),
                    (int) r.getObject(8)
            );
            return s;
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
    public String getRutSocio() {
        return rutSocio;
    }

    /**
     *
     * @param rutSocio
     */
    public void setRutSocio(String rutSocio) {
        this.rutSocio = rutSocio;
    }

    /**
     *
     * @return
     */
    public String getNombreSocio() {
        return nombreSocio;
    }

    /**
     *
     * @param nombreSocio
     */
    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    /**
     *
     * @return
     */
    public String getCuentaBancariaSocio() {
        return cuentaBancariaSocio;
    }

    /**
     *
     * @param cuentaBancariaSocio
     */
    public void setCuentaBancariaSocio(String cuentaBancariaSocio) {
        this.cuentaBancariaSocio = cuentaBancariaSocio;
    }

    /**
     *
     * @return
     */
    public int getTipoCuentaSocio() {
        return tipoCuentaSocio;
    }

    /**
     *
     * @param tipoCuentaSocio
     */
    public void setTipoCuentaSocio(int tipoCuentaSocio) {
        this.tipoCuentaSocio = tipoCuentaSocio;
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

    /**
     *
     * @return
     */
    public int getPresupuestoSocio() {
        return presupuestoSocio;
    }

    /**
     *
     * @param presupuestoSocio
     */
    public void setPresupuestoSocio(int presupuestoSocio) {
        this.presupuestoSocio = presupuestoSocio;
    }

    /**
     *
     * @return
     */
    public int getBancoSocio() {
        return bancoSocio;
    }

    /**
     *
     * @param bancoSocio
     */
    public void setBancoSocio(int bancoSocio) {
        this.bancoSocio = bancoSocio;
    }
}
