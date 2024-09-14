import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton s, c;
    String formno;

    Signup3(String formno) {
        super("Account Details");
        
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\Administrator\\Desktop\\Bank.Management.System\\icon\\backbg - Copy.png");
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0,0,850,800);
        add(backgroundPanel);
        this.formno = formno;


        JLabel l1 = new JLabel("ACCOUNT DETAILS");
        l1.setBounds(300, 30, 680, 40);
        l1.setFont(new Font("Ralway", Font.BOLD, 30));
        backgroundPanel.add(l1);

        JLabel l2 = new JLabel("Page 3:");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(300, 60, 600, 40);
        backgroundPanel.add(l2);

        JLabel l3 = new JLabel("Account Type:");
        l3.setBounds(100, 100, 200, 40);
        l3.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(44, 117, 152));
        r1.setBounds(100, 150, 300, 30);
        backgroundPanel.add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(44, 117, 152));
        r2.setBounds(100, 200, 300, 30);
        backgroundPanel.add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(44, 117, 152));
        r3.setBounds(400, 150, 300, 30);
        backgroundPanel.add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(new Color(44, 117, 152));
        r4.setBounds(400, 200, 300, 30);
        backgroundPanel.add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number:");
        l4.setBounds(100, 240, 200, 40);
        l4.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l4);

        JLabel l5 = new JLabel("[YOUR 16 DIGITS CARD NUMBER]");
        l5.setBounds(100, 260, 200, 40);
        l5.setFont(new Font("Ralway", Font.BOLD, 12));
        backgroundPanel.add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setBounds(350, 240, 250, 40);
        l6.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l6);

        JLabel l7 = new JLabel("Pin Number:");
        l7.setBounds(100, 300, 200, 40);
        l7.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l7);

        JLabel l8 = new JLabel("[YOUR 4 DIGITS PIN NUMBER]");
        l8.setBounds(100, 340, 200, 12);
        l8.setFont(new Font("Ralway", Font.BOLD, 12));
        backgroundPanel.add(l8);

        JLabel value = new JLabel("XXXX");
        value.setFont(new Font("Raleway", Font.BOLD, 18));
        value.setBounds(350, 300, 250, 30);
        backgroundPanel.add(value);

        JLabel l10 = new JLabel("Service Required:");
        l10.setBounds(100, 370, 200, 40);
        l10.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l10);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(44, 117, 152));
        c1.setBounds(100, 400, 200, 40);
        c1.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setBackground(new Color(44, 117, 152));
        c2.setBounds(100, 450, 200, 40);
        c2.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setBackground(new Color(44, 117, 152));
        c3.setBounds(100, 500, 200, 40);
        c3.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c3);

        c4 = new JCheckBox("EMAIL ALERT");
        c4.setBackground(new Color(44, 117, 152));
        c4.setBounds(300, 400, 200, 40);
        c4.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setBackground(new Color(44, 117, 152));
        c5.setBounds(300, 450, 200, 40);
        c5.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setBackground(new Color(44, 117, 152));
        c6.setBounds(300, 500, 200, 40);
        c6.setFont(new Font("Ralway", Font.BOLD, 13));
        backgroundPanel.add(c6);

        JCheckBox c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        c7.setBackground(new Color(44, 117, 152));
        c7.setBounds(100, 550, 650, 40);
        c7.setFont(new Font("Ralway", Font.BOLD, 15));
        backgroundPanel.add(c7);

        JLabel l11 = new JLabel("Form no. :");
        l11.setBounds(690, 10, 200, 40);
        l11.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l11);

        JLabel l12 = new JLabel(formno);
        l12.setBounds(770, 10, 200, 40);
        l12.setFont(new Font("Ralway", Font.BOLD, 18));
        backgroundPanel.add(l12);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 18));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250, 640, 100, 30);
        s.addActionListener(this);
        backgroundPanel.add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD, 18));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(450, 640, 100, 30);
        c.addActionListener(this);
        backgroundPanel.add(c);

        setSize(850, 800);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (this.r1.isSelected()) {
            atype = "Saving Account";
        } else if (this.r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (this.r3.isSelected()) {
            atype = "Current Account";
        } else if (this.r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }
        Random ran = new Random();
        long first7 = ran.nextLong() % 90000000L + 1409963000000000L;
        String cardno = "" + Math.abs(first7);
        long first3 = ran.nextLong() % 9000L + 1000L;
        String pin = "" + Math.abs(first3);
        String fac = "";
        if (this.c1.isSelected()) {
            fac = fac + "ATM CARD ";
        } else if (this.c2.isSelected()) {
            fac = fac + "INTERNET BANKING";
        } else if (this.c3.isSelected()) {
            fac = fac + "Mobile Banking";
        } else if (this.c4.isSelected()) {
            fac = fac + "EMAIL ALERT";
        } else if (this.c5.isSelected()) {
            fac = fac + "CHEQUE BOOK";
        } else if (this.c6.isSelected()) {
            fac = fac + "E-STATEMENT";
        }

        try {
            if (e.getSource() == this.s) {
                if (atype.equals(" ")) {
                    JOptionPane.showMessageDialog((Component)null, "Fill all the fields");
                } else {
                    Connn connection = new Connn();
                    String q1 = "INSERT INTO `accountdetails`( `formno`,`Account_type`, `Card_number`, `Pin`, `Servce_required`) VALUES ( '"+formno+"','" + atype + "','" + cardno + "','" + pin + "','" + fac + "')";
                    String q2 = "INSERT INTO `login`( `card_number`, `pin`) VALUES('" + cardno + "','" + pin + "')";
                    connection.statement.executeUpdate(q1);
                    connection.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog((Component)null, "Card Number : " + cardno + "\n Pin : " + pin);
                    new Deposit(pin);
                    setVisible(false);
                }
            } else if (e.getSource() == this.c) {
                System.exit(0);
            }
        } catch (Exception var14) {
            Exception E = var14;
            E.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Signup3(" ");
    }
}