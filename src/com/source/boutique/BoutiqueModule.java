package com.source.boutique;

import com.source.factory.Factory;
import dagger.Module;
import dagger.Provides;

// Another way to use variable which was specified at runtime.
// This way was replaced with overriding a Builder.
@Deprecated
@Module
public class BoutiqueModule {

    private int numberOfBoxes;
    private int percentageOfIncome;

    public BoutiqueModule(int numberOfBoxes, int percentageOfIncome) {
        this.numberOfBoxes = numberOfBoxes;
        this.percentageOfIncome = percentageOfIncome;
    }

    @Provides
    Boutique provideBoutique(Factory factory) {
        return new Boutique(numberOfBoxes, percentageOfIncome, factory);
    }
}
