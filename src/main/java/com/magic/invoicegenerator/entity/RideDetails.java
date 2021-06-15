package com.magic.invoicegenerator.entity;

public class RideDetails {
    private final int rideFare;
    private int distancePerKm;
    private int timeInMinutes;

    public RideDetails(int distancePerKm, int timeInMinutes) {
        this.distancePerKm = distancePerKm;
        this.timeInMinutes = timeInMinutes;
        this.rideFare=TotalFare(distancePerKm,timeInMinutes);
    }
    private int TotalFare(int distanceInKm,int timeInMinutes){
        int costPerKilometer = 10;
        int costPerMinute = 1;
        Integer totalFare = (distanceInKm * costPerKilometer) + timeInMinutes * costPerMinute;
        return totalFare.compareTo(5) > 0 ? totalFare : 5;
    }
    public int getRideFare() {
        return rideFare;
    }
}
