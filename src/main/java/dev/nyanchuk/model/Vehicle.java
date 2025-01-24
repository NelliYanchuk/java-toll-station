package dev.nyanchuk.model;

public abstract class Vehicle {
    protected String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public abstract double calculateToll();
}
