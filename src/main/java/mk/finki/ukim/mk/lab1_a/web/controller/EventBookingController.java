package mk.finki.ukim.mk.lab1_a.web.controller;

import mk.finki.ukim.mk.lab1_a.model.Event;
import mk.finki.ukim.mk.lab1_a.model.EventBooking;
import mk.finki.ukim.mk.lab1_a.model.exceptions.LocationNotFoundException;
import mk.finki.ukim.mk.lab1_a.service.EventBookingService;
import mk.finki.ukim.mk.lab1_a.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {

    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

//    @PostMapping
//    public String bookEvent(@RequestParam String eventName,
//                            @RequestParam String attendeeName,
//                            @RequestParam String clientIpAddress,
//                            @RequestParam int numTickets,
//                            Model model) {
//
//        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, clientIpAddress, numTickets);
//
//
//        model.addAttribute("booking", booking);
//
//
//        return "bookingConfirmation";
//    }

    @PostMapping
    public String bookEvent(@RequestParam String eventName,
                            @RequestParam String attendeeName,
                            @RequestParam String clientIpAddress,
                            @RequestParam int numTickets,
                            Model model) throws LocationNotFoundException {


        Event event = eventService.findByName(eventName)
                .orElseThrow(() -> new IllegalArgumentException("Event not found: " + eventName));


        int availableTickets = event.getNrTicketsPerEvent();
        if (availableTickets < numTickets) {
            // Not enough tickets available, show error message
            model.addAttribute("error", "Not enough tickets available for " + eventName + ".");
            return "redirect:/events?error=NotEnoughTickets";
        }

        event.setNrTicketsPerEvent(availableTickets - numTickets);
      eventService.save(event.getName(),event.getDescription(), event.getPopularityScore(), event.getCategory(), event.getLocation().getId(),event.getNrTicketsPerEvent());

        EventBooking booking = eventBookingService.placeBooking(eventName, attendeeName, clientIpAddress, numTickets);
        model.addAttribute("booking", booking);

        return "bookingConfirmation";
    }

}
