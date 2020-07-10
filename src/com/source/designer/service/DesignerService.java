package com.source.designer.service;

import com.source.brands.service.BrandsService;
import com.source.colors.service.ColorsService;
import com.source.designer.logger.Logger;
import com.source.sneakers.models.Sneakers;
import javax.inject.Inject;

public class DesignerService {

    private ColorsService colorsService;
    private BrandsService brandsService;

    @Inject
    public DesignerService(ColorsService colorsService, BrandsService brandsService) {
        this.colorsService = colorsService;
        this.brandsService = brandsService;
    }

    public Sneakers makeSneakers() {
        return new Sneakers(colorsService.getRandomColor(),
                            colorsService.getRandomColor(),
                            colorsService.getRandomColor(),
                            brandsService.getRandomBrand());
    }

    @Inject
    public void notifyAboutEmployment(Logger logger) {
        logger.logHiringDesigner(this);
    }

}
