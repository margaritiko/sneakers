package com.source.boutique;

import com.source.factory.Factory;
import dagger.Module;
import dagger.Provides;

@Module
public class BoutiqueModule {

    private int numberOfBoxes;

    public BoutiqueModule(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    @Provides
    Boutique provideBoutique(Factory factory) {
        return new Boutique(numberOfBoxes, factory);
    }
}
