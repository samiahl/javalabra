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
public class KorttiTest {

    Kortti kortti;

    @Before
    public void setUp() {
        kortti = new Kortti(1);

    }

    @Test
    public void korttiPalauttaaOikeanArvon() {
        assertEquals(kortti.getArvo(),1);
    }

    @Test
    public void korttiPalauttaaOikeinKunKaannetty() {
        kortti.asetaKaannetyksi();
        assertTrue(kortti.onkoKaannetty());
    }
    
    @Test
    public void korttiPalauttaaOikeinKunEiKaannetty(){
        assertFalse(kortti.onkoKaannetty());
    }
    
    @Test
    public void KaannaTakaisinToimii(){
        kortti.asetaKaannetyksi();
        kortti.kaannaTakaisin();
        assertFalse(kortti.onkoKaannetty());
        
    }
}
