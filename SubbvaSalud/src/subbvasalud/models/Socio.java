/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author damage
 */
public class Socio extends Conexion {

    private int rutSocio;
    private String nombreSocio;
    private String apellidoSocio;
    private int idEstado;
    private String cuentaBancariaSocio;
    private String tipoCuentaSocio;
    private boolean presupuestoSocio;

    public Socio(int rutSocio, String nombreSocio, String apellidoSocio, int idEstado, String cuentaBancariaSocio, String tipoCuentaSocio, boolean presupuestoSocio) {
        this.rutSocio = rutSocio;
        this.nombreSocio = nombreSocio;
        this.apellidoSocio = apellidoSocio;
        this.idEstado = idEstado;
        this.cuentaBancariaSocio = cuentaBancariaSocio;
        this.tipoCuentaSocio = tipoCuentaSocio;
        this.presupuestoSocio = presupuestoSocio;
    }

    public int insertSocio(Socio s) {
        String sql = "";
        return 0;
    }

    public List<Socio> getAllSocios() {
        String sql = "select * from socio";
        ResultSet resultado = null;        
        List<Socio> listSocios = null;
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int i = 0;
                while (resultado.next()) {
                    Socio newSocio = (Socio) resultado.getObject(i);
                    boolean ans = listSocios.add(newSocio);
                    i++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                consulta.close();
                conexion.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return listSocios;
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

    public String getApellidoSocio() {
        return apellidoSocio;
    }

    public void setApellidoSocio(String apellidoSocio) {
        this.apellidoSocio = apellidoSocio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getCuentaBancariaSocio() {
        return cuentaBancariaSocio;
    }

    public void setCuentaBancariaSocio(String cuentaBancariaSocio) {
        this.cuentaBancariaSocio = cuentaBancariaSocio;
    }

    public String getTipoCuentaSocio() {
        return tipoCuentaSocio;
    }

    public void setTipoCuentaSocio(String tipoCuentaSocio) {
        this.tipoCuentaSocio = tipoCuentaSocio;
    }

    public boolean isPresupuestoSocio() {
        return presupuestoSocio;
    }

    public void setPresupuestoSocio(boolean presupuestoSocio) {
        this.presupuestoSocio = presupuestoSocio;
    }

}
