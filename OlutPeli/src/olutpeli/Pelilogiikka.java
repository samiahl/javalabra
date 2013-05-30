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
    private int ekaKortti;
    private int tokaKortti;
    private Pelaaja pelaaja;
    private Pelilauta lauta;
    private boolean kaksiKorttiaKaannettyna;

    public Pelilogiikka() {

        pelaaja = new Pelaaja();
        ensimmainenNostettu = true;
        lauta = new Pelilauta(4);
        ekaKortti = -1;
        kaksiKorttiaKaannettyna = false;

    }

    /**
     *
     * @param kortti
     * @return
     */
    public String kaanna(int kortti) {
        if (ensimmainenNostettu) {
            ekaKortti = kortti;
            ensimmainenNostettu = false;
            return "ensimmäinen nosto";
        }else{
            if (kortti == ekaKortti){
                return "sama kortti";
            }else{
                kaksiKorttiaKaannettyna = true;
                ensimmainenNostettu = true;
                tokaKortti = kortti;
                return kaannaToinen(pelaaja, kortti);
            }
        }
    }
    
    private String kaannaToinen(Pelaaja pelaaja, int kortti) {
        pelaaja.yritystenMaaraKasvaa();
        if(tarkistaOnkoNostetutKortitPari(ekaKortti, tokaKortti)){
            pelaaja.loydettyjenParienMaaraKasvaa();
            return "löysit parin";
        }else{
            return "ei ollut pari";
        }
    }

    public boolean tarkistaOnkoNostetutKortitPari(int eka, int toka) {
        if (lauta.getListanArvot().get(eka).equals(lauta.getListanArvot().get(toka))) {
            return true;
        }
        return false;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void asetaKaksiKorttiaKaannetyksi() {
        kaksiKorttiaKaannettyna = true;
    }

    public boolean getKaksiKorttiaKaannettyna() {
        return kaksiKorttiaKaannettyna;
    }

    public int getEkaKortti() {
        return ekaKortti;
    }

    public int getTokaKortti() {
        return tokaKortti;
    }

    
}
