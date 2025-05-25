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

        String error = validator.PassengerValidator.validate(id, first, last, birthDate, code, phone, country);
        if (error != null) return new Response(400, error);


        for (Passenger p : passengers) {

            if (p.getId() == id) {
                return new Response(400, "Ya existe un pasajero con ese ID");
            }

        }

        Passenger p = new Passenger(id, first, last, birthDate, code, phone, country);
        passengers.add(p);
        return new Response(200, "Pasajero registrado correctamente");

    }

    public Response updatePassenger(long id, String first, String last, LocalDate birthDate,
            int code, long phone, String country) {

        String error = validator.PassengerValidator.validate(id, first, last, birthDate, code, phone, country);
        if (error != null) return new Response(400, error);


        for (Passenger p : passengers) {
            if (p.getId() == id) {
                // Actualiza los campos
                p.setFirstname(first);
                p.setLastname(last);
                p.setBirthDate(birthDate);
                p.setCountryPhoneCode(code);
                p.setPhone(phone);
                p.setCountry(country);
                return new Response(200, "Pasajero actualizado correctamente");
            }
        }

        return new Response(404, "Pasajero no encontrado");
    }

}
