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

    public int GetTyyppi() {
        return tyyppi;
        
    }

    public void asetaKaannetyksi() {
        onkoKaannetty = true;
        
    }

    public boolean mitenPain() {
        return onkoKaannetty;
        
    }
}
