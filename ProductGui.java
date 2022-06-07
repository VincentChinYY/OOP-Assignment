import javax.swing.*;
import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;



public class ProductGui {

    Record newRecord;

    JFrame productFrame;
    JComboBox<Product> productComboBox;
    JSpinner productSpinner;
    Product productListObject[];
    JTable productTable;
    JLabel totalAfterTaxLabel;
    JLabel totalBeforeTaxLabel;

    public ProductGui(Record newRecord) {
        this.newRecord = newRecord;
        productListObject = new Product[5];
        Product product1 = new Product("A001", "Product 1 Name", 10.00);
        Product product2 = new Product("A002", "Product 2 Name", 20.00);
        Product product3 = new Product("A003", "Product 3 Name", 30.00);
        Product product4 = new Product("A004", "Product 4 Name", 40.00);
        Product product5 = new Product("A005", "Product 5 Name", 50.00);

        productListObject[0] = product1;
        productListObject[1] = product2;
        productListObject[2] = product3;
        productListObject[3] = product4;
        productListObject[4] = product5;
    }

    public void display() {
        productFrame = new JFrame("Supermarket Point-of-Sales System");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new exitListener());

        menu.add(exit);
        menuBar.add(menu);
        productFrame.setJMenuBar(menuBar);

        JPanel productPanel = new JPanel();
        productPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Product List"));
        productPanel.setBackground(Color.YELLOW);
        productPanel.setBounds(3, 300, 630, 250);
        productPanel.setLayout(null);

        JLabel selectProductLabel = new JLabel("Select Product");
        selectProductLabel.setBounds(30, 50, 300, 30);
        productPanel.add(selectProductLabel);

        productComboBox = new JComboBox<Product>(productListObject);
        productComboBox.setBounds(130, 55, 200, 20);
        productPanel.add(productComboBox);

        SpinnerModel value = new SpinnerNumberModel(1, 1, 100, 1);
        productSpinner = new JSpinner(value);
        productSpinner.setBounds(360, 55, 50, 20);
        productPanel.add(productSpinner);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(460, 55, 150, 20);
        addProductButton.addActionListener(new addProductButton());
        productPanel.add(addProductButton);

        String data[][] = {};
        String tableColumns[] = { "Product ID", "Product Name", "Unit Price", "Quantity", "Total" };

        productTable = new JTable();
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

        productTableScrollPane.setBounds(30, 100, 550, 250);
        productPanel.add(productTableScrollPane);

        totalBeforeTaxLabel = new JLabel("Total Before Tax: RM0.00");
        totalBeforeTaxLabel.setBounds(420, 350, 300, 30);
        productPanel.add(totalBeforeTaxLabel);

        totalAfterTaxLabel = new JLabel(
                "Total After Tax (" + String.valueOf(Math.round(newRecord.getTax() * 100.0)) + "%): RM0.00");
        totalAfterTaxLabel.setBounds(405, 380, 300, 30);
        productPanel.add(totalAfterTaxLabel);

        JButton payFrameButton = new JButton("Pay");
        payFrameButton.setBounds(225, 410, 150, 20);
        payFrameButton.addActionListener(new payFrameListener());
        productPanel.add(payFrameButton);

        productFrame.add(productPanel);

        productFrame.setSize(650, 500);
        productFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainFrame.setLayout(null);
        productFrame.setVisible(true);
    }

    class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(productFrame, "Are you want to exit?");
            if (confirmed == JOptionPane.YES_OPTION) {
                productFrame.dispose();
            }
        }
    }

    class addProductButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Product selectedProduct = (Product) productComboBox.getSelectedItem();

                String productId = selectedProduct.getId();
                String name = selectedProduct.getName();
                double price = selectedProduct.getPrice();

                int quantity = (Integer) productSpinner.getValue();
                newRecord.addProduct(selectedProduct, quantity);
                newRecord.calculateTotalBeforeTax(selectedProduct, quantity);

                Object[] row = { productId, name, "RM" + price, quantity, "RM" + quantity * price };
                DefaultTableModel model = (DefaultTableModel) productTable.getModel();
                model.addRow(row);

                totalBeforeTaxLabel.setText("Total Before Tax: RM" + String.valueOf(newRecord.getTotalBeforeTax()));
                totalAfterTaxLabel.setText(
                        "Total After Tax (6%): RM"
                                + String.valueOf(Math.round(newRecord.getTotalAfterTax() * 100.0) / 100.0));
            } catch (Exception error) {
                error.printStackTrace();
                System.out.println("Error Data Type");
            }
        }
    }

    class payFrameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productFrame.dispose();
            PayGui payGui = new PayGui(newRecord);
            payGui.display();
        }
    }
}