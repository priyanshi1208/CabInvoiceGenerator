package com.magic.invoicegenerator.test;


import com.magic.invoicegenerator.services.CabInvoiceGenerator;
import com.magic.invoicegenerator.services.ICabInvoiceGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    @Test
    void GivenTestDateAndTime_CheckIfFareLessThan5_invoiceGeneratorShouldReturnsFare5() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        int fare = cabInvoiceGenerator.calculateFare(0, 2);
        Assertions.assertEquals(5,fare);
    }
    @Test
    void GivenTestDateAndTime_CheckIfFareMoreThan5_invoiceGeneratorShouldReturnsActualFare() {
        ICabInvoiceGenerator cabInvoiceGenerator=new CabInvoiceGenerator();
        int fare = cabInvoiceGenerator.calculateFare(280, 20);
        Assertions.assertEquals(2820,fare);
    }
}
