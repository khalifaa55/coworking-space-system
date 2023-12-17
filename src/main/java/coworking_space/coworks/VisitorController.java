package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class VisitorController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    private ArrayList<String> room1Options = new ArrayList<>();
    private ArrayList<String> room2Options = new ArrayList<>();
    private ArrayList<String> room3Options = new ArrayList<>();
    @FXML
    private RadioButton Room1;

    @FXML
    private RadioButton Room2;

    @FXML
    private RadioButton Room3;
    @FXML
    private Button DisplayinfoScreen;


    @FXML
    private AnchorPane visitorScreen;


    @FXML
    void getRoom1(MouseEvent event) {
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(room1Options);


    }

    @FXML
    void getRoom2(MouseEvent event) {
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(room2Options);


    }

    @FXML
    void getRoom3(MouseEvent event) {
        choiceBox.getItems().clear();
        choiceBox.getItems().addAll(room3Options);


    }

    @FXML
    void getselectedslot(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // leave the spaces for the GUI to look better
        room1Options.add("Slot 1 for Room 1                                              ");
        room1Options.add("Slot 2 for Room 1                                              ");

        room2Options.add("Slot 1 for Room 2                                              ");
        room2Options.add("Slot 2 for Room 2                                              ");
        room2Options.add("Slot 3 for Room 2                                              ");

        room3Options.add("Slot 1 for Room 3                                              ");
        room3Options.add("Slot 2 for Room 3                                              ");
        room3Options.add("Slot 3 for Room 3                                              ");

        // Add default options to the ChoiceBox
        choiceBox.getItems().addAll(room1Options);

    }


    @FXML
    void DisplayInfoScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("DisplayUserData.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
