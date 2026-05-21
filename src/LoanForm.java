import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LoanForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoanForm.class.getName());

    private int selectedLoanId = -1;
    
    public LoanForm() {
    initComponents();
    loadCustomers();
    loadLoans();
    
    
    cmbStatus.setEnabled(false);

    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {

            int row = jTable1.getSelectedRow();

            if (row == -1) return;

            selectedLoanId = Integer.parseInt(
                jTable1.getValueAt(row, 0).toString()
            );

            txtLoanAmount.setText(jTable1.getValueAt(row, 2).toString());
            txtInterestRate.setText(jTable1.getValueAt(row, 3).toString());
            txtDuration.setText(jTable1.getValueAt(row, 4).toString());
            cmbStatus.setSelectedItem(
            jTable1.getValueAt(row, 5).toString()
            );
            
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnApplyLoan = new javax.swing.JButton();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtInterestRate = new javax.swing.JTextField();
        txtLoanAmount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCustomer = new javax.swing.JComboBox<>();
        btnDashboard = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan Form");

        jPanel1.setBackground(new java.awt.Color(230, 240, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Customer ", "Amount ", "Interest Rate", "Duration", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 640, 226));

        btnApplyLoan.setBackground(new java.awt.Color(0, 153, 153));
        btnApplyLoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnApplyLoan.setForeground(new java.awt.Color(255, 255, 255));
        btnApplyLoan.setText("Apply Loan");
        btnApplyLoan.addActionListener(this::btnApplyLoanActionPerformed);
        jPanel1.add(btnApplyLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 40));

        btnApprove.setBackground(new java.awt.Color(0, 204, 0));
        btnApprove.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setText("Approve");
        btnApprove.addActionListener(this::btnApproveActionPerformed);
        jPanel1.add(btnApprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 120, 40));

        btnReject.setBackground(new java.awt.Color(255, 51, 51));
        btnReject.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnReject.setForeground(new java.awt.Color(255, 255, 255));
        btnReject.setText("Reject");
        btnReject.addActionListener(this::btnRejectActionPerformed);
        jPanel1.add(btnReject, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 90, 40));

        btnClear.setBackground(new java.awt.Color(255, 153, 51));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 80, 40));

        cmbStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING", "APPROVED", "REJECTED", "PAID" }));
        jPanel1.add(cmbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 137, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Duration");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 80, -1));

        txtDuration.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 137, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Status");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 60, -1));

        txtInterestRate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtInterestRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 137, -1));

        txtLoanAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtLoanAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 137, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Customer ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 96, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Loan Amount ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 115, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Interest Rate");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 100, -1));

        cmbCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 137, -1));

        btnDashboard.setBackground(new java.awt.Color(102, 102, 255));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 130, 40));

        jPanel2.setBackground(new java.awt.Color(210, 225, 245));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 102));
        lblTitle.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Share-Money-Dollar--Streamline-Plump-Remix.png")); // NOI18N
        lblTitle.setText("Loan Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addContainerGap(553, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(lblTitle))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void loadCustomers() {

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT customer_id, full_name FROM customers";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        cmbCustomer.removeAllItems();

        while (rs.next()) {

            cmbCustomer.addItem(
                rs.getInt("customer_id") + " - " +
                rs.getString("full_name")
            );
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);

    }
}

public void loadLoans() {

    try {

        Connection con = DBConnection.getConnection();

        String sql =
        "SELECT l.loan_id, c.full_name, l.loan_amount, " +
        "l.interest_rate, l.duration_months, l.status " +
        "FROM loans l " +
        "JOIN customers c ON l.customer_id = c.customer_id";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        DefaultTableModel model =
        (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);

        while (rs.next()) {

            model.addRow(new Object[] {

              rs.getInt("loan_id"),
              rs.getString("full_name"),
              rs.getDouble("loan_amount"),
              rs.getDouble("interest_rate"),
              rs.getInt("duration_months"),
              rs.getString("status")
        });
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e);

    }
}
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      
    txtLoanAmount.setText("");
    txtInterestRate.setText("");
    txtDuration.setText("");
    cmbCustomer.setSelectedIndex(0);
    selectedLoanId = -1;

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
                                       
    try {
        if (selectedLoanId == -1) {
            JOptionPane.showMessageDialog(null, "Select a loan first");
            return;
        }

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE loans SET status='REJECTED' WHERE loan_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, selectedLoanId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Loan Rejected");
        loadLoans();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnApplyLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyLoanActionPerformed
      
        if (txtLoanAmount.getText().isEmpty() ||
    txtInterestRate.getText().isEmpty() ||
    txtDuration.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "Fill all fields");
    return;
}
    try {
        if (cmbCustomer.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Select customer");
            return;
        }

        String selectedCustomer = cmbCustomer.getSelectedItem().toString();
        int customerId = Integer.parseInt(selectedCustomer.split(" - ")[0]);

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO loans(customer_id, loan_amount, interest_rate, duration_months, status) " +
                     "VALUES (?, ?, ?, ?, 'PENDING')";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, customerId);
        pst.setDouble(2, Double.parseDouble(txtLoanAmount.getText()));
        pst.setDouble(3, Double.parseDouble(txtInterestRate.getText()));
        pst.setInt(4, Integer.parseInt(txtDuration.getText()));

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Loan Applied Successfully");
        loadLoans();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_btnApplyLoanActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        
    try {
        if (selectedLoanId == -1) {
            JOptionPane.showMessageDialog(null, "Select a loan first");
            return;
        }

        Connection con = DBConnection.getConnection();

        String sql = "UPDATE loans SET status='APPROVED' WHERE loan_id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, selectedLoanId);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Loan Approved");
        loadLoans();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    }//GEN-LAST:event_btnApproveActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new LoanForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplyLoan;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnReject;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtInterestRate;
    private javax.swing.JTextField txtLoanAmount;
    // End of variables declaration//GEN-END:variables
}
