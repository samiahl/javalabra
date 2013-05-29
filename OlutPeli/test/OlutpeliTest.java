/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import olutpeli.Kortti;
import olutpeli.Pelaaja;
import olutpeli.Pelilauta;
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

    private String jokuNimi;

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
    public void korttiPalauttaaOikeanArvon() {
        Kortti kortti = new Kortti(1);

        int vastaus = kortti.getArvo();

        assertEquals("1", vastaus);
    }

    @Test
    public void korttiPalauttaaOikeanTotuusarvon() {
        Kortti kortti = new Kortti(1);
        Kortti kortti2 = new Kortti(1);

        kortti.asetaKaannetyksi();

        boolean vastaus = true;
        boolean vastaus2 = false;

        assertEquals("true", vastaus);
        assertEquals("false", vastaus2);
    }

    @Test
    public void arvotLoytyvatListasta() {
        Pelilauta lauta2 = new Pelilauta(2);
        Pelilauta lauta4 = new Pelilauta(4);
        Pelilauta lauta6 = new Pelilauta(6);

        lauta2.arvotListaan();
        lauta4.arvotListaan();
        lauta6.arvotListaan();

        int vastaus2 = lauta2.palautaArvojenMaara();
        int vastaus4 = lauta4.palautaArvojenMaara();
        int vastaus6 = lauta6.palautaArvojenMaara();

        assertEquals("4", vastaus2);
        assertEquals("16", vastaus4);
        assertEquals("32", vastaus6);


    }

    @Test
    public void testaaYritystenSekaLoydettyjenMaaranKasvun() {
        Pelaaja pelaaja = new Pelaaja(jokuNimi);
        String testi = this.jokuNimi;

        pelaaja.loydettyjenParienMaaraKasvaa();

        pelaaja.yritystenMaaraKasvaa();
        pelaaja.yritystenMaaraKasvaa();

        String vastaus = pelaaja.toString();


        assertEquals("testi, loydetytParit= 1, yritystenMaara= 2", vastaus);


    }
    
}
