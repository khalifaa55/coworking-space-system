package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.function.Consumer;
import java.util.regex.Pattern;

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
    void initialize(){
        password.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {validatePassword(password.getText(),password.getText());}});
        confirmPassword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {validatePassword(password.getText(),confirmPassword.getText());}});
        phoneNumber.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {validatePhoneNumber(phoneNumber.getText());}});
        userName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {validateUsername(userName.getText());}});
        email.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {validateEmail(email.getText());}});
    }
    @FXML
    void saveInfoAndRedirect(MouseEvent Event) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        /* String textFromuserName = userName.getText();
        String textFromEmail = email.getText();
        String textFromPhoneNumber = phoneNumber.getText();
        String textFromPassword = password.getText();
        String textFromConfirmPassword = confirmPassword.getText();

*/
      //  Parent root = FXMLLoader.load(getClass().getResource("registerScreen.fxml"));
        //System.out.println("Text from user: " + userName.getText());
//        System.out.println("Text from password: " + password.getText());

    }
    private boolean passwordRegex(String password) {
        // Define the password validation regex
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$";

        // Check if the password matches the regex
        boolean isValid = Pattern.matches(passwordRegex, password);

        // Display a pop-up with the validation result
        return isValid;
    }

    private boolean phoneNumberRegex(String phoneNumber) {

        String phoneNumberRegex = "^[0-9]{10}$";

        // Check if the password matches the regex
        boolean isValid = Pattern.matches(phoneNumberRegex,phoneNumber);

        // Display a pop-up with the validation result
        return isValid;
    }

    private boolean emailRegex(String email) {

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        boolean isValid = Pattern.matches(emailRegex, email);

        // Display a pop-up with the validation result
        return isValid;
    }
    private boolean usernameRegex(String username) {

        String usernameRegex = "^[a-zA-Z0-9_]{3,20}$";


        boolean isValid = Pattern.matches(usernameRegex, username);

        // Display a pop-up with the validation result
        return isValid;
    }

    private void validatePassword(String password, String confirmPassword) {
        boolean isValid = passwordRegex(password);
        boolean equalsConfirmPass = password.equals(confirmPassword);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Password Validation");
        if(!isValid || !equalsConfirmPass) {
            Label Message = new Label("Invalid password. Please try again");

            Button closeButton = new Button("Close");
            closeButton.setOnAction(event -> popupStage.close());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));
            layout.getChildren().addAll(Message, closeButton);

            Scene scene = new Scene(layout, 300, 100);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        boolean isValid = phoneNumberRegex(phoneNumber);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Phone Number Validation");
        if(!isValid) {
            Label Message = new Label("Invalid phone number. Please try again");

            Button closeButton = new Button("Close");
            closeButton.setOnAction(event -> popupStage.close());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));
            layout.getChildren().addAll(Message, closeButton);

            Scene scene = new Scene(layout, 300, 100);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        }
    }

    private void validateEmail(String email) {
        boolean isValid = emailRegex(email);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Email Validation");
        if(!isValid) {
            Label Message = new Label("Invalid email. Please try again");

            Button closeButton = new Button("Close");
            closeButton.setOnAction(event -> popupStage.close());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));
            layout.getChildren().addAll(Message, closeButton);

            Scene scene = new Scene(layout, 300, 100);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        }
    }

    private void validateUsername(String username) {
        boolean isValid = usernameRegex(username);
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Username Validation");
        if(!isValid) {
            Label Message = new Label("Invalid username. Please try again");

            Button closeButton = new Button("Close");
            closeButton.setOnAction(event -> popupStage.close());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));
            layout.getChildren().addAll(Message, closeButton);

            Scene scene = new Scene(layout, 300, 100);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        }
    }






}


