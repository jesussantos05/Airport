/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JComboBox;

/**
 *
 * @author Jesús
 */
public class ComboInitializer {

    public static void fillWithHours(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Hour");
        for (int i = 0; i <= 23; i++) {
            combo.addItem(String.valueOf(i));
        }
    }

    public static void fillWithMinutes(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Minute");
        for (int i = 0; i <= 59; i++) {
            combo.addItem(String.valueOf(i));
        }
    }

    public static void fillWithDays(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Day");
        for (int i = 1; i <= 31; i++) {
            combo.addItem(String.valueOf(i));
        }
    }

    public static void fillWithMonths(JComboBox<String> combo) {
        combo.removeAllItems();
        combo.addItem("Month");
        for (int i = 1; i <= 12; i++) {
            combo.addItem(String.valueOf(i));
        }
    }
}
