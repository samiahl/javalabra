/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

/**
 * Luokka, joka luo pelaajan ja ohjailee pelaajan arvoja.
 * 
 * @author samiahl
 */
public class Pelaaja {
    /**
     * Pelaajan haluama nimi top-listoihin.
     */
    private String kayttajatunnus;
    /**
     * Löydettyjen parien lukumäärä. 
     */
    private int loydetytParit;
    /**
     * Yritysten lukumäärä, joka tulee top-listoihin.
     */
    private int yritystenMaara;

    /**
     * Konstruktori, joka antaa pelaajalle alkuarvot.
     */
    public Pelaaja() {
        this.kayttajatunnus = "";
        this.loydetytParit = 0;
        this.yritystenMaara = 0;


    }
    /**
     * Kasvattaa löydettyjen parien määrää yhdellä.
     */
    public void loydettyjenParienMaaraKasvaa() {
        loydetytParit++;
    }
    /**
     * Kasvattaa löydettyjen yritysten määrää yhdellä.
     */
    public void yritystenMaaraKasvaa() {
        yritystenMaara++;
    }
    /**
     * Palauttaa pelaajan antaman tunnuksen.
     */
    public String getTunnus(){
        return kayttajatunnus;
    }
    /**
     * Palauttaa pelaajan suorittamien yritysten määrän.
     */
    public int getYritystenMaara(){
        return yritystenMaara;
    }
    /**
     * Palauttaa pelaajan tähänastisten löydettyjen parien määrän.
     */
    public int getloydetytParit(){
        return loydetytParit;
    }
    /**
     * Nollaa löydettyjen parien määrän, esim silloin, 
     * kun pelaaja arvaa väärin tai peli päättyy.
     * 
     */
    public void nollaaPariLaskuri(){
        loydetytParit = 0;
    }
    /**
     * Nollaa pelaajan yritysten määrän pelin loputtua.
     */
    public void nollaaYritysLaskuri(){
        yritystenMaara = 0;
    }
    /**
     * Asettaa pelaajan antaman nimen Pelaaja-oliolle.
     * @param nimi 
     */
    public void asetaPelaajalleNimi(String nimi){
        kayttajatunnus = nimi;
    }
    
}
