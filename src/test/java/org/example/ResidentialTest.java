package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResidentialTest {

    Residential residential;

    @BeforeEach
    void setUp() {
        residential = new Condo("Street Address", "84092", 1, 1, 1,1);
    }

    @Test
    void testDefaultConstructor() {
        residential = new Condo();
        assertEquals("", residential.getStreetAddress());
        assertEquals("", residential.getZip());
        assertEquals(0, residential.getBedCount());
        assertEquals(0, residential.getBedCount());
        assertEquals(0, residential.getSqFootage());
    }

    @Test
    void testConstructor() {
        assertEquals("Street Address", residential.getStreetAddress());
        assertEquals("84092", residential.getZip());
        assertEquals(1, residential.getBedCount());
        assertEquals(1, residential.getBedCount());
        assertEquals(1, residential.getSqFootage());
    }

    @Test
    void getBedCount() {
        assertEquals(1, residential.getBedCount());
    }

    @Test
    void getBathCount() {
        assertEquals(1, residential.getBedCount());
    }

    @Test
    void getSqFootage() {
        assertEquals(1, residential.getSqFootage());
    }

    @Test
    void setBedCount() {
        residential.setBedCount(2);
        assertEquals(2, residential.getBedCount());
    }

    @Test
    void setBathCount() {
        residential.setBathCount(2);
        assertEquals(2, residential.getBathCount());
    }

    @Test
    void setSqFootage() {
        residential.setSqFootage(2);
        assertEquals(2, residential.getSqFootage());
    }
}
