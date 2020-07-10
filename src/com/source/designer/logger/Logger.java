package com.source.designer.logger;

import com.source.designer.service.DesignerService;

import javax.inject.Inject;

public class Logger {

    private TagsProvider tagsProvider;

    public Logger(TagsProvider tagsProvider) {
        this.tagsProvider = tagsProvider;
    }

    public void logHiringDesigner(DesignerService designerService) {
        System.out.println("A designer was hired.");
    }

}
