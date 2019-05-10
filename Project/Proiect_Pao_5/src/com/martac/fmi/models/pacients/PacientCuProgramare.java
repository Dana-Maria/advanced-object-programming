package com.martac.fmi.models.pacients;

import com.martac.fmi.models.doctors.Doctor;

import java.util.Calendar;
import java.util.List;

public class PacientCuProgramare extends Pacient {

    private Calendar ora;

    public PacientCuProgramare(String nume, Calendar dataNasterii, String cnp,
                               String numarTelefon, String grupaSange, Boolean operat,
                               Boolean subTratament, Boolean internat,
                               String boala, Integer doctorId, Calendar ora) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange, operat,
                subTratament, internat, boala, doctorId);
        this.ora = ora;
    }

    public Calendar getOra() {
        return ora;
    }
}
