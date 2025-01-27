package dev.nyanchuk.controller;

import dev.nyanchuk.model.*;
import dev.nyanchuk.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TollControllerTest {

    private TollStation tollStation;
    private TollService tollService;
    private TollController tollController;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("Highway Toll", "Los Angeles");
        tollService = new TollService(tollStation);
        tollController = new TollController(tollService);
    }

    @Test
    public void testAddCar() {
        tollController.addVehicle("car", "CAR123", 0);

        assertEquals(100.0, tollStation.getTotal());
        assertEquals(1, tollStation.getVehicles().size());
        assertEquals("CAR123", tollStation.getVehicles().get(0).getNumber());
    }

    @Test
    public void testAddMotorcycle() {
        tollController.addVehicle("motorcycle", "MOTO456", 0);

        assertEquals(50.0, tollStation.getTotal());
        assertEquals(1, tollStation.getVehicles().size());
        assertEquals("MOTO456", tollStation.getVehicles().get(0).getNumber());
    }

    @Test
    public void testAddTruck() {
        tollController.addVehicle("truck", "TRUCK789", 4);

        assertEquals(200.0, tollStation.getTotal());
        assertEquals(1, tollStation.getVehicles().size());
        assertEquals("TRUCK789", tollStation.getVehicles().get(0).getNumber());
    }

    @Test
    public void testInvalidVehicle() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            tollController.addVehicle("bike", "BIKE001", 0);
        });

        assertEquals("Unknown vehicle type: bike", exception.getMessage());
    }

    @Test
    public void testShowReport() {
        tollController.addVehicle("car", "CAR001", 0);
        tollController.addVehicle("motorcycle", "MOTO002", 0);

        tollController.showReport();

        assertEquals(150.0, tollStation.getTotal());
    }
}
