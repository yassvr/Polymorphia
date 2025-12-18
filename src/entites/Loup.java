package entites;

public class Loup extends Monstre {

    public Loup() {
        this.nom = "Loup";
        this.vie = 40;
        this.attaque = 10;
        this.defense = 3;
        this.recompense = 8;
    }

    @Override
    public void crier() {
        System.out.println("Le loup hurle...");
    }
}

