import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GeneralRoom.class, name = "general"),
        @JsonSubTypes.Type(value = TeachingRoom.class, name = "teaching"),

})
abstract public class AbstractRoom {
    public String name;
    public int id;
    public int maxNumberOfVisitors;
    public ArrayList<Slot> slots;
    public ArrayList<AbstractVisitor> visitors;

    public AbstractRoom() {
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    public abstract ArrayList<Slot> getAvailableSlots();
    public abstract int getNumOfVisitors();
    public abstract double getReservationMoney();

}
