package com.janppires.tdd.garbagenotifier;

import java.util.List;

public class EventsProvider {
    private List<Event> events;

    public EventsProvider(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEvents() {
        return this.events;
    }
}
