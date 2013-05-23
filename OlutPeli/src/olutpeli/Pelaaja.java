/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

/**
 *
 * @author samiahl
 */
public class Pelaaja {

    private String pelaajanNimi;
    private int loydetytParit;
    private int yritystenMaara;

    public Pelaaja(String nimi) {
        
        this.pelaajanNimi = nimi;
        this.loydetytParit = 0;
        this.yritystenMaara = 0;


    }

    public void loydettyjenParienMaaraKasvaa() {
        loydetytParit++;
    }

    public void yritystenMaaraKasvaa() {
        yritystenMaara++;
    }
    
    public String getNimi(){
        return pelaajanNimi;
    }
    
    public int getYritystenMaara(){
        return yritystenMaara;
    }
    
    public int getloydetytParit(){
        return loydetytParit;
    }
}
