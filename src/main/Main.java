package main;

import com.source.factory.Factory;
import com.source.sneakers.models.SneakersInBox;

public class Main {

    public static void main(String[] args) {

        ServicesComponent servicesComponent = DaggerServicesComponent.create();

        Factory factory = new Factory();
        servicesComponent.inject(factory);
        SneakersInBox sneakersInBox = factory.makeSneakers();

        System.out.println(sneakersInBox);
    }
}
