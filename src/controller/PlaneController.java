/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import model.Plane;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class PlaneController {
    
    private ArrayList<Plane> planes;

    public PlaneController(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    public Response registerPlane(String id, String brand, String model, int capacity, String airline) {
        
        String error = validator.PlaneValidator.validate(id, brand, model, capacity);
        if (error != null) return new Response(400, error);


        for (Plane p : planes) {
            if (p.getId().equals(id)) return new Response(400, "Ya existe un avión con ese ID");   
        }

        Plane plane = new Plane(id, brand, model, capacity, airline);
        planes.add(plane);
        return new Response(200, "Avión registrado correctamente");
    }
    
}
