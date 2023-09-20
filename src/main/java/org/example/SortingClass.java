package org.example;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class SortingClass {
    public void execute(List<HourlyPrice> hourlyPrices) {
        sortAndDisplayPricesBySize(hourlyPrices);
    }

    // Code to only show the price once if recurring
    public void sortAndDisplayPricesBySize(List<HourlyPrice> hourlyPrices) {
        if (!hourlyPrices.isEmpty()) {
            // Sort the hourly prices in descending order by size
            Collections.sort(hourlyPrices, (a, b) -> Integer.compare(b.getPrice(), a.getPrice()));

            int previousPrice = -1;

            // Display the sorted prices with the start and end times, showing only the first occurrence of each unique price
            for (HourlyPrice hourlyPrice : hourlyPrices) {
                int price = hourlyPrice.getPrice();

                if (price != previousPrice) {
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