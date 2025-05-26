/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import repository.PassengerRepository;
import model.Passenger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús
 */
public class InMemoryPassengerRepository implements PassengerRepository {

    private final List<Passenger> passengers;

    public InMemoryPassengerRepository(List<Passenger> initialData) {
        this.passengers = initialData;
    }

    @Override
    public List<Passenger> getAll() {
        return new ArrayList<>(passengers); // copia defensiva
    }

    @Override
    public Passenger findById(long id) {
        return passengers.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        int index = -1;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getId() == passenger.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            passengers.set(index, passenger);
        }
    }

    @Override
    public boolean exists(long id) {
        return passengers.stream().anyMatch(p -> p.getId() == id);
    }
}
