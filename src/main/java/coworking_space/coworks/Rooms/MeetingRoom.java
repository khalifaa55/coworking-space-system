package coworking_space.coworks.Rooms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import coworking_space.coworks.Rooms.AbstractRoom;
import coworking_space.coworks.Rooms.Slot;
import coworking_space.coworks.Visitors.FormalVisitor;

import java.util.ArrayList;


public class MeetingRoom extends AbstractRoom {
    public final String type = "meeting";
//    public final int maxNumberOfVisitors = 10;
    public  ArrayList<FormalVisitor> visitors;

    @JsonCreator
    public MeetingRoom(@JsonProperty("name") String name,
                       @JsonProperty("id") int id,
                       @JsonProperty("slots") ArrayList<Slot> slots,
                       @JsonProperty("visitors") ArrayList<FormalVisitor> visitors) {
        this();
        this.name = name;
        this.id = id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<FormalVisitor>();
        maxNumberOfVisitors=10;
    }

    public MeetingRoom() {
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
//    @JsonIgnore
//    public  ArrayList<Slot> getAvailableSlotsForAdmin()
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
    @JsonIgnore
    public int getNumOfVisitors() {
        return visitors.size();
    }

}





