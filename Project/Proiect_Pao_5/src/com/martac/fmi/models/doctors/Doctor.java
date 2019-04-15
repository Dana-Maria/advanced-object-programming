package com.martac.fmi.models.doctors;

import com.martac.fmi.models.Persoana;

import java.util.Calendar;

public abstract class Doctor extends Persoana {

    protected Integer aniExperienta;
    protected Calendar dataAngajarii;

    public Doctor (String nume)
    {
        super(nume);
    }

    public Doctor(String nume, Calendar dataNasterii, String cnp,
                  String numarTelefon, String grupaSange,
                  Integer aniExperienta, Calendar dataAngajarii) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange);
        this.aniExperienta = aniExperienta;
        this.dataAngajarii = dataAngajarii;
    }

    public Doctor(Integer aniExperienta, Calendar dataAngajarii) {
        this.aniExperienta = aniExperienta;
        this.dataAngajarii = dataAngajarii;
    }

    public Integer getAniExperienta() {
        return aniExperienta;
    }

    public void setAniExperienta(Integer aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public Calendar getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Calendar dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public abstract double getSalariu();

    public Doctor() {
    }
}
