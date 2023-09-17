package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OptimalCharge {

    public void execute(List<HourlyPrice> hourlyPrices) {
        findLowestSequenceAndAverage(hourlyPrices);
    }

    public void findLowestSequenceAndAverage(List<HourlyPrice> hourlyPrices) {
        BigDecimal lowestSum = BigDecimal.valueOf(Double.MAX_VALUE);
        List<HourlyPrice> lowestSequence = new ArrayList<>();
        int startIndex = -1;

        for (int i = 0; i <= hourlyPrices.size() - 4; i++) {
            List<HourlyPrice> currentSequence = new ArrayList<>(hourlyPrices.subList(i, i + 4));
            BigDecimal currentSum = calculateSum(currentSequence);

            if (currentSum.compareTo(lowestSum) < 0) {
                lowestSum = currentSum;
                lowestSequence = currentSequence;
                startIndex = i;
            }
        }

        String startTime = String.format("%02d", lowestSequence.get(0).getHour());
        String endTime = String.format("%02d", (lowestSequence.get(0).getHour() + 4) % 24);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale("sv", "SE")));
        System.out.printf("Påbörja laddning klockan %s%n", startTime);
        BigDecimal average = calculateSum(lowestSequence).divide(BigDecimal.valueOf(4), 2, BigDecimal.ROUND_HALF_UP);
        System.out.printf("Medelpris 4h: %.2f öre/kWh%n", average);
    }

    private BigDecimal calculateSum(List<HourlyPrice> sequence) {
        BigDecimal sum = BigDecimal.ZERO;
        for (HourlyPrice hourlyPrice : sequence) {
            sum = sum.add(hourlyPrice.getPrice());
        }
        return sum;
    }
}
