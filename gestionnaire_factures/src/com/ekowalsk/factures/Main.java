package com.ekowalsk.factures;

import java.util.Scanner;
// KOWALSKI EMANUEL
//SUP DE VINCI
//28.08.2023

public class Main {
    public static void main(String[] args) {
        System.out.print("Bienvenue dans CreaDevis : ");
        System.out.print("Veuilez renseignez votre nom pour creer un profil entreprise ? ");
        Scanner sc = new Scanner(System.in);
        User user = new User();
        boolean fin = false;
        Builder builder = new Builder();
            String input = user.inputOuiNon(sc);
            if (input.equals("oui")) {
                user.create(sc);
            } else if (input.equals("non")) {
                System.out.println("non marcher");
                //TODO implementer systeme de connection si le temps
            }

        do {
            System.out.println("-------------Menu------------");
            System.out.println("Creer une nouveau devis : 1");
            System.out.println("Afficher la liste des factures : 2");
            System.out.println("Afficher la liste de devis : 3");
            System.out.println("Creer une facture à partir d'un devis : 4");
            System.out.println("Signez un devis : 5");

            System.out.println("Quittez l'application : Q");
            System.out.println("Veuillez faire votre choix");
            input = sc.nextLine();
            switch (input) {
                default:
                    System.out.println("Un numéro qui est présent dans la liste");
                    break;
                case "1":
                    System.out.println("Création devis");
                    Devis devis = new Devis();
                    devis = builder.createDevis(user,sc);
                    devis.add(user,sc, devis);
                    user.getDevis().add(devis);
                    System.out.println("appuyez sur la touche entree pour revenir au menu");
                    sc.nextLine();
                    break;
                case "2":
                    System.out.println("Affichage facture");
                    user.choixAffichage(sc);
                    System.out.println("appuyez sur la touche entree pour revnir au menu");
                    sc.nextLine();
                    break;
                case "3":
                    System.out.println("Affichage Devis");
                    user.choixAffichageDevis(sc);
                    System.out.println("appuyez sur la touche entree pour revnir au menu");
                    sc.nextLine();
                    break;
                case "4":
                    System.out.println("Creer facture à partir de devis");
                    user.creerDevis(sc);
                    System.out.println("appuyez sur la touche entree pour revnir au menu");
                    sc.nextLine();
                    break;
                case "5":
                    System.out.println("Signature des devis");
                    user.afficherFactures();
                    System.out.println("Quel devis souhaitez vous faire signé ? Donnez l'id");
                    input= user.inputNumericString(sc);
                    user.signeDevis(sc,input);
                    System.out.println("appuyez sur la touche entree pour revnir au menu");
                    sc.nextLine();
                    break;

                case "Q":
                    System.out.println("A bientot ...");
                    fin = true;
                    break;
            }
        } while (!fin);
    }
}

