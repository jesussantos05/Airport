/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airport;

import org.json.JSONArray;
import org.json.JSONObject;
import model.Passenger;
import model.Plane;
import model.Location;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Flight;

/**
 *
 * @author Jesús
 */
public class JsonLoader {

    public static ArrayList<Passenger> loadPassengers(String path) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Passenger p = new Passenger(
                        obj.getLong("id"),
                        obj.getString("firstname"),
                        obj.getString("lastname"),
                        LocalDate.parse(obj.getString("birthDate")),
                        obj.getInt("countryPhoneCode"),
                        obj.getLong("phone"),
                        obj.getString("country")
                );
                passengers.add(p);
                if (passengers.isEmpty()) {
                    System.out.println("⚠️ No se cargaron pasajeros. Verifica el archivo JSON.");
                }

            }
        } catch (Exception e) {
            System.out.println("Error al cargar pasajeros: " + e.getMessage());
        }
        return passengers;
    }

    public static ArrayList<Plane> loadPlanes(String path) {
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Plane p = new Plane(
                        obj.getString("id"),
                        obj.getString("brand"),
                        obj.getString("model"),
                        obj.getInt("maxCapacity"),
                        obj.getString("airline")
                );
                planes.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar aviones: " + e.getMessage());
        }
        return planes;
    }

    public static ArrayList<Location> loadLocations(String path) {
        ArrayList<Location> locations = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                Location loc = new Location(
                        obj.getString("airportId"),
                        obj.getString("airportName"),
                        obj.getString("airportCity"),
                        obj.getString("airportCountry"),
                        obj.getDouble("airportLatitude"),
                        obj.getDouble("airportLongitude")
                );
                locations.add(loc);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar localizaciones: " + e.getMessage());
        }
        return locations;
    }

    public static ArrayList<Flight> loadFlights(
            String path,
            ArrayList<Plane> planes,
            ArrayList<Location> locations,
            ArrayList<Passenger> passengers
    ) {
        ArrayList<Flight> flights = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray array = new JSONArray(content);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                String id = obj.getString("id");

                Plane plane = planes.stream()
                        .filter(p -> p.getId().equals(obj.getString("plane")))
                        .findFirst().orElse(null);

                Location departure = locations.stream()
                        .filter(l -> l.getAirportId().equals(obj.getString("departureLocation")))
                        .findFirst().orElse(null);

                Location arrival = locations.stream()
                        .filter(l -> l.getAirportId().equals(obj.getString("arrivalLocation")))
                        .findFirst().orElse(null);

                Location scale = null;
                if (!obj.isNull("scaleLocation")) {
                    scale = locations.stream()
                            .filter(l -> l.getAirportId().equals(obj.getString("scaleLocation")))
                            .findFirst().orElse(null);
                }

                LocalDateTime date = LocalDateTime.parse(obj.getString("departureDate"));
                int ha = obj.getInt("hoursDurationArrival");
                int ma = obj.getInt("minutesDurationArrival");
                int hs = obj.getInt("hoursDurationScale");
                int ms = obj.getInt("minutesDurationScale");

                Flight f;
                if (scale != null) {
                    f = new Flight(id, plane, departure, scale, arrival, date, ha, ma, hs, ms);
                } else {
                    f = new Flight(id, plane, departure, arrival, date, ha, ma);
                }

                if (obj.has("passengers")) {
                    JSONArray passengerArray = obj.getJSONArray("passengers");
                    for (int j = 0; j < passengerArray.length(); j++) {
                        long pid = passengerArray.getLong(j);
                        Passenger p = passengers.stream()
                                .filter(pa -> pa.getId() == pid)
                                .findFirst().orElse(null);
                        if (p != null) {
                            f.addPassenger(p);
                        } else {
                            System.out.println("Pasajero no encontrado con ID: " + pid);
                        }
                    }
                }

                flights.add(f);

            }

        } catch (Exception e) {
            System.out.println("Error al cargar vuelos: " + e.getMessage());
        }

        return flights;
    }

}
