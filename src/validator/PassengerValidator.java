/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.time.LocalDate;

/**
 *
 * @author Jesús
 */
public class PassengerValidator {

    public static String validate(long id, String first, String last, LocalDate birthDate,
                                  int code, long phone, String country) {

        if (id < 0 || String.valueOf(id).length() > 15) return "ID inválido";
        if (first == null || first.isEmpty() || last == null || last.isEmpty() || country == null || country.isEmpty())
            return "Campos vacíos";
        if (birthDate == null) return "Fecha inválida";
        if (code < 0 || String.valueOf(code).length() > 3) return "Código país inválido";
        if (phone < 0 || String.valueOf(phone).length() > 11) return "Teléfono inválido";

        return null;
    }
}
