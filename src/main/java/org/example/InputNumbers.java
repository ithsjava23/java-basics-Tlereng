package org.example;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputNumbers {

    //Class for input of the prices from the user
    public List<HourlyPrice> execute() {
        Scanner sc = new Scanner(System.in);
        List<HourlyPrice> hourlyPrices = new ArrayList<>();
        System.out.println("Vänligen ange priset per timme.");

        for (int i = 0; i < 24; i++) {
            String input = sc.nextLine();
            try {
                BigDecimal price = new BigDecimal(input);
                hourlyPrices.add(new HourlyPrice(i, price));
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt pris, vänligen skriv siffror");
                i--;
            }
        }

        return hourlyPrices;
    }
}