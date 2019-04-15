package com.martac.fmi.auth;

import com.martac.fmi.models.pacients.Pacient;

public class PacientAuth implements Authenticalble {

    private Pacient pacient;
    private String password;


    @Override
    public String getUserName() {
        return pacient.getNume();
    }

    @Override
    public String getPassword() {
        return password;
    }
}
