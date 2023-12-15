package coworking_space.coworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class VisitorController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    private ArrayList<Slot> availableSlots = new ArrayList<>();

    // ObservableList to hold the slot strings for the ChoiceBox
    private ObservableList<String> observableSlots = FXCollections.observableArrayList();


    @FXML
    private RadioButton Room1;

    @FXML
    private RadioButton Room2;

    @FXML
    private RadioButton Room3;


    @FXML
    void getRoom1(MouseEvent event) {
//        private void updatechoiceBox() {
//            // Clear the observable list
//            observableSlots.clear();
//
//            // Populate the observable list with slot information
//            for (Slot slot : availableSlots) {
//                // Customize this to format the slot information as needed
//                String slotInfo = slot.getStartTime() + " - " + slot.getEndTime();
//                observableSlots.add(slotInfo);
//            }
//
//            // Set the updated observable list as the items for the ChoiceBox
//            choiceBox.setItems(observableSlots);
//        }
//
//        // Method to retrieve available slots and update the ChoiceBox
//        private void retrieveAvailableSlots() {
//            if(RegisterController.formaltype){
//
//            } else if (RegisterController.instructortype) {
//
//            }else{
//
//            }
//
//
//            updatechoiceBox();
//        }




    }


    void getRoom2(MouseEvent event) {
        choiceBox.getItems().clear();



    }

    @FXML
    void getRoom3(MouseEvent event) {
        choiceBox.getItems().clear();



    }

    @FXML
    void getselectedslot(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
