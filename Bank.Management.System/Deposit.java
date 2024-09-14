import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;


public class Deposit extends JFrame implements ActionListener{

  
    TextField textField;
    JButton b1,b2;
    String pin;

    Deposit(String pin) {
        this.pin = pin;

        BackgroundPanel backgroundPanel = new BackgroundPanel("C:\\Users\\Administrator\\Desktop\\icon\\atm2.png");
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0,0,850,800);
        add(backgroundPanel);

        JLabel label1 =new JLabel(" ENTER AMOUNT YOU WANT TO DEPOSIT ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setBounds(190,150,500,30);
        backgroundPanel.add(label1);

        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(190, 190, 290, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 20));
        backgroundPanel.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(300, 350, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        backgroundPanel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(300, 390, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        backgroundPanel.add(b2);




        setSize(850, 800);
        setLayout(null);
        setLocation(350,150);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        try {
            
        
        String amount =textField.getText();
        Date date = new Date();
        if(e.getSource()==b1){
            if(textField.getText().equals(" ")){
                JOptionPane.showMessageDialog(null, " Please enter the amount you want to Deposit");
            }else{
                Connn connection = new Connn();
                connection.statement.executeUpdate("INSERT INTO `deposit`( `pin`, `date`, `type`, `amount`) VALUES ('"+pin+"','"+date+"','Deposit','"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+"Deposit Succesfullly");
                setVisible(false);
                new Main(pin);
            }
            }else if(e.getSource()==b2){
              setVisible(false);
              new Main(pin);
            }

       
    } catch(Exception E){
        E.printStackTrace();
    }
}

    public static void main(String[] args) {
        new Deposit(" ");
    }

}

