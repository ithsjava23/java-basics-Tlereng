package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<HourlyPrice> hourlyPrices = new ArrayList<>();
        Locale.setDefault(new Locale("sv","SE"));
        //Loop menu with options
        String meny = """
                
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """;
        do {
            System.out.print(meny);

            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("e")) {
                break;
            }

            switch (choice) {
                case "1" -> {
                    InputNumbers inputNumbers = new InputNumbers(sc);
                    hourlyPrices = inputNumbers.execute(hourlyPrices);
                }

                case "2" -> {
                    MinAvgMax minAvgMax = new MinAvgMax();
                    minAvgMax.execute(hourlyPrices);
                }
                case "3" -> {
                    SortingClass sorting = new SortingClass();
                    sorting.execute(hourlyPrices);
                }
                case "4" -> {
                    OptimalCharge optimalCharge = new OptimalCharge();
                    optimalCharge.execute(hourlyPrices);
                }
                default -> System.out.println("Ogiltigt val");
            }
        } while (true);
        sc.close();
    }
}