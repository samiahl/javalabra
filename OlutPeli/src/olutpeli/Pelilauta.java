/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samiahl
 */
public class Pelilauta {

    private List taulu;

    public Pelilauta() {  // koko tulee olemaan joko 2x2, 4x4 tai 6x6
        this.taulu = new ArrayList<>();
    }

    public void luoPelilauta(int koko) {
        for (int i = 0; i < koko; i++) {
            taulu.add(luoLista());
        }
    }
    
    public ArrayList luoLista() {
        ArrayList<Kortti> rivi = new ArrayList<>();
        return rivi;
    }
}
