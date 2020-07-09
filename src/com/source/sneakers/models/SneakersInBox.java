package com.source.sneakers.models;

public class SneakersInBox {

    private Sneakers sneakers;
    private double price;

    public SneakersInBox(Sneakers sneakers, double price) {
        this.sneakers = sneakers;
        this.price = price;
    }

    public Sneakers getSneakers() {
        return sneakers;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s\n\nPrice: %.2f$.", sneakers, price);
    }
}
