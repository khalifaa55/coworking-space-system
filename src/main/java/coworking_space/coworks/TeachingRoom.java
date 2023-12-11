package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@JsonTypeName("teaching")


public class TeachingRoom extends AbstractRoom{
    public String projecttype;
    public String boardtype;
    public String instractorname;
    public String type;
    ArrayList<InstructorVisitor> visitors;
    public final int maxNumberOfVisitors = 2;
    public TeachingRoom(@JsonProperty("name") String name, @JsonProperty("id") int id, @JsonProperty("projecttype") String projecttype,
                        @JsonProperty("boardtype") String boardtype, @JsonProperty("instractorname")String instractorname,
                        @JsonProperty("slots") ArrayList<Slot> slots,
                        @JsonProperty("visitors") ArrayList<InstructorVisitor> visitors)


    {
        this(name,id,slots,visitors);
        this.type="teaching";
        this.projecttype = projecttype;
        this.boardtype = boardtype;
        this.instractorname =instractorname;

    }
    public TeachingRoom(@JsonProperty("name") String name, @JsonProperty("id") int id,
                        @JsonProperty("slots") ArrayList<Slot> slots,
                        @JsonProperty("visitors") ArrayList<InstructorVisitor> visitors) {
        this();

        this.name=name;
        this.id=id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<InstructorVisitor>();


    }
    @JsonCreator
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

    @JsonProperty("visitors")
    @Override
    ArrayList<InstructorVisitor> getVisitors() {
        return visitors;
    }
    @JsonProperty
    public String getType() {
        return type;
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
        // no available slots
        if(availableSlots.isEmpty()){
            return null;
        }
        else{
            return availableSlots;
        }
    }
//    public ArrayList<Slot> getReservedSlots()
//    {
//        return ReservedSlots;
//    }
    @JsonIgnore
    public double getReservationMoney(){
        double totalAmount = 0;

        for (Slot slot : slots) {
            totalAmount += (slot.getReservations().size())*(slot.getFees());
        }
        return totalAmount;
    }

}




