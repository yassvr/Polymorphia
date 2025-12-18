package objets;

import entites.Joueur;

public class Armure extends Objet {

    private int bonusDef;

    public Armure(String nom, int bonusDef, int prix) {
        this.nom = nom;
        this.bonusDef = bonusDef;
        this.prix = prix;
    }

    @Override
    public void utiliser(Joueur joueur) {
        joueur.augmenterDefense(bonusDef);
        System.out.println("Armure équipée : +" + bonusDef + " défense");
    }
}

