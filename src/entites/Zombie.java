package entites;

public class Zombie extends Monstre {

    public Zombie() {
        this.nom = "Zombie";
        this.vie = 50;
        this.attaque = 12;
        this.defense = 5;
        this.recompense = 10;
    }

    @Override
    public void crier() {
        System.out.println("Le zombie grogne...");
    }
}

