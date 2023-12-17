package coworking_space.coworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;



public  class VisitorController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    private ArrayList<Slot> availableSlots = new ArrayList<>();

    // ObservableList to hold the slot strings for the ChoiceBox
    private ObservableList<String> observableSlots = FXCollections.observableArrayList();
//
    public static  ArrayList<AbstractRoom> meetingRooms;
    public static ArrayList<AbstractRoom> teachingRooms;
    public static ArrayList<AbstractRoom> generalRooms;
    public static void getarraylistfrommain(ArrayList<AbstractRoom> meeting_rooms){
        meetingRooms=meeting_rooms;
    }

    public static void getarraylistfromMain(ArrayList<AbstractRoom> teaching_rooms){
        teachingRooms=teaching_rooms;
    }
    public static void getarraylistfrommMain(ArrayList<AbstractRoom> genaral_rooms){
        generalRooms=genaral_rooms;
    }




    @FXML
    private RadioButton Room1;
    private String Room;

    @FXML
    private RadioButton Room2;

    @FXML
    public RadioButton Room3;
    private String SelectedRoom;

    @FXML
    private Button save;

    @FXML
    private ToggleGroup Rooms;

    public DatePicker datepicker;
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

        } else if (selectedDate.isBefore(currentDate)) {

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

    private void retrieveAvailableSlots(int i) {
        availableSlots.clear();

        if (RegisterController.formaltype) {
            AbstractRoom meeting_room = meetingRooms.get(i);
            availableSlots = meeting_room.getAvailableSlots(selectedDate);


        } else if (RegisterController.instructortype) {
            AbstractRoom teaching_room = teachingRooms.get(i);
            availableSlots = teaching_room.getAvailableSlots(selectedDate);

        } else {
            Room3.setVisible(false);
            AbstractRoom general_room = generalRooms.get(i);
            availableSlots = general_room.getAvailableSlots(selectedDate);

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

        } else if (Room.equals("Room_2")) {

            System.out.println("room2");
            retrieveAvailableSlots(1);

        }else{

            System.out.println("room3");
            retrieveAvailableSlots(2);
        }


    }





    @FXML
    void getselectedslot(MouseEvent event) {
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
                    FormalVisitor formalVisitor = new FormalVisitor();
                    formalVisitor.makeReservation(meetingRooms.get(0), selectedDate, startTime, endTime);
                } else if (RegisterController.instructortype) {
                    InstructorVisitor instructorVisitor = new InstructorVisitor();
                    instructorVisitor.makeReservation(teachingRooms.get(0), selectedDate, startTime, endTime);
                } else {
                    GeneralVisitor generalVisitor = new GeneralVisitor();
                    generalVisitor.makeReservation(generalRooms.get(0), selectedDate, startTime, endTime);
                }
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Room1.setOnAction(this::handleRadioButtonSelection_1);
        Room2.setOnAction(this::handleRadioButtonSelection_1);
        Room3.setOnAction(this::handleRadioButtonSelection_1);


        // leave the spaces for the GUI to look better

        //choiceBox.setItems(observableSlots);
       // choiceBox.getItems().addAll(room1Options);

        //System.out.println("Size of meetingRooms: " + meetingRooms.size());
    }
}
