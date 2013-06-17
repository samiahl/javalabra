/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KayttisTest;

import Kayttis.Aika;
import Kayttis.GUI;
import org.junit.Test;


/**
 * Testaa ajastimen luonnin
 * @author samiahl
 */
public class AikaTest {

    Aika timer;
    GUI kayttis;
    
    @Test
    public void luoAjastimen(){
        timer = new Aika(kayttis, 500);
    }
    
    
}

