package coworking_space.coworks;

import coworking_space.coworks.Visitors.AbstractVisitor;
import coworking_space.coworks.Visitors.Registration;
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

public class DisplayUserDataController {

    @FXML
    private AnchorPane DisplayInfoScreen;

    @FXML
    private Button EditScreenButton;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label Passwordlable;

    @FXML
    private Button logoutButton;

    @FXML
    private Button makeReservationButton;

    @FXML
    private Label namelabel;

    @FXML
    private Label phoneNumberlabel;

    @FXML
    private Button updateReservationButton;


    static Registration currentResistrtionn= Registration.getRegistration();


    public static AbstractVisitor cVisitor= AbstractVisitor.getCurrentVisitor(currentResistrtionn);

    public void initialize() {
        namelabel.setText(cVisitor.name);
        EmailLabel.setText(cVisitor.getUserEmail());
        Passwordlable.setText(cVisitor.getPassword());
        phoneNumberlabel.setText(cVisitor.getPhoneNumber());
    }

    @FXML
    void SwitchToEditScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)editInformationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToMakeReservationScreen_1(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)MakeReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToUpdateReservationScreen_1(MouseEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)updateReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logout_1(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayInfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
