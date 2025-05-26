/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Passenger;
import java.util.List;

/**
 *
 * @author Jesús
 */
public interface PassengerRepository {
    List<Passenger> getAll();
    Passenger findById(long id);
    void save(Passenger passenger);
    void update(Passenger passenger);
    boolean exists(long id);
}
