package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CondoTest {

    Condo condo;

    @BeforeEach
    void beforeEach() {
        condo = new Condo("Street Name", "84092", 1,1,1,1);
    }

    @Test
    void testDefaultConstructor() {
        condo = new Condo();
        assertEquals("" , condo.getStreetAddress());
        assertEquals(0 , condo.getBedCount());
        assertEquals(0, condo.getBathCount());
        assertEquals(0, condo.getSqFootage());
        assertEquals(0, condo.getFloorLvl());
    }

    @Test
    void testConstructor() {
        assertEquals("Street Name" , condo.getStreetAddress());
        assertEquals(1 , condo.getBedCount());
        assertEquals(1, condo.getBathCount());
        assertEquals(1, condo.getSqFootage());
        assertEquals(1, condo.getFloorLvl());
    }

    @Test
    void getFloorLvl() {
        assertEquals(1, condo.getFloorLvl());
    }

    @Test
    void setFloorLvl() {
        condo.setFloorLvl(2);
        assertEquals(2, condo.getFloorLvl());
    }

    @Test
    void testCalculateAppraisalPrice() {
        assertEquals(18088.00, condo.calculateAppraisalPrice(), 0.01); //For one level
        condo.setFloorLvl(2);
        assertEquals(23088.00, condo.calculateAppraisalPrice(), 0.01); //For two levels
    }
}