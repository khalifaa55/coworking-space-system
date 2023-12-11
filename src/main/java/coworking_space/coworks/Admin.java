package coworking_space.coworks;

import java.util.ArrayList;
import java.util.Scanner;

public class    Admin {
    private final String Admin_Name = "Admin";
    private final String Admin_Password = "Admin";
    //    public static   ArrayList<Slot> availableSlots=new ArrayList<>();
    public void addSlot(AbstractRoom room, Slot slot) {
        // Check if the room and slots are not null and the room has at least one slot
        if (room != null ) {
            // Set the start time of the first slot to "2"
            room.slots.add(slot);
        }
    }
    void displayAllAvailableSlots(AbstractRoom room ) {
        ArrayList<Slot> availableSlots= room.getAvailableSlots();
        for (Slot slot : availableSlots) {
            if (availableSlots != null && !availableSlots.isEmpty()) {
                System.out.println("Start Time: " + slot.getStartTime());
                System.out.println("End Time: " + slot.getEndTime());
                System.out.println("Fees : " + slot.getFees());
                System.out.println("\n");

            } else {
                System.out.println("No available slots");
            }
        }
    }

    public static void displayRoomVisitors(AbstractRoom room) {
        System.out.println("Visitors in " + room.getRoomType() + ":");
        int no = 1;
        for (AbstractVisitor visitor : room.getVisitors()) {
            System.out.println("The " + no + " visitor Id: " + visitor.id);
            System.out.println("The " + no + " visitor Name: " + visitor.name);
            // You can't call getVisitorType() without a common interface, so omitting it in this example
            System.out.println();
            no++;
        }
    }




    void DisplayRoomSlots(AbstractRoom Room)
    {
//        System.out.print("There is no Slots : ");
        int i=1;
        for( Slot slot : Room.slots){
            System.out.println( "The "+ i +" Slot Start Time : "+ slot.getStartTime());
            System.out.println( "The "+ i +" Slot End Time : "+ slot.getEndTime());
            System.out.println( "The "+ i +" Slot Fees  : "+ slot.getFees());
            i++;
        }
    }
    void DisplayRoomsData(AbstractRoom Room) {
        System.out.println("The Room ID : "+Room.id);
        System.out.println("The Room Name : "+Room.name);
        if(Room instanceof TeachingRoom)
        {
            TeachingRoom TR= (TeachingRoom) Room;

            System.out.println("The Room Max Number OF Visitors  : "+TR.maxNumberOfVisitors);
            System.out.println("The Type Of The Board : "+TR.boardtype);
            System.out.println("The Instructor Name : "+TR.instractorname);
            System.out.println("The Projector Type : "+TR.projecttype);
        } else if (Room instanceof GeneralRoom) {
            GeneralRoom Gr = (GeneralRoom) Room;
            System.out.println("The Room Max Number OF Visitors  : "+Gr.maxNumberOfVisitors);
        }
        else
        {
            MeetingRoom Mr = (MeetingRoom) Room;
            System.out.println("The Room Max Number OF Visitors  : "+Mr.maxNumberOfVisitors);
            ArrayList<Slot> Reserved = Mr.getReservedSlots();
            for(Slot rslot:Reserved)
            {
                System.out.println("Start Time: " + rslot.getStartTime());
                System.out.println("End Time: " + rslot.getEndTime());
                System.out.println("Fees: " + rslot.getFees());
                System.out.println();
            }

        }
        System.out.println();

        ArrayList<Slot> AvailableSlots = Room.getAvailableSlots();

        System.out.println("The Reserved Slots are : \n");



        System.out.println("The available Slots are : ");
        for(Slot aslot:AvailableSlots)
        {
            System.out.println("Start Time: " + aslot.getStartTime());
            System.out.println("End Time: " + aslot.getEndTime());
            System.out.println("Fees: " + aslot.getFees());
            System.out.println();
        }

        System.out.printf("\n");

        displayRoomVisitors(Room);
    }



    void displayInstructors(ArrayList<TeachingRoom> Rooms) {
        int no_=1;
        for (TeachingRoom r : Rooms) {
//            TeachingRoom teachingRoom = (TeachingRoom) r;
            System.out.println("Instructors in The "+no_+" Room : \n");
            ArrayList<InstructorVisitor> Ins = r.visitors;
            int no_0 = 1;
            for (InstructorVisitor ins : Ins) {
                System.out.println("The " + no_0 + " Instructor Name : " + ins.name);
                System.out.println("The " + no_0 + " Instructor ID : " + ins.id);
                System.out.println();
                no_0++;
            }
            no_++;

        }
    }

//    void DisplayVisitorData(AbstractVisitor visitor, AbstractRoom Room) {
//        visitor.
//     visitor.DisplayReservation(Room);}


