/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048ppe;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

/**
 *
 * @author Armand
 */
import java.awt.*;
import javax.swing.*;

import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import javax.swing.border.Border;


public class jeu extends JFrame implements KeyListener, Runnable {

    private plateau plateau;

    JFrame frame;
    public long debut;
    public long fin;
    public boolean set;
    public int colonnes = 4;
    public int lignes = 4;
    private JPanel panneau;

    public jeu() {
        frame = new JFrame();
        setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        panneau = new JPanel();
        frame.setContentPane(panneau);
        // ajout du plateau au jeu 
        plateau = new plateau(colonnes, lignes);
        plateau.debut();
        affichergrille();
        frame.setVisible(true);
        update();
        

    }

    public void update() {
        
            
        
        panneau = new JPanel();
        this.plateau.affichegrille();
        panneau.setLayout(new GridLayout(colonnes, lignes));
        this.affichergrille();
        frame.setContentPane(panneau);
        panneau.revalidate();
        panneau.repaint();
        panneau.setFocusable(true);
        panneau.requestFocusInWindow();
        panneau.addKeyListener(this);
       if(plateau.checkloose()){System.out.println("perdu");}
    }

    public void affichergrille() {

        for (int i = 0; i < colonnes; i++) {
            for (int j = 0; j < lignes; j++) {
                
                String value();
                if(plateau.tab[i][j].getvaleur()==0){
                    value = " ";
                }
                else{
                   value =  Integer.toString(plateau.tab[i][j].getvaleur());
                }
               
                JLabel label = new JLabel(value,SwingConstants.CENTER);
                 Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);

               label.setBorder(border);
                 label.setFont(new Font("Courier New", Font.ITALIC, 25));
                panneau.add(label);
            }
        }
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        int k = e.getKeyCode();
        plateau.update(k);
        update();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        System.out.println("yolo"); //To change body of generated methods, choose Tools | Templates.
    }

}
