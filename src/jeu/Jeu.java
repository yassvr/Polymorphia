
package jeu;

import java.util.Random;
import java.util.Scanner;

import combat.Combat;
import entites.Dragon;
import entites.Joueur;
import entites.Loup;
import entites.Monstre;
import entites.Zombie;
import marchand.Marchand;

public class Jeu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Joueur joueur = new Joueur("Javalt");
        Marchand marchand = new Marchand();

        while (true) {

            if (!joueur.estVivant()) {
                System.out.println("\n❌ Tu es mort. Fin du jeu.");
                break;
            }

            System.out.println("\n===== POLYMORPHIA =====");
            System.out.println("PV: " + joueur.getVie() + " | Intcoins: " + joueur.getIntcoins());
            System.out.println("1) Marchand (acheter)");
            System.out.println("2) Explorer (combat)");
            System.out.println("0) Quitter");
            System.out.print("Choix: ");

            int choix = sc.nextInt();

            if (choix == 1) {
                marchand.vendreObjet(joueur);
            } else if (choix == 2) {

                Monstre monstre;
                int r = rand.nextInt(3);

                if (r == 0) monstre = new Loup();
                else if (r == 1) monstre = new Zombie();
                else monstre = new Dragon();

                Combat.lancer(joueur, monstre);

            } else if (choix == 0) {
                System.out.println("Au revoir.");
                break;
            } else {
                System.out.println("Choix invalide.");
            }
        }

        sc.close();
    }
}
