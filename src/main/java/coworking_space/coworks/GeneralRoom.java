package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneralRoom extends AbstractRoom
{
    //Attributes//
    public String type;
    public final int maxNumberOfVisitors = 20;
    public ArrayList<GeneralVisitor> visitors;

    //Class Constructors//
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
    public GeneralRoom() {
        this.type = "general";
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<GeneralVisitor>();
    }

    //Getters//
    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }
    public ArrayList<GeneralVisitor> getVisitors() {
        return visitors;
    }

    //Implemented Methods//
    @JsonIgnore
    public ArrayList<Slot> getAvailableSlots()
    {
        for (Slot slot : slots)
        {
            // Check if there are no reservations or the slot is not fully reserved
            if (slot.getReservations().isEmpty() || slot.getReservations().size() < maxNumberOfVisitors)
            {
                availableSlots.add(slot);
            }
            else
                ReservedSlots.add(slot);
        }
        // No available slots
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
    public double getReservationMoney()
    {
        double totalAmount = 0;
        for (Slot slot : slots) //get number of reservations * its fees
        {
            totalAmount += (slot.getReservations().size()) * (slot.getFees());
        }
        return totalAmount;
    }
}


