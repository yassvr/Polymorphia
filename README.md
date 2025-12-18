# Polymorphia

Projet réalisé dans le cadre d’un **TP de Programmation Orientée Objet (Java)**.  
Le jeu propose un **mode Solo (PvE)** et un **mode Multijoueur (PvP)** en interface console.

---

# Fonctionnalités

# Mode Solo (PvE)
- Exploration et combats contre des monstres (Loup, Zombie, Dragon)
- Système de combat tour par tour
- Inventaire contenant :
  - Armes
  - Armures
  - Potions
  - Sorts
  - Materia
  - Monnaie (intcoins)
- Marchand permettant d’acheter des objets
- Récompenses après les combats

# Mode Multijoueur (PvP)
- Combat entre deux joueurs via réseau
- Architecture client / serveur
- Communication par sockets TCP
- Connexion via IP (local ou réseau)

---

# Architecture du projet

Le projet respecte les principes fondamentaux de la **Programmation Orientée Objet** :
- Héritage (`Entite`, `Monstre`, `Objet`)
- Polymorphisme (objets utilisables, types de monstres)
- Encapsulation (inventaire, statistiques du joueur)
- Séparation claire des responsabilités par packages

# Organisation des packages
- `entites` : Joueur, Monstre, Dragon, Zombie, Loup
- `objets` : Arme, Armure, Potion, Sort, Materia
- `inventaire` : gestion de l’inventaire et des intcoins
- `combat` : logique des combats
- `marchand` : gestion du marchand
- `multijoueur` : PvP (ServeurPvP / ClientPvP)
- `jeu` : menu principal et interface console

Polymorphia
└─ src
   ├─ combat
   │  └─ Combat.java
   │
   ├─ entites
   │  ├─ Entite.java
   │  ├─ Joueur.java
   │  ├─ Monstre.java
   │  ├─ Dragon.java
   │  ├─ Loup.java
   │  └─ Zombie.java
   │
   ├─ inventaire
   │  └─ Inventaire.java
   │
   ├─ jeu
   │  └─ Jeu.java
   │
   ├─ marchand
   │  └─ Marchand.java
   │
   ├─ objets
   │  ├─ Objet.java
   │  ├─ Arme.java
   │  ├─ Armure.java
   │  ├─ Potion.java
   │  ├─ Sort.java
   │  └─ Materia.java
   │
   └─ reseau
      ├─ ServeurPvP.java
      └─ ClientPvP.java
---

# Exécution

# Mode Solo
Lancer la classe :
jeu.Jeu

yaml
Copy code

Puis choisir :
Mode Solo

yaml
Copy code

---

# Mode Multijoueur (PvP)

1. Lancer le serveur (une seule fois) :
multijoueur.ServeurPvP

markdown
Copy code

2. Lancer deux clients :
multijoueur.ClientPvP

yaml
Copy code

# Adresse IP
- `127.0.0.1` si le serveur et les clients sont sur le même PC
- Sinon, utiliser l’IP du PC serveur sur le réseau local

---

# Technologies utilisées
- Java 21
- Eclipse IDE
- Git / GitHub
- Programmation Orientée Objet
- Sockets TCP (réseau)

---

# Auteurs
- EL MORAGHI YASSIR
- BELRHALI MOAHMMED

---

## 📌 Remarques
- Interface utilisateur en console
- Projet conforme aux exigences du TP
- Architecture orientée objet claire et extensible
