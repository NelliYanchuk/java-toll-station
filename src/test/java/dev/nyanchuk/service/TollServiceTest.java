package dev.nyanchuk.service;

import dev.nyanchuk.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TollServiceTest {

    private TollStation tollStation;
    private TollService tollService;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("Main Gate", "New York");
        tollService = new TollService(tollStation);
    }

    @Test
    public void testProcessVehicle() {
        Vehicle car = new Car("CAR001");
        tollService.processVehicle(car);

        assertEquals(100.0, tollService.getTotalCollected());
        assertEquals(1, tollStation.getVehicles().size());
        assertEquals(car, tollStation.getVehicles().get(0));
    }

    @Test
    public void testTotalCollected() {
        tollService.processVehicle(new Car("CAR001"));
        tollService.processVehicle(new Motorcycle("MOTO001"));
        tollService.processVehicle(new Truck("TRUCK001", 3));

        assertEquals(300.0, tollService.getTotalCollected());
    }

    @Test
    public void testGenerateReport() {
        tollService.processVehicle(new Car("CAR001"));
        tollService.processVehicle(new Motorcycle("MOTO001"));
        tollService.generateReport();

        assertEquals(150.0, tollService.getTotalCollected());
    }
}
