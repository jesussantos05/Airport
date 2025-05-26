/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;

import com.formdev.flatlaf.FlatDarkLaf;
import controller.PassengerController;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.Flight;
import model.Location;
import model.Passenger;
import model.Plane;
import repository.FlightRepository;
import repository.LocationRepository;
import view.AirportFrame;
import repository.PassengerRepository;
import repository.PlaneRepository;
import repository.impl.InMemoryFlightRepository;
import repository.impl.InMemoryLocationRepository;
import repository.impl.InMemoryPassengerRepository;
import repository.impl.InMemoryPlaneRepository;

/**
 *
 * @author Jesús
 */
public class Main {

    public static void main(String[] args) {
        // Cargar datos
        ArrayList<Passenger> passengerList = JsonLoader.loadPassengers("json/passengers.json");
        System.out.println("Pasajeros cargados: " + passengerList.size());

        PassengerRepository passengerRepo = new InMemoryPassengerRepository(passengerList);

        ArrayList<Plane> planes = JsonLoader.loadPlanes("json/planes.json");
        System.out.println("Aviones cargados: " + planes.size()); 
        
        PlaneRepository planeRepo = new InMemoryPlaneRepository(planes);
        
        ArrayList<Location> locations = JsonLoader.loadLocations("json/locations.json");
        System.out.println("Localizaciones cargadas: " + locations.size());
        
        LocationRepository locationRepo = new InMemoryLocationRepository(locations);

        ArrayList<Flight> flights = JsonLoader.loadFlights("json/flights.json", planes, locations, passengerList);
        System.out.println("Vuelos cargados: " + flights.size());
        
        FlightRepository flightRepo = new InMemoryFlightRepository(flights);

        // Iniciar interfaz gráfica
        SwingUtilities.invokeLater(() -> {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("No se pudo cargar FlatDarkLaf: " + ex.getMessage());
        }
               
            AirportFrame frame = new AirportFrame();
            frame.setPassengerRepository(passengerRepo);
            frame.setPassengers(passengerList);
            frame.setPlaneRepository(planeRepo);
            frame.setPlanes(planes);
            frame.setLocationRepository(locationRepo);
            frame.setLocations(locations);
            frame.setFlights(flights);
            frame.setVisible(true);
            
        });
    }
}