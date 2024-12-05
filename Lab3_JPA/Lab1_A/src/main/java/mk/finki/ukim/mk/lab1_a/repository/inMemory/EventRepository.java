//package mk.finki.ukim.mk.lab1_a.repository.inMemory;
//
//import mk.finki.ukim.mk.lab1_a.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab1_a.model.Category;
//import mk.finki.ukim.mk.lab1_a.model.Event;
//import mk.finki.ukim.mk.lab1_a.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class EventRepository {
//    public List<Event> findAll(){
//        return DataHolder.events;
//    }
//
//    public List<Event> searchEvents(String text){
//        return DataHolder.events.stream()
//                .filter(c -> c.getName().contains(text) ||
//                        c.getDescription().contains(text))
//                .toList();
//    }
//
////    public Event save(Event event) {
////        // If the category already exists, remove it and add the new one
////        DataHolder.categories.removeIf(c -> c.getName().equals(category.getName()));
////
////        DataHolder.categories.add(category);
////
////        return category;
////    }
//
//    public List<Event> searchByCategory(Category category){
//        return DataHolder.events.stream()
//                .filter(event -> event.getCategory().equals(category))
//                .collect(Collectors.toList());
//
//    }
//    public Optional<Event> findById(long id){
//        return DataHolder.events
//                .stream()
//                .filter(i->i.getId().equals(id))
//                .findFirst();
//    }
//
//    public void deleteById(long id){
//        DataHolder.events.removeIf(i->i.getId().equals(id));
//    }
//   //String name, String description, Double popularityScore, Location location
//
//    public Optional <Event> save(String name, String description, double popularityScore, Category category,Location location, int nrTicketsPerEvent){
//        DataHolder.events.removeIf(i->i.getName().equals(name));
//
//        Event event= new Event(name,description,popularityScore,category,location,nrTicketsPerEvent);
//        DataHolder.events.add(event);
//        return Optional.of(event);
//
//    }
//    public Optional<Event>findByName(String name){
//        return DataHolder.events
//                .stream()
//                .filter(i->i.getName().equals(name))
//                .findFirst();
//    }
//
//    public void saveNrTickets(Event event, int newTicketCount) {
//        event.setNrTicketsPerEvent(newTicketCount);
//    }
//
//
//}
