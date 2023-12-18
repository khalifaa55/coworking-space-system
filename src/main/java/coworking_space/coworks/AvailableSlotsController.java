package coworking_space.coworks;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import javafx.fxml.FXMLLoader;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AvailableSlotsController implements Initializable {

    @FXML
    private TableView<AbstractRoom> AvailableTable;
    @FXML
    private TableColumn<AbstractRoom, String> RoomId;
    @FXML
    private Button AddSlotButton;

    @FXML
    private TableColumn<AbstractRoom, String> Date;

    @FXML
    private TextField EbdTineText;

    @FXML
    private TableColumn<AbstractRoom, String> EndTime;

    @FXML
    private TableColumn<AbstractRoom, String> Fees;

    @FXML
    private TextField FeesText;

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button RoomDataButton;

    @FXML
    private TextField Roomid;

    @FXML
    private TableColumn<AbstractRoom,String> RoomName;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private TableColumn<AbstractRoom, String> RoonTy;

    @FXML
    private TextField SlotDate;

    @FXML
    private TableColumn<AbstractRoom, String> StartTime;

    @FXML
    private TextField StartTimetEXT;

    @FXML
    private Button VisitorsData;

    @FXML
    private ImageView availableSlotsImage;

    @FXML
    private AnchorPane availableSlotsScreen;
    AbstractRoom SelectedRoom ;
    public  ArrayList<Slot> Mslots = new ArrayList<>();
    public  ArrayList<InstructorVisitor> I_visitprs = new ArrayList<>();
    public  ArrayList<GeneralVisitor> G_visitprs = new ArrayList<>();
    public  ArrayList<FormalVisitor> F_visitprs = new ArrayList<>();

    Slot slot1 = new Slot("8", "10", 100.00);
    Slot slot2 = new Slot("10", "12", 300);
    InstructorVisitor Ivisitor_2=new InstructorVisitor("Fagor",3);
    InstructorVisitor Ivisitor_3=new InstructorVisitor("Fago",4);

    FormalVisitor Fvisitor_3=new FormalVisitor("Fago",4);
    FormalVisitor Fvisitor_2=new FormalVisitor("Fagor",3);
    GeneralVisitor Gvisitor_3=new GeneralVisitor("Fago",4);
    GeneralVisitor Gvisitor_2=new GeneralVisitor("Fagor",3);

    ArrayList<AbstractRoom> GRooms = new ArrayList<>(3);
    ArrayList<AbstractRoom> TRooms = new ArrayList<>(2);
    ArrayList<AbstractRoom> MRooms = new ArrayList<>(2);



    @FXML
    void AddSlot(MouseEvent event) {

    }
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

//    public void DisplayAllSlots()
//    {
//        ObservableList<AbstractRoom> rooms = FXCollections.observableArrayList();
////        ArrayList<AbstractRoom> Room ;
//        for(AbstractRoom Gr :GRooms) {
//          rooms.add(Gr);
//        }
//        for(AbstractRoom Tr :TRooms)
//        {
//            rooms.add(Tr);
//
//        }
//        for(AbstractRoom Mr :MRooms)
//        {
//            rooms.add(Mr);
//
//        }
//        RoomId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));
//        RoomName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
//
//        RoonTy.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoomType()));
//        Date.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().availableslots.get(0).currentDate)));
//
//        StartTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().availableslots.get(0).getStartTime()));
//        EndTime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().availableslots.get(0).getEndTime()));
//        Fees.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().availableslots.get(0).getFees())));
//        AvailableTable.setItems(rooms);
//    }
public void DisplayAllSlots() {
    ObservableList<AbstractRoom> rooms = FXCollections.observableArrayList();

    for (AbstractRoom Gr : GRooms) {
        rooms.add(Gr);
    }
    for (AbstractRoom Tr : TRooms) {
        rooms.add(Tr);
    }
    for (AbstractRoom Mr : MRooms) {
        rooms.add(Mr);
    }

    RoomId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));
    RoomName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
    RoonTy.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoomType()));

    // Check if the room has available slots
    Date.setCellValueFactory(cellData -> {
        ArrayList<Slot> availableSlots = cellData.getValue().getAvailableSlotsForAdmin();
        return new SimpleStringProperty(availableSlots.isEmpty() ? "" : String.valueOf(availableSlots.get(0).getCurrentDate()));
    });

    // Check if the room has available slots
    StartTime.setCellValueFactory(cellData -> {
        ArrayList<Slot> availableSlots = cellData.getValue().getAvailableSlotsForAdmin();
        return new SimpleStringProperty(availableSlots.isEmpty() ? "" : availableSlots.get(0).getStartTime());
    });

    // Check if the room has available slots
    EndTime.setCellValueFactory(cellData -> {
        ArrayList<Slot> availableSlots = cellData.getValue().getAvailableSlotsForAdmin();
        return new SimpleStringProperty(availableSlots.isEmpty() ? "" : availableSlots.get(0).getEndTime());
    });

    // Check if the room has available slots
    Fees.setCellValueFactory(cellData -> {
        ArrayList<Slot> availableSlots = cellData.getValue().getAvailableSlotsForAdmin();
        return new SimpleStringProperty(availableSlots.isEmpty() ? "" : String.valueOf(availableSlots.get(0).getFees()));
    });

    AvailableTable.setItems(rooms);
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Slot S_0 = new Slot("9" , "11",150);
        Mslots.add(S_0);
        Mslots.add(slot1);
        Mslots.add(slot2);

        I_visitprs.add(Ivisitor_2);
        I_visitprs.add(Ivisitor_3);
        F_visitprs.add(Fvisitor_2);
        F_visitprs.add(Fvisitor_3);
        G_visitprs.add(Gvisitor_2);
        G_visitprs.add(Gvisitor_3);
        GRooms.add(null);  // Or any initial value you want
        TRooms.add(null);
        MRooms.add(null);

        Mslots.get(0).createReservation(Gvisitor_2);
        Mslots.get(0).createReservation(Gvisitor_3);


        AbstractRoom Groom = new GeneralRoom("G1", 2, Mslots, G_visitprs);
        GRooms.set(0, Groom);
        AbstractRoom Troom = new TeachingRoom("T1", 3, Mslots, I_visitprs);
        TRooms.set(0, Troom);
        AbstractRoom Mroom = new MeetingRoom("M1", 1, Mslots, F_visitprs);
        MRooms.set(0, Mroom);
        DisplayAllSlots();
    }
}
