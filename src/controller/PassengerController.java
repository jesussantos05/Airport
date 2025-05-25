/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jesús
 */
public class PassengerController {
    private ArrayList<Passenger> passengers;

    public PassengerController(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Response registerPassenger(long id, String first, String last, LocalDate birthDate,
                                      int code, long phone, String country) {
        
        if (id < 0 || String.valueOf(id).length() > 15) return new Response(400, "ID inválido");
        if (first.isEmpty() || last.isEmpty() || country.isEmpty()) return new Response(400, "Campos vacíos");
        if (birthDate == null) return new Response(400, "Fecha inválida");
        if (code < 0 || String.valueOf(code).length() > 3) return new Response(400, "Código país inválido");
        if (phone < 0 || String.valueOf(phone).length() > 11) return new Response(400, "Teléfono inválido");

        for (Passenger p : passengers) {
            
            if (p.getId() == id) return new Response(400, "Ya existe un pasajero con ese ID");
            
        }

        Passenger p = new Passenger(id, first, last, birthDate, code, phone, country);
        passengers.add(p);
        return new Response(200, "Pasajero registrado correctamente");
        
    }
    
}
