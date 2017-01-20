/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048ppe;

import java.util.Random;

/**
 *
 * @author Armand
 */
public class plateau {

    tile[][] tab;

    int colonnes = 4;
    int lignes = 4;
    int casedebut = 2;
    int winningScore=1024;

    public plateau() {
        this.tab = new tile[colonnes][lignes];
    }

    public plateau(int colonnes, int lignes) {
        this.tab = new tile[colonnes][lignes];
    }

    public void debut() {
        remplirgrille();
        for (int i = 0; i < casedebut; i++) {
            randomnombre();

        }

    }

    public void remplirgrille() {
        for (int i = 0; i < colonnes; i++) {
            for (int j = 0; j < lignes; j++) {
                tab[i][j] = new tile(0, i, j);
            }
        }

    }

    public void affichegrille() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (tab[i][j] != null) {
                    {
                        if (tab[i][j].getvaleur() != 0) {
                            System.out.print(tab[i][j].getvaleur());

                        } else {
                            System.out.print("0");
                        }

                    }
                } else {
                    System.out.print("0");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");

    }

    public void update(int k) {

        if (!bougerlescases(k)) {
            randomnombre();

        }
        doudouenplace();

    }

    private void doudouenplace() {
        for (int i = 0; i < colonnes; i++) {
            for (int j = 0; j < lignes; j++) {
                if (tab[i][j].getdoudou()) {
                    tab[i][j].setdoudou(false);
                }
            }
        }
    }

    //permet d'ajouter un nombre random sur une place libre du plateau.
    public void randomnombre() {
        Random random = new Random();
        boolean notvalid = true;

        // evite de faire spawner des case la ou il y a dja des tiles .
        while (notvalid) {
            int position = random.nextInt(lignes * colonnes);
            int ligne = position / lignes;
            int colonne = position % colonnes;

            tile actuelle = tab[ligne][colonne];
            if (actuelle.getvaleur() == 0) {
                int value = random.nextInt(10) < 9 ? 2 : 4;// permet de changer enter 2 et 4 avec 90% chance de 2
                tab[ligne][colonne] = new tile(value, ligne, colonne);
                notvalid = false;

            }
        }
    }

    public boolean bougerlescases(int k) {
        boolean bougercase = false;
        int i = 0;
        if (k == 40) {

            while (!bougercase) {
                bougercase = bas();
                i++;
            }
        }
        if (k == 38) {

            while (!bougercase) {
                bougercase = haut();
                i++;
            }
        }
        if (k == 37) {

            while (!bougercase) {
                bougercase = gauche();
                i++;
            }
        }
        if (k == 39) {

            while (!bougercase) {
                bougercase = droite();
                i++;
            }
        }

        if (i == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean haut() {

        for (int i = 1; i < colonnes; i++) {
            for (int j = 0; j < lignes; j++) {

                if (tab[i][j].getvaleur() != 0) {

                    if (tab[i - 1][j].getvaleur() == 0) {
                        tab[i - 1][j] = new tile(tab[i][j].getvaleur(), i - 1, j);
                        tab[i][j].setvaleur(0);
                        return false;
                    }
                    if (tab[i - 1][j].getvaleur() == tab[i][j].getvaleur() & !tab[i - 1][j].getdoudou() & !tab[i][j].getdoudou()) {
                        checkwin(tab[i][j].getvaleur());

                        tab[i - 1][j] = new tile(tab[i][j].getvaleur() * 2, i - 1, j);
                        tab[i - 1][j].setdoudou(true);
                        tab[i][j].setvaleur(0);
                        return false;
                    }

                }

            }
        }
        return true;
    }

    public boolean bas() {

        for (int i = colonnes - 2; i > -1; i--) {
            for (int j = 0; j < lignes; j++) {

                if (tab[i][j].getvaleur() != 0) {

                    if (tab[i + 1][j].getvaleur() == 0) {
                        tab[i + 1][j] = new tile(tab[i][j].getvaleur(), i + 1, j);
                        tab[i][j].setvaleur(0);
                        return false;
                    }
                    if (tab[i + 1][j].getvaleur() == tab[i][j].getvaleur() & !tab[i + 1][j].getdoudou() & !tab[i][j].getdoudou()) {
                        checkwin(tab[i][j].getvaleur());

                        tab[i + 1][j] = new tile(tab[i][j].getvaleur() * 2, i + 1, j);
                        tab[i + 1][j].setdoudou(true);
                        tab[i][j].setvaleur(0);
                        return false;
                    }

                }

            }

        }
        return true;
    }

    public boolean droite() {

        for (int i = 0; i < lignes; i++) {
            for (int j = colonnes - 2; j > -1; j--) {

                if (tab[i][j].getvaleur() != 0) {

                    if (tab[i][j + 1].getvaleur() == 0) {
                        tab[i][j + 1] = new tile(tab[i][j].getvaleur(), i, j + 1);
                        tab[i][j].setvaleur(0);
                        return false;
                    }
                    if (tab[i][j + 1].getvaleur() == tab[i][j].getvaleur() & !tab[i][j + 1].getdoudou() & !tab[i][j].getdoudou()) {
                        checkwin(tab[i][j].getvaleur());

                        tab[i][j + 1] = new tile(tab[i][j].getvaleur() * 2, i, j + 1);
                        tab[i][j + 1].setdoudou(true);
                        tab[i][j].setvaleur(0);
                        return false;
                    }

                }

            }

        }
        return true;
    }

    public boolean gauche() {

        for (int i = 0; i < lignes; i++) {
            for (int j = 1; j < colonnes; j++) {

                if (tab[i][j].getvaleur() != 0) {

                    if (tab[i][j - 1].getvaleur() == 0) {
                        tab[i][j - 1] = new tile(tab[i][j].getvaleur(), i, j - 1);
                        tab[i][j].setvaleur(0);
                        return false;
                    }
                    if (tab[i][j - 1].getvaleur() == tab[i][j].getvaleur() & !tab[i][j - 1].getdoudou() & !tab[i][j].getdoudou()) {
                        checkwin(tab[i][j].getvaleur());
                        tab[i][j - 1] = new tile(tab[i][j].getvaleur() * 2, i, j + 1);
                        tab[i][j - 1].setdoudou(true);
                        tab[i][j].setvaleur(0);
                        return false;
                    }

                }

            }

        }
        return true;
    }

    public void checkwin(int x) {
        if (x == winningScore) {
            System.out.println("wiiiii");
        }
    }
    public boolean checkloose(){
        
        for (int i = 1; i < colonnes; i++) {
             if (tab[i][0].getvaleur()== tab[i-1][0].getvaleur() || tab[i][0].getvaleur()== 0 ) {
                    return false;
                }
        }
        
        for (int i = 1; i < colonnes; i++) {
             if (tab[0][i].getvaleur()== tab[0][i-1].getvaleur() || tab[0][i].getvaleur()== 0 ) {
                    return false;
                }
        }
        
        
        for (int i = 1; i < colonnes; i++) {
            for (int j = 1; j < lignes; j++) {
                if (tab[i][j].getvaleur()== tab[i-1][j].getvaleur() || tab[i][j].getvaleur()== tab[i][j-1].getvaleur()||tab[i][j].getvaleur()== 0 ) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
