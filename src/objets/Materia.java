package objets;

import entites.Joueur;

public class Materia extends Objet {

    private int amelioration;

    public Materia(String nom, int amelioration, int prix) {
        this.nom = nom;
        this.amelioration = amelioration;
        this.prix = prix;
    }

    @Override
    public void utiliser(Joueur joueur) {
        joueur.augmenterAttaque(amelioration);
        joueur.augmenterDefense(amelioration);
        System.out.println(
            "Materia utilisée : +" + amelioration + " attaque et défense"
        );
    }
}

