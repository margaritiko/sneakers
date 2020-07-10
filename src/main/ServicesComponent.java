package main;

import com.source.designer.logger.LoggerModule;
import com.source.designer.service.BeginnerDesignerModule;
import com.source.factory.Factory;
import dagger.Component;

@Component(modules = {LoggerModule.class, BeginnerDesignerModule.class})
public interface ServicesComponent {

    void inject(Factory fashionFactory);

}