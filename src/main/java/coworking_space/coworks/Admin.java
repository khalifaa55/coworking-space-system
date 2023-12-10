/*package coworking_space.coworks;

import java.util.ArrayList;
import java.util.Scanner;

public class    Admin {
    private final String Admin_Name = "coworking_space.coworks.Admin";
    private final String Admin_Password = "coworking_space.coworks.Admin";
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

    void displayRoomVisitors(AbstractRoom room)
    {
        System.out.println("Visitors in " + room.getRoomType() + ":");
        int no_=1;
        if(room instanceof GeneralRoom) {
            GeneralRoom generalRoom = (GeneralRoom) room;
            for (AbstractVisitor vis : generalRoom.visitors) {
                GeneralVisitor v = (GeneralVisitor) vis;
                System.out.println("The " + no_ + " visitor Id :" + v.id);
                System.out.println("The " + no_ + " visitor Name :" + v.name);
//                System.out.println("The " + no_ + " visitor type :" + v.type);
                System.out.println();

                no_++;
            }
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
        System.out.println("The Room Max Number OF Visitors  : "+Room.maxNumberOfVisitors);
        System.out.println();

        ArrayList<Slot> availableSlots = Room.getAvailableSlots();

        ArrayList<Slot> allSlots = Room.slots;
//        ArrayList<Slot> Reserved = new ArrayList<>();
        System.out.println("The Reserved Slots are : ");

        for(int i=0 ; i<allSlots.size();i++){

            if (!(allSlots.get(0).equals(availableSlots.get(i))) && (Room.getNumOfVisitors()== Room.maxNumberOfVisitors)) {
//                Reserved.equals(allSlots.get(i));
                System.out.println("Start Time: " + allSlots.get(i).getStartTime());
                System.out.println("End Time: " + allSlots.get(i).getEndTime());
                System.out.println("Fees: " + allSlots.get(i).getFees());
                allSlots.remove(i);
            }
        }

        System.out.println("The available Slots are : ");
        for(int i=0 ; i<allSlots.size() ; i++) {
            if ((allSlots.get(0).equals(availableSlots.get(i)))) {
                System.out.println("Start Time: " + allSlots.get(i).getStartTime());
                System.out.println("End Time: " + allSlots.get(i).getEndTime());
                System.out.println("Fees: " + allSlots.get(i).getFees());
//
                System.out.println();
            }
        }

        System.out.printf("\n");
        ArrayList<AbstractVisitor> visitors = Room.visitors;
        int no_=1;
        for(AbstractVisitor vis : visitors){
            System.out.println("Visitors in the room are : " + Room.getNumOfVisitors());

            System.out.println("The "+ no_ + " visitor ID : "+ vis.id);
            System.out.println("The "+ no_ + " visitor Name : "+ vis.name);
            System.out.println("The "+ no_ + " visitor Type : "+ vis.type);
            System.out.println();
            no_ ++;

        }
    }

    void DisplayTeachingRoom(TeachingRoom Room) {

        System.out.println("The Room ID : "+Room.id);
        System.out.println("The Room Name : "+Room.name);
        System.out.println("The Max number Of Visitors : "+Room.maxNumberOfVisitors);
        System.out.println("The Type Of The Board : "+Room.boardtype);
        System.out.println("The Instructor Name : "+Room.instractorname);
        System.out.println("The Projector Type : "+Room.projecttype);
        ArrayList<Slot> availableSlots = Room.getAvailableSlots();
//        ArrayList<Slot> a = Room.getAvailableSlots(availableSlots);
        System.out.println();
        ArrayList<Slot> allSlots = Room.slots;
        System.out.println("The available Slots are : ");
        for (Slot S : availableSlots) {

            System.out.println("Start Time: " + S.getStartTime());
            System.out.println("End Time: " + S.getEndTime());
            System.out.println("Fees: " + S.getFees());
            System.out.println();
//
        }
        System.out.println("The Reserved Slots are : ");

        for (int i=0 ; i<allSlots.size() ; i++) {
            if (allSlots.get(i).equals(availableSlots.get(i)) ) {
                continue;
            }
            else{
                System.out.println("Start Time: " + allSlots.get(i).getStartTime());
                System.out.println("End Time: " + allSlots.get(i).getEndTime());
                System.out.println("Fees: " + allSlots.get(i).getFees());
            }
        }
        System.out.println();
        ArrayList<InstructorVisitor> instructors =Room.visitors;
        if (instructors != null ) {
            System.out.println("Visitors in the room are : " + Room.getNumOfVisitors());
            for (AbstractVisitor ins : instructors) {
                System.out.println("Visitor name : " + ins.name);
                System.out.println("Visitor Id : " + ins.id);
                System.out.println("Visitor Type : " + ins.type);
                System.out.println();
            }
        } else {
            System.out.println("No Instructors in the room.");
        }
    }

    void displayInstructors(ArrayList<AbstractRoom> Rooms) {
        int no_=1;
        for (AbstractRoom r : Rooms) {
            TeachingRoom teachingRoom = (TeachingRoom) r;
            System.out.println("Instructors in The "+no_+" Room : \n");
            ArrayList<InstructorVisitor> Ins = teachingRoom.visitors;
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

//    void DisplayVisitorData(coworking_space.coworks.AbstractVisitor visitor, coworking_space.coworks.AbstractRoom Room) {
//        visitor.displayData();
//     visitor.DisplayReservation(Room);}


    double CalcRoom_Profit(AbstractRoom Room) {
        double Profit = Room.getReservationMoney();
        return Profit;
    }

//    void UpdateRoom(coworking_space.coworks.AbstractRoom Room ) {
//        int Case;
//        Scanner scanner = new Scanner(System.in);
//        Case = scanner.nextInt();
//        switch (Case) {
//            case 1:
//                System.out.println("Enter The new Room Id : ");
//                Room.id = scanner.nextInt();
//                break;
//            case 2:
//                System.out.println("Enter The new Room name");
//                Room.name = scanner.next();
//                break;
//            case 3:
//                DisplayRoomVisitors(Room);
//                System.out.println("Enter the visitor Number : ");
//                scanner.nextInt();
//                UpdateVisitor(Room.visitors.get(scanner.nextInt()) , Room);
//                break;
//            case 4:
//                DisplayRoomSlots(Room);
//                System.out.println("Enter The Slot number : ");
//                scanner.nextInt();
//                UpdateSlot(Room.slots.get(scanner.nextInt()) , Room);
//                break;
//        }
//        System.out.println("The Data Of The Room After The Update : \n");
//        DisplayRoomsData(Room);
//    }
//
//    void UpdateVisitor(coworking_space.coworks.AbstractVisitor visitor  , coworking_space.coworks.AbstractRoom Room) {
//            int Case;
//        Scanner scanner = new Scanner(System.in);
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
//        System.out.println("The Data Of THE Visitors After The Update : \n");
//        DisplayRoomVisitors(Room);
//        //////////////////////Update the reservation ///////////////////////
//    }

    void UpdateSlot(Slot slot , AbstractRoom Room) {
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
        System.out.println("The Data Of The Slots After The Update : \n");
        DisplayRoomSlots(Room);
    }

    void DeleteRoom(int RoomId, ArrayList<AbstractRoom> Rooms ) {

        for (int i = 0; i < Rooms.size(); i++) {
            if (Rooms.get(i).id == RoomId) {
                Rooms.remove(i);
            }
        }
    }
    void DeleteVisitor(AbstractVisitor Visitor , AbstractRoom Room) {
        ArrayList<AbstractVisitor> allVisitors = Room.visitors;

        for (int i = 0; i < allVisitors.size(); i++) {
            if (Visitor.equals(allVisitors.get(i))) {
                allVisitors.remove(i);
                break;
            }
        }
//        DisplayRoomVisitors(Room);
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
}*/
