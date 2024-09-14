import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Bank extends JFrame implements ActionListener {

    private static JFrame login;
    private JTextField t1;
    private JPasswordField value;
    private JButton b, c, d;

    public Bank() {
        try {
            login = new JFrame("Login");
            login.setBounds(500, 400, 850, 800);  // Adjusted size to fit all components

            // Correct path to image file
            BufferedImage mypicture = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\icon\\bank.png"));

            // Create ImageIcon and scale the image
            ImageIcon icon = new ImageIcon(mypicture.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            JLabel picLabel = new JLabel(icon);
            picLabel.setBounds(400, 10, 60, 60); // Set bounds as needed
            login.add(picLabel);

            BufferedImage mypicture1 = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\icon\\card.png"));
            ImageIcon icon1 = new ImageIcon(mypicture1.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
            JLabel picLabel1 = new JLabel(icon1);
            picLabel1.setBounds(800, 400, 300, 300); // Set bounds as needed
            login.add(picLabel1);

            // Initialize components
            t1 = new JTextField();
            JLabel l2 = new JLabel("Card Number:");
            l2.setBounds(450, 100, 120, 30);
            t1.setBounds(600, 100, 250, 30);
            login.add(l2);
            login.add(t1);

            JLabel l4 = new JLabel("BANK ");
            l4.setFont(new Font("Raleway", Font.BOLD, 50));
            l4.setBounds(500, 10, 200, 50);
            login.add(l4);

            JLabel l3 = new JLabel("Don't have an account? Click to sign up:");
            l3.setBounds(450, 290, 400, 30);
            login.add(l3);

            JLabel l5 = new JLabel("CUSTOMER LOGIN PAGE");
            l5.setBounds(500, 50, 300, 30);
            login.add(l5);

            value = new JPasswordField();
            JLabel l1 = new JLabel("Pin:");
            l1.setBounds(450, 150, 250, 30);
            value.setBounds(600, 150, 250, 30);
            login.add(value);
            login.add(l1);

            b = new JButton("Login");
            b.setBounds(550, 210, 80, 60);
            b.addActionListener(this);  // Register this class as the ActionListener
            login.add(b);

            d = new JButton("Cancel");
            d.setBounds(650, 210, 80, 60);
            d.addActionListener(this);  // Register this class as the ActionListener
            login.add(d);

            c = new JButton("Signup");
            c.setBounds(700, 280, 80, 40);
            c.addActionListener(this);  // Register this class as the ActionListener
            login.add(c);

            login.setLayout(null);
            login.setLocation(0, 0);
            login.setSize(1500, 1080);
            login.getContentPane().setBackground(new Color(216, 191, 216));
            login.setVisible(true);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            System.err.println("Error initializing the frame: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class DatabaseUtils {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_123";
        private static final String USER = "root";  // Update with your MySQL username
        private static final String PASSWORD = "";   // Update with your MySQL password

        public static Connection connect() throws SQLException {
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        }

        public static boolean validateLogin(String cardnumber, String pin) {
            String query = "SELECT * FROM login WHERE card_number = ? AND pin = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, cardnumber);
                pstmt.setString(2, pin);

                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next();  // Return true if a record is found
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }

        public static boolean signup(String cardnumber, String pin) {
            String query =  "INSERT INTO `login`(`card_number`, `pin`) VALUES ('"+cardnumber+"', '"+pin+"')";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, cardnumber);
                pstmt.setString(2, pin);

                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                if (e.getMessage().contains("Duplicate entry")) {
                    System.out.println("Card number already exists or pin is reused.");
                }
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b) {  // Login button clicked
                String cardnumber = t1.getText();
                String pin = new String(value.getPassword());

                if (DatabaseUtils.validateLogin(cardnumber, pin)) {
                    JOptionPane.showMessageDialog(this, "Login Successful!");
                    new Main(pin);
                    login.dispose(); 
                    // Proceed to the main application or dashboard
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid card number or pin.");
                }
            } else if (e.getSource() == c) {  // Signup button clicked
                new Signup();  // Instantiate and show the Signup form
                login.dispose();  // Close the login window
            } else if (e.getSource() == d) {  // Cancel button clicked
                login.dispose();  // Close the login window
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        new Bank();
    }
}
