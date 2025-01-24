package dev.nyanchuk.model;

public class Motorcycle extends Vehicle {
    public Motorcycle(String number) {
        super(number);
    }

    @Override
    public double calculateToll() {
        return 50.0;
    }
}
