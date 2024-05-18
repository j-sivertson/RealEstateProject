package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.REO.reoListings;

public class Utilities {

    public static int getValidInt(String question, String warning) {

        Scanner numberScanner = new Scanner(System.in); //Creating number scanner

        //variables
        boolean valid = false;

        int intInput = 0;

        do {
            System.out.print(question);

            if(numberScanner.hasNextInt()) {
                intInput = numberScanner.nextInt();
                valid = true;

            }
            else {
                System.out.println(warning);
                numberScanner.next();
            } // end of if and else statement
        } while (!valid); // end of do while loop

        return intInput;
    } // end of getValidInt method

    public static double getValidDouble(String question, String warning) {
        Scanner doubleScanner = new Scanner(System.in); // Creating number scanner

        // Variables
        double result = 0;
        boolean valid = false;

        String decimalPattern = "\\d+(\\.\\d{1,2})?|\\.\\d{1,2}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(decimalPattern);

        do {
            System.out.print(question);

            String input = doubleScanner.next(); // Read user input as string

            // Match the input against the pattern
            Matcher matcher = pattern.matcher(input);

            if (matcher.matches()) { // Check if input matches the pattern
                result = Double.parseDouble(input); // Convert string to double
                valid = true; // Set valid to true to exit the loop
            } else {
                System.out.println(warning);
            }
        } while (!valid);

        return result;
    } // End of getValidDouble method

    public static int checkValidInt( Scanner sIn, String input) {
        boolean validInt = false;
        int propertyIndex = 0;
        while (!validInt) {
            try {
                propertyIndex = Integer.parseInt(input); //Check to see if the input is a number
                validInt = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number from 1 to " + reoListings.getListCount() + ": ");
                input = sIn.nextLine();
            } //END of try and catch statement
        } //END of while loop
        return propertyIndex;
    } //END of checkValidInt method

    public static int checkValidIndex(Scanner sIn, int propertyIndex) {
        boolean validIndex = false;
        while (!validIndex) {
            if (propertyIndex <= 0 || propertyIndex > reoListings.getListCount()) {
                System.out.print("Invalid . Please enter a number from 1 to " + reoListings.getListCount() + ": ");
                propertyIndex = sIn.nextInt();
            } else {
                validIndex = true;
            } //END of if statement
        } //END of while loop
        return propertyIndex;
    } //END of checkValidIndex method
}
