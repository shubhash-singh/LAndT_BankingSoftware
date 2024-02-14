import java.io.*;
import javax.swing.*;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage extends JFrame implements ActionListener{
    private JLabel bankName, alertMsg, bankAddress;
    private JButton logIn;
    private JButton signUp;
    private JLabel accountNo, password;
    private JTextField accountNoInput;
    private JPasswordField passwordInput;

    LoginPage() 
    {
        // super("Banking Software");

        
        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);

        bankAddress = new JLabel("Chittoor, Andra Pradesh, 517-127, India");
        bankAddress.setForeground(Color.LIGHT_GRAY);
        bankAddress.setFont(new Font("Monotype Corsiva", Font.PLAIN, 20));
        bankAddress.setBounds(320, 85, 1000, 50);
        add(bankAddress);


        accountNo = new JLabel("Email Id: ");
        accountNo.setForeground(Color.WHITE);
        accountNo.setFont(new Font("Arial", Font.PLAIN, 28));
        accountNo.setBounds(540, 150, 200, 30);
        add(accountNo);


        accountNoInput = new JTextField(16);
        accountNoInput.setBounds(660, 150, 325, 30);
        accountNoInput.setFont(new Font("Arial", Font.PLAIN, 20));
        add(accountNoInput);

        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.PLAIN, 28));
        password.setBounds(522, 200, 200, 30);
        add(password);


        passwordInput = new JPasswordField(24);
        passwordInput.setBounds(660, 200, 325, 30);
        passwordInput.setFont(new Font("Arial", Font.PLAIN, 20));
        add(passwordInput);


        alertMsg = new JLabel("");
        alertMsg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
        alertMsg.setForeground(Color.RED);
        alertMsg.setBounds(650, 250, 300, 30);
        add(alertMsg);

        logIn = new JButton("Log In");
        logIn.setForeground(Color.WHITE);
        logIn.setBackground(Color.RED);
        logIn.setBorder(null);
        logIn.addActionListener(this);
        logIn.setBounds(690, 330, 100, 40);
        add(logIn);


        signUp = new JButton("Create New Account");
        signUp.setForeground(Color.WHITE);
        signUp.setBackground(Color.RED);
        signUp.setBorder(null);
        signUp.setBounds(640, 400, 200, 40);
        signUp.addActionListener(this);
        add(signUp);


        // Setting up the background Image
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
    @Override
    public  void actionPerformed(ActionEvent ae)
    {
        try {
            
            if(ae.getSource() == signUp)
            {
                new ApplicationForm();
                dispose(); // This line closes the login page 
                
            }

            else if (ae.getSource() == logIn)
            {
                String id = accountNoInput.getText().toString().toLowerCase();
                char[] passwordChars = passwordInput.getPassword();
                String Password = String.valueOf(passwordChars);
                

                if(id.isBlank() || Password.isBlank() ) {
                    alertMsg.setText("Email or Username can't be Empty");

                }
                else {
                    LoginConfirmation(id,Password);
                }
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void LoginConfirmation(String Id, String Password){

        XSSFWorkbook workbk;
        XSSFSheet sheet;
        File excelFile = new File("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/UserDetail.xlsx");
        String EmailId, password;


        try{
            FileInputStream excel = new FileInputStream(excelFile);
            workbk = new XSSFWorkbook(excel);
            sheet = workbk.getSheet("Sheet1");
            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                EmailId = sheet.getRow(i).getCell(3).toString();
                password = sheet.getRow(i).getCell(4).toString();
    
                if (EmailId.equalsIgnoreCase(Id) && password.equals(Password)) {
                    String Name = sheet.getRow(i).getCell(0).toString();
                    String accNumber = sheet.getRow(i).getCell(1).toString();
                    String MobileNo = sheet.getRow(i).getCell(2).toString();
                    String emailId = sheet.getRow(i).getCell(3).toString();
                    String accType = sheet.getRow(i).getCell(5).toString();
                    String balance = sheet.getRow(i).getCell(6).toString();
                    String lastTrans = sheet.getRow(i).getCell(8).toString();
                    String lastTrnasTime = sheet.getRow(i).getCell(9).toString();
                    String lastTransDetails = sheet.getRow(i).getCell(10).toString();

                    

                    int rowNumber = i;
                    new AccountDetail(Name, accNumber, MobileNo, emailId, accType, balance, lastTrans, lastTrnasTime,lastTransDetails, rowNumber);
                    workbk.close();
                    dispose();
                    
                    break;
                }
                else if(EmailId.equals(Id) && !password.equals(Password)){
                    alertMsg.setText("Incorrect Password");
                }
                else {
                    alertMsg.setText("Account not found Create new Account");
                }
            }
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        new LoginPage();
    }

}