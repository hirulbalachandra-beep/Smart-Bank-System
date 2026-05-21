import net.sf.jasperreports.swing.JRViewer;
import java.io.InputStream;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.swing.JRViewer;

public class ReportForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ReportForm.class.getName());

    /**
     * Creates new form ReportForm
     */
    public ReportForm() {
    initComponents();
    }
    
    

public void openReport(String reportName) {
    try {
        java.sql.Connection con = DBConnection.getConnection();

        String path = "src/" + reportName;

        JasperReport jr =
            JasperCompileManager.compileReport(path);

        JasperPrint jp =
            JasperFillManager.fillReport(jr, null, con);

        reportPanel.removeAll();
        reportPanel.setLayout(new java.awt.BorderLayout());

        JRViewer viewer = new JRViewer(jp);

        reportPanel.add(viewer, java.awt.BorderLayout.CENTER);

        reportPanel.revalidate();
        reportPanel.repaint();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnLoan = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnTransaction = new javax.swing.JButton();
        btnLoanPayment = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAudit1 = new javax.swing.JButton();
        reportPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report Center  ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLoan.setBackground(new java.awt.Color(173, 216, 230));
        btnLoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoan.setForeground(new java.awt.Color(51, 51, 51));
        btnLoan.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Share-Money-Dollar--Streamline-Plump-Remix.png")); // NOI18N
        btnLoan.setText("Loan Report");
        btnLoan.setContentAreaFilled(false);
        btnLoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoan.addActionListener(this::btnLoanActionPerformed);
        jPanel1.add(btnLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        btnCustomer.setBackground(new java.awt.Color(173, 216, 230));
        btnCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomer.setForeground(new java.awt.Color(51, 51, 51));
        btnCustomer.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Information-Desk-Customer--Streamline-Plump-Remix.png")); // NOI18N
        btnCustomer.setText("Customer Report");
        btnCustomer.setContentAreaFilled(false);
        btnCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomer.addActionListener(this::btnCustomerActionPerformed);
        jPanel1.add(btnCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        btnTransaction.setBackground(new java.awt.Color(173, 216, 230));
        btnTransaction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTransaction.setForeground(new java.awt.Color(51, 51, 51));
        btnTransaction.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Transaction-Repeat-Recurring--Streamline-Plump-Remix.png")); // NOI18N
        btnTransaction.setText("Transaction Report");
        btnTransaction.setContentAreaFilled(false);
        btnTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransaction.addActionListener(this::btnTransactionActionPerformed);
        jPanel1.add(btnTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        btnLoanPayment.setBackground(new java.awt.Color(173, 216, 230));
        btnLoanPayment.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoanPayment.setForeground(new java.awt.Color(51, 51, 51));
        btnLoanPayment.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Payment-Methods-Options--Streamline-Plump-Remix.png")); // NOI18N
        btnLoanPayment.setText("Loan Payment Report");
        btnLoanPayment.setContentAreaFilled(false);
        btnLoanPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoanPayment.addActionListener(this::btnLoanPaymentActionPerformed);
        jPanel1.add(btnLoanPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        btnClose.setBackground(new java.awt.Color(255, 153, 102));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(this::btnCloseActionPerformed);
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 130, 40));

        jPanel4.setBackground(new java.awt.Color(210, 225, 245));

        lblTitle2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(0, 51, 102));
        lblTitle2.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Reports-Document-Analytics--Streamline-Plump-Remix.png")); // NOI18N
        lblTitle2.setText("Report Center  ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle2)
                .addContainerGap(555, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 40));

        btnDashboard.setBackground(new java.awt.Color(0, 153, 153));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setToolTipText("");
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);
        jPanel1.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 130, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\icons8-bank-building-100.png")); // NOI18N
        jLabel6.setRequestFocusEnabled(false);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 100, 100));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Secure. Simple. Smart Banking.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        btnAudit1.setBackground(new java.awt.Color(173, 216, 230));
        btnAudit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAudit1.setForeground(new java.awt.Color(51, 51, 51));
        btnAudit1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Zoom-Document--Streamline-Plump-Remix.png")); // NOI18N
        btnAudit1.setText("Audit Report");
        btnAudit1.setContentAreaFilled(false);
        btnAudit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAudit1.addActionListener(this::btnAudit1ActionPerformed);
        jPanel1.add(btnAudit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 372, 610));

        reportPanel.setBackground(new java.awt.Color(230, 240, 255));

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(reportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 800, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoanPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanPaymentActionPerformed
      
    openReport("LoanPaymentReport.jrxml");

    }//GEN-LAST:event_btnLoanPaymentActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed

    openReport("CustomerReport.jrxml");

    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionActionPerformed
                                                  
    openReport("TransactionReport.jrxml");

    }//GEN-LAST:event_btnTransactionActionPerformed

    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
                                          
    openReport("LoanReport.jrxml");

    }//GEN-LAST:event_btnLoanActionPerformed

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed

        new Dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnAudit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAudit1ActionPerformed
        openReport("AuditReport.jrxml");
    }//GEN-LAST:event_btnAudit1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new ReportForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAudit1;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnLoanPayment;
    private javax.swing.JButton btnTransaction;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JPanel reportPanel;
    // End of variables declaration//GEN-END:variables
}
