package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Residential extends Property implements Bidable {
//Class Attributes
    public static HashMap<String, Double> bids = new HashMap<>();
//Attributes
    private int bedCount;
    private int bathCount;
    private int sqFootage;
    int bidCount = 0;

    //Constructors
    Residential() {
        super();
        bedCount = 0;
        bathCount = 0;
        sqFootage = 0;
    }

    public Residential(String streetAddress, String zip,  int bedCount, int bathCount, int sqFootage) {
        super(streetAddress, zip);
        this.bedCount = bedCount;
        this.bathCount = bathCount;
        this.sqFootage = sqFootage;
    }

    public int getBedCount() {
        return bedCount;
    }

    public int getBathCount() {
        return bathCount;
    }

    public int getSqFootage() {
        return sqFootage;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public void setBathCount(int bathCount) {
        this.bathCount = bathCount;
    }

    public void setSqFootage(int sqFootage) {
        this.sqFootage = sqFootage;
    }

    //Methods
    public abstract double calculateAppraisalPrice();

    public HashMap<String,Double> getBids() {
        return bids;
    }

    public Double getBid(String bidder) {
        return bids.get(bidder);
    }

    public Set<String> getBidders() {
        return bids.keySet();
    }

    public int getBidCount() {
        return bids.size();
    }

    public int geteBidCount() {
        return bidCount;
    }
    public void newBid(String bidder, Double bid) {
        bids.put(bidder, bid);
        bidCount++;
    }

    public void displayBids(Residential chosenResidence) {
        String header = "Current Bids for this listing:\n";
        header = "-".repeat(40) + "\n";
        header += String.format("\t\tBidder\t\t     Bid");
        header += "\n" + "-".repeat(40) + "\n";
        System.out.println(header);


    }
}
