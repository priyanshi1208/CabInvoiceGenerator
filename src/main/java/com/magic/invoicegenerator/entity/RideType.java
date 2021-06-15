package com.magic.invoicegenerator.entity;

public class RideType {

    public enum Ridetype {
        NORMAL_RIDES, PREMIUM_RIDES
    }

    private int costPerKilometer;
    private int costPerMinute;
    private int minimumFare;

    public RideType(Ridetype ridetype) {
        if (ridetype.equals(Ridetype.NORMAL_RIDES)) {
            this.costPerKilometer = 10;
            this.costPerMinute = 1;
            this.minimumFare = 5;
        }
        if (ridetype.equals(Ridetype.PREMIUM_RIDES)) {
            this.costPerKilometer = 15;
            this.costPerMinute = 2;
            this.minimumFare = 20;
        }
    }

    public int getCostPerKilometer() {
        return costPerKilometer;
    }

    public int getCostPerMinute() {
        return costPerMinute;
    }

    public int getMinimumFare() {
        return minimumFare;
    }
}


