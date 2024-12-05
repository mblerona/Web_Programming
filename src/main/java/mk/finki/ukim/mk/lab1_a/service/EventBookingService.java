package mk.finki.ukim.mk.lab1_a.service;

import mk.finki.ukim.mk.lab1_a.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}
