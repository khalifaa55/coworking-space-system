package coworking_space.coworks;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import coworking_space.coworks.Slot; // Import the necessary class



import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class VisitorsDataController {

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button RoomDataButton;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private Button VisitorsData;

    @FXML
    private ImageView visitorsDataImage;

    @FXML
    private AnchorPane visitorsDataScreen;



    @FXML
    void changeScreenDisplayRoomsDataScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToAvailableRoomsScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)availableSlotsScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void changeScreenUpdateRoomDataScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)updateRoomScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void LogOut_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
