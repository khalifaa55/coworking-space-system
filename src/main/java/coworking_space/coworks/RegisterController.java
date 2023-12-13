package coworking_space.coworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class RegisterController implements Initializable {

    @FXML
    private RadioButton formalVisitor;

    @FXML
    private RadioButton generalVisitor;

    @FXML
    private RadioButton instructorVisitor;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up event handlers for radio buttons
        instructorVisitor.setOnAction(this::handleRadioButtonSelection);
        formalVisitor.setOnAction(this::handleRadioButtonSelection);
        generalVisitor.setOnAction(this::handleRadioButtonSelection);

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

    // Event handler for radio button selection
    private void handleRadioButtonSelection(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        System.out.println("Selected RadioButton: " + selectedRadioButton.getText());
    }

    @FXML
    void saveInfoAndRedirect(MouseEvent Event) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        // Check if any radio button is selected in the Visitor_Type ToggleGroup
        if (Visitor_Type.getSelectedToggle() == null) {
            // No radio button is selected, display an error message or take appropriate action
            String inValidTitle = "Visitor Validation";
            String inValidMessage = "Please choose a visitor type.";
            inValidMessage(inValidTitle, inValidMessage);
            return; // Stop further processing since validation failed
        }

        // Continue with the rest of your code for saving information and redirection
        String textFromUserName = userName.getText();
        String textFromEmail = email.getText();
        String textFromPhoneNumber = phoneNumber.getText();
        String textFromPassword = password.getText();
        String textFromConfirmPassword = confirmPassword.getText();

      //  Parent root = FXMLLoader.load(getClass().getResource("registerScreen.fxml"));


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

        String phoneNumberRegex = "^[0-9]{11}$";

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
        boolean isValid = passwordRegex(password) ;
        boolean equalsConfirmPass = password.equals(confirmPassword);

        if(!isValid || !equalsConfirmPass) {
            String inValidTitle = "Password Validation";
            String inValidMessage = "Invalid password, please try again.";
            inValidMessage(inValidTitle, inValidMessage);

        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        boolean isValid = phoneNumberRegex(phoneNumber) ;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid) {
            String inValidTitle = "Phone Number Validation";
            String inValidMessage = "Invalid phone number, Please try again.";
            inValidMessage(inValidTitle, inValidMessage);

        }
    }

    private void validateEmail(String email) {
        boolean isValid = emailRegex(email) || email == null;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid) {
            String inValidTitle = "Email Validation";
            String inValidMessage = "Invalid email, please try again.";
            inValidMessage(inValidTitle, inValidMessage);


        }
    }

    private void validateUsername(String username) {
        boolean isValid = usernameRegex(username) || username == null;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid) {
            String inValidTitle = "Username Validation";
            String inValidMessage = "Invalid username, please try again.";
            inValidMessage(inValidTitle, inValidMessage);
        }
    }

    private void inValidMessage(String title, String message){
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);

        Label Message = new Label(message);
        Message.setFont(Font.font(14));
        Message.setStyle("-fx-text-fill: white");


        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> popupStage.close());
        closeButton.setStyle("-fx-background-radius: 10");
        //closeButton.setLayoutX(150);
//        closeButton.setScaleY(100);
//        closeButton.setX(150);
//        closeButton.setAlignment(15020);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #6678CB");
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(Message, closeButton);

        Scene scene = new Scene(layout, 300, 100);
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }




}


