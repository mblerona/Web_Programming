package mk.finki.ukim.mk.lab1_a.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import mk.finki.ukim.mk.lab1_a.model.Category;
import mk.finki.ukim.mk.lab1_a.model.Event;
import mk.finki.ukim.mk.lab1_a.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Event> events = new ArrayList<>(10);
    public static List<Location> locations = new ArrayList<>(5);

    //@PostConstruct
//    public void init() {
//        Location locationArt = new Location("Museum of art", "Skopje", "500", "Museum in Skopje");
//        Location locationCafe = new Location("Street Cafe", "Budapest", "100", "Cafe in Budapest");
//        Location locationLab = new Location("ScienceLab", "Vienna", "350", "Amphitheater in Vienna");
//
//        locations.add(locationArt);
//        locations.add(locationCafe);
//        locations.add(locationLab);
//
//        events.add(new Event("Halloween", "Halloween party", 8.7, Category.THEME_PARTY, locationCafe,10));
//        events.add(new Event("New Year", "New Year party", 9.3, Category.THEME_PARTY, locationCafe,5));
//        events.add(new Event("April Fools", "April Fools party", 3.4, Category.THEME_PARTY, locationCafe,7));
//        events.add(new Event("Gallery Exhibition", "Art related gallery", 8.5, Category.ART, locationArt,20));
//        events.add(new Event("Rock Music Night", "RocknRoll lovers", 9.8, Category.MUSIC, locationCafe,2));
//        events.add(new Event("Space Exploring", "Learn more about space", 10.0, Category.SCIENCE, locationLab,100));
//    }
}
