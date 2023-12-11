package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private ImageView loginImage;

    @FXML
    private AnchorPane loginScreen;

    @FXML
    private Button registerLogin;

    @FXML
    void changeScreenToLoginScreen_2(MouseEvent event) throws IOException
    {
        // Load the registerScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("registerScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) loginScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
