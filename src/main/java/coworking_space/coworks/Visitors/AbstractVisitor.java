package coworking_space.coworks.Visitors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import coworking_space.coworks.Rooms.AbstractRoom;

import java.time.LocalDate;
import java.util.ArrayList;

import static coworking_space.coworks.EditInformationController.inValidMessage;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GeneralVisitor.class, name = "general"),
        @JsonSubTypes.Type(value = FormalVisitor.class, name = "formal"),
        @JsonSubTypes.Type(value = InstructorVisitor.class, name = "instructor"),
})
public abstract class AbstractVisitor {
    public String name;


    protected String userEmail;
    protected String phoneNumber;
    protected String password;
    public int id;
    public String type;
    public static ArrayList<AbstractVisitor> visitors;

    public static void getAbstractVisitorsFromMain(ArrayList<AbstractVisitor> Visitors) {
        visitors = Visitors;
    }

    public static void createVisitorsFromRegistrations(Registration currentR) {
        boolean check = false;
        boolean flag = false;
        String UserEmailCurrentR = currentR.getUserEmail();
        System.out.println(UserEmailCurrentR);
        for (AbstractVisitor v : visitors) {
            if ((v.userEmail).equals(UserEmailCurrentR) && currentR.getRole().equals(v.type)) {
                check = true;
                break;
            }
        }
        if (!check) {
            AbstractVisitor visitor = createVisitorFromRegistration(currentR);
            for (AbstractVisitor v : visitors) {
                if ((v.userEmail).equals(UserEmailCurrentR)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                visitors.add(visitor);
            }
        }
    }

    @JsonIgnore
    protected static AbstractVisitor createVisitorFromRegistration(Registration currentR) {
        try {
            switch (currentR.getRole()) {
                case "General Visitor":
                    return GeneralVisitor.createVisitorFromRegistration(currentR);
                case "Formal Visitor":
                    return FormalVisitor.createVisitorFromRegistration(currentR);
                case "Instructor Visitor":
                    return InstructorVisitor.createVisitorFromRegistration(currentR);
                default:
                    throw new IllegalArgumentException("Unknown visitor type: " + currentR.getRole());
            }
        } catch (Exception e) {
            System.err.println("Unknown visitor type: " + currentR.getRole());
            e.printStackTrace();
            return null; // Return null or throw a specific exception as needed
        }
    }

    @JsonIgnore
    public static AbstractVisitor getCurrentVisitor(Registration currentR) {
        try {
            if (visitors != null) {
                for (AbstractVisitor currentVisitor : visitors) {
                    if (currentR.getUserEmail().equals(currentVisitor.userEmail)) {
                        return currentVisitor;
                    }
                }
            } else {
                System.err.println("Error: Visitors list is null.");
            }
        } catch (Exception e) {
            // Catch more specific exceptions if possible
            System.err.println("Error while searching for current visitor: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void editUserInfo(AbstractVisitor cVisitor, String currentuseremail, String newname, String newpass, String newemail, String newphoneNumber) {
        if (newname != null && !newname.isEmpty()) {
            cVisitor.name = newname;
            Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, newname, null, null, null);

        }
        if (newpass != null && !newpass.isEmpty()) {
            cVisitor.password = newpass;
            Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, null, newpass, null);
        }
        if (newemail != null && !newemail.isEmpty()) {
            cVisitor.userEmail = newemail;
            Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, newemail, null, null);

        }
        if (newphoneNumber != null && !newphoneNumber.isEmpty()) {
            cVisitor.phoneNumber = newphoneNumber;
            Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, null, null, newphoneNumber);

        }
    }

    public void checkEmail(String newEmail) {
        for (AbstractVisitor allVisitor : visitors) {
            if (allVisitor.userEmail.equals(newEmail)) {
                String inValidTitle = "EmailNotValid";
                String inValidMessage = "Invalid Email, please try again.";
                inValidMessage(inValidTitle, inValidMessage);
            }
        }
    }

    @JsonIgnore
    public static int getlasindex() {
        int lastindex = visitors.size() - 1;
        AbstractVisitor lastElement = visitors.get(lastindex);
        return lastElement.getId();
    }

    public int getId() {
        return id;
    }

    @JsonIgnore
    public abstract ArrayList DisplayReservation(AbstractRoom room);

    public abstract void makeReservation(AbstractRoom room, LocalDate date, String startTime, String endTime, int id);

    public abstract void cancelReservation(AbstractRoom Room, String startTime, String endTime);

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
//    @JsonIgnore
//    public void editUserInfo(int c, AbstractVisitor editVisitor, String currentUserEmail, String newName,String newPass, String newPhoneNumber, String newEmail) {
//        switch (c) {
//            case 1:
//                editVisitor.name=newName;
//                    Registration.updateRegistrationInfo(Registration.getRegistrations(), currentUserEmail, newName, null, null);
//                break;
//            case 2:
//                editVisitor.password=newPass;
//                Registration.updateRegistrationInfo(Registration.getRegistrations(), currentUserEmail, newName, null, null);
//                break;
//            case 3:
//                editVisitor.phoneNumber=newPhoneNumber;
//                Registration.updateRegistrationInfo(Registration.getRegistrations(), currentUserEmail, newName, null, null);
//                break;
//            case 4:
//                editVisitor.userEmail=newEmail;
//                Registration.updateRegistrationInfo(Registration.getRegistrations(), currentUserEmail, newName, null, null);
//                break;
//        }
//    }

/*public void editUserInfo(int c,ArrayList<AbstractVisitor> editvisitor , String currentuseremail, String newname,char[] newpass,String phonenumber,String email) {
        switch (c) {
            case 1:
                for (AbstractVisitor visitor : editvisitor) {
                    if (visitor.userEmail.equals( currentuseremail)) {
                        visitor.name=newname;
                        Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, newname, null, null);
                        return;
                    }break;
                }
            case 2:
                for (AbstractVisitor visitor : editvisitor) {
                    if (visitor.userEmail.equals( currentuseremail)) {
                        visitor.password=newpass;
                        Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, newpass, null);
                        return;
                    }
                }break;
            case 3:
                for (AbstractVisitor visitor : editvisitor) {
                    if (visitor.userEmail.equals(currentuseremail)) {
                        visitor.phoneNumber= phonenumber;
                        Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, null, phonenumber);
                        return;
                    }
                }break;
        }
    }*/

    /*
    @JsonIgnore
    public void displayData(int c, ArrayList<AbstractVisitor> visitorinfo, String currentUserEmail, AbstractRoom room, Registration currentr) {
        switch (c) {
            case 1:
                for (AbstractVisitor visitor : visitorinfo) {
                    // Check if the current visitor has the target ID
                    if (visitor.userEmail.equals(currentUserEmail)){
                        //display 3la al gui
                        System.out.println("Visitor ID: " + visitor.id);
                        System.out.println("Visitor Name: " + visitor.name);
                        System.out.println("Visitor Email: "+visitor.userEmail);
                        System.out.println("Visitor password: "+visitor.password);
                        System.out.println("Visitor phoneNumber: "+visitor.phoneNumber);
                        return;
                    }
                }break;
            case 2:
                for (AbstractVisitor visitor : visitorinfo) {
                    if (visitor.userEmail.equals(currentUserEmail)) {
                        DisplayReservation(room, currentr);
                    }
                }break;
        }
    }*/