package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
            double averageDouble = (double) sum / hourlyPrices.size();
            String average = String.format("%.2f", averageDouble);

            // Format time intervals for min and max prices.
            String minTime = String.format("%02d-%02d", hourlyPrices.get(0).getStartHour(), hourlyPrices.get(0).getEndHour());
            String maxTime = String.format("%02d-%02d", hourlyPrices.get(hourlyPrices.size() - 1).getStartHour(), hourlyPrices.get(hourlyPrices.size() - 1).getEndHour());

            // Print the results with appropriate formatting using printf.
            System.out.print("\nLägsta pris: " + minTime + ", " + min + " öre/kWh\n");
            System.out.print("Högsta pris: " + maxTime + ", " + max + " öre/kWh\n");
            System.out.print("Medelpris: " + average + " öre/kWh");

        } else {
            // Handle the case when no prices are provided.
            System.out.print("Du har inte angivit några priser.");
        }
    }
}
