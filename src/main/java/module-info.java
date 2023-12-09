module coworking_space.coworks {
    requires javafx.controls;
    requires javafx.fxml;


    opens coworking_space.coworks to javafx.fxml;
    exports coworking_space.coworks;
}