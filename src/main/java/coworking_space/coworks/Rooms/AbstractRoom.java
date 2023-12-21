package coworking_space.coworks.Rooms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import coworking_space.coworks.Visitors.AbstractVisitor;

import java.time.LocalDate;
import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GeneralRoom.class, name = "general"),
        @JsonSubTypes.Type(value = MeetingRoom.class, name = "meeting"),
        @JsonSubTypes.Type(value = TeachingRoom.class, name = "teaching"),
})

abstract public class AbstractRoom
{

    //Attributes//
    public String name;
    protected int id;
    @JsonIgnore
    public String type;
    public ArrayList<Slot> slots;
    public ArrayList<AbstractVisitor> visitors;
    protected int maxNumberOfVisitors;
    protected ArrayList<Slot> availableSlots=new ArrayList<>();
    @JsonIgnore
    public ArrayList<Slot> reservedSlots=new ArrayList<>();
    @JsonIgnore
    public ArrayList<Slot.Reservation> reservationsInDate=new ArrayList<Slot.Reservation>();


    //Methods//
    @JsonIgnore
    public ArrayList<Slot> getAvailableSlots(LocalDate date)
    {
        availableSlots.clear();
        reservedSlots.clear();
        for (Slot slot : slots)
        {
            if (slot.getReservations()!=null) {
                for (Slot.Reservation reservation : slot.getReservations())
                {  //store reservation that exist in the chosen date in ArrayList reservationsInDate
                    if (reservation.getReservationDate().equals(date))
                    {
                        reservationsInDate.add(reservation);
                    }
                }
            }
            // Check if there are no reservations or the slot is not fully reserved at the chosen date
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
    public abstract  ArrayList<Slot> getAvailableSlotsForAdmin();
//    {
//        availableSlots.clear();
//        reservedSlots.clear();
//        for (Slot slot : slots) {
//            // Check if there are no reservations or the slot is not fully reserved
//            if (slot.getReservations().isEmpty() || slot.getReservations().size() < maxNumberOfVisitors)
//            {
//                availableSlots.add(slot);
//            }
//            else
//                reservedSlots.add(slot);
//        }
//        // no available slots
//        if(availableSlots.isEmpty())
//        {
//            return null;
//        }
//        else
//        {
//            return availableSlots;
//        }
//    }


    //Getters

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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //returns ArrayList of AbstractVisitor or any of its subclasses
    @JsonIgnore
    public abstract ArrayList<? extends AbstractVisitor> getVisitors();
}



