/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

/**
 *
 * @author samiahl
 */
public class Kortti {
    private int arvo;
    private boolean onkoKaannetty;

    
    
    public Kortti(int arvo) {
        this.onkoKaannetty = false;
        this.arvo = arvo;

    }
    /**
     * Palauttaa kortin arvon.
     * 
     */
    
    public int getArvo() {
        return arvo;
        
    }
    
    /**
     * Pelaajan valittua tietty kortti, asettaa metodi tämän kortin
     * arvoksi true
     * 
     */
    public void asetaKaannetyksi() {
        onkoKaannetty = true;
        
    }
    
    public void kaannaTakaisin(){
        onkoKaannetty = false;
    }
    /**
     * palauttaa joko true tai false riippuen siitä miten päin kortti on
     * 
     * 
     */
    public boolean onkoKaannetty() {
        return onkoKaannetty;
        
    }
}
