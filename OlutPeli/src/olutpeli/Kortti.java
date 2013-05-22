/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olutpeli;

/**
 *
 * @author samiahl
 */
public class Kortti {
    private int x;
    private int y;
    private String tyyppi;
    private boolean onkoKaannetty;
    
    public Kortti(int x, int y, String tyyppi){
        this.onkoKaannetty = false;
        this.tyyppi = tyyppi;
        this.x = x;
        this.y = y;
        
    }
    public int GetX(){
        return x;
    }
    
    public int GetY(){
        return y;
    }
    
    public String GetTyyppi(){
        return tyyppi;
    }
    
    public void asetaKaannetyksi(){
        onkoKaannetty = true;
    }
    
    public boolean mitenPain(){
        return onkoKaannetty;
    }        
}
