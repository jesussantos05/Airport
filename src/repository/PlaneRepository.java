/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Plane;
import java.util.List;

/**
 *
 * @author Jesús
 */
public interface PlaneRepository {
    List<Plane> getAll();
    Plane findById(String id);
    void save(Plane plane);
    boolean exists(String id);
}
