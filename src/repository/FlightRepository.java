/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Flight;
import java.util.List;

/**
 *
 * @author Jesús
 */
public interface FlightRepository {
    List<Flight> getAll();
    Flight findByCode(String code);
    void save(Flight flight);
    boolean exists(String code);
    Flight findById(String id);
    void update(Flight flight); 
}
