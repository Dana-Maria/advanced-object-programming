package com.martac.fmi.services;

import com.martac.fmi.auth.PacientAuth;
import com.martac.fmi.models.pacients.Pacient;
import com.martac.fmi.models.pacients.PacientCuProgramare;
import com.martac.fmi.models.pacients.PacientUrgenta;

import java.io.IOException;
import java.util.Calendar;
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
        Pacient pacient = (Pacient) o;
        pacients.add(pacient);

        try {
            writePacientToFile(pacient);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisier " + e.getMessage());
        }
    }

    @Override
    public void remove(Object o) {
        pacients.remove(o);
    }

    @Override
    public void remove(int i) {
        pacients.remove(i);
    }

    private String getStringFromCalendar(Calendar data, boolean ora) {
        String dataString = "";

        dataString += data.get(Calendar.DAY_OF_MONTH) + "." + data.get(Calendar.MONTH) + "." +
                data.get(Calendar.YEAR);

        if (ora) {
            dataString += " " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE);
        }

        return dataString;
    }

    private String getBooleanString(boolean operat) {
        if (operat) {
            return "true";
        } else {
            return "false";
        }
    }

    private void writePacientToFile(Pacient pacient) throws IOException {
        WriteService writeService = new WriteService("src/pacient.csv");
        writeService.write("\n");

        try {
            writeService.write(pacient.getNume());
            if (pacient instanceof PacientUrgenta) {
                writeService.write("Urgenta");
            } else {
                writeService.write("Programare");
            }

            writeService.write(getStringFromCalendar(pacient.getDataNasterii(), false));
            writeService.write(pacient.getCnp());
            writeService.write(pacient.getNumarTelefon());
            writeService.write(pacient.getGrupaSange());
            writeService.write(getBooleanString(pacient.getOperat()));
            writeService.write(getBooleanString(pacient.getSubTratament()));
            writeService.write(getBooleanString(pacient.getInternat()));
            writeService.write(pacient.getBoala());
            writeService.write(pacient.getDoctorId().toString());

            if (pacient instanceof PacientCuProgramare) {
                /* Adaugam si data programarii */
                PacientCuProgramare pacientCuProgramare = (PacientCuProgramare) pacient;
                writeService.write(getStringFromCalendar(pacientCuProgramare.getOra(), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayPatients(boolean urgenta) {
        for (Pacient pacient : pacients) {
            if (urgenta) {
                if (pacient instanceof PacientUrgenta) {
                    System.out.println(pacient);
                }
            }
            else {
                if (pacient instanceof  PacientCuProgramare) {
                    System.out.println(pacient);
                }
            }
        }
    }
}
