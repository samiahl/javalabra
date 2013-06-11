/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttis;

import Logiikka.*;
import LautaJaKappaleet.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Luokka hoitaa pelilaudan kokoamisen ja reagoi pelaajan valintoihin
 * pelilaudalla.
 * 
* @author samiahl
 */
public final class GUI extends JPanel implements ActionListener {

    private JFrame lauta;
    private JLabel yritykset;
    private JLabel loydetyt;
    private JLabel pelaajanNimi;
    private JButton[] kortit;
    private JButton lopetusPainike;
    private JButton uusipeliPainike;
    private Panel paneeli;
    private int korttiParienMaara;
    private Pelilogiikka peli;
    private String kaannetytKortit;

    
    public GUI() {
        peli = new Pelilogiikka();
        aloitaPeli();
        


    }

    public void aloitaPeli() {
        kysyPelaajanNimi();
        kysyParienMaara();
        lauta = new JFrame();
        lauta.setSize(500, 600);
        lauta.setTitle("Olutmuistipeli<3");
        lauta.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        teeKortit();
        teeNimiJaLaskurit();
        teePainikkeet();
        laitaKortitLaudalle();
        laitaPainikkeetLaudalle();
        laitaNimiJaLaskuritLaudalle();
        lauta.setVisible(true);
        pelinPaatos();

    }

    /**
     * kysyy pelaajalta nimen asetusikkunan avulla.
     */
    private void kysyPelaajanNimi() {
        peli.getPelaaja().asetaNimi(Asetusikkuna.kysyNimi("Syötä nimesi: "));

    }

    /**
     * Kysyy parien määrän laudalle.
     */
    private void kysyParienMaara() {
        int parienMaara = Asetusikkuna.kysyTaso("Valitse joko 2, 8 tai 18 paria.");
        while (!(parienMaara == 2
                || parienMaara == 8
                || parienMaara == 18)) {
            parienMaara = Asetusikkuna.kysyTaso("Valitse joko 2, 8 tai 18 paria.");
        }
        asetaKorttienMaara(parienMaara);
        korttiParienMaara = parienMaara;
    }

    /**
     * tekee oikean määrän kortteja.
     *
     * @param korttiParienMaara
     */
    public void asetaKorttienMaara(int parienMaara) {
        kortit = new JButton[2 * parienMaara];

    }

    /**
     * tekee kortit.
     */
    private void teeKortit() {
        for (int i = 0; i < kortit.length; i++) {
            kortit[i] = new JButton("Öl");
            kortit[i].addActionListener(this);
        }
        peli.getPelilauta().arvotListaan(kortit.length);
    }

    /**
     * tekee lopetus -ja uusipeli-painikkeet.
     */
    private void teePainikkeet() {
        lopetusPainike = new JButton("Lopeta");
        lopetusPainike.addActionListener(this);
        uusipeliPainike = new JButton("Aloita uusi");
        uusipeliPainike.addActionListener(this);

    }

    /**
     * tekee laskuri -ja nimiOtsikot .
     */
    private void teeNimiJaLaskurit() {
        loydetyt = new JLabel("Löydetyt: ");
        yritykset = new JLabel("Yritykset: ");
        pelaajanNimi = new JLabel("Nimi: " + peli.getPelaaja().getNimi());
    }

    /**
     * laittaa kortit laudalle.
     */
    private void laitaKortitLaudalle() {
        paneeli = new Panel();
        if (kortit.length == 4) {
            paneeli.setLayout(new GridLayout(2, (kortit.length) / 2));
        } else if (kortit.length == 16) {
            paneeli.setLayout(new GridLayout(4, (kortit.length) / 4));
        } else {
            paneeli.setLayout(new GridLayout(6, (kortit.length) / 6));
        }
        for (int i = 0; i < kortit.length; i++) {
            paneeli.add(kortit[i]);
        }
        lauta.add(paneeli);
    }

    /**
     * laittaa tehdyt painikkeet laudalle.
     *
     */
    private void laitaPainikkeetLaudalle() {
        Panel painikePaneeli = new Panel();
        painikePaneeli.setLayout(new GridLayout(1, 2));
        painikePaneeli.add(lopetusPainike);
        painikePaneeli.add(uusipeliPainike);
        lauta.add(painikePaneeli, BorderLayout.SOUTH);
    }

    /**
     * Laittaa tehdyt laskurit sekä nimen laudan yläosaan.
     */
    private void laitaNimiJaLaskuritLaudalle() {
        Panel nimiJalaskuriPaneeli = new Panel();
        nimiJalaskuriPaneeli.setLayout(new GridLayout(1, 3));
        nimiJalaskuriPaneeli.add(pelaajanNimi);
        nimiJalaskuriPaneeli.add(loydetyt);
        nimiJalaskuriPaneeli.add(yritykset);
        lauta.add(nimiJalaskuriPaneeli, BorderLayout.NORTH);
    }

    /**
     *
     * @param ensimmainen
     * @param toinen
     */
    public void kaannaKaannetytTakaisin(int ensimmainen, int toinen) {
        kortit[ensimmainen].setText("Öl");
        kortit[toinen].setText("Öl");
        peli.asetaOnkoKaksiKaannettyna(false);
    }

    /**
     *
     */
    public void tulostenTarkastus() {
        loydetyt.setText("Löydetyt: " + peli.getPelaaja().getloydetytParit());
        yritykset.setText("Yritykset: " + peli.getPelaaja().getYritystenMaara());

    }

    /**
     *
     */
    public void nollaa() {
        peli.getPelaaja().nollaaPariLaskuri();
        peli.getPelaaja().nollaaYritysLaskuri();
        tulostenTarkastus();
    }

    /**
     *
     * @param ensimmainen
     * @param toinen
     */
    private void lukitseKortit(int ensimmainen, int toinen) {
        kortit[ensimmainen].setVisible(true);
        kortit[toinen].setVisible(true);
        korttiParienMaara--;
        peli.asetaOnkoKaksiKaannettyna(false);
    }

    /**
     *
     */
    public void pelinPaatos() {
        if (peli.getPelaaja().getloydetytParit() == korttiParienMaara) {
            lauta.setTitle("Läpäisit pelin " + peli.getPelaaja().getYritystenMaara()
                    + " yrityksellä.");
        }
    }

    /**
     *
     */
    private void uusiPeli() {
        aloitaPeli();
        kysyParienMaara();
        teeKortit();
        nollaa();
        lauta.remove(paneeli);
        laitaKortitLaudalle();
        lauta.setVisible(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (peli.getKaksiKorttiaKaannettyna()==false) {
            for (int i = 0; i < kortit.length; i++) {
                if (kortit[i] == e.getSource()) {
                    kortit[i].setText(peli.getPelilauta().getKorttiMerkkijonona(i));
                    kaannetytKortit = peli.kaanna(i);
                    if (kaannetytKortit.equals("Ei ollut pari")) {
                        kaannaKaannetytTakaisin(peli.getEkaKortti(), peli.getTokaKortti());
                        
//                    } else if (kaannetytKortit.equals("Löysit parin")) {
//                        lukitseKortit(peli.getEkaKortti(), peli.getTokaKortti());
                    }
                    
                }

            }

        }

        if (e.getSource() == lopetusPainike) {
            System.exit(0);
        }

        if (e.getSource() == uusipeliPainike) {
            uusiPeli();
        }
    }
}
