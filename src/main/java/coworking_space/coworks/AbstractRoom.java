package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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
    public int id;
    @JsonIgnore
    public String type;
    public ArrayList<Slot> slots;
    public ArrayList<AbstractVisitor> visitors;
    ArrayList<Slot> availableslots=new ArrayList<>();
    ArrayList<Slot> reservedslots=new ArrayList<>();
    ArrayList<Slot> availableSlots=new ArrayList<>();
    ArrayList<Slot> ReservedSlots=new ArrayList<>();

    //Methods//
    public abstract ArrayList<Slot> getAvailableSlots(LocalDate date);
    public abstract int getNumOfVisitors();
    public abstract double getReservationMoney();
    @JsonIgnore public String getRoomType(){
        return type;
    }
    @JsonIgnore abstract ArrayList<? extends AbstractVisitor> getVisitors();
    public  abstract ArrayList<Slot> getAvailableSlotsForAdmin();



}



