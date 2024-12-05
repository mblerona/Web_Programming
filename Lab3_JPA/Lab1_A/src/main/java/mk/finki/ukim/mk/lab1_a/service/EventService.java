package mk.finki.ukim.mk.lab1_a.service;

import mk.finki.ukim.mk.lab1_a.model.Category;
import mk.finki.ukim.mk.lab1_a.model.Event;
import mk.finki.ukim.mk.lab1_a.model.Location;
import mk.finki.ukim.mk.lab1_a.model.exceptions.LocationNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    public List<Event> findByCategory(Category category);
    void deleteById(Long id);
    Optional<Event> findById(Long id);

    Optional<Event> save(String name, String description, double popularityScore, Category category, Long locationId, int nrTickets) throws LocationNotFoundException;
    void update(Long eventId, String name, String description, Double popularityScore,Category category ,Location location, int nrTickets);

    void decrementNrTickets (Long eventId, int nrTickets);
    Optional<Event> findByName(String name);

   // public void updateByEvent(Event event);
}
