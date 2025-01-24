package dev.nyanchuk.model;

public class Car extends Vehicle{
    public Car(String number) {
        super(number);
    }

    @Override
    public double calculateToll() {
        return 100.0;
    }
}
