import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositePage extends JFrame implements ActionListener{

    private JLabel bankName, Amount, password;
    private JTextField amountInput, passwordInput;
    private JButton deposite;
    String Password;
    int rowNum;

    DepositePage() {

        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.RED);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 40));
        bankName.setBounds(350, 130, 1000, 60);  //(x, y, width, height)
        add(bankName);

        Amount = new JLabel("Amount: ");
        Amount.setForeground(Color.WHITE);
        Amount.setFont(new Font("Arial", Font.PLAIN, 20));
        Amount.setBounds(280, 220, 200, 30);
        add(Amount);

        amountInput = new JTextField();
        amountInput.setForeground(Color.BLACK);
        amountInput.setFont(new Font("Arial", Font.PLAIN, 18));
        amountInput.setBounds(280, 250, 350, 30);
        add(amountInput);
        
        password = new JLabel("Password: ");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setBounds(280, 280, 200, 30);
        add(password);

        passwordInput = new JTextField();
        passwordInput.setForeground(Color.BLACK);
        passwordInput.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordInput.setBounds(280, 310, 350, 30);
        add(passwordInput);

        deposite = new JButton("deposite");
        deposite.setForeground(Color.WHITE);
        deposite.setBackground(Color.red);
        deposite.setBorder(null);
        // deposite.addActionListener(this);
        deposite.setBounds(510, 440, 90, 40);
        add(deposite);

        ImageIcon backgroundImage = new ImageIcon("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/Images/atm.png");
        Image background = backgroundImage.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        ImageIcon backgrouIcon2 =new ImageIcon(background);
        JLabel imagBack = new JLabel(backgrouIcon2);
        imagBack.setBounds(0, 0, 1000, 650);
        add(imagBack);

        
        setLayout(null);
        setSize(1010, 650);
        setLocation(380, 150);
        // setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        try{

            if (ae.getSource() == deposite) {
                
                String amount = amountInput.getText().toString();
                String Password = passwordInput.getText().toString();

                if (this.Password.equals(Password)) {
                    int Money = Integer.parseInt(amount);
                    performDeposite(Money);
                }
            }
        }catch(Exception e) {

        }
    }

    public void performDeposite(int amount) {
        

    }
    public static void main(String[] args) {
        new DepositePage();
    }
}
