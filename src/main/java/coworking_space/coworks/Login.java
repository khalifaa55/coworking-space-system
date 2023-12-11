package coworking_space.coworks;

import java.util.Arrays;

class Login {

    private String userEmail;
    private static final String adminUserName="admin";
    private String role;
    private String password;
    private static final String adminPassword= "admin";

    private static Login lastSuccessfulLogin;
    static final String PANEL_NAME = "SCREEN_1";
    public Login(){}
    private Login(String userName, String role, String password) {
        this.userEmail = userName;
        this.role = role;
        this.password = password;

    }




               /* if(adminLogin(userEmail, password)){
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                }
                else if (validateLogin(userEmail, password,role)) {
                    lastSuccessfulLogin = new Login(userEmail, role, password);
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    System.out.println(role);
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials. Please try again.");
                }
      */





    private boolean validateLogin(String userEmail, String password,String role) {



        for (Registration obj : Registration.getRegistrations()) {

            System.out.println("Entered userName: " + userEmail);
            System.out.println("Stored rUsername: " + obj.getUserName());

            if (obj.getUserName().equals(userEmail) && (obj.getNewPassword().equals(password))) {

                Registration currentResigtration = Registration.currentUser(userEmail, role);
                AbstractVisitor.createVisitorFromRegistration(currentResigtration);
                return true;
            }
        }
        return false;
    }

    private boolean adminLogin(String userEmail, String password) {
        if (userEmail==adminUserName&&password==adminPassword){
            return true;
        }
        else return false;
    }

    public static Login getLastSuccessfulLogin() {
        return lastSuccessfulLogin;
    }
}