/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import airport.JsonSaver;
import model.Location;
import model.Plane;
import model.Flight;
import model.Passenger;
import com.formdev.flatlaf.FlatDarkLaf;
import controller.FlightController;
import controller.LocationController;
import controller.PassengerController;
import controller.PlaneController;
import controller.Response;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import utils.ComboInitializer;

/**
 *
 * @author edangulo
 */
public class AirportFrame extends javax.swing.JFrame {

    /**
     * Creates new form AirportFrame
     */
    private int x, y;
    private ArrayList<Passenger> passengers;
    private ArrayList<Plane> planes;
    private ArrayList<Location> locations;
    private ArrayList<Flight> flights;
    
    public AirportFrame() {
        initComponents();

        this.passengers = new ArrayList<>();
        this.planes = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.flights = new ArrayList<>();
        
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        this.generateMonths();
        this.generateDays();
        this.generateHours();
        this.generateMinutes();
        this.blockPanels();

        jTabbedPane1.setSelectedIndex(12);

        for (int i = 0; i <= 23; i++) {
            hourDurationFlightRegis.addItem(String.valueOf(i));
        }
        for (int i = 0; i <= 59; i++) {
            minDurationFlightRegis.addItem(String.valueOf(i));
        }

    }

    private void blockPanels() {
        //9, 11
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            if (i != 9 && i != 11) {
                jTabbedPane1.setEnabledAt(i, false);
            }
        }
    }
    
    private void generateMonths() {
        ComboInitializer.fillWithMonths(monthRegis);
        ComboInitializer.fillWithMonths(monthDepartureFlightRegis);
        ComboInitializer.fillWithMonths(monthPassengerUpdateInfo);
    }
    
    private void generateDays() {
        ComboInitializer.fillWithDays(dayRegis);
        ComboInitializer.fillWithDays(dayDepartureFlightRegis);
        ComboInitializer.fillWithDays(dayPassengerUpdateInfo);   
    }
    
    
    private void generateHours() {
        ComboInitializer.fillWithHours(hourDepartureFlightRegis);
        ComboInitializer.fillWithHours(hourDurationFlightRegis);
        ComboInitializer.fillWithHours(hourScaleDurationFlightRegis);
        ComboInitializer.fillWithHours(hourDelayFlight);
    }

    
    private void generateMinutes() {
        ComboInitializer.fillWithMinutes(minDepartureFlightRegis);
        ComboInitializer.fillWithMinutes(minDurationFlightRegis);
        ComboInitializer.fillWithMinutes(minScaleDurationFlightRegis);
        ComboInitializer.fillWithMinutes(minDelayFlight);  
    }
    
    private void updateFlightComboBoxes() {
        planeFlightRegis.removeAllItems();
        for (Plane p : planes) {
            planeFlightRegis.addItem(p.getId());
        }

        locationFlightRegis.removeAllItems();
        arrivalLocationFlightRegis.removeAllItems();
        scaleLocationFlightRegis.removeAllItems(); // ← Añadido

        locationFlightRegis.addItem("Location");
        arrivalLocationFlightRegis.addItem("Location");
        scaleLocationFlightRegis.addItem("No scale");

        for (Location l : locations) {
            locationFlightRegis.addItem(l.getAirportId());
            arrivalLocationFlightRegis.addItem(l.getAirportId());
            scaleLocationFlightRegis.addItem(l.getAirportId()); // ← Añadido
        }
    }

    private void updateAddToFlightCombos() {
        flightPassengerAddToFlight.removeAllItems(); // el combobox que contiene los vuelos

        for (Flight f : flights) {
            flightPassengerAddToFlight.addItem(f.getId());
        }
    }

    private void updatePassengerTable() {
        DefaultTableModel model = (DefaultTableModel) tableShowAllPassengers.getModel();
        model.setRowCount(0);
        for (Passenger passenger : this.passengers) {
            model.addRow(new Object[]{
                passenger.getId(),
                passenger.getFullname(),
                passenger.getBirthDate(),
                passenger.calculateAge(),
                passenger.generateFullPhone(),
                passenger.getCountry(),
                passenger.getNumFlights()
            });
        }
    }

    private void updatePassengerCombo() {
        userSelect.removeAllItems();
        for (Passenger p : passengers) {
            userSelect.addItem(String.valueOf(p.getId()));
        }
    }

    private void updateDelayFlightCombo() {
        idDelayFlight.removeAllItems(); // limpia el combo

        for (Flight f : flights) {
            idDelayFlight.addItem(f.getId()); // agrega cada ID de vuelo
        }
    }

    public void setPlanes(ArrayList<Plane> list) {
        this.planes = list;
        updateFlightComboBoxes();
    }

    public void setLocations(ArrayList<Location> list) {
        this.locations = list;
        updateFlightComboBoxes();
    }

    public void setFlights(ArrayList<Flight> list) {
        this.flights = list;
        updateAddToFlightCombos();
        updateDelayFlightCombo();
    }

    public void setPassengers(ArrayList<Passenger> list) {
        this.passengers = list;
        updatePassengerCombo();
        updatePassengerTable();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new view.PanelRound();
        panelRound2 = new view.PanelRound();
        jButton13 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        phoneCodeRegis = new javax.swing.JTextField();
        idPassengerRegiss = new javax.swing.JTextField();
        yearRegis = new javax.swing.JTextField();
        countryRegis = new javax.swing.JTextField();
        phoneRegis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lastNameRegis = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        monthRegis = new javax.swing.JComboBox<>();
        firstNameRegis = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dayRegis = new javax.swing.JComboBox<>();
        registerPassengerButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        idPlaneRegis = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        brandRegis = new javax.swing.JTextField();
        modelRegis = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        maxCapacityRegis = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        airlineRegis = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        createPlaneRegistrationButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        idAirportRegis = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        nameAirportRegis = new javax.swing.JTextField();
        cityAirportRegis = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        countryAirportRegis = new javax.swing.JTextField();
        latitudeAirportRegis = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        longitudeAirportRegis = new javax.swing.JTextField();
        locationCreateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        idFlightRegis = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        planeFlightRegis = new javax.swing.JComboBox<>();
        locationFlightRegis = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        arrivalLocationFlightRegis = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        scaleLocationFlightRegis = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        yearDepartureFlightRegis = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        monthDepartureFlightRegis = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        dayDepartureFlightRegis = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        hourDepartureFlightRegis = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        minDepartureFlightRegis = new javax.swing.JComboBox<>();
        hourDurationFlightRegis = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        minDurationFlightRegis = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        hourScaleDurationFlightRegis = new javax.swing.JComboBox<>();
        minScaleDurationFlightRegis = new javax.swing.JComboBox<>();
        flightCreateButtonRegis = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        idPassengerUpdateInfo = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        firstNamePassengerUpdateInfo = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        lastNamePassengerUpdateInfo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        yearPassengerUpdateInfo = new javax.swing.JTextField();
        monthPassengerUpdateInfo = new javax.swing.JComboBox<>();
        dayPassengerUpdateInfo = new javax.swing.JComboBox<>();
        phonePassengerUpdateInfo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        phoneCodePassengerUpdateInfo = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        countryPassengerUpdateInfo = new javax.swing.JTextField();
        UpdateInfoButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        idPassengerAddToFlight = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        flightPassengerAddToFlight = new javax.swing.JComboBox<>();
        AddToFlightButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowMyFlights = new javax.swing.JTable();
        RefreshShowMyFlightsButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableShowAllPassengers = new javax.swing.JTable();
        RefreshShowAllPassengersButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableShowAllFlights = new javax.swing.JTable();
        RefreshShowAllFlightsButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        RefreshShowAllPlanesButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableShowAllPlanes = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableShowAllLocations = new javax.swing.JTable();
        RefreshShowAllLocationsButton = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        hourDelayFlight = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        idDelayFlight = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        minDelayFlight = new javax.swing.JComboBox<>();
        DelayFlightButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        user = new javax.swing.JRadioButton();
        administrator = new javax.swing.JRadioButton();
        userSelect = new javax.swing.JComboBox<>();
        panelRound3 = new view.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setRadius(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRound2MouseDragged(evt);
            }
        });
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound2MousePressed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButton13.setText("X");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(1083, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jButton13)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setText("Country:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel2.setText("ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel3.setText("First Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setText("Last Name:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setText("Birthdate:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setText("+");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 20, -1));

        phoneCodeRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(phoneCodeRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, -1));

        idPassengerRegiss.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idPassengerRegiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPassengerRegissActionPerformed(evt);
            }
        });
        jPanel2.add(idPassengerRegiss, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, -1));

        yearRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(yearRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, -1));

        countryRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(countryRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 130, -1));

        phoneRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(phoneRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel7.setText("Phone:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel8.setText("-");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, -1));

        lastNameRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(lastNameRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel9.setText("-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));

        monthRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
        jPanel2.add(monthRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        firstNameRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel2.add(firstNameRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 130, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel10.setText("-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 30, -1));

        dayRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));
        jPanel2.add(dayRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        registerPassengerButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        registerPassengerButton.setText("Register");
        registerPassengerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPassengerButtonActionPerformed(evt);
            }
        });
        jPanel2.add(registerPassengerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        jTabbedPane1.addTab("Passenger registration", jPanel2);

        jPanel3.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel11.setText("ID:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(53, 96, 22, 25);

        idPlaneRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idPlaneRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPlaneRegisActionPerformed(evt);
            }
        });
        jPanel3.add(idPlaneRegis);
        idPlaneRegis.setBounds(180, 93, 130, 33);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel12.setText("Brand:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(53, 157, 50, 25);

        brandRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        brandRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandRegisActionPerformed(evt);
            }
        });
        jPanel3.add(brandRegis);
        brandRegis.setBounds(180, 154, 130, 33);

        modelRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        modelRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelRegisActionPerformed(evt);
            }
        });
        jPanel3.add(modelRegis);
        modelRegis.setBounds(180, 213, 130, 33);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel13.setText("Model:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(53, 216, 55, 25);

        maxCapacityRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        maxCapacityRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxCapacityRegisActionPerformed(evt);
            }
        });
        jPanel3.add(maxCapacityRegis);
        maxCapacityRegis.setBounds(180, 273, 130, 33);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel14.setText("Max Capacity:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(53, 276, 109, 25);

        airlineRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airlineRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlineRegisActionPerformed(evt);
            }
        });
        jPanel3.add(airlineRegis);
        airlineRegis.setBounds(180, 333, 130, 33);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel15.setText("Airline:");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(53, 336, 70, 25);

        createPlaneRegistrationButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        createPlaneRegistrationButton.setText("Create");
        createPlaneRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlaneRegistrationButtonActionPerformed(evt);
            }
        });
        jPanel3.add(createPlaneRegistrationButton);
        createPlaneRegistrationButton.setBounds(490, 480, 120, 40);

        jTabbedPane1.addTab("Airplane registration", jPanel3);

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel16.setText("Airport ID:");

        idAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel17.setText("Airport name:");

        nameAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        cityAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel18.setText("Airport city:");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel19.setText("Airport country:");

        countryAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        latitudeAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel20.setText("Airport latitude:");

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel21.setText("Airport longitude:");

        longitudeAirportRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        locationCreateButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        locationCreateButton.setText("Create");
        locationCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationCreateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(longitudeAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(latitudeAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(locationCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(515, 515, 515))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel18)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel19)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel20))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(idAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(nameAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cityAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(countryAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(latitudeAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(longitudeAirportRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(locationCreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("Location registration", jPanel13);

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel22.setText("ID:");

        idFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel23.setText("Plane:");

        planeFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        planeFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plane" }));

        locationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        locationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel24.setText("Departure location:");

        arrivalLocationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arrivalLocationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel25.setText("Arrival location:");

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel26.setText("Scale location:");

        scaleLocationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scaleLocationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel27.setText("Duration:");

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel28.setText("Duration:");

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel29.setText("Departure date:");

        yearDepartureFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        yearDepartureFlightRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearDepartureFlightRegisActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel30.setText("-");

        monthDepartureFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthDepartureFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel31.setText("-");

        dayDepartureFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayDepartureFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel32.setText("-");

        hourDepartureFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        hourDepartureFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));
        hourDepartureFlightRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourDepartureFlightRegisActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel33.setText("-");

        minDepartureFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        minDepartureFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));
        minDepartureFlightRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minDepartureFlightRegisActionPerformed(evt);
            }
        });

        hourDurationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        hourDurationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));
        hourDurationFlightRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourDurationFlightRegisActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel34.setText("-");

        minDurationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        minDurationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));
        minDurationFlightRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minDurationFlightRegisActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel35.setText("-");

        hourScaleDurationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        hourScaleDurationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        minScaleDurationFlightRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        minScaleDurationFlightRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        flightCreateButtonRegis.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        flightCreateButtonRegis.setText("Create");
        flightCreateButtonRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightCreateButtonRegisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scaleLocationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(arrivalLocationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(46, 46, 46)
                        .addComponent(locationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idFlightRegis)
                            .addComponent(planeFlightRegis, 0, 130, Short.MAX_VALUE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(yearDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(monthDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(dayDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(hourDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(minDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(hourDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(minDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(hourScaleDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(minScaleDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(flightCreateButtonRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(530, 530, 530))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(idFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(planeFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hourDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(minDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(locationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addComponent(yearDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(dayDepartureFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(arrivalLocationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28))
                            .addComponent(hourDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(minDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourScaleDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(minScaleDurationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26)
                                .addComponent(scaleLocationFlightRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(flightCreateButtonRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Flight registration", jPanel4);

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel36.setText("ID:");

        idPassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel37.setText("First Name:");

        firstNamePassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel38.setText("Last Name:");

        lastNamePassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel39.setText("Birthdate:");

        yearPassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        monthPassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthPassengerUpdateInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        dayPassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayPassengerUpdateInfo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        phonePassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel40.setText("-");

        phoneCodePassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel41.setText("+");

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel42.setText("Phone:");

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel43.setText("Country:");

        countryPassengerUpdateInfo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        UpdateInfoButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        UpdateInfoButton.setText("Update");
        UpdateInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(108, 108, 108)
                                .addComponent(idPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(41, 41, 41)
                                .addComponent(firstNamePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(43, 43, 43)
                                .addComponent(lastNamePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(55, 55, 55)
                                .addComponent(yearPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(monthPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(dayPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(phoneCodePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(phonePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(63, 63, 63)
                                .addComponent(countryPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(UpdateInfoButton)))
                .addContainerGap(573, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(idPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(firstNamePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(lastNamePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(yearPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(phoneCodePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(phonePassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(countryPassengerUpdateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(UpdateInfoButton)
                .addGap(113, 113, 113))
        );

        jTabbedPane1.addTab("Update info", jPanel5);

        idPassengerAddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idPassengerAddToFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPassengerAddToFlightActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel44.setText("ID:");

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel45.setText("Flight:");

        flightPassengerAddToFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        flightPassengerAddToFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight" }));
        flightPassengerAddToFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightPassengerAddToFlightActionPerformed(evt);
            }
        });

        AddToFlightButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AddToFlightButton.setText("Add");
        AddToFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToFlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(79, 79, 79)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(flightPassengerAddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPassengerAddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(829, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddToFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel44))
                    .addComponent(idPassengerAddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(flightPassengerAddToFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(AddToFlightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jTabbedPane1.addTab("Add to flight", jPanel6);

        tableShowMyFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tableShowMyFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Departure Date", "Arrival Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableShowMyFlights);

        RefreshShowMyFlightsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RefreshShowMyFlightsButton.setText("Refresh");
        RefreshShowMyFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshShowMyFlightsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RefreshShowMyFlightsButton)
                .addGap(527, 527, 527))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(RefreshShowMyFlightsButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Show my flights", jPanel7);

        tableShowAllPassengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tableShowAllPassengers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableShowAllPassengers);

        RefreshShowAllPassengersButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RefreshShowAllPassengersButton.setText("Refresh");
        RefreshShowAllPassengersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshShowAllPassengersButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(RefreshShowAllPassengersButton))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RefreshShowAllPassengersButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Show all passengers", jPanel8);

        tableShowAllFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tableShowAllFlights.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID", "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableShowAllFlights);

        RefreshShowAllFlightsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RefreshShowAllFlightsButton.setText("Refresh");
        RefreshShowAllFlightsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshShowAllFlightsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(RefreshShowAllFlightsButton)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RefreshShowAllFlightsButton)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Show all flights", jPanel9);

        RefreshShowAllPlanesButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RefreshShowAllPlanesButton.setText("Refresh");
        RefreshShowAllPlanesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshShowAllPlanesButtonActionPerformed(evt);
            }
        });

        tableShowAllPlanes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableShowAllPlanes);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(RefreshShowAllPlanesButton))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(RefreshShowAllPlanesButton)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Show all planes", jPanel10);

        tableShowAllLocations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airport ID", "Airport Name", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableShowAllLocations);

        RefreshShowAllLocationsButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        RefreshShowAllLocationsButton.setText("Refresh");
        RefreshShowAllLocationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshShowAllLocationsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(RefreshShowAllLocationsButton))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(RefreshShowAllLocationsButton)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Show all locations", jPanel11);

        hourDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        hourDelayFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel46.setText("Hours:");

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel47.setText("ID:");

        idDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idDelayFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel48.setText("Minutes:");

        minDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        minDelayFlight.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        DelayFlightButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        DelayFlightButton.setText("Delay");
        DelayFlightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelayFlightButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minDelayFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourDelayFlight, 0, 105, Short.MAX_VALUE)
                            .addComponent(idDelayFlight, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(820, 820, 820))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DelayFlightButton)
                .addGap(531, 531, 531))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(idDelayFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(hourDelayFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(minDelayFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(DelayFlightButton)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Delay flight", jPanel12);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        user.setText("User");
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        administrator.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        administrator.setText("Administrator");
        administrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorActionPerformed(evt);
            }
        });
        jPanel1.add(administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 164, -1, -1));

        userSelect.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        userSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User" }));
        userSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSelectActionPerformed(evt);
            }
        });
        jPanel1.add(userSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 130, -1));

        jTabbedPane1.addTab("Administration", jPanel1);

        panelRound1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 1150, 620));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 660, 1150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRound2MousePressed

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRound2MouseDragged

    private void administratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorActionPerformed
        if (user.isSelected()) {
            user.setSelected(false);
            userSelect.setSelectedIndex(0);

        }
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setEnabledAt(i, true);
        }
        jTabbedPane1.setEnabledAt(4, false);
        jTabbedPane1.setEnabledAt(5, false);
        jTabbedPane1.setEnabledAt(6, false);
        jTabbedPane1.setEnabledAt(0, true);
    }//GEN-LAST:event_administratorActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        if (administrator.isSelected()) {
            administrator.setSelected(false);
        }
        for (int i = 1; i < jTabbedPane1.getTabCount(); i++) {

            jTabbedPane1.setEnabledAt(i, false);

        }
        jTabbedPane1.setEnabledAt(4, true);
        jTabbedPane1.setEnabledAt(5, true);
        jTabbedPane1.setEnabledAt(6, true);
        jTabbedPane1.setEnabledAt(10, true);
        jTabbedPane1.setEnabledAt(12, true);
        jTabbedPane1.setEnabledAt(8, true);
        jTabbedPane1.setEnabledAt(0, false);
    }//GEN-LAST:event_userActionPerformed

    private void registerPassengerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPassengerButtonActionPerformed
        try {
            long id = Long.parseLong(idPassengerRegiss.getText());
            String firstname = firstNameRegis.getText();
            String lastname = lastNameRegis.getText();
            int year = Integer.parseInt(yearRegis.getText());
            int month = Integer.parseInt(monthRegis.getSelectedItem().toString());
            int day = Integer.parseInt(dayRegis.getSelectedItem().toString());
            LocalDate birthDate = LocalDate.of(year, month, day);
            int code = Integer.parseInt(phoneCodeRegis.getText());
            long phone = Long.parseLong(phoneRegis.getText());
            String country = countryRegis.getText();

            PassengerController controller = new PassengerController(passengers);
            Response res = controller.registerPassenger(id, firstname, lastname, birthDate, code, phone, country);

            javax.swing.JOptionPane.showMessageDialog(this, res.getMessage());

            if (res.getStatusCode() == 200) {
                // Limpia campos si fue exitoso
                phoneCodeRegis.setText("");
                idPassengerRegiss.setText("");
                yearRegis.setText("");
                countryRegis.setText("");
                phoneRegis.setText("");
                lastNameRegis.setText("");
                firstNameRegis.setText("");
                monthRegis.setSelectedIndex(0);
                dayRegis.setSelectedIndex(0);
            }
            updatePassengerCombo();
            JsonSaver.savePassengers(passengers, "json/passengers.json");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: datos inválidos o vacíos");
        }
    }//GEN-LAST:event_registerPassengerButtonActionPerformed

    private void createPlaneRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlaneRegistrationButtonActionPerformed
        try {
            String id = idPlaneRegis.getText();
            String brand = brandRegis.getText();
            String model = modelRegis.getText();
            int capacity = Integer.parseInt(maxCapacityRegis.getText());
            String airline = airlineRegis.getText();

            PlaneController controller = new PlaneController(planes);
            Response res = controller.registerPlane(id, brand, model, capacity, airline);

            javax.swing.JOptionPane.showMessageDialog(this, res.getMessage());

            if (res.getStatusCode() == 200) {
                idPlaneRegis.setText("");
                brandRegis.setText("");
                modelRegis.setText("");
                maxCapacityRegis.setText("");
                airlineRegis.setText("");
            }

            if (res.getStatusCode() == 200) {
                updateFlightComboBoxes();
            }

            JsonSaver.savePlanes(planes, "json/planes.json");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: datos inválidos o vacíos");
        }
    }//GEN-LAST:event_createPlaneRegistrationButtonActionPerformed

    private void locationCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationCreateButtonActionPerformed
        try {
            String id = idAirportRegis.getText();
            String name = nameAirportRegis.getText();
            String city = cityAirportRegis.getText();
            String country = countryAirportRegis.getText();
            double latitude = Double.parseDouble(latitudeAirportRegis.getText());
            double longitude = Double.parseDouble(longitudeAirportRegis.getText());

            LocationController controller = new LocationController(locations);
            Response res = controller.registerLocation(id, name, city, country, latitude, longitude);

            javax.swing.JOptionPane.showMessageDialog(this, res.getMessage());

            if (res.getStatusCode() == 200) {
                idAirportRegis.setText("");
                nameAirportRegis.setText("");
                cityAirportRegis.setText("");
                countryAirportRegis.setText("");
                latitudeAirportRegis.setText("");
                longitudeAirportRegis.setText("");
            }

            if (res.getStatusCode() == 200) {
                updateFlightComboBoxes();
            }

            JsonSaver.saveLocations(locations, "json/locations.json");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: datos inválidos o vacíos");
        }
    }//GEN-LAST:event_locationCreateButtonActionPerformed

    private void flightCreateButtonRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightCreateButtonRegisActionPerformed
        try {
            String flightId = idFlightRegis.getText();
            String planeId = planeFlightRegis.getSelectedItem().toString();
            String originId = locationFlightRegis.getSelectedItem().toString();
            String destId = arrivalLocationFlightRegis.getSelectedItem().toString();
            String scaleId = scaleLocationFlightRegis.getSelectedItem().toString();

            // Validar campos de fecha
            String yearStr = yearDepartureFlightRegis.getText().trim();
            String monthStr = monthDepartureFlightRegis.getSelectedItem().toString();
            String dayStr = dayDepartureFlightRegis.getSelectedItem().toString();
            String hourStr = hourDepartureFlightRegis.getSelectedItem().toString();
            String minStr = minDepartureFlightRegis.getSelectedItem().toString();
            String durHourStr = hourDurationFlightRegis.getSelectedItem().toString();
            String durMinStr = minDurationFlightRegis.getSelectedItem().toString();

            if (!isNumeric(yearStr) || !isNumeric(monthStr) || !isNumeric(dayStr)
                    || !isNumeric(hourStr) || !isNumeric(minStr)
                    || !isNumeric(durHourStr) || !isNumeric(durMinStr)) {
                throw new Exception("Fecha u hora inválida.");
            }

            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            int hour = Integer.parseInt(hourStr);
            int minute = Integer.parseInt(minStr);
            int durHours = Integer.parseInt(durHourStr);
            int durMins = Integer.parseInt(durMinStr);

            LocalDateTime departureDate = LocalDateTime.of(year, month, day, hour, minute);

            int scaleHours = 0;
            int scaleMins = 0;

            if (!scaleId.equals("No scale")) {
                String scaleHourStr = hourScaleDurationFlightRegis.getSelectedItem().toString();
                String scaleMinStr = minScaleDurationFlightRegis.getSelectedItem().toString();

                if (!isNumeric(scaleHourStr) || !isNumeric(scaleMinStr)) {
                    throw new Exception("Duración de escala inválida.");
                }

                scaleHours = Integer.parseInt(scaleHourStr);
                scaleMins = Integer.parseInt(scaleMinStr);
            }

            Plane selectedPlane = null;
            for (Plane p : planes) {
                if (p.getId().equals(planeId)) {
                    selectedPlane = p;
                    break;
                }
            }

            Location origin = null, dest = null, scale = null;
            for (Location l : locations) {
                if (l.getAirportId().equals(originId)) {
                    origin = l;
                }
                if (l.getAirportId().equals(destId)) {
                    dest = l;
                }
                if (!scaleId.equals("No scale") && l.getAirportId().equals(scaleId)) {
                    scale = l;
                }
            }

            FlightController controller = new FlightController(flights);
            Response res;

            if (scale != null) {
                res = controller.registerFlight(flightId, selectedPlane, origin, dest, scale,
                        departureDate, durHours, durMins, scaleHours, scaleMins);
            } else {
                res = controller.registerFlight(flightId, selectedPlane, origin, dest,
                        departureDate, durHours, durMins);
            }

            javax.swing.JOptionPane.showMessageDialog(this, res.getMessage());

            if (res.getStatusCode() == 200) {

                // Limpiar campos
                idFlightRegis.setText("");
                idPassengerUpdateInfo.setText("");
                yearDepartureFlightRegis.setText("");
                firstNamePassengerUpdateInfo.setText("");
                lastNamePassengerUpdateInfo.setText("");
                planeFlightRegis.setSelectedIndex(0);
                locationFlightRegis.setSelectedIndex(0);
                arrivalLocationFlightRegis.setSelectedIndex(0);
                scaleLocationFlightRegis.setSelectedIndex(0);
                monthDepartureFlightRegis.setSelectedIndex(0);
                dayDepartureFlightRegis.setSelectedIndex(0);
                hourDepartureFlightRegis.setSelectedIndex(0);
                minDepartureFlightRegis.setSelectedIndex(0);
                hourDurationFlightRegis.setSelectedIndex(0);
                minDurationFlightRegis.setSelectedIndex(0);
                hourScaleDurationFlightRegis.setSelectedIndex(0);
                minScaleDurationFlightRegis.setSelectedIndex(0);
            }

            updateAddToFlightCombos();
            updateDelayFlightCombo();
            JsonSaver.saveFlights(flights, "json/flights.json"); // guardar vuelo en archivo

        } catch (Exception e) {
            e.printStackTrace(); // Para depuración en consola
            javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_flightCreateButtonRegisActionPerformed

    private void UpdateInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoButtonActionPerformed
        String raw = (String) userSelect.getSelectedItem();
        if (raw == null || raw.equals("Select User") || raw.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor selecciona un pasajero.");
            return;
        }

        try {
            long selectedId = Long.parseLong(raw);
            Passenger selectedPassenger = null;
            for (Passenger p : passengers) {
                if (p.getId() == selectedId) {
                    selectedPassenger = p;
                    break;
                }
            }

            if (selectedPassenger == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pasajero no encontrado.");
                return;
            }

            // Actualizar campos
            selectedPassenger.setFirstname(firstNamePassengerUpdateInfo.getText());
            selectedPassenger.setLastname(lastNamePassengerUpdateInfo.getText());

            // Reconstruir fecha
            int year = Integer.parseInt(yearPassengerUpdateInfo.getText());
            int month = monthPassengerUpdateInfo.getSelectedIndex();    // si los ítems van de "1" a "12"
            int day = dayPassengerUpdateInfo.getSelectedIndex();      // idem
            selectedPassenger.setBirthDate(LocalDate.of(year, month, day));

            selectedPassenger.setCountryPhoneCode(Integer.parseInt(phoneCodePassengerUpdateInfo.getText()));
            selectedPassenger.setPhone(Long.parseLong(phonePassengerUpdateInfo.getText()));
            selectedPassenger.setCountry(countryPassengerUpdateInfo.getText());

            javax.swing.JOptionPane.showMessageDialog(this, "Información del pasajero actualizada correctamente.");
            updatePassengerCombo();     // y para actualizar el combo, en caso de que id/name cambien

            JsonSaver.savePassengers(passengers, "json/passengers.json");

        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(this, "Hay un número mal formado:\n" + nfe.getMessage());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar pasajero:\n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_UpdateInfoButtonActionPerformed

    private void AddToFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToFlightButtonActionPerformed
        try {
            long passengerId = Long.parseLong(idPassengerAddToFlight.getText());
            String flightId = flightPassengerAddToFlight.getSelectedItem().toString();

            Passenger selectedPassenger = null;
            for (Passenger p : passengers) {
                if (p.getId() == passengerId) {
                    selectedPassenger = p;
                    break;
                }
            }

            if (selectedPassenger == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pasajero no encontrado.");
                return;
            }

            FlightController controller = new FlightController(flights);
            Response res = controller.addPassengerToFlight(flightId, selectedPassenger);

            javax.swing.JOptionPane.showMessageDialog(this, res.getMessage());

            if (res.getStatusCode() == 200) {
                updatePassengerTable();
            }

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al añadir pasajero al vuelo.");
        }
    }//GEN-LAST:event_AddToFlightButtonActionPerformed

    private void DelayFlightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelayFlightButtonActionPerformed
        try {
            String flightId = idDelayFlight.getItemAt(idDelayFlight.getSelectedIndex());
            int hours = Integer.parseInt(hourDelayFlight.getItemAt(hourDelayFlight.getSelectedIndex()));
            int minutes = Integer.parseInt(minDelayFlight.getItemAt(minDelayFlight.getSelectedIndex()));

            Flight flight = null;
            for (Flight f : this.flights) {
                if (flightId.equals(f.getId())) {
                    flight = f;
                    break;
                }
            }

            if (flight == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Vuelo no encontrado.");
                return;
            }

            flight.delay(hours, minutes);
            javax.swing.JOptionPane.showMessageDialog(this, "Vuelo retrasado correctamente.");

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String newDeparture = flight.getDepartureDate().format(fmt);
            String newArrival = flight.calculateArrivalDate().format(fmt);

            String msg = "Vuelo retrasado correctamente.\n\n"
                    + "Nueva hora de salida: " + newDeparture + "\n"
                    + "Nueva hora de llegada: " + newArrival;

            javax.swing.JOptionPane.showMessageDialog(this, msg);

            JsonSaver.saveFlights(flights, "json/flights.json");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error: revisa los datos ingresados.");
        }
    }//GEN-LAST:event_DelayFlightButtonActionPerformed

    private void RefreshShowMyFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshShowMyFlightsButtonActionPerformed
        try {
            long selectedId = Long.parseLong(userSelect.getSelectedItem().toString());

            Passenger selectedPassenger = null;
            for (Passenger p : passengers) {
                if (p.getId() == selectedId) {
                    selectedPassenger = p;
                    break;
                }
            }

            if (selectedPassenger == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pasajero no encontrado.");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tableShowMyFlights.getModel();
            model.setRowCount(0); // limpiar tabla

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            for (Flight f : selectedPassenger.getFlights()) {
                model.addRow(new Object[]{
                    f.getId(),
                    f.getDepartureDate().format(fmt),
                    f.calculateArrivalDate().format(fmt)
                });
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al mostrar los vuelos del pasajero.");
        }
    }//GEN-LAST:event_RefreshShowMyFlightsButtonActionPerformed

    private void RefreshShowAllPassengersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshShowAllPassengersButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableShowAllPassengers.getModel();
        model.setRowCount(0);
        for (Passenger passenger : this.passengers) {
            model.addRow(new Object[]{passenger.getId(), passenger.getFullname(), passenger.getBirthDate(), passenger.calculateAge(), passenger.generateFullPhone(), passenger.getCountry(), passenger.getNumFlights()});
        }
    }//GEN-LAST:event_RefreshShowAllPassengersButtonActionPerformed

    private void RefreshShowAllFlightsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshShowAllFlightsButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableShowAllFlights.getModel();
        model.setRowCount(0);
        for (Flight flight : this.flights) {
            model.addRow(new Object[]{flight.getId(), flight.getDepartureLocation().getAirportId(), flight.getArrivalLocation().getAirportId(), (flight.getScaleLocation() == null ? "-" : flight.getScaleLocation().getAirportId()), flight.getDepartureDate(), flight.calculateArrivalDate(), flight.getPlane().getId(), flight.getNumPassengers()});
        }
    }//GEN-LAST:event_RefreshShowAllFlightsButtonActionPerformed

    private void RefreshShowAllPlanesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshShowAllPlanesButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableShowAllPlanes.getModel();
        model.setRowCount(0);
        for (Plane plane : this.planes) {
            model.addRow(new Object[]{plane.getId(), plane.getBrand(), plane.getModel(), plane.getMaxCapacity(), plane.getAirline(), plane.getNumFlights()});
        }
    }//GEN-LAST:event_RefreshShowAllPlanesButtonActionPerformed

    private void RefreshShowAllLocationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshShowAllLocationsButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableShowAllLocations.getModel();
        model.setRowCount(0);
        for (Location location : this.locations) {
            model.addRow(new Object[]{location.getAirportId(), location.getAirportName(), location.getAirportCity(), location.getAirportCountry()});
        }
    }//GEN-LAST:event_RefreshShowAllLocationsButtonActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void userSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSelectActionPerformed
        String raw = (String) userSelect.getSelectedItem();
        // si está en la posición cero o es el texto por defecto, no hacemos nada
        if (raw == null || raw.equals("Select User") || raw.isBlank()) {
            return;
        }

        try {
            long selectedId = Long.parseLong(raw);
            Passenger selectedPassenger = null;

            for (Passenger p : passengers) {
                if (p.getId() == selectedId) {
                    selectedPassenger = p;
                    break;
                }
            }

            if (selectedPassenger != null) {
                // Rellena aquí **todos** los campos de tu formulario de Update Info
                idPassengerUpdateInfo.setText(String.valueOf(selectedPassenger.getId()));
                firstNamePassengerUpdateInfo.setText(selectedPassenger.getFirstname());
                lastNamePassengerUpdateInfo.setText(selectedPassenger.getLastname());

                // Birthdate desglosado en tu combo Month5/Day5 y jTextField24
                LocalDate bd = selectedPassenger.getBirthDate();
                yearPassengerUpdateInfo.setText(String.valueOf(bd.getYear()));
                monthPassengerUpdateInfo.setSelectedItem(String.valueOf(bd.getMonthValue()));
                dayPassengerUpdateInfo.setSelectedItem(String.valueOf(bd.getDayOfMonth()));

                // Teléfono y código de país
                phoneCodePassengerUpdateInfo.setText(String.valueOf(selectedPassenger.getCountryPhoneCode()));
                phonePassengerUpdateInfo.setText(String.valueOf(selectedPassenger.getPhone()));

                countryPassengerUpdateInfo.setText(selectedPassenger.getCountry());
            }

        } catch (NumberFormatException nfe) {
            // no es un número válido
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar datos del pasajero:\n" + e.getMessage());
        }
    }//GEN-LAST:event_userSelectActionPerformed

    private void idPlaneRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPlaneRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPlaneRegisActionPerformed

    private void brandRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandRegisActionPerformed

    private void modelRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelRegisActionPerformed

    private void maxCapacityRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxCapacityRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxCapacityRegisActionPerformed

    private void airlineRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlineRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airlineRegisActionPerformed

    private void hourDurationFlightRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourDurationFlightRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourDurationFlightRegisActionPerformed

    private void hourDepartureFlightRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourDepartureFlightRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourDepartureFlightRegisActionPerformed

    private void minDepartureFlightRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minDepartureFlightRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minDepartureFlightRegisActionPerformed

    private void minDurationFlightRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minDurationFlightRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minDurationFlightRegisActionPerformed

    private void yearDepartureFlightRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearDepartureFlightRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearDepartureFlightRegisActionPerformed

    private void flightPassengerAddToFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightPassengerAddToFlightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightPassengerAddToFlightActionPerformed

    private void idPassengerAddToFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPassengerAddToFlightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPassengerAddToFlightActionPerformed

    private void idPassengerRegissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPassengerRegissActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPassengerRegissActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AirportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddToFlightButton;
    private javax.swing.JButton DelayFlightButton;
    private javax.swing.JButton RefreshShowAllFlightsButton;
    private javax.swing.JButton RefreshShowAllLocationsButton;
    private javax.swing.JButton RefreshShowAllPassengersButton;
    private javax.swing.JButton RefreshShowAllPlanesButton;
    private javax.swing.JButton RefreshShowMyFlightsButton;
    private javax.swing.JButton UpdateInfoButton;
    private javax.swing.JRadioButton administrator;
    private javax.swing.JTextField airlineRegis;
    private javax.swing.JComboBox<String> arrivalLocationFlightRegis;
    private javax.swing.JTextField brandRegis;
    private javax.swing.JTextField cityAirportRegis;
    private javax.swing.JTextField countryAirportRegis;
    private javax.swing.JTextField countryPassengerUpdateInfo;
    private javax.swing.JTextField countryRegis;
    private javax.swing.JButton createPlaneRegistrationButton;
    private javax.swing.JComboBox<String> dayDepartureFlightRegis;
    private javax.swing.JComboBox<String> dayPassengerUpdateInfo;
    private javax.swing.JComboBox<String> dayRegis;
    private javax.swing.JTextField firstNamePassengerUpdateInfo;
    private javax.swing.JTextField firstNameRegis;
    private javax.swing.JButton flightCreateButtonRegis;
    private javax.swing.JComboBox<String> flightPassengerAddToFlight;
    private javax.swing.JComboBox<String> hourDelayFlight;
    private javax.swing.JComboBox<String> hourDepartureFlightRegis;
    private javax.swing.JComboBox<String> hourDurationFlightRegis;
    private javax.swing.JComboBox<String> hourScaleDurationFlightRegis;
    private javax.swing.JTextField idAirportRegis;
    private javax.swing.JComboBox<String> idDelayFlight;
    private javax.swing.JTextField idFlightRegis;
    private javax.swing.JTextField idPassengerAddToFlight;
    private javax.swing.JTextField idPassengerRegiss;
    private javax.swing.JTextField idPassengerUpdateInfo;
    private javax.swing.JTextField idPlaneRegis;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastNamePassengerUpdateInfo;
    private javax.swing.JTextField lastNameRegis;
    private javax.swing.JTextField latitudeAirportRegis;
    private javax.swing.JButton locationCreateButton;
    private javax.swing.JComboBox<String> locationFlightRegis;
    private javax.swing.JTextField longitudeAirportRegis;
    private javax.swing.JTextField maxCapacityRegis;
    private javax.swing.JComboBox<String> minDelayFlight;
    private javax.swing.JComboBox<String> minDepartureFlightRegis;
    private javax.swing.JComboBox<String> minDurationFlightRegis;
    private javax.swing.JComboBox<String> minScaleDurationFlightRegis;
    private javax.swing.JTextField modelRegis;
    private javax.swing.JComboBox<String> monthDepartureFlightRegis;
    private javax.swing.JComboBox<String> monthPassengerUpdateInfo;
    private javax.swing.JComboBox<String> monthRegis;
    private javax.swing.JTextField nameAirportRegis;
    private view.PanelRound panelRound1;
    private view.PanelRound panelRound2;
    private view.PanelRound panelRound3;
    private javax.swing.JTextField phoneCodePassengerUpdateInfo;
    private javax.swing.JTextField phoneCodeRegis;
    private javax.swing.JTextField phonePassengerUpdateInfo;
    private javax.swing.JTextField phoneRegis;
    private javax.swing.JComboBox<String> planeFlightRegis;
    private javax.swing.JButton registerPassengerButton;
    private javax.swing.JComboBox<String> scaleLocationFlightRegis;
    private javax.swing.JTable tableShowAllFlights;
    private javax.swing.JTable tableShowAllLocations;
    private javax.swing.JTable tableShowAllPassengers;
    private javax.swing.JTable tableShowAllPlanes;
    private javax.swing.JTable tableShowMyFlights;
    private javax.swing.JRadioButton user;
    private javax.swing.JComboBox<String> userSelect;
    private javax.swing.JTextField yearDepartureFlightRegis;
    private javax.swing.JTextField yearPassengerUpdateInfo;
    private javax.swing.JTextField yearRegis;
    // End of variables declaration//GEN-END:variables
}
