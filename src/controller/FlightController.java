/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Flight;
import model.Plane;
import model.Location;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class FlightController {

    private ArrayList<Flight> flights;

    public FlightController(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public Response registerFlight(String id, Plane plane, Location origin, Location destination,
            LocalDateTime date, int hours, int minutes) {
        if (id == null || id.isBlank()) {
            return new Response(400, "ID vacío");
        }
        if (plane == null) {
            return new Response(400, "Avión no seleccionado");
        }
        if (origin == null || destination == null) {
            return new Response(400, "Ubicación no válida");
        }
        if (origin.getAirportId().equals(destination.getAirportId())) {
            return new Response(400, "Origen y destino no pueden ser iguales");
        }
        if (date == null) {
            return new Response(400, "Fecha no válida");
        }
        if (hours < 0 || minutes < 0) {
            return new Response(400, "Duración inválida");
        }

        for (Flight f : flights) {
            if (f.getId().equalsIgnoreCase(id)) {
                return new Response(400, "Ya existe un vuelo con ese ID");
            }
        }

        Flight flight = new Flight(id, plane, origin, destination, date, hours, minutes);
        flights.add(flight);
        return new Response(200, "Vuelo registrado correctamente");
    }

    public Response addPassengerToFlight(String flightId, model.Passenger passenger) {
        if (flightId == null || flightId.isBlank()) {
            return new Response(400, "ID de vuelo vacío");
        }
        if (passenger == null) {
            return new Response(400, "Pasajero inválido");
        }
        for (Flight f : flights) {
            if (f.getId().equalsIgnoreCase(flightId)) {
                
                // Validar si ya está
                for (model.Passenger p : f.getPassengers()) {
                    if (p.getId() == passenger.getId()) {
                        return new Response(400, "Este pasajero ya está en el vuelo");
                    }
                }

                // Validar capacidad del avión
                if (f.getNumPassengers() >= f.getPlane().getMaxCapacity()) {
                    return new Response(400, "El vuelo ya está lleno");
                }

                f.addPassenger(passenger);
                passenger.addFlight(f);   
                
                return new Response(200, "Pasajero añadido al vuelo correctamente");
            }
        }
        
        return new Response(404, "Vuelo no encontrado");
    }

}
