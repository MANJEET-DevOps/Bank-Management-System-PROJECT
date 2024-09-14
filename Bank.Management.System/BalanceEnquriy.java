import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton b1;
    BalanceEnquriy(String pin){
        this.pin =pin;

        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(100,70,700,35);
        add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(100,100,400,35);
        add(label2);

        b1 = new JButton("Back");
        b1.setBounds(200,200,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        int balance =0;
        try{
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM `deposit` WHERE `pin` = '"+pin+"'");
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(400,400);
        getContentPane().setBackground(new Color(200, 191, 231));
        setLocation(200,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Main(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}