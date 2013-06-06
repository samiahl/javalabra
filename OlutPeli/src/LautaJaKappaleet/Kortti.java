/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LautaJaKappaleet;

/**
 *
 * @author samiahl
 */
public class Kortti {

    private int arvo;

    
    private boolean onkoKaannetty;
//    private boolean ensimmäinenKortti;

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
     * Pelaajan valittua tietty kortti, asettaa metodi tämän kortin arvoksi true
     *
     */
    public void asetaKaannetyksi() {
        onkoKaannetty = true;
    }
    
    /**
     * kääntää käännetyn kortin takaisin.
     */
    
    public void kaannaTakaisin() {
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
    @Override
    public String toString() {
        return "" +arvo;
    }
}
