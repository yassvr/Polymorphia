package multijoueur;

import java.io.*;
import java.net.*;

public class ServeurPvP {

    private static int degats(int atk, int def) {
        return Math.max(1, atk - def);
    }

    public static void main(String[] args) throws Exception {
        int port = 5000;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Serveur PvP prêt sur port " + port);

        Socket s1 = server.accept();
        System.out.println("Joueur 1 connecté");
        Socket s2 = server.accept();
        System.out.println("Joueur 2 connecté");

        BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
        PrintWriter out1 = new PrintWriter(s1.getOutputStream(), true);

        BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()));
        PrintWriter out2 = new PrintWriter(s2.getOutputStream(), true);

        // format attendu: NOM;VIE;ATK;DEF
        String[] p1 = in1.readLine().split(";");
        String[] p2 = in2.readLine().split(";");

        String nom1 = p1[0];
        int vie1 = Integer.parseInt(p1[1]);
        int atk1 = Integer.parseInt(p1[2]);
        int def1 = Integer.parseInt(p1[3]);

        String nom2 = p2[0];
        int vie2 = Integer.parseInt(p2[1]);
        int atk2 = Integer.parseInt(p2[2]);
        int def2 = Integer.parseInt(p2[3]);

        out1.println("START;Tu affrontes " + nom2);
        out2.println("START;Tu affrontes " + nom1);

        boolean tourJ1 = true;

        while (vie1 > 0 && vie2 > 0) {

            if (tourJ1) {
                out1.println("YOURTURN;" + vie1 + ";" + vie2);
                out2.println("WAIT;" + vie2 + ";" + vie1);

                String cmd = in1.readLine(); // ATTACK
                if ("ATTACK".equals(cmd)) {
                    int d = degats(atk1, def2);
                    vie2 -= d;
                    out1.println("INFO;Tu infliges " + d + " dégâts.");
                    out2.println("INFO;Tu subis " + d + " dégâts.");
                }

            } else {
                out2.println("YOURTURN;" + vie2 + ";" + vie1);
                out1.println("WAIT;" + vie1 + ";" + vie2);

                String cmd = in2.readLine(); // ATTACK
                if ("ATTACK".equals(cmd)) {
                    int d = degats(atk2, def1);
                    vie1 -= d;
                    out2.println("INFO;Tu infliges " + d + " dégâts.");
                    out1.println("INFO;Tu subis " + d + " dégâts.");
                }
            }

            tourJ1 = !tourJ1;
        }

        if (vie1 <= 0) {
            out1.println("END;DEFEAT");
            out2.println("END;VICTORY");
        } else {
            out1.println("END;VICTORY");
            out2.println("END;DEFEAT");
        }

        s1.close();
        s2.close();
        server.close();
    }
}
