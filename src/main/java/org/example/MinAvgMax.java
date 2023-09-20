package org.example;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinAvgMax {

    // Executes the finding of minimum, maximum, and average prices.
    public void execute(List<HourlyPrice> hourlyPrices) {
        findMinMaxAndAverage(hourlyPrices);
    }

    // Finds the minimum, maximum, and average prices from a list of hourly prices.
    public void findMinMaxAndAverage(List<HourlyPrice> hourlyPrices) {
        if (!hourlyPrices.isEmpty()) {
            // Sort the hourly prices in ascending order.
            Collections.sort(hourlyPrices, Comparator.comparing(HourlyPrice::getPrice));

            // Calculate the minimum and maximum prices.
            int min = hourlyPrices.get(0).getPrice();
            int max = hourlyPrices.get(hourlyPrices.size() - 1).getPrice();

            // Calculate the sum of all prices.
            int sum = 0;
            for (HourlyPrice hourlyPrice : hourlyPrices) {
                sum += hourlyPrice.getPrice();
            }

            // Calculate the average price as a float.
            float average = (float) sum / hourlyPrices.size();

            // Format time intervals for min and max prices.
            String minTime = String.format("%02d-%02d", hourlyPrices.get(0).getStartHour(), hourlyPrices.get(0).getEndHour());
            String maxTime = String.format("%02d-%02d", hourlyPrices.get(hourlyPrices.size() - 1).getStartHour(), hourlyPrices.get(hourlyPrices.size() - 1).getEndHour());

            // Print the results with appropriate formatting using printf.
            System.out.println("Lägsta pris: " + minTime + ", " + min + " öre/kWh");
            System.out.println("Högsta pris: " + maxTime + ", " + max + " öre/kWh");
            System.out.printf("Medelpris: %.2f öre/kWh%n", average);

        } else {
            // Handle the case when no prices are provided.
            System.out.println("Du har inte angivit några priser.");
        }
    }
}
