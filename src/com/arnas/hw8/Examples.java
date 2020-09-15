package com.arnas.hw8;

import java.io.*;
import java.util.Arrays;

public class Examples {
    // Pavyzdžių skaidrėse testavimas

    public static void main(String[] args) {
        // Pirmas pavyzdys su Try/ Catch/ Finally

        // System.out.println("... Pirmas pavyzdys: try / catch / finally");
        // int res;
        // try {
        //     // ... pavojingas kodas
        //     res = 1 / 0; // ArithmeticException: / by zero
        // } catch (Exception e){
        //         System.err.println("Pirmame pavyzdyje įvyko klaida!");
        // } finally {
        //     // finally blokas bus iškviestas, net jei darysime res = 1 / 1;
        //     // … ir net jei nebus catch bloko
        //     System.out.println("Finally blokas!");
        // }
        // System.out.println("Programos pabaiga!");

        // Antras pavyzdys su Working Directory

        System.out.println("... Antras pavyzdys su Working Directory");
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Trečias pavyzdys su Failų skaitymu (Read)
        System.out.println("... Trečias pavyzdys su Failų skaitymu (Read)");
        // ... sukuriu failo objektą, kuris laiko info kur failas randasi
        File relativeFile = new File("./data/c.csv");
        try {
            // standartinis būdas gauti duomenis iš teksitinio failo javoje
            FileReader fileReader = new FileReader(relativeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // skaitome eilutė po eilutės su .readLine() metodu
            String fileLine = bufferedReader.readLine(); // "\n", "\r\n" - ieško newline
            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
                System.out.println(fileLine); // spausdiname visą eilutę

                // inicializuojame savo personų arraylistą su iš failo gautais duomenimis
                String[] splitString = fileLine.split(","); // fileLine.split("\\s;|\\s|;");

                // skaitome sekančią eilutę
                fileLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File was not found, check if it's there!");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Some general IO error!");
        }

        // Ketvirtas pavyzdys su Failų rašymu (Write)

        System.out.println("... Ketvirtas pavyzdys su Failų rašymu (Write)");
        File relativeFile2 = new File("./data/b.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2);
            BufferedWriter bw = new BufferedWriter(fw);
            String fileLine = "Mindaugas";
            bw.write(fileLine);

            // writting file with newline
            String fileLine2 = "Mindaugas\n";
            bw.write(fileLine2);
            bw.write("Jonas");
            bw.newLine();
            bw.write("Antanas");
            bw.write("\n");
            bw.write("Petras"); // neprideda new line
            // bw.flush();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Penktas pavyzdys su Failų pildymu/atnaujinimu (Append)

        System.out.println("... Penktas pavyzdys su Failų pildymu/atnaujinimu (Append)");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./data/b.csv"), true));
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
