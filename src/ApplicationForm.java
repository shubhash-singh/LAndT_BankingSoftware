import java.awt.*;
import javax.swing.*;

class ApplicationForm extends JFrame{

    private JLabel bankName;
    private JLabel name, Mobile, Email, AccType, InitialDeposite;
    private JTextField nameInput, MobileInput, EmailInput, InitialDepositeInput;
    private JRadioButton male, female;

    ApplicationForm()
    {
        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);


        name = new JLabel("Name: ");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.PLAIN, 28));
        name.setBounds(580, 150, 200, 30);
        add(name);

        nameInput = new JTextField();
        nameInput.setBounds(665, 150, 325, 30);
        add(nameInput);

        Mobile = new JLabel("Mobile No.: ");
        Mobile.setForeground(Color.WHITE);
        Mobile.setFont(new Font("Arial", Font.PLAIN, 28));
        Mobile.setBounds(521, 200, 200, 30);
        add(Mobile);

        MobileInput = new JTextField();
        MobileInput.setBounds(665, 200, 325, 30);
        add(MobileInput);

        Email = new JLabel("Email: ");
        Email.setForeground(Color.WHITE);
        Email.setFont(new Font("Arial", Font.PLAIN, 28));
        Email.setBounds(584, 250, 200, 30);
        add(Email);

        EmailInput = new JTextField();
        EmailInput.setBounds(665, 250 ,325, 30);
        add(EmailInput);

        AccType = new JLabel("Account Type: ");
        AccType.setForeground(Color.WHITE);
        AccType.setFont(new Font("Arial", Font.PLAIN, 28));
        AccType.setBounds(483, 300, 200, 30);
        add(AccType);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        add(male);
        add(female);


        InitialDeposite = new JLabel("Initial Deposite: ");
        InitialDeposite.setForeground(Color.WHITE);
        InitialDeposite.setFont(new Font("Arial", Font.PLAIN, 28));
        InitialDeposite.setBounds(470, 350, 200, 30);
        add(InitialDeposite);

        InitialDepositeInput = new JTextField();
        InitialDepositeInput.setBounds(665, 350, 325, 30);
        add(InitialDepositeInput);

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
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ApplicationForm();
    }
    
}
