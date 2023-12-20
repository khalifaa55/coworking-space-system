package coworking_space.coworks;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.collections.ObservableList;


import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import static com.sun.beans.introspect.ClassInfo.clear;
import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;


public class DisplayRoomDataController implements Initializable {


    @FXML
    private TableView<Slot> AvailableSlotsTable;

    @FXML
    private Label BoardType;

    @FXML
    private TableColumn<Slot, LocalDate> DateColumn;

    @FXML
    private TableColumn<Slot, LocalDate> DateR;

    @FXML
    private TableColumn<Slot, String> EndTimeColumn;

    @FXML
    private TableColumn<Slot, String> EndTimeR;

    @FXML
    private TableColumn<Slot, Double> FeesColumn;

    @FXML
    private TableColumn<Slot, Double> FeesR;

    @FXML
    private Label InstructorName;

    @FXML
    private Pane InstructorPane;

    @FXML
    private Button LogOutButton;

    @FXML
    private Label MaxNoVisitors;

    @FXML
    private Label NoVisitorsRoom;

    @FXML
    private Label ProjectorType;

    @FXML
    private TableView<Slot> ReservedSlotsTable;

    @FXML
    private Label RoomProfit;

    @FXML
    private TextField RoomID;
    @FXML
    private RadioButton TeachingRadio;

    @FXML
    private ToggleGroup types;

    @FXML
    private RadioButton GeneralRadio;
    @FXML
    private RadioButton MeetingRadio;


    @FXML
    private Button RoomsAvailableSlots;


    @FXML
    private Label SelectedRoomName;

    @FXML
    private TableColumn<Slot, String> StartTimeColumn;

    @FXML
    private TableColumn<Slot, String> StartTimeR;

    @FXML
    private Button UpdateRoom;

    @FXML
    private Button VisitorsData;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsIdColumn;

    @FXML
    private TableColumn<AbstractVisitor, String> VisitorsNameColumn;

    @FXML
    private TableView<AbstractVisitor> VisitorsTable;

    @FXML
    private ImageView displayRoomDataImage;

    @FXML
    private AnchorPane displayRoomDataScreen;
    AbstractRoom SelectedRoom= null;

    Admin alshimaa = new Admin();

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
    ObservableList<Slot> Reserved = FXCollections.observableArrayList();


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
    String Type;
    int Id;
    @FXML

    void DisplayRoom(MouseEvent event) {

       Type =String.valueOf(types.getSelectedToggle());
       Id=Integer.parseInt(RoomID.getText());
//       updateRoomsIdComboBox(Type)
//       ;
       DisplayRoomVistor(Id);
        FillData(SelectedRoom);
        SelectedRoom(Type,Id);
        DispalyReservedSlots(Type,Id);
    }

    @FXML
    public void DeleteRoom(MouseEvent event) {
//        int INDEX = 0;
//
//        if (Type.equals(String.valueOf(GeneralRadio))) {
//            for (Iterator<AbstractRoom> iterator = GRooms.iterator(); iterator.hasNext(); ) {
//                AbstractRoom G = iterator.next();
//                if (G.id == Id) {
//                    iterator.remove();
//                    break;  // Exit the loop once the room is removed
//                }
//                INDEX++;
//            }
//        } else if (Type.equals(String.valueOf(TeachingRadio))) {
//            for (Iterator<AbstractRoom> iterator = TRooms.iterator(); iterator.hasNext(); ) {
//                AbstractRoom T = iterator.next();
//                if (T.id == Id) {
//                    iterator.remove();
//                    break;  // Exit the loop once the room is removed
//                }
//                INDEX++;
//            }
//        } else {
//            for (Iterator<AbstractRoom> iterator = MRooms.iterator(); iterator.hasNext(); ) {
//                AbstractRoom M = iterator.next();
//                if (M.id == Id) {
//                    iterator.remove();
//                    break;  // Exit the loop once the room is removed
//                }
//                INDEX++;
//            }
//        }
    }


    public void DisplayRoomVistor(int ID) {


        if (Type.equals(String.valueOf(GeneralRadio))) {
            SelectedRoom= null;
            for (AbstractRoom Gr : generalRooms) {
                if (ID== Gr.id) {
                    SelectedRoom = Gr;
                }
            }
        }
       else if(Type.equals(String.valueOf(TeachingRadio)))
        {
            SelectedRoom= null;
            for (AbstractRoom Tr : teachingRooms) {
                if (ID== Tr.id) {
                    SelectedRoom = Tr;
                }
            }

        }
        else {
            SelectedRoom= null;
            for (AbstractRoom Mr : meetingRooms) {
                if (ID ==Mr.id) {
                    SelectedRoom = Mr;
                }
            }
        }
        for(AbstractRoom G:generalRooms)
            if(G.name==null)
                    break;
    }
public  void FillData(AbstractRoom Room)
    {
        Visitors.clear();
        RoomProfit.setText("");

//        SelectedRoomID.setText(String.valueOf(Room.id));
        SelectedRoomName.setText(Room.name);
        NoVisitorsRoom.setText(String.valueOf( Room.getNumOfVisitors()));
        if(Room instanceof GeneralRoom)
        {

            InstructorPane.setVisible(false);

            GeneralRoom room=(GeneralRoom) Room;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));

