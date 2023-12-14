package coworking_space.coworks;

import java.io.IOException;
import java.util.ArrayList;
public class filesMain {
    public static void main(String[] args) {
        final String WRITE_SLOTS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\slots.json";
        final String READ_SLOTS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\slots.json";
        final String WRITE_GENERAL_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\generalRooms.json";
        final String READ_GENERAL_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\generalRooms.json";
        final String WRITE_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";
        final String READ_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";

        ArrayList<AbstractVisitor> visitors=new ArrayList<>();
        try {
            visitors= Json.readVisitorsFromFile(READ_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GeneralVisitor Gvisitor_0=new GeneralVisitor("haya",200); // Working with visitor types that matches the room
        GeneralVisitor Gvisitor_1=new GeneralVisitor("malak","myPassword",123,"general");

        FormalVisitor gen = new FormalVisitor("hano",12);
        InstructorVisitor gen2 = new InstructorVisitor("Rahmaa",14);
        visitors.add(Gvisitor_0);
        visitors.add(Gvisitor_1);
        visitors.add(gen);
        visitors.add(gen2);
        try {
            Json.writeVisitorsToFile( visitors, WRITE_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        ArrayList<AbstractRoom> generalRooms=new ArrayList<>();
//        try {
//            generalRooms = Json.readRoomsFromFile(READ_GENERAL_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<GeneralVisitor> gens= new ArrayList<>();
//        GeneralVisitor gen = new GeneralVisitor("hano",12);
//        GeneralVisitor gen2 = new GeneralVisitor("Rahmaa",14);
//
//        Slot slot1 = new Slot("8/11","9/11", 100.00);
//        Slot slot2 = new Slot("11/11","10/10", 300);
//
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
//        gens.add(gen);
//        gens.add(gen2);
//        slots.add(slot1);
//        slots.add(slot2);
//        GeneralRoom general_room= new GeneralRoom("B",125,slots,gens);
//        generalRooms.add(general_room);
//        try {
//            Json.writeRoomsToFile( generalRooms, WRITE_GENERAL_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //////////////////////////////////SLOTS JSON/////////////////////////////////////////
//        ArrayList<Slot> slots = new ArrayList<>();
//        Slot slot = new Slot("0", "12", 700.00);
//        Slot slot1 = new Slot("0", "12", 700.00);
//        Slot slot2 = new Slot("0", "12", 700);
//        Slot slot3 = new Slot("0", "12", 700);

//        GeneralVisitor gen = new GeneralVisitor();
//        GeneralVisitor gen2 = new GeneralVisitor();
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
//        try {
//            slots = Json.readSlotsFromFile(READ_SLOTS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        slots.add(slot);
//        slots.add(slot1);
//        slots.add(slot2);
//        slots.add(slot3);
//
//        // Add Slot objects to the `slots` list
//        try {
//            Json.writeSlotsToFile( slots,WRITE_SLOTS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
