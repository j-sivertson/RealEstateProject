package org.example;

public class Condo extends Residential{

    //Attributes
    int floorLvl;
    //Constructors
    Condo() {
        super();
        this.floorLvl = 0;
    }

    public Condo(String streetAddress, String zip, int bedCount, int bathCount, int sqFootage, int floorLvl) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.floorLvl = floorLvl;
    }
    //Getters and Setters

    public int getFloorLvl() {
        return floorLvl;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    //Methods
    @Override
    public double calculateAppraisalPrice() {
        double total = (88.00 * this.getSqFootage() + (8000.00 * this.getBedCount()) + (10000.00 * this.getBathCount()));
        if(this.getFloorLvl() > 1) { //Check to see if the condo has
            total += (5000.00 * (this.getFloorLvl() - 1));
        }
        this.setAppraisalPrice(total);
        return total;
    }

    @Override
    public String toString() {
        String output = "";
        //Creating header
        String header = "------------------------------------------------------------------------\n";
        header += String.format("Residence Type: %s\tAddress: %s\t\tZip Code: %s", this.getClass().getSimpleName(), this.getStreetAddress(), this.getZip());
        header += "\n------------------------------------------------------------------------\n";
        output += header;
        //Creating body
        String body = String.format("Sq Footage: %s\nBedrooms: %s\nBathrooms: %s\nFloor: %s", this.getSqFootage(), this.getBedCount(), this.getBathCount(), this.getFloorLvl());
        body += "\n----------------------------------------\n";
        output += body;
        //Creating footer
        String footer = String.format("Appraisal Price: $%,.2f\nList Price: $%,.2f", this.getAppraisalPrice(), this.getListPrice());
        footer += "\n----------------------------------------\n";
        output += footer;

        return output;
    }
}
