package com.ekowalsk.factures;

import java.util.Scanner;

public class Builder {
    public Devis createDevis(User user, Scanner sc){

        String username=user.getNom(); // nom du proprio depuis son username
        String adresse = user.getAdresse();


        System.out.println("Quel numéro d'id souhaitez vous renseignez ?");
        int id = Integer.parseInt(user.inputNumericString(sc));

        Devis devis = new Devis(username,id,adresse,false);

        System.out.println("Devis créer avec le numéro : " + devis.getId() + " Et sous le nom " + devis.getProprio());
        return devis;
    }
}
