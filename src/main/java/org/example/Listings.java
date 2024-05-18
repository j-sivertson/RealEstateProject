package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings {

    //Attributes
    private HashMap<String, Residential> listings;
    private ArrayList<Residential> residences;

    // Default Constructor
    Listings(){
        listings = new HashMap<>();
        residences = new ArrayList<>();
    }


    //Methods
    public HashMap<String, Residential> getListings(){
        return listings;
    }

    public Residential getListing(String address){
        return listings.get(address);
    }

    public Set<String> getStreetAddresses(){
        return listings.keySet();
    }

    public Collection<Residential> getResidences(){
        return listings.values();
    }

    public int getListCount(){
        return listings.size();
    }

    public void addListing(String address, Residential residence){
        listings.put(address, residence);
        residences.add(residence);
    }

    public Residential getListingByIndex(int index){
        return residences.get(index);
    }

    public ArrayList<Residential> getResidenceList(){
        return residences;
    }
}
