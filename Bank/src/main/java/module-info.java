module bank.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens bank.bank to javafx.fxml;
    exports bank.bank;
}