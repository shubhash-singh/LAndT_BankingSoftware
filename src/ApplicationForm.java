import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ApplicationForm extends JFrame{

    private JLabel bankName;
    private JLabel name, dob, Address, street, city, Zipcode;
    private JTextField nameInput, dobInput, AddressInput, streetInput, cityInput, ZipCodeInput;

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

        dob = new JLabel("Date of Birth: ");
        dob.setForeground(Color.WHITE);
        dob.setFont(new Font("Arial", Font.PLAIN, 28));
        dob.setBounds(500, 200, 200, 30);
        add(dob);

        dobInput = new JTextField();
        dobInput.setBounds(665, 200, 325, 30);
        add(dobInput);

        Address = new JLabel("Address: ");
        Address.setForeground(Color.WHITE);
        Address.setFont(new Font("Arial", Font.PLAIN, 28));
        Address.setBounds(500, 250, 200, 30);
        add(Address);

        AddressInput = new JTextField();
        AddressInput.setBounds(665, 250 ,325, 30);
        add(AddressInput);

        street = new JLabel("Street: ");
        street.setForeground(Color.WHITE);
        street.setFont(new Font("Arial", Font.PLAIN, 28));
        street.setBounds(500, 300, 200, 30);
        add(street);

        streetInput = new JTextField();
        streetInput.setBounds(665, 300, 325, 30);
        add(streetInput);

        city = new JLabel("City: ");
        city.setForeground(Color.WHITE);
        city.setFont(new Font("Arial", Font.PLAIN, 28));
        city.setBounds(500, 350, 200, 30);
        add(city);

        cityInput = new JTextField();
        cityInput.setBounds(665, 350, 325, 30);
        add(cityInput);

        Zipcode = new JLabel("ZipCode: ");
        Zipcode.setForeground(Color.WHITE);
        Zipcode.setFont(new Font("Arial", Font.PLAIN, 28));
        Zipcode.setBounds(500, 400, 200, 30);
        add(Zipcode);

        ZipCodeInput = new JTextField();
        ZipCodeInput.setBounds(665, 400, 325, 30);
        add(ZipCodeInput);

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
}
