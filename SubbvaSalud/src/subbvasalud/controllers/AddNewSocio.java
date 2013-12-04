/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class AddNewSocio {

    Socio s;

    public AddNewSocio() {
        s = new Socio();
    }

    public int guardarSocio(Socio so) {
        int i = s.insertSocio(so);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public void formInsertarSocio() {
    }

}
