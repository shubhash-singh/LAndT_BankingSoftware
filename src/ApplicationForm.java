import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class ApplicationForm extends JFrame implements ActionListener{

    private JLabel bankName;
    private JLabel name, Mobile, Email, AccType, InitialDeposite, WarningMsg;
    private JTextField nameInput, MobileInput, EmailInput, InitialDepositeInput;
    private JRadioButton current, saving;
    private JButton Submit, clear;

    ApplicationForm()
    {
        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);

        
        // Name Entry Sections
        name = new JLabel("Name: ");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.PLAIN, 28));
        name.setBounds(580, 150, 200, 30);
        add(name);

        nameInput = new JTextField();
        nameInput.setBounds(665, 150, 325, 30);
        add(nameInput);


        // Mobile NUmber Entry Section
        Mobile = new JLabel("Mobile No.: ");
        Mobile.setForeground(Color.WHITE);
        Mobile.setFont(new Font("Arial", Font.PLAIN, 28));
        Mobile.setBounds(521, 200, 200, 30);
        add(Mobile);

        MobileInput = new JTextField();
        MobileInput.setBounds(665, 200, 325, 30);
        add(MobileInput);


        // Email Entry Section
        Email = new JLabel("Email: ");
        Email.setForeground(Color.WHITE);
        Email.setFont(new Font("Arial", Font.PLAIN, 28));
        Email.setBounds(584, 250, 200, 30);
        add(Email);

        EmailInput = new JTextField();
        EmailInput.setBounds(665, 250 ,325, 30);
        add(EmailInput);


        // Account Type selection section
        AccType = new JLabel("Account Type: ");
        AccType.setForeground(Color.WHITE);
        AccType.setFont(new Font("Arial", Font.PLAIN, 28));
        AccType.setBounds(483, 300, 200, 30);
        add(AccType);
        // RadioButton to select Account Type
        current = new JRadioButton("Current");
        saving = new JRadioButton("Saving");
        current.setForeground(Color.BLACK);
        saving.setForeground(Color.BLACK);
        current.setFont(new Font("Arial", Font.PLAIN, 28));
        saving.setFont(new Font("Arial",Font.PLAIN, 28 ));
        current.setBounds(665, 300, 150, 30);
        saving.setBounds(820, 300, 150, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(current);
        genderGroup.add(saving);
        add(current);
        add(saving);


        // Initial Deposite section 
        InitialDeposite = new JLabel("Initial Deposite: ");
        InitialDeposite.setForeground(Color.WHITE);
        InitialDeposite.setFont(new Font("Arial", Font.PLAIN, 28));
        InitialDeposite.setBounds(470, 350, 200, 30);
        add(InitialDeposite);

        InitialDepositeInput = new JTextField();
        InitialDepositeInput.setBounds(665, 350, 325, 30);
        add(InitialDepositeInput);

        // Button to submit all the data to open a new Bank account
        Submit = new JButton("Submit");
        Submit.setForeground(Color.WHITE);
        Submit.setBackground(Color.RED);
        Submit.setBorder(null);
        Submit.setBounds(550, 450, 150, 40);
        Submit.addActionListener(this); 
        add(Submit);

        // Button to clear all the fields
        clear = new JButton("Clear All");
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.RED);
        clear.setBorder(null);
        clear.setBounds(720, 450, 150, 40);
        clear.addActionListener(this); 
        add(clear);

        // Warning Message
        WarningMsg = new JLabel();
        WarningMsg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
        WarningMsg.setForeground(Color.RED);
        WarningMsg.setBounds(600, 400, 500, 30);
        add(WarningMsg);

        // Setting up the background Image
        ImageIcon backgroundImage = new ImageIcon("//media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/Images/Login_BackGround2.jpg");
        Image background = backgroundImage.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        ImageIcon backgrouIcon2 =new ImageIcon(background);
        JLabel imagBack = new JLabel(backgrouIcon2);
        imagBack.setBounds(0, 0, 1000, 650);
        add(imagBack);


        setLayout(null);
        setSize(1000, 650);
        setLocation(380, 150);
        // setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            if(ae.getSource() == Submit) {
                String Name = nameInput.getText().toString();
                String Mobile_No = MobileInput.getText().toString();
                String Email_Id = EmailInput.getText().toString();
                String Initial_Deposite =InitialDepositeInput.getText().toString();
                nameInput.setText("");
                MobileInput .setText(""); 
                EmailInput.setText("");
                InitialDepositeInput.setText("");
                WarningMsg.setText("");


                if(Name.isBlank() || Mobile_No.isBlank() || Email_Id.isBlank() || Initial_Deposite.isBlank() ) {
                    WarningMsg.setText("None of the fields should be empty");
                }
                else if(Integer.parseInt(Initial_Deposite) < 1000 ) {
                    WarningMsg.setText("Initial deposite must be greater than 1000");
                }
            }
            else if (ae.getSource() == clear) {
                nameInput.setText("");
                MobileInput .setText(""); 
                EmailInput.setText("");
                InitialDepositeInput.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ApplicationForm();
    }
}