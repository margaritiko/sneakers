package com.source.boutique;

import com.source.factory.Factory;
import com.source.sneakers.models.SneakersInBox;

import javax.inject.Inject;
import javax.inject.Named;

public class Boutique {

    private int numberOfBoxes;
    private int percentageOfIncome;
    private Factory factory;

    @Inject
    public Boutique(@Named("number of boxes") int numberOfBoxes,
                    @Named("percentage of income") int percentageOfIncome,
                    Factory factory) {
        this.numberOfBoxes = numberOfBoxes;
        this.percentageOfIncome = percentageOfIncome;
        this.factory = factory;
    }

    public void showStock() {
        System.out.println(String.format("\n______\nBoutique contains %d boxes and takes %d from an income.\n______\n\n", numberOfBoxes, percentageOfIncome));
        for (int numberOfBox = 0; numberOfBox < numberOfBoxes; ++numberOfBox) {
            SneakersInBox box = factory.makeSneakers();
            System.out.println(String.format("%s\n\n", box));
        }
    }

}
