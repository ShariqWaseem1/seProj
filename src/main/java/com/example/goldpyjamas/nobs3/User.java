package com.example.goldpyjamas.nobs3;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;

    User(String un, String p){
        username = un;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
