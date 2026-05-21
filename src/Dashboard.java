import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PiePlot;

public class Dashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(Dashboard.class.getName());

    public Dashboard() {
        initComponents();
        loadTransactionChart();
        loadKPIData();
        loadPieChart();
    }
    public void setUserInfo(String username, String role) {
    lblLoginInfo.setText("Logged in as: " + username + " | Role: " + role);
}
private void loadPieChart() {

    DefaultPieDataset dataset = new DefaultPieDataset();

    try {

        Connection con = DBConnection.getConnection();

        String sql =
            "SELECT transaction_type, SUM(amount) AS total " +
            "FROM transactions GROUP BY transaction_type";

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            String type = rs.getString("transaction_type");
            double total = rs.getDouble("total");

            dataset.setValue(type, total);
        }

        // CREATE PIE CHART
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Transaction Distribution",
                dataset,
                true,
                true,
                false
        );

        //  CUSTOM COLORS
        PiePlot plot = (PiePlot) pieChart.getPlot();

        plot.setSectionPaint("DEPOSIT", Color.GREEN);
        plot.setSectionPaint("WITHDRAW", Color.RED);
        plot.setSectionPaint("TRANSFER", Color.BLUE);

        // SHOW CHART
        ChartPanel chartPanel = new ChartPanel(pieChart);

        panelPieChart.removeAll();
        panelPieChart.setLayout(new java.awt.BorderLayout());
        panelPieChart.add(chartPanel);

        panelPieChart.validate();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading pie chart");
    }

}
   
    //  TRANSACTION BAR CHART
   
    private void loadTransactionChart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT DATE_FORMAT(transaction_date, '%b') AS month, " +
                "MONTH(transaction_date) AS m, " +
                "transaction_type, SUM(amount) AS total " +
                "FROM transactions " +
                "GROUP BY m, transaction_type, month " +
                "ORDER BY m";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String month = rs.getString("month");
                String type = rs.getString("transaction_type");
                double total = rs.getDouble("total");

                dataset.addValue(total, type, month);
            }

            JFreeChart chart = ChartFactory.createBarChart(
                    "Bank Transaction Overview",
                    "Month",
                    "Amount (LKR)",
                    dataset
            );

            //  COLORS
            BarRenderer renderer =
                (BarRenderer) chart.getCategoryPlot().getRenderer();

            renderer.setSeriesPaint(0, Color.GREEN); // DEPOSIT
            renderer.setSeriesPaint(1, Color.RED);   // WITHDRAW
            renderer.setSeriesPaint(2, Color.BLUE);  // TRANSFER

            ChartPanel chartPanel = new ChartPanel(chart);

            panelChart.removeAll();
            panelChart.setLayout(new java.awt.BorderLayout());
            panelChart.add(chartPanel);
            panelChart.revalidate();
            panelChart.repaint();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error loading transaction chart");
        }
    }

   
    // KPI DASHBOARD VALUES
   
    private void loadKPIData() {

        try {
            Connection con = DBConnection.getConnection();

            // Today Deposits
            PreparedStatement pst1 = con.prepareStatement(
                "SELECT IFNULL(SUM(amount),0) FROM transactions " +
                "WHERE transaction_type='DEPOSIT' " +
                "AND DATE(transaction_date)=CURDATE()"
            );
            ResultSet rs1 = pst1.executeQuery();
            if (rs1.next()) {
                lblTodayDeposits.setText(
                    "Rs " + String.format("%,.2f", rs1.getDouble(1))
                );
            }

            // Today Withdrawals
            PreparedStatement pst2 = con.prepareStatement(
                "SELECT IFNULL(SUM(amount),0) FROM transactions " +
                "WHERE transaction_type='WITHDRAW' " +
                "AND DATE(transaction_date)=CURDATE()"
            );
            ResultSet rs2 = pst2.executeQuery();
            if (rs2.next()) {
                lblTodayWithdrawals.setText(
                    "Rs " + String.format("%,.2f", rs2.getDouble(1))
                );
            }

            // Monthly Income
            PreparedStatement pst3 = con.prepareStatement(
                "SELECT IFNULL(SUM(amount),0) FROM transactions " +
                "WHERE transaction_type='DEPOSIT' " +
                "AND MONTH(transaction_date)=MONTH(CURDATE())"
            );
            ResultSet rs3 = pst3.executeQuery();
            if (rs3.next()) {
                lblMonthlyIncome.setText(
                    "Rs " + String.format("%,.2f", rs3.getDouble(1))
                );
            }

            // Monthly Expenses
            PreparedStatement pst4 = con.prepareStatement(
                "SELECT IFNULL(SUM(amount),0) FROM transactions " +
                "WHERE transaction_type='WITHDRAW' " +
                "AND MONTH(transaction_date)=MONTH(CURDATE())"
            );
            ResultSet rs4 = pst4.executeQuery();
            if (rs4.next()) {
                lblMonthlyExpenses.setText(
                    "Rs " + String.format("%,.2f", rs4.getDouble(1))
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error loading KPI data");
        }
    

   
    // initComponents() stays SAME
   
}

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnLoans = new javax.swing.JButton();
        btnTransactions = new javax.swing.JButton();
        btnAccounts1 = new javax.swing.JButton();
        btnLoanPayments = new javax.swing.JButton();
        btnReports3 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnAuditLogs = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelChart = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblTodayDeposits = new javax.swing.JLabel();
        lblTodayDeposits1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblMonthlyIncome = new javax.swing.JLabel();
        lblMonthlyIncome1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblTodayWithdrawals = new javax.swing.JLabel();
        lblTodayWithdrawals1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblMonthlyExpenses = new javax.swing.JLabel();
        lblMonthlyExpenses1 = new javax.swing.JLabel();
        lblLoginInfo = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bank System Dashboard");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(230, 240, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(173, 216, 230));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLoans.setBackground(new java.awt.Color(173, 216, 230));
        btnLoans.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoans.setForeground(new java.awt.Color(51, 51, 51));
        btnLoans.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Share-Money-Dollar--Streamline-Plump-Remix.png")); // NOI18N
        btnLoans.setText("Loans");
        btnLoans.setBorderPainted(false);
        btnLoans.setContentAreaFilled(false);
        btnLoans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoans.addActionListener(this::btnLoansActionPerformed);
        jPanel2.add(btnLoans, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        btnTransactions.setBackground(new java.awt.Color(173, 216, 230));
        btnTransactions.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTransactions.setForeground(new java.awt.Color(51, 51, 51));
        btnTransactions.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Transaction-Repeat-Recurring--Streamline-Plump-Remix.png")); // NOI18N
        btnTransactions.setText("Transactions");
        btnTransactions.setBorderPainted(false);
        btnTransactions.setContentAreaFilled(false);
        btnTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransactions.addActionListener(this::btnTransactionsActionPerformed);
        jPanel2.add(btnTransactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btnAccounts1.setBackground(new java.awt.Color(173, 216, 230));
        btnAccounts1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAccounts1.setForeground(new java.awt.Color(51, 51, 51));
        btnAccounts1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\User-Folder--Streamline-Plump-Remix.png")); // NOI18N
        btnAccounts1.setText("Accounts");
        btnAccounts1.setBorderPainted(false);
        btnAccounts1.setContentAreaFilled(false);
        btnAccounts1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccounts1.addActionListener(this::btnAccounts1ActionPerformed);
        jPanel2.add(btnAccounts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btnLoanPayments.setBackground(new java.awt.Color(173, 216, 230));
        btnLoanPayments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoanPayments.setForeground(new java.awt.Color(51, 51, 51));
        btnLoanPayments.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Credit-Card-Approved--Streamline-Plump-Remix.png")); // NOI18N
        btnLoanPayments.setText("Loan Payments");
        btnLoanPayments.setToolTipText("");
        btnLoanPayments.setBorderPainted(false);
        btnLoanPayments.setContentAreaFilled(false);
        btnLoanPayments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoanPayments.addActionListener(this::btnLoanPaymentsActionPerformed);
        jPanel2.add(btnLoanPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        btnReports3.setBackground(new java.awt.Color(173, 216, 230));
        btnReports3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReports3.setForeground(new java.awt.Color(51, 51, 51));
        btnReports3.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Reports-Document-Analytics--Streamline-Plump-Remix.png")); // NOI18N
        btnReports3.setText("Reports");
        btnReports3.setBorderPainted(false);
        btnReports3.setContentAreaFilled(false);
        btnReports3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports3.setFocusPainted(false);
        btnReports3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports3.addActionListener(this::btnReports3ActionPerformed);
        jPanel2.add(btnReports3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        btnLogout.setBackground(new java.awt.Color(173, 216, 230));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Logout-3--Streamline-Plump-Remix(1).png")); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);
        btnLogout.setMargin(new java.awt.Insets(2, 0, 3, 14));
        btnLogout.addActionListener(this::btnLogoutActionPerformed);
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 40));

        btnAuditLogs.setBackground(new java.awt.Color(173, 216, 230));
        btnAuditLogs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAuditLogs.setForeground(new java.awt.Color(51, 51, 51));
        btnAuditLogs.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Zoom-Document--Streamline-Plump-Remix.png")); // NOI18N
        btnAuditLogs.setText("Audit Logs");
        btnAuditLogs.setBorderPainted(false);
        btnAuditLogs.setContentAreaFilled(false);
        btnAuditLogs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAuditLogs.addActionListener(this::btnAuditLogsActionPerformed);
        jPanel2.add(btnAuditLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        btnCustomers.setBackground(new java.awt.Color(173, 216, 230));
        btnCustomers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(51, 51, 51));
        btnCustomers.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Information-Desk-Customer--Streamline-Plump-Remix.png")); // NOI18N
        btnCustomers.setText("Customers");
        btnCustomers.setBorderPainted(false);
        btnCustomers.setContentAreaFilled(false);
        btnCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomers.addActionListener(this::btnCustomersActionPerformed);
        jPanel2.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel3.setBackground(new java.awt.Color(170, 195, 225));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Bank--Streamline-Plump-Remix.png")); // NOI18N
        jLabel1.setText("Dashboard");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        panelChart.setBackground(new java.awt.Color(230, 240, 255));
        panelChart.setForeground(new java.awt.Color(230, 240, 255));
        panelChart.setPreferredSize(new java.awt.Dimension(500, 300));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel1.add(panelChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 330, 220));

        jPanel8.setBackground(new java.awt.Color(230, 240, 255));

        lblTodayDeposits.setBackground(new java.awt.Color(0, 153, 51));
        lblTodayDeposits.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblTodayDeposits.setForeground(new java.awt.Color(51, 204, 0));
        lblTodayDeposits.setText("Today Deposits");

        lblTodayDeposits1.setBackground(new java.awt.Color(0, 153, 51));
        lblTodayDeposits1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTodayDeposits1.setForeground(new java.awt.Color(51, 51, 51));
        lblTodayDeposits1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Money-Incoming-Profit--Streamline-Plump-Remix.png")); // NOI18N
        lblTodayDeposits1.setText("Today Deposits");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTodayDeposits))
                    .addComponent(lblTodayDeposits1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodayDeposits1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTodayDeposits)
                .addGap(32, 32, 32))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, 50));

        jPanel10.setBackground(new java.awt.Color(230, 240, 255));
        jPanel10.setForeground(new java.awt.Color(51, 51, 51));

        lblMonthlyIncome.setBackground(new java.awt.Color(0, 0, 51));
        lblMonthlyIncome.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblMonthlyIncome.setForeground(new java.awt.Color(0, 204, 51));
        lblMonthlyIncome.setText("Monthly Income");

        lblMonthlyIncome1.setBackground(new java.awt.Color(0, 0, 51));
        lblMonthlyIncome1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMonthlyIncome1.setForeground(new java.awt.Color(51, 51, 51));
        lblMonthlyIncome1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Money-Incoming-Profit--Streamline-Plump-Remix.png")); // NOI18N
        lblMonthlyIncome1.setText("Monthly Income");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(lblMonthlyIncome1)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMonthlyIncome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblMonthlyIncome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMonthlyIncome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, 60));

        jPanel9.setBackground(new java.awt.Color(230, 240, 255));

        lblTodayWithdrawals.setBackground(new java.awt.Color(0, 0, 51));
        lblTodayWithdrawals.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblTodayWithdrawals.setForeground(new java.awt.Color(255, 51, 51));
        lblTodayWithdrawals.setText("Today Withdrawals");

        lblTodayWithdrawals1.setBackground(new java.awt.Color(0, 0, 51));
        lblTodayWithdrawals1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblTodayWithdrawals1.setForeground(new java.awt.Color(51, 51, 51));
        lblTodayWithdrawals1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Money-Outgoing-Expense--Streamline-Plump-Remix.png")); // NOI18N
        lblTodayWithdrawals1.setText("Today Withdrawals");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblTodayWithdrawals))
                    .addComponent(lblTodayWithdrawals1))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTodayWithdrawals1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTodayWithdrawals)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 150, 60));

        jPanel5.setBackground(new java.awt.Color(230, 240, 255));

        lblMonthlyExpenses.setBackground(new java.awt.Color(0, 0, 51));
        lblMonthlyExpenses.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblMonthlyExpenses.setForeground(new java.awt.Color(255, 51, 51));
        lblMonthlyExpenses.setText("Monthly Expenses");

        lblMonthlyExpenses1.setBackground(new java.awt.Color(0, 0, 51));
        lblMonthlyExpenses1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMonthlyExpenses1.setForeground(new java.awt.Color(51, 51, 51));
        lblMonthlyExpenses1.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Money-Outgoing-Expense--Streamline-Plump-Remix.png")); // NOI18N
        lblMonthlyExpenses1.setText("Monthly Expenses");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblMonthlyExpenses))
                    .addComponent(lblMonthlyExpenses1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMonthlyExpenses1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMonthlyExpenses)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 50));

        lblLoginInfo.setBackground(new java.awt.Color(0, 0, 51));
        lblLoginInfo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblLoginInfo.setForeground(new java.awt.Color(0, 0, 204));
        lblLoginInfo.setIcon(new javax.swing.ImageIcon("D:\\Documents\\NetBeansProjects\\SmartBankSystem\\src\\icons\\Customer-Support-6--Streamline-Plump-Remix.png")); // NOI18N
        lblLoginInfo.setText("Logged in as :");
        lblLoginInfo.setToolTipText("");
        jPanel1.add(lblLoginInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        panelPieChart.setBackground(new java.awt.Color(230, 240, 255));
        panelPieChart.setForeground(new java.awt.Color(230, 240, 255));

        javax.swing.GroupLayout panelPieChartLayout = new javax.swing.GroupLayout(panelPieChart);
        panelPieChart.setLayout(panelPieChartLayout);
        panelPieChartLayout.setHorizontalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        panelPieChartLayout.setVerticalGroup(
            panelPieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel1.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 210, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        new CustomerForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionsActionPerformed
        new TransactionForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransactionsActionPerformed

    private void btnLoansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoansActionPerformed
        
    new LoanForm().setVisible(true);
    this.dispose(); 

    }//GEN-LAST:event_btnLoansActionPerformed

    private void btnAccounts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccounts1ActionPerformed
        new AccountForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAccounts1ActionPerformed

    private void btnLoanPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanPaymentsActionPerformed
        
    new LoanPaymentForm().setVisible(true);
    this.dispose();

    }//GEN-LAST:event_btnLoanPaymentsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
                                              
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        new LoginForm().setVisible(true); // change login form name
        this.dispose(); // close dashboard
    }

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnAuditLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditLogsActionPerformed
       
    new AuditForm().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnAuditLogsActionPerformed

    private void btnReports3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReports3ActionPerformed
        
    new ReportForm().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnReports3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccounts1;
    private javax.swing.JButton btnAuditLogs;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnLoanPayments;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReports3;
    private javax.swing.JButton btnTransactions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblLoginInfo;
    private javax.swing.JLabel lblMonthlyExpenses;
    private javax.swing.JLabel lblMonthlyExpenses1;
    private javax.swing.JLabel lblMonthlyIncome;
    private javax.swing.JLabel lblMonthlyIncome1;
    private javax.swing.JLabel lblTodayDeposits;
    private javax.swing.JLabel lblTodayDeposits1;
    private javax.swing.JLabel lblTodayWithdrawals;
    private javax.swing.JLabel lblTodayWithdrawals1;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel panelPieChart;
    // End of variables declaration//GEN-END:variables
}
