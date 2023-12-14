package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@JsonTypeName("formal")
public class FormalVisitor extends AbstractVisitor {

    @JsonIgnore
    public String type;

    //Class Constructors//
    @JsonCreator
    public FormalVisitor(@JsonProperty("name") String name,
                                @JsonProperty("password") String password,
                                @JsonProperty("id") int id,
                                @JsonProperty("type")String type) {
        this.type = "formal";
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public FormalVisitor(String name, int id) {
        this.type="formal";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public FormalVisitor() {
        this.type="formal";
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
    public static FormalVisitor createVisitorFromRegistration(Registration registration) {
        return new FormalVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),"formal");
    }

    @Override
    protected void DisplayReservation(AbstractRoom room,Registration currentr) {
        MeetingRoom MR = (MeetingRoom) room;

        for(Slot slot:MR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorName = r.getVisitor().userEmail;
                if(currentr.getUserEmail().equals(visitorName)){
                    System.out.println(slot.startTime);
                    System.out.println(slot.endTime);
                }
            }
        }

    }
    protected void makeReservation(AbstractRoom room ) {
        //AbstractRoom room= new TeachingRoom();

        MeetingRoom MR = (MeetingRoom) room;

        List<Slot> availableslots = MR.getAvailableSlots();
        for (Slot slot : availableslots) {
            System.out.println(slot);
        }

        Scanner input1 = new Scanner(System.in);
        String startTimestring = input1.nextLine();

        Scanner input2 = new Scanner(System.in);
        String endTimestring = input2.nextLine();

        Scanner input3 = new Scanner(System.in);
        double fees = input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring, endTimestring, fees);
        FormalVisitor formalVisitor = new FormalVisitor();

        for (Slot slot : availableslots) {
            if (Reservedslot.startTime.equals( slot.startTime) & Reservedslot.endTime.equals(slot.endTime) ) {
                slot.createReservation(formalVisitor);
            }
        }


    }

    protected void updateReservation(AbstractRoom Room) {

        MeetingRoom MR= (MeetingRoom)Room;
        cancelReservation(MR);
        makeReservation(MR);

    }

    public void cancelReservation(AbstractRoom Room) {

        MeetingRoom MR= (MeetingRoom) Room;

        Scanner input1 = new Scanner(System.in);
        String startTimestring=input1.nextLine();

        Scanner input2 = new Scanner(System.in);
        String endTimestring=input2.nextLine();

        Scanner input3 = new Scanner(System.in);
        double fees=input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring,  endTimestring,  fees);
        FormalVisitor formalVisitor = new FormalVisitor();

        Slot canceledslot=new Slot (startTimestring,  endTimestring,  fees);

        for (Slot slot : MR.slots)
        {
            if (canceledslot.startTime.equals(slot.startTime) && canceledslot.endTime.equals(slot.endTime))
            {
                slot.removeReservation(canceledslot.createReservation(formalVisitor));
            }
        }
    }
}


