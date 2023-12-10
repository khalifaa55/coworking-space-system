/*package coworking_space.coworks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Admin alshimaa = new Admin();

//        coworking_space.coworks.AbstractRoom room = new coworking_space.coworks.GeneralRoom();
//        room.id=1;
//        room.name="G1";
//
//        Slot S_0 = new Slot();
//        S_0.setStartTime("7");
//        S_0.setEndTime("9");
//        S_0.setFees(150);
//
//        Slot S_1 = new Slot();
//        S_1.setStartTime("8");
//        S_1.setEndTime("12");
//        S_1.setFees(120);
////        ArrayList<Slot> sarr=new ArrayList<>();
////        sarr.add(S_1);
////        sarr.add(S_0);
//        alshimaa.addSlot(room , S_0);
//        alshimaa.addSlot(room,S_1);
//
////        alshimaa.UpdateSlot(S, room);
////        alshimaa.DisplayRoomSlots(room);
////         alshimaa.deleteSlot(S_0, room);
//
////        alshimaa.displayAllAvailableSlots(room);
//        coworking_space.coworks.AbstractVisitor Gvisitor = new coworking_space.coworks.GeneralVisitor();
//        Gvisitor.id=25;
//        Gvisitor.name="Omnia";
////        Gvisitor.type="Genaral";
//        room.visitors.add(Gvisitor);
//
////        alshimaa.DisplayRoomVisitors(room); //Doneee
////        alshimaa.DisplayRoomsData(room);
//
//
//        coworking_space.coworks.AbstractVisitor Ivisitor = new coworking_space.coworks.GeneralVisitor();
//        Ivisitor.id=12;
//        Ivisitor.name="Fagr";
////        Ivisitor.type="general";
//
////        coworking_space.coworks.InstructorVisitor Ivisitor_2 = new coworking_space.coworks.InstructorVisitor();
////        Ivisitor_2.id=23;
////        Ivisitor_2.name="Banosa";
////        Ivisitor_2.type="Teaching";
////        ArrayList<coworking_space.coworks.GeneralVisitor> Varr=new ArrayList<>();
////        Varr.add(Ivisitor);
//
//        room.visitors.add(Ivisitor);
////        alshimaa.DisplayRoomVisitors(room);
//
//        S_1.createReservation(Ivisitor);
//        alshimaa.DisplayRoomsData(room);
//        System.out.println(alshimaa.CalcRoom_Profit(room));
//
//        ArrayList<coworking_space.coworks.AbstractRoom> generalRooms=new ArrayList<>();
//
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<coworking_space.coworks.GeneralVisitor> gens= new ArrayList<>();
//        coworking_space.coworks.GeneralVisitor gen = new coworking_space.coworks.GeneralVisitor("h",12);
//        coworking_space.coworks.GeneralVisitor gen2 = new coworking_space.coworks.GeneralVisitor("R",14);
//        Slot slot1 = new Slot("8/11","9/11", 100.00);
//        Slot slot2 = new Slot("11/11","10/10", 300);
//
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
//        gens.add(gen);
//        gens.add(gen2);
//        slots.add(slot1);
//        slots.add(slot2);
//        coworking_space.coworks.GeneralRoom general_room= new coworking_space.coworks.GeneralRoom("A",123,slots,gens);
//        generalRooms.add(general_room);
//        System.out.println(general_room.getReservationMoney());
//        System.out.println(alshimaa.CalcRoom_Profit(general_room));

//        Varr.add(Ivisitor_2);

//        TeachingRoom Room = new TeachingRoom("T1",19,"B1","S1","OMnia",sarr , Varr);
//        alshimaa.DisplayTeachingRoom(Room); // Doneeee

//        TeachingRoom TR = (TeachingRoom) Room;
//        alshimaa.addSlot(Room, S_1);

//        Room.visitors.add(Ivisitor);

//        ArrayList<coworking_space.coworks.AbstractRoom> TRooms = new ArrayList<>(2);
//        TRooms.add(Room);
//        TRooms.add(new TeachingRoom("T1",19,"B1","S1","OMnia",sarr , Varr));
//        alshimaa.displayInstructors(TRooms);
//        }
//             alshimaa.DeleteRoom(1,TRooms);
//             alshimaa.displayInstructors(TRooms);

//        TRooms.get(0).visitors.add(Ivisitor_2);

//        alshimaa.DeleteVisitor(Ivisitor,TRooms.get(0));
//        alshimaa.DeleteRoom(1,TRooms);
//
//        alshimaa.displayInstructors(TRooms);

//        alshimaa.UpdateVisitor(Ivisitor, TRooms.get(0));
//        alshimaa.UpdateRoom(TRooms.get(0));


        Slot S_0=new Slot("8","10",150);
        Slot S_1=new Slot("9","11",120);
        ArrayList<Slot> slots=new ArrayList<>();
        slots.add(S_0);
//        slots.add(S_1);
        GeneralVisitor Gvisitor_0=new GeneralVisitor("Banosa",2); // Working with visitor types that matches the room
        GeneralVisitor Gvisitor_1=new GeneralVisitor("Fagora",1);
        ArrayList<GeneralVisitor> visitors=new ArrayList<>();
        visitors.add(Gvisitor_0);
        visitors.add(Gvisitor_1);

        AbstractRoom Groom = new GeneralRoom("Groom",1,slots,visitors);

        alshimaa.addSlot(Groom,S_1);
        alshimaa.displayAllAvailableSlots(Groom);
        alshimaa.displayRoomVisitors(Groom);


    }
}*/
