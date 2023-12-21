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
import java.util.Iterator;
import java.util.ResourceBundle;

import static coworking_space.coworks.EditInformationController.cVisitor;
import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;

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


//    public static void getRoomsArrayListFromMain(ArrayList<MeetingRoom> meeting_rooms,ArrayList<TeachingRoom> teaching_rooms,ArrayList<GeneralRoom> general_rooms){
//        meetingRooms=meeting_rooms;
//        teachingRooms=teaching_rooms;
//        generalRooms=general_rooms;
//    }


    private ArrayList<Slot> availableSlots = new ArrayList<>();

    // ObservableList to hold the slot strings for the ChoiceBox
    private ObservableList<String> observableSlots = FXCollections.observableArrayList();

    ArrayList<Slot> currentUserReservations;

    int roomOfCurrentUser;



    private void updateUserchoiceBox() {

        observableUserSlots.clear();

        // Populate the observable list with slot information
        for (Slot slot : currentUserReservations) {
           for(Slot.Reservation r : slot.reservations){
               String visitorEmail = r.getVisitor().userEmail;
               if ((DisplayUserDataController.cVisitor.userEmail).equals(visitorEmail)){

                   String slotInfo = slot.getStartTime() + " - " + slot.getEndTime() + " --> " +r.getReservationDate();
                   observableUserSlots.add(slotInfo);
               }
           }


        }

        // Set the updated observable list as the items for the ChoiceBox
        choicebox.setItems(observableUserSlots);
    }


    public void fillChoicebox(){

        if (currentUserReservations == null) {
            currentUserReservations = new ArrayList<>();
        } else {
            currentUserReservations.clear();
        }


        if(RegisterController.instructortype||LoginController.instructortype){

            for(int i=0;i<teachingRooms.size();i++){

                currentUserReservations= cVisitor.DisplayReservation(teachingRooms.get(i), Registration.getRegistration());



            }


        }else if (RegisterController.formaltype||LoginController.formaltype){

            for(int i=0;i<meetingRooms.size();i++){

                currentUserReservations= cVisitor.DisplayReservation(meetingRooms.get(i), Registration.getRegistration());


            }

        }else{

            for(int i=0;i<generalRooms.size();i++){

                currentUserReservations= cVisitor.DisplayReservation(generalRooms.get(i), Registration.getRegistration());


            }
        }
        updateUserchoiceBox();
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

        if (RegisterController.formaltype||LoginController.formaltype) {
            AbstractRoom meeting_room = meetingRooms.get(i);
            availableSlots = meeting_room.getAvailableSlots(newSelecteddate);


        } else if (RegisterController.instructortype||LoginController.instructortype) {
            AbstractRoom teaching_room = teachingRooms.get(i);
            availableSlots = teaching_room.getAvailableSlots(newSelecteddate);

        } else {

            AbstractRoom general_room = generalRooms.get(i);
            availableSlots = general_room.getAvailableSlots(newSelecteddate);

        }


        updatechoiceBox();
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
            String[] Twoparts = selectedSlot.split(" --> ");
            String timeInfo = Twoparts[0];
            String dateInfo = Twoparts[1];
           String [] timeparts= timeInfo.split(" - ");
            if (timeparts.length == 2) {

                String startTime = timeparts[0]; // Extract start time
                String endTime = timeparts[1];  // Extract end time

                // Now you have startTime and endTime
                System.out.println("Start Time: " + startTime);
                System.out.println("End Time: " + endTime);

                if(RegisterController.formaltype||LoginController.formaltype) {
                    for (AbstractRoom MR :meetingRooms ){
                        for (Slot slot : MR.slots) {
                            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                                for (Slot.Reservation r : slot.getReservations()) {
                                    String visitorEmail = r.getVisitor().userEmail;
                                    if ((DisplayUserDataController.cVisitor.userEmail).equals(visitorEmail)) {
                                        roomOfCurrentUser= r.getID();
                                    }
                                }
                            }
                        }
                    }
                }
                else if(RegisterController.instructortype||LoginController.instructortype){
                    for (AbstractRoom TR :teachingRooms ){
                        for (Slot slot : TR.slots) {
                            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                                for (Slot.Reservation r : slot.getReservations()) {
                                    String visitorEmail = r.getVisitor().userEmail;
                                    if ((DisplayUserDataController.cVisitor.userEmail).equals(visitorEmail)) {
                                        roomOfCurrentUser=r.getID();
                                    }
                                }
                            }
                        }
                    }
                }else{
                    for (AbstractRoom GR :generalRooms ){
                        for (Slot slot : GR.slots) {
                            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                                for (Slot.Reservation r : slot.getReservations()) {
                                    String visitorEmail = r.getVisitor().userEmail;
                                    if ((DisplayUserDataController.cVisitor.userEmail).equals(visitorEmail)) {
                                        roomOfCurrentUser=r.getID();
                                    }
                                }
                            }
                        }
                    }
                }


                if (RegisterController.formaltype||LoginController.formaltype) {

                    for(int i=0;i<meetingRooms.size();i++) {
                        cVisitor.cancelReservation(meetingRooms.get(i), Registration.getRegistration(), startTime, endTime);

                    }
                } else if (RegisterController.instructortype||LoginController.instructortype) {

                    for(int i=0;i<teachingRooms.size();i++) {
                        cVisitor.cancelReservation(teachingRooms.get(i), Registration.getRegistration(), startTime, endTime);
                    }
                } else {

                    for(int i=0;i<generalRooms.size();i++) {
                        cVisitor.cancelReservation(generalRooms.get(i), Registration.getRegistration(), startTime, endTime);
                    }
                }
            }

        }
        observableUserSlots.remove(selectedSlot);
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

        retrieveAvailableSlots(roomOfCurrentUser);
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
                if (RegisterController.formaltype||LoginController.formaltype) {
                    //FormalVisitor formalVisitor = new FormalVisitor();
                    cVisitor.makeReservation(meetingRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime,roomOfCurrentUser);
                } else if (RegisterController.instructortype||LoginController.instructortype) {

                    cVisitor.makeReservation(teachingRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime,roomOfCurrentUser);
                } else {

                    cVisitor.makeReservation(generalRooms.get(roomOfCurrentUser), newSelecteddate, startTime, endTime,roomOfCurrentUser);
                }
            }
        }
    }
    @FXML
    void replaceReservation(MouseEvent event) {
        updateReservationScreen.setVisible(true);
        DeleteSlot();

    }

    @FXML
    void saveNewReservation(MouseEvent event) {
        makeNewReservation();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillChoicebox();
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
