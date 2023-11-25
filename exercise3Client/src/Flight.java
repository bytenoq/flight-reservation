// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight implements Serializable {
    String code;
    String from;
    String to;
    LocalDate date;
    LocalTime time;
    int cost;
    int seats;
    ArrayList<String> seatsAvailable = new ArrayList<>();
    
    // Constructor
    public Flight(String code, String from, String to, LocalDate date, LocalTime time, int cost, int seats) {
        this.code = code;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.seats = seats;
        seatsAvailable = fillSeats(seats);
    }
    
    // Setters - Getters
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    
    public ArrayList<String> getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(ArrayList<String> seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
    
    // Συνάρτηση που δημιουργεί μία ArrayList με βάση τον αριθμό των θέσεων σε μία πτήση
    private ArrayList<String> fillSeats(int seats) {
        for(int row = 1; row <= seats/4; row++) {
            // Αριθμούμε τις θέσεις σε μία ArrayList μέσω της οποίας ελέγχουμε ποιες είναι διαθέσιμες
            seatsAvailable.add(Integer.toString(row)+"A");
            seatsAvailable.add(Integer.toString(row)+"B");
            seatsAvailable.add(Integer.toString(row)+"C");
            seatsAvailable.add(Integer.toString(row)+"D");
        }
        
        return seatsAvailable;
    }
    
    // Συνάρτηση που δεσμεύει τις θέσεις σε μία πτήση και αλλάζει τον κωδικό της δεσμευμένης θέσης σε X
    protected ArrayList<String> reserveSeat(String seat) {
        int index = 0;
        // Διάβασμα της ArrayList
        for(String s1: seatsAvailable) {
            if(s1.equals(seat)) {
                seatsAvailable.set(index, "X");
            }
            index++;
        }
        setSeatsAvailable(seatsAvailable);
                
        return seatsAvailable;
    }
    
    // Συνάρτηση που υπολογίζει τις διαθέσιμες θέσεις σε μία πτήση
    protected int countSeatsAvailable() {
        int counter = 0;
        // Διάβασμα της ArrayList
        for(String s1: seatsAvailable) {
            if(!s1.equals("X"))
                counter++;
        }
        
        return counter;
    }

    @Override
    public String toString() {
        return "Flight{" + "code=" + code + ", from=" + from + ", to=" + to + ", date=" + date + ", time=" + time + ", cost=" + cost + ", seats=" + seats + ", seatsAvailable=" + seatsAvailable + '}';
    }
    
}