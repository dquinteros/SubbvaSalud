/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

/**
 *
 * @author damage
 */
public class TipoCuenta {

    private int idCuenta;
    private String nombreCuenta;

    /**
     *
     * @param idCuenta
     * @param nombreCuenta
     */
    public TipoCuenta(int idCuenta, String nombreCuenta) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
    }

    /**
     *
     * @return
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     *
     * @param idCuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     *
     * @return
     */
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    /**
     *
     * @param nombreCuenta
     */
    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

}
