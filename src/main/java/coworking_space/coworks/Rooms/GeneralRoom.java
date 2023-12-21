package coworking_space.coworks.Rooms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import coworking_space.coworks.Visitors.GeneralVisitor;

import java.util.ArrayList;

public class GeneralRoom extends AbstractRoom
{
    //Attributes//
    public final String type = "general";

    public ArrayList<GeneralVisitor> visitors;

    //Class Constructors//
    @JsonCreator
    public GeneralRoom(@JsonProperty("name") String name,
                       @JsonProperty("id") int id,
                       @JsonProperty("slots") ArrayList<Slot> slots,
                       @JsonProperty("visitors") ArrayList<GeneralVisitor> visitors)
    {
        this.name = name;
        this.id = id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<GeneralVisitor>();
        maxNumberOfVisitors=20;
    }

    // Default constructor for Jackson
    public GeneralRoom()
    {
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<GeneralVisitor>();
    }

    @JsonIgnore
    public int getNumOfVisitors() {
        return visitors.size();
    }


    //Getters//
    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    //Implemented Method//
    public ArrayList<GeneralVisitor> getVisitors() {
        return visitors;
    }
//    @JsonIgnore
//    public ArrayList<Slot> getAvailableSlotsForAdmin()
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



}


