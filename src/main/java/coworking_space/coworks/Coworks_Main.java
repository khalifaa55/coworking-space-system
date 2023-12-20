package coworking_space.coworks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class Coworks_Main extends Application {
    /*  2 General Rooms: max_num_visitors 20 per room
        3 Meeting Rooms: max_num_visitors 10 per room
        3 Teaching Rooms: max_num_visitors 10 per room
    */
    final static String WRITE_GENERAL_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\generalRooms.json";
    final static String READ_GENERAL_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\generalRooms.json";
    final static String WRITE_MEETING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\meetingRooms.json";
    final static String READ_MEETING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\meetingRooms.json";
    final static String WRITE_TEACHING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\teachingRooms.json";
    final static String READ_TEACHING_ROOMS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\teachingRooms.json";
    final static String WRITE_VISITORS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\visitors.json";
    final static String READ_VISITORS_PATH = "E:\\Coworks with GUI\\coworking-space-system\\src\\main\\resources\\visitors.json";

    public static ArrayList<AbstractVisitor> visitors = new ArrayList<>();
    public static ArrayList<Registration> registrations = new ArrayList<Registration>();
    public static ArrayList<AbstractRoom> meetingRooms = new ArrayList<>();
    public static ArrayList<AbstractRoom> generalRooms = new ArrayList<>();
    public static ArrayList<AbstractRoom> teachingRooms = new ArrayList<>();
///////////////////////////////////////////////////////

    public static ArrayList<Slot> Mslots = new ArrayList<>();
    public static ArrayList<FormalVisitor> formals = new ArrayList<>();
    public static ArrayList<Slot> Mslots2 = new ArrayList<>();
    public static ArrayList<FormalVisitor> formals2 = new ArrayList<>();
    public static ArrayList<Slot> Mslots3 = new ArrayList<>();
    public static ArrayList<FormalVisitor> formals3 = new ArrayList<>();


//    public static ArrayList<AbstractRoom> teachingRooms = new ArrayList<>();

    public static ArrayList<Slot> tslots = new ArrayList<>();
    public static ArrayList<InstructorVisitor> insts = new ArrayList<>();
    public static ArrayList<Slot> tslots2 = new ArrayList<>();
    public static ArrayList<InstructorVisitor> insts2 = new ArrayList<>();
    public static ArrayList<Slot> tslots3 = new ArrayList<>();
    public static ArrayList<InstructorVisitor> insts3 = new ArrayList<>();

    public static void readArrayListFromJson() {
        try {
            generalRooms = Json.readGeneralRoomsFromFile(READ_GENERAL_ROOMS_PATH);
            meetingRooms = Json.readMeetingRoomsFromFile(READ_MEETING_ROOMS_PATH);
            teachingRooms = Json.readTeachingRoomsFromFile(READ_TEACHING_ROOMS_PATH);
            visitors = Json.readVisitorsFromFile(READ_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error reading data from file", e);
        }
    }


    public static void writeArrayListIntoJson() {
        try {
            Json.writeGeneralRoomsToFile(generalRooms, WRITE_GENERAL_ROOMS_PATH);
            Json.writeMeetingRoomsToFile(meetingRooms, WRITE_MEETING_ROOMS_PATH);
            Json.writeTeachingRoomsToFile(teachingRooms, WRITE_TEACHING_ROOMS_PATH);
            Json.writeVisitorsToFile(visitors, WRITE_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error writing data to file", e);
        }
    }

  /*  public static void sendArrayListToMain(ArrayList<?> arrayList) {
        try {
            Object firstElement = arrayList.get(0);
            if (firstElement instanceof MeetingRoom) {
                meetingRooms = (ArrayList<MeetingRoom>) arrayList;
            } else if (firstElement instanceof GeneralRoom) {
                generalRooms = (ArrayList<GeneralRoom>) arrayList;
            } else if (firstElement instanceof TeachingRoom) {
                teachingRooms = (ArrayList<TeachingRoom>) arrayList;
            } else if (firstElement instanceof AbstractVisitor) {
                visitors = (ArrayList<AbstractVisitor>) arrayList;
            }
        } catch (NullPointerException e) {
            System.out.println("Null ArrayList");
            e.printStackTrace();
        }
    }
*/
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Coworks_Main.class.getResource("welcomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Coworks");
        stage.setScene(scene);
        //write into files when exiting program
        stage.setOnCloseRequest(event -> {
            writeArrayListIntoJson();
            System.out.println("writing in file");
        });
        stage.show();
    }

    public static void main(String[] args) {
        readArrayListFromJson();
        Registration.getVisitorsFromMain(visitors);
        AbstractVisitor.getAbstractVisitorsFromMain(visitors);

        FormalVisitor formal = new FormalVisitor("alshimaa", 12);
        FormalVisitor formal0 = new FormalVisitor("ahmed", 14);

        FormalVisitor formal1 = new FormalVisitor("Farha", 123);
        FormalVisitor formal2 = new FormalVisitor("ahmed", 143);

        FormalVisitor formal3 = new FormalVisitor("Omnia", 122);
        FormalVisitor formal4 = new FormalVisitor("Mahmoud", 142);

            Slot slot1 = new Slot("08:00 AM", "10:00 AM", 100.00,LocalDate.of(2023,12,1));
            Slot slot2 = new Slot("10:00 AM", "12:00 PM", 300,LocalDate.of(2023,12,2));


            Slot slot3 = new Slot("02:00 PM", "04:00 PM", 100.00,LocalDate.of(2023,12,3));
            Slot slot4 = new Slot("04:00 PM", "06:00 PM", 300,LocalDate.of(2023,12,4));

            Slot slot5 = new Slot("06:00 PM", "08:00 PM", 100.00,LocalDate.of(2023,12,5));
            Slot slot6 = new Slot("08:00 PM", "10:00 PM", 300,LocalDate.of(2023,12,6));

            // slot2.createReservation(inst);
            //slot1.createReservation(inst);
            formals.add(formal);
            formals.add(formal0);
            Mslots.add(slot1);
            Mslots.add(slot2);

            AbstractRoom meeting_room = new MeetingRoom("Mroom1", 1, Mslots, formals);
            AbstractRoom meeting_room2 = new MeetingRoom("Mroom2", 2, Mslots2, formals2);
            AbstractRoom meeting_room3 = new MeetingRoom("Mroom3", 3, Mslots3, formals3);

        meetingRooms.add(meeting_room);
        meetingRooms.add(meeting_room2);
        meetingRooms.add(meeting_room3);

        //slot1.createReservation(inst);
        formals2.add(formal1);
        formals2.add(formal2);
        Mslots2.add(slot3);
        Mslots2.add(slot4);

        //slot1.createReservation(inst);
        formals3.add(formal3);
        formals3.add(formal4);
        Mslots3.add(slot5);
        Mslots3.add(slot6);


        InstructorVisitor inst1= new InstructorVisitor("Fagr",12);
        InstructorVisitor inst2 = new InstructorVisitor("ashraf",14);
        insts.add(inst1);
        insts.add(inst2);

        InstructorVisitor inst3= new InstructorVisitor("Bansee",123);
        InstructorVisitor inst4 = new InstructorVisitor("abdelnasser",143);
        insts2.add(inst3);
        insts2.add(inst4);
        InstructorVisitor inst5= new InstructorVisitor("haneen",122);
        InstructorVisitor inst6 = new InstructorVisitor("ahmed",142);
        insts3.add(inst5);
        insts3.add(inst6);

            Slot slot7 = new Slot("08:00 AM", "10:00 AM", 100.00, LocalDate.of(2023,12,7));
            Slot slot8 = new Slot("10:00 AM", "12:00 PM", 300.00,LocalDate.of(2023,12,8));


            Slot slot9 = new Slot("08:00 AM", "10:00 AM", 100.00,LocalDate.of(2023,12,9));
            Slot slot10 = new Slot("10:00 AM", "12:00 PM", 300.00,LocalDate.of(2023,12,10));

            Slot slot11 = new Slot("08:00 AM", "10:00 AM", 100.00,LocalDate.of(2023,12,11));
            Slot slot12 = new Slot("10:00 AM", "12:00 PM", 300.00,LocalDate.of(2023,12,12));


        tslots.add(slot7);
        tslots.add(slot8);
        tslots2.add(slot9);
        tslots2.add(slot10);
        slot7.createReservation(inst1);

        tslots3.add(slot11);
        tslots3.add(slot12);
        AbstractRoom teaching_room = new TeachingRoom("Troom1", 4, tslots, insts);
        teachingRooms.add(teaching_room);

        AbstractRoom teaching_room2 = new TeachingRoom("Troom2", 5, tslots2, insts2);
        AbstractRoom teaching_room3 = new TeachingRoom("Troom3", 6, tslots3, insts3);
        teachingRooms.add(teaching_room2);
        teachingRooms.add(teaching_room3);

//        slot1.createReservation(inst1);



        ArrayList<Slot> gslots = new ArrayList<>();
        ArrayList<Slot> gslots2 = new ArrayList<>();
        GeneralVisitor Gvisitor_3=new GeneralVisitor("Fago",4);
        GeneralVisitor Gvisitor_2=new GeneralVisitor("Fagor",3);
        ArrayList<GeneralVisitor> generals = new ArrayList<>();
        ArrayList<GeneralVisitor> generals2 = new ArrayList<>();
        generals.add(Gvisitor_2);
        generals.add(Gvisitor_3);
        generals2.add(Gvisitor_2);
        generals2.add(Gvisitor_3);

            Slot slot13 = new Slot("02:00 PM", "04:00 PM", 100.00,LocalDate.of(2023,12,12));
            Slot slot14 = new Slot("04:00 PM", "06:00 PM", 300.00,LocalDate.of(2023,12,13));

            Slot slot15 = new Slot("06:00 PM", "08:00 PM", 100.00,LocalDate.of(2023,12,14));
            Slot slot16 = new Slot("04:00", "06:00 PM", 300.00,LocalDate.of(2023,12,15));
//        InstructorVisitor inst1= new InstructorVisitor("h",12);
//        InstructorVisitor inst2 = new InstructorVisitor("R",14);
//        insts.add(inst1);
//        insts.add(inst2);
//
//        InstructorVisitor inst3= new InstructorVisitor("y",123);
//        InstructorVisitor inst4 = new InstructorVisitor("z",143);
//        insts.add(inst3);
//        insts.add(inst4);
//        InstructorVisitor inst5= new InstructorVisitor("G",122);
//        InstructorVisitor inst6 = new InstructorVisitor("D",142);
//        insts3.add(inst5);
//        insts3.add(inst6);
        gslots2.add(slot13);
        gslots2.add(slot14);

        gslots.add(slot15);
        gslots.add(slot16);


        AbstractRoom general_room = new GeneralRoom("Groom1", 7, gslots2, generals);
            AbstractRoom general_room2 = new GeneralRoom("Groom2", 8, gslots, generals2);
            generalRooms.add(general_room);
            generalRooms.add(general_room2);




        System.out.println("Size of meetingRooms: " + meetingRooms.size());
        //VisitorCancelReservationScreen.getRoomsArrayListFromMain(meetingRooms,teachingRooms,generalRooms);
//        MakeReservationController.getRoomsArrayListFromMain(meetingRooms, teachingRooms, generalRooms);

//            VisitorCancelReservationScreen.getarraylistfrommain(meetingRooms);
//            VisitorCancelReservationScreen.getarraylistfromMain(teachingRooms);
//            VisitorCancelReservationScreen.getarraylistfrommMain(generalRooms);

//            VisitorController.getarraylistfrommain(meetingRooms);
//            VisitorController.getarraylistfromMain(teachingRooms);
//            VisitorController.getarraylistfrommMain(generalRooms);

        Admin alshimaa= new Admin();
//        for(AbstractRoom M:meetingRooms)
//        {
//            alshimaa.DisplayRoomsData(M);
//        }
//        for(AbstractRoom M:teachingRooms)
//        {
//            alshimaa.DisplayRoomsData(M);
//        }
//        for(AbstractRoom m: generalRooms)
//        {
//            alshimaa.DisplayRoomsData(m);
//        }
//        // System.out.println(meetingRooms.get(0));
        //System.out.println("Size of meetingRooms: " + meetingRooms.size());


        //writeArrayListIntoJson();

       // writeArrayListIntoJson();
        Collections.sort(Mslots);
        Collections.sort(Mslots2);
        Collections.sort(Mslots3);

        Collections.sort(tslots);
        Collections.sort(tslots2);
        Collections.sort(tslots3);

        Collections.sort(gslots);
        Collections.sort(gslots2);
         launch();



    }

}
