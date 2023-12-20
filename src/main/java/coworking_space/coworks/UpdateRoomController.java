package coworking_space.coworks;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;


import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateRoomController implements Initializable {


    @FXML
    private TableView<Slot> AvailableSlotsTable;

    @FXML
    private TableColumn<Slot, LocalDate> DateA;

    @FXML
    private TextField EbdTineText;

    @FXML
    private Button EditSlotButton;


    @FXML
    private Pane InstructorPane;
    @FXML
    private TextField ProjectorText;
    @FXML
    private TextField BoardText;


    @FXML
    private TableColumn<Slot, String> EndA;

    @FXML
    private TableColumn<Slot, Double> FeesA;

    @FXML
    private TextField FeesText;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button LogOutButton1;

    @FXML
    private Button LogOutButton2;

    @FXML
    private Button RoomDataButton;

    @FXML
    private ChoiceBox<String> RoomTyprComboBox;

    @FXML
    private Button RoomsAvailableSlots;

    @FXML
    private ChoiceBox<String> RoomsIdComboBox;

    @FXML
    private TextField RoomIdText;

    @FXML
    private TextField RoomNameText;

    @FXML
    private TextField SelectedVisitorId;

    @FXML
    private DatePicker DatePick;

    @FXML
    private TextField SlotNumberSelected;

    @FXML
    private TableColumn<Slot,String > StartA;

    @FXML
    private TextField StartTimetEXT;

    @FXML
    private TableView<AbstractVisitor> V_Table;

    @FXML
    private TableColumn<AbstractVisitor, String> V_id;
    @FXML
    private TableColumn<AbstractVisitor, String> V_name;

    @FXML
    private Button VisitorsData;

    @FXML
    private ImageView updateRoomImage;

    @FXML
    private AnchorPane updateRoomScreen;
AbstractRoom SelectedRoom;
    Admin alshimaa = new Admin();

    String RoomType;
    public  ArrayList<Slot> Mslots = new ArrayList<>();
    public  ArrayList<Slot> Mslots_1 = new ArrayList<>();
    public  ArrayList<Slot> Mslots_2 = new ArrayList<>();

    public  ArrayList<InstructorVisitor> I_visitprs = new ArrayList<>();
    public  ArrayList<GeneralVisitor> G_visitprs = new ArrayList<>();
    public  ArrayList<FormalVisitor> F_visitprs = new ArrayList<>();

    Slot slot1 = new Slot("8", "10", 100.00, LocalDate.of(2023 , 3 , 7));
    Slot slot2 = new Slot("10", "12", 300,LocalDate.of(2023 , 12 , 7));
    Slot slot3 = new Slot("8", "10", 100.00, LocalDate.of(2023 , 3 , 7));
    Slot slot4= new Slot("10", "12", 300,LocalDate.of(2023 , 12 , 7));
    Slot slot5 = new Slot("8", "10", 100.00, LocalDate.of(2023 , 3 , 7));
    Slot slot6 = new Slot("10", "12", 300,LocalDate.of(2023 , 12 , 7));
    InstructorVisitor Ivisitor_2=new InstructorVisitor("Fagor",3);
    InstructorVisitor Ivisitor_3=new InstructorVisitor("Fago",4);

    FormalVisitor Fvisitor_3=new FormalVisitor("Fago",4);
    FormalVisitor Fvisitor_2=new FormalVisitor("Fagor",3);
    GeneralVisitor Gvisitor_3=new GeneralVisitor("Fago",4);
    GeneralVisitor Gvisitor_2=new GeneralVisitor("Fagor",3);

    ArrayList<AbstractRoom> GRooms = new ArrayList<>(3);
    ArrayList<AbstractRoom> TRooms = new ArrayList<>(2);
    ArrayList<AbstractRoom> MRooms = new ArrayList<>(2);

    ObservableList<AbstractVisitor> Visitors = FXCollections.observableArrayList();
    ObservableList<Slot> AvailableSlots = FXCollections.observableArrayList();




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
        ObservableList<Slot> currentSlots = AvailableSlotsTable.getItems();
//        String STime = StartA.getText();

        for (Slot slot : currentSlots) {
//            if (STime.equals(slot.getStartTime())) {
            slot.setStartTime(StartTimetEXT.getText());
            slot.setEndTime(EbdTineText.getText());
            slot.setFees(Double.parseDouble(FeesText.getText()));
            slot.setSlotDate(DatePick.getValue());
            AvailableSlotsTable.setItems(currentSlots);
            AvailableSlotsTable.refresh();
                  break;
//            }
        }

    }
    @FXML
    void udateRoomData(MouseEvent event) {
        SelectedRoom.id=Integer.parseInt(RoomIdText.getText());
        SelectedRoom.name=RoomNameText.getText();
        if(SelectedRoom instanceof TeachingRoom)
        {
            TeachingRoom Tr= (TeachingRoom) SelectedRoom;
            Tr.boardtype=BoardText.getText();
            Tr.projecttype=ProjectorText.getText();
        }
    }

    @FXML
    void RowClicked(MouseEvent event) {

        Slot ClickedSlot = AvailableSlotsTable.getSelectionModel().getSelectedItem();
//        int Index= AvailableSlotsTable.getSelectionModel().getSelectedIndex();
         DatePick.setValue(ClickedSlot.slotDate);
        StartTimetEXT.setText(ClickedSlot.getStartTime());
        EbdTineText.setText(ClickedSlot.getEndTime());
        FeesText.setText(String.valueOf(ClickedSlot.getFees()));
    }

    @FXML
    void AddSlot(MouseEvent event) {
        ObservableList<Slot> currentSlots = AvailableSlotsTable.getItems();

        Slot slot = new Slot(StartTimetEXT.getText(),EbdTineText.getText(),Double.parseDouble(FeesText.getText()),DatePick.getValue());
        currentSlots.add(slot);

        AvailableSlotsTable.setItems(currentSlots);
        AvailableSlotsTable.refresh();
    }




    public void updateRoomsIdComboBox(String roomType) {
        RoomsIdComboBox.getItems().clear();

        if ("General".equals(roomType)) {
            for (AbstractRoom room : GRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().add(myString);
                    RoomType="General";
                }
            }
        } else if ("Teaching".equals(roomType)) {
            for (AbstractRoom room : TRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().add(myString);
                    RoomType="Teaching";

                }
            }
        } else if ("Meeting".equals(roomType)) {
            for (AbstractRoom room : MRooms) {
                if (room != null) {
                    String myString = String.valueOf(room.id);
                    RoomsIdComboBox.getItems().add(myString);
                    RoomType="Meeting";
                }
            }

        }
    }

    public void DisplayRoomVistor(String Id) {


        if (RoomType.equals("General")) {
            for (AbstractRoom Gr : GRooms) {
                if (Id.equals(String.valueOf(Gr.id))) {
                    SelectedRoom = Gr;
                }
            }
        }
        else if(RoomType.equals("Teaching"))
        {
            for (AbstractRoom Tr : TRooms) {
                if (Id.equals(String.valueOf(Tr.id))) {
                    SelectedRoom = Tr;
                }
            }

        }
        else {
            for (AbstractRoom Mr : MRooms) {
                if (Id.equals(String.valueOf(Mr.id))) {
                    SelectedRoom = Mr;
                }
            }
        }
        FillData(SelectedRoom);
        DisplayAvailableSlots(SelectedRoom);
    }
    public  void FillData(AbstractRoom Room)
    {
        Visitors.clear();

        RoomIdText.setText(String.valueOf(Room.id));
        RoomNameText.setText(Room.name);
        if(Room instanceof GeneralRoom)
        {
        InstructorPane.setVisible(false);

            GeneralRoom room=(GeneralRoom) Room;

            for (GeneralVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else if(Room instanceof TeachingRoom)
        {
            InstructorPane.setVisible(true);
            TeachingRoom room =(TeachingRoom) Room;
            ProjectorText.setText(room.projecttype);
            BoardText.setText(room.boardtype);
            for (InstructorVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else {
            InstructorPane.setVisible(false);

            MeetingRoom room=(MeetingRoom)Room;
            for (FormalVisitor V : room.visitors) {
                Visitors.add(V);
            }


        }
        V_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        V_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

        V_Table.setItems(Visitors);
    }


    public void DisplayAvailableSlots(AbstractRoom SelectedRoom) {
        AvailableSlots.clear();

        for (Slot s : SelectedRoom.getAvailableSlotsForAdmin()) {
            System.out.println(s.getFees());
            AvailableSlots.add(s);
        }

        DateA.setCellValueFactory(new PropertyValueFactory<Slot, LocalDate>("slotDate"));
        StartA.setCellValueFactory(new PropertyValueFactory<Slot, String>("startTime"));
        EndA.setCellValueFactory(new PropertyValueFactory<Slot, String>("endTime"));
        FeesA.setCellValueFactory(new PropertyValueFactory<Slot, Double>("fees"));


        AvailableSlotsTable.setItems(AvailableSlots);

    }
    public void ApplyManyTIMES()
    {
        RoomTyprComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateRoomsIdComboBox(newValue);
        });
        RoomsIdComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            DisplayRoomVistor(newValue);
        });

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         InstructorPane.setVisible(false);
        Slot S_0 = new Slot("9" , "11",150 , LocalDate.of(2023,3 ,5));
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

       // Mslots.get(0).createReservation(Gvisitor_2);
        //Mslots.get(0).createReservation(Gvisitor_3);
        Mslots_1.add(slot3);
        Mslots_1.add(slot4);
        Mslots_2.add(slot5);
        Mslots_2.add(slot6);

        AbstractRoom Groom = new GeneralRoom("G1", 2, Mslots, G_visitprs);
        GRooms.set(0, Groom);
        AbstractRoom Troom = new TeachingRoom("T1", 3, Mslots_1, I_visitprs);
        TRooms.set(0, Troom);
        AbstractRoom Mroom = new MeetingRoom("M1", 1, Mslots_2, F_visitprs);
        MRooms.set(0, Mroom);
        RoomTyprComboBox.getItems().addAll("General", "Meeting", "Teaching");

        RoomIdText.setText("");
        RoomNameText.setText("");

        ApplyManyTIMES();

    }
}
