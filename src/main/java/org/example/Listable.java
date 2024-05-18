package org.example;

import java.util.HashMap;
import java.util.Set;

public interface Listable {

    public HashMap<String, Residential> getListings();

    public HashMap<String, Residential> getListing(String address);

    public Set<String> getStreetAddresses();

    public Set<String> getResidences();

    public int getListCount();

    public void addListing(String address, Residential residence);
}
