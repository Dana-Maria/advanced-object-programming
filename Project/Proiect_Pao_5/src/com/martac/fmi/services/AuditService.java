package com.martac.fmi.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

public class AuditService {
    private static PrintWriter printWriter;
    private static final String LOG_LOCATION = "./audit.csv";

    private static AuditService ourInstance = new AuditService();

    public static AuditService getInstance() {
        return ourInstance;
    }

    private AuditService() {

        try {
            printWriter = new PrintWriter(new File(LOG_LOCATION));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                closeWriter();
            }
        });
    }

    public void writeLogLine(String message) {

        Date d = new Date();
        printWriter.println(message + "," + d);

    }

    private boolean closeWriter () {
        boolean result = true;
        printWriter.flush();
        printWriter.close();
        return result;
    }
}
