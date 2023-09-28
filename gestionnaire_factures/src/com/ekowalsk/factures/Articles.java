package com.ekowalsk.factures;

public class Articles {
    private String nom;
    private String description;
    private int quantite;
    private int prix;


    public Articles (String nom, String description, int quantite, int prix) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }


    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getPrix() {
        return prix;
    }
}
