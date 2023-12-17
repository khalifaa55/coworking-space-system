package coworking_space.coworks;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static coworking_space.coworks.EditInformation.cVisitor;
import static coworking_space.coworks.EditInformation.currentResistrtionn;

public class DisplayUserData {
    @FXML
    private Button DisplayCancelReservationScreen;

    @FXML
    private AnchorPane DisplayINfoScreen;

    @FXML
    private Button DisplayInfoScreen;

    @FXML
    private Button DisplayUpdateReservationScreen;

    @FXML
    private Button MakeReservationScreen;

    @FXML
    private TextField SetEmail;

    @FXML
    private TextField SetPhoneNum;

    @FXML
    private TextField setName;

    @FXML
    private TextField setPassword;
    @FXML
    void DisplayUserInfo(MouseEvent event)throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("EditInformation.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) DisplayINfoScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SaveUpdatedData(MouseEvent event) {
        String newName= setName.getText();
        String newEmail=SetEmail.getText();
        cVisitor.checkEmail(newEmail);
        String newPhoneNumber=SetPhoneNum.getText();
        String newPassword=setPassword.getText();
        cVisitor.editUserInfo(cVisitor,cVisitor.userEmail,newName,newPassword,newEmail,newPhoneNumber);
    }


    protected static void inValidMessage(String title, String message){
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

    @FXML
    void DisplayCancelReservation(MouseEvent event) {

    }

    @FXML
    void DisplayMakeReservation(MouseEvent event) {

    }

    @FXML
    void DisplayUpdateReservation(MouseEvent event) {

    }
}
