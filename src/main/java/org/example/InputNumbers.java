package org.example;
import java.util.List;
import java.util.Scanner;

public class InputNumbers {
    private Scanner sc;

    public InputNumbers(Scanner sc) {
        this.sc = sc;
    }

    // Class for input of the prices from the user
    public List<HourlyPrice> execute(List<HourlyPrice>hourlyPrices) {

        for (int i = 0; i < 24; i++) {
            String input = sc.nextLine();
            try {
                int price = Integer.parseInt(input);
                hourlyPrices.add(new HourlyPrice(i, price));
            } catch (NumberFormatException e) {
                System.out.print("\nOgiltigt pris, vänligen skriv siffror");
                i--;
            }
        }

        return hourlyPrices;
    }
}