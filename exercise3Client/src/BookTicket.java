// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.rmi.*;
import java.util.*;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookTicket extends javax.swing.JFrame {

    private static Operations op;
    ArrayList<Flight> flights;
    
    public BookTicket() {
        initComponents();
        try {
            // Σύνδεση στον RMI Server
            op = (Operations) Naming.lookup("//localhost/exercise3");
            // Δημιουργεί ArrayList με τις πτήσεις που υπάρχουν στο αρχείο
            flights = sendFlights();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(BookTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Δημιουργία Combo Box με τον κωδικό από τις πτήσεις
        String[] flightCodes = new String[flights.size()];
        int i=0;
        for(Flight f1: flights) {
            flightCodes[i] = f1.getCode();
            i++;
        }
        flightCodeCB.setModel(new javax.swing.DefaultComboBoxModel(flightCodes));    
    }

    public Ticket bookTicket(Flight flight, Ticket ticket) throws RemoteException {
        return op.bookTicket(flight, ticket);
    }
    
    public ArrayList<Flight> sendFlights() throws RemoteException {
        return op.sendFlights();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        flightCodeCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        viewAvailableSeatsJB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedSeatsJL = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        clientFirstNameTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        clientLastNameTF = new javax.swing.JTextField();
        nextJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Κράτηση Εισιτηρίου Πελάτη");

        jLabel1.setText("Κωδικός πτήσης:");

        flightCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightCodeCBActionPerformed(evt);
            }
        });

        jLabel2.setText("Διαθέσιμες θέσεις:");

        viewAvailableSeatsJB.setText("Εμφάνιση");
        viewAvailableSeatsJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAvailableSeatsJBActionPerformed(evt);
            }
        });

        jLabel3.setText("Επιλογή θέσεων:");

        jScrollPane2.setViewportView(selectedSeatsJL);

        jLabel4.setText("Όνομα:");

        clientFirstNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientFirstNameTFActionPerformed(evt);
            }
        });

        jLabel5.setText("Επώνυμο:");

        clientLastNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientLastNameTFActionPerformed(evt);
            }
        });

        nextJB.setText("Επόμενο");
        nextJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextJB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewAvailableSeatsJB, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(flightCodeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientFirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientLastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(flightCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(viewAvailableSeatsJB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(clientFirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(clientLastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(nextJB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clientLastNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientLastNameTFActionPerformed
        
    }//GEN-LAST:event_clientLastNameTFActionPerformed

    // Λειτουργίες που γίνονται όταν ο χρήστης πατάει Επομένο
    private void nextJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJBActionPerformed
        // Δημιουργεί μία HashMap για τους κατόχους των εισιτηρίων με το όνομα και τη θέση τους   
        HashMap<String, String> holders = new HashMap<>();
        String flightCode = (String) flightCodeCB.getSelectedItem();
        // Παίρνεις τις επιλεγμένες τιμές από τη λίστα με τις διαθέσιμες θέσεις
        int[] selectedIndices = selectedSeatsJL.getSelectedIndices();
        String[] selectedSeats = new String[selectedIndices.length];
        for(int i = 0; i < selectedIndices.length; i++) {
            selectedSeats[i] = String.valueOf(selectedSeatsJL.getModel().getElementAt(selectedIndices[i]));
        }
        // Παίρνει το όνομα και το επώνυμο του χρήστη και το κάνει String
        String clientFirstName = clientFirstNameTF.getText();
        String clientLastName = clientLastNameTF.getText();
        String clientName = clientFirstName + " " + clientLastName;
        // Αντιστοίχιση της επιλογής στο Combo Box με αντικείμενο πτήσης
        Flight flight = null;
        for(Flight f1: flights) {
            if(f1.getCode().equals(flightCode)) {
                flight = f1;
                    
                break;
            }
        }
        // Δημιουργία παραθύρου για τη κράτηση σε συγκεκριμένη θέση από συγκεκριμένο κάτοχο
        int value = selectedIndices.length;
        while (value > 0) {                
            JTextField holderFirstNameTF = new JTextField();
            JTextField holderLastNameTF = new JTextField();
            JComboBox seatsCB = new JComboBox();
            
            int index = 0;
            String[] newSeats = new String[value];  

            // Δίνει τιμές στο Combo Box με βάση τις θέσεις που επιλέχθηκαν προηγουμένως
            for(Flight f1: flights) {
                if(f1.getCode().equals(flightCode)) {
                    for(int i = 0; i < selectedIndices.length; i++) {
                        if(!selectedSeats[i].equals("X")) {
                            newSeats[index] = selectedSeats[i];
                            index++;
                        }
                    }
                    seatsCB.setModel(new javax.swing.DefaultComboBoxModel(newSeats));

                    break;
                }
            }

            // Εμφάνιση του παραθύρου
            JPanel holderJP = new JPanel(new GridLayout(0, 1));
            holderJP.add(new JLabel("Όνομα:"));
            holderJP.add(holderFirstNameTF);
            holderJP.add(new JLabel("Επώνυμο:"));
            holderJP.add(holderLastNameTF);
            holderJP.add(new JLabel("Θέση:"));
            holderJP.add(seatsCB);
            String holderFirstName = holderFirstNameTF.getText();
            String holderLastName = holderLastNameTF.getText();
            String holderName = holderFirstName + " " + holderLastName;
            String selectedSeat = String.valueOf(seatsCB.getSelectedItem());
            JOptionPane.showConfirmDialog(null, holderJP, "Κατόχος Εισιτηρίου " + String.valueOf((Integer) selectedIndices.length-value+1), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            // Η θέση που επέλεξε ο χρήστης δεσμεύεται και δεν είναι πλέον διαθέσιμη
            for(int i = 0; i < selectedSeats.length; i++) {
                if(selectedSeats[i].equals(selectedSeat)) {
                    selectedSeats[i] = "X";
                }
            }
            flight.reserveSeat(selectedSeat);
            // Προσθήκη του ονόματος του κατόχου και της θέσης του σε HashMap
            holders.put(holderName, selectedSeat);
            value--;
        }
        System.out.println(holders);
        // Δημιουργία αντικειμένου και κλήση της συνάρτησης bookTicket για εγγραφή στο αρχείο
        Ticket ticket = new Ticket(flightCode, clientName, holders);
        try {
            bookTicket(flight, ticket);
        } catch (RemoteException ex) {
            Logger.getLogger(BookTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Κλήση για επιστροφή στο μενού
        setVisible(false);
    }//GEN-LAST:event_nextJBActionPerformed

    private void clientFirstNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientFirstNameTFActionPerformed
        
    }//GEN-LAST:event_clientFirstNameTFActionPerformed

    // Εμφάνιση ενός πίνακα με τις διαθέσιμες θέσεις
    private void viewAvailableSeatsJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAvailableSeatsJBActionPerformed
        JPanel seatsJP = new JPanel(new GridLayout(0, 4));

        // Διάβασμα των πτήσεων
        for(Flight f1: flights) {
            // Βρίσκει την πτήση που επέλεξε ο χρήστης από το Combo Box
            if(f1.getCode().equals(flightCodeCB.getSelectedItem())) {
                // Την προσθέτει στο γραφικό
                for(String available: f1.getSeatsAvailable()) {
                    seatsJP.add(new JLabel(available));
                }
            }
        }
        JOptionPane.showConfirmDialog(null, seatsJP, "Θέσεις", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_viewAvailableSeatsJBActionPerformed

    // Επιλογή του Combo Box με τις πτήσεις
    private void flightCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightCodeCBActionPerformed
        String flightCode = (String) flightCodeCB.getSelectedItem();
        int index = 0;
        Flight flight = null;
        for(Flight f1: flights) {
            if(f1.getCode().equals(flightCode)) {
                flight = f1;
                    
                break;
            }
        }
        // Δίνει τις τιμές στη λίστα αν υπάρχουν διαθέσιμες θέσεις στη πτήση
        if(flight.countSeatsAvailable() > 0) {
            for(Flight f1: flights) {
                    if(f1.getCode().equals(flightCode)) {
                        String[] seatsAvailable = new String[(f1.countSeatsAvailable())];
                        for(String s1: f1.getSeatsAvailable()) {
                            if(!s1.equals("X")) {
                                seatsAvailable[index] = s1;
                                index++;
                            }
                        }
                        selectedSeatsJL.setModel(new javax.swing.DefaultComboBoxModel(seatsAvailable));
                        flight = f1;

                        break;
                    }
                }
        } else {
            JOptionPane.showMessageDialog(null, "Δεν υπάρχουν διαθέσιμες θέσεις", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_flightCodeCBActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientFirstNameTF;
    private javax.swing.JTextField clientLastNameTF;
    private javax.swing.JComboBox<String> flightCodeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextJB;
    private javax.swing.JList<String> selectedSeatsJL;
    private javax.swing.JButton viewAvailableSeatsJB;
    // End of variables declaration//GEN-END:variables
}
