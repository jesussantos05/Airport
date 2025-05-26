/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Location;
import java.util.List;

/**
 *
 * @author Jesús
 */
public interface LocationRepository {
    List<Location> getAll();
    Location findById(String id);
    void save(Location location);
    boolean exists(String id);
}
