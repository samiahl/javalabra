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

    public Pelilogiikka() {


        this.ensimmainenNostettu = false;
        this.toinenNostettu = false;


    }

    public void aloitaPeli(int koko, String nimi) {
        Pelilauta lauta = new Pelilauta(koko);
        Pelaaja uusiPelaaja = new Pelaaja(nimi);
        //tee käyttöliittymän käynnistys!!!
        
    }

    public Kortti nostaEnsimmainenKortti() {
        return null;
    }

    public Kortti NostaToinenKortti() {
        return null;

    }

    public boolean tarkistaOnkoNostetutKortitPari() {
        if (!ensimmainenNostettu == toinenNostettu) {
            return false;
        }
        return true;
    }

    
    
}
