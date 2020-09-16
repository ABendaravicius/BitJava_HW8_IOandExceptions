package com.arnas.hw8;

import java.io.*;
import java.util.Scanner;

public class InputWrite {

    public static void main (String[] args) {
        // Rašymas į failą iš konsolėje pateikto input'o

        File writtenFile = new File("./data/textFromConsole.txt"); // file to write to
        Scanner inputScan = new Scanner(System.in); // input scanner

        try {
            BufferedWriter inputWriter = new BufferedWriter(new FileWriter(writtenFile, true));

            System.out.println("Teksto rašymas į failą pradėtas. (Įrašykite 'quit' jeigu norite nutraukti rašymą į failą)");
            String userInput = inputScan.nextLine(); // read input from console
            while (userInput != null) { // check if input is not null
                if (!userInput.equals("quit")) {
                    inputWriter.write(userInput + "\n"); // append input to file and insert line break
                    userInput = inputScan.nextLine();
                } else { // if input equals 'quit' terminate the program
                    inputWriter.close();
                    break;
                }
            }
            System.out.println("... Programos pabaiga.");
        } catch(IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}
