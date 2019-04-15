package com.martac.fmi.models.pacients;

import com.martac.fmi.models.doctors.Doctor;

import java.util.Calendar;
import java.util.List;

public class PacientUrgenta extends Pacient {
    public PacientUrgenta(String nume, Calendar dataNasterii, String cnp, 
                          String numarTelefon, String grupaSange, Boolean operat, 
                          List<String> alergii, Boolean subTratament,
                          Boolean internat, String boala, Doctor doctor) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange, operat, 
                alergii, subTratament, internat, boala, doctor);
    }
}
