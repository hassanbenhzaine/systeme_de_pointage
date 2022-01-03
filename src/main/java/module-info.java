module com.youcode.systemepointage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;

    opens com.youcode.systemepointage to javafx.fxml;
    exports com.youcode.systemepointage;
}