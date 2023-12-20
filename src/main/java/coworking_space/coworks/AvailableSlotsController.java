package coworking_space.coworks;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import javafx.fxml.FXMLLoader;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.util.Callback;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AvailableSlotsController implements Initializable {



    @FXML
    private TableView<Slot> AvailableTA;

    @FXML
    private TableColumn<Slot, LocalDate> Date;


    @FXML
    private TableColumn<Slot, String> EndTime;

    @FXML
    private TableColumn<Slot, Double> Fees;


    @FXML
    private RadioButton GeneralRadio;

    @FXML
    private Button LogOutButton1;

    @FXML
    private RadioButton MeetingRadio;

    @FXML
    private Button RoomDataButton;

    @FXML
    private TextField Roomid1;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private TableColumn<Slot, String> StartTime;



    @FXML
    private RadioButton TeachingRadio;

    @FXML
    private Button VisitorsData;
    @FXML
    private ToggleGroup Types;

    @FXML
    private ImageView availableSlotsImage;

    @FXML
    private AnchorPane availableSlotsScreen;

    public ArrayList<Slot> Mslots = new ArrayList<>();
    public ArrayList<Slot> Gslots = new ArrayList<>();

    public ArrayList<Slot> Tslots = new ArrayList<>();

    public ArrayList<InstructorVisitor> I_visitprs = new ArrayList<>();
    public ArrayList<GeneralVisitor> G_visitprs = new ArrayList<>();
    public ArrayList<FormalVisitor> F_visitprs = new ArrayList<>();

    Slot slot1 = new Slot("8", "10", 100.00, LocalDate.of(2023, 12, 19));
    Slot slot2 = new Slot("10", "12", 300, LocalDate.of(2023, 12, 20));
    Slot slot3 = new Slot("8", "10", 100.00, LocalDate.of(2023, 12, 21));
    Slot slot4 = new Slot("10", "12", 300, LocalDate.of(2023, 12, 22));
    Slot slot5 = new Slot("8", "10", 100.00, LocalDate.of(2023, 12, 23));
    Slot slot6 = new Slot("10", "12", 300, LocalDate.of(2023, 12, 24));
    InstructorVisitor Ivisitor_2 = new InstructorVisitor("Fagor", 3);
    FormalVisitor Fvisitor_2 = new FormalVisitor("Fagor", 3);
    GeneralVisitor Gvisitor_2 = new GeneralVisitor("Fagor", 3);

    ArrayList<AbstractRoom> GRooms = new ArrayList<>(3);
    ArrayList<AbstractRoom> TRooms = new ArrayList<>(2);
    ArrayList<AbstractRoom> MRooms = new ArrayList<>(2);




    @FXML
    void changeScreenDisplayRoomsDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenUpdateRoomDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)updateRoomScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void changeScreenToVisitorsDataScreen_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)visitorsDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void LogOut_2(MouseEvent event) throws IOException {
// Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) availableSlotsScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    int SelectedSlot;
    String Typee;
    int RoonID;
    @FXML
    void DeleteSlot(MouseEvent event) {
        ObservableList<Slot> available=AvailableTA.getItems();

        SelectedSlot = AvailableTA.getSelectionModel().getSelectedIndex();
        if(Typee.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:GRooms)
            {
                if(RoonID==R.id) {
                   R.slots.remove(SelectedSlot);
                   available.remove(SelectedSlot);
                }

            }
        } else if (Typee.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :TRooms)
            {
                if(RoonID== R.id)
                {

                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);


                }
            }

        }
        else {
            for(AbstractRoom R:MRooms)
            {
                if(RoonID == R.id)
                {

                    R.slots.remove(SelectedSlot);
                    available.remove(SelectedSlot);

                }
            }
        }
        AvailableTA.setItems(available);
        AvailableTA.refresh();
        for(AbstractRoom R:GRooms)
        {
            for(Slot S: R.getAvailableSlotsForAdmin())
            {
                System.out.println(S.getStartTime());
            }
        }
    }

    @FXML
    void DisplaySlots(MouseEvent event) {
        Typee=String.valueOf(Types.getSelectedToggle());
        RoonID=Integer.parseInt(Roomid1.getText());
        SelectedRoom(Typee,RoonID);
    }

    public void SelectedRoom(String Type , int Id)
    {
        ObservableList<Slot> available=FXCollections.observableArrayList();

        if(Type.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:GRooms)
            {
                if(Id==R.id) {
                    for (Slot S : R.slots) {
                        System.out.println(S.getStartTime());
                        available.add(S);
                    }
                }

            }
        } else if (Type.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :TRooms)
            {
                if(Id== R.id)
                {
                    for(Slot S:R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }

        }
        else {
            for(AbstractRoom R:MRooms)
            {
                if(Id == R.id)
                {
                    for(Slot S :R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }
        }
        Date.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("Sdate"));
        StartTime.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndTime.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        Fees.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        AvailableTA.setItems(available);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Slot S_0 = new Slot("9" , "11",150,LocalDate.of(2023,12,19));
        Mslots.add(S_0);
        Mslots.add(slot1);
        Mslots.add(slot2);
        Gslots.add(slot3);
        Gslots.add(slot4);
        Tslots.add(slot5);
        Tslots.add(slot6);
//
        I_visitprs.add(Ivisitor_2);
//        I_visitprs.add(Ivisitor_3);
        F_visitprs.add(Fvisitor_2);
//        F_visitprs.add(Fvisitor_3);
        G_visitprs.add(Gvisitor_2);
//        G_visitprs.add(Gvisitor_3);
        GRooms.add(null);  // Or any initial value you want
        TRooms.add(null);
        MRooms.add(null);
//
//        Mslots.get(0).createReservation(Gvisitor_2);
//        Mslots.get(0).createReservation(Gvisitor_3);
//
//
        AbstractRoom Groom = new GeneralRoom("G1", 2, Gslots, G_visitprs);
        GRooms.set(0, Groom);
        AbstractRoom Troom = new TeachingRoom("T1", 3, Tslots, I_visitprs);
        TRooms.set(0, Troom);
        AbstractRoom Mroom = new MeetingRoom("M1", 1, Mslots, F_visitprs);
        MRooms.set(0, Mroom);


  }
}
