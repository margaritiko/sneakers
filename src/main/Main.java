package main;

import com.source.sneakers.models.SneakersInBox;

public class Main {

    public static void main(String[] args) {

        ServicesComponent servicesComponent = DaggerServicesComponent.create();
        SneakersInBox sneakersInBox = servicesComponent.getHighFashionFactory().makeSneakers();

        System.out.println(sneakersInBox);
    }
}
