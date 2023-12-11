package coworking_space.coworks;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Admin alshimaa = new Admin();

//        AbstractRoom room = new GeneralRoom();
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
//        AbstractVisitor Gvisitor = new GeneralVisitor();
//        Gvisitor.id=25;
//        Gvisitor.name="Omnia";
////        Gvisitor.type="Genaral";
//        room.visitors.add(Gvisitor);
//
////        alshimaa.DisplayRoomVisitors(room); //Doneee
////        alshimaa.DisplayRoomsData(room);
//
//
//        AbstractVisitor Ivisitor = new GeneralVisitor();
//        Ivisitor.id=12;
//        Ivisitor.name="Fagr";
////        Ivisitor.type="general";
//
////        InstructorVisitor Ivisitor_2 = new InstructorVisitor();
////        Ivisitor_2.id=23;
////        Ivisitor_2.name="Banosa";
////        Ivisitor_2.type="Teaching";
////        ArrayList<GeneralVisitor> Varr=new ArrayList<>();
////        Varr.add(Ivisitor);
//
//        room.visitors.add(Ivisitor);
////        alshimaa.DisplayRoomVisitors(room);
//
//        S_1.createReservation(Ivisitor);
//        alshimaa.DisplayRoomsData(room);
//        System.out.println(alshimaa.CalcRoom_Profit(room));
//
//        ArrayList<AbstractRoom> generalRooms=new ArrayList<>();
//
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<GeneralVisitor> gens= new ArrayList<>();
//        GeneralVisitor gen = new GeneralVisitor("h",12);
//        GeneralVisitor gen2 = new GeneralVisitor("R",14);
//        Slot slot1 = new Slot("8/11","9/11", 100.00);
//        Slot slot2 = new Slot("11/11","10/10", 300);
//
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
//        gens.add(gen);
//        gens.add(gen2);
//        slots.add(slot1);
//        slots.add(slot2);
//        GeneralRoom general_room= new GeneralRoom("A",123,slots,gens);
//        generalRooms.add(general_room);
//        System.out.println(general_room.getReservationMoney());
//        System.out.println(alshimaa.CalcRoom_Profit(general_room));

//        Varr.add(Ivisitor_2);

//        TeachingRoom Room = new TeachingRoom("T1",19,"B1","S1","OMnia",sarr , Varr);
//        alshimaa.DisplayTeachingRoom(Room); // Doneeee

//        TeachingRoom TR = (TeachingRoom) Room;
//        alshimaa.addSlot(Room, S_1);

//        Room.visitors.add(Ivisitor);

//        ArrayList<AbstractRoom> TRooms = new ArrayList<>(2);
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
        Slot S_2=new Slot("10","11",120);

        ArrayList<Slot> slots=new ArrayList<>();
        slots.add(S_0);

//        slots.add(S_1);
//        GeneralVisitor Gvisitor_0=new GeneralVisitor("Banosa",2); // Working with visitor types that matches the room
//        GeneralVisitor Gvisitor_1=new GeneralVisitor("Fagora",1);
//        ArrayList<GeneralVisitor> visitors=new ArrayList<>();
//        visitors.add(Gvisitor_0);
//        visitors.add(Gvisitor_1);

//        AbstractRoom Groom = new GeneralRoom("Groom",1,slots,visitors);

//        alshimaa.addSlot(Groom,S_1);
//
//        alshimaa.displayAllAvailableSlots(Groom);
//        alshimaa.displayRoomVisitors(Groom);
        FormalVisitor Fvisitor_0=new FormalVisitor("Banosa",2); // Working with visitor types that matches the room
        FormalVisitor Fvisitor_1=new FormalVisitor("Fagora",1);
        FormalVisitor Fvisitor_2=new FormalVisitor("Fagor",3);
        FormalVisitor Fvisitor_3=new FormalVisitor("Fago",4);




        ArrayList<FormalVisitor> visitors=new ArrayList<>();
        visitors.add(Fvisitor_0);
        visitors.add(Fvisitor_1);
        visitors.add(Fvisitor_2);
        visitors.add(Fvisitor_3);

        AbstractRoom Mroom = new MeetingRoom("Mroom",1,slots,visitors);

        alshimaa.addSlot(Mroom,S_1);
        alshimaa.addSlot(Mroom,S_2);
//        alshimaa.displayAllAvailableSlots(Troom);
//        alshimaa.displayRoomVisitors(Troom);
        S_0.createReservation(Fvisitor_0);
        S_0.createReservation(Fvisitor_1);
        S_0.createReservation(Fvisitor_2);
        S_0.createReservation(Fvisitor_3);

        alshimaa.DisplayRoomsData(Mroom);
//        slots.add(S_1);
//        slots.add(S_2);
//         GeneralRoom Gr= new GeneralRoom("GR1",3,slots,visitors);


//        alshimaa.DisplayRoomsData(Troom);
//          alshimaa.DisplayTeachingRoom(Troom);
//        System.out.println(alshimaa.CalcRoom_Profit(Troom));
//
//        TeachingRoom Tr=new TeachingRoom("TR1" , 3,slots,visitors);
////        slots.add(S_1);
//        ArrayList<InstructorVisitor> Iv = new ArrayList<>();
//        Iv.add(Ivisitor_2);
//        Iv.add(Ivisitor_3);
//        TeachingRoom Tr_2=new TeachingRoom("TR2" , 37,slots,Iv);
//        ArrayList<TeachingRoom>Trooms =new ArrayList<>(2);
//        Trooms.add(Tr);
//        Trooms.add(Tr_2);
//        alshimaa.displayInstructors(Trooms);
//        alshimaa.UpdateRoom(Troom);

//        alshimaa.DeleteVisitor(Ivisitor_2,Tr_2);
//        AbstractRoom t = new TeachingRoom("sh",25,slots,Iv);
//        AbstractRoom t_2 = new TeachingRoom("fa",30,slots,Iv);
//        ArrayList<AbstractRoom>Trn = new ArrayList<>(2);
//        Trn.add(t);
//        Trn.add(t_2);
//        alshimaa.DeleteRoom(30,Trn);





    }
}
