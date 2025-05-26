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

import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Flight;

/**
 *
 * @author Jesús
 */
public class JsonSaver {

    public static void savePassengers(ArrayList<Passenger> passengers, String path) {
        JSONArray array = new JSONArray();
        for (Passenger p : passengers) {
            JSONObject obj = new JSONObject();
            obj.put("id", p.getId());
            obj.put("firstname", p.getFirstname());
            obj.put("lastname", p.getLastname());
            obj.put("birthDate", p.getBirthDate().toString());
            obj.put("countryPhoneCode", p.getCountryPhoneCode());
            obj.put("phone", p.getPhone());
            obj.put("country", p.getCountry());
            array.put(obj);
        }
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(array.toString(4));
        } catch (Exception e) {
            System.out.println("Error al guardar pasajeros: " + e.getMessage());
        }
    }

    public static void savePlanes(ArrayList<Plane> planes, String path) {
        JSONArray array = new JSONArray();
        for (Plane p : planes) {
            JSONObject obj = new JSONObject();
            obj.put("id", p.getId());
            obj.put("brand", p.getBrand());
            obj.put("model", p.getModel());
            obj.put("maxCapacity", p.getMaxCapacity());
            obj.put("airline", p.getAirline());
            array.put(obj);
        }
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(array.toString(4));
        } catch (Exception e) {
            System.out.println("Error al guardar aviones: " + e.getMessage());
        }
    }

    public static void saveLocations(ArrayList<Location> locations, String path) {
        JSONArray array = new JSONArray();
        for (Location l : locations) {
            JSONObject obj = new JSONObject();
            obj.put("airportId", l.getAirportId());
            obj.put("airportName", l.getAirportName());
            obj.put("airportCity", l.getAirportCity());
            obj.put("airportCountry", l.getAirportCountry());
            obj.put("airportLatitude", l.getAirportLatitude());
            obj.put("airportLongitude", l.getAirportLongitude());
            array.put(obj);
        }
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(array.toString(4));
        } catch (Exception e) {
            System.out.println("Error al guardar localizaciones: " + e.getMessage());
        }
    }

    public static void saveFlights(ArrayList<Flight> flights, String path) {
        JSONArray array = new JSONArray();
        for (Flight f : flights) {
            JSONObject obj = new JSONObject();
            obj.put("id", f.getId());
            obj.put("plane", f.getPlane().getId());
            obj.put("departureLocation", f.getDepartureLocation().getAirportId());
            obj.put("arrivalLocation", f.getArrivalLocation().getAirportId());
            obj.put("scaleLocation", f.getScaleLocation() == null ? JSONObject.NULL : f.getScaleLocation().getAirportId());
            obj.put("departureDate", f.getDepartureDate().toString());
            obj.put("hoursDurationArrival", f.getHoursDurationArrival());
            obj.put("minutesDurationArrival", f.getMinutesDurationArrival());
            obj.put("hoursDurationScale", f.getHoursDurationScale());
            obj.put("minutesDurationScale", f.getMinutesDurationScale());
            array.put(obj);
        }

        try (FileWriter writer = new FileWriter(path)) {

            writer.write(array.toString(4)); // formato bonito
        } catch (Exception e) {
            System.out.println("Error al guardar vuelos: " + e.getMessage());
        }
    }

}