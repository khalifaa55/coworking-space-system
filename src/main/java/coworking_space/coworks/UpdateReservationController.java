package coworking_space.coworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateReservationController implements Initializable {


    @FXML
    private Button D_button;

    @FXML
    private Button R_button;
    @FXML
    private ImageView c_screen;

    @FXML
    private ChoiceBox<String> choicebox;

    @FXML
    private DatePicker date_picker;
    @FXML
    private Button displayInfoButton;

    @FXML
    private Button makeReservationButton;

    @FXML
    private Button saveButton;

    @FXML
    private ChoiceBox<String> slotChoiceBox;
    @FXML
    public AnchorPane updateReservationScreen;
    LocalDate newSelecteddate ;
    LocalDate currentDate=LocalDate.now();

    private ObservableList<String> observableUserSlots = FXCollections.observableArrayList();

    public static  ArrayList<MeetingRoom> meetingRooms;
    public static ArrayList<TeachingRoom> teachingRooms;
    public static ArrayList<GeneralRoom> generalRooms;
    public static void getRoomsArrayListFromMain(ArrayList<MeetingRoom> meeting_rooms,ArrayList<TeachingRoom> teaching_rooms,ArrayList<GeneralRoom> general_rooms){
        meetingRooms=meeting_rooms;
        teachingRooms=teaching_rooms;
        generalRooms=general_rooms;
    }
//    public static void getarraylistfrommain(ArrayList<AbstractRoom> meeting_rooms){
//        meetingRooms=meeting_rooms;
//    }
//
//    public static void getarraylistfromMain(ArrayList<AbstractRoom> teaching_rooms){
//        teachingRooms=teaching_rooms;
//    }
//    public static void getarraylistfrommMain(ArrayList<AbstractRoom> genaral_rooms){
//        generalRooms=genaral_rooms;
//    }


    private ArrayList<Slot> availableSlots = new ArrayList<>();

    // ObservableList to hold the slot strings for the ChoiceBox
    private ObservableList<String> observableSlots = FXCollections.observableArrayList();

    ArrayList<Slot> currentUserReservations;

    int roomOfCurrentUser;


    private void updateUserchoiceBox() {
        // Clear the observable list
        observableUserSlots.clear();

        // Populate the observable list with slot information
        for (Slot slot : currentUserReservations) {
            // Customize this to format the slot information as needed
            String slotInfo = slot.getStartTime() + " - " + slot.getEndTime();
            observableUserSlots.add(slotInfo);
        }

        // Set the updated observable list as the items for the ChoiceBox
        choicebox.setItems(observableUserSlots);
    }


    public void fillChoicebox(){
        currentUserReservations.clear();;

        if(RegisterController.instructortype){
            InstructorVisitor instructorVisitor = new InstructorVisitor();
            for(int i=0;i<teachingRooms.size();i++){

                currentUserReservations= instructorVisitor.DisplayReservation(teachingRooms.get(i), Registration.getRegistration());
                roomOfCurrentUser=i;

            }


        }else if (RegisterController.formaltype){
            FormalVisitor formalVisitor = new FormalVisitor();
            for(int i=0;i<meetingRooms.size();i++){

                currentUserReservations= formalVisitor.DisplayReservation(meetingRooms.get(i), Registration.getRegistration());
                roomOfCurrentUser=i;

            }

        }else{
            GeneralVisitor generalVisitor = new GeneralVisitor();
            for(int i=0;i<generalRooms.size();i++){

                currentUserReservations= generalVisitor.DisplayReservation(generalRooms.get(i), Registration.getRegistration());
                roomOfCurrentUser=i;

            }
        }
        fillChoicebox();;


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
        slotChoiceBox.setItems(observableSlots);
    }

    private void retrieveAvailableSlots(int i) {
        availableSlots.clear();

        if (RegisterController.formaltype) {
            AbstractRoom meeting_room = meetingRooms.get(i);
            availableSlots = meeting_room.getAvailableSlots(newSelecteddate);


        } else if (RegisterController.instructortype) {
            AbstractRoom teaching_room = teachingRooms.get(i);
            availableSlots = teaching_room.getAvailableSlots(newSelecteddate);

        } else {

            AbstractRoom general_room = generalRooms.get(i);
            availableSlots = general_room.getAvailableSlots(newSelecteddate);

        }


        updateUserchoiceBox();
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



    void DeleteSlot (){
        String selectedSlot = choicebox.getSelectionModel().getSelectedItem();
        if (selectedSlot != null) {
            // Split the selected slot string to extract start time and end time
            String[] parts = selectedSlot.split(" - ");
            if (parts.length == 2) {
                String startTime = parts[0]; // Extract start time
                String endTime = parts[1];   // Extract end time

                // Now you have startTime and endTime
                System.out.println("Start Time: " + startTime);
                System.out.println("End Time: " + endTime);

                if (RegisterController.formaltype) {
                    FormalVisitor formalVisitor = new FormalVisitor();
                    for(int i=0;i<meetingRooms.size();i++) {
                        formalVisitor.cancelReservation(meetingRooms.get(i), Registration.getRegistration(), startTime, endTime);
                    }
                } else if (RegisterController.instructortype) {
                    InstructorVisitor instructorVisitor = new InstructorVisitor();
                    for(int i=0;i<teachingRooms.size();i++) {
                        instructorVisitor.cancelReservation(teachingRooms.get(i), Registration.getRegistration(), startTime, endTime);
                    }
                } else {
                    GeneralVisitor generalVisitor = new GeneralVisitor();
                    for(int i=0;i<generalRooms.size();i++) {
                        generalVisitor.cancelReservation(generalRooms.get(i), Registration.getRegistration(), startTime, endTime);
                    }
                }
            }
        }
    }

    @FXML
    void deletSlot(MouseEvent event) {
        DeleteSlot();
    }
    @FXML
    void getDate(ActionEvent event) {

        newSelecteddate=date_picker.getValue();
        if(newSelecteddate.isAfter(currentDate.plusDays(30))){
            inValidMessage("ERROR!","choose a date within 30 days");

        } else if (newSelecteddate.isBefore(currentDate)) {

            inValidMessage("ERROR!", "invalid date");
        }
    }
    void makeNewReservation(){

        String selectedSlot = slotChoiceBox.getSelectionModel().getSelectedItem();
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
                    formalVisitor.makeReservation(meetingRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime);
                } else if (RegisterController.instructortype) {
                    InstructorVisitor instructorVisitor = new InstructorVisitor();
                    instructorVisitor.makeReservation(teachingRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime);
                } else {
                    GeneralVisitor generalVisitor = new GeneralVisitor();
                    generalVisitor.makeReservation(generalRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime);
                }
            }
        }
    }
    @FXML
    void replaceReservation(MouseEvent event) {
        updateReservationScreen.setVisible(true);
        DeleteSlot();
        makeNewReservation();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    void changeScreenToDisplayInfoScreen_2(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)displayUserDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateReservationScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToMakeReservationScreen_2(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("(visitor)MakeReservationScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateReservationScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void logout_2(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateReservationScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
}
