package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class HourlyPrice {
    private int startHour;
    private BigDecimal price;

    public HourlyPrice(int startHour, BigDecimal price) {
        this.startHour = startHour;
        this.price = price;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return (startHour + 1) % 24;  // Calculate the end hour based on the start hour
    }

    public BigDecimal getPrice() {
        return price;
    }
}