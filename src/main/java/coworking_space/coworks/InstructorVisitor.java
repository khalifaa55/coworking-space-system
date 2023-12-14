
package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class InstructorVisitor extends AbstractVisitor {

    @JsonIgnore
    public String type;

    //Class Constructors//
    @JsonCreator
    public InstructorVisitor(@JsonProperty("name") String name,
                             @JsonProperty("password") String password,
                             @JsonProperty("id") int id,
                             @JsonProperty("type") String type) {
        this.type = "instructor";
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public InstructorVisitor(String name, int id) {
        this.type="instructor";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public InstructorVisitor() {
        this.type="instructor";
    }

    //Getters//
    @JsonProperty("password")
    public String getPassword(){
        return this.password;
    }
    @JsonProperty("phoneNumber")
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    @JsonProperty("userEmail")
    public String getUserEmail(){
        return this.userEmail;
    }
    //Setters//
    public void setPassword(String password){
        this.password=password;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setUserEmail(String userEmail){
        this.userEmail=userEmail;
    }

    //Class Methods//
    @JsonIgnore
    public static InstructorVisitor createVisitorFromRegistration(Registration registration) {
        return new InstructorVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),"instructor");
    }

    @Override
    protected void DisplayReservation(AbstractRoom room , Registration currentr) {

        TeachingRoom TR = (TeachingRoom) room;
        for(Slot slot:TR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorEmail = r.getVisitor().userEmail;
                if(currentr.getUserEmail().equals(visitorEmail)){
                    System.out.println(slot.getStartTime());
                    System.out.println(slot.getEndTime());
                    System.out.println(slot.getFees());

                }
            }
        }

    }

    protected void makeReservation(AbstractRoom room ) {
        //AbstractRoom room= new TeachingRoom();

        TeachingRoom TR = (TeachingRoom) room;

        List<Slot> availableslots = TR.getAvailableSlots();
        for (Slot slot : availableslots) {
            System.out.println(slot);
        }

        Scanner input1 = new Scanner(System.in);
        String startTimestring = input1.nextLine();
        //LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTimestring = input2.nextLine();
        // LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees = input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring, endTimestring, fees);
        InstructorVisitor instructorVisitor = new InstructorVisitor();

        for (Slot slot : availableslots) {
            if (Reservedslot.startTime.equals( slot.startTime) & Reservedslot.endTime.equals(slot.endTime) ) {
                slot.createReservation(instructorVisitor);
            }
        }

    }

    protected void updateReservation(AbstractRoom Room) {

        TeachingRoom TR= (TeachingRoom)Room;
        cancelReservation(TR);
        makeReservation(TR);

    }

    public void cancelReservation(AbstractRoom Room) {

        TeachingRoom TR= (TeachingRoom) Room;

        Scanner input1 = new Scanner(System.in);
        String startTimestring=input1.nextLine();
        //LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTimestring=input2.nextLine();
        //LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees=input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring,  endTimestring,  fees);
        InstructorVisitor instructorVisitor = new InstructorVisitor();

        Slot canceledslot=new Slot (startTimestring,  endTimestring,  fees);

        for (Slot slot : TR.slots)
        {
            if (canceledslot.startTime.equals(slot.startTime) && canceledslot.endTime.equals(slot.endTime)) {
                slot.removeReservation(canceledslot.createReservation(instructorVisitor));

            }
        }
    }
}


