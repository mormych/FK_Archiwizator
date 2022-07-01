module com.fk.fk_archiwizator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires org.jsoup;


    opens com.fk.fk_archiwizator to javafx.fxml;
    exports com.fk.fk_archiwizator;
    exports com.fk.fk_archiwizator.controllers;
    opens com.fk.fk_archiwizator.controllers to javafx.fxml;
    exports com.fk.fk_archiwizator.mail;
    opens com.fk.fk_archiwizator.mail to javafx.fxml;
}