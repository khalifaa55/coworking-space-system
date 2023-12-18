package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneralRoom extends AbstractRoom
{
    //Attributes//
    public final String type = "general";
    public final int maxNumberOfVisitors = 2;
    public ArrayList<GeneralVisitor> visitors;

    //Class Constructors//
    @JsonCreator
    public GeneralRoom(@JsonProperty("name") String name,
                       @JsonProperty("id") int id,
                       @JsonProperty("slots") ArrayList<Slot> slots,
                       @JsonProperty("visitors") ArrayList<GeneralVisitor> visitors) {
        this.name = name;
        this.id = id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<GeneralVisitor>();
    }

    // Default constructor for Jackson
    public GeneralRoom() {
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
    public ArrayList<Slot> getAvailableSlots(LocalDate date)
    {
        for (Slot slot : slots)
        {
            ArrayList<Slot.Reservation> reservationsInDate=new ArrayList<Slot.Reservation>();
            for(Slot.Reservation reservation : slot.getReservations()){
                if(reservation.getDate().equals(date)){
                    reservationsInDate.add(reservation);
                }

            }
            // Check if there are no reservations or the slot is not fully reserved
            if (reservationsInDate.isEmpty() ||reservationsInDate.size() < maxNumberOfVisitors)
            {
                availableSlots.add(slot);
            }
            else
                reservedSlots.add(slot);
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
    @JsonIgnore
    public ArrayList<Slot> getAvailableSlotsForAdmin(){

        for (Slot slot : slots) {
            // Check if there are no reservations or the slot is not fully reserved
            if (slot.getReservations().isEmpty() || slot.getReservations().size() < maxNumberOfVisitors) {
                availableSlots.add(slot);
            }
            else
                reservedSlots.add(slot);
        }
        // no available slots.json
        if(availableSlots.isEmpty()){
            return null;
        }
        else{
            return availableSlots;
        }
    }

}


