/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author samiahl
 */
public class GUI implements Runnable {

    private JFrame frame;

    public GUI() {
    }

    @Override
    public void run() {

        frame = new JFrame("Muistipeli");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    private void luoKomponentit(Container contentPane) {
    }

    public JFrame getFrame() {
        return frame;

    }
}