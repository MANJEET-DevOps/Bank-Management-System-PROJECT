
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

// Custom JPanel class to handle background image

class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            System.err.println("Error loading background image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Signup2 extends JFrame implements ActionListener {

    JComboBox<String> box, box2, box3, box4, box5;
    JRadioButton r1, r2, r3, r4;
    JTextField textPan, textAdh;
    JButton next;
    String formno;

    Signup2(String formno) {
        
        super("APPLICATION FORM");
        setSize(850, 800);
        this.formno = formno;

        // Set custom panel with background image
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\Administrator\\Desktop\\icon\\backbg.png");
        backgroundPanel.setLayout(null);
        add(backgroundPanel);

        try {
            BufferedImage mypicture = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\icon\\bank.png"));
            ImageIcon icon = new ImageIcon(mypicture.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            JLabel picLabel = new JLabel(icon);
            picLabel.setBounds(200, 30, 60, 60);
            backgroundPanel.add(picLabel);

            JLabel l2 = new JLabel("ADDITIONAL DETAILS");
            l2.setBounds(300, 30, 680, 40);
            l2.setFont(new Font("Raleway", Font.BOLD, 30));
            backgroundPanel.add(l2);

            
            JLabel l1 = new JLabel("Page 2:");
            l1.setFont(new Font("Raleway", Font.BOLD, 22));
            l1.setBounds(300, 60, 600, 40);
            backgroundPanel.add(l1);

            JLabel l3 = new JLabel("Religion:");
            l3.setFont(new Font("Raleway", Font.BOLD, 18));
            l3.setBounds(200, 120, 100, 30);
            backgroundPanel.add(l3);

            String[] religion = {"Select", "HINDU", "MUSLIM", "SIKH", "CHRISTIAN", "OTHER"};
            box = new JComboBox<>(religion);
            box.setBackground(new Color(144, 213, 255));
            box.setFont(new Font("Raleway", Font.BOLD, 14));
            box.setBounds(400, 120, 320, 30);
            backgroundPanel.add(box);

            JLabel l4 = new JLabel("Category:");
            l4.setFont(new Font("Raleway", Font.BOLD, 18));
            l4.setBounds(200, 170, 100, 30);
            backgroundPanel.add(l4);

            String[] category = {"Select", "GENERAL", "OBC", "SC", "ST"};
            box2 = new JComboBox<>(category);
            box2.setBackground(new Color(144, 213, 255));
            box2.setFont(new Font("Raleway", Font.BOLD, 14));
            box2.setBounds(400, 170, 320, 30);
            backgroundPanel.add(box2);

            JLabel l5 = new JLabel("Income:");
            l5.setFont(new Font("Raleway", Font.BOLD, 18));
            l5.setBounds(200, 220, 100, 30);
            backgroundPanel.add(l5);

            String[] income = {"Select", "NULL", "<1,50,000", "<2,50,000", "5,00,000", "Upto 10,00,000", "Above 10,00,000"};
            box3 = new JComboBox<>(income);
            box3.setBackground(new Color(144, 213, 255));
            box3.setFont(new Font("Raleway", Font.BOLD, 14));
            box3.setBounds(400, 220, 320, 30);
            backgroundPanel.add(box3);

            JLabel l6 = new JLabel("Educational:");
            l6.setFont(new Font("Raleway", Font.BOLD, 18));
            l6.setBounds(200, 270, 150, 30);
            backgroundPanel.add(l6);

            String[] educational = {"Select", "NON-GRADUATE", "GRADUATE", "POST-GRADUATE", "DOCTORATE", "OTHER"};
            box4 = new JComboBox<>(educational);
            box4.setBackground(new Color(144, 213, 255));
            box4.setFont(new Font("Raleway", Font.BOLD, 14));
            box4.setBounds(400, 270, 320, 30);
            backgroundPanel.add(box4);

            JLabel l7 = new JLabel("Occupation:");
            l7.setFont(new Font("Raleway", Font.BOLD, 18));
            l7.setBounds(200, 320, 150, 30);
            backgroundPanel.add(l7);

            String[] occupation = {"Select", "SALARIED", "SELF-EMPLOYED", "BUSINESS", "STUDENT", "RETIRED", "OTHER"};
            box5 = new JComboBox<>(occupation);
            box5.setBackground(new Color(144, 213, 255));
            box5.setFont(new Font("Raleway", Font.BOLD, 14));
            box5.setBounds(400, 320, 320, 30);
            backgroundPanel.add(box5);

            JLabel l8 = new JLabel("Pan Number:");
            l8.setFont(new Font("Raleway", Font.BOLD, 18));
            l8.setBounds(200, 370, 150, 30);
            backgroundPanel.add(l8);

            textPan = new JTextField();
            textPan.setFont(new Font("Raleway", Font.BOLD, 18));
            textPan.setBounds(400, 370, 320, 30);
            backgroundPanel.add(textPan);

            JLabel l9 = new JLabel("Aadhaar Number:");
            l9.setFont(new Font("Raleway", Font.BOLD, 18));
            l9.setBounds(200, 420, 250, 30);
            backgroundPanel.add(l9);

            textAdh = new JTextField();
            textAdh.setFont(new Font("Raleway", Font.BOLD, 18));
            textAdh.setBounds(400, 420, 320, 30);
            backgroundPanel.add(textAdh);

            JLabel l11 = new JLabel("Senior Citizens:");
            l11.setFont(new Font("Raleway", Font.BOLD, 18));
            l11.setBounds(200, 470, 150, 30);
            backgroundPanel.add(l11);

            r1 = new JRadioButton("YES");
            r1.setFont(new Font("Raleway", Font.BOLD, 18));
            r1.setBackground(new Color(144, 213, 255));
            r1.setBounds(400, 470, 90, 30);
            backgroundPanel.add(r1);

            r2 = new JRadioButton("NO");
            r2.setFont(new Font("Raleway", Font.BOLD, 18));
            r2.setBackground(new Color(144, 213, 255));
            r2.setBounds(550, 470, 90, 30);
            backgroundPanel.add(r2);

            ButtonGroup seniorCitizensGroup = new ButtonGroup();
            seniorCitizensGroup.add(r1);
            seniorCitizensGroup.add(r2);

            JLabel l12 = new JLabel("Existing Account:");
            l12.setFont(new Font("Raleway", Font.BOLD, 18));
            l12.setBounds(200, 520, 300, 30);
            backgroundPanel.add(l12);

            r3 = new JRadioButton("YES");
            r3.setFont(new Font("Raleway", Font.BOLD, 18));
            r3.setBackground(new Color(144, 213, 255));
            r3.setBounds(400, 520, 90, 30);
            backgroundPanel.add(r3);

            r4 = new JRadioButton("NO");
            r4.setFont(new Font("Raleway", Font.BOLD, 18));
            r4.setBackground(new Color(144, 213, 255));
            r4.setBounds(550, 520, 90, 30);
            backgroundPanel.add(r4);

            ButtonGroup existingAccountGroup = new ButtonGroup();
            existingAccountGroup.add(r3);
            existingAccountGroup.add(r4);

            JLabel l13 = new JLabel("Form No:");
            l13.setFont(new Font("Raleway", Font.BOLD, 18));
            l13.setBounds(650, 10, 100, 30);
            backgroundPanel.add(l13);

            // Uncomment and set form number if applicable
            JLabel l14 = new JLabel(formno);
            l14.setFont(new Font("Raleway", Font.BOLD, 18));
            l14.setBounds(760, 10, 100, 30);
            backgroundPanel.add(l14);
            next = new JButton("Next");
            next.setFont(new Font("Raleway", Font.BOLD, 18));
            next.setBackground(Color.WHITE);
            next.setForeground(Color.BLACK);
            next.setBounds(600, 640, 100, 30);
            next.addActionListener(this);
            backgroundPanel.add(next);

            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception exp) {
            System.err.println("Error initializing the frame: " + exp.getMessage());
            exp.printStackTrace();
        }
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == next) {
        // Retrieve form data
        String religion = (String) box.getSelectedItem();
        String category = (String) box2.getSelectedItem();
        String income = (String) box3.getSelectedItem();
        String educational = (String) box4.getSelectedItem();
        String occupation = (String) box5.getSelectedItem();
        String panNumber = textPan.getText();
        String aadhaarNumber = textAdh.getText();

        // Handle Senior Citizen selection
        boolean isSeniorCitizen = r1.isSelected(); // If "YES" is selected
        boolean isSeniorCitizenSelected = r2.isSelected(); // If "NO" is selected
        boolean isSeniorCitizenValue = isSeniorCitizen || (!isSeniorCitizen && !isSeniorCitizenSelected);

        // Handle Existing Account selection
        boolean hasExistingAccount = r3.isSelected(); // If "YES" is selected
        boolean hasExistingAccountSelected = r4.isSelected(); // If "NO" is selected
        boolean hasExistingAccountValue = hasExistingAccount || (!hasExistingAccount && !hasExistingAccountSelected);

        try {
            if (religion.equals("Select") || category.equals("Select") || income.equals("Select")
                || educational.equals("Select") || occupation.equals("Select") || panNumber.isEmpty()
                || aadhaarNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return; // Stop execution if validation fails{
                   
                } else {
                    Connn connection = new Connn();
                    String query= "INSERT INTO `addtional`(`formno`,`religion`, `category`, `income`, `educational`, `occupation`, `pannumber`, `aadharnumber`, `Seniorcitizen`, `existingaccount`) VALUES ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+educational+"','"+occupation+"','"+panNumber+"','"+aadhaarNumber+"','"+isSeniorCitizenValue+"','"+hasExistingAccountValue+"')";
    
                    connection.statement.executeUpdate(query);
                    
                    new Signup3(formno);
                    setVisible(false);
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }
        }

        
    public static void main(String[] args) {
         new Signup2("");
    }
}
