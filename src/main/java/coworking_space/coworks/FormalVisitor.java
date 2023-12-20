package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static coworking_space.coworks.DisplayUserDataController.cVisitor;

@JsonTypeName("formal")
public class FormalVisitor extends AbstractVisitor {
    public  static ArrayList<Slot> FuserResrvations =new ArrayList<>();


    //Class Constructors//

    @JsonCreator
    public FormalVisitor(@JsonProperty("name") String name,
                          @JsonProperty("password")String password,
                          @JsonProperty("id") int id,
                          @JsonProperty("userEmail") String Email,
                          @JsonProperty("phoneNumber") String phoneNumber) {
        this.type="formal";
        this.name = name;
        this.id = id;
        this.password = password;
        this.userEmail=Email;
        this.phoneNumber=phoneNumber;
    }
    public FormalVisitor(String name, int id) {
        this.type="formal";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public FormalVisitor() {
    }

    //Getters//
    public String getPassword(){
        return this.password;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
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
        return new FormalVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),registration.getUserEmail(), registration.getPhoneNumber());
    }

    @Override
    protected ArrayList<Slot> DisplayReservation(AbstractRoom room,Registration currentr) {
        MeetingRoom MR = (MeetingRoom) room;

        for(Slot slot:MR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorName = r.getVisitor().userEmail;
                if(currentr.getUserEmail().equals(visitorName)){
                    FuserResrvations.add(slot);
                    System.out.println(slot.startTime);
                    System.out.println(slot.endTime);
                }
            }
        }
        return FuserResrvations;

    }
    protected void makeReservation(AbstractRoom room, LocalDate date,String startTime,String endTime, int id) {
        //AbstractRoom room= new TeachingRoom();
       // System.out.println("Size of meetingRooms: " + meetingRooms.size());

        MeetingRoom MR = (MeetingRoom) room;

        List<Slot> availableslots = MR.getAvailableSlots(date);




        for (Slot slot : availableslots) {
            if (startTime.equals( slot.startTime) & endTime.equals(slot.endTime) ) {
                slot.createReservation(cVisitor,date,id );
                System.out.println("Reservation Made successfully");
                break;
            }
        }


    }



    public void cancelReservation(AbstractRoom Room,Registration cuurentr,String startTime,String endTime) {

        MeetingRoom MR= (MeetingRoom)Room;
        for (Slot slot : MR.slots) {
            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                for (Slot.Reservation r : slot.getReservations()) {
                    String visitorEmail = r.getVisitor().userEmail;
                    if ((cVisitor.userEmail).equals(visitorEmail)) {
                        slot.removeReservation(r);
                        // Optionally add a message or confirmation of cancellation
                        System.out.println("Reservation canceled successfully!");
                        return; // Exit the method after canceling the reservation
                    }
                }
            }
        }
    }
}


