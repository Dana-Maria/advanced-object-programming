package com.martac.fmi;

import com.martac.fmi.models.doctors.Doctor;
import com.martac.fmi.models.doctors.DoctorCardiolog;
import com.martac.fmi.models.doctors.DoctorEstetician;
import com.martac.fmi.models.pacients.Pacient;
import com.martac.fmi.models.pacients.PacientCuProgramare;
import com.martac.fmi.models.pacients.PacientUrgenta;
import com.martac.fmi.services.DoctorService;
import com.martac.fmi.services.PacientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    private static List<Pacient> pacients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();

    private static void afiseazaMeniu() {
        System.out.println();

        System.out.println("Meniu:");
        System.out.println("0. Exit");
        System.out.println("1. Afiseaza Pacienti.");
        System.out.println("2. Afiseaza Doctori.");
        System.out.println("3. Afiseaza Doctorii cu experienta de peste n anii experienta:");
        System.out.println("4. Afiseaza programari curente.");
        System.out.println("5. Afiseaza numar urgente.");
        System.out.println("6. Modifica data programare.");
        System.out.println("7. Modifica parola.");
        System.out.println("8. Afiseaza Pacienti cu grupa de sange: ");
        System.out.println("9. Adauga Pacient.");
        System.out.println("10. Sterge Pacient.");

        System.out.println("Alege Optiune: ");

    }

    private static void adaugaPacienti() {
        PacientUrgenta p1 = new PacientUrgenta("Popescu Sergiu", new GregorianCalendar(1980, 11, 3),
                "12345678975", "076436473", "A", true,
                Arrays.asList("Animale", "Flori"), false,
                false, "X", doctors.get(0));
        PacientUrgenta p2 = new PacientUrgenta("Vasile Ion", new GregorianCalendar(1990, 11, 3),
                "12345678975", "076436473", "AB", true,
                Arrays.asList("Animale"), false,
                false, "X", doctors.get(0));
        PacientCuProgramare p3 = new PacientCuProgramare("Sandulescu Sergiu", new GregorianCalendar(1980, 11, 3),
                "12345678975", "076436473", "A", true,
                Arrays.asList("Animale", "Flori"), false,
                false, "X", doctors.get(0),
                new GregorianCalendar(2019, 1, 4, 14, 20));

        pacients.add(p1);
        pacients.add(p2);
        pacients.add(p3);
    }

    private static void adaugaDoctor() {
        DoctorEstetician d1 = new DoctorEstetician("Grigore Alexandru",
                new GregorianCalendar(1975, 12, 28),
                "732573248572", "0724832424", "O", 20,
                new GregorianCalendar(1999, 11, 3));
        DoctorCardiolog d2 = new DoctorCardiolog("Todor Paul",
                new GregorianCalendar(1960, 2, 4),
                "732573248572", "0724832424", "O", 34,
                new GregorianCalendar(1985, 11, 3));
        DoctorEstetician d3 = new DoctorEstetician("Vlad George",
                new GregorianCalendar(1970, 12, 28),
                "732573248572", "0724832424", "O", 24,
                new GregorianCalendar(1995, 11, 3));
        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
    }

    public static void main(String[] args) {
        adaugaDoctor();
        adaugaPacienti();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int optiun = 0;
        afiseazaMeniu();

        try {
            optiun = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println("Eroare la citire/deschidere de fisier!");
        }
        while (optiun != 0) {
            PacientService pacientService = new PacientService(pacients);
            DoctorService doctorService = new DoctorService(doctors);

            switch (optiun) {
                case 1: {
                    pacientService.display();
                    break;
                }
                case 2: {
                    doctorService.display();
                    break;
                }
                case 3: {
                    try {
                        System.out.print("n = ");
                        int n = Integer.parseInt(bufferedReader.readLine());
                        doctorService.display(n);
                    } catch (IOException e) {
                        System.err.println("Something went wrong");
                    }
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    break;
                }
                case 9: {
                    break;
                }
                case 10: {
                    break;
                }

                default: {
                    System.out.println("Ati ales o optiune care nu se regaseste in meniu");

                    break;
                }
            }

            try {
                System.out.println();
                System.out.println("Apasati enter pentru a continua");
                bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println("Eroare la citire/deschidere de fisier!");
            }

            afiseazaMeniu();

            try {
                optiun = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.err.println("Eroare la citire/deschidere de fisier!");
            }
        }

    }
}
