package entites;

import inventaire.Inventaire;

public class Joueur extends Entite {

    private int intcoins;
    private Inventaire inventaire;

    public Joueur(String nom) {
        this.nom = nom;
        this.vie = 100;
        this.attaque = 10;
        this.defense = 5;
        this.intcoins = 30;
        this.inventaire = new Inventaire();
    }

    public void ajouterIntcoins(int valeur) {
        intcoins += valeur;
    }

    public int getIntcoins() {
        return intcoins;
    }
    public void augmenterAttaque(int valeur) {
        this.attaque += valeur;
    }

    public void augmenterDefense(int valeur) {
        this.defense += valeur;
    }

    public void soigner(int valeur) {
        this.vie += valeur;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }
}

