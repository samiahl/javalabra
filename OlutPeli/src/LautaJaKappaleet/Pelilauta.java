/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LautaJaKappaleet;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author samiahl
 */
public class Pelilauta {

    /**
     * korttien arvot arraylistissa
     */
    private ArrayList<Integer> arvot;

    /**
     * luo pelilauta-olion, uuden arraylistin ja laskee korttien määrän
     * pelilaudan koon mukaan.
     */
    
    public Pelilauta() {
        this.arvot = new ArrayList<>();

    }

    /**
     * Jakaa korttien määrän kahdella ja lisää jokaisen arvon kaksi kertaa
     * listaan. Lopuksi shufflella sekoittaa arvojen järjestyksen
     * sattumanvaraiseksi.
     */
    public void arvotListaan(int korttienmaara) {
        for (int i = 0; i < korttienmaara / 2; i++) {
            arvot.add(i);
            arvot.add(i);
        }
        Collections.shuffle(arvot);
    }

/**
     * Seuraavat metodit ovat kaikki get-metodeita, joten on ehkä hieman 
     * tarpeetonta selvittää niiden toimintoja 
     */
    public int getArvojenMaara() {
        return arvot.size();
    }

    public ArrayList getListanArvot() {
        return arvot;
    }

    public String getKorttiMerkkijonona(int kortinJarjnro) {
        return Integer.toString(arvot.get(kortinJarjnro));

    }

}