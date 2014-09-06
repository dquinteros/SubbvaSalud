/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.controllers;

import java.io.File;
import subbvasalud.models.Periodo;

/**
 *
 * @author damage
 */
public class informeNuboxController {

    public informeNuboxController() {
    }
    
    public void createNuboxReport(File f,Periodo p){
        String fileName = f.getPath();
        System.out.println(fileName);
    }
    
}
