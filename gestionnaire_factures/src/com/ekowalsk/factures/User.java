package com.ekowalsk.factures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

    private String nom;

    private String description;
    private String adresse;
    private List<Devis> devis;

    private List<Factures> factures;

    public User() {
        this.nom = null;
        this.factures = new ArrayList<>();
        this.description = null;
        this.adresse=null;
        this.devis=new ArrayList<>();
    }


    public void creerDevis(Scanner sc){
        String input;

        System.out.println("Entrez l'ID du devis à partir du quel vous souhaitez créer une facture :");
        String idDevis = inputNumericString(sc);

        for (Devis devis : devis) {
            if (devis.getId() == Integer.parseInt(idDevis)) {

                Factures facture = new Factures(devis.getProprio(), devis.getId(), devis.getAdresse(), true, devis.getArticles());

                /* J'ai enlever ce bout de code car je me suis rendu compte qu'un devis signé ne pouvais pas etre modifié IRL
                System.out.println("Souhaitez-vous ajouter des articles à ce devis ? (oui/non) :");
                input = inputOuiNon(sc);

                if (input.equals("oui")) {
                    facture.add(this, sc, facture);
                }
                */
                if(devis.isSigne()){factures.add(facture);
                    System.out.println("Facture créée avec succès.");
                    return;
                }

                System.out.println("Facture non créée car devis pas signé.");
                return;
            }
        }
        System.out.println("Aucun devis trouvé avec l'ID " + idDevis);
    }


    public void signeDevis(Scanner sc,String id){
        if (devis != null && !devis.isEmpty()) {
            for (Devis facture : devis) {
                if (facture.getId() == Integer.parseInt(id)) {
                    System.out.println("Etes-vous sûr de signer le devis d'ID : " + id);
                    String input = inputOuiNon(sc);
                    if (input.equals("oui")) {
                        facture.setSigne(true);
                        System.out.println("Devis signée avec succès");
                    } else {
                        System.out.println("Signature annulée");
                    }
                    return;
                }
            }
            System.out.println("Devis avec l'ID " + id + " non trouvée");
        } else {
            System.out.println("Aucun devis n'a été créée");
        }
    }
    public void create(Scanner sc){
        String userInput;
        boolean isValidInput = false;

        System.out.println("Quel nom de compte souhaitez vous ?");
        userInput = inputString(sc);
        this.nom=userInput;
        System.out.println("Quel descr de compte souhaitez vous ?");
        userInput = inputString(sc);
        this.description=userInput;
        System.out.println("Quel adresse de compte souhaitez vous ?");
        userInput = inputString(sc);
        this.adresse=userInput;
        System.out.println("Votre compte à été creer avec les informations suivantes : " + " nom : "+ this.nom + " | description : "+ this.description + " et l'adresse " + this.adresse);
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public void choixAffichageDevis(Scanner sc){
        String input;

        System.out.println("Voulez vous affichez toutes vos devis ou par ID ? choix : tous ou id");
        input = inputString(sc);
        if(input.equals("tous")){
            afficherDevis();
        } else if (input.equals("id")) {
            System.out.println("Précisez l'id de la facture : ");
            input = inputNumericString(sc);

            afficherDevisId(Integer.parseInt(input));
        }
    }

    public void afficherDevis() {
        int total;
        if (devis != null && !devis.isEmpty()) {
            System.out.println("Liste des devis : " );
            for (Devis devis : devis) {
                total=0;//reset du total a chaque facture différentes
                System.out.println("------------- ");
                System.out.println("Numero de devis : " + devis.getId());
                System.out.println("Proprio : " + devis.getProprio());
                List<Articles> articles = devis.getArticles();
                if (articles != null && !articles.isEmpty()) {
                    System.out.println("---------------");
                    System.out.println("Articles :");
                    System.out.println("---------------");
                    for (Articles article : articles) {
                        System.out.println("Nom : " + article.getNom());
                        System.out.println("Description : " + article.getDescription());
                        System.out.println("Quantité : " + article.getQuantite());
                        System.out.println("Prix HT : " + article.getPrix());
                        System.out.println("---------------");
                        total += article.getPrix();
                    }
                    System.out.println("Total du devis HT: " + total);
                } else {
                    System.out.println("Aucun article dans ce devis");
                }
                System.out.println("-----------");
            }
        } else {
            System.out.println("Aucun devis n'a été créée");
        }
    }

    public void afficherDevisId(int id) {
        if (devis != null && !devis.isEmpty()) {
            for (Devis devis : devis) {
                if (devis.getId() == id) {
                    System.out.println("------------- ");
                    System.out.println("Numero de devis : " + devis.getId());
                    System.out.println("Proprio : " + devis.getProprio());
                    List<Articles> articles = devis.getArticles();
                    if (articles != null && !articles.isEmpty()) {
                        System.out.println("---------------");
                        System.out.println("Articles :");
                        System.out.println("---------------");
                        int total = 0;
                        for (Articles article : articles) {
                            System.out.println("Nom : " + article.getNom());
                            System.out.println("Description : " + article.getDescription());
                            System.out.println("Quantité : " + article.getQuantite());
                            System.out.println("Prix HT : " + article.getPrix());
                            System.out.println("---------------");
                            total += article.getPrix();
                        }
                        System.out.println("Total du devis HT: " + total);
                    } else {
                        System.out.println("Aucun article dans ce devis");
                    }
                    System.out.println("-----------");
                    return;
                }
            }
            System.out.println("devis avec l'ID " + id + " non trouvée");
        }else {
            System.out.println("Aucune devis n'a été créée");
        }
    }

    public void choixAffichage(Scanner sc){
        boolean correctInput = false;
        String input;

            System.out.println("Voulez vous affichez toutes vos factures ou par ID ? choix : tous ou id");
             input = inputString(sc);
            if(input.equals("tous")){
                afficherFactures();
            } else if (input.equals("id")) {
                System.out.println("Précisez l'id de la facture : ");
                input = inputNumericString(sc);

                afficherFactureId(Integer.parseInt(input));
            }
    }

    public void afficherFactures() {
        int total;
        if (factures != null && !factures.isEmpty()) {
            System.out.println("Liste des factures : " );
            for (Factures facture : factures) {
                total=0;//reset du total a chaque facture différentes
                System.out.println("------------- ");
                System.out.println("Numero de Facture : " + facture.getId());
                System.out.println("Proprio : " + facture.getProprio());
                List<Articles> articles = facture.getArticles();
                if (articles != null && !articles.isEmpty()) {
                    System.out.println("---------------");
                    System.out.println("Articles :");
                    System.out.println("---------------");
                    for (Articles article : articles) {
                        System.out.println("Nom : " + article.getNom());
                        System.out.println("Description : " + article.getDescription());
                        System.out.println("Quantité : " + article.getQuantite());
                        System.out.println("Prix HT : " + article.getPrix());
                        System.out.println("---------------");
                        total += article.getPrix();
                    }
                    System.out.println("Total de la facture HT: " + total);
                } else {
                    System.out.println("Aucun article dans cette facture");
                }
                System.out.println("-----------");
            }
        } else {
            System.out.println("Aucune facture n'a été créée");
        }
    }


    public void afficherFactureId(int id) {
        if (factures != null && !factures.isEmpty()) {
            for (Factures facture : factures) {
                if (facture.getId() == id) {
                    System.out.println("------------- ");
                    System.out.println("Numero de Facture : " + facture.getId());
                    System.out.println("Proprio : " + facture.getProprio());
                    List<Articles> articles = facture.getArticles();
                    if (articles != null && !articles.isEmpty()) {
                        System.out.println("---------------");
                        System.out.println("Articles :");
                        System.out.println("---------------");
                        int total = 0;
                        for (Articles article : articles) {
                            System.out.println("Nom : " + article.getNom());
                            System.out.println("Description : " + article.getDescription());
                            System.out.println("Quantité : " + article.getQuantite());
                            System.out.println("Prix HT : " + article.getPrix());
                            System.out.println("---------------");
                            total += article.getPrix();
                        }
                        System.out.println("Total de la facture HT: " + total);
                    } else {
                        System.out.println("Aucun article dans cette facture");
                    }
                    System.out.println("-----------");
                    return;
                }
            }
            System.out.println("Facture avec l'ID " + id + " non trouvée");
        }else {
            System.out.println("Aucune facture n'a été créée");
        }
    }

    public String inputString(Scanner sc) {
        String userInput;

        do {
            System.out.print("Veuillez entrer une chaîne de caractères valide : ");
            userInput = sc.nextLine();

            if (userInput != null) { // TODO Ajoutez une méthode de validation par la suite
                return userInput;
            } else {
                System.out.println("Entrée invalide.");
            }
        } while (true);
    }

    public String inputOuiNon(Scanner sc){
        String userInput;
        boolean isValidInput = false;

        do {
            System.out.print("Veuillez entrer 'oui' ou 'non': ");
            userInput = sc.nextLine().toLowerCase();

            if (userInput.equals("oui") || userInput.equals("non")) {
                isValidInput = true;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer 'oui' ou 'non'.");
            }
        } while (!isValidInput);

        return userInput;
    }


    public String inputNumericString(Scanner sc) {
        String userInput;

        do {
            System.out.print("Veuillez entrer un nombre valide : ");
            userInput = sc.nextLine();

            if (isNumeric(userInput)) {
                return userInput;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        } while (true);
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getNom() {
        return nom;
    }

    public List<Devis> getDevis() {
        return devis;
    }
}
