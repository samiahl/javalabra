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
    private int loydetytParit;
    private int nostojenMaara;
    
    
    
    public Pelilogiikka(){
        
        
        
        
    }
    public void uudenPelinAloitus(){
        this.loydetytParit = 0;
        this.nostojenMaara = 0;
    }
    
    
    
    public Kortti nostaEnsimmainenKortti(){
        return null;
    }
    
    public Kortti NostaToinenKortti(){
        return null;
        
    }
    
    public void loydettyjenParienMaaraKasvaa(){
        loydetytParit++;
    }
    
    public void nostojenMaaraKasvaa(){
        nostojenMaara++;
    }
    
    
    
}
