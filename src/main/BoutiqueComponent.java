package main;

import com.source.boutique.Boutique;
import com.source.boutique.BoutiqueModule;
import com.source.designer.logger.LoggerModule;
import com.source.designer.service.HighFashionDesignerModule;
import dagger.Component;

@Component(modules = {LoggerModule.class, HighFashionDesignerModule.class, BoutiqueModule.class})
public interface BoutiqueComponent {

    Boutique getBoutique();

}
