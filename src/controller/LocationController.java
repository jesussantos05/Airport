/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Location;
import java.util.ArrayList;
import repository.LocationRepository;
import validator.LocationValidator;

/**
 *
 * @author Jesús
 */
public class LocationController {
    
    private final LocationRepository repository;

    public LocationController(LocationRepository repository) {
        this.repository = repository;
    }

    public Response registerLocation(String id, String name, String city, String country,
                                     double lat, double lon) {
        String error = LocationValidator.validate(id, city, country, lat, lon);
        if (error != null) return new Response(400, error);

        if (repository.exists(id)) return new Response(400, "Ya existe una ubicación con ese ID");

        Location location = new Location(id, name, city, country, lat, lon);
        repository.save(location);

        return new Response(200, "Ubicación registrada correctamente");
    }
}
