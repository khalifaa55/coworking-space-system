package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeachingRoom extends AbstractRoom{

    public String projecttype;
    public String boardtype;
    public String instructorname;
    public final String type = "teaching";
    public ArrayList<InstructorVisitor> visitors;
    public final int maxNumberOfVisitors = 10;
    @JsonCreator
    public TeachingRoom(@JsonProperty("name") String name, @JsonProperty("id") int id, @JsonProperty("projectType") String projecttype,
                        @JsonProperty("boardType") String boardtype, @JsonProperty("instructorName")String instractorname,
                        @JsonProperty("slots") ArrayList<Slot> slots,
                        @JsonProperty("visitors") ArrayList<InstructorVisitor> visitors)


    {
        this(name,id,slots,visitors);
        this.projecttype = projecttype;
        this.boardtype = boardtype;
        this.instructorname =instructorname;

    }
    public TeachingRoom(String name, int id, ArrayList<Slot> slots,
                       ArrayList<InstructorVisitor> visitors) {
        this();
        this.name=name;
        this.id=id;
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<InstructorVisitor>();


    }
    public TeachingRoom() {
        this.boardtype="B1";
        this.projecttype="P1";
        this.instructorname ="alshimaa";
        this.slots = (slots != null) ? slots : new ArrayList<Slot>();
        this.visitors = (visitors != null) ? visitors : new ArrayList<InstructorVisitor>();
    }


    @JsonProperty("slots")
    public ArrayList<Slot> getSlots() {
        return slots;
    }

    ArrayList<InstructorVisitor> getVisitors() {
        return visitors;
    }
}




