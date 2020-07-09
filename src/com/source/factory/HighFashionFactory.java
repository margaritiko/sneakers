package com.source.factory;

import com.source.designer.service.DesignerService;
import com.source.price.estimator.PriceEstimator;
import com.source.sneakers.models.Sneakers;
import com.source.sneakers.models.SneakersInBox;

public class HighFashionFactory implements Factory {

    private DesignerService designerService;
    private PriceEstimator priceEstimator;

    public HighFashionFactory(DesignerService designerService, PriceEstimator priceEstimator) {
        this.designerService = designerService;
        this.priceEstimator = priceEstimator;
    }

    @Override
    public SneakersInBox makeSneakers() {
        Sneakers sneakers = designerService.makeSneakers();
        double price = priceEstimator.estimateSneakers(sneakers);

        return new SneakersInBox(sneakers, price);
    }
}
