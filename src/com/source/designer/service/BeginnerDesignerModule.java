package com.source.designer.service;


import dagger.Binds;
import dagger.Module;

@Module
public abstract class BeginnerDesignerModule {

    @Binds
    abstract Designer bindDesigner(BeginnerDesigner designer);

}
