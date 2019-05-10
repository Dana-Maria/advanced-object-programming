package com.martac.fmi.models.doctors;

import java.util.Calendar;

public class DoctorPediatru extends Doctor {

    public DoctorPediatru(String nume, Calendar dataNasterii, String cnp, String numarTelefon, String grupaSange,
                          Integer aniExperienta, Calendar dataAngajarii) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange, aniExperienta, dataAngajarii);
    }

    @Override
    public double getSalariu() {
        return 750 * aniExperienta;
    }
}
