package com.martac.fmi.models;

import java.util.Calendar;

public abstract class Persoana {
    protected String nume;
    protected Calendar dataNasterii;
    protected final String cnp;
    protected String numarTelefon;
    protected String grupaSange;

    public Persoana (String nume)
    {
        this.nume = nume;
        this.cnp = "32893298";
    }

    public Persoana(String nume, Calendar dataNasterii, String cnp, String numarTelefon, String grupaSange) {
        this.nume = nume;
        this.dataNasterii = dataNasterii;
        this.cnp = cnp;
        this.numarTelefon = numarTelefon;
        this.grupaSange = grupaSange;
    }

    public Persoana() {
        cnp = "";
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Calendar getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Calendar dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getGrupaSange() {
        return grupaSange;
    }

    public void setGrupaSange(String grupaSange) {
        this.grupaSange = grupaSange;
    }

    @Override
    public String toString() {
        return nume + " nascut la data de " + dataNasterii.get(Calendar.DAY_OF_MONTH) + "."
                + dataNasterii.get(Calendar.MONTH) + "." + dataNasterii.get(Calendar.YEAR) +
                " cu cnp " + cnp + " cu numarul de telefon " + numarTelefon;
    }
}
