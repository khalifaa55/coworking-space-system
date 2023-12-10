import java.util.ArrayList;

public class Maine {
    public static void main(String[] args) {
        final String WRITE_SLOTS_PATH = "src/main/resources/slots.json";
        final String READ_SLOTS_PATH = "Slots.json";
        ArrayList<Slot> slots = new ArrayList<>();
        Slot slot = new Slot("8/11","9/11", 100.00);
        slots.add(slot);
        Slot slot1 = new Slot("8/11","9/11", 100.00);
        Slot slot2 = new Slot("11/11","10/10", 300);
        GeneralVisitor gen = new GeneralVisitor();
        GeneralVisitor gen2 = new GeneralVisitor();
        gen.name = "haneen";
        gen2.name = "hana";
        slot2.createReservation(gen);
        slot1.createReservation(gen2);
        slots.add(slot1);
        slots.add(slot2);
        // Add Slot objects to the `slots` list
        /*try {
            Json.writeSlotsToFile(slots, WRITE_SLOTS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            slots = Json.readSlotsFile(READ_SLOTS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
    }
}
