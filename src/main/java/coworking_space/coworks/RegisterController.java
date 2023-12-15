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

public class RegisterController implements Initializable {

    @FXML
    private RadioButton formalVisitor;

    @FXML
    private RadioButton generalVisitor;

    @FXML
    private RadioButton instructorVisitor;
    @FXML
    private ToggleGroup Visitor_Type;
    private String visitorType;

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
    void GoToVisitorScreen() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Visitor.fxml"));

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
        visitorType = selectedRadioButton.getText();
        System.out.println("Selected RadioButton: " + visitorType);

    }

    @FXML
    void saveInfoAndRedirect(MouseEvent Event) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

//        validatePassword(password.getText(),confirmPassword.getText());
//        validatePhoneNumber(phoneNumber.getText());
//        validateUsername(userName.getText());
//        validateEmail(email.getText());
        boolean isRegistrationValid=Registration.usernameRegex(userName.getText())&& Registration.emailRegex(email.getText())&& Registration.phoneNumberRegex(phoneNumber.getText()) && Registration.passwordRegex(password.getText())&& (password.getText()).equals(confirmPassword.getText());
        // Check if any radio button is selected in the Visitor_Type ToggleGroup
        if (Visitor_Type.getSelectedToggle() == null) {
            // No radio button is selected, display an error message or take appropriate action
            String inValidTitle = "Visitor Validation";
            String inValidMessage = "Please choose a visitor type.";
            inValidMessage(inValidTitle, inValidMessage);
            return; // Stop further processing since validation failed
        }  else if (!isRegistrationValid) {
            String inValidTitle = "Invalid Registration";
            String inValidMessage = "Please fill out missing data.";
            inValidMessage(inValidTitle, inValidMessage);
            return;
        }
        else {
            Registration newRegistration = new Registration(userName.getText(), email.getText(), phoneNumber.getText(), password.getText(), visitorType);
            AbstractVisitor.createVisitorFromRegistration(newRegistration);
            Registration.getRegistrations().add(newRegistration);
            System.out.println("Registration successful");
            GoToVisitorScreen();
        }

    }

    private void validatePassword(String password, String confirmpassword) {
        boolean isValid = Registration.passwordRegex(password) ;
        boolean equalsConfirmPass = password.equals(confirmpassword);

        if(!isValid || !equalsConfirmPass) {
            String inValidTitle = "Password Validation";
            String inValidMessage = "Invalid password, please try again.";
            inValidMessage(inValidTitle, inValidMessage);

        }
    }

    private void validatePhoneNumber(String phoneNumber) {
        boolean isValid = Registration.phoneNumberRegex(phoneNumber) ;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid) {
            String inValidTitle = "Phone Number Validation";
            String inValidMessage = "Invalid phone number, please try again.";
            inValidMessage(inValidTitle, inValidMessage);

        }
    }

    private void validateEmail(String email) {
        boolean isValid = Registration.emailRegex(email) ;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid || email == null ) {
            String inValidTitle = "Email Validation";
            String inValidMessage = "Invalid email, please try again.";
            inValidMessage(inValidTitle, inValidMessage);
        }
        else if (Registration.isDuplicateEmail(email)){
            String inValidTitle = "Duplicate Email";
            String inValidMessage ="Email in use, You can login directly.";
            inValidMessage(inValidTitle, inValidMessage);
        }
    }

    private void validateUsername(String username) {
        boolean isValid = Registration.usernameRegex(username) ;
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        if(!isValid || username == null) {
            String inValidTitle = "Username Validation";
            String inValidMessage ="Invalid username, please try again.";
            inValidMessage(inValidTitle, inValidMessage);

        }
    }

    private void inValidMessage(String title, String message){
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);

        Label Message = new Label(message);
        Message.setAlignment(Pos.CENTER);
        Message.setFont(Font.font(14));
        Message.setStyle("-fx-text-fill: white");

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> popupStage.close());
        closeButton.setStyle("-fx-background-radius: 10");

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


