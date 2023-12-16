package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EditInformation {

    @FXML
    private Button DisplayCancelReservationScreen;

    @FXML
    private AnchorPane DisplayInfoScreen;

    @FXML
    private Button DisplayUpdateReservationScreen;

    @FXML
    private Button EditScreen;

    @FXML
    private Label EmailLabel;

    @FXML
    private Button MakeReservationScreen;

    @FXML
    private Label Passwordlable;

    @FXML
    private Label namelabel;

    @FXML
    private Label phoneNumberlabel;



    static Registration currentResistrtionn= Registration.getRegistration();
    static AbstractVisitor cVisitor=AbstractVisitor.getCurrentVisitor(currentResistrtionn);

    public void initialize() {
        namelabel.setText(cVisitor.name);
        EmailLabel.setText(cVisitor.userEmail);
        Passwordlable.setText(cVisitor.password);
        phoneNumberlabel.setText(cVisitor.phoneNumber);
    }
    @FXML
    void SwitchToEditScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("DisplayUserData.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void DisplayCancelReservation(MouseEvent event) {

    }

    @FXML
    void DisplayMakeReservation(MouseEvent event) {

    }

    @FXML
    void DisplayUpdateReservation(MouseEvent event) {

    }
}
