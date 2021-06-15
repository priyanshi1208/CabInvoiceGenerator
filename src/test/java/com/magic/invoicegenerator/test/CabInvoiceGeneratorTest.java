package com.magic.invoicegenerator.test;


import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;
import com.magic.invoicegenerator.services.CabInvoiceGenerator;
import com.magic.invoicegenerator.services.ICabInvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class CabInvoiceGeneratorTest {


    @Test
    void GivenTestMultipleDatesAndTime_CheckForParticularUser_InvoiceGeneratorReturnsInvoiceForUser() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        List<RideDetails> rideDetails=new ArrayList<>();
        rideDetails.add(new RideDetails(280,20,1));
        rideDetails.add(new RideDetails(300,30,2));
        rideDetails.add(new RideDetails(200,20,1));
        Invoice invoice = cabInvoiceGenerator.calculateMultipleRideFareForParticularUser(rideDetails,1);
        Assertions.assertEquals(4840,invoice.getTotalFare());
        Assertions.assertEquals(2,invoice.getTotalRides());
        Assertions.assertEquals(2420,invoice.getAverageFare());
    }
}
