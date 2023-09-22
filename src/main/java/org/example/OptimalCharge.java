package org.example;
import java.text.DecimalFormat;
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
        float average = (float) lowestSum / 4;

        // Create a DecimalFormat with the desired format.
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        // Format the average using the DecimalFormat.
        String formattedAverage = decimalFormat.format(average);

        System.out.printf("Påbörja laddning klockan %s%n", startTime);
        System.out.print("Medelpris 4h: " + formattedAverage + " öre/kWh\n");
    }

    private int calculateSum(List<HourlyPrice> sequence) {
        int sum = 0;
        for (HourlyPrice hourlyPrice : sequence) {
            sum += hourlyPrice.getPrice();
        }
        return sum;
    }
}
