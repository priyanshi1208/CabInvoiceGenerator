package com.magic.invoicegenerator.services;

import com.magic.invoicegenerator.entity.RideDetails;

import java.util.Arrays;
import java.util.List;

public class CabInvoiceGenerator implements ICabInvoiceGenerator {

    private final int CostPerKilometer=10;
    private final int CostPerMinute=1;

    @Override
    public int calculateSingleRideFare(int distanceInKilometer, int timeInMinutes) {
        Integer totalFare = (distanceInKilometer * CostPerKilometer) + timeInMinutes * CostPerMinute;
        return totalFare.compareTo(5) > 0 ? totalFare : 5;
    }

    @Override
    public int calculateMultipleRideFare(List<RideDetails> rideDetails) {
        return rideDetails.stream().mapToInt(RideDetails::getRideFare).sum();
    }
}
