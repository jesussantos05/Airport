/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Location;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class LocationController {
    
    
    private ArrayList<Location> locations;

    public LocationController(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Response registerLocation(String id, String name, String city, String country, double lat, double lon) {
        
        String error = validator.LocationValidator.validate(id, city, country, lat, lon);
        if (error != null) return new Response(400, error);
        
        for (Location loc : locations) {
            if (loc.getAirportId().equalsIgnoreCase(id)) {
                return new Response(400, "Ya existe una ubicación con ese ID");
            }
        }

        Location location = new Location(id, name, city, country, lat, lon);
        locations.add(location);
        return new Response(200, "Ubicación registrada correctamente");
    }
    
}
