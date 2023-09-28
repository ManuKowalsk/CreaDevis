package com.ekowalsk.factures;

import java.util.List;

public class Factures extends Devis{

    public Factures(String proprio, int id, String adresse, boolean signe, List<Articles> articles) {
        super(proprio, id, adresse,signe,articles);
    }
}
