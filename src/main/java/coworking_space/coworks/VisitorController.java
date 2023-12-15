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

    private ArrayList<AbstractRoom> meetingRooms = Coworks_Main.meetingRooms;
    private ArrayList<Slot> slots  = Coworks_Main.Mslots;
    private ArrayList<Slot> slots2  = Coworks_Main.Mslots2;
    private ArrayList<Slot> slots3  = Coworks_Main.Mslots3;
    private ArrayList<FormalVisitor> insts=Coworks_Main.formals;
    private ArrayList<FormalVisitor> insts2=Coworks_Main.formals2;
    private ArrayList<FormalVisitor> insts3=Coworks_Main.formals3;



    @FXML
    private RadioButton Room1;

    @FXML
    private RadioButton Room2;

    @FXML
    private RadioButton Room3;
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

        if(RegisterController.formaltype){
            AbstractRoom meeting_room = meetingRooms.get(i);
            availableSlots = meeting_room.getAvailableSlots();


        } else if (RegisterController.instructortype) {

        }else{

        }


        updatechoiceBox();
    }


    @FXML
    void getRoom1(MouseEvent event) {

        retrieveAvailableSlots(0);
    }


    void getRoom2(MouseEvent event) {
        retrieveAvailableSlots(1);

    }

    @FXML
    void getRoom3(MouseEvent event) {

        retrieveAvailableSlots(2);
    }

    @FXML
    void getselectedslot(MouseEvent event) {
        String selectedSlot = choiceBox.getSelectionModel().getSelectedItem();
        // Use the selected slot as needed
        System.out.println("Selected Slot: " + selectedSlot);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(observableSlots);
    }
}
