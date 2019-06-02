package com.martac.fmi.services;

import com.martac.fmi.models.doctors.*;
import com.martac.fmi.models.pacients.PacientCuProgramare;
import com.martac.fmi.models.pacients.PacientUrgenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {
    private Connection connection;
    private String driver = "jdbc:postgresql://localhost:5432/PAO";

    public DatabaseService() {
        try {
            //Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(driver, "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getPatients() {
        List<String> l = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Pacienti\"");
            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                if (r.getBoolean("Urgenta")) {
                    PacientUrgenta pacientUrgenta = new PacientUrgenta(r.getString("Nume"), null,
                            r.getString("CNP"), null, r.getString("\"Grupa_de_Sange\""),
                            r.getBoolean("Operat"), r.getBoolean("Sub Tratament"),
                            r.getBoolean("Internat"), r.getString("Boala"), null);

                    l.add(pacientUrgenta.toString());
                } else {
                    PacientCuProgramare p = new PacientCuProgramare(r.getString("Nume"), null,
                            r.getString("CNP"), null, r.getString("\"Grupa_de_Sange\""),
                            r.getBoolean("Operat"), r.getBoolean("Sub Tratament"),
                            r.getBoolean("Internat"), r.getString("Boala"), null, null);

                    l.add(p.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l.toArray(new String[0]);
    }

    public String[] getDoctors() {
        List<String> l = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Doctori\"");
            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                if (r.getString("Tip").equalsIgnoreCase("Cardiolog")) {
                    DoctorCardiolog d = new DoctorCardiolog(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Ortoped")) {
                    DoctorOrtoped d = new DoctorOrtoped(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Pediatru")) {
                    DoctorPediatru d = new DoctorPediatru(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Oftalmolog")) {
                    DoctorOftalmolog d = new DoctorOftalmolog(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Estetician")) {
                    DoctorEstetician d = new DoctorEstetician(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l.toArray(new String[0]);
    }

    public String[] getDoctors(int n) {
        List<String> l = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Doctori\" " +
                    "WHERE \"Ani_Experienta\" >= ?");
            preparedStatement.setInt(1, n);

            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                if (r.getString("Tip").equalsIgnoreCase("Cardiolog")) {
                    DoctorCardiolog d = new DoctorCardiolog(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Ortoped")) {
                    DoctorOrtoped d = new DoctorOrtoped(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Pediatru")) {
                    DoctorPediatru d = new DoctorPediatru(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Oftalmolog")) {
                    DoctorOftalmolog d = new DoctorOftalmolog(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                } else if (r.getString("Tip").equalsIgnoreCase("Estetician")) {
                    DoctorEstetician d = new DoctorEstetician(r.getString("Nume"), null,
                            r.getString("CNP"), null, null,
                            r.getInt("Ani_Experienta"), null);

                    l.add(d.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l.toArray(new String[0]);
    }

    public String[] getEmergencies() {
        List<String> l = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Pacienti\"");
            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                if (r.getBoolean("Urgenta")) {
                    PacientUrgenta pacientUrgenta = new PacientUrgenta(r.getString("Nume"), null,
                            r.getString("CNP"), null, r.getString("Grupa_de_Sange"),
                            r.getBoolean("Operat"), r.getBoolean("Sub Tratament"),
                            r.getBoolean("Internat"), r.getString("Boala"), null);

                    l.add(pacientUrgenta.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l.toArray(new String[0]);
    }

    public String[] getGrupaSange(String s) {
        List<String> l = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Pacienti\" WHERE " +
                    "\"Grupa_de_Sange\" = ?");
            preparedStatement.setString(1, s);
            ResultSet r = preparedStatement.executeQuery();

            while (r.next()) {
                if (r.getBoolean("Urgenta")) {
                    PacientUrgenta pacientUrgenta = new PacientUrgenta(r.getString("Nume"), null,
                            r.getString("CNP"), null, r.getString("Grupa_de_Sange"),
                            r.getBoolean("Operat"), r.getBoolean("Sub Tratament"),
                            r.getBoolean("Internat"), r.getString("Boala"), null);

                    l.add(pacientUrgenta.toString());
                } else {
                    PacientCuProgramare p = new PacientCuProgramare(r.getString("Nume"), null,
                            r.getString("CNP"), null, r.getString("Grupa_de_Sange"),
                            r.getBoolean("Operat"), r.getBoolean("Sub Tratament"),
                            r.getBoolean("Internat"), r.getString("Boala"), null, null);

                    l.add(p.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l.toArray(new String[0]);
    }
}
