import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    String pin;
    Pin(String pin){
        this.pin =pin;


        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(40,40,400,35);
        add(label1);


        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(40,70,150,35);
        add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65,125,128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(190,70,180,25);
        p1.setFont(new Font("Raleway", Font.BOLD,22));
        add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(40,100,400,35);
        add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65,125,128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(190,100,180,25);
        p2.setFont(new Font("Raleway", Font.BOLD,22));
        add(p2);



        b1 = new JButton("CHANGE");
        b1.setBounds(200,200,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(200,250,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        setSize(500,400);
        getContentPane().setBackground(new Color(200, 191, 231));
        setLayout(null);
        setLocation(350,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String pin1 = this.p1.getText();
            String pin2 = this.p2.getText();
            if (!pin1.equals(pin2)) {
               JOptionPane.showMessageDialog((Component)null, "Entered PIN does not match");
               return;
            }
   
            if (e.getSource() == this.b1) {
               if (this.p1.getText().equals("")) {
                  JOptionPane.showMessageDialog((Component)null, "Enter New PIN");
                  return;
               }
   
               if (this.p2.getText().equals("")) {
                  JOptionPane.showMessageDialog((Component)null, "Re-Enter New PIN");
                  return;
               }
   
               Connn c = new Connn();
               String q1 = "update deposit set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
               String q2 = "update login set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
               String q3 = "update accountdetails set pin = '" + pin1 + "' where pin = '" + this.pin + "'";
               c.statement.executeUpdate(q1);
               c.statement.executeUpdate(q2);
               c.statement.executeUpdate(q3);
               JOptionPane.showMessageDialog((Component)null, "PIN changed successfully");
               this.setVisible(false);
               new Main(this.pin);
            } else if (e.getSource() == this.b2) {
               new Main(this.pin);
               this.setVisible(false);
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }
   
      }

    public static void main(String[] args) {
        new Pin("");
    }
}