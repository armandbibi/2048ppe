/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048ppe;

/**
 *
 * @author Armand
 */
public class tile {
    int valeur,ligne,colonne;
    boolean doudou  ;
    
    
    public tile(int valeur,int ligne,int colonne){
        this.valeur = valeur;
        this.ligne = ligne;
        this.colonne = colonne;
        this.doudou = false;
    }
    
    
    public void setvaleur(int x){
        this.valeur = x;
    }
    public void setcolonne(int y){
        this.colonne = y;
    }
     public void setligne(int x){
        this.ligne = x;
    }
     public void setdoudou(boolean x){
         this.doudou = x;
     }
     
    public int getvaleur(){
        return this.valeur;
    }
     public int getligne(){
        return this.ligne;
    }
     public int getcolonne(){
        return this.colonne;
    }
    public boolean getdoudou(){
        return this.doudou;
    }
    
}
