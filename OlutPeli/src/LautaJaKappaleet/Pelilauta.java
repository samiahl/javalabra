/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LautaJaKappaleet;

import LautaJaKappaleet.Kortti;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author samiahl
 */
public class Pelilauta {

    /**
     * pelilauta matriisina
     */
    private Kortti[][] taulu;
    /**
     * korttien arvot arraylistissa
     */
    private ArrayList<Kortti> arvot;
    /**
     * korttien määrä
     */
    private int korttienMaara;
    private int koko;

    /**
     * luo pelilauta-olion, uuden arraylistin ja laskee korttien määrän
     * pelilaudan koon mukaan.
     */
    public Pelilauta() {
        this.taulu = new Kortti[koko][koko];
        this.arvot = new ArrayList<>();
        this.korttienMaara = koko * koko;
    }

    /**
     * Jakaa korttien määrän kahdella ja lisää jokaisen arvon kaksi kertaa
     * listaan. Lopuksi shufflella sekoittaa arvojen järjestyksen
     * sattumanvaraiseksi.
     */
    public void arvotListaan(int korttienmaara) {
        for (int i = 0; i < korttienmaara / 2; i++) {
            arvot.add(new Kortti(i));
            arvot.add(new Kortti(i));
        }
        Collections.shuffle(arvot);
    }

    /**
     * Lisää luodun listan arvoja matriisiin. Pointteri etenee jokaisella
     * iteraatiolla listalla eteenpäin, kun arvo on ensin lisätty taulukkoon.
     */
    public void listaTaulukkoon() {
        int listanPointteri = 0;
        // arvotListaan();
        for (int i = 0; i < taulu.length; i++) {
            for (int j = 0; j < taulu.length; j++) {
                if (onkoRuutuTyhja(i, j)) {
                    taulu[i][j] = arvot.get(listanPointteri);
                    listanPointteri++;
                }
            }
        }
    }

    /**
     * tarkistaa onko taulun tietty ruutu tyhjänä.
     *
     * @param x kertoo koordinaatin x
     * @param y kertoo koordinaatin y
     * @return palauttaa totuusarvon
     */
    public boolean onkoRuutuTyhja(int x, int y) {
        if (taulu[x][y] == null) {
            return true;
        }
        return false;
    }

    /**
     * tulostaa laudan, jotta näkee, että taulukon ja listan luonti toimii.
     */
    public void tulostaLauta() {
        for (int i = 0; i < taulu.length; i++) {
            for (int j = 0; j < taulu[0].length; j++) {
                if (taulu[i][j].getArvo() < 10) {
                    System.out.print("0" + taulu[i][j].getArvo() + "|");
                } else {
                    System.out.print(taulu[i][j].getArvo() + "|");
                }
            }
            System.out.println("");
        }
    }

    /**
     * palauttaa arvolistan koon.
     *
     * @return
     */
    public int getArvojenMaara() {
        return arvot.size();
    }

    /**
     * palauttaa arvolistan kokonaisuudessaan.
     *
     * @return
     */
    public ArrayList getListanArvot() {
        return arvot;
    }

    /**
     *
     * @param kortinJarjnro
     * @return
     */
    public String getKorttiMerkkijonona(int kortinJarjnro) {
        return Integer.toString(arvot.get(kortinJarjnro).getArvo());
        
    }

    
}
