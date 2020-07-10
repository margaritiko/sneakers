package main;

import com.source.factory.Factory;
import com.source.factory.HighFashionFactory;
import dagger.Component;

@Component
public interface ServicesComponent {

    void inject(HighFashionFactory fashionFactory);

}