// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends UnicastRemoteObject implements Operations {

    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    
    public Server() throws RemoteException {
        super();
        // Δημιουργία πτήσεων
//        Flight flight1 = new Flight("OA246", "Athens", "Samos", LocalDate.of(2021, 5, 14), LocalTime.of(17, 00, 00), 50, 100);
//        Flight flight2 = new Flight("OA247", "Volos", "London", LocalDate.of(2021, 5, 15), LocalTime.of(15, 00, 00), 5, 40);
//        Flight flight3 = new Flight("OA248", "Thessaloniki", "Samos", LocalDate.of(2021, 5, 6), LocalTime.of(18, 00, 00), 25, 80);
//        Flight flight4 = new Flight("OA249", "Athens", "Samos", LocalDate.of(2021, 5, 14), LocalTime.of(21, 00, 00), 40, 60);
//        writeFlight(flight1);
//        writeFlight(flight2);
//        writeFlight(flight3);
//        writeFlight(flight4);
        
        // Διάβασμα και εμφάνιση των πτήσεων/εισιτηρίων (αν αυτά υπάρχουν)
        // H try-catch γίνεται σχόλιο αν δεν υπάρχουν τα αρχεία
        try {
            flights = readFlights();
            tickets = readTickets();
            
            for(Flight f1: flights) {
                System.out.println(f1.toString());
            }
            
            for(Ticket t1: tickets) {
                System.out.println(t1.toString());
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Συνάρτηση εγγραφής αντικειμένου πτήσης σε αρχείο FlightsData.dat
    public void writeFlight(Flight flight) {
        try {
            ObjectOutputStream out;
            out = new ObjectOutputStream(new FileOutputStream("FlightsData.dat", true));
            out.writeObject(flight);
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Συνάρτηση διαβάσματος αντικειμένου πτήσης από το αρχείο FlightsData.dat
    public ArrayList<Flight> readFlights() throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        
        // Δοκιμάζει να βρει το αρχείο FlightsData.dat
        try {
            fis = new FileInputStream("FlightsData.dat");
            
            // Για κάθε αντικείμενο Flight που υπάρχει στο αρχείο
            // Προσθέτει το αντικείμενο σε ArrayList
            while(true) {
                ObjectInputStream in = new ObjectInputStream(fis);
                flights.add((Flight) in.readObject());
            }
        } catch (EOFException e) {
            
        } finally {
            if(fis != null)
                fis.close();
        }
        
        return flights;
    }
    
    // Συνάρτηση ενημέρωσης αρχείου FlightsData.dat
    public ArrayList<Flight> updateFlights() {        
        // Διαγραφή του αρχείου
        File f = new File("FlightsData.dat");
        f.delete();
        
        // Διάβασμα της ArrayList με τις πτήσεις και εγγραφή στο αρχείο
        for(Flight f1: flights) {
            writeFlight(f1);
        }
       
        return flights;
    }
    
    // Συνάρτηση εγγραφής αντικειμένου εισιτηρίου σε αρχείο TicketsData.dat
    public void writeTicket(Ticket ticket) {
        try {
            ObjectOutputStream out;
            out = new ObjectOutputStream(new FileOutputStream("TicketsData.dat", true));
            out.writeObject(ticket);
            out.flush();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Συνάρτηση διαβάσματος αντικειμένου εισιτηριου από το αρχείο TicketsData.dat
    public ArrayList<Ticket> readTickets() throws IOException, ClassNotFoundException {      
        FileInputStream fis = null;
        
        // Δοκιμάζει να βρει το αρχείο TicketsData.dat
        try {
            fis = new FileInputStream("TicketsData.dat");
            
            // Για κάθε αντικείμενο Ticket που υπάρχει στο αρχείο
            // Προσθέτει το αντικείμενο σε ArrayList
            while(true) {
                ObjectInputStream in = new ObjectInputStream(fis);
                tickets.add((Ticket) in.readObject());
            }
        } catch (EOFException e) {
            
        } finally {
            if(fis != null)
                fis.close();
        }
        
        return tickets;
    }
    
    // Συνάρτηση από το interface που εμφανίζει τις διαθέσιμες πτήσεις, με κριτήρια την αφετηρία, τον προορισμό και την ημερομηνία
    @Override
    public ArrayList<Flight> checkAvailability(String from, String to, LocalDate date) throws RemoteException {
        ArrayList<Flight> flightsAvailable = new ArrayList<>();
        for(Flight f1: flights) {
            // Ελέγχουμε την ArrayList των πτήσεων
            // Αν αντιστοιχούν πτήσεις με ελεύθερες θέσεις στους επιθυμητούς σταθμούς αποχώρησης και άφιξης και τις επιθυμητές ημερομηνίες, εμφανίζονται
            if(f1.getFrom().equals(from) && f1.getTo().equals(to) && f1.getDate().isEqual(date) && f1.countSeatsAvailable() > 0) {
                flightsAvailable.add(f1);
            } 
        }
        
        return flightsAvailable;
    }
    
    // Συνάρτηση από το interface που κάνει κράτηση σε μία πτήση
    @Override
    public Ticket bookTicket(Flight flight, Ticket ticket) throws RemoteException {
        // Κάνουμε εγγραφή σε αρχείο
        writeTicket(ticket);
        tickets.add(ticket);
        // Διάβασμα της ArrayList πτήσεων
        for(Flight f1: flights) {
            // Ελέγχει αν υπάρχει πτήση με τον κωδικό που εισάγει ο χρήστης
            if(f1.getCode().equals(ticket.getFlightCode())) {
                f1.setSeatsAvailable(flight.getSeatsAvailable());
            }
        }
        // Ανανεώνουμε το αρχείο με τις πτήσεις
        updateFlights();
        System.out.println("New Ticket: " + ticket.toString());
        
        return ticket;
    }
    
    // Συνάρτηση από το interface που εμφανίζει την κράτηση που έχει κάνει ένας χρήστης σε μία πτήση
    @Override
    public Ticket viewTicket(String clientName, String flightCode) throws RemoteException {
        
        // Ελέγχουμε την ArrayList των εισιτηρίων
        for(Ticket t1: tickets) {
            // Αν η πτήση και το όνομα αντιστοιχούν σε εισιτήριο, αυτό εμφανίζεται
            if(t1.getClientName().equals(clientName) && t1.getFlightCode().equals(flightCode)) {
                return t1;
            }
        }
        
        return null;
    }
    
    // Συνάρτηση από το interface που επιστρέφει την ArrayList με τις πτήσεις
    @Override
    public ArrayList<Flight> sendFlights() {
        
        return flights;
    }
}