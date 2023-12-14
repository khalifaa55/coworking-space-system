package coworking_space.coworks;

import java.io.IOException;
import java.util.ArrayList;
public class filesMain {
    public static void main(String[] args) {
        final String WRITE_SLOTS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\slots.json";
        final String READ_SLOTS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\slots.json";
        final String WRITE_GENERAL_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\generalRooms.json";
        final String READ_GENERAL_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\generalRooms.json";
        final String WRITE_MEETING_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\meetingRooms.json";
        final String READ_MEETING_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\meetingRooms.json";
        final String WRITE_TEACHING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\teachingRooms.json";
        final String READ_TEACHING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\teachingRooms.json";
        final String WRITE_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";
        final String READ_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";

        //////////////////////////////////VISITORS JSON/////////////////////////////////////////
//        ArrayList<AbstractVisitor> visitors=new ArrayList<>();
//        try {
//            visitors= Json.readVisitorsFromFile(READ_VISITORS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        GeneralVisitor Gvisitor_0=new GeneralVisitor("haya",200); // Working with visitor types that matches the room
//        GeneralVisitor Gvisitor_1=new GeneralVisitor("malak","myPassword",123,"general");
//
//        FormalVisitor gen = new FormalVisitor("hano",12);
//        InstructorVisitor gen2 = new InstructorVisitor("Rahmaa",14);
//        visitors.add(Gvisitor_0);
//        visitors.add(Gvisitor_1);
//        visitors.add(gen);
//        visitors.add(gen2);
//        try {
//            Json.writeVisitorsToFile( visitors, WRITE_VISITORS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ////////////////////////////////TEACHING ROOMS JSON/////////////////////////////////////////
        ArrayList<AbstractRoom> teachingRooms=new ArrayList<>();
        try {
            teachingRooms = Json.readRoomsFromFile(READ_TEACHING_ROOMS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Slot> slots = new ArrayList<>();
        ArrayList<InstructorVisitor> gens= new ArrayList<>();
        InstructorVisitor gen = new InstructorVisitor("hano",12);
        InstructorVisitor gen2 = new InstructorVisitor("Rahmaa",14);

        Slot slot1 = new Slot("8","10", 100.00);
        Slot slot2 = new Slot("8","10", 300);

        slot2.createReservation(gen);
        slot1.createReservation(gen2);
        gens.add(gen);
        gens.add(gen2);
        slots.add(slot1);
        slots.add(slot2);
        TeachingRoom general_room1= new TeachingRoom("B",125,slots,gens);
        TeachingRoom general_room= new TeachingRoom("B",125,null,null);
        teachingRooms.add(general_room);
        teachingRooms.add(general_room1);
        try {
            Json.writeRoomsToFile( teachingRooms, WRITE_TEACHING_ROOMS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //////////////////////////////////MEETING ROOMS JSON/////////////////////////////////////////

//        ArrayList<AbstractRoom> meetingRooms=new ArrayList<>();
//        try {
//            meetingRooms = Json.readRoomsFromFile(READ_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<FormalVisitor> gens= new ArrayList<>();
//        FormalVisitor gen = new FormalVisitor("hano",12);
//        FormalVisitor gen2 = new FormalVisitor("Rahmaa",14);
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
//        MeetingRoom general_room1= new MeetingRoom("B",125,slots,gens);
//        MeetingRoom general_room= new MeetingRoom("B",125,null,null);
//        meetingRooms.add(general_room);
//        meetingRooms.add(general_room1);
//        try {
//            Json.writeRoomsToFile( meetingRooms, WRITE_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        //////////////////////////////////GENERAL ROOMS JSON/////////////////////////////////////////
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
//        GeneralRoom general_room1= new GeneralRoom("B",125,slots,gens);
//        GeneralRoom general_room= new GeneralRoom("B",125,null,null);
//        generalRooms.add(general_room);
//        generalRooms.add(general_room1);
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
//
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
