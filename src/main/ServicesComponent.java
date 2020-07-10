package main;

import com.source.designer.logger.LoggerModule;
import com.source.factory.HighFashionFactory;
import dagger.Component;

@Component(modules = LoggerModule.class)
public interface ServicesComponent {

    void inject(HighFashionFactory fashionFactory);

}