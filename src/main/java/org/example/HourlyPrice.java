package org.example;

import java.math.BigDecimal;
import java.util.Locale;

public class HourlyPrice {

    //Class to store the hour of the input for the price and return it so I can use it for other classes

       private int hour;
       private BigDecimal price;

    public HourlyPrice(int hour,BigDecimal price){
        this.hour = hour;
        this.price = price;
}
    public int getHour(){
        return hour;
    }
    public BigDecimal getPrice(){
        return price;
    }
}