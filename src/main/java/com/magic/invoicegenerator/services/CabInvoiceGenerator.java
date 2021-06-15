package com.magic.invoicegenerator.services;

import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;

import java.util.List;

public class CabInvoiceGenerator implements ICabInvoiceGenerator {

    @Override
    public Invoice calculateMultipleRideFareForParticularUser(List<RideDetails> rideDetails,int userId) {
        long totalFare=rideDetails.stream().filter(ride->ride.getUserId().equals(userId))
                .mapToInt(RideDetails::getRideFare).sum();
        long totalRides=rideDetails.stream().filter(ride->ride.getUserId().equals(userId)).count();
        return new Invoice(totalRides, totalFare, totalFare/totalRides);
    }
}
