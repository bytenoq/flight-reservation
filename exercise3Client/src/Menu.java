// Γιώργος Κριαράς, 3212016078
// Μανώλης Σιγουλάκης, 3212016178

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkAvailabilityJB = new javax.swing.JButton();
        bookTicketJB = new javax.swing.JButton();
        viewTicketJB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Σύστημα Διαχείρισης Κράτησης Αεροπορικών Εισιτηρίων");

        checkAvailabilityJB.setText("Έλεγχος Διαθεσιμότητας Πτήσης");
        checkAvailabilityJB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkAvailabilityJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAvailabilityJBActionPerformed(evt);
            }
        });

        bookTicketJB.setText("Κράτηση Εισιτηρίου");
        bookTicketJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTicketJBActionPerformed(evt);
            }
        });

        viewTicketJB.setText("Εμφάνιση Στοιχείων Κράτησης");
        viewTicketJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTicketJBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewTicketJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookTicketJB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkAvailabilityJB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(checkAvailabilityJB)
                .addGap(18, 18, 18)
                .addComponent(bookTicketJB)
                .addGap(18, 18, 18)
                .addComponent(viewTicketJB)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkAvailabilityJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAvailabilityJBActionPerformed
        CheckAvailability ca = new CheckAvailability();
        ca.setVisible(true);
    }//GEN-LAST:event_checkAvailabilityJBActionPerformed

    private void bookTicketJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTicketJBActionPerformed
        BookTicket bt = new BookTicket();
        bt.setVisible(true);
    }//GEN-LAST:event_bookTicketJBActionPerformed

    private void viewTicketJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTicketJBActionPerformed
        ViewTicket vt = new ViewTicket();
        vt.setVisible(true);
    }//GEN-LAST:event_viewTicketJBActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookTicketJB;
    private javax.swing.JButton checkAvailabilityJB;
    private javax.swing.JButton viewTicketJB;
    // End of variables declaration//GEN-END:variables
}
