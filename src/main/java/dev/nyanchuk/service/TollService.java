package dev.nyanchuk.service;

import dev.nyanchuk.model.*;

public class TollService {
    private final TollStation tollStation;

    public TollService(TollStation tollStation) {
        this.tollStation = tollStation;
    }

    public void processVehicle(Vehicle vehicle) {
        tollStation.addVehicle(vehicle);
    }

    public double getTotalCollected() {
        return tollStation.getTotal();
    }

    public void generateReport() {
        tollStation.report();
    }
}
