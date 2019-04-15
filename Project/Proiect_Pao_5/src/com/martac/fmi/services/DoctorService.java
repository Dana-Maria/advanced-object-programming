package com.martac.fmi.services;

import com.martac.fmi.models.doctors.Doctor;

import java.util.List;

public class DoctorService implements Service {
    private List<Doctor> doctors;

    public DoctorService(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public void display() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor.toString());
        }
    }

    public void display(int n) {
        for (Doctor doctor : doctors) {
            if (doctor.getAniExperienta() >= n) {
                System.out.println(doctor.toString());
            }
        }
    }

    @Override
    public void add(Object o) {
        doctors.add((Doctor) o);
    }

    @Override
    public void remove(Object o) {
        doctors.remove(o);
    }

    @Override
    public void remove(int i) {
        doctors.remove(i);
    }
}
