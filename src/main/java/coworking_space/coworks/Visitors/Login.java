package coworking_space.coworks.Visitors;

import coworking_space.coworks.Admin;

public class Login {
    private String userEmail;
    private String password;
    private String role;

    public Login(String userName, String role, String password) {
        this.userEmail = userName;
        this.role = role;
        this.password = password;

    }

    public static boolean validateLogin(Login currentLogin) {
        boolean flag=false;
        for (Registration obj : Registration.getRegistrations()) {
            if (obj.getUserEmail().equals(currentLogin.userEmail) && (obj.getNewPassword().equals(currentLogin.password))) {

                Registration currentRegistration = Registration.currentUser(currentLogin.userEmail, currentLogin.role);
                System.out.println(currentRegistration.getRole());
                AbstractVisitor.createVisitorsFromRegistrations(currentRegistration);
                flag=true;
            }
        }
        return flag;
    }

    public static boolean adminLogin(String userEmail, String password) {
        if (userEmail.equals(Admin.getAdmin_Name()) && password.equals(Admin.getAdmin_Password())){
            return true;
        }
        else return false;
    }


}