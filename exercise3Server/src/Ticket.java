// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.io.Serializable;
import java.util.HashMap;

public class Ticket implements Serializable {
    String flightCode;
    String clientName;
    HashMap<String, String> holders;

    // Constructor
    public Ticket(String flightCode, String clientName, HashMap<String, String> holders) {
        this.flightCode = flightCode;
        this.clientName = clientName;
        this.holders = holders;
    }
    
    // Setters - Getters

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public HashMap<String, String> getHolders() {
        return holders;
    }

    public void setHolders(HashMap<String, String> holders) {
        this.holders = holders;
    }

    @Override
    public String toString() {
        return "Ticket{" + "flightCode=" + flightCode + ", clientName=" + clientName + ", holders=" + holders + '}';
    }
    
}