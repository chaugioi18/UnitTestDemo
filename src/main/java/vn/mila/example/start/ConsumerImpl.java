package vn.mila.example.start;

import com.google.gson.Gson;
import com.google.inject.Inject;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.mila.example.base.ICommand;
import vn.mila.example.base.IConsumer;
import vn.mila.example.base.IEvent;
import vn.mila.example.handler.IMainLogic;

import java.util.Map;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 5/23/19
 * Time: 10:21 AM
 */
public class ConsumerImpl implements IConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Vertx vertx;
    private Config config;
    private IMainLogic mainLogic;
    private Gson gson;
    private Map<IEvent, ICommand> map;

    @Inject
    ConsumerImpl(Vertx vertx,
                 Config config,
                 IMainLogic mainLogic,
                 Gson gson,
                 Map<IEvent, ICommand> map) {
        this.vertx = vertx;
        this.config = config;
        this.mainLogic = mainLogic;
        this.gson = gson;
        this.map = map;
    }

    @Override
    public IConsumer initMap() {
        LOGGER.info("Start set event map");
        for (Event event : Event.values()) {
            ICommand command = (ICommand) App.injector.getInstance(event.getCommand());
            map.put(event, command);
        }
        return this;
    }

    @Override
    public IConsumer usingRestful() {
        LOGGER.info("Init API ");
        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setHost(config.getHost()).setPort(config.getPort()));
        Router router = Router.router(vertx);
        router.post(config.getApi()).handler(context->{
            context.request().bodyHandler(body->{
                LOGGER.info("Receive body {}", body);
                String username = body.toJsonObject().getString("username");
                context.response().end(gson.toJsonTree(mainLogic.getListAccount(username)).toString());
            });
        });


        server.requestHandler(router);
        LOGGER.info("Start restful user services");
        server.listen(event -> {
            if (event.succeeded()) {
                LOGGER.info("Listen on port {}", config.getPort());
            } else {
                LOGGER.info("Listen failed on port {} cause by {}", config.getPort(), event.cause().getMessage());
            }
        });
        return this;
    }

}
