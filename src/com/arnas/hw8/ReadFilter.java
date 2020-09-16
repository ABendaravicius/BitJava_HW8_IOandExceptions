package com.arnas.hw8;

import java.io.*;
import java.util.ArrayList;

public class ReadFilter {

    public static void main(String[] args) {
        File readFile = new File("./data/data.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(readFile));
            // Failo skaitymas
            System.out.println("... Failo skaitymas:");
            // Arraylist failo informacijos laikymui
            ArrayList<String> readList = new ArrayList<String>();

            String nextLine = fileReader.readLine();
            while (nextLine != null) {
                System.out.println(nextLine);
                readList.add(nextLine);
                nextLine = fileReader.readLine();
            }

            // Failo filtravimas
            System.out.println("... Failo filtravimas");
            // Arraylist filtruotos informacijos laikymui
            ArrayList<String> filterList = new ArrayList<String>();

            readList.forEach((line) ->  {
                String[] currentLine = line.split(" ");
                int currentAge = Integer.parseInt(currentLine[1]);
                if (currentAge > 18) {
                    filterList.add(line);
                }
            });

            // Filtruotų duomenų rašymas į naują failą
            File filteredFile = new File("./data/filteredData.csv");

            filterList.forEach((line) -> {
                try {
                    System.out.println(line);
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filteredFile, true));
                    fileWriter.write(line);
                } catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            });

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
