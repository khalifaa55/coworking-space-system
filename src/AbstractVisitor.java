import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "visitorType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GeneralVisitor.class, name = "general"),
})
public abstract class AbstractVisitor {
    public String name;
    private char[] password;
    protected int id;
    public String type;
    /*
        public static ArrayList<AbstractVisitor> createVisitorsFromRegistrations(ArrayList<Registration> registrations) {
            ArrayList<AbstractVisitor> visitors = new ArrayList<>();
            for (Registration registration : registrations) {
                AbstractVisitor visitor = createVisitorFromRegistration(registration);
                visitors.add(visitor);
            }
            return visitors;
        }

        protected static AbstractVisitor createVisitorFromRegistration(Registration registration) {
            switch (registration.getType()) {
                case "general":
                    return GeneralVisitor.createVisitorFromRegistration(registration);
                case "formal":
                    return formalVisitor.createVisitorFromRegistration(registration);
                case "instructor":
                    return InstructorVisitor.createVisitorFromRegistration(registration);
                default:
                    throw new IllegalArgumentException("Unknown visitor type: " + registration.getType());
            }
        }

        public void editUserInfo(int c,ArrayList<Registration> registrations , int currentuserid, String newname,char[] newpass,String phonenumber,String email) {
            switch (c) {
                case 1:
                    for (Registration visitor : registrations) {
                        if (visitor.getUserid()== currentuserid) {
                            visitor.setUserName(newname);

                            return;
                        }break;
                    }
                case 2:
                    for (Registration visitor : registrations) {
                        if (visitor.id == currentuserid) {
                            visitor.setNewPassword(newpass);
                            return;
                        }
                    }break;
                case 3:
                    for (Registration visitor : registrations) {
                        if (visitor.id == currentuserid) {
                            visitor.setUserEmail(email);
                            return;
                        }
                    }break;
                case 4:
                    for (Registration visitor : registrations) {
                        if (visitor.id == currentuserid) {
                            visitor.setPhoneNumber(phonenumber);
                            return;
                        }
                    }break;
            }
        }

        public void displayData(int c, ArrayList<AbstractVisitor> visitorinfo, int currentuserid) {
            switch (c) {
                case 1:
                    for (AbstractVisitor visitor : visitorinfo) {
                        // Check if the current visitor has the target ID
                        if (visitor.id == currentuserid) {
                            //display 3la al gui
                            System.out.println("Visitor ID: " + visitor.id);
                            System.out.println("Visitor Name: " + visitor.name);
                            return;
                        }
                    }break;
                case 2:
                    for (AbstractVisitor visitor : visitorinfo) {
                        if (visitor.id == currentuserid) {
                            //display all his reservation

                        }
                    }break;
            }
        }
    */
    protected abstract void makeReservation(AbstractRoom room);
    protected abstract void updateReservation(AbstractRoom room);
    public abstract void cancelReservation(AbstractRoom room);
}
