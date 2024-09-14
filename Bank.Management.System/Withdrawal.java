import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;


public class Withdrawal extends JFrame implements ActionListener{
    TextField textField;
    JButton b1 , b2;
    String pin;
    Withdrawal(String pin){
        this.pin = pin;

        
        JLabel label = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label.setFont(new Font("System",Font.BOLD,18));
        label.setBounds(40, 20, 350, 30);
        add(label);

        JLabel label1 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label1.setFont(new Font("Raleway",Font.BOLD,12));
        label1.setBounds(20, 70, 180, 30);
        add(label1);

        textField = new TextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 18));
        // textField.setBackground(Color.WHITE);
        // textField.setForeground(Color.BLACK);
        textField.setBounds(200, 70, 200, 30);
        add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30, 200, 150, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250, 200, 150, 30);
        b2.addActionListener(this);
        add(b2);



        setSize(450, 400);
        setLocation(350,150);
        setLayout(null);
        getContentPane().setBackground(new Color(158, 224, 193));
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
      try{
        String amount = textField.getText();
        Date date = new Date();
        if(textField.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Withdraw");
        }else{
            Connn c= new Connn();
            ResultSet resultset = c.statement.executeQuery("SELECT * FROM `deposit` WHERE `pin` = '"+pin+"'");
            int balance = 0;
            while (resultset.next()){
                if(resultset.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultset.getString("amount"));
                }else{
                    balance -= Integer.parseInt(resultset.getString("amount"));
                }
            }
            if(balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insuffient Balance");
                return;
            }
            
            c.statement.executeUpdate("INSERT INTO `deposit`( `pin`, `date`, `type`, `amount`) VALUES ('"+pin+"','"+date+"','Withdraw','"+amount+"')");
            JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
            
            
            setVisible(false);
            new Main(pin);
        }

      } catch(Exception E){
        E.printStackTrace();

      } 
        }else if(e.getSource()==b2){
            new Main(pin);
            setVisible(false);
        }
    }


public static void main (String[] args){
    new Withdrawal(" ");
}
}
