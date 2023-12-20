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
    public int maxNumberOfVisitors = 20;
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
    }

    // Default constructor for Jackson
    public GeneralRoom()
    {
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<GeneralVisitor>();
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
}


