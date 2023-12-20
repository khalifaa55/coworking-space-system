package coworking_space.coworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;

import static coworking_space.coworks.DisplayUserDataController.cVisitor;

public class MakeReservationController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    private ArrayList<Slot> availableSlots = new ArrayList<>();

    // ObservableList to hold the slot strings for the ChoiceBox
    private ObservableList<String> observableSlots = FXCollections.observableArrayList();
//

//    public static void getRoomsArrayListFromMain(ArrayList<AbstractRoom> meeting_rooms, ArrayList<AbstractRoom> teaching_rooms, ArrayList<AbstractRoom> general_rooms) {
//        for (AbstractRoom room : meeting_rooms) {
//            if (room instanceof MeetingRoom) {
//                MeetingRoom MR = (MeetingRoom) room;
//                meetingRooms.add(MR);
//            }
//        }
//
//        for (AbstractRoom room : teaching_rooms) {
//            if (room instanceof TeachingRoom) {
//                TeachingRoom TR = (TeachingRoom) room;
//                teachingRooms.add(TR);
//            }
//        }
//
//        for (AbstractRoom room : general_rooms) {
//            if (room instanceof GeneralRoom) {
//                GeneralRoom GR = (GeneralRoom) room;
//                generalRooms.add(GR);
//            }
//        }
//    }

//    public static void getarraylistfromMain(ArrayList<AbstractRoom> ){
//        teachingRooms=teaching_rooms;
//    }
//    public static void getarraylistfrommMain(ArrayList<AbstractRoom> genaral_rooms){
//        generalRooms=genaral_rooms;
//    }


    @FXML
    private Button DisplayinfoButton;

    @FXML
    private RadioButton Room1;

    @FXML
    private RadioButton Room2;

    @FXML
    private RadioButton Room3;

    @FXML
    private ToggleGroup Rooms;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button logoutButton;

    @FXML
    private Button save;

    @FXML
    private Button updateReservationButton;

    @FXML
    private AnchorPane visitorScreen;

    private String SelectedRoom;
    private String Room;
    int index;
    LocalDate selectedDate;
    LocalDate currentDate=LocalDate.now();

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
    void getDate(ActionEvent event) {
        selectedDate = datepicker.getValue();
        if(selectedDate.isAfter(currentDate.plusDays(30))){
            inValidMessage("ERROR!","choose a date within 30 days");

        }
        else if (selectedDate.isBefore(currentDate)) {
            inValidMessage("ERROR!", "invalid date");
        }
    }
    private void updatechoiceBox() {
        // Clear the observable list
        observableSlots.clear();

        // Populate the observable list with slot information
        for (Slot slot : availableSlots) {
            // Customize this to format the slot information as needed
            String slotInfo = slot.getStartTime() + " - " + slot.getEndTime();
            observableSlots.add(slotInfo);
        }

        // Set the updated observable list as the items for the ChoiceBox
        choiceBox.setItems(observableSlots);
    }

//   private void retrieveAvailableSlots(int i) {
//        availableSlots.clear();
//
//        if ( RegisterController.formaltype) {
//
//            MeetingRoom meeting_room = meetingRooms.get(i);
//            availableSlots = meeting_room.getAvailableSlots(selectedDate);
//
//
//        } else if (RegisterController.instructortype) {
//            TeachingRoom teaching_room = teachingRooms.get(i);
//            availableSlots = teaching_room.getAvailableSlots(selectedDate);
//        }
//        else {
//            Room3.setVisible(false);
//            GeneralRoom general_room = generalRooms.get(i);
//            availableSlots = general_room.getAvailableSlots(selectedDate);
//        }
//
//        updatechoiceBox();
//    }


    private void retrieveAvailableSlots(int i) {
        availableSlots.clear();

        if (RegisterController.formaltype && meetingRooms != null && i < meetingRooms.size()) {
            AbstractRoom room = meetingRooms.get(i);
            if (room instanceof MeetingRoom) {
                MeetingRoom meeting_room = (MeetingRoom) room;
                availableSlots = meeting_room.getAvailableSlots(selectedDate);
            }
        } else if (RegisterController.instructortype && teachingRooms != null && i < teachingRooms.size()) {
            AbstractRoom room = teachingRooms.get(i);
            if (room instanceof TeachingRoom) {
                TeachingRoom teaching_room = (TeachingRoom) room;
                availableSlots = teaching_room.getAvailableSlots(selectedDate);
            }
        } else if (generalRooms != null && i < generalRooms.size()) {
            Room3.setVisible(false);
            AbstractRoom room = generalRooms.get(i);
            if (room instanceof GeneralRoom) {
                GeneralRoom general_room = (GeneralRoom) room;
                availableSlots = general_room.getAvailableSlots(selectedDate);
            }
        }

        updatechoiceBox();
    }

    private void handleRadioButtonSelection_1(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) event.getSource();
        Room = selectedRadioButton.getText();

        if(Room.equals("Room_1")) {
            // leave the spaces for the GUI to look better
            System.out.println("room1");
            retrieveAvailableSlots(0);
            index=0;
        }
        else if (Room.equals("Room_2")) {

            System.out.println("room2");
            retrieveAvailableSlots(1);
            index=1;
        }
        else{

            System.out.println("room3");
            retrieveAvailableSlots(2);
            index=2;
        }
    }

    void MakeReservation (){
        String selectedSlot = choiceBox.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            // Split the selected slot string to extract start time and end time
            String[] parts = selectedSlot.split(" - ");
            if (parts.length == 2) {
                String startTime = parts[0]; // Extract start time
                String endTime = parts[1];   // Extract end time

                // Now you have startTime and endTime
                System.out.println("Start Time: " + startTime);
                System.out.println("End Time: " + endTime);

                // Pass these values to the appropriate visitor's makeReservation method
                if (RegisterController.formaltype) {
                   // FormalVisitor formalVisitor = new FormalVisitor("fagr",123);
                    cVisitor.makeReservation(meetingRooms.get(index), selectedDate, startTime, endTime);
                }
                else if (RegisterController.instructortype) {
                    //InstructorVisitor instructorVisitor = new InstructorVisitor();
                    cVisitor.makeReservation(teachingRooms.get(index), selectedDate, startTime, endTime);
                }
                else {
                    //GeneralVisitor generalVisitor = new GeneralVisitor();
                    cVisitor.makeReservation(generalRooms.get(index), selectedDate, startTime, endTime);
                }
            }
        }
    }

    @FXML
    void getselectedslot(MouseEvent event) {

        if(selectedDate.isAfter(currentDate.plusDays(30))){
            inValidMessage("ERROR!","choose a date within 30 days");

        }
        else if (selectedDate.isBefore(currentDate)) {
            inValidMessage("ERROR!", "invalid date");

        }
        else{
            MakeReservation();}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Room1.setOnAction(this::handleRadioButtonSelection_1);
        Room2.setOnAction(this::handleRadioButtonSelection_1);
        Room3.setOnAction(this::handleRadioButtonSelection_1);


        if (RegisterController.generaltype){
            Room3.setVisible(false);
        }


        // leave the spaces for the GUI to look better

        //choiceBox.setItems(observableSlots);
       // choiceBox.getItems().addAll(room1Options);

        //System.out.println("Size of meetingRooms: " + meetingRooms.size());
        // Add default options to the ChoiceBox
    }

    @FXML
    void changeScreenToUpdateReservationScreen(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)updateReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToDisplayInfoScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)displayUserDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) visitorScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
