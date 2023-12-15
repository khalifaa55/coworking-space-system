package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MeetingRoom extends AbstractRoom {
    public String type;
    public final int maxNumberOfVisitors = 10;
    public ArrayList<FormalVisitor> visitors;

    @JsonCreator
    public MeetingRoom(@JsonProperty("name") String name,
                       @JsonProperty("id") int id,
                       @JsonProperty("slots") ArrayList<Slot> slots,
                       @JsonProperty("visitors") ArrayList<FormalVisitor> visitors) {
        this();
        this.type="meeting";
        this.name = name;
        this.id = id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<FormalVisitor>();
    }

    public MeetingRoom() {
        this.type="meeting";
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<FormalVisitor>();
    }


    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public ArrayList<FormalVisitor> getVisitors() {
        return visitors;
    }

    @JsonIgnore
    public ArrayList<Slot> getAvailableSlots() {
//        ArrayList<Slot> availableSlots = new ArrayList<>();
        for (Slot slot : slots) {
            // Check if there are no reservations or the slot is not fully reserved
            if (slot.getReservations().isEmpty() || slot.getReservations().size() < maxNumberOfVisitors) {
                availableSlots.add(slot);
            }
            else
                ReservedSlots.add(slot);
        }
        // no available slots.json
        if (availableSlots.isEmpty()) {
            return null;
        } else {
            return availableSlots;
        }
    }

    @JsonIgnore
    public int getNumOfVisitors(){
        return visitors.size();
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





