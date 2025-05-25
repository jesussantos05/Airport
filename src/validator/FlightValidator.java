/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Jesús
 */
public class FlightValidator {

    public static String validate(String id, String planeId, String from, String to,
                                  String scale, LocalDate date, LocalTime duration,
                                  LocalTime scaleTime, boolean withScale) {

        if (id == null || id.isBlank()) return "ID vacío";
        if (!id.matches("[A-Z]{3}\\d{3}")) return "ID del vuelo inválido. Formato: XXXYYY";

        if (planeId == null || planeId.isBlank()) return "Debe seleccionar un avión";
        if (from == null || from.isBlank()) return "Ubicación de salida no válida";
        if (to == null || to.isBlank()) return "Ubicación de llegada no válida";
        if (from.equals(to)) return "La ubicación de salida y llegada no pueden ser iguales";

        if (date == null) return "Fecha de salida inválida";
        if (duration == null || duration.equals(LocalTime.of(0, 0)))
            return "La duración del vuelo debe ser mayor a 00:00";

        if (withScale) {
            if (scale == null || scale.isBlank()) return "Ubicación de escala inválida";
            if (scale.equals(from) || scale.equals(to)) return "La escala no puede ser igual a la salida o llegada";
            if (scaleTime == null || scaleTime.equals(LocalTime.of(0, 0)))
                return "El tiempo de escala debe ser mayor a 00:00";
        }

        return null;
    }
}
