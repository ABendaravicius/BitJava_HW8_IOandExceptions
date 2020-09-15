package com.arnas.hw8;

import java.io.IOException;
import java.util.Scanner;

public class CustomException {

    public static class ProhibitedInputTypeException extends Exception {

        public ProhibitedInputTypeException() {
            super("Expected text type input, got number instead.");
        }
    }

    public static void main(String[] args) {

        try {
            String userInput = checkInput();
            System.out.println("Jūs įvedėte: " + userInput + ".\nJūsų įvestas tekstas yra tinkamas.");
        } catch(ProhibitedInputTypeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String checkInput() throws ProhibitedInputTypeException {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Įveskite tekstą: ");

        if (inputScanner.hasNextInt()) {
            throw new ProhibitedInputTypeException();
        } else {
            String input = inputScanner.nextLine();
            return input;
        }
    }
}
