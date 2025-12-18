package multijoueur;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientPvP {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("IP serveur (ex: 127.0.0.1): ");
        String host = sc.nextLine();

        Socket socket = new Socket(host, 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Nom joueur: ");
        String nom = sc.nextLine();

        System.out.print("Vie (ex 100): ");
        int vie = Integer.parseInt(sc.nextLine());

        System.out.print("Attaque: ");
        int atk = Integer.parseInt(sc.nextLine());

        System.out.print("Defense: ");
        int def = Integer.parseInt(sc.nextLine());

        // format: NOM;VIE;ATK;DEF
        out.println(nom + ";" + vie + ";" + atk + ";" + def);

        while (true) {
            String msg = in.readLine();
            if (msg == null) break;

            String[] parts = msg.split(";");
            String type = parts[0];

            if ("START".equals(type)) {
                System.out.println(parts[1]);

            } else if ("YOURTURN".equals(type)) {
                System.out.println("Ton tour. PV toi=" + parts[1] + " | PV ennemi=" + parts[2]);
                System.out.println("Appuie Entrée pour attaquer...");
                sc.nextLine();
                out.println("ATTACK");

            } else if ("WAIT".equals(type)) {
                System.out.println("Attends... PV toi=" + parts[1] + " | PV ennemi=" + parts[2]);

            } else if ("INFO".equals(type)) {
                System.out.println(parts[1]);

            } else if ("END".equals(type)) {
                System.out.println("Fin: " + parts[1]);
                break;
            }
        }

        socket.close();
    }
}

