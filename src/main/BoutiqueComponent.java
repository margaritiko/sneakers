package main;

import com.source.boutique.Boutique;
import com.source.designer.logger.LoggerModule;
import com.source.designer.service.HighFashionDesignerModule;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Named;

@Component(modules = {LoggerModule.class, HighFashionDesignerModule.class})
public interface BoutiqueComponent {

    Boutique getBoutique();

    // Overriding Builder definition
    @Component.Builder
    interface Builder {

        BoutiqueComponent build();

        @BindsInstance
        Builder numberOfBoxes(@Named("number of boxes") int numberOfBoxes);

        @BindsInstance
        Builder percentageOfIncome(@Named("percentage of income") int percentageOfIncome);

    }

}
