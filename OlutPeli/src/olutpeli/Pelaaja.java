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

    private String kayttajatunnus;
    private int loydetytParit;
    private int yritystenMaara;

    public Pelaaja(String nimi) {
        
        this.kayttajatunnus = nimi;
        this.loydetytParit = 0;
        this.yritystenMaara = 0;


    }

    public void loydettyjenParienMaaraKasvaa() {
        loydetytParit++;
    }

    public void yritystenMaaraKasvaa() {
        yritystenMaara++;
    }
    
    public String getTunnus(){
        return kayttajatunnus;
    }
    
    public int getYritystenMaara(){
        return yritystenMaara;
    }
    
    public int getloydetytParit(){
        return loydetytParit;
    }

    @Override
    public String toString() {
        return kayttajatunnus + ", loydetytParit= " + loydetytParit + ", yritystenMaara= " + yritystenMaara;
    }
    
    
}
