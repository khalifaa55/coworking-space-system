package coworking_space.coworks.Visitors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import coworking_space.coworks.Coworks_Main;
import coworking_space.coworks.Rooms.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @JsonIgnore
    public ArrayList<Slot> DisplayReservation(AbstractRoom room) {
        MeetingRoom MR = (MeetingRoom) room;

        for(Slot slot:MR.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorEmail = r.getVisitor().userEmail;
                if ((cVisitor.userEmail).equals(visitorEmail)) {
                    FuserResrvations.add(slot);
                    System.out.println(slot.getStartTime());
                    System.out.println(slot.getEndTime());
                }
            }
        }
        return FuserResrvations;

    }
    public void makeReservation(AbstractRoom room, LocalDate date, String startTime, String endTime, int id) {

        if(room instanceof TeachingRoom){
            System.out.println(" instance of teaching room ");


        }else if (room instanceof MeetingRoom){
            System.out.println(" instance of Meeting room ");
            MeetingRoom MR = (MeetingRoom) room;
            ArrayList<Slot> availableSlots = MR.getAvailableSlots(date);

            for (Slot slot : availableSlots) {
                if (startTime.equals(slot.getStartTime()) && endTime.equals(slot.getEndTime())) {
                    slot.createReservation(cVisitor, date, id);
                    FormalVisitor v = (FormalVisitor) cVisitor;
                    MR.visitors.add(v);

                    if (MR.getId() == 1) {
                        Coworks_Main.formals = MR.visitors;
                    } else if (MR.getId() == 2) {
                        Coworks_Main.formals2 = MR.visitors;
                    } else {
                        Coworks_Main.formals3 = MR.visitors;
                    }
                    System.out.println("Reservation Made successfully");
                    break;
                }
            }

        }else if (room instanceof GeneralRoom){
            System.out.println(" instance of General room ");


        }else{
            System.out.println(" instance of abstract room ");
        }

//        if (room instanceof MeetingRoom) {
//            MeetingRoom MR = (MeetingRoom) room;
//            ArrayList<Slot> availableSlots = MR.getAvailableSlots(date);
//
//            for (Slot slot : availableSlots) {
//                if (startTime.equals(slot.getStartTime()) && endTime.equals(slot.getEndTime())) {
//                    slot.createReservation(cVisitor, date, id);
//                    FormalVisitor v = (FormalVisitor) cVisitor;
//                    MR.visitors.add(v);
//
//                    if (MR.getId() == 1) {
//                        Coworks_Main.formals = MR.visitors;
//                    } else if (MR.getId() == 2) {
//                        Coworks_Main.formals2 = MR.visitors;
//                    } else {
//                        Coworks_Main.formals3 = MR.visitors;
//                    }
//                    System.out.println("Reservation Made successfully");
//                    break;
//                }
//            }
//        } else {
//            // Handle the case where room is not a MeetingRoom
//            System.out.println("Room is not a MeetingRoom");
//        }
    }


//    public  static  void getFormals(ArrayList<FormalVisitor> v)
//    {
//        Coworks_Main.formals=v;
//    }


    public void cancelReservation(AbstractRoom Room,String startTime,String endTime) {

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


