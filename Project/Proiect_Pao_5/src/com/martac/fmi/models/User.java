package com.martac.fmi.models;

import java.util.Calendar;

public class User extends Persoana {

    public User(String nume, Calendar dataNasterii, String cnp, String numarTelefon, String grupaSange) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange);
    }
}
