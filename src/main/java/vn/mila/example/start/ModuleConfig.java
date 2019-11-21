package vn.mila.example.start;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.mila.example.base.ICommand;
import vn.mila.example.base.IEvent;
import vn.mila.example.handler.ILogic;
import vn.mila.example.handler.IMainLogic;
import vn.mila.example.handler.LogicImpl;
import vn.mila.example.handler.MainLogicImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 10:33 AM
 */
public class ModuleConfig extends AbstractModule {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Vertx vertx;
    private Config config;
    private Gson gson;

    public ModuleConfig(Context context) {
        this.gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .create();
        if (!context.config().isEmpty()) {

            this.config = gson.fromJson(context.config().encodePrettily(), Config.class);
        } else {
            this.config = gson.fromJson("{\n" +
                    "    \"host\":\"localhost\",\n" +
                    "    \"port\":9980,\n" +
                    "    \"api\":\"/test/auth\"\n" +
                    "}", Config.class);
        }
        this.vertx = Vertx.vertx(new VertxOptions()
                .setWorkerPoolSize(4)
                .setMaxWorkerExecuteTime(10000));
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return gson;
    }

    @Provides
    @Singleton
    public Vertx getVertx() {
        return this.vertx;
    }

    @Provides
    @Singleton
    public Config getConfig() {
        return this.config;
    }

    @Provides
    @Singleton
    public Map<IEvent, ICommand> getEventMap() {
        return new HashMap<>();
    }

    @Override
    protected void configure() {
        bind(ILogic.class).to(LogicImpl.class).in(Scopes.SINGLETON);
        bind(IMainLogic.class).to(MainLogicImpl.class).in(Scopes.SINGLETON);
    }



}
