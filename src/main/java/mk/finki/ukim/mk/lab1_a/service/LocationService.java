package mk.finki.ukim.mk.lab1_a.service;

import mk.finki.ukim.mk.lab1_a.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService  {
    public List<Location> findAll();
    Optional<Location> findById(Long id);


}
