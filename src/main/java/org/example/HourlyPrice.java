package org.example;

public class HourlyPrice {
    private int startHour;
    private int price;


    public HourlyPrice(int startHour, int price) {
        this.startHour = startHour;
        this.price = price;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        int endHour = (startHour + 1) % 24;  // Calculate the end hour based on the start hour
        if(endHour == 0){
            endHour = 24;
        }
        return endHour;
    }

    public int getPrice() {
        return price;
    }
}