package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.Scanner;


@JsonTypeName("general")
public class GeneralRoom extends AbstractRoom {

    public String type;
    public final int maxNumberOfVisitors = 20;
    ArrayList<GeneralVisitor> visitors;
    ArrayList<Slot> ReservedSlots = new ArrayList<>();


    @JsonCreator
    public GeneralRoom(@JsonProperty("name") String name,
                       @JsonProperty("id") int id,
                       @JsonProperty("slots") ArrayList<Slot> slots,
                       @JsonProperty("visitors") ArrayList<GeneralVisitor> visitors) {
        this.type="general";
        this.name = name;
        this.id = id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<GeneralVisitor>();
    }

    // Default constructor for Jackson
    @JsonCreator
    public GeneralRoom() {
        this.type = "general";
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<GeneralVisitor>();
    }

    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    @JsonProperty("visitors")
    public ArrayList<GeneralVisitor> getVisitors() {
        return visitors;
    }
    @JsonProperty
    public String getType() {
        return type;
    }


    @JsonIgnore
    public ArrayList<Slot> getAvailableSlots() {

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
    public int getNumOfVisitors() {
        return visitors.size();
    }

    @JsonIgnore
    public double getReservationMoney() {
        double totalAmount = 0;

        for (Slot slot : slots) {
            totalAmount += (slot.getReservations().size()) * (slot.getFees());
        }
        return totalAmount;
    }
//    public ArrayList<Slot>getReservedSlots()
//    {
//        return ReservedSlots;
//    }


}


