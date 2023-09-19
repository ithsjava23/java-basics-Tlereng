package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SortingClass {
    public void execute(List<HourlyPrice> hourlyPrices) {
        sortAndDisplayPricesBySize(hourlyPrices);
    }
    //code to only show the price once if recurring
    public void sortAndDisplayPricesBySize(List<HourlyPrice> hourlyPrices) {
        if (!hourlyPrices.isEmpty()) {
            // Sort the hourly prices in descending order by size
            Collections.sort(hourlyPrices, (a, b) -> b.getPrice().compareTo(a.getPrice()));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("sv", "SE")));

            BigDecimal previousPrice = BigDecimal.ZERO;

            // Display the sorted prices with the start and end times, showing only the first occurrence of each unique price
            for (HourlyPrice hourlyPrice : hourlyPrices) {
                BigDecimal price = hourlyPrice.getPrice();

                if (price.compareTo(previousPrice) != 0) {
                    String startTime = String.format("%02d-%02d", hourlyPrice.getStartHour(), hourlyPrice.getEndHour());
                    System.out.println(startTime + " " + price + " öre");
                }

                previousPrice = price;
            }
        } else {
            System.out.println("Du har inte angivit något pris.");
        }
    }
}

