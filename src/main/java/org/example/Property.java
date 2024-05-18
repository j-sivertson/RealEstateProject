package org.example;

public abstract class Property {
    //Attributes
    private String streetAddress;
    private String zip;
    private double listPrice;
    private double appraisalPrice;

    //Constructors
    Property() {
        streetAddress = "";
        zip = "";
        listPrice = 0.0;
        appraisalPrice = 0.0;

    }

    public Property(String streetAddress, String zip) {
        this.streetAddress = streetAddress;
        this.zip = zip;
        listPrice = 0.0; // Setting both listPrice and appraisalPrice to zero because we may not know these two fields when they are first initialized
        appraisalPrice = 0.0;
    }

    //Getters first and then Setters

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getZip() {
        return this.zip;
    }

    public double getListPrice() {
        return this.listPrice;
    }

    public double getAppraisalPrice() {
        return this.appraisalPrice;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    protected void setAppraisalPrice(double appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }

    //Methods

    public abstract double calculateAppraisalPrice();
}
