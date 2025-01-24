package dev.nyanchuk.model;

import java.util.ArrayList;
import java.util.List;

public class TollStation {
    private String name;
    private String city;
    private double total;
    private List<Vehicle> vehicles;

    public TollStation(String name, String city) {
        this.name = name;
        this.city = city;
        this.total = 0.0;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        total += vehicle.calculateToll();
    }
    
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    

    public double getTotal() {
        return total;
    }

    public void report() {
        System.out.println(city + " '" + name + "' Toll Station report: ");
        System.out.println("Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println("- " + vehicle.getClass().getSimpleName() + " [" + vehicle.getNumber() + "] Toll: $" + vehicle.calculateToll());
        }
        System.out.println("Total money collected:" + total);
    }
}
