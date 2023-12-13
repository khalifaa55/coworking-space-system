package coworking_space.coworks;

import java.io.IOException;
import java.util.ArrayList;
public class filesMain {
    public static void main(String[] args) {
        final String WRITE_SLOTS_PATH = "src/main/resources/slots.json";
        final String READ_SLOTS_PATH = "slots.json";
        ArrayList<Slot> slots = new ArrayList<>();
        Slot slot = new Slot("0", "12", 700.00);
        Slot slot1 = new Slot("0", "12", 700.00);
        Slot slot2 = new Slot("0", "12", 700);
        Slot slot3 = new Slot("0", "12", 700);

//        GeneralVisitor gen = new GeneralVisitor();
//        GeneralVisitor gen2 = new GeneralVisitor();
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
        try {
            slots = Json.readSlotsFromFile(READ_SLOTS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        slots.add(slot);
        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);

        // Add Slot objects to the `slots` list
        try {
            Json.writeSlotsToFile( slots,WRITE_SLOTS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
