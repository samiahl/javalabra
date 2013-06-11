/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import LautaJaKappaleet.Pelaaja;
import LautaJaKappaleet.Pelilauta;

/**
 * Luokka, jossa on kortin kääntämisen toiminnot
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
     * Kääntämisen suorittava metodi. Tarkistaa onko kortti ensimmäinen vai
     * toinen kääntövuorossa oleva kortti. Tarkistaa myös, että onko kortti jo
     * käännettynä. Jos kortti on ensimmäinen käännettävä, sen järjestys
     * taulussa talletetaan.
     *
     * @param moneskoKortti kertoo monesko käännetty kortti on.
     * @return kommentti kertoo mitä on tapahtuu missäkin vaiheessa.
     */
    public String kaanto(int moneskoKortti) {
        if (ensimmainenNostettu == true) {
            ekaKortti = moneskoKortti;
            ensimmainenNostettu = false;
            return "Ensimmäinen nosto";
        } else {
            if (moneskoKortti == ekaKortti) {
                return "Sama kortti";
            } else {
                kaksiKorttiaKaannettyna = true;
                ensimmainenNostettu = true;
                tokaKortti = moneskoKortti;
                return toinenKaanto(moneskoKortti);
            }
        }
    }

    /**
     * Lisää pelaajan yritysten ja parien määrää(jos löytyy kaksi samaa).
     *
     * @param pelaaja Pelaamassa oleva pelaaja
     * @param moneskoKortti kertoo monesko kortti on taulussa.
     * @return kommentti kertoo mitä tapahtuu missäkin vaiheessa.
     *
     */
    private String toinenKaanto(int moneskoKortti) {
        pelaaja.yritystenMaaraKasvaa();
        if (tarkistaOnkoNostetutKortitPari(ekaKortti, moneskoKortti)) {
            pelaaja.loydettyjenParienMaaraKasvaa();
            return "Löysit parin";
        } else {
            return "Ei ollut pari";
        }
    }

    /**
     * tarkistaa ovatko nostetut kaksi korttia pari.
     *
     * @param eka ensimmäinen nostettu
     * @param toka toinen nostettu
     * @return tosi tai epätosi
     */
    public boolean tarkistaOnkoNostetutKortitPari(int eka, int toka) {
        if ((lauta.getListanArvot().get(eka)).equals(lauta.getListanArvot().get(toka))) {
            return true;
        }
        return false;
    }

    /**
     * asettaa todeksi, jotta tiedetään kahden kortin olevan jo käännettynä
     * meneillään olevalla vuorolla.
     */
    public void asetaOnkoKaksiKaannettyna(boolean onkoKaksiKaannettyna) {
        kaksiKorttiaKaannettyna = onkoKaksiKaannettyna;
    }

    /**
     * palauttaa tiedon, että onko yksi vai kaksi korttia käännettynä.
     */
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

    public Pelilauta getPelilauta() {
        return lauta;
    }

    
    
    //ALTERNATIVE KÄÄNTÖ
    
    
    public boolean kaantoo(int moneskoKortti) {
        if (ensimmainenNostettu == true) {
            ekaKortti = moneskoKortti;
            ensimmainenNostettu = false;
            return true;
        }
        return false;
    }
    
    public boolean toinenKaantoo(int moneskoKortti){
        if (ensimmainenNostettu == false){
            tokaKortti = moneskoKortti;
            ensimmainenNostettu = true;
            return true;
        }
        return false;
    }
    
    
    
    
}
//public String kaanto(int moneskoKortti) {
//        if (ensimmainenNostettu == true) {
//            ekaKortti = moneskoKortti;
//            ensimmainenNostettu = false;
//            return "Ensimmäinen nosto";
//        } else {
//            if (moneskoKortti == ekaKortti) {
//                return "Sama kortti";
//            } else {
//                kaksiKorttiaKaannettyna = true;
//                ensimmainenNostettu = true;
//                tokaKortti = moneskoKortti;
//                return toinenKaanto(moneskoKortti);
//            }
//        }
//    }

