package com.source.designer.logger;

import dagger.Module;
import dagger.Provides;

import java.util.ArrayList;
import java.util.Arrays;

@Module
public class LoggerModule {

    @Provides
    static TagsProvider provideTagsProvider() {
        return new TagsProvider(new ArrayList<>(Arrays.asList(Tag.FEATURE, Tag.DEBUG)));
    }

    @Provides
    static Logger provideLogger(TagsProvider tagsProvider) {
        return new Logger(tagsProvider);
    }

}
