package org.example;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class OptimalCharge {

    public void execute(List<HourlyPrice> hourlyPrices) {
        findLowestSequenceAndAverage(hourlyPrices);
    }

    public void findLowestSequenceAndAverage(List<HourlyPrice> hourlyPrices) {
        int lowestSum = Integer.MAX_VALUE;
        List<HourlyPrice> lowestSequence = new ArrayList<>();
        int startIndex = -1;

        for (int i = 0; i <= hourlyPrices.size() - 4; i++) {
            List<HourlyPrice> currentSequence = new ArrayList<>(hourlyPrices.subList(i, i + 4));
            int currentSum = calculateSum(currentSequence);

            if (currentSum < lowestSum) {
                lowestSum = currentSum;
                lowestSequence = currentSequence;
                startIndex = i;
            }
        }

        String startTime = String.format("%02d", lowestSequence.get(0).getStartHour());

        // Calculate the average price as a BigDecimal with two decimal places and rounding mode HALF_UP.
        BigDecimal averageBigDecimal = new BigDecimal(lowestSum).divide(new BigDecimal(4), 2, RoundingMode.HALF_UP);

        // Format the average using custom logic to remove trailing zeros if not significant.
        String formattedAverage = formatAverage(averageBigDecimal);

        System.out.printf("\nPåbörja laddning klockan %s%n", startTime);
        System.out.print("Medelpris 4h: " + formattedAverage + " öre/kWh\n");
    }

    private int calculateSum(List<HourlyPrice> sequence) {
        int sum = 0;
        for (HourlyPrice hourlyPrice : sequence) {
            sum += hourlyPrice.getPrice();
        }
        return sum;
    }

    private String formatAverage(BigDecimal averageBigDecimal) {
        String formatted = averageBigDecimal.stripTrailingZeros().toPlainString();
        if (formatted.endsWith(".0")) {
            formatted = formatted.substring(0, formatted.length() - 2);
        }
        return formatted.replace(".", ",");
    }
}
