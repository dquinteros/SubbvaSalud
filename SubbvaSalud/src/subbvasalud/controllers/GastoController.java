/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import subbvasalud.models.Gasto;

/**
 *
 * @author damage
 */
public class GastoController {

    public GastoController() {
    }

    public LinkedList<Gasto> getAll() {
        Gasto g = new Gasto();
        LinkedList<Gasto> lg = new LinkedList<>();
        lg = g.getAllGastos();
        if (lg.size() > 0) {
            return lg;
        } else {
            return null;
        }

    }

    public Gasto getByName(String nombre) {
        Gasto g = new Gasto();
        LinkedList<Gasto> lg = new LinkedList<>();
        lg = g.getAllGastos();

        for (Gasto ga : lg) {
            if (ga.getNombreGasto().equals(nombre)) {
                return ga;
            }
        }
        return null;
    }

}
