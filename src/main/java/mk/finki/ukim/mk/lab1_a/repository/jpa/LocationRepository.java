package mk.finki.ukim.mk.lab1_a.repository.jpa;

import mk.finki.ukim.mk.lab1_a.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {


}
