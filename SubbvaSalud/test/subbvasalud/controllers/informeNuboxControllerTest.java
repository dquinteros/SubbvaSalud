/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.controllers;

import java.io.File;
import javax.swing.JFileChooser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import subbvasalud.models.Periodo;

/**
 *
 * @author damage
 */
public class informeNuboxControllerTest {
    JFileChooser select;
    public informeNuboxControllerTest() {
        select  = new JFileChooser();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createNuboxReport method, of class informeNuboxController.
     */
    @Test
    public void testCreateNuboxReport() {
        System.out.println("createNuboxReport");  
          int rv = select.showOpenDialog(select);
        File f  = null;
        if (rv == JFileChooser.APPROVE_OPTION) {
            f = select.getSelectedFile();
        }        
        Periodo p = null;
        informeNuboxController instance = new informeNuboxController();
        instance.createNuboxReport(f, p);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
