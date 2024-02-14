import java.awt.*;
import java.awt.event.*;
// import java.util.ArrayList;

import javax.swing.*;

public class AccountDetail extends JFrame implements ActionListener{

    private JLabel bankName, bankAddress;
    private JLabel UserName, Account_No, Mobile_No, Email, Account_Balance, AccountType, LastTransTO;
    private JLabel name_, email_, mobileNo_, accountNo_, accountBal_, accType_, lastTrans_, lastTransTime_;
    private JButton logout, transferMoney;
    String accNumber,balance;
    int rowNum;

    AccountDetail(String Name, String accNumber, String MobileNo, String emailId, String accType, String balance, String lastTrans, String lastTransTime, String lastTransDetails, int rowNum) {
        this.accNumber = accNumber;
        this.balance = balance;
        this.rowNum = rowNum;

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
        UserName.setBounds(450, 150, 100, 30);
        add(UserName);

        name_ = new JLabel(Name);
        name_.setForeground(Color.RED);
        name_.setFont(new Font("Arial", Font.ITALIC, 23));
        name_.setBounds(520, 150, 500, 30);
        add(name_);


        Email = new JLabel("Email: ");
        Email.setForeground(Color.WHITE);
        Email.setFont(new Font("Arial", Font.PLAIN, 23));
        Email.setBounds(450, 190, 100, 30);
        add(Email);

        email_ = new JLabel(emailId);
        email_.setForeground(Color.RED);
        email_.setFont(new Font("Arial", Font.ITALIC, 23));
        email_.setBounds(519, 190, 500, 30);
        add(email_);

        Mobile_No = new JLabel("Mobile Number: ");
        Mobile_No.setForeground(Color.WHITE);
        Mobile_No.setFont(new Font("Arial", Font.PLAIN, 23));
        Mobile_No.setBounds(450, 230, 200, 30);
        add(Mobile_No);
        
        mobileNo_ = new JLabel(MobileNo);
        mobileNo_.setForeground(Color.RED);
        mobileNo_.setFont(new Font("Arial", Font.ITALIC, 23));
        mobileNo_.setBounds(612, 230, 500, 30);
        add(mobileNo_);


        Account_No = new JLabel("Account Number: ");
        Account_No.setForeground(Color.WHITE);
        Account_No.setFont(new Font("Arial", Font.PLAIN, 23));
        Account_No.setBounds(450, 270, 200, 30);
        add(Account_No);

        accountNo_ = new JLabel(accNumber);
        accountNo_.setForeground(Color.RED);
        accountNo_.setFont(new Font("Arial", Font.ITALIC, 23));
        accountNo_.setBounds(625, 270, 500, 30);
        add(accountNo_);


        Account_Balance = new JLabel("Balance: ");
        Account_Balance.setForeground(Color.WHITE);
        Account_Balance.setFont(new Font("Arial", Font.PLAIN, 23));
        Account_Balance.setBounds(450, 310, 200, 30);
        add(Account_Balance);


        accountBal_ = new JLabel(balance);
        accountBal_.setForeground(Color.RED);
        accountBal_.setFont(new Font("Arial", Font.ITALIC, 23));
        accountBal_.setBounds(540, 310, 500, 30);
        add(accountBal_);



        AccountType = new JLabel("Account Type: ");
        AccountType.setForeground(Color.WHITE);
        AccountType.setFont(new Font("Arial", Font.PLAIN, 23));
        AccountType.setBounds(450, 350, 200, 30);
        add(AccountType);

        accType_ = new JLabel(accType);
        accType_.setForeground(Color.RED);
        accType_.setFont(new Font("Arial", Font.ITALIC, 23));
        accType_.setBounds(597, 350, 500, 30);
        add(accType_);


        LastTransTO = new JLabel("Last Transaction: ");
        LastTransTO.setForeground(Color.WHITE);
        LastTransTO.setFont(new Font("Arial", Font.PLAIN, 23));
        LastTransTO.setBounds(450, 390, 200, 30);
        add(LastTransTO);




        lastTrans_ = new JLabel(lastTransDetails);
        lastTrans_.setForeground(Color.RED);
        lastTrans_.setFont(new Font("Arial", Font.ITALIC, 23));
        lastTrans_.setBounds(630, 390, 300, 30);
        add(lastTrans_);
         
        
        lastTransTime_ = new JLabel(lastTransTime);
        lastTransTime_.setForeground(Color.RED);
        lastTransTime_.setFont(new Font("Arial", Font.ITALIC, 23));
        lastTransTime_.setBounds(630, 400, 500, 50);
        add(lastTransTime_);

        logout = new JButton("Logout");
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.RED);
        logout.setBorder(null);
        logout.addActionListener(this);
        logout.setBounds(600, 550, 100, 40);
        add(logout);


        transferMoney = new JButton();
        transferMoney = new JButton("Pay");
        transferMoney.setForeground(Color.WHITE);
        transferMoney.setBackground(Color.red);
        transferMoney.setBorder(null);
        transferMoney.addActionListener(this);
        transferMoney.setBounds(610, 480, 80, 40);
        add(transferMoney);


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
    public void actionPerformed(ActionEvent ae){

        try {
            
            if(ae.getSource() == logout) {
                new LoginPage();
                dispose();

            }
            else if(ae.getSource() == transferMoney) {
                new TransactionSection(accNumber, balance, rowNum);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
}