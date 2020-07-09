package com.source.sneakers.models;

import com.source.brands.models.Brand;
import com.source.colors.models.Color;

public class Sneakers {

    private Color surfaceColor;
    private Color decorationColor;
    private Color soleColor;
    private Brand brand;

    public Sneakers(Color surfaceColor, Color decorationColor, Color soleColor, Brand brand) {
        this.surfaceColor = surfaceColor;
        this.decorationColor = decorationColor;
        this.soleColor = soleColor;
        this.brand = brand;
    }

    public Color getSurfaceColor() {
        return surfaceColor;
    }

    public Color getDecorationColor() {
        return decorationColor;
    }

    public Color getSoleColor() {
        return soleColor;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("Sneakers '%s'.\nOrigin country: %s.\n\nDETAILS\n" +
                "surface color: %s,\ndecorations color: %s,\nsole color: %s.", brand.getName(),
                brand.getOriginCountry(), surfaceColor, decorationColor, soleColor);
    }
}
