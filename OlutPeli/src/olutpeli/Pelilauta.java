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
    private ArrayList<Integer> arvot;
    

    public Pelilauta(int koko) {            // koko tulee olemaan joko 2x2, 4x4 tai 6x6
        this.taulu = new Kortti[koko][koko];
        this.arvot = new ArrayList<>();
        
    }
    
    public void arvotKorteille(int korttienMaara){
        for (int i = 0; i < korttienMaara/2; i++) {
            arvot.add(i);
            arvot.add(i);
        }
        Collections.shuffle(arvot);
    }
}