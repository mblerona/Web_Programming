package mk.finki.ukim.mk.lab1_a.repository.jpa;

import mk.finki.ukim.mk.lab1_a.model.Category;
import mk.finki.ukim.mk.lab1_a.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByLocation_Id(Long locationId);

    Optional<Event> findEventByName(String name);

    @Query("SELECT e FROM Event e WHERE " +
            "LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%')) OR " +
            "(:category IS NULL OR e.category = :category) OR " +
            "LOWER(e.description) LIKE LOWER(CONCAT('%', :description, '%'))")
    List<Event> searchByNameCategoryOrDescription(
            @Param("name") String name,
            @Param("category") Category category,
            @Param("description") String description
    );

    List<Event> findEventByCategory(Category category);
}
