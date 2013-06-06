/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttis;

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
    private JFrame ikkuna;
    private JLabel yritykset;
    private JLabel loydetyt;
    private JLabel tekstikentta;
    private JButton[] kortit;
    private JButton lopetus;
    private JButton uusipeli;
    private Panel korttiPaneeli;
    private int korttienMaaraPelilaudalla;
    private int korttiParienMaara;
    private Vaikeusaste vaikeusaste;
    private Pelilogiikka peli;
    private JLabel pelaajanNimi;
    private int kaannettykortti;

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



    }

    /**
     *
     */
//    public void run() {
//
//        ikkuna = new JFrame("Muistipeli");
//        ikkuna.setPreferredSize(new Dimension(500, 500));
//
//        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        luoKomponentit(ikkuna.getContentPane());
//
//        ikkuna.pack();
//        ikkuna.setVisible(true);
//
//
//    }
//
//    private void luoKomponentit(Container contentPane) {
//    }
//
//    public JFrame getFrame() {
//        return ikkuna;
//
//    }
    // TODO: miten saa käyttiksen kysymään käyttäjän nimen ja pelin tason!!!
    /**
     * kysyy pelaajalta nimen asetusikkunan avulla.
     *
     */
    private void kysyPelaajanNimi() {
        peli.getPelaaja().asetaNimi(Asetusikkuna.kysyNimi("Syötä Nimesi: "));

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
        //while ei päästä läpi!! MIKSI?!?!?!

        asetaKorttienMaara(parienMaara);

    }

    /**
     * tekee oikean määrän kortteja.
     *
     * @param korttiParienMaara
     */
    public void asetaKorttienMaara(int korttiParienMaara) {
        kortit = new JButton[2 * korttiParienMaara];
        korttienMaaraPelilaudalla = kortit.length;
    }

    /**
     * tekee kortit.
     */
    private void teeKortit() {
        for (int i = 0; i < kortit.length; i++) {
            kortit[i] = new JButton("Öl");
            kortit[i].addActionListener(this);

            //TODO:jostain oluiden kuvat!! 
        }
        peli.getPelilauta().arvotListaan(kortit.length);
    }

    /**
     * tekee lopetus -ja uusipeli-painikkeet.
     */
    private void teePainikkeet() {
        lopetus = new JButton("Lopeta");
        lopetus.addActionListener(this);
        uusipeli = new JButton("Aloita uusi");
        uusipeli.addActionListener(this);

    }

    /**
     * tekee laskuri -ja nimiOtsikot .
     */
    private void teeNimiJaLaskurit() {
        loydetyt = new JLabel("Löydetyt: ");
        yritykset = new JLabel("Yritykset: ");
        pelaajanNimi = new JLabel("Nimi: ");
    }

    /**
     * laittaa kortit laudalle.
     */
    private void laitaKortitLaudalle() {
        korttiPaneeli = new Panel();
        if (kortit.length == 4) {
            korttiPaneeli.setLayout(new GridLayout(2, (kortit.length) / 2));
        } else if (kortit.length == 16) {
            korttiPaneeli.setLayout(new GridLayout(4, (kortit.length) / 4));
        } else {
            korttiPaneeli.setLayout(new GridLayout(6, (kortit.length) / 6));
        }
        for (int i = 0; i < kortit.length; i++) {
            korttiPaneeli.add(kortit[i]);
        }
        lauta.add(korttiPaneeli);
    }

    /**
     * laittaa tehdyt painikkeet laudalle.
     *
     */
    private void laitaPainikkeetLaudalle() {
        Panel painikePaneeli = new Panel();
        painikePaneeli.setLayout(new GridLayout(1, 2));
        painikePaneeli.add(lopetus);
        painikePaneeli.add(uusipeli);
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
    
    private void kaannaKaannetytTakaisin(){
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lopetus) {
            System.exit(0);
        }
        if (e.getSource() == uusipeli) {
            peli.getPelaaja().nollaaPariLaskuri();
            peli.getPelaaja().nollaaYritysLaskuri();
            aloitaPeli();
        }
        if (!peli.getKaksiKorttiaKaannettyna()) {
            for (int i = 0; i < kortit.length; i++) {
                if (kortit[i] == e.getSource()) {
                    kortit[i].setText(peli.getPelilauta().getKorttiMerkkijonona(i));
                    kaannettykortti = peli.kaanna(i);
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        new GUI();


    }
}