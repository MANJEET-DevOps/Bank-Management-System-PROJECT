
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;
    JTextField textName, textfName, textEmail, textAdd, textCity, textPin, textState;
    JDateChooser dateChooser;
    Random ran = new Random();
    Long first4 = (ran.nextLong() % 9000L) + 1800L;
    String FIRST = " " + Math.abs(first4);
    Signup() {
        super("APPLICATION FORM");
        // Set up the background panel
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\Administrator\\Desktop\\icon\\backbg - Copy.png");
        backgroundPanel.setLayout(null);
        add(backgroundPanel);
        // Add logo image
        try {
            ImageIcon logoIcon = new ImageIcon(ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\icon\\bank.png")).getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            JLabel logoLabel = new JLabel(logoIcon);
            logoLabel.setBounds(50, 10, 100, 100);
            backgroundPanel.add(logoLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Application Form Number
        JLabel label1 = new JLabel("APPLICATION FORM NO." + first4);
        label1.setBounds(160, 20, 680, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        backgroundPanel.add(label1);
        // Page Number
        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", Font.BOLD, 22));
        label2.setBounds(330, 70, 600, 30);
        backgroundPanel.add(label2);
        // Personal Details Header
        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(298, 90, 688, 30);
        backgroundPanel.add(label3);
        // Name
        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 190, 100, 30);
        backgroundPanel.add(labelName);
        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        backgroundPanel.add(textName);
        // Father's Name
        JLabel labelfName = new JLabel("Father's Name:");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100, 240, 200, 30);
        backgroundPanel.add(labelfName);
        textfName = new JTextField();
        textfName.setFont(new Font("Raleway", Font.BOLD, 14));
        textfName.setBounds(300, 240, 400, 30);
        backgroundPanel.add(textfName);
        // Date of Birth
        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 340, 200, 30);
        backgroundPanel.add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 340, 400, 30);
        backgroundPanel.add(dateChooser);
        //    Gender
        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        backgroundPanel.add(labelG);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 290, 60, 30);
        backgroundPanel.add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 290, 90, 30);
        backgroundPanel.add(r2);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        //  Email
        JLabel labelEmail = new JLabel("Email address:");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 390, 200, 30);
        backgroundPanel.add(labelEmail);
        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(300, 390, 400, 30);
        backgroundPanel.add(textEmail);
        // Marital Status
        JLabel labelMs = new JLabel("Marital Status:");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 440, 200, 30);
        backgroundPanel.add(labelMs);
        m1 = new JRadioButton("Married");
        m1.setBounds(300, 440, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        backgroundPanel.add(m1);
        m2 = new JRadioButton("Unmarried");
        m2.setBounds(420, 440, 100, 30);
        m2.setBackground(new Color(222, 255, 228));
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        backgroundPanel.add(m2);
        m3 = new JRadioButton("Other");
        m3.setBounds(550, 440, 106, 30);
        m3.setBackground(new Color(222, 255, 228));
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        backgroundPanel.add(m3);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(m1);
        maritalGroup.add(m2);
        maritalGroup.add(m3);
        // Address
        JLabel labelAdd = new JLabel("Address:");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100, 490, 200, 30);
        backgroundPanel.add(labelAdd);
        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 490, 400, 30);
        backgroundPanel.add(textAdd);
        // City
        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 540, 200, 30);
        backgroundPanel.add(labelCity);
        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(300, 540, 400, 30);
        backgroundPanel.add(textCity);
        // Pin Code
        JLabel labelPin = new JLabel("Pin Code:");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 590, 200, 30);
        backgroundPanel.add(labelPin);
        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 590, 400, 30);
        backgroundPanel.add(textPin);
        // State
        JLabel labelState = new JLabel("State:");
        labelState.setFont(new Font("Raleway", Font.BOLD, 20));
        labelState.setBounds(100, 640, 200, 30);
        backgroundPanel.add(labelState);
        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 640, 400, 30);
        backgroundPanel.add(textState);
        // Next Button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 680, 80, 30);
        next.addActionListener(this);
        backgroundPanel.add(next);
        setSize(850, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = FIRST;
        String name = textName.getText();
        String fname = textfName.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null;
        String email = textEmail.getText();
        String marital = m1.isSelected() ? "Married" : m2.isSelected() ? "Unmarried" : m3.isSelected() ? "Other" : null;
        String address = textAdd.getText();
        String city = textCity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();
        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || gender == null || email.equals("") || marital == null || address.equals("") || city.equals("") || pincode.equals("") || state.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Connn connection = new Connn();
                String q = "INSERT INTO `user`(`form_no`, `name`, `father_name`, `dob`, `gender`, `email`, `marital`, `address`, `city`, `pincode`, `state`) VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                connection.statement.executeUpdate(q);
                new Signup2(formno);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Signup::new);
    }
}
