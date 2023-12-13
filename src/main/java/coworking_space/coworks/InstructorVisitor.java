
package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@JsonTypeName("instructor")
public class InstructorVisitor extends AbstractVisitor {

    @JsonIgnore
    public String type;
    @JsonCreator
    public InstructorVisitor(@JsonProperty("name") String name,
                             @JsonProperty("id") int id
    ) {
        this.type="general";
        this.name = name;
        this.id = id;
    }
    @JsonIgnore
    public InstructorVisitor(String name,String password,int id,String type) {
        this.type = "general";
        this.name = name;
        this.id = id;
        this.password = password;
    }
    @JsonCreator
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

    public InstructorVisitor() {
        this.type="instructor";
    }

    protected void DisplayReservation(AbstractRoom room) {

    }

    @JsonIgnore
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



    @JsonIgnore
    protected void updateReservation(AbstractRoom Room) {

        TeachingRoom TR= (TeachingRoom)Room;
        cancelReservation(TR);
        makeReservation(TR);

    }

    @JsonIgnore
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

        for (Slot slot : TR.slots) {
            if (canceledslot.startTime.equals(slot.startTime) && canceledslot.endTime.equals(slot.endTime)) {
                slot.removeReservation(canceledslot.createReservation(instructorVisitor));

            }


        }
    }


}


