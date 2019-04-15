package com.martac.fmi.auth;

import com.martac.fmi.models.doctors.Doctor;

public class DoctorAuth implements Authenticalble {

    private Doctor doctor;
    private String password;

    @Override
    public String getUserName() {
        return doctor.getNume();
    }

    @Override
    public String getPassword() {
        return password;
    }
}
