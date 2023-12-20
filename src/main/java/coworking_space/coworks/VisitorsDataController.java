package coworking_space.coworks;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.collections.ObservableList;
//import static coworking_space.coworks.MyMain.Visitors;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;
import static coworking_space.coworks.Coworks_Main.visitors;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @FXML
    void ChoosenVisitor(MouseEvent event) {
        int Index=0;

        AbstractVisitor ClickedVisitor = V_Table.getSelectionModel().getSelectedItem();
        V_ID.setText(String.valueOf(ClickedVisitor.id));
        V_Name.setText(ClickedVisitor.name);
        V_Email.setText(ClickedVisitor.userEmail);
        V_Phone.setText(ClickedVisitor.phoneNumber);
    }

    @FXML
    void DeleteVisitor(MouseEvent event) {
        ObservableList<AbstractVisitor> currentVisitors = V_Table.getItems();

        Index= V_Table.getSelectionModel().getSelectedIndex();

        for(AbstractVisitor V:currentVisitors) {
            V_ID.setText("");
            V_Name.setText("");
            V_Email.setText("");
            V_Phone.setText("");
            visitors.remove(Index);
            currentVisitors.remove(Index);
            V_Table.setItems(currentVisitors);
            V_Table.refresh();
            break; // <-- This break statement exits the loop after the first iteration
        }

        for(AbstractVisitor V :visitors){
            System.out.println(V.id);
            System.out.println(V.name);
        }
    }
    int Index=0;

    @FXML
    void UpdateVisitor(MouseEvent event) {

        ObservableList<AbstractVisitor> currentVisitors = V_Table.getItems();
         Index=V_Table.getSelectionModel().getSelectedIndex();
        for (int i=0 ; i<currentVisitors.size() ; i++) {

            if (i==Index) {
                currentVisitors.get(i).id = Integer.parseInt(V_ID.getText());
                currentVisitors.get(i).name = V_Name.getText();
                currentVisitors.get(i).userEmail = V_Email.getText();
                currentVisitors.get(i).phoneNumber = V_Phone.getText();
                V_Table.setItems(currentVisitors);
                V_Table.refresh();
                break;
            }
        }

        for(AbstractVisitor V :visitors){
            System.out.println(V.id);
            System.out.println(V.name);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<AbstractVisitor> visi= FXCollections.observableArrayList();
        for(AbstractVisitor vis: visitors)
        {
            System.out.println(vis.id);
            visi.add(vis);
        }
        VisitorsNames.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        VisitorsId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));
        VisitorEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().userEmail));
        VisitorsPhone.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().phoneNumber));

       V_Table.setItems(visi);

    }

}
