import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TransactionSection extends JFrame implements ActionListener{

    private JLabel bankName, accountNo, money_, alertMsg;
    private JTextArea emailId, sendMoney;
    private JButton transferMoney, goBack;
    String accNumber;
    
    TransactionSection(String accNumber) {

        this.accNumber = accNumber;

        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.WHITE);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 55));
        bankName.setBounds(300, 20, 1000, 80);  //(x, y, width, height)
        add(bankName);


        accountNo = new JLabel("Sender Email Id: ");
        accountNo.setForeground(Color.WHITE);
        accountNo.setFont(new Font("Arial", Font.PLAIN, 28));
        accountNo.setBounds(365, 150, 400, 30);
        add(accountNo);


        emailId = new JTextArea();
        emailId.setBounds(580, 150, 390, 30);
        emailId.setForeground(Color.black);
        emailId.setFont(new Font("Arial", Font.PLAIN, 23));
        add(emailId);


        money_ = new JLabel("Money: ");
        money_.setForeground(Color.WHITE);
        money_.setFont(new Font("Arial", Font.PLAIN, 28));
        money_.setBounds(482, 200, 200, 30);
        add(money_);

        sendMoney = new JTextArea();
        sendMoney.setForeground(Color.black);
        sendMoney.setFont(new Font("Arial", Font.PLAIN, 23));
        sendMoney.setBounds(580, 200, 150, 30);
        add(sendMoney);

        alertMsg = new JLabel();
        alertMsg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
        alertMsg.setForeground(Color.RED);
        alertMsg.setBounds(570, 250,250, 30);
        add(alertMsg);

        transferMoney = new JButton();
        transferMoney = new JButton("Pay");
        transferMoney.setForeground(Color.WHITE);
        transferMoney.setBackground(Color.red);
        transferMoney.setBorder(null);
        transferMoney.addActionListener(this);
        transferMoney.setBounds(610, 300, 80, 40);
        add(transferMoney);

        goBack = new JButton("Back");
        goBack.setForeground(Color.WHITE);
        goBack.setBackground(Color.red);
        goBack.setBorder(null);
        goBack.addActionListener(this);
        goBack.setBounds(605, 350, 90, 40);
        add(goBack);


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

    public void actionPerformed(ActionEvent ae) {

        try {
            
            if (ae.getSource() == transferMoney) {
                String userId = emailId.getText().toString();
                int payAmount = Integer.parseInt(sendMoney.getText());
                if (payAmount < 0) {
                    alertMsg.setText("Amount can't be less than 0.");
                }
                else if (payAmount > 100000) {
                    alertMsg.setText("Amount is too big.");
                }
                else {
                    executeTransfer(payAmount, userId);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);    
        }
    }


    public void executeTransfer(int amount, String userId) {


        XSSFWorkbook workbk;
        XSSFSheet sheet;
        File excelFile = new File("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/UserDetail.xlsx");

        try {
            workbk = new XSSFWorkbook(excelFile);
            sheet = workbk.getSheet("Sheet1");

            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                String EmailId = sheet.getRow(i).getCell(3).toString();

                if(userId.equals(EmailId)) {
                    
                    Row row = sheet.getRow(i);
                    Cell amountCell = row.getCell(5);
                    Cell nameCell = row.getCell(1);
                    Cell lastTranferFrom = row.getCell(9);
                    
                    String lastTransTo = String.valueOf(amount)+"to "+nameCell+LocalDate.now().toString() +" on "+ LocalTime.now().toString();

                    for(int j=5;j<sheet.getLastRowNum();j++) {
                        
                    }
                    
                    lastTranferFrom.setCellValue(lastTransTo);
                    amountCell.setCellValue(amount);
                }
                    
            }
            try (FileOutputStream fileOut = new FileOutputStream("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/UserDetail.xlsx")) {
                workbk.write(fileOut);
                workbk.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing to Excel file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}