package com.source.factory;

import com.source.designer.service.Designer;
import com.source.price.estimator.PriceEstimator;
import com.source.sneakers.models.Sneakers;
import com.source.sneakers.models.SneakersInBox;
import javax.inject.Inject;

public class Factory {

    // Let's hire two designers from one company to see the problem
    // of creating a new instances of Company class each time
    // (without using annotation @Singleton at first).

    @Inject Designer mainDesigner;
    @Inject Designer internDesigner;

    @Inject PriceEstimator priceEstimator;

    @Inject
    public Factory(Designer mainDesigner, Designer internDesigner, PriceEstimator priceEstimator) {
        this.mainDesigner = mainDesigner;
        this.internDesigner = internDesigner;
        this.priceEstimator = priceEstimator;
    }

    public SneakersInBox makeSneakers() {
        Sneakers sneakersFromLeader = mainDesigner.makeSneakers();
        double leadersSneakersPrice = priceEstimator.estimateSneakers(sneakersFromLeader);

        Sneakers sneakersFromIntern = internDesigner.makeSneakers();
        double internsSneakersPrice = priceEstimator.estimateSneakers(sneakersFromIntern);

        // Returns the cheapest one 💎
        if (internsSneakersPrice < leadersSneakersPrice) {
            return new SneakersInBox(sneakersFromIntern, internsSneakersPrice);
        }

        return new SneakersInBox(sneakersFromLeader, leadersSneakersPrice);
    }
}
