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

public class EditInformationController {

    @FXML
    private Button DisplayCancelReservationScreen;

    @FXML
    private AnchorPane editInfoScreen;

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
    void SaveUpdatedData(MouseEvent event) {

    }
    @FXML
    void changeScreenToMakeReservationScreen_3(MouseEvent event)throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)MakeReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) editInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToUpdateReservationScreen_3(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)updateReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) editInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logout_3(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) editInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
