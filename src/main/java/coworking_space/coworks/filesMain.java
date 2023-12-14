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
        final String WRITE_TEACHING_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\teachingRooms.json";
        final String READ_TEACHING_ROOMS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\teachingRooms.json";
        final String WRITE_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";
        final String READ_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";

        //////////////////////////////////VISITORS JSON/////////////////////////////////////////
//        ArrayList<AbstractVisitor> visitors=new ArrayList<>();
//        try {
//            visitors= Json.readVisitorsFromFile(READ_VISITORS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        ////////////////General Visitors////////////////
//        GeneralVisitor gen1 = new GeneralVisitor("Rabab",0);
//        GeneralVisitor gen2 = new GeneralVisitor("Habiba",1);
//        GeneralVisitor gen3 = new GeneralVisitor("Ahmed",2);
//        GeneralVisitor gen4 = new GeneralVisitor("Mahmoud",3);
//        GeneralVisitor gen5 = new GeneralVisitor("Malak",4);
//        gen1.setUserEmail("rabab@example.com");
//        gen2.setUserEmail("beebo22@yahoo.com");
//        gen3.setUserEmail("ahmed.khalifa@hotmail.com");
//        gen4.setUserEmail("mahmoud.email@outlook.com");
//        gen5.setUserEmail("malak123@aol.com");
//
//        gen1.setPassword("P@ssw0rd!");
//        gen2.setPassword("8CharPwd");
//        gen3.setPassword("MyP@ssw0rd");
//        gen4.setPassword("Hello123");
//        gen5.setPassword("Pass@123");
//
//        gen1.setPhoneNumber("0128887777");
//        gen2.setPhoneNumber("0119990000");
//        gen3.setPhoneNumber("0107778888");
//        gen4.setPhoneNumber("0125556666");
//        gen5.setPhoneNumber("0113334444");
//
//        visitors.add(gen1);
//        visitors.add(gen2);
//        visitors.add(gen3);
//        visitors.add(gen4);
//        visitors.add(gen5);
//        ////////////////Formal Visitors////////////////
//        FormalVisitor frml1 = new FormalVisitor("Rehab",5);
//        FormalVisitor frml2 = new FormalVisitor("Islam",6);
//        FormalVisitor frml3 = new FormalVisitor("Haya",7);
//        FormalVisitor frml4 = new FormalVisitor("Rodayna",8);
//        FormalVisitor frml5 = new FormalVisitor("Adam",9);
//        FormalVisitor frml6 = new FormalVisitor("Yassin",10);
//        FormalVisitor frml7 = new FormalVisitor("Injy",11);
//        FormalVisitor frml8 = new FormalVisitor("Hamza",12);
//        FormalVisitor frml9 = new FormalVisitor("Nour",13);
//        FormalVisitor frml10 = new FormalVisitor("Layla",14);
//        frml1.setUserEmail("rehab@gmail.com");
//        frml2.setUserEmail("islam456@icloud.com");
//        frml3.setUserEmail("haya_h@zoho.com");
//        frml4.setUserEmail("rody42@mail.com");
//        frml5.setUserEmail("adam.email@yandex.com");
//        frml6.setUserEmail("yassin.m@emailservice.com");
//        frml7.setUserEmail("injy.support@company.org");
//        frml8.setUserEmail("hamza.manager@organization.co");
//        frml9.setUserEmail("nour_h@mail.com");
//        frml10.setUserEmail("layla.account@yandex.com");
//
//        frml1.setPhoneNumber("0101112222");
//        frml2.setPhoneNumber("0123210987");
//        frml3.setPhoneNumber("0114321098");
//        frml4.setPhoneNumber("0105432109");
//        frml5.setPhoneNumber("0127654321");
//        frml6.setPhoneNumber("0108765432");
//        frml7.setPhoneNumber("0119876543");
//        frml8.setPhoneNumber("0127654321");
//        frml9.setPhoneNumber("0105432109");
//        frml10.setPhoneNumber("0114321098");
//
//        frml1.setPassword("MyPassword1");
//        frml2.setPassword("L0ngP@ss");
//        frml3.setPassword("123456Ab");
//        frml4.setPassword("AbCdEfGh");
//        frml5.setPassword("Pa$$word");
//        frml6.setPassword("SecurePass123!");
//        frml7.setPassword("P@ssw0rd123");
//        frml8.setPassword("Secret@789");
//        frml9.setPassword("StrongPwd456!");
//        frml10.setPassword("P@ssw0rd#789");
//
//        visitors.add(frml1);
//        visitors.add(frml2);
//        visitors.add(frml3);
//        visitors.add(frml4);
//        visitors.add(frml5);
//        visitors.add(frml6);
//        visitors.add(frml7);
//        visitors.add(frml8);
//        visitors.add(frml9);
//        visitors.add(frml10);
//        ////////////////Instructor Visitors////////////////
//        InstructorVisitor inst1=new InstructorVisitor("Moaz",15);
//        InstructorVisitor inst2=new InstructorVisitor("Mohamed",16);
//        InstructorVisitor inst3=new InstructorVisitor("Mira",17);
//        InstructorVisitor inst4=new InstructorVisitor("Tayem",18);
//        InstructorVisitor inst5=new InstructorVisitor("Kareem",19);
//        inst1.setUserEmail("moaz123@service.info");
//        inst2.setUserEmail("horus456@webmail.eu");
//        inst3.setUserEmail("mirana.email@website.org");
//        inst4.setUserEmail("tayem@protonmail.ch");
//        inst5.setUserEmail("kareem12345@platform.travel");
//
//        inst1.setPhoneNumber("0118765432");
//        inst2.setPhoneNumber("0109876543");
//        inst3.setPhoneNumber("0123456789");
//        inst4.setPhoneNumber("0112345678");
//        inst5.setPhoneNumber("0101234567");
//
//        inst1.setPassword("Secret12");
//        inst2.setPassword("1aB@cD!2");
//        inst3.setPassword("Qwerty12");
//        inst4.setPassword("P@ssw0rd");
//        inst5.setPassword("Abc12345");
//
//        visitors.add(inst1);
//        visitors.add(inst2);
//        visitors.add(inst3);
//        visitors.add(inst4);
//        visitors.add(inst5);
//
//
//        try {
//            Json.writeVisitorsToFile( visitors, WRITE_VISITORS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ////////////////////////////////TEACHING ROOMS JSON/////////////////////////////////////////
//        ArrayList<AbstractRoom> teachingRooms=new ArrayList<>();
//        try {
//            teachingRooms = Json.readRoomsFromFile(READ_TEACHING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ArrayList<Slot> slots = new ArrayList<>();
//        ArrayList<InstructorVisitor> gens= new ArrayList<>();
//        InstructorVisitor gen = new InstructorVisitor("hano",12);
//        InstructorVisitor gen2 = new InstructorVisitor("Rahmaa",14);
//
//        Slot slot1 = new Slot("8","10", 100.00);
//        Slot slot2 = new Slot("8","10", 300);
//
//        slot2.createReservation(gen);
//        slot1.createReservation(gen2);
//        gens.add(gen);
//        gens.add(gen2);
//        slots.add(slot1);
//        slots.add(slot2);
//        TeachingRoom general_room1= new TeachingRoom("Room B",125,slots,gens);
//        TeachingRoom general_room= new TeachingRoom("Room B",125,null,null);
//        teachingRooms.add(general_room);
//        teachingRooms.add(general_room1);
//        try {
//            Json.writeRoomsToFile( teachingRooms, WRITE_TEACHING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

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
