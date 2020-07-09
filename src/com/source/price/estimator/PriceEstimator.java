package com.source.price.estimator;

import com.common.random.RandomService;
import com.source.sneakers.models.Sneakers;

import java.util.ArrayList;
import java.util.List;

public class PriceEstimator {

    private final static int numberOfCoefficients = 11;
    private final static int maxCoefficientValue = 1000;
    private final static int hashNormalizationValue = 500;
    private final static int priceNormalizationValue = 1000;

    private List<Integer> coefficients = new ArrayList<>();

    public PriceEstimator(RandomService randomService) {
        int leftBorder = randomService.getRandomInt();
        int rightBorder = randomService.getRandomInt();

        if (leftBorder > rightBorder) {
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }

        for (int index = 0; index < numberOfCoefficients; ++index) {
            int calculatedCoefficient = randomService.getRandomInt(leftBorder, rightBorder);
            coefficients.add(calculatedCoefficient % maxCoefficientValue);
        }
    }

    public double estimateSneakers(Sneakers sneakers) {
        List<Integer> features = new ArrayList<>();

        features.add(sneakers.getSurfaceColor().getR());
        features.add(sneakers.getSurfaceColor().getG());
        features.add(sneakers.getSurfaceColor().getB());
        features.add(sneakers.getDecorationColor().getR());
        features.add(sneakers.getDecorationColor().getG());
        features.add(sneakers.getDecorationColor().getB());
        features.add(sneakers.getSoleColor().getR());
        features.add(sneakers.getSoleColor().getG());
        features.add(sneakers.getSoleColor().getB());
        features.add(sneakers.getBrand().getName().hashCode() % hashNormalizationValue);

        return applyLinearRegression(features) / priceNormalizationValue;
    }


    private int applyLinearRegression(List<Integer> features) {
        int price = coefficients.get(0);
        for (int index = 1; index < numberOfCoefficients; ++index) {
            price += features.get(index - 1) * coefficients.get(index);
        }

        return Math.abs(price);
    }

}
