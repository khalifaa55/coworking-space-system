package coworking_space.coworks;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static coworking_space.coworks.Coworks_Main.registrations;

public class Registration {
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private String role;
    private String newPassword;
    private int id;
    private static int idCounter ;
    private static Registration currentRegistration;

    public Registration(){}
    public Registration(String userName, String userEmail, String phoneNumber, String newPassword,String role,int lastId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.newPassword = newPassword;
        this.id = ++lastId;
        this.role=role;

    }

    public static void getVisitorsFromMain(ArrayList<AbstractVisitor>visitors){
        for (AbstractVisitor visitorR:visitors) {
            Registration r=new Registration();
            r.setPhoneNumber(visitorR.phoneNumber);
            r.setUserName(visitorR.name);
            r.setUserEmail(visitorR.userEmail);
            r.setNewPassword(visitorR.password);
            registrations.add(r);
        }
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

        String phoneNumberRegex = "^[0-9]{11}$";

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

    public static ArrayList<Registration> getRegistrations() {
        return registrations;
    }
    public static Registration  getRegistration(){ return currentRegistration;}

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

    public static void  updateRegistrationInfo(ArrayList<Registration> registrations, String userCurrentEmail, String newUserName,String newUserEmail,String newPassword, String newPhoneNumber) {
        for (Registration registration : registrations) {
            if (registration.getUserEmail().equals(userCurrentEmail)) {
                if (newUserName != null) {
                    registration.setUserName(newUserName);
                }
                if (newUserEmail != null) {
                    registration.setUserEmail(newUserEmail);
                    System.out.println(registration.getUserEmail());
                }
                if (newPassword != null) {
                    registration.setNewPassword(newPassword);
                }
                if (newPhoneNumber != null) {
                    registration.setPhoneNumber(newPhoneNumber);
                    System.out.println(registration.getPhoneNumber());
                }
                //if (newUserEmail!= null) {
                //  registration.setPhoneNumber(newPhoneNumber);}

                return;
            }
        }
    }

    public static int updateIdCounter(){
    idCounter=AbstractVisitor.getlasindex();
        System.out.println(idCounter);
        return idCounter;
    }
    public int userid(){return id;}
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
    public static void setCurrentRegistration(Registration currentRegistration) {
        Registration.currentRegistration = currentRegistration;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setID(int id) {
        this.id = id;
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

}

