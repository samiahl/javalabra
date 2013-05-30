/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class PelilautaTest {

    Pelilauta lauta;

    @Before
    public void setUp() {
        lauta = new Pelilauta(4);

    }

    @Test
    public void palauttaaArvojenMaaranOikein(){
        lauta.arvotListaan();
        assertEquals(lauta.getArvojenMaara(),16);
    }
    
    
}
