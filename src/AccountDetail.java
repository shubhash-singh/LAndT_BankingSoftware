import java.awt.*;

import javax.swing.*;

public class AccountDetail extends JFrame{
    private JLabel bankName;
    // private JLabel UserName, Account_No, Mobile_No, Email, Account_Balance, LastTransTO, LastTransTimeDate;
    AccountDetail() {

        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);

        ImageIcon backgroundImage = new ImageIcon("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/Images/Login_BackGround2.jpg");
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
