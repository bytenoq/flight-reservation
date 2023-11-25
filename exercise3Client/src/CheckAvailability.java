// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

import java.awt.GridLayout;
import java.rmi.*;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CheckAvailability extends javax.swing.JFrame {
    
    private static Operations op;
    ArrayList<Flight> flightsAvailable = new ArrayList<Flight>();

    public CheckAvailability() {
        try {
            // Σύνδεση στον RMI Server
            op = (Operations) Naming.lookup("//localhost/exercise3");
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }
    
    public ArrayList<Flight> checkAvailability(String from, String to, LocalDate date) throws RemoteException {
        return op.checkAvailability(from, to, date);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fromTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        toTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateTF = new javax.swing.JTextField();
        nextJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Έλεγχος Διαθεσιμότητας Πτήσης");

        jLabel1.setText("Αφετηρία:");

        fromTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Προορισμός:");

        toTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Ημερομηνία:");

        dateTF.setText("YYYY-MM-DD");
        dateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTFActionPerformed(evt);
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
                    .addComponent(nextJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateTF, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(toTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(nextJB)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fromTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromTFActionPerformed

    private void dateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTFActionPerformed

    private void toTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toTFActionPerformed

    private void nextJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJBActionPerformed
        String from = fromTF.getText();
        String to = toTF.getText();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateTF.getText(), dateFormatter);
        try {
            flightsAvailable = checkAvailability(from, to, date);
        } catch (RemoteException ex) {
            Logger.getLogger(CheckAvailability.class.getName()).log(Level.SEVERE, null, ex);
        }

        JPanel flightsJP = new JPanel(new GridLayout(0, 7));
        flightsJP.add(new JLabel("Κωδικός πτήσης"));
        flightsJP.add(new JLabel("Αφετηρία"));
        flightsJP.add(new JLabel("Προορισμός"));
        flightsJP.add(new JLabel("Ημερομηνία"));
        flightsJP.add(new JLabel("Ώρα"));
        flightsJP.add(new JLabel("Κόστος"));
        flightsJP.add(new JLabel("Διαθέσιμες θέσεις"));
        for (Flight f1 : flightsAvailable) {
            flightsJP.add(new JLabel(f1.getCode()));
            flightsJP.add(new JLabel(f1.getFrom()));
            flightsJP.add(new JLabel(f1.getTo()));
            flightsJP.add(new JLabel(f1.getDate().toString()));
            flightsJP.add(new JLabel(f1.getTime().toString()));
            flightsJP.add(new JLabel(String.valueOf(f1.getCost())));
            flightsJP.add(new JLabel(String.valueOf(f1.countSeatsAvailable())));
        }
        JOptionPane.showConfirmDialog(null, flightsJP, "Διαθέσιμες πτήσεις", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        setVisible(false);
    }//GEN-LAST:event_nextJBActionPerformed

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
            java.util.logging.Logger.getLogger(CheckAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckAvailability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckAvailability().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateTF;
    private javax.swing.JTextField fromTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton nextJB;
    private javax.swing.JTextField toTF;
    // End of variables declaration//GEN-END:variables
}
