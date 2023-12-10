import java.io.IOException;
import java.util.ArrayList;

public class MMAIN {
    public static void main(String[] args) {
        final String WRITE_TEACHING_ROOMS_PATH = "src/main/resources/teachingRooms.json";
        final String READ_TEACHING_ROOMS_PATH = "teachingRooms.json";

        ArrayList<AbstractRoom> teachingRooms=new ArrayList<>();

        ArrayList<Slot> slots = new ArrayList<>();
        ArrayList<InstructorVisitor> arr_vistors= new ArrayList<>();
        InstructorVisitor test = new InstructorVisitor("Mr",2245);
        InstructorVisitor test2 = new InstructorVisitor("Miss",8960);

        try {
            teachingRooms  = Json.readRoomsFile(READ_TEACHING_ROOMS_PATH);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        Slot slot_1= new Slot("8:00","10:00", 100.00);
        Slot slot_2 = new Slot("11:00","2:00", 300);

        slot_1.createReservation(test);
        slot_2.createReservation(test2);
        arr_vistors.add(test);
        arr_vistors.add(test2);
        slots.add(slot_1);
        slots.add(slot_1);
        TeachingRoom T_room= new TeachingRoom("Room1",123,"hhk","bjhj","bhkjhj",slots,arr_vistors);
        teachingRooms.add(T_room);




        try {
            Json.writeRoomsToFile(teachingRooms,WRITE_TEACHING_ROOMS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
