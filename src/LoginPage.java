import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPage extends JFrame implements ActionListener{
    private JLabel bankName, alertMsg;
    private JButton logIn;
    private JButton signUp;
    private JLabel accountNo, password;
    private JTextField accountNoInput;
    private JPasswordField passwordInput;
    private String Login_Username, LoginPassword;

    LoginPage() 
    {
        // super("Banking Software");

        
        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);


        accountNo = new JLabel("Email Id: ");
        accountNo.setForeground(Color.WHITE);
        accountNo.setFont(new Font("Arial", Font.PLAIN, 28));
        accountNo.setBounds(540, 150, 200, 30);
        add(accountNo);


        accountNoInput = new JTextField(16);
        accountNoInput.setBounds(660, 150, 325, 30);
        add(accountNoInput);

        password = new JLabel("Password:");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.PLAIN, 28));
        password.setBounds(522, 200, 200, 30);
        add(password);


        passwordInput = new JPasswordField(24);
        passwordInput.setBounds(660, 200, 325, 30);
        add(passwordInput);


        alertMsg = new JLabel(" ");
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
        setSize(1000, 650);
        setLocation(380, 150);
        setUndecorated(true);
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
                
            }

            else if (ae.getSource() == logIn)
            {
                String id = accountNoInput.getText().toString();
                String Password = passwordInput.getPassword().toString();
                LoginPassword = Password;
                Login_Username = id;

                if(id.isEmpty() || Password.isBlank() ) {
                    alertMsg.setText("Password");
                }
                else {
                    alertMsg.setText("UserName");
                }
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUsername()
    {
        return Login_Username;
    }
    public String getPassword(){
        return LoginPassword;
    }


}