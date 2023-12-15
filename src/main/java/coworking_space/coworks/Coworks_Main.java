package coworking_space.coworks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Coworks_Main extends Application
{

    public static ArrayList<AbstractRoom> meetingRooms=new ArrayList<>();

    public static ArrayList<Slot> Mslots = new ArrayList<>();
    public static  ArrayList<FormalVisitor> formals= new ArrayList<>();
    public static ArrayList<Slot> Mslots2 = new ArrayList<>();
    public static   ArrayList<FormalVisitor> formals2= new ArrayList<>();
    public static  ArrayList<Slot> Mslots3 = new ArrayList<>();
    public static  ArrayList<FormalVisitor> formals3= new ArrayList<>();



    public static ArrayList<AbstractRoom> teachingRooms=new ArrayList<>();

    public static ArrayList<Slot> tslots = new ArrayList<>();
    public static  ArrayList<InstructorVisitor> insts= new ArrayList<>();
    public static ArrayList<Slot> tslots2 = new ArrayList<>();
    public static   ArrayList<InstructorVisitor> insts2= new ArrayList<>();
    public static  ArrayList<Slot> tslots3 = new ArrayList<>();
    public static  ArrayList<InstructorVisitor> insts3= new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Coworks_Main.class.getResource("welcomeScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1155,759);
        stage.setTitle("Coworks");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        final String WRITE_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";
        final String READ_VISITORS_PATH = "E:\\coworking space\\coworks\\src\\main\\resources\\visitors.json";

        ArrayList<AbstractVisitor> visitors=new ArrayList<>();
        try {
            visitors= Json.readVisitorsFromFile(READ_VISITORS_PATH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        launch();

//        final String WRITE_MEETING_ROOMS_PATH = "src/main/resources/meetingRooms.json";
//        final String READ_MEETING_ROOMS_PATH = "meetingRooms.json";




        FormalVisitor formal= new FormalVisitor("h",12);
        FormalVisitor formal0 = new FormalVisitor("R",14);

        FormalVisitor formal1= new FormalVisitor("y",123);
        FormalVisitor formal2 = new FormalVisitor("z",143);

        FormalVisitor formal3= new FormalVisitor("G",122);
        FormalVisitor formal4 = new FormalVisitor("D",142);



//        try {
//            meetingRooms  = Json.readRoomsFromFile(READ_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Slot slot1 = new Slot("8/11","9/11", 100.00);
        Slot slot2 = new Slot("11/11","10/10", 300);


        Slot slot3 = new Slot("8/11","9/11", 100.00);
        Slot slot4 = new Slot("11/11","10/10", 300);

        Slot slot5 = new Slot("8/11","9/11", 100.00);
        Slot slot6 = new Slot("11/11","10/10", 300);

        // slot2.createReservation(inst);
        //slot1.createReservation(inst);
        formals.add(formal);
        formals.add(formal0);
        Mslots.add(slot1);
        Mslots.add(slot2);
        MeetingRoom meeting_room= new MeetingRoom("A",123,Mslots,formals);
        meetingRooms.add(meeting_room);

        MeetingRoom meeting_room2= new MeetingRoom("B",124,Mslots2,formals2);
        MeetingRoom meeting_room3= new MeetingRoom("C",125,Mslots3,formals3);
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







//        InstructorVisitor inst1= new InstructorVisitor("h",12);
//        InstructorVisitor inst2 = new InstructorVisitor("R",14);
//
//        InstructorVisitor inst3= new InstructorVisitor("y",123);
//        InstructorVisitor inst4 = new InstructorVisitor("z",143);
//
//        InstructorVisitor inst5= new InstructorVisitor("G",122);
//        InstructorVisitor inst6 = new InstructorVisitor("D",142);


        Slot slot7 = new Slot("8/11","9/11", 100.00);
        Slot slot8 = new Slot("11/11","10/10", 300);


        Slot slot9 = new Slot("8/11","9/11", 100.00);
        Slot slot10 = new Slot("11/11","10/10", 300);

        Slot slot11 = new Slot("8/11","9/11", 100.00);
        Slot slot12 = new Slot("11/11","10/10", 300);



        tslots.add(slot7);
        tslots.add(slot8);
        TeachingRoom teaching_room= new TeachingRoom("A",123,tslots,insts);
        meetingRooms.add(meeting_room);

        TeachingRoom teaching_room2= new TeachingRoom("B",124,tslots2,insts2);
        TeachingRoom teaching_room3= new TeachingRoom("C",125,tslots3,insts3);
        meetingRooms.add(meeting_room2);
        meetingRooms.add(meeting_room3);

        //slot1.createReservation(inst);

        tslots2.add(slot9);
        tslots2.add(slot10);

        tslots3.add(slot11);
        tslots3.add(slot12);






//
//        try {
//            Json.writeRoomsToFile(meetingRooms,WRITE_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }



    }
}