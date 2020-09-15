package com.arnas.hw8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InputOutput {
    public static void main(String[] args) {

        File readFile = new File("./data/data.csv");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFile));
            String fileLine = reader.readLine();
            while (fileLine != null) {
                System.out.println(fileLine);
                fileLine = reader.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
