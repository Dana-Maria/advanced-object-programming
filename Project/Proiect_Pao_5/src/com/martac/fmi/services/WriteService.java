package com.martac.fmi.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteService {
    private String pathToFile;

    public WriteService(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void write(String s) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToFile, true));

        if (!s.equals("\n")) {
            bufferedWriter.write(s + ",");
        } else {
            bufferedWriter.write(s);
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
