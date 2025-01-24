package dev.nyanchuk.model;

public class Truck extends Vehicle {
    private int numAxles;

    public Truck(String number, int numAxles) {
        super(number);
        if (numAxles <= 0) {
            throw new IllegalArgumentException("Number of axles must be greater than 0");
        }
        this.numAxles = numAxles;
    }

    public int getNumAxles() {
        return numAxles;
    }

    @Override
    public double calculateToll() {
        return 50.0 * numAxles;
    }
}