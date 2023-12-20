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
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;



import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdateRoomController implements Initializable {


    @FXML
    private TextField RoomIdText;
    @FXML
    private RadioButton TeachingRadio;

    @FXML
    private ToggleGroup types;
    @FXML
    private RadioButton MeetingRadio;

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
    private TextField InsrtructorText;


    @FXML
    private TableColumn<Slot, String> EndA;

    @FXML
    private TableColumn<Slot, Double> FeesA;

    @FXML
    private TextField FeesText;

    @FXML
    private Button RoomDataButton;


    @FXML
    private Button RoomsAvailableSlots;


    @FXML
    private TextField RoomNameText;

    @FXML
    private TextField SelectedVisitorId;

    @FXML
    private DatePicker DatePick;

    @FXML
    private TextField SlotNumberSelected;
    @FXML
    private RadioButton GeneralRadio;

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


    ObservableList<AbstractVisitor> Visitors = FXCollections.observableArrayList();


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
    String Types;
    int ID;


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


@FXML
void udateRoomData(MouseEvent event) {


    if(Types.equals(String.valueOf(GeneralRadio)))
    {
        for(AbstractRoom R:generalRooms)
        {
            if(SelectedRoom.id==Integer.parseInt(RoomIdText.getText()) || SelectedRoom.name.equals(RoomNameText.getText()))
            {
                R.id=Integer.parseInt(RoomIdText.getText());
                R.name=RoomNameText.getText();
                break;
            }
        }
    }
    else if(Types.equals(String.valueOf(TeachingRadio)))
    {
        for(AbstractRoom R:teachingRooms)
        {
            TeachingRoom Tr=(TeachingRoom) R;
            if(SelectedRoom.id==Integer.parseInt(RoomIdText.getText()) || SelectedRoom.name.equals(RoomNameText.getText()))
            {
                Tr.id=Integer.parseInt(RoomIdText.getText());
                Tr.name=RoomNameText.getText();
                Tr.projecttype=ProjectorText.getText();
                Tr.boardtype=BoardText.getText();
                Tr.instructorname=InsrtructorText.getText();
                break;
            }
        }
    }
    else {
        for(AbstractRoom R:meetingRooms)
        {
            if(SelectedRoom.id==Integer.parseInt(RoomIdText.getText()) || SelectedRoom.name.equals(RoomNameText.getText()))
            {
                R.id=Integer.parseInt(RoomIdText.getText());
                R.name=RoomNameText.getText();
                break;
            }

        }
    }
    for(AbstractRoom e:generalRooms)
    {
        System.out.println(e.name);
    }
}
    @FXML
    void DisplayRoom(MouseEvent event) {

        Types =String.valueOf(types.getSelectedToggle());
        ID=Integer.parseInt(RoomIdText.getText());
//       updateRoomsIdComboBox(Type)
//       ;
        DisplayRoomVistor(ID);
        FillData(SelectedRoom);
        SelectedRoom(Types,ID);
    }



    public void DisplayRoomVistor(int ID) {


        if (Types.equals(String.valueOf(GeneralRadio))) {
            SelectedRoom= null;
            for (AbstractRoom Gr : generalRooms) {
                if (ID== Gr.id) {
                    SelectedRoom = Gr;
                }
            }
        }
        else if(Types.equals(String.valueOf(TeachingRadio)))
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

//        SelectedRoomID.setText(String.valueOf(Room.id));
        RoomNameText.setText(Room.name);
//        NoVisitorsRoom.setText(String.valueOf( Room.getNumOfVisitors()));
        if(Room instanceof GeneralRoom)
        {

            InstructorPane.setVisible(false);

            GeneralRoom room=(GeneralRoom) Room;
//            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));

            for (GeneralVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else if(Room instanceof TeachingRoom)
        {
            InstructorPane.setVisible(true);

            TeachingRoom room =(TeachingRoom) Room;
//            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            ProjectorText.setText(room.projecttype);
            BoardText.setText(room.boardtype);
            InsrtructorText.setText(room.instructorname);

            for (InstructorVisitor V : room.visitors) {
                Visitors.add(V);
            }
        }
        else {
            InstructorPane.setVisible(false);

            MeetingRoom room=(MeetingRoom)Room;
//            MaxNoVisitors.setText(String.valueOf(room.maxNumberOfVisitors));
            for (FormalVisitor V : room.visitors) {
                Visitors.add(V);
            }


        }
        V_name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name));
        V_id.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().id)));

        V_Table.setItems(Visitors);
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
        DateA.setCellValueFactory(new PropertyValueFactory<Slot,LocalDate>("slotDate"));
        StartA.setCellValueFactory(new PropertyValueFactory<Slot,String>("startTime"));
        EndA.setCellValueFactory(new PropertyValueFactory<Slot,String>("endTime"));
        FeesA.setCellValueFactory(new PropertyValueFactory<Slot,Double>("fees"));
        AvailableSlotsTable.setItems(available);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         InstructorPane.setVisible(false);



    }
}
