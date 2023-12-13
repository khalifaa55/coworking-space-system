package coworking_space.coworks;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

class Registration {
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private String role;
    private String newPassword;
    private int id;
    private static int idCounter ;
    private static Registration currentRegistration;
    private static final ArrayList<Registration> registrations = new ArrayList<>();
    static final String PANEL_NAME = "SCREEN_2";

    public Registration(){}
    public Registration(String userName, String userEmail, String phoneNumber, String newPassword,String role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.newPassword = newPassword;
        this.id = ++idCounter;
        this.role=role;

    }

    public static boolean usernameRegex(String username) {

        String usernameRegex = "^[a-zA-Z0-9_]{3,20}$";


        boolean isValid = Pattern.matches(usernameRegex, username);

        // Display a pop-up with the validation result
        return isValid;
    }
    public static boolean passwordRegex(String password) {
        // Define the password validation regex
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$";

        // Check if the password matches the regex
        boolean isValid = Pattern.matches(passwordRegex, password);

        // Display a pop-up with the validation result
        return isValid;
    }

    public static boolean phoneNumberRegex(String phoneNumber) {

        String phoneNumberRegex = "^[0-9]{10}$";

        // Check if the password matches the regex
        boolean isValid = Pattern.matches(phoneNumberRegex,phoneNumber);

        // Display a pop-up with the validation result
        return isValid;
    }

    public static boolean emailRegex(String email) {

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        boolean isValid = Pattern.matches(emailRegex, email);

        // Display a pop-up with the validation result
        return isValid;
    }

               /* if (userName.isEmpty() || userEmail.isEmpty() || phoneNumber.isEmpty() || newPassword.length == 0 || confirmPassword
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

                */

    public static ArrayList<Registration> getRegistrations() {
        return registrations;
    }

    public static boolean  isDuplicateEmail(String email) {
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


    public static void  updateRegistrationInfo(ArrayList<Registration> registrations, String userCurrentEmail, String newUserName,String newPassword, String newPhoneNumber) {
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
    public String getNewPassword() {return newPassword;}
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
    public void setNewPassword(String newPassword ) {this.newPassword=newPassword;}
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }

    // private boolean isValidPhoneNumber(String phoneNumber) {}

    // private boolean isValidEmail(String email) {}

}

