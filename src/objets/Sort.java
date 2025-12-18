package objets;

import entites.Joueur;

public class Sort extends Objet {

    private int puissance;

    public Sort(String nom, int puissance, int prix) {
        this.nom = nom;
        this.puissance = puissance;
        this.prix = prix;
    }

    @Override
    public void utiliser(Joueur joueur) {
        joueur.augmenterAttaque(puissance);
        System.out.println("Sort lancé : +" + puissance + " attaque");
    }
}

