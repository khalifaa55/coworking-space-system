package coworking_space.coworks;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;


import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateRoomController implements Initializable {

    @FXML
    private Button AddSlotButton;

    @FXML
    private TableView<Slot> AvailableSlotsTable;
    @FXML
    private TableColumn<Slot, String> DateA;
    @FXML
    private TableColumn<Slot, String> EndA;

    @FXML
    private TableColumn<Slot, String> FeesA;
    @FXML
    private TableColumn<Slot, String> StartA;
    @FXML
    private TableColumn<Slot, String> No_;


    @FXML
    private TextField EbdTineText;

    @FXML
    private Button EditSlotButton;

    @FXML
    private Button EditVisitorButton;

    @FXML
    private TextField FeesText;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button RoomDataButton;

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
    private TextField SelectedVisitorId;

    @FXML
    private TextField SlotDate;

    @FXML
    private TextField SlotNumberSelected;

    @FXML
    private TextField StartTimetEXT;

    @FXML
    private Button UpdateRoom;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsName;

    @FXML
    private TableView<AbstractVisitor> VisitorsTable;

    @FXML
    private TableColumn<AbstractVisitor,String > VistorsId;


    @FXML
    private ImageView updateRoomImage;

    @FXML
    private AnchorPane updateRoomScreen;
    Admin alshimaa = new Admin();

    AbstractRoom SelectedRoom ;
    Slot SelectedSlot ;

    public ArrayList<Slot> Mslots = new ArrayList<>();
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
    void EditVisitor(MouseEvent event) {

    }
    @FXML
    void changeScreenDisplayRoomsDataScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)displayRoomDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToAvailableSlotsScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)availableSlotsScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void changeScreenToVisitorsDataScreen(MouseEvent event) throws IOException
    {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("(admin)visitorsDataScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void LogOut(MouseEvent event) throws IOException {
        // Load the loginScreen.fxml file
        Parent root = FXMLLoader.load(getClass().getResource("welcomeScreen.fxml"));

        // Create a new scene with the loaded FXML content
        Scene scene = new Scene(root);

        // Get the Stage from the MouseEvent's source
        Stage stage = (Stage) updateRoomScreen.getScene().getWindow();

        // Set the new scene on the stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void UpdateSlot(MouseEvent event) {
        DisplayAvailableSlots();
    }
    @FXML
    void AddSlot(MouseEvent event) {
        DisplayAvailableSlots();
    }

    void TakeData()
    {
       String S= SlotNumberSelected.getText();
        int slotNumber = Integer.parseInt(S);
        String StartTime= StartTimetEXT.getText();
        String EndTime= EbdTineText.getText();
        String Date= SlotDate.getText();
        String Fees= FeesText.getText();
        double fees = Double.parseDouble(Fees);
//        SelectedRoom.getAvailableSlotsForAdmin().get(slotNumber-1).setFees(fees);
//        SelectedRoom.getAvailableSlotsForAdmin().get(slotNumber-1).setStartTime(StartTime);
//        SelectedRoom.getAvailableSlotsForAdmin().get(slotNumber-1).setEndTime(EndTime);
        Slot s=new Slot(StartTime,EndTime,fees);
        SelectedRoom.slots.add(s);
//        if(slotNumber =2);



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
//        f
//        }indRoomById(selectedId);
    }
        public void DisplayRoomVistor (String Id){

            for (AbstractRoom r : MRooms) {
                if (Id.equals(String.valueOf(r.id))) {
                    SelectedRoomID.setText(String.valueOf(r.id));
                    SelectedRoomName.setText(r.name);
                    SelectedRoom = r;
                    MeetingRoom Mr = (MeetingRoom) r;
                    ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                    for (FormalVisitor v : Mr.visitors) {
                        customers.add(v);
//
                    }
                    VisitorsName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                    VistorsId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                    VisitorsTable.setItems(customers);
                    DisplayAvailableSlots();


                }
            }
            for (AbstractRoom r : GRooms) {
                if (Id.equals(String.valueOf(r.id))) {
                    SelectedRoomID.setText(String.valueOf(r.id));
                    SelectedRoomName.setText(r.name);
                    SelectedRoom = r;
                    GeneralRoom Gr = (GeneralRoom) r;
                    ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                    for (GeneralVisitor v : Gr.visitors) {
                        customers.add(v);
//
                    }
                    VisitorsName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                    VistorsId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                    VisitorsTable.setItems(customers);
                    DisplayAvailableSlots();


                }
            }

            for (AbstractRoom r : TRooms) {
                if (Id.equals(String.valueOf(r.id))) {
                    SelectedRoomID.setText(String.valueOf(r.id));
                    SelectedRoomName.setText(r.name);
                    SelectedRoom = r;
                    TeachingRoom Tr = (TeachingRoom) r;
                    ObservableList<AbstractVisitor> customers = FXCollections.observableArrayList();

                    for (InstructorVisitor v : Tr.visitors) {
                        customers.add(v);
//
                    }
                    VisitorsName.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().name)));
                    VistorsId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

                    VisitorsTable.setItems(customers);
                    DisplayAvailableSlots();


                }
            }

//
        }
        public void DisplayAvailableSlots () {
            AvailableSlotsTable.getItems().clear();

            ObservableList<Slot> slotsavail = FXCollections.observableArrayList();

            for (Slot s : SelectedRoom.getAvailableSlotsForAdmin()) {
                System.out.println(s.getFees());
                slotsavail.add(s);
            }
            // Set a custom row factory to manage the auto-incremented column
            AvailableSlotsTable.setRowFactory(tableView -> {
                TableRow<Slot> row = new TableRow<>();

                // No_ column cell value factory
                No_.setCellValueFactory(cellData -> {
                    if (row.isEmpty()) {
                        return new SimpleStringProperty("");
                    } else {
                        // Bind the cell value to the index of the row + 1
                        return new SimpleStringProperty(String.valueOf(row.getIndex() + 1));
                    }
                });

                return row;
            });

            // Set a custom row factory to manage the auto-incremented column
//            AvailableSlotsTable.setRowFactory(tableView -> {
//                TableRow<Slot> row = new TableRow<>();
//
//                // Bind the cell value to the index of the row + 1
//                No_.setCellValueFactory(cellData -> new SimpleStringProperty(row.getIndex() + 1 + ""));
//
//                return row;
//            });

            DateA.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().currentDate)));
            StartA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStartTime()));
            EndA.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEndTime()));
            FeesA.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().fees)));

            AvailableSlotsTable.setItems(slotsavail);
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        RoomTyprComboBox.getItems().addAll("General", "Meeting", "Teaching");

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
