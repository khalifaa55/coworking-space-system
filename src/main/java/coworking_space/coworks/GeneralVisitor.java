package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class GeneralVisitor extends AbstractVisitor{

    @JsonIgnore
    public String type;
    @JsonCreator
    public GeneralVisitor(@JsonProperty("name") String name,
                          @JsonProperty("password") String password,
                          @JsonProperty("id") int id,
                          @JsonProperty("type") String type) {
        this.type = "general";
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public GeneralVisitor(String name, int id) {
        this.type="general";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public GeneralVisitor() {
        this.type="general";
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
    public static GeneralVisitor createVisitorFromRegistration(Registration registration) {
        return new GeneralVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),"general");
    }
    @Override
    protected void DisplayReservation(AbstractRoom room , Registration currentr) {
        GeneralRoom gene = (GeneralRoom) room;

        for(Slot slot:gene.getSlots()){
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

        GeneralRoom GR = (GeneralRoom) room;

        Scanner input1 = new Scanner(System.in);
        String startTime = input1.nextLine();
//        LocalDateTime startTime = LocalDateTime.parse(startTimestring);

        Scanner input2 = new Scanner(System.in);
        String endTime = input2.nextLine();
//        LocalDateTime endTime = LocalDateTime.parse(endTimestring);

        Scanner input3 = new Scanner(System.in);
        double fees = input3.nextDouble();

        Slot Reserved_slot = new Slot(startTime, endTime, fees);
        GeneralVisitor generalVisitor = new GeneralVisitor();


        List<Slot> availableslots = GR.getAvailableSlots();
        for (Slot slot : availableslots) {
            System.out.println(slot);
        }

        for (Slot slot : availableslots){


            if (Reserved_slot.startTime .equals(slot.startTime) && Reserved_slot.endTime.equals(slot.endTime)) {
                Reserved_slot.createReservation(generalVisitor);
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
        String startTime=input1.nextLine();

        Scanner input2 = new Scanner(System.in);
        String endTime=input2.nextLine();

        Scanner input3 = new Scanner(System.in);
        double fees=input3.nextDouble();
        Slot Reserved_slot = new Slot(startTime,  endTime,  fees);
        GeneralVisitor generalVisitor = new GeneralVisitor();

        Slot canceled_slot=new Slot (startTime,  endTime,  fees);


        for(Slot slot :GR.slots) {
            if (canceled_slot.startTime.equals(slot.startTime) && canceled_slot.endTime.equals(slot.endTime)) {
                canceled_slot.removeReservation(canceled_slot.createReservation(generalVisitor));
            }
        }
    }
}


