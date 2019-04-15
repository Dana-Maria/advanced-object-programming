package com.martac.fmi.models.doctors;

import java.util.Calendar;

public class DoctorEstetician extends Doctor {

    public DoctorEstetician(String nume)
    {
        super(nume);
    }

    public DoctorEstetician(String nume, Calendar dataNasterii,
                            String cnp, String numarTelefon, String grupaSange,
                            Integer aniExperienta, Calendar dataAngajarii) {
        super(nume, dataNasterii, cnp, numarTelefon, grupaSange, aniExperienta, dataAngajarii);
    }

    @Override
    public double getSalariu() {
        return 1200 * aniExperienta ;
    }
}
