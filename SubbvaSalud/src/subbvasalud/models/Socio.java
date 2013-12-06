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
public class Socio extends Conexion {

    private int idSocio;
    private int rutSocio;
    private String nombreSocio;
    private String cuentaBancariaSocio;
    private int tipoCuentaSocio;
    private int presupuestoSocio;
    private int idEstado;
    private int bancoSocio;

    private static final int COLUMNAS = 8;

    public Socio() {

    }

    public Socio(int idSocio, int rutSocio, String nombreSocio, String cuentaBancariaSocio, int tipoCuentaSocio, int presupuestoSocio, int idEstado, int bancoSocio) {
        this.idSocio = idSocio;
        this.rutSocio = rutSocio;
        this.nombreSocio = nombreSocio;
        this.cuentaBancariaSocio = cuentaBancariaSocio;
        this.tipoCuentaSocio = tipoCuentaSocio;
        this.presupuestoSocio = presupuestoSocio;
        this.idEstado = idEstado;
        this.bancoSocio = bancoSocio;
    }

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
                    + s.getRutSocio() + ","
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

    public LinkedList<Socio> getAllSocios() {
        String sql = "select * from socio";
        ResultSet result = null;
        connect();
        LinkedList<Socio> listSocios;
        listSocios = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    System.out.println("Pasa");
                    Socio newSocio = this.createSocioFromResultSet(result);
                    boolean ans;
                    ans = listSocios.add(newSocio);
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
        return listSocios;
    }

    public Socio createSocioFromResultSet(ResultSet r) {
        try {
            Socio s;
            s = new Socio(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
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

    public int getRutSocio() {
        return rutSocio;
    }

    public void setRutSocio(int rutSocio) {
        this.rutSocio = rutSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getCuentaBancariaSocio() {
        return cuentaBancariaSocio;
    }

    public void setCuentaBancariaSocio(String cuentaBancariaSocio) {
        this.cuentaBancariaSocio = cuentaBancariaSocio;
    }

    public int getTipoCuentaSocio() {
        return tipoCuentaSocio;
    }

    public void setTipoCuentaSocio(int tipoCuentaSocio) {
        this.tipoCuentaSocio = tipoCuentaSocio;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getPresupuestoSocio() {
        return presupuestoSocio;
    }

    public void setPresupuestoSocio(int presupuestoSocio) {
        this.presupuestoSocio = presupuestoSocio;
    }

    public int getBancoSocio() {
        return bancoSocio;
    }

    public void setBancoSocio(int bancoSocio) {
        this.bancoSocio = bancoSocio;
    }
}
