package com.janppires.tdd.garbagenotifier;

import java.util.List;

public class GarbageNotifier {

    private boolean notificationEnabled;
    private EventsProvider eventsProvider;
    private EmailProvider emailProvider;

    public GarbageNotifier(boolean notificationEnabled, EventsProvider eventsProvider, EmailProvider emailProvider) {
        this.notificationEnabled = notificationEnabled;
        this.eventsProvider = eventsProvider;
        this.emailProvider = emailProvider;
    }

    public boolean isNotificationEnabled() {
        return this.notificationEnabled;
    }

    public boolean toggleNotification() {
        this.notificationEnabled = !this.notificationEnabled;
        return this.notificationEnabled;
    }

    public List<Event> getEvents() {
        return eventsProvider.getEvents();
    }

    public Event getNextEvent() {
        return eventsProvider.getEvents().get(0);
    }


    public boolean sendEmail() {
        Event event = getNextEvent();
        String recipient=  "andre@bla.com";
        String subject = "Garbage Collection: " + event.getGarbageType() + ": " + event.getDate() + " at " + event.getTime();
        String body = "Dear Andre, your next " + event.getGarbageType() + " collection will be tomorrow morning at " + event.getTime();
        emailProvider.sendEmail(new Email(recipient, subject, body));
        return true;
    }
}
