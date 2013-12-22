/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.controllers;

import java.util.LinkedList;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;

/**
 *
 * @author damage
 */
public class SolicitudController {
    
   SolicitudDeReembolso sr;
   Periodo p;
   Socio s;
   LinkedList<SolicitudDeReembolso> lsr;

    public SolicitudController() {
        sr = new SolicitudDeReembolso();
        p = new Periodo();
        s = new Socio();        
    }
   
    public int guardarSolicitud(SolicitudDeReembolso sre) {

        int i = sr.insertSolicitud(sre);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public int editarSolicitud(SolicitudDeReembolso sre) {
        int i = sr.updateSolicitud(sre);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public SolicitudDeReembolso getSolicitud(int id) {
        return sr.getSolicitudById(id);
    } 
    
    
       
    
}
