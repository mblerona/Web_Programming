//package mk.finki.ukim.mk.lab1_a.repository.inMemory;
//
//import mk.finki.ukim.mk.lab1_a.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab1_a.model.Event;
//import mk.finki.ukim.mk.lab1_a.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class LocationRepository {
//    public List<Location> findAll(){
//        return DataHolder.locations;
//    }
//    public Optional<Location> findById(long id){
//        return DataHolder.locations
//                .stream()
//                .filter(i->i.getId().equals(id))
//                .findFirst();
//    }
//
//}