    double CalcRoom_Profit(AbstractRoom Room) {
        double Profit = Room.getReservationMoney();
        return Profit;
    }

    void UpdateRoom(AbstractRoom Room ) {
//        TeachingRoom TR = (TeachingRoom) Room;
        int Case;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Ypur Choice : \n1-ID \t2-name \n3-visitors\t4-Slots :\n");

        Case = scanner.nextInt();
        switch (Case) {
            case 1:
                System.out.println("Enter The new Room Id : ");
                Room.setId(scanner.nextInt());
                break;
            case 2:
                System.out.println("Enter The new Room name");
                Room.setName(scanner.next());
                break;
            case 3:
                displayRoomVisitors(Room);
                System.out.println("Enter the visitor Number : ");
                Room.updateVisitors(Room.visitors.get((scanner.nextInt())-1) , Room);
                break;
            case 4:
                DisplayRoomSlots(Room);
                System.out.println("Enter The Slot number : ");

                Room.updateSlots(Room.slots.get((scanner.nextInt())-1) , Room);
                break;
        }
        System.out.println("The Data Of The Room After The Update : \n");
        DisplayRoomsData(Room);
    }
//
    void UpdateVisitor(AbstractVisitor visitor  , AbstractRoom Room) {
//        int Case;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter The Choice : \n1-ID \t 2-name\n 3-type :\n");
//        Case = scanner.nextInt();
//////////////////// Update the Visitor Info ////////////////////
//        switch (Case){
//            case 1:
//                System.out.println("Enter The new Id");
//                visitor.id = scanner.nextInt();
//                break;
//            case 2:
//                System.out.println("Enter The new name");
//                visitor.name = scanner.next();
//                break;
//            case 3:
//                System.out.println("Enter The new Type");
//                visitor.type = scanner.next();
//                break;
//        }
        System.out.println("The Data Of THE Visitors After The Update : \n");
        displayRoomVisitors(Room);
        //////////////////////Update the reservation ///////////////////////
    }

    void UpdateSlot(Slot slot , AbstractRoom Room) {
//        int Case;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter The Choice You want to Update : \n");
//        System.out.println("1_ Start Time \n 2_ End Time \n 3_ Fees \n");
//        Case = scanner.nextInt();
//        switch (Case){
//            case 1:
//                System.out.println("Enter The new Start Time : \n");
//                slot.setStartTime(scanner.next());
//                break;
//            case 2:
//                System.out.println("Enter The new End Time : \n");
//                slot.setEndTime(scanner.next());
//                break;
//            case 3:
//                System.out.println("Enter The new Fees : \n");
//                slot.setFees(scanner.nextDouble());
//                break;
//        }
        System.out.println("The Data Of The Slots After The Update : \n");
        DisplayRoomSlots(Room);
    }

    void DeleteRoom(int RoomId, ArrayList<AbstractRoom> Rooms ) {

        for (int i = 0; i < Rooms.size(); i++) {
            if (Rooms.get(i).id == RoomId) {
                Rooms.remove(i);
            }
        }
        for(AbstractRoom R:Rooms)
        {
            DisplayRoomsData(R);
        }

    }
    void DeleteVisitor(AbstractVisitor Visitor , AbstractRoom Room) {
        if(Room instanceof TeachingRoom) {
            TeachingRoom Tr = (TeachingRoom)Room;
            ArrayList<InstructorVisitor> allVisitors = Tr.visitors;
            for (int i = 0; i < allVisitors.size(); i++) {
                if (Visitor.equals(allVisitors.get(i))) {
                    allVisitors.remove(i);
                    break;
                }
            }
        }
        else if(Room instanceof GeneralRoom)
        {
            GeneralRoom Gr = (GeneralRoom)Room;
            ArrayList<GeneralVisitor> allVisitors = Gr.visitors;
            for (int i = 0; i < allVisitors.size(); i++) {
                if (Visitor.equals(allVisitors.get(i))) {
                    allVisitors.remove(i);
                    break;
                }
            }
        }
        else
        {
            MeetingRoom Mr = (MeetingRoom)Room;
            ArrayList<FormalVisitor> allVisitors = Mr.visitors;
            for (int i = 0; i < allVisitors.size(); i++) {
                if (Visitor.equals(allVisitors.get(i))) {
                    allVisitors.remove(i);
                    break;
                }
            }
        }


        displayRoomVisitors(Room);
    }
    public void deleteSlot(Slot S, AbstractRoom Room) {
        ArrayList<Slot> allSlots = Room.slots;

        for (int i = 0; i < allSlots.size(); i++) {
            if (S.equals(allSlots.get(i))) {
                allSlots.remove(i);
                break;
            }
        }
        DisplayRoomSlots(Room);
    }
}
