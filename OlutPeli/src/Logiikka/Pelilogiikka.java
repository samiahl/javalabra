/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import LautaJaKappaleet.Pelaaja;
import LautaJaKappaleet.Pelilauta;

/**
 *Luokka, jossa on kortin kääntämisen toiminnot
 * 
 * @author samiahl
 */
public class Pelilogiikka {
    /**
     * kertoo onko kortti ensimmäinen vai toinen nostovuorossa oleva kortti.
     */
    private boolean ensimmainenNostettu;
    /**
     * vuoron ensimmäinen nostettu kortti.
     */
    private int ekaKortti;
    /**
     * vuoron toinen nostettu kortti.
     */
    private int tokaKortti;
    /**
     * pelaajaa ilmentävä pelaaja-olio, joka sisältää pelaajan tunnuksen sekä
     * yritysten ja löydettyjen parien määrän.
     */
    private Pelaaja pelaaja;
    /**
     * Pelilauta, sisältää kortti-olioita, joita pelaaja kääntää.
     */
    private Pelilauta lauta;
    /**
     * kertoo, että on yksi vai kaksi korttia käännettynä.
     */
    private boolean kaksiKorttiaKaannettyna;

    /**
     * alustaa muuttujille alkuarvot.
     */
    
    public Pelilogiikka() {
        pelaaja = new Pelaaja();
        ensimmainenNostettu = true;
        lauta = new Pelilauta();
        ekaKortti = -1;
        kaksiKorttiaKaannettyna = false;

    }

    /**
     * Kääntämisen suorittava metodi. Tarkistaa onko kortti ensimmäinen 
     * vai toinen kääntövuorossa oleva kortti. Tarkistaa myös, että onko kortti
     * jo käännettynä. 
     * Jos kortti on ensimmäinen käännettävä, sen järjestys taulussa talletetaan.
     * 
     * @param moneskoKortti kertoo monesko käännetty kortti on.
     * @return kommentti kertoo mitä on tapahtuu missäkin vaiheessa.
     */
    public int kaanna(int moneskoKortti) {
        if (ensimmainenNostettu) {
            ekaKortti = moneskoKortti;
            ensimmainenNostettu = false;
            return 1;//ensimmäinen nosto
        }else{
            if (moneskoKortti == ekaKortti){
                return 2; //sama kortti
            }else{
                kaksiKorttiaKaannettyna = true;
                ensimmainenNostettu = true;
                tokaKortti = moneskoKortti;
                return kaannaToinen(pelaaja, moneskoKortti);
            }
        }
    }
    /**
     * Lisää pelaajan yritysten ja parien määrää(jos löytyy kaksi samaa).
     * 
     * 
     * @param pelaaja Pelaamassa oleva pelaaja
     * @param moneskoKortti kertoo monesko kortti on kortti on taulussa.
     * @return kommentti kertoo mitä tapahtuu missäkin vaiheessa.
     * 
     */
    
    private int kaannaToinen(Pelaaja pelaaja, int moneskoKortti) {
        pelaaja.yritystenMaaraKasvaa();
        asetaKaksiKorttiaTakaisinFalseksi();
        if(tarkistaOnkoNostetutKortitPari(ekaKortti, tokaKortti)){
            pelaaja.loydettyjenParienMaaraKasvaa();
            return 3;//löysit parin
        }else{
            return 4;// ei ollut pari
        }
    }
    /**
     * tarkistaa ovatko nostetut kaksi korttia pari.
     * @param eka ensimmäinen nostettu
     * @param toka toinen nostettu
     * @return tosi tai epätosi
     */

    public boolean tarkistaOnkoNostetutKortitPari(int eka, int toka) {
        if (lauta.getListanArvot().get(eka).equals(lauta.getListanArvot().get(toka))) {
            return true;
        }
        return false;
    }

    /**
     * asettaa todeksi, jotta tiedetään kahden kortin olevan jo käännettynä 
     * meneillään olevalla vuorolla.
     */
    public void asetaKaksiKorttiaKaannetyksi() {
        kaksiKorttiaKaannettyna = true;
    }
    /**
     * asettaa takasin epätodeksi, kun pelaaja lopettaa kääntövuoron.
     */
    public void asetaKaksiKorttiaTakaisinFalseksi(){
        kaksiKorttiaKaannettyna = false;
    /**
     * palauttaa tiedon, että onko yksi vai kaksi korttia käännettynä.
     */    
    }    
    public boolean getKaksiKorttiaKaannettyna() {
        return kaksiKorttiaKaannettyna;
    }
    /**
     * palauttaa ensimmäisen nostetun kortin.
     */
    public int getEkaKortti() {
        return ekaKortti;
    }
    /**
     * palauttaa toisen nostetun kortin.
     */
    public int getTokaKortti() {
        return tokaKortti;
    }
    /**
     * palauttaa pelaaja-olion.
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }
    
    public Pelilauta getPelilauta(){
        return lauta;
    }
    
    
}
