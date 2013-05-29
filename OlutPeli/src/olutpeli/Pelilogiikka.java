/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

/**
 *
 * @author samiahl
 */
public class Pelilogiikka {

    private boolean ensimmainenNostettu;
    private boolean toinenNostettu;
    private int ekaKortti;
    private int tokaKortti;


    public Pelilogiikka() {

        this.ensimmainenNostettu = false;
        this.toinenNostettu = false;



    }

    public void aloitaPeli(int koko, String nimi) {
        Pelilauta lauta = new Pelilauta(koko);
        Pelaaja uusiPelaaja = new Pelaaja(nimi);
        lauta.listaTaulukkoon();
        
//        lauta.tulostaLauta();
        //tee käyttöliittymän käynnistys!!!

    }

    public String kaannaEnsimmainenKortti(Kortti kortti) {
        if (kortti.onkoKaannetty() == true) {
            return "on jo käännetty";
        }
        if (ensimmainenNostettu == false) {
            ensimmainenNostettu = true;
            toinenNostettu = false;
            ekaKortti = kortti.getArvo();
            kortti.asetaKaannetyksi();
        }
        return "ensimmäinen kääntö";
    }

    public String kaannaToinenKortti(Kortti kortti, Pelaaja pelaaja) {
        if (kortti.onkoKaannetty() == true) {
            return "on jo käännetty";
        }
        if (ensimmainenNostettu == true && toinenNostettu == false) {
            kortti.asetaKaannetyksi();
            ensimmainenNostettu = false;
            toinenNostettu = true;
            tokaKortti = kortti.getArvo();
            if (tarkistaOnkoNostetutKortitPari() == true) {
                pelaaja.loydettyjenParienMaaraKasvaa();
                pelaaja.yritystenMaaraKasvaa();
            } else {
                pelaaja.yritystenMaaraKasvaa();
                kortti.kaannaTakaisin();
            }
        }
        return "toinen nosto";

    }

    public boolean tarkistaOnkoNostetutKortitPari() {
        if (ekaKortti == tokaKortti) {
            return true;
        }
        return false;
    }

}
