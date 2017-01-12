package com.janppires.tdd.garbagenotifier;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SendGarbageCollectionNotificationTest {

    private GarbageNotifier garbageNotifier;

    @Test
    public void emailIsSentAt9pToTheCustomerNotifyingNextGarbageCollection() {
        Event plasticEvent = new Event("16-01-2017", "9AM", "PLASTIC");
        List<Event> events = Arrays.asList(plasticEvent);
        EventsProvider eventsProvider = new EventsProvider(events);

        EmailProvider emailProvider = mock(EmailProvider.class);

        Email email = new Email("andre@bla.com", "Garbage Collection: PLASTIC: 16-01-2017 at 9AM", "Dear Andre, your next PLASTIC collection will be tomorrow morning at 9AM");
        garbageNotifier = new GarbageNotifier(true, eventsProvider, emailProvider);

        assertEquals(plasticEvent, nextDayEventIs());
        assertEquals(true, emailIsSentAt9pm());
        verify(emailProvider, times(1)).sendEmail(email);
    }

    private Event nextDayEventIs() {
        return garbageNotifier.getNextEvent();
    }

    private boolean emailIsSentAt9pm() {
        return garbageNotifier.sendEmail();
    }
}
