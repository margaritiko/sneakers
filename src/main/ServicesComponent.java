package main;

import com.source.designer.logger.LoggerModule;
import com.source.designer.service.BeginnerDesignerModule;
import com.source.factory.Factory;
import dagger.Component;

import javax.inject.Singleton;

// You can comment the next line to see the problem with different designers' companies - wrong behavior.
// Also comment @Singleton annotation in BoutiqueComponent and Company.
@Singleton
@Component(modules = {LoggerModule.class, BeginnerDesignerModule.class})
public interface ServicesComponent {

    void inject(Factory fashionFactory);

}