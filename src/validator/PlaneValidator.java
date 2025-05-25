/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Jesús
 */
public class PlaneValidator {

    public static String validate(String id, String brand, String model, int capacity) {
        if (id == null || id.isBlank()) return "ID vacío";
        if (!id.matches("[A-Z]{2}\\d{5}")) return "Formato de ID inválido. Debe ser XXYYYYY (2 letras + 5 dígitos)";
        if (brand == null || brand.isBlank()) return "Marca vacía";
        if (model == null || model.isBlank()) return "Modelo vacío";
        if (capacity <= 0) return "Capacidad inválida";
        return null;
    }
}
