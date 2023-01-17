module com.katamari.javafxcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.katamari.javafxcalculator to javafx.fxml;
    exports com.katamari.javafxcalculator;
}