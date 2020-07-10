package com.common.limits;
import javax.inject.Inject;

public class LimitsService {

    private static final int colorsBottomBorder = 0;
    private static final int colorsTopBorder = 255;

    @Inject
    public LimitsService() {}

    public int fitColorValueInBorders(int value) {
        if (value < 0) value *= -1;
        value %= 255;
        return value;
    }

}
