package com.source.designer.service;

import dagger.Module;
import dagger.Provides;

@Module
public class HighFashionDesignerModule {

    @Provides
    Designer provideDesigner(HighFashionDesigner designer) {
        return designer;
    }

}
