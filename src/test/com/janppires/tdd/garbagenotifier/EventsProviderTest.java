package com.janppires.tdd.garbagenotifier;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class EventsProviderTest {

    @Test
    public void hasListWithOneEvent() {
        List<Event> events = Arrays.asList(new Event("a", null, "b"));
        assertThat(new EventsProvider(events).getEvents(), hasSize(1));
    }

}