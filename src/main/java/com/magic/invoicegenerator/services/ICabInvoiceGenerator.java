package com.magic.invoicegenerator.services;

import com.magic.invoicegenerator.entity.RideDetails;

import java.util.List;

public interface ICabInvoiceGenerator {
     int calculateSingleRideFare(int distance, int timeInMinutes) ;
     int calculateMultipleRideFare(List<RideDetails> rideDetails);
}
