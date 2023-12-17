package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateRoomController {


    @FXML
    private Button logoutButton;
    @FXML
    private Button AddSlotButton;

    @FXML
    private TableView<?> AvailableSlotsTable;

    @FXML
    private TextField EbdTineText;

    @FXML
    private Button EditSlotButton;

    @FXML
    private Button EditVisitorButton;

    @FXML
    private TextField FeesText;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button RoomDataButton;

    @FXML
    private ChoiceBox<?> RoomTyprComboBox;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private ChoiceBox<?> RoomsIdComboBox;

    @FXML
    private Label SelectedRoomID;

    @FXML
    private Label SelectedRoomName;

    @FXML
    private TextField SelectedVisitorId;

    @FXML
    private TextField SlotDate;

    @FXML
    private TextField SlotNumberSelected;

    @FXML
    private TextField StartTimetEXT;

    @FXML
    private Button UpdateRoom;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableView<?> VisitorsTable;

    @FXML
    private ImageView updateRoomImage;

    @FXML
    private AnchorPane updateRoomScreen;

    @FXML
    void AddSlot(MouseEvent event) {

    }

    @FXML
    void EditVisitor(MouseEvent event) {

    }
    @FXML
    void changeScreenDisplayRoomsDataScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToAvailableSlotsScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)availableSlotsScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToVisitorsDataScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)visitorsDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void LogOut(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void UpdateSlot(MouseEvent event) {

    }
}
