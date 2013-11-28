/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class MainMenuControllerTest {

    MainMenuController mmc;

    Socio socioNull;
    Socio socioVacio;
    Socio socioValido;

    public MainMenuControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mmc = new MainMenuController();
        socioNull = null;
        socioVacio = new Socio();       
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of totalPersonas method, of class MainMenuController.
     */
    @Test
    public void testMostrarSocios() {
        System.out.println("totalPersonas");
        DefaultTableModel tableModel = null;

        mmc.mostrarSocios(tableModel);

    }

    @Test
    public void testInsertarSocio() {
        System.out.println("insertarSocio");
        int actual = mmc.guardarSocio(socioNull);
        int actual2 = mmc.guardarSocio(socioVacio);
        assertEquals(0, actual);
        assertEquals(1, actual2);
        assertEquals(-1, actual2);
    }

}
