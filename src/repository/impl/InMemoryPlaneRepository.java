/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import repository.PlaneRepository;
import model.Plane;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class InMemoryPlaneRepository implements PlaneRepository{
    private final List<Plane> planes;

    public InMemoryPlaneRepository(List<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public List<Plane> getAll() {
        return new ArrayList<>(planes); // copia defensiva
    }

    @Override
    public Plane findById(String id) {
        return planes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Plane plane) {
        planes.add(plane);
    }

    @Override
    public boolean exists(String id) {
        return planes.stream().anyMatch(p -> p.getId().equals(id));
    }
}
