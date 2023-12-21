package coworking_space.coworks.Visitors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import coworking_space.coworks.Rooms.AbstractRoom;
import coworking_space.coworks.Rooms.GeneralRoom;
import coworking_space.coworks.Rooms.Slot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static coworking_space.coworks.DisplayUserDataController.cVisitor;


public class GeneralVisitor extends AbstractVisitor {
    public  static ArrayList<Slot> GuserResrvations =new ArrayList<>();

    //Class Constructors//
    @JsonCreator
    public GeneralVisitor(
                          @JsonProperty("name") String name,
                          @JsonProperty("password")String password,
                          @JsonProperty("id") int id,
                          @JsonProperty("userEmail") String Email,
                          @JsonProperty("phoneNumber") String phoneNumber) {
        this.type="general";
        this.name = name;
        this.id = id;
        this.password = password;
        this.userEmail=Email;
        this.phoneNumber=phoneNumber;
    }
    public GeneralVisitor(String name, int id) {
        this.type="general";
        this.name = name;
        this.id = id;
    }
    @JsonCreator
    public GeneralVisitor() {

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
    public static GeneralVisitor createVisitorFromRegistration(Registration registration) {
        return new GeneralVisitor(registration.getUserName(), registration.getNewPassword(), registration.userid(),registration.getUserEmail(), registration.getPhoneNumber());
    }
    @Override
    public ArrayList DisplayReservation(AbstractRoom room) {
        GeneralRoom gene = (GeneralRoom) room;

        for(Slot slot:gene.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorEmail = r.getVisitor().userEmail;
                if ((cVisitor.userEmail).equals(visitorEmail)) {
                    GuserResrvations.add(slot);
                    System.out.println(slot.getStartTime());
                    System.out.println(slot.getEndTime());
                }
            }
        }
        return GuserResrvations;

    }
    public void makeReservation(AbstractRoom room, LocalDate date, String startTime, String endTime, int id) {

        GeneralRoom GR = (GeneralRoom) room;



        List<Slot> availableslots = GR.getAvailableSlots(date);


        for (Slot slot : availableslots){

            if (startTime .equals(slot.getStartTime()) && endTime.equals(slot.getEndTime())) {
                slot.createReservation(cVisitor,date , id );
                break;
            }
        }
    }



    public void cancelReservation(AbstractRoom Room,String startTime,String endTime) {

        GeneralRoom GR= (GeneralRoom) Room;

        for (Slot slot : GR.slots) {
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
