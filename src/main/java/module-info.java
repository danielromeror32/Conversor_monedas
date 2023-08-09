module com.monedasapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.monedasapp to javafx.fxml;
    exports com.monedasapp;
}