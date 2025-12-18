package entites;

public class Dragon extends Monstre {

    public Dragon() {
        this.nom = "Dragon";
        this.vie = 80;
        this.attaque = 20;
        this.defense = 10;
        this.recompense = 25;
    }

    @Override
    public void crier() {
        System.out.println("🔥 Le dragon rugit !");
    }
}

