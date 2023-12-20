
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

public class InstructorVisitor extends AbstractVisitor {
    public  static ArrayList<Slot> IuserResrvations =new ArrayList<>();

    //Class Constructors//

    @JsonCreator
    public InstructorVisitor(@JsonProperty("name") String name,
                          @JsonProperty("password")String password,
                          @JsonProperty("id") int id,
                          @JsonProperty("userEmail") String Email,
                          @JsonProperty("phoneNumber") String phoneNumber) {
        this.type="instructor";
        this.name = name;
        this.id = id;
        this.password = password;
        this.userEmail=Email;
        this.phoneNumber=phoneNumber;
    }
    public InstructorVisitor(String name,
                            int id) {
        this.type="instructor";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public InstructorVisitor() {
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
    public static InstructorVisitor createVisitorFromRegistration(Registration registration) {
        return new InstructorVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),registration.getUserEmail(), registration.getPhoneNumber());
    }

    @Override
    protected ArrayList DisplayReservation(AbstractRoom room , Registration currentr) {

        TeachingRoom TR = (TeachingRoom) room;
        for(Slot slot:TR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorEmail = r.getVisitor().userEmail;
                if(currentr.getUserEmail().equals(visitorEmail)){
                    IuserResrvations.add(slot);

                    System.out.println(slot.getStartTime());
                    System.out.println(slot.getEndTime());
                    System.out.println(slot.getFees());

                }
            }
        }
        return IuserResrvations;

    }

    protected void makeReservation(AbstractRoom room , LocalDate date,String startTime,String endTime,int id) {
        //AbstractRoom room= new TeachingRoom();

        TeachingRoom TR = (TeachingRoom) room;

        List<Slot> availableslots = TR.getAvailableSlots(date);



        for (Slot slot : availableslots) {
            if (startTime.equals( slot.startTime) & endTime.equals(slot.endTime) ) {
                slot.createReservation(cVisitor,date, id );
                break;
            }
        }

    }



    public void cancelReservation(AbstractRoom Room, Registration currentr,String startTime,String endTime) {

        TeachingRoom TR= (TeachingRoom) Room;
        for (Slot slot : TR.slots) {
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


