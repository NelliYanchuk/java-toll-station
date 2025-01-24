package dev.nyanchuk.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    @Test
    public void testCar() {
        Vehicle car = new Car("ABC123");
        assertEquals(100.0, car.calculateToll());
    }

    @Test
    public void testMotorcycle() {
        Vehicle motorcycle = new Motorcycle("XYZ789");
        assertEquals(50.0, motorcycle.calculateToll());
    }

    @Test
    public void testTruck() {
        Vehicle truck = new Truck("LMN456", 4);
        assertEquals(200.0, truck.calculateToll());
    }

    @Test
    public void testTruckWithOneAxle() {
        Vehicle truck = new Truck("AXLE001", 1);
        assertEquals(50.0, truck.calculateToll());
    }

    @Test
    public void testTruckInvalidAxles() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Truck("INVALID", 0);
        });
        assertEquals("Number of axles must be greater than 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Truck("INVALID", -2);
        });
        assertEquals("Number of axles must be greater than 0", exception.getMessage());
    }

    @Test
    public void testVehicleGetNumber() {
        Vehicle car = new Car("CAR123");
        assertEquals("CAR123", car.getNumber());

        Vehicle motorcycle = new Motorcycle("MOTO456");
        assertEquals("MOTO456", motorcycle.getNumber());

        Vehicle truck = new Truck("TRUCK789", 3);
        assertEquals("TRUCK789", truck.getNumber());
    }
}