package com.martac.fmi.models.doctors;

public class DoctorOrtoped extends Doctor {


    @Override
    public double getSalariu() {
        return 950 * aniExperienta;
    }

}
