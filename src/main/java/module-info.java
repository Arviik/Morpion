module appli.morpion {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens appli.morpion to javafx.fxml;
    exports appli.morpion;
    exports appli.morpion.controller;
    opens appli.morpion.controller to javafx.fxml;
}