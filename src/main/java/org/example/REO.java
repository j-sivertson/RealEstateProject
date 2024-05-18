package org.example;

import java.util.Random;
import java.util.Scanner;

import static org.example.Utilities.*;

public class REO {

    //Attributes
    public static Listings reoListings = new Listings(); //Creating a new instance of the Listings class

    public static void main(String[] args) {

        Scanner sIn = new Scanner(System.in); //Creating scanner for the users input

        //Loop to display options
        boolean done = true;
        while(done) {

            //Creating header
            String header = "----------------------------------------\n";
            header += "             Main Menu                     ";
            header += "\n----------------------------------------\n";
            System.out.print(header);

            //Creating options
            System.out.println("1. Listings");
            System.out.println("2. Bids");
            System.out.println(); //Empty line

            System.out.print("What would you like to do? (1-2): ");

            String choice = sIn.nextLine(); //Getting the users input

            switch (choice) {
                case "1":
                    listingsMenu();
                    System.out.println(); //Empty line
                    break;
                case "2":
                    bidsMenu();
                    System.out.println(); //Empty line
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number from 1-2.\n");
            } //End of switch statement

        } //END of while loop

    }//END of main method

    public static void listingsMenu() {
        Scanner sIn = new Scanner(System.in); //Creating scanner for the users input

        //Loop to display options
        boolean done = false;
        while(!done) {

            //Creating header
            String header = "----------------------------------------\n";
            header += "             Listings                     ";
            header += "\n----------------------------------------\n";
            System.out.print(header);

            //Creating options
            System.out.println("1. Adding Listings");
            System.out.println("2. Show Listing");
            System.out.println("3. Auto Populate Listings (Dev tool)");
            System.out.println(); //Empty line
            System.out.println("ENTER: Exit back to previous menu");
            System.out.println(); //Empty line

            System.out.print("What would you like to do? (1-3): ");

            String choice = sIn.nextLine(); //Getting the users input

            switch (choice) {
                case "1":
                    addListingMenu();
                    break;
                case "2":
                    showListingsMenu();
                    break;
                case "3":
                    autoPopulateMenu();
                    break;
                case "":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number from 1-3.\n");
            } //End of switch statement

        } //END of while loop

    }//END of userListing method

    public static void addListingMenu() {
        Scanner sIn = new Scanner(System.in); //Creating scanner for the users input

        boolean done = false;
        while (!done) {

            //Creating header
            String header = "----------------------------------------\n";
            header += "             Add Listings                     ";
            header += "\n----------------------------------------\n";
            System.out.print(header);

            //Creating options
            System.out.println("1. Add House");
            System.out.println("2. Add Condo");
            System.out.println("ENTER: Exit back to previous menu");
            System.out.println(); //Empty line

            System.out.print("What would you like to do? (1-2): ");

            String choice = sIn.nextLine(); //Getting the users input

            switch (choice) {
                case "1":
                    addHouseMenu();
                    break;
                case "2":
                    addCondoMenu();
                    break;
                case "":
                    done = true;
                default:
                    System.out.println("Invalid input. Please enter a number from 1-2.\n");
            } //END of switch statement
        } //END of while loop
    }//END of addListingMenu method

    private static void showListingsMenu() {

        //Creating header
        System.out.println("Current Listings for REO:");

        //Loop through the listings and print out the details
        int listingNumber = 1;
        for(Residential residence : reoListings.getResidences()) {
            System.out.println("Listing Number: " + listingNumber); //Print listing number
            System.out.println(residence.toString()); //Print out the details of the listing
            listingNumber++; //Increment the listing number
        }
    }

    private static void autoPopulateMenu() {
        //Creating a new instance of the House class
        House house1 = new House("123 Main St", "12345", 3, 2, 2000, 1.5);
        house1.setAppraisalPrice(house1.calculateAppraisalPrice());
        house1.setListPrice(250000.00);
        reoListings.addListing("123 Main St", house1);

        //Creating a new instance of the House class
        House house2 = new House("456 Elm St", "54321", 4, 3, 3000, 2.5);
        house2.setAppraisalPrice(house2.calculateAppraisalPrice());
        house2.setListPrice(350000.00);
        reoListings.addListing("456 Elm St", house2);

        //Creating a new instance of the Condo class
        Condo condo1 = new Condo("789 Oak St", "67890", 2, 2, 1500, 3);
        condo1.setAppraisalPrice(condo1.calculateAppraisalPrice());
        condo1.setListPrice(200000.00);
        reoListings.addListing("789 Oak St", condo1);

        //Creating a new instance of the Condo class
        Condo condo2 = new Condo("101 Pine St", "09876", 1, 1, 1000, 1);
        condo2.setAppraisalPrice(condo2.calculateAppraisalPrice());
        condo2.setListPrice(150000.00);
        reoListings.addListing("101 Pine St", condo2);

        System.out.println("\nListings have been auto-populated.\n");
    }

