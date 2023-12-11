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
    @JsonCreator
    public FormalVisitor(@JsonProperty("name") String name,
                         @JsonProperty("id") int id
    ) {
        this.type="Formal";
        this.name = name;
        this.id = id;
    }
    @JsonIgnore
    public FormalVisitor(String name,String password,int id,String type) {
        this.type = "Formal";
        this.name = name;
        this.id = id;
        this.password=password;
    }
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
                    System.out.println(slot.startTimeString);
                    System.out.println(slot.endTimeString);
                }
            }
        }

    }

    public FormalVisitor() {
        this.type="formal";
    }
    @JsonIgnore
    protected void makeReservation(AbstractRoom room ) {
        //AbstractRoom room= new TeachingRoom();

        MeetingRoom MR = (MeetingRoom) room;

        List<Slot> availableslots = MR.getAvailableSlots();
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
        FormalVisitor formalVisitor = new FormalVisitor();




        for (Slot slot : availableslots) {
            if (Reservedslot.startTimeString.equals( slot.startTimeString ) & Reservedslot.endTimeString.equals(slot.endTimeString) ) {
                slot.createReservation(formalVisitor);
            }
        }


    }



    @JsonIgnore
    protected void updateReservation(AbstractRoom Room) {

        MeetingRoom MR= (MeetingRoom)Room;
        cancelReservation(MR);
        makeReservation(MR);

    }

    @JsonIgnore
    public void cancelReservation(AbstractRoom Room) {

        MeetingRoom MR= (MeetingRoom) Room;

        Scanner input1 = new Scanner(System.in);
        String startTimestring=input1.nextLine();
        //LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTimestring=input2.nextLine();
        //LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees=input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring,  endTimestring,  fees);
        FormalVisitor formalVisitor = new FormalVisitor();

        Slot canceledslot=new Slot (startTimestring,  endTimestring,  fees);

        for (Slot slot : MR.slots) {
            if (canceledslot.startTimeString.equals(slot.startTimeString) && canceledslot.endTimeString.equals(slot.endTimeString)) {
                slot.removeReservation(canceledslot.createReservation(formalVisitor));

            }


        }

    }

}
