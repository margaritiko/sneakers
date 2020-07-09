package com.source.brands.service;

import com.common.random.RandomService;
import com.source.brands.models.Brand;
import com.source.brands.models.OriginCountry;

public class BrandsService {

    private RandomService randomService;

    public BrandsService(RandomService randomService) {
        this.randomService = randomService;
    }

    public Brand getRandomBrand() {
        int lengthOfBrandName = randomService.getRandomInt(3, 10);
        String name = "";

        for (int index = 0; index < lengthOfBrandName; ++index) {
            name += randomService.getRandomCharacter();
        }

        int countryIndex = randomService.getRandomInt(0, OriginCountry.class.getEnumConstants().length);
        OriginCountry originCountry = OriginCountry.class.getEnumConstants()[countryIndex];

        return new Brand(name, originCountry);
    }
}
