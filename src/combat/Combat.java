package combat;

import java.util.Random;
import java.util.Scanner;

import entites.Joueur;
import entites.Monstre;
import objets.Objet;

public class Combat {
	@SuppressWarnings("resource")
    public static void lancer(Joueur joueur, Monstre monstre) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n=== Combat contre " + monstre.getNom() + " ===");
        monstre.crier();

        while (joueur.estVivant() && monstre.estVivant()) {

            System.out.println("\nJoueur PV: " + joueur.getVie() + " | Monstre PV: " + monstre.getVie());
            System.out.println("1) Attaquer");
            System.out.println("2) Utiliser un objet (potion/sort/materia/arme/armure)");
            System.out.print("Choix: ");

            int choix = sc.nextInt();

            if (choix == 1) {
                joueur.attaquer(monstre);
                System.out.println("Tu attaques le monstre !");
            } else if (choix == 2) {

                if (joueur.getInventaire().estVide()) {
                    System.out.println("Inventaire vide.");
                } else {
                    // afficher inventaire
                    for (int i = 0; i < joueur.getInventaire().getObjets().size(); i++) {
                        Objet obj = joueur.getInventaire().getObjets().get(i);
                        System.out.println(i + ") " + obj.getNom());
                    }

                    System.out.print("Choisir un objet: ");
                    int idx = sc.nextInt();

                    if (idx >= 0 && idx < joueur.getInventaire().getObjets().size()) {
                        Objet obj = joueur.getInventaire().getObjets().get(idx);
                        obj.utiliser(joueur);
                        // On retire l'objet après utilisation (simple pour TP)
                        joueur.getInventaire().retirerObjet(obj);
                    } else {
                        System.out.println("Choix invalide.");
                    }
                }

            } else {
                System.out.println("Choix invalide.");
                continue;
            }

            // Tour monstre (si vivant)
            if (monstre.estVivant()) {
                monstre.attaquer(joueur);
                System.out.println(monstre.getNom() + " t'attaque !");
            }
        }

        if (joueur.estVivant()) {
            System.out.println("\n✅ Victoire ! Tu gagnes " + monstre.getRecompense() + " intcoins.");
            joueur.ajouterIntcoins(monstre.getRecompense());

            // Drop aléatoire simple (petite chance)
            int roll = random.nextInt(100);
            if (roll < 20) {
                System.out.println("🎁 Drop: un objet aléatoire (à améliorer ensuite)");
                // Optionnel : tu peux ajouter un drop réel plus tard
            }
        } else {
            System.out.println("\n❌ Défaite... Fin de partie.");
        }
    }
}
