/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import repository.LocationRepository;
import model.Location;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class InMemoryLocationRepository implements LocationRepository {
    private final List<Location> locations;

    public InMemoryLocationRepository(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public List<Location> getAll() {
        return new ArrayList<>(locations);
    }

    @Override
    public Location findById(String id) {
        return locations.stream().filter(l -> l.getAirportId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Location location) {
        locations.add(location);
    }

    @Override
    public boolean exists(String id) {
        return locations.stream().anyMatch(l -> l.getAirportId().equals(id));
    }
}
