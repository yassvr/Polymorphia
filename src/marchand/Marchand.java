package marchand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entites.Joueur;
import objets.Arme;
import objets.Armure;
import objets.Materia;
import objets.Objet;
import objets.Potion;
import objets.Sort;

public class Marchand {

    private List<Objet> stock = new ArrayList<>();

    public Marchand() {
        // Prix dépend des stats 
        stock.add(new Arme("Épée", 5, 20));
        stock.add(new Arme("Hache", 8, 30));

        stock.add(new Armure("Armure cuir", 3, 18));
        stock.add(new Armure("Armure acier", 6, 35));

        stock.add(new Potion("Potion", 20, 10));
        stock.add(new Potion("Grande potion", 40, 18));

        stock.add(new Sort("Sort de puissance", 6, 25));
        stock.add(new Materia("Materia", 2, 15));
    }

    public void afficherStock() {
        System.out.println("\n=== Marchand ===");
        for (int i = 0; i < stock.size(); i++) {
            Objet o = stock.get(i);
            System.out.println(i + ") " + o.getNom() + " - " + o.getPrix() + " intcoins");
        }
    }

    public void vendreObjet(Joueur joueur) {
        Scanner sc = new Scanner(System.in);

        afficherStock();
        System.out.println("Tes intcoins: " + joueur.getIntcoins());
        System.out.print("Choisir un objet (-1 pour annuler): ");

        int choix = sc.nextInt();

        if (choix == -1) {
            return;
        }

        if (choix < 0 || choix >= stock.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Objet obj = stock.get(choix);

        if (joueur.getIntcoins() < obj.getPrix()) {
            System.out.println("Pas assez d'intcoins.");
            return;
        }

        joueur.ajouterIntcoins(-obj.getPrix());
        joueur.getInventaire().ajouterObjet(obj);

        System.out.println("Achat réussi: " + obj.getNom());
    }
}

