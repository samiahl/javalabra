/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import LautaJaKappaleet.Pelaaja;
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
public class PelaajaTest {
    
    Pelaaja pelaaja;

    @Before
    public void setUp() {
        pelaaja = new Pelaaja();
    }

    @Test
    public void pelaajallaTyhjäNimi(){
        assertEquals(pelaaja.getNimi(),"");
    }
    
    @Test
    public void nimenAsettaminenToimii(){
        pelaaja.asetaNimi("sami");
        assertEquals("sami", pelaaja.getNimi());
    }
    
    @Test
    public void alussaLoydetytNolla(){
        assertEquals(pelaaja.getloydetytParit(),0);
    }
    
    @Test
    public void alussaYrityksetNolla(){
        assertEquals(pelaaja.getYritystenMaara(),0);
    }
    
    @Test
    public void loydettyjenMaaraKasvaa(){
        pelaaja.loydettyjenParienMaaraKasvaa();
        assertEquals(pelaaja.getloydetytParit(),1);
    }
    @Test
    public void yritystenMaaraKasvaa(){
        pelaaja.yritystenMaaraKasvaa();
        assertEquals(pelaaja.getYritystenMaara(),1);
    }
    @Test
    public void yritystenNollausToimii(){
        pelaaja.yritystenMaaraKasvaa();
        pelaaja.nollaaYritysLaskuri();
        assertEquals(pelaaja.getYritystenMaara(),0);
    }
    @Test
    public void loydettyjenNollausToimii(){
        pelaaja.loydettyjenParienMaaraKasvaa();
        pelaaja.nollaaPariLaskuri();
        assertEquals(pelaaja.getloydetytParit(),0);
    }
    
}