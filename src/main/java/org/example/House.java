package org.example;

public class House extends Residential{

    //Attributes
    double yardAcres;
    //Constructors
    House() {
        super();
        yardAcres = 0.0;
    }

    public House(String streetAddress, String zip,  int bedCount, int bathCount, int sqFootage, double yardAcres) {
        super(streetAddress, zip, bedCount, bathCount, sqFootage);
        this.yardAcres = yardAcres;
    }
    //Getters and Setters

    public double getYardAcres() {
        return yardAcres;
    }

    public void setYardAcres(double yardAcres) {
        this.yardAcres = yardAcres;
    }

    //Methods
    @Override
    public double calculateAppraisalPrice() {
        double total = (97.00 * this.getSqFootage() + (10000.00 * this.getBedCount()) + (12000.00 * this.getBathCount()));
        if(this.getYardAcres() >= 1){ //Check to see if the house has one acre or more of property and adds the price to the total
            total += (460000.00 * Math.floor(this.getYardAcres()));
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
        String body = String.format("Sq Footage: %s\nBedrooms: %s\nBathrooms: %s\nYard Size(Acres): %s", this.getSqFootage(), this.getBedCount(), this.getBathCount(), this.getYardAcres());
        body += "\n----------------------------------------\n";
        output += body;
        //Creating footer
        String footer = String.format("Appraisal Price: $%,.2f\nList Price: $%,.2f", this.getAppraisalPrice(), this.getListPrice());
        footer += "\n----------------------------------------\n";
        output += footer;

        return output;
    }
}
