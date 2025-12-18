package inventaire;

import inventaire.Inventaire;
import java.util.ArrayList;
import java.util.List;
import objets.Objet;

public class Inventaire {

    private List<Objet> objets = new ArrayList<>();

    public void ajouterObjet(Objet obj) {
        objets.add(obj);
    }

    public void retirerObjet(Objet obj) {
        objets.remove(obj);
    }

    public List<Objet> getObjets() {
        return objets;
    }

    public boolean estVide() {
        return objets.isEmpty();
    }
}
