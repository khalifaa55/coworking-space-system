package coworking_space.coworks;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.Scanner;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = GeneralRoom.class, name = "general"),
        @JsonSubTypes.Type(value = TeachingRoom.class, name = "teaching"),

})

abstract public class AbstractRoom implements UpdatableRoom {
    public String name;
    public int id;
    public String type;
    public int maxNumberOfVisitors;
    public ArrayList<Slot> slots;
    public ArrayList<AbstractVisitor> visitors;
    ArrayList<Slot> availableSlots=new ArrayList<>();
    ArrayList<Slot> ReservedSlots=new ArrayList<>();

    public AbstractRoom() {
        this.slots = new ArrayList<>();
        this.visitors = new ArrayList<>();
    }

    public abstract ArrayList<Slot> getAvailableSlots();
    public abstract ArrayList<Slot> getReservedSlots();
    public abstract int getNumOfVisitors();
    public abstract double getReservationMoney();
    public String getRoomType(){
        return type;
    }
    abstract ArrayList<? extends AbstractVisitor> getVisitors();

    @Override
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name=name;
    }

//    @Override
public void updateVisitors(AbstractVisitor visitor  , AbstractRoom Room) {
    int Case;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter The Choice : \n1-ID \t 2-name\n 3-type :\n");
    Case = scanner.nextInt();
////////////////// Update the Visitor Info ////////////////////
    switch (Case){
        case 1:
            System.out.println("Enter The new Id");
            visitor.id = scanner.nextInt();
            break;
        case 2:
            System.out.println("Enter The new name");
            visitor.name = scanner.next();
            break;
        case 3:
            System.out.println("Enter The new Type");
            visitor.type = scanner.next();
            break;
    }
    System.out.println("The Data Of THE Visitors After The Update : \n");
    //////////////////////Update the reservation ///////////////////////
}
    public void updateSlots(Slot slot , AbstractRoom Room) {
        int Case;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Choice You want to Update : \n");
        System.out.println("1_ Start Time \n 2_ End Time \n 3_ Fees \n");
        Case = scanner.nextInt();
        switch (Case){
            case 1:
                System.out.println("Enter The new Start Time : \n");
                slot.setStartTime(scanner.next());
                break;
            case 2:
                System.out.println("Enter The new End Time : \n");
                slot.setEndTime(scanner.next());
                break;
            case 3:
                System.out.println("Enter The new Fees : \n");
                slot.setFees(scanner.nextDouble());
                break;
        }
    }
//    @Override

}
