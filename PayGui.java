import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class PayGui {

    JFrame payFrame;

    ButtonGroup payMethodButtonGroup;

    JLabel cardNumberLabel;
    JTextField cardNumberTextField;
    JLabel expireDateLabel;
    JTextField expireDateTextField;
    JLabel ccvLabel;
    JTextField ccveTextField;

    JLabel payAmountLabel;
    JTextField payAmountTextField;
    Record newRecord;

    JButton printReceiptButton;
    JButton payButton;
    JButton nextRecordButton;

    String recordFilName;
    WriteRecordFile recordFile;

    public PayGui(Record record) {
        recordFilName = "record.txt";
        this.newRecord = record;
        recordFile = new WriteRecordFile();
    }

    public void display() {
        payFrame = new JFrame("Supermarket Point-of-Sales System");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new exitListener());

        menu.add(exit);
        menuBar.add(menu);
        payFrame.setJMenuBar(menuBar);

        JPanel payPanel = new JPanel();
        payPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Product List"));
        payPanel.setBackground(Color.PINK);
        payPanel.setBounds(3, 300, 630, 250);
        payPanel.setLayout(null);

        JRadioButton creditCardRadioButton = new JRadioButton("Credit Card");
        creditCardRadioButton.setBounds(30, 50, 100, 30);
        payPanel.add(creditCardRadioButton);

        JRadioButton debitCardRadioButton = new JRadioButton("Debit Card");
        debitCardRadioButton.setBounds(30, 80, 100, 30);
        payPanel.add(debitCardRadioButton);

        JRadioButton cashRadioButton = new JRadioButton("Cash");
        cashRadioButton.setBounds(30, 110, 100, 30);
        payPanel.add(cashRadioButton);

        payMethodButtonGroup = new ButtonGroup();
        payMethodButtonGroup.add(creditCardRadioButton);
        payMethodButtonGroup.add(debitCardRadioButton);
        payMethodButtonGroup.add(cashRadioButton);
        creditCardRadioButton.setActionCommand("creditCard");
        debitCardRadioButton.setActionCommand("debitCard");
        cashRadioButton.setActionCommand("cash");

        creditCardRadioButton.addActionListener(new creditCardListsner());
        debitCardRadioButton.addActionListener(new debitCardListener());
        cashRadioButton.addActionListener(new cashListener());

        cardNumberLabel = new JLabel("Card Number");
        cardNumberLabel.setBounds(180, 50, 300, 30);
        cardNumberLabel.setVisible(false);
        payPanel.add(cardNumberLabel);

        cardNumberTextField = new JTextField();
        cardNumberTextField.setBounds(280, 55, 150, 20);
        cardNumberTextField.setVisible(false);
        payPanel.add(cardNumberTextField);

        payAmountLabel = new JLabel("Pay Amount(RM)");
        payAmountLabel.setBounds(180, 50, 300, 30);
        payAmountLabel.setVisible(false);
        payPanel.add(payAmountLabel);

        payAmountTextField = new JTextField();
        payAmountTextField.setBounds(280, 55, 150, 20);
        payAmountTextField.setVisible(false);
        payPanel.add(payAmountTextField);

        expireDateLabel = new JLabel("Expire Date");
        expireDateLabel.setBounds(180, 80, 300, 30);
        expireDateLabel.setVisible(false);
        payPanel.add(expireDateLabel);

        expireDateTextField = new JTextField();
        expireDateTextField.setBounds(280, 85, 150, 20);
        expireDateTextField.setVisible(false);
        payPanel.add(expireDateTextField);

        ccvLabel = new JLabel("CCV");
        ccvLabel.setBounds(180, 110, 300, 30);
        ccvLabel.setVisible(false);
        payPanel.add(ccvLabel);

        ccveTextField = new JTextField();
        ccveTextField.setBounds(280, 115, 150, 20);
        ccveTextField.setVisible(false);
        payPanel.add(ccveTextField);

        payButton = new JButton("Pay");
        payButton.setBounds(150, 215, 150, 25);
        payButton.addActionListener(new payButtonListener());
        payPanel.add(payButton);

        printReceiptButton = new JButton("Print Receipt");
        printReceiptButton.setBounds(150, 215, 150, 25);
        printReceiptButton.addActionListener(new printReceiptListener());
        printReceiptButton.setVisible(false);
        payPanel.add(printReceiptButton);

        nextRecordButton = new JButton("New Record");
        nextRecordButton.setBounds(150, 265, 150, 25);
        nextRecordButton.addActionListener(new nextRecordListener());
        nextRecordButton.setVisible(false);
        payPanel.add(nextRecordButton);

        payFrame.add(payPanel);
        payFrame.setSize(500, 500);
        payFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainFrame.setLayout(null);
        payFrame.setVisible(true);
    }

    class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(payFrame, "Are you want to exit?");
            if (confirmed == JOptionPane.YES_OPTION) {
                payFrame.dispose();
            }
        }
    }

    class creditCardListsner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardNumberLabel.setVisible(true);
            cardNumberTextField.setVisible(true);
            expireDateLabel.setVisible(true);
            expireDateTextField.setVisible(true);
            ccvLabel.setVisible(true);
            ccveTextField.setVisible(true);

            payAmountLabel.setVisible(false);
            payAmountTextField.setVisible(false);
        }
    }

    class debitCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardNumberLabel.setVisible(true);
            cardNumberTextField.setVisible(true);
            expireDateLabel.setVisible(true);
            expireDateTextField.setVisible(true);
            ccvLabel.setVisible(true);
            ccveTextField.setVisible(true);

            payAmountLabel.setVisible(false);
            payAmountTextField.setVisible(false);
        }
    }

    class cashListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardNumberLabel.setVisible(false);
            cardNumberTextField.setVisible(false);
            expireDateLabel.setVisible(false);
            expireDateTextField.setVisible(false);
            ccvLabel.setVisible(false);
            ccveTextField.setVisible(false);

            payAmountLabel.setVisible(true);
            payAmountTextField.setVisible(true);
        }
    }

    class payButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String paymentMethod = payMethodButtonGroup.getSelection().getActionCommand();
                String cardNumber = "";
                String expireDate = "";
                String ccv = "";
                double cash = 0.0;
                if (paymentMethod == "creditCard") {
                    cardNumber = cardNumberTextField.getText();
                    expireDate = expireDateTextField.getText();
                    ccv = ccveTextField.getText();
                    newRecord.setCreditCard(cardNumber, expireDate, ccv);
                }
                if (paymentMethod == "debitCard") {
                    cardNumber = cardNumberTextField.getText();
                    expireDate = expireDateTextField.getText();
                    ccv = ccveTextField.getText();
                    newRecord.setDebitCard(cardNumber, expireDate, ccv, cash);
                }
                if (paymentMethod == "cash") {
                    cash = Double.parseDouble(payAmountTextField.getText());
                    newRecord.setCash(cash);
                }
                newRecord.setPaymentMethod(paymentMethod);

                newRecord.processOrder();
                JOptionPane.showMessageDialog(payFrame, "Successfully add new record");

                recordFile.addRecord(newRecord, recordFilName);

                payButton.setVisible(false);
                printReceiptButton.setVisible(true);
                nextRecordButton.setVisible(true);
            } catch (Exception error) {
                error.printStackTrace();
                System.out.println("Error Data Type");
            }
        }
    }

    class printReceiptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fileName = "receipt.txt";
            WriteReceiptFile receiptFile = new WriteReceiptFile();
            receiptFile.WriteReceipt(newRecord, fileName);
            JOptionPane.showMessageDialog(payFrame, "Successfully Print Receipt");
        }
    }

    class nextRecordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Gui newGui = new Gui();
            newGui.display();
            payFrame.dispose();
        }
    }
}
