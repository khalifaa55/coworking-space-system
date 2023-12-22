package coworking_space.coworks;

import coworking_space.coworks.Visitors.AbstractVisitor;
import coworking_space.coworks.Visitors.Registration;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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

import javafx.collections.ObservableList;
//import static coworking_space.coworks.MyMain.Visitors;
import static coworking_space.coworks.Coworks_Main.visitors;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class VisitorsDataController  implements  Initializable{

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button RoomDataButton;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private TextField V_Email;

    @FXML
    private TextField V_ID;

    @FXML
    private TextField V_Name;

    @FXML
    private TextField V_Phone;

    @FXML
    private TableView<AbstractVisitor> V_Table;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorEmail;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsId;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsNames;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsPhone;

    @FXML
    private ImageView visitorsDataImage;

    @FXML
    private AnchorPane visitorsDataScreen;

    @FXML
    void changeScreenDisplayRoomsDataScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToAvailableRoomsScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)availableSlotsScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void changeScreenUpdateRoomDataScreen_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)updateRoomScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void LogOut_3(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorsDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
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
    @FXML
    void ChoosenVisitor(MouseEvent event) {

        AbstractVisitor ClickedVisitor = V_Table.getSelectionModel().getSelectedItem();
        V_ID.setText(String.valueOf(ClickedVisitor.id));
        V_Name.setText(ClickedVisitor.name);
        V_Email.setText(ClickedVisitor.getUserEmail());
        V_Phone.setText(ClickedVisitor.getPhoneNumber());
    }

    @FXML
    void DeleteVisitor(MouseEvent event) {
        ObservableList<AbstractVisitor> currentVisitors = V_Table.getItems();

        Index= V_Table.getSelectionModel().getSelectedIndex();
        V_ID.setText("");
        V_Name.setText("");
        V_Email.setText("");
        V_Phone.setText("");
        inValidMessage("Alert "," Visitor With ID "+currentVisitors.get(Index).id+" is Deleted");
        visitors.remove(Index);
        currentVisitors.remove(Index);
        V_Table.setItems(currentVisitors);
        V_Table.refresh();


    }
    int Index=0;

    @FXML
    void UpdateVisitor(MouseEvent event) {
        ObservableList<AbstractVisitor> currentVisitors = V_Table.getItems();
        Index = V_Table.getSelectionModel().getSelectedIndex();

        boolean isChecked = editUserInfo(V_Email.getText(), V_Phone.getText());

        if (isChecked) {
            for (int i = 0; i < currentVisitors.size(); i++) {
                if (Index == i) {
                    currentVisitors.get(i).setUserEmail(V_Email.getText());
                    currentVisitors.get(i).name = V_Name.getText();
                    currentVisitors.get(i).setPhoneNumber(V_Phone.getText());
                    visitors.get(i).setPhoneNumber(V_Phone.getText());
                    visitors.get(i).setUserEmail(V_Email.getText());
                    visitors.get(i).name=V_Name.getText();
                    V_Table.setItems(currentVisitors);
                    V_Table.refresh();
                }
            }
        } else {
            String inValidTitle = "ERROR!!";
            String inValidMessage = "Check Email or Phone Number Regex";
            inValidMessage(inValidTitle, inValidMessage);
        }
    }

    public boolean editUserInfo(String email, String phoneNumber) {
        boolean validEmail = true;
        boolean validPhone = true;

        if (email != null && !email.isEmpty()) {
            validEmail = Registration.emailRegex(email);
        }

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            validPhone = Registration.phoneNumberRegex(phoneNumber);
        }

        return validEmail && validPhone;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<AbstractVisitor> visi= FXCollections.observableArrayList();
        for(AbstractVisitor vis: visitors)
        {
            visi.add(vis);
        }
        VisitorsNames.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        VisitorsId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));
        VisitorEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserEmail()));
        VisitorsPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));

        V_Table.setItems(visi);

    }

}