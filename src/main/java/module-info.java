module coworking_space.coworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;


    opens coworking_space.coworks to javafx.fxml;
    exports coworking_space.coworks;
}