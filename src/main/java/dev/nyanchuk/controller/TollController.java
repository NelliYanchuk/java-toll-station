package dev.nyanchuk.controller;

import dev.nyanchuk.model.*;
import dev.nyanchuk.service.*;

public class TollController {
    private final TollService tollService;

    public TollController(TollService tollService) {
        this.tollService = tollService;
    }

    public void addVehicle(String type, String number, int axles) {
        Vehicle vehicle;
        switch (type.toLowerCase()) {
            case "car":
                vehicle = new Car(number);
                break;
            case "motorcycle":
                vehicle = new Motorcycle(number);
                break;
            case "truck":
                vehicle = new Truck(number, axles);
                break;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        tollService.processVehicle(vehicle);
    }

    public void showReport() {
        tollService.generateReport();
    }
}
