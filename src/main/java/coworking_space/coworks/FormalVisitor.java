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
                         @JsonProperty("id") int id) {
        this.type="general";
        this.name = name;
        this.id = id;
    }

    public FormalVisitor() {
        this.type="formal";
    }
    @JsonIgnore
    protected void makeReservation(AbstractRoom room ) {
        //coworking_space.coworks.AbstractRoom room= new TeachingRoom();

        MeetingRoom MR = (MeetingRoom) room;
        Scanner input1 = new Scanner(System.in);
        String startTimestring = input1.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTimestring = input2.nextLine();
        LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees = input3.nextDouble();
        Slot Reservedslot = new Slot(startTimestring, endTimestring, fees);
        InstructorVisitor instructorVisitor = new InstructorVisitor();


        List<Slot> availableslots = MR.getAvailableSlots();
        for (Slot slot : availableslots) {
            System.out.println(slot);
        }

        for (Slot slot : availableslots) {
            if (Reservedslot.startTime == slot.startTime & Reservedslot.endTime == slot.endTime) {
                Reservedslot.addReservation(Reservedslot.createReservation(instructorVisitor));
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
        InstructorVisitor instructorVisitor = new InstructorVisitor();

        Slot canceledslot=new Slot (startTimestring,  endTimestring,  fees);


        for(Slot slot :MR.slots)
            if(canceledslot.startTime==slot.startTime && canceledslot.endTime==slot.endTime){
                canceledslot.removeReservation(canceledslot.createReservation(instructorVisitor ));

            }



    }

}
