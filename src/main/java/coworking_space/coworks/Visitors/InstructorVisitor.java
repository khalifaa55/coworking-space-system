
package coworking_space.coworks.Visitors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import coworking_space.coworks.Coworks_Main;
import coworking_space.coworks.Rooms.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @JsonIgnore
    public ArrayList DisplayReservation(AbstractRoom room) {

        TeachingRoom TR = (TeachingRoom) room;
        for(Slot slot:TR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorEmail = r.getVisitor().userEmail;
                if ((cVisitor.userEmail).equals(visitorEmail)) {
                    IuserResrvations.add(slot);

                    System.out.println(slot.getStartTime());
                    System.out.println(slot.getEndTime());
                    System.out.println(slot.getFees());

                }
            }
        }
        return IuserResrvations;

    }

    public void makeReservation(AbstractRoom room, LocalDate date, String startTime, String endTime, int id) {

        if(room instanceof TeachingRoom){
            System.out.println(" instance of teaching room ");
        }else if (room instanceof MeetingRoom){
            System.out.println(" instance of Meeting room ");
        }else if (room instanceof GeneralRoom){
            System.out.println(" instance of General room ");
        }else{
            System.out.println(" instance of abstract room ");
        }


        if (room instanceof TeachingRoom) {
            TeachingRoom TR = (TeachingRoom) room;
            ArrayList<Slot> availableSlots = TR.getAvailableSlots(date);

            for (Slot slot : availableSlots) {
                if (startTime.equals(slot.getStartTime()) && endTime.equals(slot.getEndTime())) {
                    slot.createReservation(cVisitor, date, id);
                    InstructorVisitor v = (InstructorVisitor) cVisitor;
                    TR.visitors.add(v);

                    if (TR.getId() == 4) {
                        Coworks_Main.insts = TR.visitors;
                    } else if (TR.getId() == 5) {
                        Coworks_Main.insts2 = TR.visitors;
                    } else {
                        Coworks_Main.insts3 = TR.visitors;
                    }
                    System.out.println("Reservation Made successfully");
                    break;
                }
            }
        } else {
            // Handle the case where room is not a MeetingRoom
            System.out.println("Room is not a MeetingRoom");
        }
    }



    public void cancelReservation(AbstractRoom Room,String startTime,String endTime) {

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


