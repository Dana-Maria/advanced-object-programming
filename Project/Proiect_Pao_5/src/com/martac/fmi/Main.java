package com.martac.fmi;

import com.martac.fmi.models.doctors.*;
import com.martac.fmi.models.pacients.Pacient;
import com.martac.fmi.models.pacients.PacientCuProgramare;
import com.martac.fmi.models.pacients.PacientUrgenta;
import com.martac.fmi.services.AuditService;
import com.martac.fmi.services.DoctorService;
import com.martac.fmi.services.PacientService;
import com.martac.fmi.services.ReadService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Pacient> pacients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();

    private static Calendar getCalendarFromString(String data, boolean ora) {
        String[] splitData = data.split("\\.");

        int zi = Integer.parseInt(splitData[0]);
        int luna = Integer.parseInt(splitData[1]);

        if (ora) {
            String[] splitLastElement = splitData[2].split(" ");
            int an = Integer.parseInt(splitLastElement[0]);

            String[] splitOra = splitLastElement[1].split(":");
            int oraInt = Integer.parseInt(splitOra[0]);
            int minut = Integer.parseInt(splitOra[1]);

            return new GregorianCalendar(an, luna, zi, oraInt, minut);
        }

        int an = Integer.parseInt(splitData[2]);
        return new GregorianCalendar(an, luna, zi);
    }

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
        try {
            ReadService readService = new ReadService("src/pacient.csv");
            readService.readLine(); // citim prima linie cu numele coloanelor

            String[] line = readService.readLine();
            while (line != null) {
                String nume = line[0].trim();
                String dataNasterii = line[2].trim();
                String CNP = line[3].trim();
                String nrTelefon = line[4].trim();
                String grupaSange = line[5].trim();
                String operat = line[6].trim();
                String tratament = line[7].trim();
                String internat = line[8].trim();
                String boala = line[9].trim();
                String idDoctor = line[10].trim();

                Calendar dataNasteriiCalendar = getCalendarFromString(dataNasterii, false);

                if (line[1].trim().equalsIgnoreCase("urgenta")) {
                    PacientUrgenta pacientUrgenta = new PacientUrgenta(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Boolean.parseBoolean(operat), Boolean.parseBoolean(tratament),
                            Boolean.parseBoolean(internat), boala, Integer.parseInt(idDoctor));

                    pacients.add(pacientUrgenta);
                }
                else {
                    Calendar ora = getCalendarFromString(line[11].trim(), true);
                    PacientCuProgramare pacientCuProgramare = new PacientCuProgramare(nume, dataNasteriiCalendar,
                            CNP, nrTelefon, grupaSange, Boolean.parseBoolean(operat),
                            Boolean.parseBoolean(tratament), Boolean.parseBoolean(internat), boala,
                            Integer.parseInt(idDoctor), ora);

                    pacients.add(pacientCuProgramare);
                }

                line = readService.readLine();
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisier");
        }
    }

    private static void adaugaDoctor() {
        try {
            ReadService readService = new ReadService("src/doctor.csv");
            readService.readLine(); // citim prima linie cu numele coloanelor

            String[] line = readService.readLine();
            while (line != null) {
                String nume = line[0].trim();
                String dataNasterii = line[2].trim();
                String CNP = line[3].trim();
                String nrTelefon = line[4].trim();
                String grupaSange = line[5].trim();
                String aniExperienta = line[6].trim();
                String dataAngajarii = line[7].trim();

                Calendar dataNasteriiCalendar = getCalendarFromString(dataNasterii, false);
                Calendar dataAngajariiCalendar = getCalendarFromString(dataAngajarii, false);

                if (line[1].trim().equalsIgnoreCase("estetician")) {
                    DoctorEstetician doctorEstetician = new DoctorEstetician(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Integer.parseInt(aniExperienta), dataAngajariiCalendar);

                    doctors.add(doctorEstetician);
                }
                else if (line[1].trim().equalsIgnoreCase("cardiolog")) {
                    DoctorCardiolog doctorCardiolog = new DoctorCardiolog(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Integer.parseInt(aniExperienta), dataAngajariiCalendar);

                    doctors.add(doctorCardiolog);
                }
                else if (line[1].trim().equalsIgnoreCase("oftalmolog")) {
                    DoctorOftalmolog doctorOftalmolog = new DoctorOftalmolog(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Integer.parseInt(aniExperienta), dataAngajariiCalendar);

                    doctors.add(doctorOftalmolog);
                }
                else if (line[1].trim().equalsIgnoreCase("ortoped")) {
                    DoctorOrtoped doctorOrtoped = new DoctorOrtoped(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Integer.parseInt(aniExperienta), dataAngajariiCalendar);

                    doctors.add(doctorOrtoped);
                }
                else if (line[1].trim().equalsIgnoreCase("pediatru")) {
                    DoctorPediatru doctorPediatru = new DoctorPediatru(nume, dataNasteriiCalendar, CNP, nrTelefon,
                            grupaSange, Integer.parseInt(aniExperienta), dataAngajariiCalendar);

                    doctors.add(doctorPediatru);
                }

                line = readService.readLine();
            }
        } catch (IOException e) {
            System.out.println("A aparut o eroare la citirea din fisier");
        }
    }

    public static void main(String[] args) {
        adaugaDoctor();
        adaugaPacienti();

        AuditService auditService = AuditService.getInstance();


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
                    auditService.writeLogLine("Afiseaza Pacienti");
                    break;
                }
                case 2: {
                    doctorService.display();
                    auditService.writeLogLine("Afiseaza Doctori");
                    break;
                }
                case 3: {
                    try {
                        System.out.print("n = ");
                        int n = Integer.parseInt(bufferedReader.readLine());
                        doctorService.display(n);
                        auditService.writeLogLine("Afiseaza Doctori cu peste " + n + " ani experienta");
                    } catch (IOException e) {
                        System.err.println("Something went wrong");
                    }
                    break;
                }
                case 4: {
                    pacientService.displayPatients(false);
                    auditService.writeLogLine("Afiseaza pacientii cu programare");
                    break;
                }
                case 5: {
                    pacientService.displayPatients(true);
                    auditService.writeLogLine("Afiseaza urgentele");
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
                    try {
                        readAndStoreNewPatient(bufferedReader, pacientService);
                        auditService.writeLogLine("Adauga un nou pacient");

                        System.out.println();
                        System.out.println("Pacientul a fost adaugat cu succes!");
                    } catch (IOException ex) {
                        System.err.println("Eroare la citire");
                    }
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

    private static void readAndStoreNewPatient(BufferedReader bufferedReader, PacientService pacientService) throws IOException {
        String nume = readField(bufferedReader, "Numele pacientului");
        String tip = readField(bufferedReader, "Tip pacient (urgenta / programare): ");
        String ziuaNasterii = readField(bufferedReader, "Data nasterii:\nziua: ");
        String lunaNasterii = readField(bufferedReader, "luna (1-12): ");
        String anulNasterii = readField(bufferedReader, "anul: ");
        String cnp = readField(bufferedReader, "cnp: ");
        String nrTelefon = readField(bufferedReader, "Numar de telefon: ");
        String grupaSange = readField(bufferedReader, "Grupa de sange (O / A / B / AB): ");
        String operat = readField(bufferedReader, "Este pacientul operat (Y / N): ");
        String subTratament = readField(bufferedReader, "Este pacientul sub tratament (Y / N): ");
        String internat = readField(bufferedReader, "Este pacientul internat (Y / N): ");
        String boala = readField(bufferedReader, "Boala de care sufera: ");
        String doctor = readField(bufferedReader, "Doctorul care se ocupa de pacient: ");

        Calendar dataNasterii = new GregorianCalendar(Integer.parseInt(anulNasterii),
                Integer.parseInt(lunaNasterii), Integer.parseInt(ziuaNasterii));


        if (tip.equalsIgnoreCase("programare")) {
            String ziuaProgramarii = readField(bufferedReader, "Data programarii:\nziua: ");
            String lunaProgramarii = readField(bufferedReader, "luna (1-12): ");
            String anulProgramarii = readField(bufferedReader, "anul: ");
            String oraProgramarii = readField(bufferedReader, "ora: ");
            String minutulProgramarii = readField(bufferedReader, "minutul: ");

            Calendar dataProgramarii = new GregorianCalendar(Integer.parseInt(anulProgramarii),
                    Integer.parseInt(lunaProgramarii), Integer.parseInt(ziuaProgramarii),
                    Integer.parseInt(oraProgramarii), Integer.parseInt(minutulProgramarii));

            PacientCuProgramare pacientCuProgramare = new PacientCuProgramare(nume, dataNasterii,
                    cnp, nrTelefon, grupaSange, getBooleanFromStringYN(operat), getBooleanFromStringYN(subTratament),
                    getBooleanFromStringYN(internat), boala, getDoctorIdFromName(doctor), dataProgramarii);

            pacientService.add(pacientCuProgramare);
        }
        else if (tip.equalsIgnoreCase("urgenta")) {
            PacientUrgenta pacientUrgenta = new PacientUrgenta(nume, dataNasterii, cnp, nrTelefon, grupaSange,
                    getBooleanFromStringYN(operat), getBooleanFromStringYN(subTratament),
                    getBooleanFromStringYN(internat), boala, getDoctorIdFromName(doctor));

            pacientService.add(pacientUrgenta);
        }
    }

    private static String readField(BufferedReader bufferedReader, String message) throws IOException {
        System.out.println();
        System.out.println(message);

        return bufferedReader.readLine();
    }

    private static boolean getBooleanFromStringYN(String yn) {
        return yn.equalsIgnoreCase("y");
    }

    private static int getDoctorIdFromName(String name) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getNume().equalsIgnoreCase(name)) {
                return i+1;
            }
        }

        return 0;
    }
}
