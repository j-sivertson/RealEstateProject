package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    House house;

    @BeforeEach
    void setUp() {
        house = new House("Street Name","84092", 1, 1, 1, 1.0);
    }

    @Test
    void testDefaultConstructor() {
        house = new House();
        assertEquals("", house.getStreetAddress());
        assertEquals("", house.getZip());
        assertEquals(0, house.getBedCount());
        assertEquals(0, house.getBathCount());
        assertEquals(0, house.getSqFootage());
        assertEquals(0, house.getYardAcres());
    }

    @Test
    void testConstructor() {
        assertEquals("Street Name", house.getStreetAddress());
        assertEquals("84092", house.getZip());
        assertEquals(1, house.getBedCount());
        assertEquals(1, house.getBathCount());
        assertEquals(1, house.getSqFootage());
        assertEquals(1.0, house.getYardAcres());

    }

    @Test
    void getYardAcres() {
        assertEquals(1.0, house.getYardAcres());
    }

    @Test
    void setYardAcres() {
        house.setYardAcres(2.0);
        assertEquals(2.0, house.getYardAcres());
    }

    @Test
    void testCalculateAppraisalPrice() {
        assertEquals(482097.00, house.calculateAppraisalPrice(), 0.01); //For one acre
        house.setYardAcres(0.5);
        assertEquals(22097, house.calculateAppraisalPrice()); //For less than one acre
        house.setYardAcres(1.1);
        assertEquals(482097.00, house.calculateAppraisalPrice(), 0.01); //For more than 1 acre but less than 2
    }
}
