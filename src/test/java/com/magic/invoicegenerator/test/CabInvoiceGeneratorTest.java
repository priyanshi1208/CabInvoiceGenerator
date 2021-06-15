package com.magic.invoicegenerator.test;

import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;
import com.magic.invoicegenerator.entity.RideType;
import com.magic.invoicegenerator.services.CabInvoiceGenerator;
import com.magic.invoicegenerator.services.ICabInvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CabInvoiceGeneratorTest {
    @Test
    void GivenTestMultipleDatesAndTime_CheckForParticularUser_InvoiceGeneratorReturnsInvoiceForUser() {
        ICabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        List<RideDetails> rideDetails = new ArrayList<>();
        rideDetails.add(new RideDetails(280, 20, 1, RideType.Ridetype.NORMAL_RIDES));
        rideDetails.add(new RideDetails(300, 30, 2, RideType.Ridetype.NORMAL_RIDES));
        rideDetails.add(new RideDetails(200, 20, 1, RideType.Ridetype.NORMAL_RIDES));
        Invoice invoice = cabInvoiceGenerator.calculateMultipleRideFareForParticularUser(rideDetails, 1);
        Assertions.assertEquals(4840, invoice.getTotalFare());
        Assertions.assertEquals(2, invoice.getTotalRides());
        Assertions.assertEquals(2420, invoice.getAverageFare());
    }

    @Test
    void GivenTestMultipleDatesAndTime_CheckForTypeOfRide_InvoiceGeneratorReturnsInvoiceAccordingToRideType() {
        ICabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        List<RideDetails> rideDetails = new ArrayList<>();
        rideDetails.add(new RideDetails(280, 20, 1, RideType.Ridetype.NORMAL_RIDES));
        rideDetails.add(new RideDetails(300, 30, 2, RideType.Ridetype.NORMAL_RIDES));
        rideDetails.add(new RideDetails(200, 20, 1, RideType.Ridetype.PREMIUM_RIDES));
        Invoice invoice = cabInvoiceGenerator.calculateMultipleRideFareForParticularUser(rideDetails, 1);
        Assertions.assertEquals(5860, invoice.getTotalFare());
        Assertions.assertEquals(2, invoice.getTotalRides());
        Assertions.assertEquals(2930, invoice.getAverageFare());
    }
}
