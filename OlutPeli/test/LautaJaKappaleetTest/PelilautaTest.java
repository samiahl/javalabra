package LautaJaKappaleetTest;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import LautaJaKappaleet.Pelilauta;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * testaa pelilaudan toimintoja
 * 
 * @author samiahl
 */
public class PelilautaTest {

    Pelilauta lauta;

    @Before
    public void setUp() {
        lauta = new Pelilauta();

    }

    @Test
    public void palauttaaArvojenMaaranOikein() {
        lauta.arvotListaan(16);
        assertEquals(lauta.getArvojenMaara(), 16);
    }

    @Test
    public void listaSekoittaaItsensa() {
        lauta.arvotListaan(36);
    }

    @Test
    public void JokaistaKorttiaVainYksi() {
        lauta.arvotListaan(16);
        assertEquals(16, lauta.getArvojenMaara());
    }

    @Test
    public void kortinArvoPalautetaanOikeanaLukuna() {
        ArrayList<Integer> eriArvot = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            eriArvot.add(i);
        }
        lauta.asetaKorteilleArvot(eriArvot);
        assertEquals(lauta.getKortinArvo(5), 6);

    }

    @Test
    public void kortinArvoPalautetaanOikeanaArvoMerkkijonona() {
        ArrayList<Integer> eriArvot = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            eriArvot.add(i);
        }
        lauta.asetaKorteilleArvot(eriArvot);
        assertEquals(lauta.getKorttiMerkkijonona(1), "2");
    }
    
    
}