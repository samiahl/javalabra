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
    private int tyyppi;
    private boolean onkoKaannetty;

    
    
    public Kortti(int tyyppi) {
        this.onkoKaannetty = false;
        this.tyyppi = tyyppi;

    }
    /**
     * Palauttaa kortin tyypin.
     * 
     */
    
    public int GetTyyppi() {
        return tyyppi;
        
    }
    
    /**
     * Pelaajan valittua tietty kortti, asettaa metodi tämän kortin
     * arvoksi true
     * 
     */
    public void asetaKaannetyksi() {
        onkoKaannetty = true;
        
    }
    /**
     * palauttaa joko true tai false riippuen siitä miten päin kortti on
     * 
     * 
     */
    public boolean mitenPain() {
        return onkoKaannetty;
        
    }
}
