import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/BankSystemDB",
                "root",
                "1234"
            );

            System.out.println("Connection Success");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

        }

        return con;

    }

}