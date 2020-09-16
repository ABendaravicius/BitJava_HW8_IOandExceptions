package com.arnas.hw8;

import java.io.*;
import java.util.ArrayList;

public class ReadFilter {

    public static void main(String[] args) {
        File readFile = new File("./data/data.csv");

        // Arraylist failo informacijos laikymui
        ArrayList<String> readList = new ArrayList<String>();

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(readFile));
            // Failo skaitymas
            System.out.println("... Failo skaitymas:");

            String nextLine = fileReader.readLine();
            while (nextLine != null) {
                System.out.println(nextLine);
                readList.add(nextLine);
                nextLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        // Failo filtravimas
        System.out.println("... Failo filtravimas (įrašomi tik asmenys, kurių amžius > 18");
        // Arraylist filtruotos informacijos laikymui
        ArrayList<String> filterList = new ArrayList<String>();

        int currentAge;
        String[] currentLine;
        for (String line : readList) {
            currentLine = line.split(" ");
            currentAge = Integer.parseInt(currentLine[1]);
            if (currentAge > 18) {
                filterList.add(line);
            }
        }

        // Filtruotų duomenų rašymas į naują failą
        File filteredFile = new File("./data/filteredData.csv");

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filteredFile));
            for (String line : filterList) {
                fileWriter.write(line + "\n");
                System.out.println(line);
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
