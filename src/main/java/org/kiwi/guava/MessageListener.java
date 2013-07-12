package org.kiwi.guava;

import com.google.common.eventbus.Subscribe;

public class MessageListener {
    private String message;

    @Subscribe
    public void receiveMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
