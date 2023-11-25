// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.awt.GridLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewTicket extends javax.swing.JFrame {
    
    private static Operations op;
    ArrayList<Flight> flights;


    public ViewTicket() {
        initComponents();
        try {
            // Σύνδεση στον RMI Server
            op = (Operations) Naming.lookup("//localhost/exercise3");
            // Δημιουργεί ArrayList με τις πτήσεις που υπάρχουν στο αρχείο
            flights = sendFlights();
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ViewTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Πίνακας με όλες τις πτήσεις
        String[] flightCodes = new String[flights.size()];
        int i=0;
        for(Flight f1: flights) {
            flightCodes[i] = f1.getCode();
            i++;
        }
        flightCodeCB.setModel(new javax.swing.DefaultComboBoxModel(flightCodes));
    }
    
    public Ticket viewTicket(String clientName, String flightCode) throws RemoteException {
        return op.viewTicket(clientName, flightCode);
    }
    
    public ArrayList<Flight> sendFlights() throws RemoteException {
        return op.sendFlights();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clientFirstNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clientLastNameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        flightCodeCB = new javax.swing.JComboBox<>();
        nextJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Εμφάνιση Στοιχείων Κράτησης");

        jLabel1.setText("Όνομα:");

        jLabel2.setText("Επώνυμο:");

        jLabel3.setText("Κωδικός πτήσης:");

        flightCodeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightCodeCBActionPerformed(evt);
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
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clientFirstNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(clientLastNameTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                        .addComponent(flightCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(clientFirstNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(clientLastNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(flightCodeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(nextJB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJBActionPerformed
        JLabel label;
        JPanel ticketJP = new JPanel(new GridLayout(0, 1));;
        String clientFirstName = clientFirstNameTF.getText();
        String clientLastName = clientLastNameTF.getText();
        String clientName = clientFirstName + " " + clientLastName;
        Ticket ticket = null;
        try {
            ticket = viewTicket(clientName, (String) flightCodeCB.getSelectedItem());
        } catch (RemoteException ex) {
            Logger.getLogger(ViewTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ticket.getClientName());
        System.out.println((String) flightCodeCB.getSelectedItem());
        
        if (ticket == null) {
            label = new JLabel("Κανένα αποτέλεσμα");
            ticketJP.add(label);
        } else {
            label = new JLabel(ticket.getClientName());
            ticketJP.add(label);
            label = new JLabel(ticket.getFlightCode());
            ticketJP.add(label);
            // Εκτύπωση HashMap
            for (Map.Entry<String, String> entry : ticket.getHolders().entrySet()){
                label = new JLabel(entry.getValue() + " " + entry.getKey());
                ticketJP.add(label);
            }
        }
        int result = JOptionPane.showConfirmDialog(null, ticketJP, "Στοιχεία εισιτηρίου", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_nextJBActionPerformed

    private void flightCodeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightCodeCBActionPerformed

    }//GEN-LAST:event_flightCodeCBActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTicket().setVisible(true);
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
    private javax.swing.JButton nextJB;
    // End of variables declaration//GEN-END:variables
}
