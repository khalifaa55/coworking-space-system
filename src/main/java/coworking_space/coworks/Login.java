package coworking_space.coworks;

import java.util.Arrays;

class Login {

    private String userEmail;

    private String password;
    private String role;

    private static final String adminUserName="Admin";
    private static final String adminPassword= "Admin";

    private Login(String userName, String role, String password) {
        this.userEmail = userName;
        this.role = role;
        this.password = password;

    }

    public static boolean validateLogin(String userEmail, String password,String role) {



        for (Registration obj : Registration.getRegistrations()) {

            if (obj.getUserEmail().equals(userEmail) && (obj.getNewPassword().equals(password))) {

                Registration currentRegistration = Registration.currentUser(userEmail, role);
                AbstractVisitor.createVisitorFromRegistration(currentRegistration);
                return true;
            }
        }
        return false;
    }

    public static boolean adminLogin(String userEmail, String password) {
        if (userEmail.equals(adminUserName) && password.equals(adminPassword)){
            return true;
        }
        else return false;
    }


}