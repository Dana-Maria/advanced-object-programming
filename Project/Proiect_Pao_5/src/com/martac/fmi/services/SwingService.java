package com.martac.fmi.services;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingService {
    private JFrame frame;
    private static SwingService instance;

    private SwingService() {
    }

    public static SwingService getInstance() {
        if (instance == null) {
            instance = new SwingService();
        }

        return instance;
    }

    public void mainWindow() {
        frame = new JFrame("Fereastra Principala");
        frame.setLocation(100, 100);
        frame.setSize(600, 400);

        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));

        JButton patientsButton = new JButton("Afiseaza Pacientii");
        JButton doctorsButton = new JButton("Afiseaza Doctorii");
        JButton doctorsNButton = new JButton("Afiseaza Doctorii cu cel putin n ani experienta");
        JButton emergenciesButton = new JButton("Afiseaza Urgentele");
        JButton grupaSangeButton = new JButton("Afiseaza pacientii cu grupa de sange");
        JButton exitButton = new JButton("Iesire");



        panel.add(patientsButton);
        panel.add(doctorsButton);
        panel.add(doctorsNButton);
        panel.add(emergenciesButton);
        panel.add(grupaSangeButton);
        panel.add(exitButton);

        patientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().patientsWindow();
            }
        });

        doctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().doctorsWindow();
            }
        });

        doctorsNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().doctorsNInputWindow();
            }
        });

        emergenciesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().emergenciesWindow();
            }
        });

        grupaSangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().grupaSangeInputWindow();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public void patientsWindow() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();

        String[] p = new DatabaseService().getPatients();
        JList<String> list = new JList<>(p);

        panel.add(list);

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                SwingService.getInstance().mainWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void doctorsWindow() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();

        String[] p = new DatabaseService().getDoctors();
        JList<String> list = new JList<>(p);

        panel.add(list);

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                SwingService.getInstance().mainWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Fereastra care cere numarul de ani experienta pentru a afisa lista.
     */
    public void doctorsNInputWindow() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();
        JLabel aniExperientaLabel = new JLabel("Ani experienta: ");
        JTextField aniExperientaField = new JTextField("", 15);
        JButton veziButton = new JButton("Vezi doctori");

        panel.add(aniExperientaLabel);
        panel.add(aniExperientaField);
        panel.add(veziButton);

        veziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = Integer.parseInt(aniExperientaField.getText().trim());
                SwingService.getInstance().doctorsWindow(n);
            }
        });

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                SwingService.getInstance().mainWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Fereastra care afiseaza lista doctorilor cu mai mult de n ani experienta
     */
    public void doctorsWindow(int n) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();

        String[] p = new DatabaseService().getDoctors(n);
        JList<String> list = new JList<>(p);

        panel.add(list);

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().doctorsNInputWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void emergenciesWindow() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();

        String[] p = new DatabaseService().getEmergencies();
        JList<String> list = new JList<>(p);

        panel.add(list);

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                SwingService.getInstance().mainWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public void grupaSangeInputWindow() {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();
        JLabel grupaSangeLabel = new JLabel("Grupa Sange: ");
        JTextField grupaSangeField = new JTextField("", 15);
        JButton veziButton = new JButton("Vezi pacienti");

        panel.add(grupaSangeLabel);
        panel.add(grupaSangeField);
        panel.add(veziButton);

        veziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = grupaSangeField.getText().trim();
                SwingService.getInstance().grupaSangeWindow(s);
            }
        });

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
                SwingService.getInstance().mainWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Fereastra care afiseaza lista pacientilor cu o anumita grupa de sange
     */
    public void grupaSangeWindow(String s) {
        frame.getContentPane().removeAll();
        frame.repaint();

        JPanel panel = new JPanel();

        String[] p = new DatabaseService().getGrupaSange(s);
        JList<String> list = new JList<>(p);

        panel.add(list);

        JButton inapoiButton = new JButton("Inapoi");
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingService.getInstance().doctorsNInputWindow();
            }
        });

        panel.add(inapoiButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}
