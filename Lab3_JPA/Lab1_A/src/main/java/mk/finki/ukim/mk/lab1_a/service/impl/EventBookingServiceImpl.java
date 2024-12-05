package mk.finki.ukim.mk.lab1_a.service.impl;

import mk.finki.ukim.mk.lab1_a.model.EventBooking;
import mk.finki.ukim.mk.lab1_a.service.EventBookingService;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {
    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        if(eventName==null||eventName.isEmpty() || attendeeName==null||attendeeName.isEmpty()){
            throw new IllegalArgumentException();
        }
    EventBooking eventBooking=new EventBooking(eventName,attendeeName,attendeeAddress,(long)numberOfTickets);

    return eventBooking;
    }
}
