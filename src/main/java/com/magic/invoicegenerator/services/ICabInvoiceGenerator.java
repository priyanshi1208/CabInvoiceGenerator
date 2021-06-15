package com.magic.invoicegenerator.services;

import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;

import java.util.List;

public interface ICabInvoiceGenerator {
    Invoice calculateMultipleRideFareForParticularUser(List<RideDetails> rideDetails, Integer userId);

    void printInvoice(Integer userId, long totalFare, long totalRides);
}
