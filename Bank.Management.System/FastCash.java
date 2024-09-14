import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin =pin;

        JLabel label = new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setBounds(30,10,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,23));
        add(label);

        b1 = new JButton("Rs. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(40,70,150,35);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Rs. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(40,120,150,35);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Rs. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(40,160,150,35);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("Rs. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(250,70,150,35);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("Rs. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(250,120,150,35);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("Rs. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(250,160,150,35);
        b6.addActionListener(this);
        add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(190,300,150,35);
        b7.addActionListener(this);
        add(b7);

        setLayout(null);
        setSize(450,400);
        getContentPane().setBackground(new Color(200, 191, 231));
        setLocation(350,150);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            setVisible(false);
            new Main(pin);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Connn c = new Connn();
            Date date = new Date();
            try{
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM `deposit` WHERE `pin` = '"+pin+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }

                c.statement.executeUpdate("INSERT INTO `deposit`( `pin`, `date`, `type`, `amount`) VALUES ('"+pin+"','"+date+"','Withdraw','"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Main(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}