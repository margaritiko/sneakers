package main;

import com.common.limits.LimitsService;
import com.common.random.RandomService;
import com.source.brands.service.BrandsService;
import com.source.colors.service.ColorsService;
import com.source.designer.service.DesignerService;
import com.source.factory.Factory;
import com.source.factory.HighFashionFactory;
import com.source.price.estimator.PriceEstimator;
import com.source.sneakers.models.SneakersInBox;

public class Main {

    public static void main(String[] args) {

        RandomService randomService = new RandomService();
        LimitsService limitsService = new LimitsService();

        ColorsService colorsService = new ColorsService(randomService, limitsService);
        BrandsService brandsService = new BrandsService(randomService);

        DesignerService designerService = new DesignerService(colorsService, brandsService);
        PriceEstimator priceEstimator = new PriceEstimator(randomService);

        Factory factory = new HighFashionFactory(designerService, priceEstimator);
        SneakersInBox sneakersInBox = factory.makeSneakers();

        System.out.println(sneakersInBox);
    }
}
