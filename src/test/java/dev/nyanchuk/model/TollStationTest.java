package dev.nyanchuk.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TollStationTest {

    private TollStation tollStation;

    @BeforeEach
    public void setUp() {
        tollStation = new TollStation("Bridge", "San Francisco");
    }

    @Test
    public void testAddVehicle() {
        Vehicle car = new Car("CAR001");
        tollStation.addVehicle(car);

        assertEquals(100.0, tollStation.getTotal());
        List<Vehicle> vehicles = tollStation.getVehicles();
        assertEquals(1, vehicles.size());
        assertEquals(car, vehicles.get(0));
    }

    @Test
    public void testMultipleVehicles() {
        Vehicle car = new Car("CAR001");
        Vehicle motorcycle = new Motorcycle("MOTO001");
        Vehicle truck = new Truck("TRUCK001", 3);

        tollStation.addVehicle(car);
        tollStation.addVehicle(motorcycle);
        tollStation.addVehicle(truck);

        assertEquals(300.0, tollStation.getTotal());
        assertEquals(3, tollStation.getVehicles().size());
    }

    @Test
    public void testReportOutput() {
        Vehicle car = new Car("CAR001");
        Vehicle motorcycle = new Motorcycle("MOTO001");
        Vehicle truck = new Truck("TRUCK001", 2);

        tollStation.addVehicle(car);
        tollStation.addVehicle(motorcycle);
        tollStation.addVehicle(truck);

        tollStation.report();
        assertEquals(250.0, tollStation.getTotal());
    }
}
