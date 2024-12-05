package mk.finki.ukim.mk.lab1_a.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@NoArgsConstructor

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String name;
    private String description;
    private double popularityScore;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Location location;

    private int nrTicketsPerEvent;


    public Event(String name, String description, double popularityScore, Category category,Location location, int nrTicketsPerEvent) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.category=category;
       // this.id= (long)(Math.random()*1000);
        this.location=location;
        this.nrTicketsPerEvent=nrTicketsPerEvent;
    }



}
