package entites;

public abstract class Entite {

    protected String nom;
    protected int vie;
    protected int attaque;
    protected int defense;

    public boolean estVivant() {
        return vie > 0;
    }

    public void subirDegats(int degats) {
        vie -= Math.max(1, degats);
    }

    public void attaquer(Entite cible) {
        int degats = Math.max(1, attaque - cible.defense);
        cible.subirDegats(degats);
    }

    public String getNom() {
        return nom;
    }

    public int getVie() {
        return vie;
    }
}
