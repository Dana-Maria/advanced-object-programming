package com.martac.fmi.services;

import com.martac.fmi.auth.PacientAuth;
import com.martac.fmi.models.pacients.Pacient;

import java.util.List;

public class PacientService implements Service {
    private List<Pacient> pacients;

    public PacientService(List<Pacient> pacients) {
        this.pacients = pacients;
    }

    @Override
    public void display() {
        for (Pacient pacient : pacients) {
            System.out.println(pacient.toString());
        }
    }

    @Override
    public void add(Object o) {
        pacients.add((Pacient)o);
    }

    @Override
    public void remove(Object o) {
        pacients.remove(o);
    }

    @Override
    public void remove(int i) {
        pacients.remove(i);
    }
}
