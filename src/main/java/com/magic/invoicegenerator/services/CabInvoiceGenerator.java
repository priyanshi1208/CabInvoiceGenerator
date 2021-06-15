package com.magic.invoicegenerator.services;
import com.magic.invoicegenerator.entity.Invoice;
import com.magic.invoicegenerator.entity.RideDetails;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CabInvoiceGenerator implements ICabInvoiceGenerator {

    @Override
    public Invoice calculateMultipleRideFareForParticularUser(List<RideDetails> rideDetails, Integer userId) {
        showallUsers(rideDetails);
        long totalFare = rideDetails.stream().filter(ride -> ride.getUserId().equals(userId))
                .mapToInt(RideDetails::getRideFare).sum();
        long totalRides = rideDetails.stream().filter(ride -> ride.getUserId().equals(userId)).count();
        printInvoice(userId, totalFare, totalRides);
        return new Invoice(totalRides, totalFare, totalFare / totalRides);
    }
    public void showallUsers(List<RideDetails> rideDetails){
        System.out.println("Users:");
        Object[] users = rideDetails.stream().map(RideDetails::getUserId).distinct().toArray();
        Arrays.stream(users).forEach(System.out::println);
    }

    @Override
    public void printInvoice(Integer userId, long totalFare, long totalRides) {
        System.out.println("The Monthly Invoice for the rides took by Customer:" + userId + "\n" +
                "Total fare:" + totalFare + "\n" +
                "For Total Rides Taken:" + totalRides + "\n" +
                "Average Cost per Ride:" + totalFare / totalRides + "\n" +
                "*****************************************");
    }
}
