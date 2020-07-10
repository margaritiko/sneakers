package com.source.factory;

import com.source.designer.service.Designer;
import com.source.price.estimator.PriceEstimator;
import com.source.sneakers.models.Sneakers;
import com.source.sneakers.models.SneakersInBox;
import javax.inject.Inject;

public class Factory {

    @Inject Designer designer;

    @Inject PriceEstimator priceEstimator;

    public SneakersInBox makeSneakers() {
        Sneakers sneakers = designer.makeSneakers();
        double price = priceEstimator.estimateSneakers(sneakers);

        return new SneakersInBox(sneakers, price);
    }
}
