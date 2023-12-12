package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RegisterController {

    @FXML
    private ToggleGroup Visitor_Type;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;

    @FXML
    public PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button registerLogin;

    @FXML
    private Button registerLogin1;

    @FXML
    private AnchorPane registerScreen;

    @FXML
    public TextField userName;

    @FXML
    void changeScreenToLoginScreen_1(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) registerScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void saveInfoAndRedirect(MouseEvent event) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
       /* String textFromuserName = userName.getText();
        String textFromEmail = email.getText();
        String textFromPhoneNumber = phoneNumber.getText();
        String textFromPassword = password.getText();
        String textFromConfirmPassword = confirmPassword.getText();

*/
      //  Parent root = FXMLLoader.load(getClass().getResource("registerScreen.fxml"));
        //System.out.println("Text from user: " + userName.getText());
        System.out.println("Text from password: " + password.getText());

    }



}


