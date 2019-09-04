package tq.spelling.web.adapters;

import com.google.inject.Guice;
import com.google.inject.Injector;
import pl.tq.apilimiter.config.ApiLimiterModule;
import pl.tq.spelling.service.mp3Provider.PollyMp3Provider;
import pl.tq.spelling.service.sentence.SentencePollyService;
import pl.tq.spelling.service.sentence.SentenceService;
import pl.tq.spelling.service.sentence.cache.SentenceCache;
import pl.tq.spelling.util.Config;

public class PollyAdapter {
    private static Injector injector;

    public static String getMp3ForSentence(String sentence) {
        if( injector == null ) {
            injector = Guice.createInjector(new ApiLimiterModule());
        }
        Config config = injector.getInstance(Config.class);
        PollyMp3Provider pollyMp3Provider = injector.getInstance(PollyMp3Provider.class);
        SentenceService sentenceService = new SentencePollyService(new SentenceCache(config.getValue("mp3CacheDirectory")), pollyMp3Provider);
        return sentenceService.getAudio(sentence);

    }
}
