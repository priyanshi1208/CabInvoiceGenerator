package com.magic.invoicegenerator.entity;

public class RideDetails {
    private final int rideFare;
    private int distancePerKm;
    private int timeInMinutes;
    private int userId;
    private RideType.Ridetype rideType;

    public RideDetails(int distancePerKm, int timeInMinutes, int userId, RideType.Ridetype rideType) {
        this.distancePerKm = distancePerKm;
        this.timeInMinutes = timeInMinutes;
        this.userId = userId;
        this.rideType = rideType;
        this.rideFare = setRideFare(distancePerKm, timeInMinutes, rideType);
    }

    private int setRideFare(int distanceInKm, int timeInMinutes, RideType.Ridetype rideType) {
        RideType ride = new RideType(rideType);
        Integer totalFare = (distanceInKm * ride.getCostPerKilometer()) + timeInMinutes * ride.getCostPerMinute();
        return totalFare.compareTo(ride.getMinimumFare()) > 0 ? totalFare : ride.getMinimumFare();
    }

    public Integer getUserId() {
        return userId;
    }

    public int getRideFare() {
        return rideFare;
    }
}
