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
        return (startHour + 1) % 24;  // Calculate the end hour based on the start hour
    }

    public int getPrice() {
        return price;
    }
}