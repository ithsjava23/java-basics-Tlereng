package org.example;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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
            BigDecimal min = hourlyPrices.get(0).getPrice();
            BigDecimal max = hourlyPrices.get(hourlyPrices.size() - 1).getPrice();

            // Calculate the sum of all prices.
            BigDecimal sum = BigDecimal.ZERO;
            for (HourlyPrice hourlyPrice : hourlyPrices) {
                sum = sum.add(hourlyPrice.getPrice());
            }

            // Calculate the average price with two decimal places.
            BigDecimal average = sum.divide(BigDecimal.valueOf(hourlyPrices.size()), 2, BigDecimal.ROUND_HALF_UP);

            // Create a DecimalFormat instance to format numbers with Swedish locale.
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("sv", "SE")));

            // Format time intervals for min and max prices.
            String minTime = String.format("%02d-%02d", hourlyPrices.get(0).getStartHour(), hourlyPrices.get(0).getEndHour());
            String maxTime = String.format("%02d-%02d", hourlyPrices.get(hourlyPrices.size() - 1).getStartHour(), hourlyPrices.get(hourlyPrices.size() - 1).getEndHour());

            // Print the results with appropriate formatting.
            System.out.println("Lägsta pris: " + minTime + ", " + decimalFormat.format(min) + " öre/kWh");
            System.out.println("Högsta pris: " + maxTime + ", " + decimalFormat.format(max) + " öre/kWh");
            System.out.printf("Medelpris: %.2f öre/kWh", average);
        } else {
            // Handle the case when no prices are provided.
            System.out.println("Du har inte angivit några priser.");
        }
    }
}
