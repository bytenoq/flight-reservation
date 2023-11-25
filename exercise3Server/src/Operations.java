// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.rmi.*;
import java.time.LocalDate;
import java.util.ArrayList;

public interface Operations extends Remote {
        
    public Ticket bookTicket(Flight flight, Ticket ticket) throws RemoteException;
    public ArrayList<Flight> checkAvailability(String from, String to, LocalDate date) throws RemoteException;
    public Ticket viewTicket(String clientName, String flightCode) throws RemoteException;
    public ArrayList<Flight> sendFlights() throws RemoteException;

}