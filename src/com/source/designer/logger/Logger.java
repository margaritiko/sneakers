package com.source.designer.logger;


import com.source.designer.service.Designer;

public class Logger {

    private TagsProvider tagsProvider;

    public Logger(TagsProvider tagsProvider) {
        this.tagsProvider = tagsProvider;
    }

    public void logHiringDesigner(Designer designer, String message) {
        System.out.println(String.format("A %s designer was hired.", message));
    }

}
