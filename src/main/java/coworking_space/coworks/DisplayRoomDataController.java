package coworking_space.coworks;


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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;


import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DisplayRoomDataController implements Initializable {
    @FXML
    private TableView<Slot> AvailableSlotsTable;
    @FXML
    private TableColumn<Slot, String> StartTimeColumn;
    @FXML
    private TableColumn<Slot, String> DateColumn;

    @FXML
    private TableColumn<Slot, String> EndTimeColumn;

    @FXML
    private TableColumn<Slot, String> FeesColumn;

    @FXML
    private Button LogOutButton;

    @FXML
    private TableView<Slot> ReservedSlotsTable;

    @FXML
    private Label RoomProfit;

    private ObservableList<String> observableList = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> RoomTyprComboBox;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private ChoiceBox<String> RoomsIdComboBox;

    @FXML
    private Label SelectedRoomID;

    @FXML
    private Label SelectedRoomName;

    @FXML
    private Button UpdateRoom;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableView<AbstractVisitor> VisitorsTable;
    @FXML
    private TableColumn<AbstractVisitor,String> VisitorsIdColumn;

    @FXML
    private TableColumn<AbstractVisitor,String> VisitorsNameColumn;

    @FXML
    private AnchorPane displayRoomDataScreen;

    @FXML
    private ImageView displayRoomDataImage;

    Admin alshimaa = new Admin();

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
    void changeScreenToAvailableSlotsScreen_1(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)availableSlotsScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) displayRoomDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void changeScreenToUpdateRoomDataDataScreen_1(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)updateRoomScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) displayRoomDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void changeScreenToVisitorsDataScreen_1(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)visitorsDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) displayRoomDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void LogOut_1(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) displayRoomDataScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();

    }


    public void updateRoomsIdComboBox(String roomType) {
        String selectedId;
        // Clear existing items
        RoomsIdComboBox.getItems().clear();

        // Add new IDs based on the selected room type
        if ("General".equals(roomType)) {
            for (AbstractRoom room : GRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().addAll(myString);

                }
            }
        } else if ("Teaching".equals(roomType)) {
            for (AbstractRoom room : TRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().addAll(myString);
                }
            }
        } else if ("Meeting".equals(roomType)) {
            for (AbstractRoom room : MRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().addAll(myString);


                }
            }
            selectedId = RoomsIdComboBox.getValue();
//            UpdateRoomData(selectedId);
        }
//        findRoomById(selectedId);



    }


//        SelectedRoomID.setText(String.valueOf(SelectedRoom.id));
//        SelectedRoomName.setText(SelectedRoom.name);
//        VisitorsTable.setItems(FXCollections.observableArrayList(SelectedRoom.visitors));
//        UpdateRoomData();

    void DisplayRoomVistor(String Id) {

        for(AbstractRoom r :MRooms) {
            if(Id.equals(String.valueOf(r.id))) {
                SelectedRoomID.setText(String.valueOf(r.id));
                SelectedRoomName.setText(r.name);
                MeetingRoom Mr = (MeetingRoom) r;
                ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                for (FormalVisitor v : Mr.visitors) {
                customers.add(v);
//
                }
                VisitorsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                VisitorsIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                VisitorsTable.setItems(customers);
                DisplayAvailableSlots();
            }
        }
        for(AbstractRoom r :GRooms)
        {
            if(Id.equals(String.valueOf(r.id))) {
                SelectedRoomID.setText(String.valueOf(r.id));
                SelectedRoomName.setText(r.name);
                SelectedRoom=r;
                GeneralRoom Mr = (GeneralRoom) r;
                ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                for (GeneralVisitor v : Mr.visitors) {
                    customers.add(v);
//
                }
                VisitorsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                VisitorsIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                VisitorsTable.setItems(customers);
                DisplayAvailableSlots();


            }
        }

                for(AbstractRoom r :TRooms)
                {
                    if(Id.equals(String.valueOf(r.id))) {
                        SelectedRoomID.setText(String.valueOf(r.id));
                        SelectedRoomName.setText(r.name);
                        TeachingRoom Mr = (TeachingRoom) r;
                        ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                        for (InstructorVisitor v : Mr.visitors) {
                            customers.add(v);
//
                        }
                        VisitorsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                        VisitorsIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                        VisitorsTable.setItems(customers);
                        DisplayAvailableSlots();
                    }
                }
//                DisplayAvailableSlots();
        }
        public void DisplayAvailableSlots()
        {

            ObservableList<Slot> slotsavail = FXCollections.observableArrayList();

            for(Slot s :SelectedRoom.getAvailableSlotsForAdmin())
            {
                slotsavail.add(s);
            }
            DateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().currentDate)));
            StartTimeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartTime()));
            EndTimeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndTime()));
            FeesColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().fees)));


            AvailableSlotsTable.setItems(slotsavail);
        }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoomTyprComboBox.getItems().addAll("General", "Meeting", "Teaching");
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
        AbstractRoom Groom = new GeneralRoom("G1", 2, Mslots, G_visitprs);
        GRooms.set(0, Groom);
        AbstractRoom Troom = new TeachingRoom("T1", 3, Mslots, I_visitprs);
        TRooms.set(0, Troom);
        AbstractRoom Mroom = new MeetingRoom("M1", 1, Mslots, F_visitprs);
        MRooms.set(0, Mroom);

        SelectedRoomID.setText("");
        SelectedRoomName.setText("");


        RoomTyprComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateRoomsIdComboBox(newValue);
        });
        RoomsIdComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            DisplayRoomVistor(newValue);
        });

    }

}

