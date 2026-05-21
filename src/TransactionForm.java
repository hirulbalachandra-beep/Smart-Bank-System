import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TransactionForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TransactionForm.class.getName());

   
    public TransactionForm() {
    initComponents();
    loadAccounts();
    loadTransactions();
    
    
}
    private void loadTransactions() {
    try {
        
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM transactions ORDER BY transaction_id DESC";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) tblTransactions.getModel();

        model.setRowCount(0);

        while (rs.next()) {
            Object[] row = {
                rs.getInt("transaction_id"),
                rs.getInt("account_id"),
                rs.getString("transaction_type"),
                rs.getDouble("amount"),
                rs.getString("reference_no"),
                rs.getTimestamp("transaction_date")
            };
            model.addRow(row);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    private void loadAccounts() {
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT account_id, account_number FROM accounts";

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        cmbAccount.removeAllItems();
        cmbToAccount.removeAllItems();

        while (rs.next()) {
            String acc = rs.getInt("account_id") + " - " + rs.getString("account_number");
            cmbAccount.addItem(acc);
            cmbToAccount.addItem(acc);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }


    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransactions = new javax.swing.JTable();
        cmbAccount = new javax.swing.JComboBox<>();
        cmbType = new javax.swing.JComboBox<>();
        txtReferenceNo = new javax.swing.JTextField();
        btnProcess = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        txtAmount1 = new javax.swing.JTextField();
        cmbToAccount = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction Form");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(230, 240, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Transaction ID", "Account Number", "Type", "Amount", "Reference No", "Date"
            }
        ));
        jScrollPane2.setViewportView(tblTransactions);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 349, 611, 199));

        cmbAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(cmbAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 310, -1));

        cmbType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPOSIT", "WITHDRAW", "TRANSFER" }));
        jPanel1.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 310, -1));

        txtReferenceNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtReferenceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 310, -1));

        btnProcess.setBackground(new java.awt.Color(153, 255, 153));
        btnProcess.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProcess.setForeground(new java.awt.Color(0, 0, 0));
        btnProcess.setText("Process Transaction");
        btnProcess.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 1, true));
        btnProcess.setBorderPainted(false);
        btnProcess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProcess.setFocusPainted(false);
        btnProcess.addActionListener(this::btnProcessActionPerformed);
        jPanel1.add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 208, 40));

        btnClear.setBackground(new java.awt.Color(255, 204, 102));
        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 80, 40));

        btnDashboard.setBackground(new java.awt.Color(102, 153, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 120, 40));

        txtAmount1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 310, -1));

        cmbToAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(cmbToAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 310, -1));

        jPanel4.setBackground(new java.awt.Color(210, 225, 245));

        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(0, 51, 102));
        lblTitle2.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Transaction-Repeat-Recurring--Streamline-Plump-Remi1x.png")); // NOI18N
        lblTitle2.setText("Transaction Form");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle2)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 40));

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Reference No ");
        jLabel5.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel5.setRequestFocusEnabled(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, 30));

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Account");
        jLabel6.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel6.setRequestFocusEnabled(false);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, 30));

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText(" To Account ");
        jLabel12.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel12.setRequestFocusEnabled(false);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 90, 30));

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Type           ");
        jLabel13.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel13.setRequestFocusEnabled(false);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, 30));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Amount");
        jLabel10.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel10.setRequestFocusEnabled(false);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
                
        if (cmbAccount.getSelectedItem() == null ||
    cmbType.getSelectedItem() == null ||
    txtAmount1.getText().isEmpty() ||
    txtReferenceNo.getText().isEmpty()) {

    JOptionPane.showMessageDialog(this, "Fill all fields");
    return;
}
        
    try {
        Connection con = DBConnection.getConnection();

        String account = cmbAccount.getSelectedItem().toString();
        String type = cmbType.getSelectedItem().toString();
        double amount = Double.parseDouble(txtAmount1.getText());
        String ref = txtReferenceNo.getText();

        int accountId = Integer.parseInt(account.split(" - ")[0]);

        // GET CURRENT BALANCE
        PreparedStatement pst1 = con.prepareStatement(
            "SELECT balance FROM accounts WHERE account_id=?"
        );
        pst1.setInt(1, accountId);
        ResultSet rs = pst1.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Account not found");
            return;
        }

        double balance = rs.getDouble("balance");

        
        // DEPOSIT
        
        if (type.equals("DEPOSIT")) {

            PreparedStatement pst = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id=?"
            );
            pst.setDouble(1, amount);
            pst.setInt(2, accountId);
            pst.executeUpdate();

            PreparedStatement log = con.prepareStatement(
                "INSERT INTO transactions(account_id, transaction_type, amount, reference_no) VALUES (?,?,?,?)"
            );
            log.setInt(1, accountId);
            log.setString(2, "DEPOSIT");
            log.setDouble(3, amount);
            log.setString(4, ref);
            log.executeUpdate();
            
            PreparedStatement audit = con.prepareStatement(
    "INSERT INTO audit_logs(user_id, action_type, description) VALUES (?,?,?)"
);

