package objets;

import entites.Joueur;

public class Arme extends Objet {

    private int bonusAtk;

    public Arme(String nom, int bonusAtk, int prix) {
        this.nom = nom;
        this.bonusAtk = bonusAtk;
        this.prix = prix;
    }

    @Override
    public void utiliser(Joueur joueur) {
    	joueur.augmenterAttaque(bonusAtk);
        System.out.println("Arme équipée : +" + bonusAtk + " attaque");
    }
}

