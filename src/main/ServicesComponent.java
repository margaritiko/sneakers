package main;

import com.source.factory.HighFashionFactory;
import dagger.Component;

@Component
public interface ServicesComponent {

    HighFashionFactory getHighFashionFactory(); // TODO: use Factory instead

}