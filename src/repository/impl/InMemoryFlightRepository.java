/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import repository.FlightRepository;
import model.Flight;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class InMemoryFlightRepository implements FlightRepository{
    
    private final List<Flight> flights;

    public InMemoryFlightRepository(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> getAll() {
        return new ArrayList<>(flights); // copia defensiva
    }

    @Override
    public Flight findByCode(String code) {
        return flights.stream()
                .filter(f -> f.getId().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Flight flight) {
        flights.add(flight);
    }

    @Override
    public boolean exists(String code) {
        return flights.stream().anyMatch(f -> f.getId().equals(code));
    }
    
    @Override
    public Flight findById(String id) {
        for (Flight f : flights) {
            if (f.getId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void update(Flight flight) {
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId().equalsIgnoreCase(flight.getId())) {
                flights.set(i, flight);
                return;
            }
        }
    }
 
}
