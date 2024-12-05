package mk.finki.ukim.mk.lab1_a.service.impl;

import mk.finki.ukim.mk.lab1_a.model.Category;
import mk.finki.ukim.mk.lab1_a.model.Event;
import mk.finki.ukim.mk.lab1_a.model.Location;
import mk.finki.ukim.mk.lab1_a.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab1_a.model.exceptions.LocationNotFoundException;
import mk.finki.ukim.mk.lab1_a.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab1_a.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab1_a.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }



    @Override
    public List<Event> searchEvents(String text) {
        if (text == null || text.isEmpty()) {
            return this.eventRepository.findAll();
        }
        return this.eventRepository.searchByNameCategoryOrDescription(text, null, text);
    }


    @Override
    public List<Event> findByCategory(Category category) {
        return eventRepository.findEventByCategory(category);
    }

    @Override
    public void deleteById(Long id) {
        this.eventRepository.deleteById(id);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return this.eventRepository.findById(id);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Category category, Long locationId, int nrTickets) throws LocationNotFoundException {
        Location location = this.locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException(locationId));

        // Don't set the ID manually; let the database handle it
        Event event = new Event(name, description, popularityScore, category, location, nrTickets);
        return Optional.of(this.eventRepository.save(event));
    }

    @Override
    public void update(Long eventId, String name, String description, Double popularityScore, Category category, Location location, int nrTickets) {
        Event event = this.eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException(eventId));

        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setCategory(category);
        event.setLocation(location);
        event.setNrTicketsPerEvent(nrTickets);

        this.eventRepository.save(event);
    }

    @Override
    public void decrementNrTickets(Long eventId, int nrTickets) {
        Event event = this.eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found: " + eventId));

        int availableTickets = event.getNrTicketsPerEvent();
        if (availableTickets < nrTickets) {
            throw new IllegalArgumentException("Not enough tickets available for this event.");
        }

        event.setNrTicketsPerEvent(availableTickets - nrTickets);
        this.eventRepository.save(event);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return eventRepository.findEventByName(name);
    }
}
