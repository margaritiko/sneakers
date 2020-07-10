package com.source.company;

import com.common.random.RandomService;
import javax.inject.Inject;
import javax.inject.Singleton;

// You can comment the next line to see the problem with different designers' companies - wrong behavior.
// Also comment @Singleton annotation in BoutiqueComponent and ServicesComponent.
@Singleton
public class Company {

    private String companyName;

    @Inject
    public Company(RandomService randomService) {
        companyName = "";
        companyName += randomService.getRandomCharacter() + randomService.getRandomCharacter();
    }

    @Override
    public String toString() {
        return String.format("[COMPANY %s]", companyName);
    }
}
