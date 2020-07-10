package com.source.boutique;

import com.source.factory.Factory;
import com.source.sneakers.models.SneakersInBox;

public class Boutique {

    private int numberOfBoxes;
    private Factory factory;

    public Boutique(int numberOfBoxes, Factory factory) {
        this.numberOfBoxes = numberOfBoxes;
        this.factory = factory;
    }

    public void showStock() {
        for (int numberOfBox = 0; numberOfBox < numberOfBoxes; ++numberOfBox) {
            SneakersInBox box = factory.makeSneakers();
            System.out.println(String.format("%s\n\n", box));
        }
    }

    public Factory getFactory() {
        return factory;
    }

}
