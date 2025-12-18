package objets;

import entites.Joueur;

public abstract class Objet {

    protected String nom;
    protected int prix;

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public abstract void utiliser(Joueur joueur);
}

