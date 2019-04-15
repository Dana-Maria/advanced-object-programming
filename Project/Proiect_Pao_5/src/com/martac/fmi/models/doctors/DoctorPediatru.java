package com.martac.fmi.models.doctors;

public class DoctorPediatru extends Doctor {
    @Override
    public double getSalariu() {
        return 750 * aniExperienta;
    }
}
