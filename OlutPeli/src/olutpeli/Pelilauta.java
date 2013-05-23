/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author samiahl
 */
public class Pelilauta {

    private Kortti[][] taulu;
    private ArrayList<Kortti> arvot;
    private int korttienMaara;

    public Pelilauta(int koko) {            // koko tulee olemaan joko 2x2, 4x4 tai 6x6
        this.taulu = new Kortti[koko][koko];
        this.arvot = new ArrayList<>();
        this.korttienMaara = koko * koko;
    }

    public void arvotListaan() {
        for (int i = 0; i < korttienMaara / 2; i++) {
            arvot.add(new Kortti (i));
            arvot.add(new Kortti (i));
        }
        Collections.shuffle(arvot);
    }

    public void listaTaulukkoon(){
        int listanPointteri = 0;
        for (int i = 0; i < taulu.length; i++) {
            for (int j = 0; j < taulu.length; j++) {
                taulu[i][j] = arvot.get(listanPointteri);
            }
        }
    }
}
    
  