    public static void addHouseMenu() {

        //Asking the user for the details of the house
        Scanner input = new Scanner(System.in); //Creating scanner for the users input

        //Ask user for the details of the house
        System.out.print("Enter the street address: ");
        String streetAddress = input.nextLine();
        System.out.print("Enter the zip code: ");
        String zip = input.nextLine();
        int bedCount = getValidInt("Enter the bed count: ", "Invalid response. Only whole numbers are acceptable.");
        int bathCount = getValidInt("Enter the bath count: ", "Invalid response. Only whole numbers are acceptable.");
        int sqFootage = getValidInt("Enter the square footage: ", "Invalid response. Only whole numbers are acceptable.");
        double yardAcres = getValidDouble("Enter the yard size in acres: ", "Invalid response. Only decimal-point numbers are acceptable.");
        System.out.println(); //Empty line

        //Creating a new instance of the House class
        House house = new House(streetAddress, zip, bedCount, bathCount, sqFootage, yardAcres);
        house.setAppraisalPrice(house.calculateAppraisalPrice());

        //Printing out final details and confirming with the user that they have created a new listing
        System.out.printf("Appraisal Price for this property is: $%,.2f\n", house.calculateAppraisalPrice());
        double listPrice = getValidDouble("Please enter the List Price for the property: ", "Invalid response. Only decimal-point numbers are acceptable.");
        house.setListPrice(listPrice); //Setting the list price
        System.out.println(); //Empty line
        System.out.print("You have created a new listing!\n");

        reoListings.addListing(streetAddress, house); //Adding the house to the listings

        //Printing out the home instance
        System.out.print(house.toString());

        System.out.print("\n\n\n"); //Empty lines
    }

    public static void addCondoMenu() {

        //Asking the user for the details of the condo
        Scanner input = new Scanner(System.in); //Creating scanner for the users input

        //Ask user for the details of the house
        System.out.print("Enter the street address: ");
        String streetAddress = input.nextLine();
        System.out.print("Enter the zip code: ");
        String zip = input.nextLine();
        int bedCount = getValidInt("Enter the bed count: ", "Invalid response. Only whole numbers are acceptable.");
        int bathCount = getValidInt("Enter the bath count: ", "Invalid response. Only whole numbers are acceptable.");
        int sqFootage = getValidInt("Enter the square footage: ", "Invalid response. Only whole numbers are acceptable.");
        int floorLvl = getValidInt("Enter the floor level of the condo: ", "Invalid response. Only whole numbers are acceptable.");
        System.out.println(); //Empty line

        //Creating a new instance of the House class
        Condo condo = new Condo(streetAddress, zip, bedCount, bathCount, sqFootage, floorLvl);
        condo.setAppraisalPrice(condo.calculateAppraisalPrice());

        //Printing out final details and confirming with the user that they have created a new listing
        System.out.printf("Appraisal Price for this property is: $%,.2f\n", condo.calculateAppraisalPrice());
        double listPrice = getValidDouble("Please enter the List Price for the property: ", "Invalid response. Only decimal-point numbers are acceptable.");
        condo.setListPrice(listPrice); //Setting the list price
        System.out.println(); //Empty line
        System.out.print("You have created a new listing!\n");

        reoListings.addListing(streetAddress, condo); //Adding the condo to the listings

        //Printing out the home instance
        System.out.print(condo.toString());

        System.out.print("\n\n\n"); //Empty lines
    }

    public static void bidsMenu() {
        Scanner sIn = new Scanner(System.in); //Creating scanner for the users input

        boolean done = false;
        while (!done) {

            //Creating header
            String header = "----------------------------------------\n";
            header += "             Bids                     ";
            header += "\n----------------------------------------\n";
            System.out.print(header);

            //Creating options
            System.out.println("1. Add New Bid");
            System.out.println("2. Show Existing Bids");
            System.out.println("3. Auto Populate Bids (Dev tool)");
            System.out.println("ENTER: Exit back to previous menu");
            System.out.println(); //Empty line

            System.out.print("What would you like to do? (1-3): ");

            String choice = sIn.nextLine(); //Getting the users input

            switch (choice) {
                case "1":
                    addBidMenu();
                    break;
                case "2":
                    showBidMenu();
                    break;
                case "3":
                    autoPopulateBidMenu();
                    break;
                case "":
                    done = true;
                default:
                    System.out.println("Invalid input. Please enter a number from 1-3.\n");
            } //END of switch statement
        } //END of while loop
    }//END of bidsMenu method

