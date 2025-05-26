/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Plane;
import java.util.ArrayList;
import repository.PlaneRepository;
import validator.PlaneValidator;

/**
 *
 * @author Jesús
 */
public class PlaneController {
    
    private final PlaneRepository repository;

    public PlaneController(PlaneRepository repository) {
        this.repository = repository;
    }

    public Response registerPlane(String id, String brand, String model, int capacity, String airline) {
        String error = PlaneValidator.validate(id, brand, model, capacity);
        if (error != null) return new Response(400, error);

        if (repository.exists(id)) return new Response(400, "Ya existe un avión con ese ID");

        Plane plane = new Plane(id, brand, model, capacity, airline);
        repository.save(plane);

        return new Response(200, "Avión registrado correctamente");
    }

//    public Response updatePlane(String id, String brand, String model, int capacity, String airline) {
//        String error = PlaneValidator.validate(id, brand, model, capacity);
//        if (error != null) return new Response(400, error);
//
//        Plane plane = repository.findById(id);
//        if (plane == null) return new Response(404, "Avión no encontrado");
//
//        // Actualizar campos
//        plane.setBrand(brand);
//        plane.setModel(model);
//        plane.setAirline(airline);
//        // No se puede cambiar el ID ni la capacidad máxima en este caso
//
//        repository.update(plane);
//        return new Response(200, "Avión actualizado correctamente");
//    }
    
}
