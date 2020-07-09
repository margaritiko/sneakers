package com.source.colors.service;

import com.common.limits.LimitsService;
import com.common.random.RandomService;
import com.source.colors.models.Color;

public class ColorsService {

    private LimitsService limitsService;
    private RandomService randomService;

    public ColorsService(RandomService randomService, LimitsService limitsService) {
        this.randomService = randomService;
        this.limitsService = limitsService;
    }

    public Color getRandomColor() {
        int r = randomService.getRandomInt();
        int g = randomService.getRandomInt();
        int b = randomService.getRandomInt();

        Color color = new Color(limitsService.fitColorValueInBorders(r),
                                limitsService.fitColorValueInBorders(g),
                                limitsService.fitColorValueInBorders(b));
        return color;
    }

}
