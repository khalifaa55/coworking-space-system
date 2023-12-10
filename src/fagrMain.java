//import java.io.IOException;
//import java.util.ArrayList;
//
//public class fagrMain {
//
//    public static void main(String[] args) {
//        final String WRITE_TEACHING_ROOMS_PATH = "src/main/resources/teachingRooms.json";
//        final String READ_TEACHING_ROOMS_PATH = "teachingRooms.json";
//        ArrayList<AbstractRoom> teachingRooms=new ArrayList<>();
//
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<InstructorVisitor> insts= new ArrayList<>();
//        InstructorVisitor inst= new InstructorVisitor("h",12);
//        InstructorVisitor inst2 = new InstructorVisitor("R",14);
//
//        try {
//            teachingRooms  = Json.readRoomsFile(READ_TEACHING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Slot slot1 = new Slot("8/11","9/11", 100.00);
//        Slot slot2 = new Slot("11/11","10/10", 300);
//
//        slot2.createReservation(inst);
//        slot1.createReservation(inst);
//        insts.add(inst);
//        insts.add(inst2);
//        slots.add(slot1);
//        slots.add(slot2);
//        //TeachingRoom teaching_room= new TeachingRoom("A",123,"p","b","i",slots,insts);
//       // teachingRooms.add(teaching_room);
//
//
//
//
//        try {
//            Json.writeRoomsToFile(teachingRooms,WRITE_TEACHING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    }
//}
