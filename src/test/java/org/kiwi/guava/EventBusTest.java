package org.kiwi.guava;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EventBusTest {
    @Test
    public void should_save_message_by_event_bus() {
        EventBus eventBus = new EventBus();
        MessageListener listener = new MessageListener();
        eventBus.register(listener);
        eventBus.post("Hello");
        assertThat(listener.getMessage(), is("Hello"));
    }
}
