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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard {

    public static boolean[] pressed = new boolean[256];
    public static boolean[] prev = new boolean[256];
    
    
     public static void appuyer(KeyEvent e){
        pressed[e.getKeyCode()] = true ;
    }
    
    public static void relacher(KeyEvent e){
        pressed[e.getKeyCode()] = false;
    }
    
    
    
    
}
