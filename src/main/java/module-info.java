module com.youcode.systemepointage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires otj.pg.embedded;
    requires org.flywaydb.core;

    opens com.youcode.systemepointage to javafx.fxml;
    exports com.youcode.systemepointage;
    exports com.youcode.systemepointage.controller;
    opens com.youcode.systemepointage.controller to javafx.fxml;
}