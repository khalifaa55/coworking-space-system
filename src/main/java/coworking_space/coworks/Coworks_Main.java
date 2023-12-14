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

//        try {
//            meetingRooms  = Json.readRoomsFromFile(READ_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Slot slot1 = new Slot("8/11","9/11", 100.00);
        Slot slot2 = new Slot("11/11","10/10", 300);

        // slot2.createReservation(inst);
        //slot1.createReservation(inst);
        insts.add(inst);
        insts.add(inst2);
        slots.add(slot1);
        slots.add(slot2);
        MeetingRoom meeting_room= new MeetingRoom("A",123,slots,insts);
        meetingRooms.add(meeting_room);





//
//        try {
//            Json.writeRoomsToFile(meetingRooms,WRITE_MEETING_ROOMS_PATH);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }



    }
}