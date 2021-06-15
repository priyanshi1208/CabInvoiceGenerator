package com.magic.invoicegenerator.test;


import com.magic.invoicegenerator.entity.RideDetails;
import com.magic.invoicegenerator.services.CabInvoiceGenerator;
import com.magic.invoicegenerator.services.ICabInvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class CabInvoiceGeneratorTest {
    @Test
    void GivenTestDateAndTime_CheckIfFareIsLessThan5_invoiceGeneratorShouldReturnsFare5() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        int fare = cabInvoiceGenerator.calculateSingleRideFare(0, 2);
        Assertions.assertEquals(5,fare);
    }
    @Test
    void GivenTestDateAndTime_CheckIfFareIsMoreThan5_invoiceGeneratorShouldReturnsActualFare() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        int fare = cabInvoiceGenerator.calculateSingleRideFare(280, 20);
        Assertions.assertEquals(2820,fare);
    }

    @Test
    void GivenTestMultipleDatesAndTime_CheckIfMultipleRideFare_InvoiceGeneratorReturnsActualTotalFare() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        List<RideDetails> rideDetails=new ArrayList<>();
        rideDetails.add(new RideDetails(280,20));
        rideDetails.add(new RideDetails(300,30));
        rideDetails.add(new RideDetails(200,20));
        int totalfare = cabInvoiceGenerator.calculateMultipleRideFare(rideDetails);
        Assertions.assertEquals(7870,totalfare);
    }
}
