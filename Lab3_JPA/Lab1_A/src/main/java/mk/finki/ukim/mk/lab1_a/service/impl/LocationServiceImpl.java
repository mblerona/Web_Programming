package mk.finki.ukim.mk.lab1_a.service.impl;

import mk.finki.ukim.mk.lab1_a.model.Location;
import mk.finki.ukim.mk.lab1_a.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab1_a.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();

    }

    @Override
    public Optional<Location> findById(Long id) {

            return this.locationRepository.findById(id);


    }

}
