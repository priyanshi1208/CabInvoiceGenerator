package com.magic.invoicegenerator.entity;

public class Invoice {
    private long totalRides;
    private long totalFare;
    private long averageFare;

    public Invoice(long totalRides, long totalFare, long averageFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFare = averageFare;
    }

    public long getTotalRides() {
        return totalRides;
    }

    public long getTotalFare() {
        return totalFare;
    }

    public long getAverageFare() {
        return averageFare;
    }
}
