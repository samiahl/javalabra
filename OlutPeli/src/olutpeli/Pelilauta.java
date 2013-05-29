/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author samiahl
 */
public class Pelilauta {

    private Kortti[][] taulu;
    private ArrayList<Kortti> arvot;
    private int korttienMaara;
//    public static final int HELPPO = 2;
//    public static final int NORMAALI = 4;
//    public static final int VAIKEA = 6;

    /**
     * koko tulee olemaan joko HELPPO(2x2), NORMAALI(4x4) tai VAIKEA(6x6)
     *
     * @param
     */
    public Pelilauta(int koko) {
        this.taulu = new Kortti[koko][koko];
        this.arvot = new ArrayList<>();
        this.korttienMaara = koko * koko;
    }

    public void arvotListaan() {
        for (int i = 0; i < korttienMaara / 2; i++) {
            arvot.add(new Kortti(i));
            arvot.add(new Kortti(i));
        }
        Collections.shuffle(arvot);
    }

    public void listaTaulukkoon() {
        int listanPointteri = 0;
        arvotListaan();
        for (int i = 0; i < taulu.length; i++) {
            for (int j = 0; j < taulu.length; j++) {
                if (onkoRuutuTyhja(i, j)) {
                    taulu[i][j] = arvot.get(listanPointteri);
                    listanPointteri++;
                }


            }
        }
    }

    public boolean onkoRuutuTyhja(int x, int y) {
        if (taulu[x][y] == null) {
            return true;
        }
        return false;
    }

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
    
    public int palautaArvojenMaara(){
        return arvot.size();
    }
}
