package com.magic.invoicegenerator.services;

import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;

import java.util.List;

public class CabInvoiceGenerator implements ICabInvoiceGenerator {

    @Override
    public Invoice calculateMultipleRideFare(List<RideDetails> rideDetails) {
        return new Invoice(rideDetails.size(),
                rideDetails.stream().mapToInt(RideDetails::getRideFare).sum(),
                rideDetails.stream().mapToInt(RideDetails::getRideFare).sum()/rideDetails.size());
    }

}
