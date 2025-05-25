/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;

import java.util.ArrayList;
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

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
