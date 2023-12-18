package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EditInformationController {

    @FXML
    private Button DisplayUpdateReservationScreen;

    @FXML
    private Button MakeReservationScreen;

    @FXML
    private TextField SetEmail;

    @FXML
    private TextField SetPhoneNum;

    @FXML
    private ImageView editInfoImage;

    @FXML
    private AnchorPane editInfoScreen;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField setName;

    @FXML
    private TextField setPassword;

    static Registration currentResistrtionn= Registration.getRegistration();
    static AbstractVisitor cVisitor=AbstractVisitor.getCurrentVisitor(currentResistrtionn);

    public void initialize() {
        setName.setText(cVisitor.name);
        SetEmail.setText(cVisitor.userEmail);
        setPassword.setText(cVisitor.password);
        SetPhoneNum.setText(cVisitor.phoneNumber);
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
