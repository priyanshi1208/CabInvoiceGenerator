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
    void GivenTestMultipleDatesAndTime_CheckIfWithMultipleRideFare_InvoiceGeneratorReturnsInvoiceSummary() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        List<RideDetails> rideDetails=new ArrayList<>();
        rideDetails.add(new RideDetails(280,20));
        rideDetails.add(new RideDetails(300,30));
        rideDetails.add(new RideDetails(200,20));
        Invoice invoice = cabInvoiceGenerator.calculateMultipleRideFare(rideDetails);
        Assertions.assertEquals(7870,invoice.getTotalFare());
        Assertions.assertEquals(3,invoice.getTotalRides());
        Assertions.assertEquals(2623,invoice.getAverageFare());
    }
}
