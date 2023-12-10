package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@JsonTypeName("general")
public class GeneralVisitor extends AbstractVisitor{

    @JsonIgnore
    public String type;
    @JsonCreator
    public GeneralVisitor(@JsonProperty("name") String name,
                          @JsonProperty("id") int id) {
        this.type="general";
        this.name = name;
        this.id = id;
    }

    public GeneralVisitor() {
        this.type="general";
    }
//    @JsonProperty
//    public String getVisitor_Type() {
//        return visitor_type;
//    }

    @JsonIgnore
    protected void makeReservation(AbstractRoom room ) {

        GeneralRoom GR = (GeneralRoom) room;

        Scanner input1 = new Scanner(System.in);
        String startTimestring = input1.nextLine();
        LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTimestring = input2.nextLine();
        LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees = input3.nextDouble();

        Slot Reserved_slot = new Slot(startTimestring, endTimestring, fees);
        GeneralVisitor generalVisitor = new GeneralVisitor();


        List<Slot> availableslots = GR.getAvailableSlots();
        for (Slot slot : availableslots) {
            System.out.println(slot);
        }

        for (Slot slot : availableslots){


            if (Reserved_slot.startTime == slot.startTime & Reserved_slot.endTime == slot.endTime) {
                Reserved_slot.addReservation(Reserved_slot.createReservation(generalVisitor));
            }
        }
    }
    @JsonIgnore
    protected void updateReservation(AbstractRoom Room) {

        GeneralRoom GR= (GeneralRoom)Room;
        cancelReservation(GR);
        makeReservation(GR);

    }


    @JsonIgnore
    public void cancelReservation(AbstractRoom Room) {

        GeneralRoom GR= (GeneralRoom) Room;

        Scanner input1 = new Scanner(System.in);
        String startTimestring=input1.nextLine();

        Scanner input2 = new Scanner(System.in);
        String endTimestring=input2.nextLine();

        Scanner input3 = new Scanner(System.in);
        double fees=input3.nextDouble();
        Slot Reserved_slot = new Slot(startTimestring,  endTimestring,  fees);
        GeneralVisitor generalVisitor = new GeneralVisitor();

        Slot canceled_slot=new Slot (startTimestring,  endTimestring,  fees);


        for(Slot slot :GR.slots)
            if(canceled_slot.startTime==slot.startTime && canceled_slot.endTime==slot.endTime){
                canceled_slot.removeReservation(canceled_slot.createReservation( generalVisitor ));

            }



    }


}