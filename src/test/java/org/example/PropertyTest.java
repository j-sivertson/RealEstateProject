package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    Property property;

    @BeforeEach
    void setUp() {
        property = new Condo("Street Address", "84092", 1, 1, 1, 1);
    }

    @Test
    void testDefaultConstructor() {
        property = new Condo();
        assertEquals("", property.getStreetAddress());
        assertEquals("", property.getZip());
    }

    @Test
    void testConstructor() {
        assertEquals("Street Address", property.getStreetAddress());
    }

    @Test
    void getStreetAddress() {
        assertEquals("Street Address", property.getStreetAddress());
    }

    @Test
    void setStreetAddress() {
        property.setStreetAddress("New Street Address");
        assertEquals("New Street Address", property.getStreetAddress());
    }

    @Test
    void getZip() {
        assertEquals("84092", property.getZip());
    }

    @Test
    void setZip() {
        property.setZip("84091");
        assertEquals("84091", property.getZip());
    }

    @Test
    void setAppraisalPrice() {
        property.setAppraisalPrice(2.00);
        assertEquals(2.00, property.getAppraisalPrice(), 0.01);
    }

    @Test
    void getListPrice() {
        assertEquals(0.00, property.getListPrice());
    }

    @Test
    void setListPrice() {
        property.setListPrice(1.00);
        assertEquals(1.00, property.getListPrice());
    }
}
