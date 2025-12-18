package objets;

import entites.Joueur;

public class Potion extends Objet {

    private int soin;

    public Potion(String nom, int soin, int prix) {
        this.nom = nom;
        this.soin = soin;
        this.prix = prix;
    }

    @Override
    public void utiliser(Joueur joueur) {
        joueur.soigner(soin);
        System.out.println("Potion utilisée : +" + soin + " PV");
    }
}
