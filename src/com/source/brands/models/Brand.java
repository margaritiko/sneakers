package com.source.brands.models;

public class Brand {

    private String name;
    private OriginCountry originCountry;

    public Brand(String name, OriginCountry originCountry) {
        this.name = name;
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public OriginCountry getOriginCountry() {
        return originCountry;
    }
}
