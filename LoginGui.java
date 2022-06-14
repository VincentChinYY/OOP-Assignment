import javax.swing.*;
import java.awt.event.*;
import java.util.Hashtable;

public class LoginGui {

    // private String loginPassword;
    Product productList[];

    JFrame loginFrame;
    JTextField employeeIdTextField;
    JTextField passwordTextField;
    Hashtable<String, String> adminList;

    public LoginGui(Product productList[]) {
        this.productList = productList;

        adminList = new Hashtable<String, String>();

        adminList.put("E123", "ABC12345");
        adminList.put("E456", "ABC67890");
        adminList.put("E789", "EFG12345");
    }

    public void display() {
        loginFrame = new JFrame("Admin Login");

        JLabel employeeIdLabel = new JLabel("Employee ID");
        employeeIdLabel.setBounds(120, 120, 300, 30);
        loginFrame.add(employeeIdLabel);

        employeeIdTextField = new JTextField();
        employeeIdTextField.setBounds(220, 125, 150, 20);
        loginFrame.add(employeeIdTextField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(120, 170, 300, 30);
        loginFrame.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(220, 175, 150, 20);
        loginFrame.add(passwordTextField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(175, 270, 150, 20);
        loginButton.addActionListener(new loginListener());
        loginFrame.add(loginButton);

        loginFrame.setSize(500, 500);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    class loginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = employeeIdTextField.getText();
            String password = passwordTextField.getText();

            if (adminList.containsKey(id) && adminList.get(id).equals(password)) {
                EditProductGui editProduct = new EditProductGui(productList);
                loginFrame.dispose();
                editProduct.display();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid Employee ID or Password", "Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}