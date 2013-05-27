/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 *
 * @author samiahl
 */
public class OlutPeli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Pelilogiikka logiikka = new Pelilogiikka();
        GUI kayttoliittyma = new GUI();
        
        
        SwingUtilities.invokeLater(kayttoliittyma);


        System.out.println("Juu peliä, juu.. syötä nimi: ");
        String nimi = lukija.nextLine();


        System.out.println("Anna koko: 2, 4 tai 6!!");
        int koko = lukija.nextInt();


        logiikka.aloitaPeli(koko, nimi);





    }
}
