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

    public Pelaaja() {
        
        this.kayttajatunnus = "";
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
    
    public void nollaaPariLaskuri(){
        loydetytParit = 0;
    }
    public void nollaaYritysLaskuri(){
        yritystenMaara = 0;
    }
    
    public void asetaPelaajalleNimi(String nimi){
        kayttajatunnus = nimi;
    }
    

    @Override
    public String toString() {
        return kayttajatunnus + ", loydetytParit= " + loydetytParit + ", yritystenMaara= " + yritystenMaara;
    }
    
    
}
