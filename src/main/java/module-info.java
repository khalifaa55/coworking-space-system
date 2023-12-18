module coworking_space.coworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.desktop;


    opens coworking_space.coworks to javafx.fxml, module.com.fasterxml.jackson.databind;
    exports coworking_space.coworks;
}