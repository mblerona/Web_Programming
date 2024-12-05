package mk.finki.ukim.mk.lab1_a.web.controller;

import mk.finki.ukim.mk.lab1_a.model.Category;
import mk.finki.ukim.mk.lab1_a.model.Event;
import mk.finki.ukim.mk.lab1_a.model.Location;
import mk.finki.ukim.mk.lab1_a.model.exceptions.LocationNotFoundException;
import mk.finki.ukim.mk.lab1_a.service.EventService;
import mk.finki.ukim.mk.lab1_a.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    private void populateFormAttributes(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("categories", Category.values());
    }


//    @GetMapping
//    public String getEventsPage(@RequestParam(required = false) String error,
//                                @RequestParam(required = false) String eventName,
//                                @RequestParam(required = false, defaultValue = "0.0") double minRating,
//                                @RequestParam(required = false) Category category,
//                                Model model) {
//        if (error != null && !error.isEmpty()) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", error);
//        }
//
//        List<Event> filteredEvents = eventService.listAll().stream()
//                .filter(event -> (eventName == null || event.getName().toLowerCase().contains(eventName.toLowerCase())))
//                .filter(event -> event.getPopularityScore() >= minRating)
//                .filter(event -> (category == null || event.getCategory() == category))
//                .collect(Collectors.toList());
//
//        model.addAttribute("events", filteredEvents);
//        model.addAttribute("categories", Category.values());
//        return "listEvents";
//    }


    //GET UPDATED:
    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) String eventName,
                                @RequestParam(required = false, defaultValue = "0.0") double minRating,
                                @RequestParam(required = false) Category category,
                                Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        // Fetch events dynamically from the database
        List<Event> events = eventService.listAll().stream()
                .filter(event -> (eventName == null || event.getName().toLowerCase().contains(eventName.toLowerCase())))
                .filter(event -> event.getPopularityScore() >= minRating)
                .filter(event -> (category == null || event.getCategory() == category))
                .collect(Collectors.toList());

        model.addAttribute("events", events);
        model.addAttribute("categories", Category.values());
        return "listEvents"; // Render listEvents.html
    }

    @PostMapping
    public String bookEvent(@RequestParam String eventName,
                            @RequestParam int numTickets,
                            Model model) {
        String attendeeName = "Petko Petkov";
        String clientIpAddress = "";

        model.addAttribute("eventName", eventName);
        model.addAttribute("attendeeName", attendeeName);
        model.addAttribute("clientIpAddress", clientIpAddress);
        model.addAttribute("numberOfTickets", numTickets);

        return "bookingConfirmation";
    }

    @GetMapping("/add-form")
    public String showAddEventForm(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("categories", Category.values());
       // model.addAttribute("nrTickets", eventService.);
        return "addEvent";
    }

//    @PostMapping("/add")
//    public String saveEvent(@RequestParam String name,
//                            @RequestParam String description,
//                            @RequestParam Double popularityScore,
//                            @RequestParam Category category,
//                            @RequestParam Long locationId,
//                            @RequestParam int nrTickets) throws LocationNotFoundException {
//        this.eventService.save(name, description, popularityScore, category, locationId,nrTickets);
//        return "redirect:/events";
//    }


    //UPDATEDDDDDDD ADD

    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Category category,
                            @RequestParam Long locationId,
                            @RequestParam int nrTickets,
                            Model model) {
        try {
            eventService.save(name, description, popularityScore, category, locationId, nrTickets);
            return "redirect:/events"; // Redirect to list all events
        } catch (Exception e) {
            // Handle errors and reload the form with error details
            model.addAttribute("error", e.getMessage());
            populateFormAttributes(model);
            return "addEvent";
        }
    }



//    @GetMapping("/edit-form/{eventId}")
//    public String showEditEventForm(@PathVariable Long eventId, Model model) {
//        if (this.eventService.findById(eventId).isPresent()) {
//            Event event = this.eventService.findById(eventId).get();
//
//            List<Location> locations = this.locationService.findAll();
//            model.addAttribute("locations", locations);
//            model.addAttribute("event", event);
//            model.addAttribute("categories", Category.values());
//            model.addAttribute("nrTickets",event.getNrTicketsPerEvent());
//            return "editEvent";
//        }
//        return "redirect:/events?error=EventNotFound";
//    }

    //UPDATEEEEEEEEED

    @GetMapping("/edit-form/{eventId}")
    public String showEditEventForm(@PathVariable Long eventId, Model model) {
        if (eventService.findById(eventId).isPresent()) {
            Event event = eventService.findById(eventId).get();
            model.addAttribute("event", event);
            populateFormAttributes(model);
            return "editEvent"; // Render editEvent.html
        }
        return "redirect:/events?error=EventNotFound";
    }





//    @PostMapping("/edit/{eventId}")
//    public String updateEvent(@PathVariable Long eventId,
//                              @RequestParam String name,
//                              @RequestParam String description,
//                              @RequestParam Double popularityScore,
//                              @RequestParam Category category,
//                              @RequestParam Long locationId,
//                              @RequestParam int nrTickets) throws LocationNotFoundException {
//        Location location = this.locationService.findById(locationId)
//                .orElseThrow(() -> new LocationNotFoundException(locationId));
//        this.eventService.update(eventId, name, description, popularityScore, category, location,nrTickets);
//        return "redirect:/events";
//    }

    //UPDATED:
    @PostMapping("/edit/{eventId}")
    public String updateEvent(@PathVariable Long eventId,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Double popularityScore,
                              @RequestParam Category category,
                              @RequestParam Long locationId,
                              @RequestParam int nrTickets,
                              Model model) {
        try {
            Location location = locationService.findById(locationId)
                    .orElseThrow(() -> new LocationNotFoundException(locationId));
            eventService.update(eventId, name, description, popularityScore, category, location, nrTickets);
            return "redirect:/events";
        } catch (Exception e) {
            // Handle errors and reload the form with error details
            model.addAttribute("error", e.getMessage());
            populateFormAttributes(model);
            return "editEvent";
        }
    }

    @GetMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
        this.eventService.deleteById(eventId);
        return "redirect:/events";
    }
}
