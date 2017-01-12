package com.janppires.tdd.garbagenotifier;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GarbageNotifierTest {

    @Test
    public void isNotificationEnabled() {
        assertEquals(true, new GarbageNotifier(true, null, null).isNotificationEnabled());
    }

    @Test
    public void enableNotification() {
        assertEquals(true, new GarbageNotifier(false, null, null).toggleNotification());
    }

    @Test
    public void containsOneEventConfigured() {
        List<Event> events = Arrays.asList(new Event("bal", null, "ble"));
        EventsProvider eventsProvider = new EventsProvider(events);
        assertThat(new GarbageNotifier(true, eventsProvider, null).getEvents(), hasSize(1));
    }

    @Test
    public void getsNextEvent(){
        Event event = new Event("bla", null, "ble");
        List<Event> events = Arrays.asList(event);
        EventsProvider eventsProvider = new EventsProvider(events);
        assertEquals(event, new GarbageNotifier(true, eventsProvider, null).getNextEvent());
    }

    @Test
    public void sendEmailWithSubjectAndBody(){
        Email email = new Email("andre@bla.com","Garbage Collection: PLASTIC: 16-01-2017 at 9AM", "Dear Andre, your next PLASTIC collection will be tomorrow morning at 9AM");
        EventsProvider eventsProvider = new EventsProvider(Arrays.asList(new Event("16-01-2017", "9AM", "PLASTIC")));
        EmailProvider emailProvider = mock(EmailProvider.class);
        assertThat(new GarbageNotifier(true, eventsProvider, emailProvider).sendEmail(), is(true));
        verify(emailProvider, times(1)).sendEmail(email);
    }
}