    private static void addBidMenu() {
        System.out.print("\n\nCurrent Listings for REO:\n\n");
        boolean done = false;
        while (!done) {
            String header = "No.     Property(bids)\n";
            header += "----------------------\n";
            System.out.print(header);

            //Loop through the listings and print out the details
            int listingNumber = 1;
            for (Residential residence : reoListings.getResidenceList()) {
                System.out.print(String.format("%s:     %s (%s)\n", listingNumber, residence.getStreetAddress(), residence.geteBidCount()));
                listingNumber++; //Increment the listing number
            }
            System.out.println(); //Empty line

            //Ask the user for the listing they would like to bid on
            Scanner sIn = new Scanner(System.in); //Creating scanner for the users input
            System.out.println("ENTER: Exit to get back to the previous menu");
            System.out.print("What listing would you like to bid on?: ");
            String input = sIn.nextLine(); //Getting the users input

            if (input.equals("")) { //First validation check
                System.out.println(); //Empty line
                return; //Return to the previous menu
            }

            //Check for input validation
            int propertyIndex = 0;
            propertyIndex = checkValidInt(sIn, input); //First input validation check
            propertyIndex = checkValidIndex(sIn, propertyIndex); //Second input validation check

            // Retrieve the chosen Residential object
            Residential chosenResidence = reoListings.getListingByIndex(propertyIndex - 1);
            System.out.print(chosenResidence.toString());
            System.out.println("\n"); //Empty line

            // Ask the user for the bid information
            System.out.print("Please enter the name of the bidder: ");
            Scanner sIn2 = new Scanner(System.in); //Creating scanner for the users input
            String bidder = sIn2.nextLine();
            double bidAmount = getValidDouble("Please enter the bid amount: ", "Invalid response. Only decimal-point numbers are acceptable.");

            // Add the bid to the chosen residence
            chosenResidence.newBid(bidder, bidAmount);

            System.out.println("Bid has been added to the listing.\n"); //Show confirmation message
        }
    }

    private static void showBidMenu() {
        //Print out the header
        System.out.println("\n\nCurrent Listings for REO:\n\n");
        String header = "No.     Property(bids)\n";
        header += "----------------------\n";
        System.out.print(header);

        //Loop through the listings and print out the details
        int listingNumber = 1;
        for (Residential residence : reoListings.getResidenceList()) {
            System.out.print(String.format("%s:     %s (%s)\n", listingNumber, residence.getStreetAddress(), residence.geteBidCount()));
            listingNumber++; //Increment the listing number
        }
        System.out.println(); //Empty line

        //Ask the user for the listing they would like to see the bids for
        Scanner sIn = new Scanner(System.in); //Creating scanner for the users input
        System.out.println("ENTER: Exit to get back to the previous menu");
        System.out.print("For which property would you like to see the current bids? ");
        String input = sIn.nextLine(); //Getting the users input

        if (input.equals("")) {
            System.out.println("\n"); //Empty line
            return; //Return to the previous menu
        }

        //Check for input validation
        int propertyIndex = 0;
        propertyIndex = checkValidInt(sIn, input); //First input validation check
        propertyIndex = checkValidIndex(sIn, propertyIndex); //Second input validation check

        // Retrieve the chosen Residential object
        Residential chosenResidence = reoListings.getListingByIndex(propertyIndex - 1);
        System.out.print(chosenResidence.toString());
        System.out.println("\n"); //Empty line

        chosenResidence.displayBids(chosenResidence); //Display bids for the chosen residence
    }

    private static void autoPopulateBidMenu() {
        //Hard Coded set of names to be used as bidders
        String[] autoBidders = {"Patric Stewart", "Walter Koenig", "William Shatner", "Leonard Nimoy", "DeForect Kelley", "James Doohan", "George Takei", "Majel Barrett", "Nichelle Nichol", "Jonathan Frank"
                , "Marina Sirtis", "Brent Spiner", "Gates McFadden", "Michael Dorn", "LeVar Burton", "Wil Wheaton", "Colm Meaney", "Michelle Forbes"};

        for (int i = 0; i < 30; i++) {

            //Create an object of type Random,  r
            Random r = new Random();

            //Randomly select a number between 0 and the length of the autoBidders list - 1.  This will be your random index into the array
            int index = r.nextInt((autoBidders.length - 1) + 1);

            //Get a random listing from the listings
            Residential res = reoListings.getListingByIndex(r.nextInt(reoListings.getListCount()));

            //Use the random index number to select a random bidder and use the appraisal price * some percentage to generate a bid amount.
            res.newBid(autoBidders[index], res.calculateAppraisalPrice() * 1.03);
        } //END of for loop

        System.out.println("Bids have been auto-populated.\n");
    } //END of autoPopulateBidMenu method

}//END of class


