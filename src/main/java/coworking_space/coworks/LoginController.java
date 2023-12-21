package coworking_space.coworks;

import coworking_space.coworks.Visitors.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    private Button LoginButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private ToggleGroup Visitor_Type;

    @FXML
    private ImageView loginImage;

    @FXML
    private AnchorPane loginScreen;

    @FXML
    private TextField userEmail;

    @FXML
    private PasswordField userPassword;

    @FXML
    private RadioButton formalVisitor;

    @FXML
    private RadioButton generalVisitor;

    @FXML
    private RadioButton instructorVisitor;
    private String visitorType;
    public static boolean formaltype =false;
    public static boolean generaltype =false;
    public static boolean instructortype =false;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up event handlers for radio buttons
        instructorVisitor.setOnAction(this::handleRadioButtonSelection);
        formalVisitor.setOnAction(this::handleRadioButtonSelection);
        generalVisitor.setOnAction(this::handleRadioButtonSelection);
    }

    private void handleRadioButtonSelection(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        visitorType = selectedRadioButton.getText();
        System.out.println("Selected RadioButton: " + visitorType);
        if(visitorType.equals("Formal Visitor")){
            formaltype=true;
        } else if (visitorType.equals("General Visitor")) {
            generaltype=true;
        }
        else{
            instructortype=true;
        }

    }

        @FXML
    void validateSignInAndRedirect(MouseEvent event) throws IOException {
        Login login =new Login(userEmail.getText(),visitorType, userPassword.getText());
        if (Login.adminLogin(userEmail.getText(), userPassword.getText())&&Visitor_Type.getSelectedToggle() == null) {

            // Load the loginScreen.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

            // Create a new scene with the loaded FXML content
            Scene scene = new Scene(root);

            // Get the Stage from the MouseEvent's source
            Stage stage = (Stage) loginScreen.getScene().getWindow();

            // Set the new scene on the stage
            stage.setScene(scene);
            stage.show();
            return;
        } else if(Visitor_Type.getSelectedToggle() == null) {
            // No radio button is selected, display an error message or take appropriate action
            String inValidTitle = "Visitor Validation";
            String inValidMessage = "Please choose a visitor type.";
            inValidMessage(inValidTitle, inValidMessage);
            return;
        } else if (!(Login.validateLogin(login))) {
            String inValidTitle = "Invalid Sign in";
            String inValidMessage = "Wrong credentials.";
            inValidMessage(inValidTitle, inValidMessage);
        }
        else if((Login.validateLogin(login))){

            // Load the loginScreen.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("(visitor)MakeReservationScreen.fxml"));

            // Create a new scene with the loaded FXML content
            Scene scene = new Scene(root);

            // Get the Stage from the MouseEvent's source
            Stage stage = (Stage) loginScreen.getScene().getWindow();

            // Set the new scene on the stage
            stage.setScene(scene);
            stage.show();
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
