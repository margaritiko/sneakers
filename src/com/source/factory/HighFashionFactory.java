package com.source.factory;

import com.source.designer.service.DesignerService;
import com.source.price.estimator.PriceEstimator;
import com.source.sneakers.models.Sneakers;
import com.source.sneakers.models.SneakersInBox;
import javax.inject.Inject;

public class HighFashionFactory implements Factory {

    @Inject DesignerService designerService;
    @Inject PriceEstimator priceEstimator;

    @Override
    public SneakersInBox makeSneakers() {
        Sneakers sneakers = designerService.makeSneakers();
        double price = priceEstimator.estimateSneakers(sneakers);

        return new SneakersInBox(sneakers, price);
    }
}