            for (GeneralVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else if(Room instanceof TeachingRoom)
        {
            InstructorPane.setVisible(true);

            TeachingRoom room =(TeachingRoom) Room;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            ProjectorType.setText(room.projecttype);
            BoardType.setText(room.boardtype);
            InstructorName.setText(room.instructorname);

            for (InstructorVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else {
            InstructorPane.setVisible(false);

            MeetingRoom room=(MeetingRoom)Room;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            for (FormalVisitor V : room.visitors) {
                Visitors.add(V);
            }


        }
        VisitorsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        VisitorsIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

        VisitorsTable.setItems(Visitors);
    }


    public void SelectedRoom(String Type , int Id)
    {
        ObservableList<Slot> available=FXCollections.observableArrayList();

        if(Type.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(Id==R.id) {
                    for (Slot S : R.getAvailableSlotsForAdmin()) {
                        System.out.println(S.getStartTime());
                        available.add(S);
                    }
                }

            }
        } else if (Type.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(Id== R.id)
                {
                    for(Slot S:R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }

        }
        else {
            for(AbstractRoom R:meetingRooms)
            {
                if(Id == R.id)
                {
                    for(Slot S :R.getAvailableSlotsForAdmin())
                        available.add(S);
                }
            }
        }
        DateColumn.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("slotDate"));
        StartTimeColumn.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndTimeColumn.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        FeesColumn.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        AvailableSlotsTable.setItems(available);

    }

    public void DispalyReservedSlots(String Type , int Id) {

        ObservableList<Slot> Reserved=FXCollections.observableArrayList();

        if(Type.equals(String.valueOf(GeneralRadio)))
        {
            for(AbstractRoom R:generalRooms)
            {
                if(Id==R.id) {
                    for (Slot S : R.reservedSlots) {
                        System.out.println(S.getStartTime());
                        Reserved.add(S);
                    }
                    RoomProfit.setText(String.valueOf(alshimaa.CalcRoom_Profit(R)));

                }

            }
        } else if (Type.equals(String.valueOf(TeachingRadio))) {
            for(AbstractRoom R :teachingRooms)
            {
                if(Id== R.id)
                {
                    for(Slot S: R.reservedSlots)
                        Reserved.add(S);
                    RoomProfit.setText(String.valueOf(alshimaa.CalcRoom_Profit(R)));

                }
            }

        }
        else {
            for(AbstractRoom R:meetingRooms)
            {
                if(Id == R.id)
                {
                    for(Slot S :R.reservedSlots)
                        Reserved.add(S);
                    RoomProfit.setText(String.valueOf(alshimaa.CalcRoom_Profit(R)));

                }
            }
        }
        DateR.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("slotDate"));
        StartTimeR.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndTimeR.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        FeesR.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        ReservedSlotsTable.setItems(Reserved);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        InstructorPane.setVisible(false);
        RoomProfit.setText("");
//        Slot S_0 = new Slot("9" , "11",150 , LocalDate.of(2023,3 ,5));
////        Mslots.add(S_0);
//        Mslots.add(slot1);
//        Mslots.add(slot2);
//
//        I_visitprs.add(Ivisitor_2);
//        I_visitprs.add(Ivisitor_3);
//        F_visitprs.add(Fvisitor_2);
//        F_visitprs.add(Fvisitor_3);
//        G_visitprs.add(Gvisitor_2);
//        G_visitprs.add(Gvisitor_3);
//        GRooms.add(null);  // Or any initial value you want
//        TRooms.add(null);
//        MRooms.add(null);
//
//        Mslots.get(0).createReservation(Gvisitor_2);
//        Mslots.get(0).createReservation(Gvisitor_3);
//       RoomProfit.setText("");
//       Mslots_1.add(slot3);
//       Mslots_1.add(slot4);
//       Mslots_2.add(slot5);
//       Mslots_2.add(slot6);
//
//        AbstractRoom Groom = new GeneralRoom("G1", 2, Mslots, G_visitprs);
//        GRooms.set(0, Groom);
//
//        AbstractRoom Troom = new TeachingRoom("T1", 3, Mslots_1, I_visitprs);
//        TRooms.set(0, Troom);
//        AbstractRoom Mroom = new MeetingRoom("M1", 1, Mslots_2, F_visitprs);
//        MRooms.set(0, Mroom);
        for(AbstractRoom G :generalRooms)
        {
            System.out.println(G.name);
        }
//        RoomTyprComboBox.getItems().addAll("General", "Meeting", "Teaching");
//
//        SelectedRoomID.setText("");
//        SelectedRoomName.setText("");

//        ApplyManyTIMES();
//        RoomTyprComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            updateRoomsIdComboBox(newValue);
//        });

    }
}

