/*package coworking_space.coworks;

import java.io.IOException;
import java.util.ArrayList;
//coworking_space.coworks.Main code for writing and reading into json file
public class MainApp {
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////
        final String WRITE_GENERAL_ROOMS_PATH = "src/main/resources/generalRooms.json";
        final String READ_GENERAL_ROOMS_PATH = "generalRooms.json";

        final String WRITE_MEETING_ROOMS_PATH = "src/main/resources/meetingRooms.json";
        final String READ_MEETING_ROOMS_PATH = "meetingRooms.json";



        final String WRITE_VISITORS_PATH = "src/main/resources/visitors.json";
        final String READ_VISITORS_PATH = "visitors.json";

        ////////////////////////////////////////////////////////////////

        ArrayList<AbstractRoom> generalRooms=new ArrayList<>();

        ArrayList<Slot> slots = new ArrayList<>();
        ArrayList<GeneralVisitor> gens= new ArrayList<>();
        GeneralVisitor gen = new GeneralVisitor("h",12);
        GeneralVisitor gen2 = new GeneralVisitor("R",14);

        try {
            generalRooms  = Json.readRoomsFile(READ_GENERAL_ROOMS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Slot slot1 = new Slot("8/11","9/11", 100.00);
        Slot slot2 = new Slot("11/11","10/10", 300);

        slot2.createReservation(gen);
        slot1.createReservation(gen2);
        gens.add(gen);
        gens.add(gen2);
        slots..add(slot1);
        slots.json.add(slot2);
        GeneralRoom general_room= new GeneralRoom("A",123,slots.json,gens);
        generalRooms.add(general_room);




        try {
            Json.writeRoomsToFile(generalRooms,WRITE_GENERAL_ROOMS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}*/




