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
        if (id == null || id.isBlank()) return new Response(400, "ID vacío");
        if (name == null || name.isBlank()) return new Response(400, "Nombre vacío");
        if (city == null || city.isBlank()) return new Response(400, "Ciudad vacía");
        if (country == null || country.isBlank()) return new Response(400, "País vacío");
        if (lat < -90 || lat > 90) return new Response(400, "Latitud inválida");
        if (lon < -180 || lon > 180) return new Response(400, "Longitud inválida");

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
