/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import olutpeli.Kortti;
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

    private String tyyppi;

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
    public void korttiPalauttaaOikeanArvon(){
        Kortti kortti = new Kortti(1);
        
        int vastaus = kortti.GetTyyppi();
        
        assertEquals("1", vastaus);
    }
    @Test
    public void korttiPalauttaaOikeanTotuusarvon(){
        Kortti kortti = new Kortti(1);
        Kortti kortti2 = new Kortti(1);
        
        kortti.asetaKaannetyksi();
        
        boolean vastaus = true;
        boolean vastaus2 = false;
        
        assertEquals("true", vastaus);
        assertEquals("false", vastaus2);
        
        
        
    }
}
