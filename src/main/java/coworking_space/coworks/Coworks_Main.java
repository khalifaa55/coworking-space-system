package coworking_space.coworks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Coworks_Main extends Application
{
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
        launch();

//        final String WRITE_MEETING_ROOMS_PATH = "src/main/resources/meetingRooms.json";
//        final String READ_MEETING_ROOMS_PATH = "meetingRooms.json";
         ArrayList<AbstractRoom> meetingRooms=new ArrayList<>();

        ArrayList<Slot> slots = new ArrayList<>();
        ArrayList<FormalVisitor> insts= new ArrayList<>();
        FormalVisitor inst= new FormalVisitor("h",12);
        FormalVisitor inst2 = new FormalVisitor("R",14);

        FormalVisitor formal1= new FormalVisitor("y",123);
        FormalVisitor formal2 = new FormalVisitor("z",143);

        FormalVisitor formal3= new FormalVisitor("G",122);
        FormalVisitor formal4 = new FormalVisitor("D",142);

        ArrayList<Slot> slots2 = new ArrayList<>();
        ArrayList<FormalVisitor> insts2= new ArrayList<>();

        ArrayList<Slot> slots3 = new ArrayList<>();
        ArrayList<FormalVisitor> insts3= new ArrayList<>();

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
        insts.add(inst);
        insts.add(inst2);
        slots.add(slot1);
        slots.add(slot2);
        MeetingRoom meeting_room= new MeetingRoom("A",123,slots,insts);
        meetingRooms.add(meeting_room);

        MeetingRoom meeting_room2= new MeetingRoom("B",124,slots2,insts2);
        MeetingRoom meeting_room3= new MeetingRoom("C",125,slots3,insts3);
        meetingRooms.add(meeting_room2);
        meetingRooms.add(meeting_room3);

        //slot1.createReservation(inst);
        insts2.add(formal1);
        insts3.add(formal2);
        slots2.add(slot3);
        slots2.add(slot4);

        //slot1.createReservation(inst);
        insts3.add(formal3);
        insts3.add(formal4);
        slots3.add(slot5);
        slots3.add(slot6);





//
//        try {
//            Json.writeRoomsToFile(meetingRooms,WRITE_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }



    }
}