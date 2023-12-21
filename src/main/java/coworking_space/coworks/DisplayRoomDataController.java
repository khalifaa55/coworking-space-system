package coworking_space.coworks;


import coworking_space.coworks.Rooms.*;
import coworking_space.coworks.Visitors.AbstractVisitor;
import coworking_space.coworks.Visitors.FormalVisitor;
import coworking_space.coworks.Visitors.GeneralVisitor;
import coworking_space.coworks.Visitors.InstructorVisitor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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


import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static coworking_space.coworks.Coworks_Main.*;


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

    ObservableList<AbstractVisitor> Visitors = FXCollections.observableArrayList();
    ObservableList<Slot> available=FXCollections.observableArrayList();
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
    String Type;
    int Id;
    @FXML

    void DisplayRoom(MouseEvent event) {
        Id = Integer.parseInt(RoomID.getText());
        Type = String.valueOf(types.getSelectedToggle());
//        try {
            SelectRoom(Id);
            FillData();
            DisplayAvailableSlots();
            DispalyReservedSlots();

//        }catch (NullPointerException ex)
//        {
//            SelectedRoomName.setText("");
//            RoomID.setText("");
//            available.clear();
//            inValidMessage("EROOR!!", "No Room ID " + Id + " With This Type\n Enter Another ID .");
//        }
    }

    @FXML
    public void DeleteRoom(MouseEvent event) {
        Id = Integer.parseInt(RoomID.getText());
        Type = String.valueOf(types.getSelectedToggle());
        try{

            SelectRoom(Id);
            RemoveSelectedRoom();
        }catch (IndexOutOfBoundsException ex)
        {
            RoomID.setText("");
            available.clear();
            inValidMessage("EROOR!!", "No Room ID " + Id + " With This Type\n Enter Another ID .");
        }
    }

    int Index=0;

    public void RemoveSelectedRoom()
    {
        boolean Check=false;
        if(Type.equals(String.valueOf(GeneralRadio)))
        {

            generalRooms.remove(Index);
            Check=true;
        } else if (Type.equals(String.valueOf(TeachingRadio))) {
            teachingRooms.remove(Index);
            Check=true;
        }
        else {
            meetingRooms.remove(Index);
            Check=true;
        }

        if(Check) {
            Visitors.clear();
            available.clear();
            InstructorName.setText("");
            BoardType.setText("");
            ProjectorType.setText("");
            SelectedRoomName.setText("");
            RoomID.setText("");
            NoVisitorsRoom.setText("");
            MaxNoVisitors.setText("");
            inValidMessage("Alert ", "Room " + Id + " is Deleted");
        }
    }

    public void SelectRoom(int ID) {

        if (Type.equals(String.valueOf(GeneralRadio))) {
            Index=0;
            for (AbstractRoom Gr : generalRooms) {
                if (ID== Gr.id) {
                    SelectedRoom = Gr;
                    break;
                }
                Index++;
            }
        }
        else if(Type.equals(String.valueOf(TeachingRadio)))
        {
            Index=0;
            for (AbstractRoom Tr : teachingRooms) {
                if (ID== Tr.id) {
                    SelectedRoom = Tr;
                    break;
                }
                Index++;
            }

        }
        else {
            Index=0;
            for (AbstractRoom Mr : meetingRooms) {
                if (ID ==Mr.id) {
                    SelectedRoom = Mr;
                    break;
                }
                Index++;
            }
        }
    }
    public  void FillData()
    {
        Visitors.clear();
        RoomProfit.setText("");

        SelectedRoomName.setText(SelectedRoom.name);
        NoVisitorsRoom.setText(String.valueOf( SelectedRoom.getNumOfVisitors()));
        if(SelectedRoom instanceof GeneralRoom)
        {

            InstructorPane.setVisible(false);

            GeneralRoom room=(GeneralRoom) SelectedRoom;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));

            for (GeneralVisitor V : room.getVisitors()) {
                Visitors.add(V);
            }
        }
        else if(SelectedRoom instanceof TeachingRoom)
        {
            InstructorPane.setVisible(true);

            TeachingRoom room =(TeachingRoom) SelectedRoom;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            ProjectorType.setText(room.projecttype);
            BoardType.setText(room.boardtype);
            InstructorName.setText(room.instructorname);

            for (InstructorVisitor V : room.getVisitors()) {
                Visitors.add(V);
            }
        }
        else {
            InstructorPane.setVisible(false);

            MeetingRoom room=(MeetingRoom)SelectedRoom;
            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            for (FormalVisitor V : room.getVisitors()) {
                Visitors.add(V);
            }


        }
        VisitorsNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        VisitorsIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

        VisitorsTable.setItems(Visitors);
    }


    public void DisplayAvailableSlots()
    {
        available.clear();
        for(Slot S :SelectedRoom.getAvailableSlotsForAdmin())
            available.add(S);


        DateColumn.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("slotDate"));
        StartTimeColumn.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndTimeColumn.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        FeesColumn.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        AvailableSlotsTable.setItems(available);

    }

    public void DispalyReservedSlots() {

        Reserved.clear();
        for (Slot S : SelectedRoom.reservedSlots) {
            System.out.println(S.getStartTime());
            Reserved.add(S);
        }
        Admin alshimaa=new Admin();
        RoomProfit.setText(String.valueOf(alshimaa.CalcRoom_Profit(SelectedRoom)));

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
        for(AbstractRoom G :generalRooms)
        {
            System.out.println(G.id);
        }
    }
}