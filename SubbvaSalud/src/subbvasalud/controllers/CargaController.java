/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class CargaController {

    Carga c;
    Socio s;

    public CargaController() {
        s = new Socio();
        c = new Carga();
    }

    public LinkedList<Carga> getCargasByRutSocio(int rut) {
        if (ViewUtils.validaRut(rut)) {
            LinkedList<Carga> cargas;
            Socio socio = null;
            socio = s.getSociosByRut(rut);
            if (socio != null) {
                if (!socio.getNombreSocio().isEmpty()) {
                    cargas = c.getAllCargasByIdSocio(socio.getIdSocio());
                    return cargas;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public LinkedList<Carga> getCargasByRutSocio(String rut) {
        if (ViewUtils.validaRut(rut)) {
            LinkedList<Carga> cargas;
            Socio socio = null;
            socio = s.getSociosByRut(Integer.parseInt(rut));
            if (socio != null) {
                if (!socio.getNombreSocio().isEmpty()) {
                    cargas = c.getAllCargasByIdSocio(socio.getIdSocio());
                    return cargas;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public Carga getCargaByRutCargaAndSocio(int rutCarga, int rutSocio) {
        if (ViewUtils.validaRut(rutCarga)) {
           LinkedList<Carga> cargas = this.getCargasByRutSocio(rutSocio);
           if(cargas!=null){
               for(Carga ca:cargas){
                   if(ca.getRut() == rutCarga){
                       return ca;
                   }
               }
           }
        }
        return null;
    }

}