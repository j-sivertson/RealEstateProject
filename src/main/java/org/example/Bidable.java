package org.example;

import java.util.HashMap;
import java.util.Set;

public interface Bidable {

    public HashMap<String,Double> getBids();

    public Double getBid(String bidder);

    public Set<String> getBidders();

public int getBidCount();

public void newBid(String bidder, Double bid);
}
