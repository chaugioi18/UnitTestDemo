package vn.mila.example.start;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.mila.example.base.IConsumer;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 10:28 AM
 */
public class App extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static Injector injector;

    @Override
    public void start() throws Exception {
        LOGGER.info("Starting services...");
        injector = Guice.createInjector(new ModuleConfig(context));
        IConsumer consumer = injector.getInstance(ConsumerImpl.class);
        consumer
                .initMap()
                .usingRestful();
    }

}
