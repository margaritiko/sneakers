package com.source.designer.service;

import javax.inject.Inject;

public class Logger {

    @Inject
    public Logger() {}

    public void logHiringDesigner(DesignerService designerService) {
        System.out.println("A designer was hired.");
    }

}
