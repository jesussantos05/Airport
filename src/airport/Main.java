/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Flight;
import model.Location;
import model.Passenger;
import model.Plane;
import view.AirportFrame;

/**
 *
 * @author Jesús
 */
public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.err.println("No se pudo cargar FlatDarkLaf: " + ex.getMessage());
            }

            AirportFrame frame = new AirportFrame();
            frame.setVisible(true);
        });

        ArrayList<Passenger> passengers = JsonLoader.loadPassengers("json/passengers.json");
        System.out.println("Pasajeros cargados: " + passengers.size());
        ArrayList<Plane> planes = JsonLoader.loadPlanes("json/planes.json");
        System.out.println("Aviones cargados: " + planes.size());
        ArrayList<Location> locations = JsonLoader.loadLocations("json/locations.json");
        System.out.println("Localizaciones cargadas: " + locations.size());
        ArrayList<Flight> flights = JsonLoader.loadFlights("json/flights.json", planes, locations, passengers);
        System.out.println("Vuelos cargados: " + flights.size());

        java.awt.EventQueue.invokeLater(() -> {
            AirportFrame frame = new AirportFrame();
            frame.setPassengers(passengers);
            frame.setPlanes(planes);
            frame.setLocations(locations);
            frame.setFlights(flights);
            frame.setVisible(true);
        });
    }
}
