package entites;

public abstract class Monstre extends Entite {

    protected int recompense;

    public int getRecompense() {
        return recompense;
    }

    public abstract void crier();
}

