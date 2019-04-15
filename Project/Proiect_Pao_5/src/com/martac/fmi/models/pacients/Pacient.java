package com.martac.fmi.models.pacients;

import com.martac.fmi.models.Persoana;
import com.martac.fmi.models.doctors.Doctor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public abstract class Pacient extends Persoana {

    protected Doctor doctor;
    protected Boolean operat;
    protected List<String> alergii;
    protected Boolean subTratament;
    protected Boolean internat;
    protected String boala;


    public Pacient(String nume, Calendar dataNasterii, String cnp, String numarTelefon,
                   String grupaSange, Boolean operat, List<String> alergii,
                   Boolean subTratament, Boolean internat, String boala, Doctor doctor) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange);
        this.operat = operat;
        this.alergii = alergii;
        this.subTratament = subTratament;
        this.internat = internat;
        this.boala = boala;
        this.doctor = doctor;
    }

    public Pacient() {
        alergii = new ArrayList<>();
    }

    public Boolean getOperat() {
        return operat;
    }

    public void setOperat(Boolean operat) {
        this.operat = operat;
    }

    public List<String> getAlergii() {
        return alergii;
    }

    public void setAlergii(List<String> alergii) {
        this.alergii = alergii;
    }

    public Boolean getSubTratament() {
        return subTratament;
    }

    public void setSubTratament(Boolean subTratament) {
        this.subTratament = subTratament;
    }

    public Boolean getInternat() {
        return internat;
    }

    public void setInternat(Boolean internat) {
        this.internat = internat;
    }

    public String getBoala() {
        return boala;
    }

    public void setBoala(String boala) {
        this.boala = boala;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
