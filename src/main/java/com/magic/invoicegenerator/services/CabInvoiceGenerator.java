package com.magic.invoicegenerator.services;

public class CabInvoiceGenerator implements ICabInvoiceGenerator {

    private int CostPerKilometer=10;
    private int CostPerMinute=1;

    @Override
    public int calculateFare(int distanceInKilometer, int timeInMinutes) {
        Integer totalFare = (distanceInKilometer * CostPerKilometer) + timeInMinutes * CostPerMinute;
        return totalFare.compareTo(5) > 0 ? totalFare : 5;
    }
}
