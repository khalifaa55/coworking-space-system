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
    Toggle selectedToggle;
    RadioButton selectedRadioButton;

    public String type;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField email;
    public String userEmail;

    @FXML
    private PasswordField password;

    public String pass;

    @FXML
    private TextField phoneNumber;
    public String userPhoneNumber;

    @FXML
    private Button registerLogin;

    @FXML
    private Button registerLogin1;

    @FXML
    private AnchorPane registerScreen;

    @FXML
    private TextField userName;
    public String name;

    private Registration registration = new Registration();

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

        boolean isValid = validateForm();
        boolean isduplicate=Registration.isDuplicateEmail(userEmail);

        System.out.println("Email: " + userEmail);
        System.out.println("Is Duplicate: " + isduplicate);

        if (isValid && (!isduplicate)) {
            Registration newRegistration = new Registration(name, userEmail, userPhoneNumber, pass,type);
            AbstractVisitor.createVisitorFromRegistration(newRegistration);
            Registration.getRegistrations().add(newRegistration);


           System.out.println("Registration succesful");
        }
        else if (isduplicate){
            System.out.println("Registration insuccesful");
            for (Registration obj : Registration.getRegistrations()) {
                 obj.displayAttributes();
            }
        }

    }

    private boolean validateForm() {

        boolean isValidUsername = registration.usernameRegex(userName.getText());
        boolean isValidEmail = registration.emailRegex(email.getText());
        boolean isValidPhoneNumber = registration.phoneNumberRegex(phoneNumber.getText());
        boolean isValidPassword = registration.passwordRegex(password.getText());
        boolean arePasswordsMatching = password.getText().equals(confirmPassword.getText());
        boolean isValidType=validateVisitorType();

        return isValidUsername && isValidEmail && isValidPhoneNumber && isValidPassword && arePasswordsMatching && isValidType;
    }


    private void validatePassword(String password, String confirmPassword) {
        boolean isValid = registration.passwordRegex(password);
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
        else if(isValid || equalsConfirmPass ){
            pass=password;
        }

    }

    private void validatePhoneNumber(String phoneNumber) {
        boolean isValid = registration.phoneNumberRegex(phoneNumber);
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
        else if(isValid ){
            userPhoneNumber=phoneNumber;
        }
    }

    private void validateEmail(String email) {
        boolean isValid = registration.emailRegex(email);
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
        else if(isValid  ){
            userEmail=email;
        }
    }

    private void validateUsername(String username) {
        boolean isValid = registration.usernameRegex(username);
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
        else if(isValid  ){
            name=username;
        }
    }

    private boolean validateVisitorType() {
        selectedToggle = Visitor_Type.getSelectedToggle();
        boolean check = false;

        if (selectedToggle == null || !(selectedToggle instanceof RadioButton)) {
            // Handle the case where no RadioButton is selected
            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Error");

            Label errorMessage = new Label("Please choose a type of visitor.");

            Button closeButton = new Button("Close");
            closeButton.setOnAction(e -> popupStage.close());

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(10));
            layout.getChildren().addAll(errorMessage, closeButton);

            Scene scene = new Scene(layout, 300, 100);
            popupStage.setScene(scene);
            popupStage.showAndWait();

            check = false;
        } else {
            selectedRadioButton = (RadioButton) selectedToggle;
            type = selectedRadioButton.getText();
            check = true;
        }

        return check;
    }

}


