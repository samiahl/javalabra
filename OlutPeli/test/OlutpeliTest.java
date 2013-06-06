/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import LautaJaKappaleet.Kortti;
import LautaJaKappaleet.Pelaaja;
import LautaJaKappaleet.Pelilauta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samiahl
 */
public class OlutpeliTest {

 

    public OlutpeliTest() {
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

    @Test
    public void hello() {
    }

    

    @Test
    public void korttiPalauttaaOikeanTotuusarvon() {
        Kortti kortti = new Kortti(1);
        Kortti kortti2 = new Kortti(1);

        kortti.asetaKaannetyksi();

        boolean vastaus = true;
        boolean vastaus2 = false;

        assertTrue(vastaus);
        assertFalse(vastaus2);
    }

   

    
    
}
