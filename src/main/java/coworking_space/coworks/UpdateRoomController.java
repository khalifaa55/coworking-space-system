package coworking_space.coworks;

import coworking_space.coworks.Rooms.*;
import coworking_space.coworks.Visitors.AbstractVisitor;
import coworking_space.coworks.Visitors.FormalVisitor;
import coworking_space.coworks.Visitors.GeneralVisitor;
import coworking_space.coworks.Visitors.InstructorVisitor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import static coworking_space.coworks.Coworks_Main.generalRooms;
import static coworking_space.coworks.Coworks_Main.meetingRooms;
import static coworking_space.coworks.Coworks_Main.teachingRooms;



import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    ObservableList<Slot> available=FXCollections.observableArrayList();


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
        int Index = AvailableSlotsTable.getSelectionModel().getSelectedIndex();
        SelectedRoom.availableSlots.get(Index).setSlotDate(DatePick.getValue());
        SelectedRoom.availableSlots.get(Index).setFees(Double.parseDouble(FeesText.getText()));
        SelectedRoom.availableSlots.get(Index).setEndTime(EbdTineText.getText());
        SelectedRoom.availableSlots.get(Index).setStartTime(StartTimetEXT.getText());
        currentSlots.get(Index).setStartTime(StartTimetEXT.getText());
        currentSlots.get(Index).setEndTime(EbdTineText.getText());
        currentSlots.get(Index).setFees(Double.parseDouble(FeesText.getText()));
        currentSlots.get(Index).setSlotDate(DatePick.getValue());
        AvailableSlotsTable.setItems(currentSlots);
        AvailableSlotsTable.refresh();

    }

    String Types;
    int ID;
    public void checkID(ActionEvent actionEvent) {
    }

    @FXML
    void RowClicked(MouseEvent event) {

        Slot ClickedSlot = AvailableSlotsTable.getSelectionModel().getSelectedItem();
//        int Index= AvailableSlotsTable.getSelectionModel().getSelectedIndex();
        DatePick.setValue(ClickedSlot.getSlotDate());
        StartTimetEXT.setText(ClickedSlot.getStartTime());
        EbdTineText.setText(ClickedSlot.getEndTime());
        FeesText.setText(String.valueOf(ClickedSlot.getFees()));
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
    LocalDate L ;
    LocalDate Current =LocalDate.now();


    public void checkDate(javafx.event.ActionEvent actionEvent) {
        L =DatePick.getValue();
        if (L.isBefore(Current)) {
            inValidMessage("ERROR!", "invalid date");
        }
    }
    @FXML
    void AddSlot(MouseEvent event) {
        ObservableList<Slot> currentSlots = AvailableSlotsTable.getItems();
        Slot slot = new Slot(StartTimetEXT.getText(),EbdTineText.getText(),Double.parseDouble(FeesText.getText()),L);
        currentSlots.add(slot);

        AvailableSlotsTable.setItems(currentSlots);
        AvailableSlotsTable.refresh();
    }


    @FXML
    void udateRoomData(MouseEvent event) {

        try {
            if (Types.equals(String.valueOf(GeneralRadio))) {
                for (AbstractRoom R : generalRooms) {
                    if (SelectedRoom.getId() == Integer.parseInt(RoomIdText.getText()) || SelectedRoom.name.equals(RoomNameText.getText())) {
                        R.name = RoomNameText.getText();
                        break;
                    }
                }
            } else if (Types.equals(String.valueOf(TeachingRadio))) {
                for (AbstractRoom R : teachingRooms) {
                    TeachingRoom Tr = (TeachingRoom) R;
                    if (SelectedRoom.getId() == Integer.parseInt(RoomIdText.getText())) {
                        Tr.name = RoomNameText.getText();
                        Tr.projecttype = ProjectorText.getText();
                        Tr.boardtype = BoardText.getText();
                        Tr.instructorname = InsrtructorText.getText();
                        break;
                    }
                }
            } else {
                for (AbstractRoom R : meetingRooms) {
                    if (SelectedRoom.getId() == Integer.parseInt(RoomIdText.getText())) {
                        R.name = RoomNameText.getText();
                        break;
                    }

                }
            }
            for (AbstractRoom e : teachingRooms) {
                TeachingRoom tr = (TeachingRoom) e;
                System.out.println(tr.boardtype);
                System.out.println(tr.instructorname);
            }
        }catch (NullPointerException ex)
        {
            inValidMessage("ERROR!!","No Selected Room To Update");
        }
    }
    @FXML
    void DisplayRoom(MouseEvent event) {

        SelectedRoom=null;
        ID = Integer.parseInt(RoomIdText.getText());
        Types = String.valueOf(types.getSelectedToggle());
        try {

            DisplayRoomVistor(ID);
            FillData(SelectedRoom);
            SelectedRoom(SelectedRoom);

        }catch (NullPointerException ex)
        {
            RoomNameText.setText("");
            RoomIdText.setText("");
            available.clear();
            inValidMessage("EROOR!!", "No Room ID " + ID + " With This Type\n Enter Another ID .");

        }
    }


    public void DisplayRoomVistor(int ID) {


        if (Types.equals(String.valueOf(GeneralRadio))) {
            SelectedRoom= null;
            for (AbstractRoom Gr : generalRooms) {
                if (ID== Gr.getId()) {
                    SelectedRoom = Gr;

                }
            }
        }
        else if(Types.equals(String.valueOf(TeachingRadio)))
        {
            SelectedRoom= null;
            for (AbstractRoom Tr : teachingRooms) {
                if (ID== Tr.getId()) {
                    SelectedRoom = Tr;

                }
            }

        }
        else {
            SelectedRoom= null;
            for (AbstractRoom Mr : meetingRooms) {
                if (ID ==Mr.getId()) {
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

//        SelectedRoomID.setText(String.valueOf(Room.getId()));
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


    public void SelectedRoom(AbstractRoom Room)
    {
        available.clear();
        for(Slot S:Room.getAvailableSlotsForAdmin()){
            System.out.println(S.getStartTime());
            System.out.println(S.getEndTime());
            available.add(S);
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