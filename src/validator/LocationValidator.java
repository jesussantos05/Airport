/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author Jesús
 */
public class LocationValidator {

    public static String validate(String id, String city, String country, double lat, double lon) {
        if (id == null || id.isBlank()) return "ID vacío";
        if (!id.matches("[A-Z]{3}")) return "El ID debe tener exactamente 3 letras mayúsculas";

        if (city == null || city.isBlank()) return "Ciudad vacía";
        if (country == null || country.isBlank()) return "País vacío";

        if (lat < -90 || lat > 90) return "Latitud fuera de rango (-90 a 90)";
        if (lon < -180 || lon > 180) return "Longitud fuera de rango (-180 a 180)";

        String latStr = String.valueOf(lat);
        String lonStr = String.valueOf(lon);

        if (!latStr.matches("^-?\\d{1,3}(\\.\\d{1,4})?$")) {
            return "Latitud debe tener máximo 4 decimales";
        }

        if (!lonStr.matches("^-?\\d{1,3}(\\.\\d{1,4})?$")) {
            return "Longitud debe tener máximo 4 decimales";
        }

        return null;
    }
}
