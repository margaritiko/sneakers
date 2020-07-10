package main;

import com.source.factory.HighFashionFactory;
import com.source.sneakers.models.SneakersInBox;

public class Main {

    public static void main(String[] args) {

        ServicesComponent servicesComponent = DaggerServicesComponent.create();

        HighFashionFactory factory = new HighFashionFactory();
        servicesComponent.inject(factory);
        SneakersInBox sneakersInBox = factory.makeSneakers();

        System.out.println(sneakersInBox);
    }
}
