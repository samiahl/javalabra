/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.util.Scanner;

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
        
        System.out.println("Tervetuloa pelaamaan!");
        System.out.println("Syötä pelilaudalle koko: 2, 4 tai 6: ");
        Pelilauta lauta = new Pelilauta(lukija.nextInt());
        
    }
}
