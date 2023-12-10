/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
class Registration {
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private String role;
    private char[] newPassword;
    private char[] confirmPassword;
    private int id;
    private static int idCounter ;
    private static Registration currentRegistration;
    private static final ArrayList<Registration> registrations = new ArrayList<>();
    static final String PANEL_NAME = "SCREEN_2";

    public Registration(){}
    private Registration(String userName, String userEmail, String phoneNumber, char[] newPassword, char[] confirmPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
        this.id = ++idCounter;

    }
    public JPanel  getRegistration(JPanel cardPanel) {

        final JPanel panel;

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\rr.PNG");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        JTextField textName = new JTextField();
        textName.setBounds(540, 146, 330, 47);
        JTextField textemail = new JTextField();
        textemail.setBounds(540, 200, 330, 47);
        JTextField textphone = new JTextField();
        textphone.setBounds(622, 258, 247, 47);
        JPasswordField textPass2 = new JPasswordField();
        textPass2.setBounds(568, 320, 305, 47);
        JPasswordField textPass3 = new JPasswordField();
        textPass3.setBounds(654, 375, 240, 47);

        textName.setOpaque(false);
        textName.setBorder(null);
        textemail.setOpaque(false);
        textemail.setBorder(null);
        textphone.setOpaque(false);
        textphone.setBorder(null);
        textPass2.setOpaque(false);
        textPass2.setBorder(null);
        textPass3.setOpaque(false);
        textPass3.setBorder(null);

        panel.setLayout(null);
        panel.add(textName);
        panel.add(textPass2);
        panel.add(textemail);
        panel.add(textPass3);
        panel.add(textphone);

        JButton regbutton = new JButton();
        regbutton.setBounds(580, 440, 169, 40);
        regbutton.setToolTipText("Register");
        regbutton.setContentAreaFilled(false);
        regbutton.setBorderPainted(false);

        regbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = textName.getText();
                userEmail = textemail.getText();
                phoneNumber = textphone.getText();
                newPassword = textPass2.getPassword();
                confirmPassword = textPass3.getPassword();

                if (userName.isEmpty() || userEmail.isEmpty() || phoneNumber.isEmpty() || newPassword.length == 0 || confirmPassword
                        .length == 0) {
                    JOptionPane.showMessageDialog(null, "All fields are required. Please fill in all the details.");
                } else if (!Arrays.equals(newPassword, confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                } else if (isDuplicateEmail(userEmail)) {
                    JOptionPane.showMessageDialog(null, "This email is already registered!");
                }
                else {
                    // Perform registration action (you can add your logic here)
                    Registration newRegistration = new Registration(userName, userEmail, phoneNumber, newPassword, confirmPassword);
                    registrations.add(newRegistration);
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                }
            }
        });

        panel.add(regbutton);

        JButton backButton = new JButton("<html><u>Back to Login</u></html>");
        backButton.setBounds(580, 490, 169, 15);
        backButton.setToolTipText("Back to Login");
        backButton.setForeground(new Color(0x124D3f));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setContentAreaFilled(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
                cardLayout.previous(cardPanel);
                System.out.println(phoneNumber);
            }
        });

        panel.add(backButton);

        return panel;
    }


    public static ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    private boolean isDuplicateEmail(String email) {
        for (Registration registration : registrations) {
            if (registration.getUserEmail().equals(email)) {
                return true; // Email is already registered
            }
        }
        return false; // Email is not registered
    }

    public static Registration currentUser(String userEmail,String role) {
        for (Registration registration : registrations) {
            if (registration.getUserEmail().equals(userEmail)) {
                registration.setRole(role);
                currentRegistration = registration;
            }
        }
        return currentRegistration;
    }


    public static void  updateRegistrationInfo(ArrayList<Registration> registrations, String userCurrentEmail, String newUserName, char[] newPassword, String newPhoneNumber) {
        for (Registration registration : registrations) {
            if (registration.getUserEmail().equals(userCurrentEmail)) {
                if (newUserName != null) {
                    registration.setUserName(newUserName);
                }
                if (newPassword != null) {
                    registration.setNewPassword(newPassword);
                }
                if (newPhoneNumber != null) {
                    registration.setPhoneNumber(newPhoneNumber);
                }
                //if (newUserEmail!= null) {
                //  registration.setPhoneNumber(newPhoneNumber);}

                return;
            }
        }
    }
    public static Registration  getRegistration(){ return currentRegistration;}

    public int userid(){return id;}
    public static void updateIdCounter(){
        idCounter=AbstractVisitor.getlasindex();
        System.out.println(idCounter);
    }

    public String getUserName() {
        return userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public char[] getNewPassword() {return newPassword;}
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail=userEmail;
    }
    public void setNewPassword(char[]newPassword ) {this.newPassword=newPassword;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }

    // private boolean isValidPhoneNumber(String phoneNumber) {}

    // private boolean isValidEmail(String email) {}

}

 */