package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AdminController {

    @FXML
    private Button AdminHomeBUtton;

    @FXML
    private TableView<?> AvailableSlotsTable;

    @FXML
    private Button LogOutButton;

    @FXML
    private TableView<?> ReservedSlotsTable;

    @FXML
    private Button RoomDataButton;

    @FXML
    private Label RoomProfit;

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
    private Button UpdateRoom;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableView<?> VisitorsTable;

    @FXML
    void LogOut(MouseEvent event) {

    }

}

