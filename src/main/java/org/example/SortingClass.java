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

    public void sortAndDisplayPricesBySize(List<HourlyPrice> hourlyPrices) {
        if (!hourlyPrices.isEmpty()) {
            // Sort the hourly prices in descending order by size
            Collections.sort(hourlyPrices, (a, b) -> b.getPrice().compareTo(a.getPrice()));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("sv", "SE")));

            // Display the sorted prices with the start and end times
            for (HourlyPrice hourlyPrice : hourlyPrices) {
                String startTime = String.format("%02d-%02d", hourlyPrice.getHour(), (hourlyPrice.getHour() + 1) % 24);
                BigDecimal price = hourlyPrice.getPrice();
                System.out.println(startTime + " " + price + " öre");
            }
        } else {
            System.out.println("Du har inte angivit något pris.");
        }
    }
}
