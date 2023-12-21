package coworking_space.coworks;



import coworking_space.coworks.Rooms.AbstractRoom;
import coworking_space.coworks.Rooms.Slot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;


import java.io.IOException;
import javafx.fxml.FXMLLoader;


import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


import java.net.URL;
import java.time.LocalDate;
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
    ObservableList<Slot> available=FXCollections.observableArrayList();


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
    private void inValidMessage(String title, String message){
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);

        Label Message = new Label(message);
        Message.setAlignment(Pos.CENTER);
        Message.setFont(Font.font(14));
        Message.setStyle("-fx-text-fill: white");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> popupStage.close());
        closeButton.setStyle("-fx-background-radius: 10");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #6678CB");
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(Message, closeButton);

        Scene scene = new Scene(layout, 300, 100);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }
    int SelectedSlot;
    String Typee;
    int RoonID;
    @FXML
    void DeleteSlot(MouseEvent event) {
        boolean Check=false;
        ObservableList<Slot> available=AvailableTA.getItems();

        SelectedSlot = AvailableTA.getSelectionModel().getSelectedIndex();
        if(Typee.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(RoonID==R.id) {
                    Check=true;
                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);
                }

            }
        } else if (Typee.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(RoonID== R.id)
                {
                    Check=true;
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
                    Check=true;
                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);

                }
            }
        }
        if(Check)
            inValidMessage("Alert" , "Slot no. " +(SelectedSlot+1) +" is Deleted ");
        AvailableTA.setItems(available);
        AvailableTA.refresh();

    }

    @FXML
    void DisplaySlots(MouseEvent event) {

        RoonID = Integer.parseInt(Roomid1.getText());
        Typee = String.valueOf(Types.getSelectedToggle());
        DisplayAvailableSlots();
    }

    public void DisplayAvailableSlots()
    {
        available.clear();
        boolean isExist=false;
        if(Typee.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(RoonID==R.id) {
                    isExist=true;
                    for (Slot S : R.slots) {
                        System.out.println(S.getStartTime());
                        available.add(S);
                    }
                }

            }
        } else if (Typee.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(RoonID== R.id)
                {
                    isExist=true;
                    for(Slot S:R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }

        }
        else {
            for(AbstractRoom R:meetingRooms)
            {
                if(RoonID == R.id)
                {
                    isExist=true;
                    for(Slot S :R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }
        }
        if(!isExist) {
            Roomid1.setText("");
            available.clear();
            inValidMessage("EROOR!!", "No Room ID " + RoonID + " With This Type\n Enter Another ID .");
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