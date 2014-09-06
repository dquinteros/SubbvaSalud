/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

/**
 *
 * @author damage
 */
public class FarmaciaDTO {

    String rut;
    int monto;

    public FarmaciaDTO(String rut, int monto) {
        this.rut = rut;
        this.monto = monto;
    }

    public FarmaciaDTO() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

}
