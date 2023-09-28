package com.ekowalsk.factures;

import java.util.List;

public class ProfilEntreprise {
    private List<User> users;

    public ProfilEntreprise(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
