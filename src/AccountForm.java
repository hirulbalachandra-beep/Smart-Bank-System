import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AccountForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AccountForm.class.getName());

  
    private int selectedAccountId = -1;
    
    public AccountForm() {
        initComponents();
        loadCustomers();
        loadAccounts();
        
        tblAccounts.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblAccounts.getSelectedRow();
        if (row == -1) return;

        selectedAccountId = Integer.parseInt(
        tblAccounts.getValueAt(row, 0).toString()
        );

        txtAccountNumber.setText(tblAccounts.getValueAt(row, 2).toString());
        txtBalance.setText(tblAccounts.getValueAt(row, 3).toString());
        cmbType.setSelectedItem(tblAccounts.getValueAt(row, 4).toString());
    }
});
}

   public void loadAccounts() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT a.account_id, c.full_name, a.account_number, a.balance, a.account_type " +
                     "FROM accounts a JOIN customers c ON a.customer_id = c.customer_id";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tblAccounts.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[]{

                rs.getInt("account_id"),
                rs.getString("full_name"),
                rs.getString("account_number"),
                rs.getDouble("balance"),
                rs.getString("account_type")

            });

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);

    }

}

public void loadCustomers() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT customer_id, full_name FROM customers";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        cmbCustomer.removeAllItems();

        while (rs.next()) {

            cmbCustomer.addItem(
                rs.getInt("customer_id") + " - " + rs.getString("full_name")
            );

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);

    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccounts = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox<>();
        cmbType = new javax.swing.JComboBox<>();
        txtBalance = new javax.swing.JTextField();
        txtAccountNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account Form");

        jPanel1.setBackground(new java.awt.Color(230, 240, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Account ID  ", "Customer Name", "Account Number", "Balance", "Type"
            }
        ));
        jScrollPane1.setViewportView(tblAccounts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 610, 240));

        btnCreate.setBackground(new java.awt.Color(102, 204, 0));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(this::btnCreateActionPerformed);
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 100, 40));

        btnUpdate.setBackground(new java.awt.Color(102, 153, 0));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 90, 40));

        btnDelete.setBackground(new java.awt.Color(255, 153, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 90, 40));

        btnClear.setBackground(new java.awt.Color(204, 204, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 80, 40));

        btnDashboard.setBackground(new java.awt.Color(0, 153, 153));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 122, 39));

        cmbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 220, 30));

        cmbType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Savings", "Current" }));
        cmbType.addActionListener(this::cmbTypeActionPerformed);
        jPanel1.add(cmbType, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 220, -1));

        txtBalance.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 220, -1));

        txtAccountNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtAccountNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 220, -1));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Customer");
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel8.setRequestFocusEnabled(false);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 90, 30));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText(" Account No");
        jLabel9.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel9.setRequestFocusEnabled(false);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 90, 30));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Balance");
        jLabel10.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel10.setRequestFocusEnabled(false);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 90, 30));

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Type");
        jLabel11.setPreferredSize(new java.awt.Dimension(60, 100));
        jLabel11.setRequestFocusEnabled(false);
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, 30));

        jPanel4.setBackground(new java.awt.Color(210, 225, 245));

        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(0, 51, 102));
        lblTitle2.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Clipboard-Check--Streamline-Plump-Remix.png")); // NOI18N
        lblTitle2.setText("Account Form");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle2)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTypeActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed


    try {
        
        if (cmbCustomer.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Select a customer");
        return;
        }

        if (txtAccountNumber.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Enter account number");
        return;
        }

        if (txtBalance.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Enter balance");
        return;
        }

        Connection con = DBConnection.getConnection();

        String selectedCustomer = cmbCustomer.getSelectedItem().toString();

        int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);

        String sql = "INSERT INTO accounts(customer_id, account_number, balance, account_type) VALUES (?, ?, ?, ?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, customerId);
        pst.setString(2, txtAccountNumber.getText());
        double balance;

        try {
            balance = Double.parseDouble(txtBalance.getText());
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid balance");
            return;
        }

        pst.setDouble(3, balance);
        pst.setString(4, cmbType.getSelectedItem().toString());

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Account Created Successfully");

        loadAccounts();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);

    }


    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      
    txtAccountNumber.setText("");
    txtBalance.setText("");
    cmbType.setSelectedIndex(0);
    cmbCustomer.setSelectedIndex(0);

    selectedAccountId = -1;

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    try {

        if (selectedAccountId == -1) {
            JOptionPane.showMessageDialog(null, "Select an account first");
            return;
        }

        Connection con = DBConnection.getConnection();

        String sql = "DELETE FROM accounts WHERE account_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, selectedAccountId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Account Deleted");

        loadAccounts();

        selectedAccountId = -1;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    try {

        if (selectedAccountId == -1) {
            JOptionPane.showMessageDialog(null, "Select an account first");
            return;
        }

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE accounts SET account_number=?, balance=?, account_type=? WHERE account_id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, txtAccountNumber.getText());
        double balance;

        try {
         balance = Double.parseDouble(txtBalance.getText());
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid balance");
         return;
        }

        pst.setDouble(2, balance);
        pst.setString(3, cmbType.getSelectedItem().toString());
        pst.setInt(4, selectedAccountId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Account Updated Successfully");

        loadAccounts();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        btnDashboard.addActionListener(e -> {
            new Dashboard().setVisible(true);
            this.dispose();
        });
    }//GEN-LAST:event_btnDashboardActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AccountForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tblAccounts;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtBalance;
    // End of variables declaration//GEN-END:variables

}