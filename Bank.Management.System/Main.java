import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class Main  extends JFrame implements ActionListener{
    String pin;
    JButton b1 , b2 ,b3 , b4 , b5 , b6 , b7;
    Main(String pin){
        this.pin = pin;

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setFont(new Font("System",Font.BOLD,25));
        label.setBounds(200, 40, 400, 35);
        add(label);

        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 150, 200, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 250, 200, 30);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("FAST CASH");
        b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(150, 350, 200, 30);
        b3.addActionListener(this);
        add(b3);


        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("Raleway",Font.BOLD,16));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(400, 150, 200, 30);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setFont(new Font("Raleway",Font.BOLD,16));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(400, 250, 200, 30);
        b5.addActionListener(this);
        add(b5);

        
        b6 = new JButton("BALANCE ENQUIRY");
        b6.setFont(new Font("Raleway",Font.BOLD,16));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(400, 350, 200, 30);
        b6.addActionListener(this);
        add(b6);

         b7 = new JButton("EXIT");
        b7.setFont(new Font("Raleway",Font.BOLD,16));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(600,400, 200, 30);
        b7.addActionListener(this);
        add(b7);




        setSize(850, 800);
        setLayout(null);
        getContentPane().setBackground(new Color(200, 191, 231));
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        }else if(e.getSource()==b7){
            System.exit(0);
        }else if(e.getSource()==b2){
            new Withdrawal(pin);
            setVisible(false);
        } else if (e.getSource()==b6) {
            new BalanceEnquriy(pin);
            setVisible(false);
        } else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource()==b4) {
            new Mini(pin);
        }
    }

public static void main(String[] args){
        new Main(" ");
}
}
