package coworking_space.coworks;

/*import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("Meeting")
public class MeetingRoom extends AbstractRoom {
    public final int maxNumberOfVisitors = 3;
    ArrayList<FormalVisitor> visitors;
//    ArrayList<Slot> ReservedSlots=new ArrayList<>();

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
    }

    @JsonCreator
    public MeetingRoom() {
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<FormalVisitor>();
    }


    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    @JsonProperty("visitors")
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
        // no available slots
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



 */
