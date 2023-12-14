package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeachingRoom extends AbstractRoom{
    public String projecttype;
    public String boardtype;
    public String instractorname;
    public String type;
    public ArrayList<InstructorVisitor> visitors;
    public final int maxNumberOfVisitors = 10;
    @JsonCreator
    public TeachingRoom(@JsonProperty("name") String name, @JsonProperty("id") int id, @JsonProperty("projectType") String projecttype,
                        @JsonProperty("boardType") String boardtype, @JsonProperty("instructorName")String instractorname,
                        @JsonProperty("slots") ArrayList<Slot> slots,
                        @JsonProperty("visitors") ArrayList<InstructorVisitor> visitors)


    {
        this(name,id,slots,visitors);
        this.type="teaching";
        this.projecttype = projecttype;
        this.boardtype = boardtype;
        this.instractorname =instractorname;

    }
    public TeachingRoom(String name, int id, ArrayList<Slot> slots,
                       ArrayList<InstructorVisitor> visitors) {
        this();
        this.type = "teaching";
        this.name=name;
        this.id=id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<InstructorVisitor>();


    }
    public TeachingRoom() {
        this.type = "teaching";
        this.boardtype="B1";
        this.projecttype="P1";
        this.instractorname="alshimaa";
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<InstructorVisitor>();
    }


    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    ArrayList<InstructorVisitor> getVisitors() {
        return visitors;
    }

    @JsonIgnore
    public int getNumOfVisitors(){
        return visitors.size();
    }
    @JsonIgnore
    public ArrayList<Slot> getAvailableSlots(){

        for (Slot slot : slots) {
            // Check if there are no reservations or the slot is not fully reserved
            if (slot.getReservations().isEmpty() || slot.getReservations().size() < maxNumberOfVisitors) {
                availableSlots.add(slot);
            }
            else
                ReservedSlots.add(slot);
        }
        // no available slots.json
        if(availableSlots.isEmpty()){
            return null;
        }
        else{
            return availableSlots;
        }
    }
    @JsonIgnore
    public double getReservationMoney(){
        double totalAmount = 0;

        for (Slot slot : slots) {
            totalAmount += (slot.getReservations().size())*(slot.getFees());
        }
        return totalAmount;
    }

}




