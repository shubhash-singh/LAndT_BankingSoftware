import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class AccountDetail extends JFrame{
    private JLabel bankName, bankAddress;
    private JLabel UserName, Account_No, Mobile_No, Email, Account_Balance, LastTransTO, LastTransTimeDate;
    private JLabel Name;
    AccountDetail() {

        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)


        add(bankName);
        bankAddress = new JLabel("Chittoor, Andra Pradesh, 517-127, India");
        bankAddress.setForeground(Color.WHITE);
        bankAddress.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
        bankAddress.setBounds(320, 85, 1000, 50);
        add(bankAddress);

        UserName = new JLabel("Name: ");
        UserName.setForeground(Color.WHITE);
        UserName.setFont(new Font("Arial", Font.PLAIN, 23));
        UserName.setBounds(50, 120, 100, 30);
        add(UserName);

        Name = new JLabel("Shubhash Singh");
        Name.setForeground(Color.RED);
        Name.setFont(new Font("Arial", Font.ITALIC, 23));
        Name.setBounds(150, 120, 400, 30);
        add(Name);

        Account_No = new JLabel("Account Number: ");
        Account_No.setForeground(Color.WHITE);
        Account_No.setFont(new Font("Arial", Font.PLAIN, 23));
        Account_No.setBounds(50, 150, 100, 30);
        add(Account_No);

        Email = new JLabel("Email: ");
        Email.setForeground(Color.WHITE);
        Email.setFont(new Font("Arial", Font.PLAIN, 23));
        Email.setBounds(50, 180, 100, 30);
        add(Email);

        Mobile_No = new JLabel();
        Mobile_No.setForeground(Color.WHITE);
        Mobile_No.setFont(new Font("Arial", Font.PLAIN, 23));
        

        ImageIcon backgroundImage = new ImageIcon("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/Images/Login_BackGround2.jpg");
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
    private ArrayList<String> getDetails(String usrename, String Password)
    {   
        ArrayList<String> userDetail = new ArrayList<>();
        
        return userDetail;
    }
    public static void main(String[] args) {
        new AccountDetail();
    }
}
