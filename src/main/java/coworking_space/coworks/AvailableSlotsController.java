package coworking_space.coworks;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;


import java.io.IOException;
import javafx.fxml.FXMLLoader;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.util.Callback;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AvailableSlotsController implements Initializable {



    @FXML
    private TableView<Slot> AvailableTA;

    @FXML
    private TableColumn<Slot, LocalDate> Date;


    @FXML
    private TableColumn<Slot, String> EndTime;

    @FXML
    private TableColumn<Slot, Double> Fees;


    @FXML
    private RadioButton GeneralRadio;

    @FXML
    private Button LogOutButton1;

    @FXML
    private RadioButton MeetingRadio;

    @FXML
    private Button RoomDataButton;

    @FXML
    private TextField Roomid1;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private TableColumn<Slot, String> StartTime;



    @FXML
    private RadioButton TeachingRadio;

    @FXML
    private Button VisitorsData;
    @FXML
    private ToggleGroup Types;

    @FXML
    private ImageView availableSlotsImage;

    @FXML
    private AnchorPane availableSlotsScreen;

    @FXML
    void changeScreenDisplayRoomsDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenUpdateRoomDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)updateRoomScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToVisitorsDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)visitorsDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void LogOut_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    int SelectedSlot;
    String Typee;
    int RoonID;
    @FXML
    void DeleteSlot(MouseEvent event) {
        ObservableList<Slot> available=AvailableTA.getItems();

        SelectedSlot = AvailableTA.getSelectionModel().getSelectedIndex();
        if(Typee.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(RoonID==R.id) {
                   R.slots.remove(SelectedSlot);
                   available.remove(SelectedSlot);
                }

            }
        } else if (Typee.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(RoonID== R.id)
                {

                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);


                }
            }

        }
        else {
            for(AbstractRoom R:meetingRooms)
            {
                if(RoonID == R.id)
                {

                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);

                }
            }
        }
        AvailableTA.setItems(available);
        AvailableTA.refresh();
        for(AbstractRoom R:generalRooms)
        {
            for(Slot S: R.getAvailableSlotsForAdmin())
            {
                System.out.println(S.getStartTime());
            }
        }
    }

    @FXML
    void DisplaySlots(MouseEvent event) {
        Typee=String.valueOf(Types.getSelectedToggle());
        RoonID=Integer.parseInt(Roomid1.getText());
        SelectedRoom(Typee,RoonID);
    }

    public void SelectedRoom(String Type , int Id)
    {
        ObservableList<Slot> available=FXCollections.observableArrayList();

        if(Type.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(Id==R.id) {
                    for (Slot S : R.slots) {
                        System.out.println(S.getStartTime());
                        available.add(S);
                    }
                }

            }
        } else if (Type.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(Id== R.id)
                {
                    for(Slot S:R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }

        }
        else {
            for(AbstractRoom R:meetingRooms)
            {
                if(Id == R.id)
                {
                    for(Slot S :R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }
        }
        Date.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("slotDate"));
        StartTime.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndTime.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        Fees.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        AvailableTA.setItems(available);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



  }
}
