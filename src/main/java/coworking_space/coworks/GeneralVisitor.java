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


public class GeneralVisitor extends AbstractVisitor{
    @JsonProperty("type")
    public String type;
    public  static ArrayList<Slot> GuserResrvations =new ArrayList<>();

    //Class Constructors//

    public GeneralVisitor( String name, String password, int id, String type) {
        this.type = type;
        this.name = name;
        this.id = id;
        this.password = password;
    }
    @JsonCreator
    public GeneralVisitor(@JsonProperty("name")String name,
                          @JsonProperty("id") int id) {
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
    protected ArrayList DisplayReservation(AbstractRoom room , Registration currentr) {
        GeneralRoom gene = (GeneralRoom) room;

        for(Slot slot:gene.getSlots()){
            for(Slot.Reservation r:slot.getReservations()){
                String visitorName = r.getVisitor().userEmail;
                if(currentr.getUserEmail().equals(visitorName)){
                    GuserResrvations.add(slot);
                    System.out.println(slot.startTime);
                    System.out.println(slot.endTime);
                }
            }
        }
        return GuserResrvations;

    }
    protected void makeReservation(AbstractRoom room , LocalDate date , String startTime , String endTime) {

        GeneralRoom GR = (GeneralRoom) room;
        GeneralVisitor generalVisitor = new GeneralVisitor();


        List<Slot> availableslots = GR.getAvailableSlots(date);


        for (Slot slot : availableslots){

            if (startTime .equals(slot.startTime) && endTime.equals(slot.endTime)) {
                slot.createReservation(generalVisitor);
            }
        }
    }

    protected void updateReservation(AbstractRoom Room, LocalDate date,String startTime,String endTime,Registration currentr) {

        GeneralRoom GR= (GeneralRoom)Room;
        //cancelReservation(GR,currentr);
        makeReservation(GR,date,startTime,endTime);

    }

    public void cancelReservation(AbstractRoom Room,Registration currentr,String startTime,String endTime) {

        GeneralRoom GR= (GeneralRoom) Room;

        for (Slot slot : GR.slots) {
            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                for (Slot.Reservation r : slot.getReservations()) {
                    String visitorEmail = r.getVisitor().userEmail;
                    if (currentr.getUserEmail().equals(visitorEmail)) {
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
