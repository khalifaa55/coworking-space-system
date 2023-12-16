package coworking_space.coworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class VisitorCancelReservationScreen {

    @FXML
    private Button D_button;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ImageView c_screen;

    @FXML
    private ChoiceBox<?> choicebox;

    private ObservableList<String> observableSlots = FXCollections.observableArrayList();

    public static  ArrayList<AbstractRoom> meetingRooms;
    public static ArrayList<AbstractRoom> teachingRooms;
    public static ArrayList<AbstractRoom> generalRooms;
    public static void getarraylistfrommain(ArrayList<AbstractRoom> meeting_rooms){
        meetingRooms=meeting_rooms;
    }

    public static void getarraylistfromMain(ArrayList<AbstractRoom> teaching_rooms){
        teachingRooms=teaching_rooms;
    }
    public static void getarraylistfrommMain(ArrayList<AbstractRoom> genaral_rooms){
        generalRooms=genaral_rooms;
    }



    ArrayList<Slot> iUserReservation=InstructorVisitor.IuserResrvations;
    ArrayList<Slot> fUserReservation=FormalVisitor.FuserResrvations;
    ArrayList<Slot> gUserReservation=GeneralVisitor.GuserResrvations;


    public void fillChoicebox(){
        if(RegisterController.instructortype){
            InstructorVisitor instructorVisitor = new InstructorVisitor();
            for(int i=0;i<teachingRooms.size();i++){

                instructorVisitor.DisplayReservation(teachingRooms.get(i), Registration.getRegistration());

            }


        }else if (RegisterController.formaltype){
            FormalVisitor formalVisitor = new FormalVisitor();

        }else{
            GeneralVisitor generalVisitor = new GeneralVisitor();
        }


    }

    @FXML
    void deletSlot(MouseEvent event) {



    }

}
