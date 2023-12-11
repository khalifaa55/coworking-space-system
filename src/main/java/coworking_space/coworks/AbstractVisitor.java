package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import coworking_space.coworks.AbstractRoom;
import coworking_space.coworks.FormalVisitor;
import coworking_space.coworks.GeneralVisitor;
import coworking_space.coworks.InstructorVisitor;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "visitorType")
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
    protected int id;
    public String type;
    public static ArrayList<AbstractVisitor> visitors = new ArrayList<>();
    public static ArrayList<AbstractVisitor> createVisitorsFromRegistrations(Registration currentR) {
        boolean check=false;
        boolean flag=false;
        for (AbstractVisitor v : visitors) {
            if ((v.id == currentR.userid() || v.userEmail == currentR.getUserEmail()) && currentR.getRole() == v.type) {
                check = true;
                break;
            }
        }
        if (check==false) {
            AbstractVisitor visitor = createVisitorFromRegistration(currentR);
            for (AbstractVisitor v : visitors) {
                if (v.id == currentR.userid() || v.userEmail == currentR.getUserEmail()) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                visitors.add(visitor);
            }
        }
        return visitors;
    }

    protected static AbstractVisitor createVisitorFromRegistration(Registration currentR) {
        try {
            switch (currentR.getRole()) {
                case "general":
                    return GeneralVisitor.createVisitorFromRegistration(currentR);
                case "formal":
                    return FormalVisitor.createVisitorFromRegistration(currentR);
                case "instructor":
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




    public void editUserInfo(int c, ArrayList<AbstractVisitor> editvisitor, String currentuseremail, String newname,String newpass, String phonenumber, String email) {
        int index = -1;
        for (AbstractVisitor visitor : editvisitor) {
            if (visitor.userEmail.equals(currentuseremail)) {
                index = editvisitor.indexOf(visitor);
                break;
            }
        }
        switch (c) {
            case 1:
                if (index != -1) {
                    editvisitor.get(index).name = newname;
                    Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, newname, null, null);
                }
                break;
            case 2:
                if (index != -1) {
                    editvisitor.get(index).password = newpass;
                    Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, newpass, null);
                }
                break;
            case 3:
                if (index != -1) {
                    editvisitor.get(index).phoneNumber = phonenumber;
                    Registration.updateRegistrationInfo(Registration.getRegistrations(), currentuseremail, null, null, phonenumber);
                }
                break;
        }
    }

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

    public void displayData(int c, ArrayList<AbstractVisitor> visitorinfo, String currentUserEmail, AbstractRoom room , Registration currentr) {
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
                    if (visitor.userEmail == currentUserEmail) {
                        DisplayReservation(room,currentr);
                    }
                }break;
        }
    }

    public static int getlasindex() {
        int lastindex = visitors.size() - 1;
        AbstractVisitor lastElement = visitors.get(lastindex);
        return lastElement.getId();
    }
    public int getId() {
        return id;
    }
    protected abstract void DisplayReservation(AbstractRoom room,Registration currentr);
    protected abstract void makeReservation(AbstractRoom room);
    protected abstract void updateReservation(AbstractRoom room);
    public abstract void cancelReservation(AbstractRoom room);
}
