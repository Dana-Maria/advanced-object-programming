package com.martac.fmi.models.doctors;

import java.util.Calendar;

public class DoctorCardiolog extends Doctor {

    public DoctorCardiolog(String nume, Calendar dataNasterii, String cnp,
                           String numarTelefon, String grupaSange, Integer aniExperienta,
                           Calendar dataAngajarii) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange, aniExperienta, dataAngajarii);
    }

    @Override
    public double getSalariu() {
        return 1500 * aniExperienta;
    }
}