audit.setInt(1, 1); // later replace with logged-in user
audit.setString(2, type);
audit.setString(3, "Transaction: " + type + " Amount: " + amount);

audit.executeUpdate();
        }

        
        // WITHDRAW
        
        else if (type.equals("WITHDRAW")) {

            if (balance < amount) {
                JOptionPane.showMessageDialog(this, "Insufficient Balance");
                return;
            }

            PreparedStatement pst = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id=?"
            );
            pst.setDouble(1, amount);
            pst.setInt(2, accountId);
            pst.executeUpdate();

            PreparedStatement log = con.prepareStatement(
                "INSERT INTO transactions(account_id, transaction_type, amount, reference_no) VALUES (?,?,?,?)"
            );
            log.setInt(1, accountId);
            log.setString(2, "WITHDRAW");
            log.setDouble(3, amount);
            log.setString(4, ref);
            log.executeUpdate();
            
            PreparedStatement audit = con.prepareStatement(
    "INSERT INTO audit_logs(user_id, action_type, description) VALUES (?,?,?)"
);

audit.setInt(1, 1); // later replace with logged-in user
audit.setString(2, type);
audit.setString(3, "Transaction: " + type + " Amount: " + amount);

audit.executeUpdate();
        }

       
        // TRANSFER
      
        else if (type.equals("TRANSFER")) {
            
            if (cmbToAccount.getSelectedItem() == null) {
             JOptionPane.showMessageDialog(this, "Select To Account");
              return;
            }

            int toAccountId = Integer.parseInt(
                cmbToAccount.getSelectedItem().toString().split(" - ")[0]
            );

            if (balance < amount) {
                JOptionPane.showMessageDialog(this, "Insufficient Balance");
                return;
            }

            // deduct sender
            PreparedStatement out = con.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id=?"
            );
            out.setDouble(1, amount);
            out.setInt(2, accountId);
            out.executeUpdate();

            // add receiver
            PreparedStatement in = con.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id=?"
            );
            in.setDouble(1, amount);
            in.setInt(2, toAccountId);
            in.executeUpdate();

            // log sender
            PreparedStatement log1 = con.prepareStatement(
                "INSERT INTO transactions(account_id, transaction_type, amount, reference_no) VALUES (?,?,?,?)"
            );
            log1.setInt(1, accountId);
            log1.setString(2, "TRANSFER_OUT");
            log1.setDouble(3, amount);
            log1.setString(4, ref);
            log1.executeUpdate();

            // log receiver
            PreparedStatement log2 = con.prepareStatement(
                "INSERT INTO transactions(account_id, transaction_type, amount, reference_no) VALUES (?,?,?,?)"
            );
            log2.setInt(1, toAccountId);
            log2.setString(2, "TRANSFER_IN");
            log2.setDouble(3, amount);
            log2.setString(4, ref);
            log2.executeUpdate();
            
            PreparedStatement audit = con.prepareStatement(
    "INSERT INTO audit_logs(user_id, action_type, description) VALUES (?,?,?)"
);

audit.setInt(1, 1); // later replace with logged-in user
audit.setString(2, type);
audit.setString(3, "Transaction: " + type + " Amount: " + amount);

audit.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Transaction Successful");

        loadTransactions();
        loadAccounts();

        txtAmount1.setText("");
        txtReferenceNo.setText("");
        cmbType.setSelectedIndex(0);
        cmbAccount.setSelectedIndex(0);
        cmbToAccount.setSelectedIndex(0);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Transaction Failed");
    }

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
                                                
    new Dashboard().setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
                                                
    txtAmount1.setText("");
    txtReferenceNo.setText("");
    cmbType.setSelectedIndex(0);
    cmbAccount.setSelectedIndex(0);
    cmbToAccount.setSelectedIndex(0);

    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TransactionForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnProcess;
    private javax.swing.JComboBox<String> cmbAccount;
    private javax.swing.JComboBox<String> cmbToAccount;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tblTransactions;
    private javax.swing.JTextField txtAmount1;
    private javax.swing.JTextField txtReferenceNo;
    // End of variables declaration//GEN-END:variables
}
