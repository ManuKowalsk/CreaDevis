package com.ekowalsk.factures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Devis {
    private String proprio;
    private String adresse;
    private int id;
    boolean signe;
    private List<Articles> articles;

    public String getAdresse() {
        return adresse;
    }



    public boolean isSigne() {
        return signe;
    }

    public void setSigne(boolean signe) {
        this.signe = signe;
    }

    public Devis() {
        this.proprio = null;
        this.id = 0;
        this.articles = null;
        this.adresse=null;
        this.signe=false;
    }
    public Devis(String proprio, int id, String adresse,boolean signe,List<Articles> articles) {
        this.proprio = proprio;
        this.id = id;
        this.articles = articles;
        this.adresse=adresse;
        this.signe=false;
    }

    public Devis(String proprio, int id, String adresse,boolean signe) {
        this.proprio = proprio;
        this.id = id;
        this.articles = new ArrayList<>();
        this.adresse=adresse;
        this.signe=false;
    }

    public void add(User user, Scanner sc, Devis devis){
        String input;
        String nomA;
        String descA;
        int qtA;
        int prixA;


        boolean fin=false;


        do{
            System.out.println("Souhaitez vous ajoutez un article (oui) ou bien terminé (non) ? ");
            input = user.inputOuiNon(sc);
            if(input.equals("oui")){
                System.out.println("Quel nom d'article souhaitez vous ?");
                nomA=user.inputString(sc);
                System.out.println("Quel description d'article souhaitez vous ?");
                descA=user.inputString(sc);
                System.out.println("Quel nombres d'article souhaitez vous ?");
                qtA= Integer.parseInt(user.inputNumericString(sc));
                System.out.println("Quel prix d'article souhaitez vous ?");
                prixA= Integer.parseInt(user.inputNumericString(sc));
                Articles articles = new Articles(nomA,descA,qtA,prixA);
                System.out.println("Souhaitez vous ajoutez l'article ? Oui ou non");
                input= user.inputOuiNon(sc);
                if(input.equals("oui")){
                    this.getArticles().add(articles);
                    System.out.println("Article ajouté");
                }
                else if(input.equals("non")){
                    System.out.println("Article pas ajouté");
                }
            }
            else if (input.equals("non")){
                System.out.println("Retour au menu ...");
                fin=true;
            }
        }while(!fin);
    }

    public String getProprio() {
        return proprio;
    }


    public int getId() {
        return id;
    }


    public List<Articles> getArticles() {
        return articles;
    }

}