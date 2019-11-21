package vn.mila.example.start;

import vn.mila.example.base.IEvent;
import vn.mila.example.command.AccountCommand;
import vn.mila.example.command.UserCommand;

/**
 * Copyright by Intelin.
 * Creator: Nguyen Ngoc Chau
 * Date: 11/20/19
 * Time: 10:40 AM
 */
public enum Event implements IEvent {
    USER("user", UserCommand.class),
    ACCOUNT("account", AccountCommand.class);

    private String description;
    private Class command;

    Event(String description, Class command) {
        this.description = description;
        this.command = command;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Class getCommand() {
        return command;
    }
}
