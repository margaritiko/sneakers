package main;

import com.source.boutique.Boutique;
import com.source.boutique.BoutiqueModule;
import com.source.factory.Factory;
import com.source.sneakers.models.SneakersInBox;

public class Main {

    public static void main(String[] args) {

        int numberOfBoxes = 3;

        BoutiqueComponent boutiqueComponent = DaggerBoutiqueComponent
                .builder()
                .boutiqueModule(new BoutiqueModule(numberOfBoxes))
                .build();
        boutiqueComponent.getBoutique().showStock();
    }
}
