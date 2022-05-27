import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class Gui {
    public void display() {
        JFrame mainFrame = new JFrame("Point-of-Sales System");

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setLayout(null);
        titlePanel.setBounds(3, 0, 630, 150);
        titlePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), ""));

        JLabel titleLabel = new JLabel("ABC Supermarket");
        titleLabel.setBounds(250, 20, 500, 30);
        titleLabel.setFont(new Font("Ubuntu", Font.BOLD, 14));
        titlePanel.add(titleLabel);

        JLabel addressLabel = new JLabel("No 100, Jalan ABC, Taman XYZ, 20000, Kuala Lumpuer, Malaysia");
        addressLabel.setBounds(100, 50, 500, 30);
        addressLabel.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        titlePanel.add(addressLabel);

        JLabel dateLabel = new JLabel("Date: 10/10/2022");
        dateLabel.setBounds(250, 70, 500, 30);
        dateLabel.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        titlePanel.add(dateLabel);

        JLabel recordIdLabel = new JLabel("Record ID: A01234");
        recordIdLabel.setBounds(245, 90, 500, 30);
        recordIdLabel.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        titlePanel.add(recordIdLabel);

        mainFrame.add(titlePanel);

        JPanel customerPanel = new JPanel();
        customerPanel.setBackground(Color.GREEN);
        customerPanel.setBounds(3, 150, 630, 150);
        customerPanel.setLayout(null);
        customerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Customer Information"));

        JLabel customerIdLabel = new JLabel("Customer ID");
        customerIdLabel.setBounds(30, 20, 300, 30);
        customerPanel.add(customerIdLabel);

        JTextField customerIdTextField = new JTextField();
        customerIdTextField.setBounds(130, 25, 100, 20);
        customerPanel.add(customerIdTextField);

        JLabel customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setBounds(280, 20, 300, 30);
        customerPanel.add(customerNameLabel);

        JTextField customerNameTextField = new JTextField();
        customerNameTextField.setBounds(400, 25, 150, 20);
        customerPanel.add(customerNameTextField);

        JLabel ageLabel = new JLabel("Customer Age");
        ageLabel.setBounds(30, 50, 300, 30);
        customerPanel.add(ageLabel);

        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(130, 55, 50, 20);
        customerPanel.add(ageTextField);

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(280, 50, 300, 30);
        customerPanel.add(phoneNumberLabel);

        JTextField phoneNumberTextField = new JTextField();
        phoneNumberTextField.setBounds(400, 55, 150, 20);
        customerPanel.add(phoneNumberTextField);

        JLabel customerAddressLabel = new JLabel("Address:");
        customerAddressLabel.setBounds(30, 80, 300, 30);
        customerPanel.add(customerAddressLabel);

        JTextField customerAddressTextField = new JTextField();
        customerAddressTextField.setBounds(130, 85, 420, 20);
        customerPanel.add(customerAddressTextField);

        mainFrame.add(customerPanel);

        JPanel productPanel = new JPanel();
        productPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Product"));
        productPanel.setBackground(Color.YELLOW);
        productPanel.setBounds(3, 300, 630, 250);
        productPanel.setLayout(null);

        JLabel selectProductLabel = new JLabel("Select Product");
        selectProductLabel.setBounds(30, 20, 300, 30);
        productPanel.add(selectProductLabel);

        String productList[] = { "Product1", "Product2", "Product3", "Product4", "Product5" };
        JComboBox<String> productComboBox = new JComboBox<>(productList);
        productComboBox.setBounds(130, 25, 200, 20);
        productPanel.add(productComboBox);

        SpinnerModel value = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner productSpinner = new JSpinner(value);
        productSpinner.setBounds(360, 25, 50, 20);
        productPanel.add(productSpinner);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(460, 25, 150, 20);
        productPanel.add(addProductButton);

        String data[][] = {
                { null, null, null, null, null },
                { null, null, null, null, null },
                { null, null, null, null, null },
                { null, null, null, null, null },
                { null, null, null, null, null },
                { null, null, null, null, null },
        };
        String tableColumns[] = { "Product ID", "Product Name", "Unit Price", "Quantity", "Total" };
        // JTable productTable = new JTable(data,tableColumns);

        JTable productTable = new JTable();
        productTable.setModel(new DefaultTableModel(data, tableColumns) {
            boolean[] columnEditables = new boolean[] {
            false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
            }
        });

        productTable.getColumnModel().getColumn(0).setResizable(false);
        productTable.getColumnModel().getColumn(1).setResizable(false);
        productTable.getColumnModel().getColumn(2).setResizable(false);
        productTable.getColumnModel().getColumn(3).setResizable(false);
        productTable.getColumnModel().getColumn(4).setResizable(false);
        productTable.getTableHeader().setReorderingAllowed(false);

        // productTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        // productTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(0);
        productTable.getColumnModel().getColumn(3).setPreferredWidth(0);
        productTable.getColumnModel().getColumn(4).setPreferredWidth(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        productTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        productTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        JScrollPane productTableScrollPane = new JScrollPane(productTable);

        productTableScrollPane.setBounds(30, 70, 550, 120);
        productPanel.add(productTableScrollPane);

        JLabel totalBeforeTaxLabel = new JLabel("Total Before Tax: RM10.00");
        totalBeforeTaxLabel.setBounds(420, 200, 300, 30);
        productPanel.add(totalBeforeTaxLabel);

        JLabel totalAfterTaxLabel = new JLabel("Total After Tax (6%): RM10.00");
        totalAfterTaxLabel.setBounds(405, 220, 300, 30);
        productPanel.add(totalAfterTaxLabel);

        mainFrame.add(productPanel);

        JPanel payPanel = new JPanel();
        payPanel.setBackground(Color.PINK);
        payPanel.setBounds(3, 550, 630, 220);
        payPanel.setLayout(null);
        payPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Payment"));

        JRadioButton creditCardRadioButton=new JRadioButton("Credit Card");
        creditCardRadioButton.setBounds(30,30,100,30);
        payPanel.add(creditCardRadioButton);

        JRadioButton debitCardRadioButton=new JRadioButton("Debit Card");
        debitCardRadioButton.setBounds(30,60,100,30);
        payPanel.add(debitCardRadioButton);
        
        JRadioButton cashRadioButton=new JRadioButton("Cash");
        cashRadioButton.setBounds(30,90,100,30);
        payPanel.add(cashRadioButton);
        
        ButtonGroup payMethodButtonGroup=new ButtonGroup();
        payMethodButtonGroup.add(creditCardRadioButton);
        payMethodButtonGroup.add(debitCardRadioButton);
        payMethodButtonGroup.add(cashRadioButton);

        JLabel cardNumberLabel=new JLabel("Card Number");
        cardNumberLabel.setBounds(180,30,300,30);
        payPanel.add(cardNumberLabel);

        JTextField cardNumberTextField=new JTextField();
        cardNumberTextField.setBounds(280,35,150,20);
        payPanel.add(cardNumberTextField);

        JLabel expireDateLabel=new JLabel("Expire Date");
        expireDateLabel.setBounds(180,60,300,30);
        payPanel.add(expireDateLabel);

        JTextField expireDateTextField=new JTextField();
        expireDateTextField.setBounds(280,65,150,20);
        payPanel.add(expireDateTextField);

        JLabel ccvLabel=new JLabel("CCV");
        ccvLabel.setBounds(180,90,300,30);
        payPanel.add(ccvLabel);

        JTextField ccveTextField=new JTextField();
        ccveTextField.setBounds(280,95,150,20);
        payPanel.add(ccveTextField);

        JButton payButton=new JButton("Pay");
        payButton.setBounds(250, 145, 150, 25);
        payPanel.add(payButton);

        JLabel payResultLabel=new JLabel("Pay Succseefully: Change is RM5.00");
        payResultLabel.setBounds(100, 175, 300, 25);
        payPanel.add(payResultLabel);

        JButton printReceiptButton=new JButton("Print Receipt");
        printReceiptButton.setBounds(350, 175, 150, 25);
        payPanel.add(printReceiptButton);

        
        mainFrame.add(payPanel);
        
        mainFrame.setSize(650, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}
