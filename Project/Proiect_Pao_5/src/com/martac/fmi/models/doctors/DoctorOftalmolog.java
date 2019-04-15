package com.martac.fmi.models.doctors;

public class DoctorOftalmolog extends Doctor {


    @Override
    public double getSalariu() {
        return 750 * aniExperienta;
    }
}
