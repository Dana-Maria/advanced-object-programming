package com.martac.fmi.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadService {
    BufferedReader bufferedReader;
    private String pathToFile;

    public ReadService(String pathToFile) throws FileNotFoundException {
        this.pathToFile = pathToFile;

        bufferedReader = new BufferedReader(new FileReader(pathToFile));
    }

    public String[] readLine() throws IOException {
        if (bufferedReader != null) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] splitLine = line.split(",");
                return splitLine;
            }
            else {
                bufferedReader.close();
            }
        }

        return null;
    }
}
