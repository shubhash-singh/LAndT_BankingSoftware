import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositePage extends JFrame implements ActionListener{

    private JLabel bankName, Amount, password, alertMsg;
    private JTextField amountInput, passwordInput;
    private JButton deposite;
    String Password;
    int rowNum;

    DepositePage(int rowNum, String Password) {
        this.rowNum = rowNum;
        this.Password = Password;



        bankName = new JLabel("Bank of Chittoor");
        bankName.setForeground(Color.RED);
        bankName.setFont(new Font("Monotype Corsiva", Font.ITALIC, 40));
        bankName.setBounds(350, 130, 1000, 60);  //(x, y, width, height)
        add(bankName);

        Amount = new JLabel("Amount: ");
        Amount.setForeground(Color.WHITE);
        Amount.setFont(new Font("Arial", Font.PLAIN, 20));
        Amount.setBounds(280, 210, 200, 30);
        add(Amount);

        amountInput = new JTextField();
        amountInput.setForeground(Color.BLACK);
        amountInput.setFont(new Font("Arial", Font.PLAIN, 18));
        amountInput.setBounds(280, 240, 350, 30);
        add(amountInput);
        
        password = new JLabel("Password: ");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setBounds(280, 270, 200, 30);
        add(password);

        passwordInput = new JTextField();
        passwordInput.setForeground(Color.BLACK);
        passwordInput.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordInput.setBounds(280, 300, 350, 30);
        add(passwordInput);


        alertMsg = new JLabel();
        alertMsg.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
        alertMsg.setForeground(Color.white);
        alertMsg.setBounds(300, 340,450, 30);
        add(alertMsg);


        deposite = new JButton("deposite");
        deposite.setForeground(Color.WHITE);
        deposite.setBackground(Color.red);
        deposite.setBorder(null);
        deposite.addActionListener(this);
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
                String Password_ = passwordInput.getText().toString();
                if (amount.isBlank() || Password_.isBlank()){
                    alertMsg.setText("None of the Fields should be Empty!!");
                }
                else if (this.Password.equals(Password_)) {
                    int Money = Integer.parseInt(amount);
                    performDeposite(Money);
                    amountInput.setText("");
                    passwordInput.setText("");
                } 
                else if (Integer.parseInt(amount) > 100000) {
                    alertMsg.setText("Amount too big !!!");
                }
                else {
                    alertMsg.setText("Invalid Password!!!");
                }
                
            }
        } catch (NumberFormatException nfe){
            alertMsg.setText("Invalid Amount");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void performDeposite(int amount) {

        XSSFWorkbook workbk = null;
        
        XSSFSheet sheet;
        File excelFile = new File("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/UserDetail.xlsx");
        try {


            FileInputStream excel = new FileInputStream(excelFile);
            workbk = new XSSFWorkbook(excel);
            sheet = workbk.getSheet("Sheet1");


            Row row = sheet.getRow(rowNum);

            String time = LocalTime.now().toString();
            String TransDetail = "+"+amount+" Deposite on";
            String timeDate = (LocalDate.now()).toString()+" at "+time.substring(0, 8);

            String newBal = row.getCell(6).toString();
            int newBalance = amount + Integer.parseInt(newBal.substring(0, newBal.length()-2));
            
            row.getCell(6).setCellValue(String.valueOf(newBalance));
            row.getCell(7).setCellValue(String.valueOf(amount));
            row.getCell(8).setCellValue("+"+String.valueOf(amount));
            row.getCell(9).setCellValue(timeDate);
            row.getCell(10).setCellValue(TransDetail);


            try (FileOutputStream fileOut = new FileOutputStream("/media/ragnar/ca023da0-2328-4858-8f08-a69753e22717/Projects/L-T_BankingSoftware/src/Data/UserDetail.xlsx")) {
                workbk.write(fileOut);
                workbk.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing to Excel file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(this, String.valueOf(amount)+" Deposited successfully! \nNew Balance is "+String.valueOf(newBalance), "Deposited", JOptionPane.ERROR_MESSAGE);
            alertMsg.setText(" ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}